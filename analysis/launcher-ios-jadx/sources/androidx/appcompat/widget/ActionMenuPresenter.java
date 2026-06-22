package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import defpackage.et0;
import defpackage.f1;
import defpackage.gb;
import defpackage.gt0;
import defpackage.i1;
import defpackage.ik1;
import defpackage.k1;
import defpackage.m1;
import defpackage.mt0;
import defpackage.n61;
import defpackage.qg1;
import defpackage.r41;
import defpackage.tt0;
import defpackage.ut0;
import defpackage.xt0;
import defpackage.yt0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ActionMenuPresenter extends gb implements k1 {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    OverflowMenuButton mOverflowButton;
    OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback;
    OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public class ActionButtonSubmenu extends tt0 {
        public ActionButtonSubmenu(Context context, ik1 ik1Var, View view) {
            super(r41.actionOverflowMenuStyle, 0, ik1Var, context, view, false);
            if ((ik1Var.G.D & 32) != 32) {
                View view2 = ActionMenuPresenter.this.mOverflowButton;
                setAnchorView(view2 == null ? (View) ((gb) ActionMenuPresenter.this).mMenuView : view2);
            }
            setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        @Override // defpackage.tt0
        public void onDismiss() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.mActionButtonPopup = null;
            actionMenuPresenter.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    public class ActionMenuPopupCallback extends i1 {
        public ActionMenuPopupCallback() {
        }

        @Override // defpackage.i1
        public qg1 getPopup() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.mActionButtonPopup;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.getPopup();
            }
            return null;
        }
    }

    public class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        @Override // java.lang.Runnable
        public void run() {
            gt0 gt0Var;
            et0 et0Var;
            if (((gb) ActionMenuPresenter.this).mMenu != null && (et0Var = (gt0Var = ((gb) ActionMenuPresenter.this).mMenu).k) != null) {
                et0Var.onMenuModeChange(gt0Var);
            }
            View view = (View) ((gb) ActionMenuPresenter.this).mMenuView;
            if (view != null && view.getWindowToken() != null && this.mPopup.tryShow()) {
                ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }
            ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, null, r41.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.1
                @Override // androidx.appcompat.widget.ForwardingListener
                public qg1 getPopup() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.mOverflowPopup;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.getPopup();
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean onForwardingStarted() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public boolean onForwardingStopped() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.mPostedOpenRunnable != null) {
                        return false;
                    }
                    actionMenuPresenter.hideOverflowMenu();
                    return true;
                }
            });
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    public class OverflowPopup extends tt0 {
        public OverflowPopup(Context context, gt0 gt0Var, View view, boolean z) {
            super(r41.actionOverflowMenuStyle, 0, gt0Var, context, view, z);
            setGravity(8388613);
            setPresenterCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        @Override // defpackage.tt0
        public void onDismiss() {
            if (((gb) ActionMenuPresenter.this).mMenu != null) {
                ((gb) ActionMenuPresenter.this).mMenu.c(true);
            }
            ActionMenuPresenter.this.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    public class PopupPresenterCallback implements ut0 {
        public PopupPresenterCallback() {
        }

        @Override // defpackage.ut0
        public void onCloseMenu(gt0 gt0Var, boolean z) {
            if (gt0Var instanceof ik1) {
                ((ik1) gt0Var).F.k().c(false);
            }
            ut0 callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(gt0Var, z);
            }
        }

        @Override // defpackage.ut0
        public boolean onOpenSubMenu(gt0 gt0Var) {
            if (gt0Var == ((gb) ActionMenuPresenter.this).mMenu) {
                return false;
            }
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.mOpenSubMenuId = ((ik1) gt0Var).G.g;
            ut0 callback = actionMenuPresenter.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(gt0Var);
            }
            return false;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.ActionMenuPresenter.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int openSubMenuId;

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }

        public SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, n61.abc_action_menu_layout, n61.abc_action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof xt0) && ((xt0) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public void bindItemView(mt0 mt0Var, xt0 xt0Var) {
        xt0Var.a(mt0Var);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) xt0Var;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    @Override // defpackage.gb
    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.mOverflowButton) {
            return false;
        }
        viewGroup.removeViewAt(i);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x013d  */
    @Override // defpackage.vt0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean flagActionItems() {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuPresenter.flagActionItems():boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.gb
    public View getItemView(mt0 mt0Var, View view, ViewGroup viewGroup) {
        View actionView = mt0Var.getActionView();
        if (actionView == null || mt0Var.e()) {
            xt0 xt0VarCreateItemView = view instanceof xt0 ? (xt0) view : createItemView(viewGroup);
            bindItemView(mt0Var, xt0VarCreateItemView);
            actionView = (View) xt0VarCreateItemView;
        }
        actionView.setVisibility(mt0Var.I ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // defpackage.gb
    public yt0 getMenuView(ViewGroup viewGroup) {
        yt0 yt0Var = this.mMenuView;
        yt0 menuView = super.getMenuView(viewGroup);
        if (yt0Var != menuView) {
            ((ActionMenuView) menuView).setPresenter(this);
        }
        return menuView;
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.mPendingOverflowIconSet) {
            return this.mPendingOverflowIcon;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        Object obj;
        OpenOverflowRunnable openOverflowRunnable = this.mPostedOpenRunnable;
        if (openOverflowRunnable != null && (obj = this.mMenuView) != null) {
            ((View) obj).removeCallbacks(openOverflowRunnable);
            this.mPostedOpenRunnable = null;
            return true;
        }
        OverflowPopup overflowPopup = this.mOverflowPopup;
        if (overflowPopup == null) {
            return false;
        }
        overflowPopup.dismiss();
        return true;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu actionButtonSubmenu = this.mActionButtonPopup;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.dismiss();
        return true;
    }

    @Override // defpackage.gb, defpackage.vt0
    public void initForMenu(Context context, gt0 gt0Var) {
        super.initForMenu(context, gt0Var);
        Resources resources = context.getResources();
        f1 f1VarD = f1.d(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = true;
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = f1VarD.h.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = f1VarD.f();
        }
        int measuredWidth = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.mSystemContext);
                this.mOverflowButton = overflowMenuButton;
                if (this.mPendingOverflowIconSet) {
                    overflowMenuButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = measuredWidth;
        this.mMinCellSize = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup overflowPopup = this.mOverflowPopup;
        return overflowPopup != null && overflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // defpackage.gb, defpackage.vt0
    public void onCloseMenu(gt0 gt0Var, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(gt0Var, z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = f1.d(this.mContext).f();
        }
        gt0 gt0Var = this.mMenu;
        if (gt0Var != null) {
            gt0Var.p(true);
        }
    }

    @Override // defpackage.vt0
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).openSubMenuId) > 0 && (menuItemFindItem = this.mMenu.findItem(i)) != null) {
            onSubMenuSelected((ik1) menuItemFindItem.getSubMenu());
        }
    }

    @Override // defpackage.vt0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    @Override // defpackage.gb, defpackage.vt0
    public boolean onSubMenuSelected(ik1 ik1Var) {
        boolean z = false;
        if (!ik1Var.hasVisibleItems()) {
            return false;
        }
        ik1 ik1Var2 = ik1Var;
        while (true) {
            gt0 gt0Var = ik1Var2.F;
            if (gt0Var == this.mMenu) {
                break;
            }
            ik1Var2 = (ik1) gt0Var;
        }
        View viewFindViewForItem = findViewForItem(ik1Var2.G);
        if (viewFindViewForItem == null) {
            return false;
        }
        this.mOpenSubMenuId = ik1Var.G.g;
        int size = ik1Var.l.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = ik1Var.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.mContext, ik1Var, viewFindViewForItem);
        this.mActionButtonPopup = actionButtonSubmenu;
        actionButtonSubmenu.setForceShowIcon(z);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(ik1Var);
        return true;
    }

    @Override // defpackage.k1
    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
            return;
        }
        gt0 gt0Var = this.mMenu;
        if (gt0Var != null) {
            gt0Var.c(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mExpandedActionViewsExclusive = z;
    }

    public void setItemLimit(int i) {
        this.mMaxItems = i;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            this.mPendingOverflowIconSet = true;
            this.mPendingOverflowIcon = drawable;
        }
    }

    public void setReserveOverflow(boolean z) {
        this.mReserveOverflow = z;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.mWidthLimit = i;
        this.mStrictWidthLimit = z;
        this.mWidthLimitSet = true;
    }

    @Override // defpackage.gb
    public boolean shouldIncludeItem(int i, mt0 mt0Var) {
        return (mt0Var.D & 32) == 32;
    }

    public boolean showOverflowMenu() {
        gt0 gt0Var;
        if (this.mReserveOverflow && !isOverflowMenuShowing() && (gt0Var = this.mMenu) != null && this.mMenuView != null && this.mPostedOpenRunnable == null) {
            gt0Var.i();
            if (!gt0Var.p.isEmpty()) {
                OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
                this.mPostedOpenRunnable = openOverflowRunnable;
                ((View) this.mMenuView).post(openOverflowRunnable);
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.gb, defpackage.vt0
    public void updateMenuView(boolean z) {
        ArrayList arrayList;
        super.updateMenuView(z);
        ((View) this.mMenuView).requestLayout();
        gt0 gt0Var = this.mMenu;
        boolean z2 = false;
        if (gt0Var != null) {
            gt0Var.i();
            ArrayList arrayList2 = gt0Var.o;
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                m1 m1Var = ((mt0) arrayList2.get(i)).G;
                if (m1Var != null) {
                    m1Var.setSubUiVisibilityListener(this);
                }
            }
        }
        gt0 gt0Var2 = this.mMenu;
        if (gt0Var2 != null) {
            gt0Var2.i();
            arrayList = gt0Var2.p;
        } else {
            arrayList = null;
        }
        if (this.mReserveOverflow && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z2 = !((mt0) arrayList.get(0)).I;
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
            }
            ViewGroup viewGroup = (ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.mOverflowButton);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.mOverflowButton, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.mOverflowButton;
            if (overflowMenuButton != null) {
                Object parent = overflowMenuButton.getParent();
                Object obj = this.mMenuView;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.mOverflowButton);
                }
            }
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
