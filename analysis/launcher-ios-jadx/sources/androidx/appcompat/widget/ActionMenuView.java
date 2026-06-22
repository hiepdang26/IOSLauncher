package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.LinearLayoutCompat;
import defpackage.et0;
import defpackage.ft0;
import defpackage.gt0;
import defpackage.mt0;
import defpackage.ut0;
import defpackage.yt0;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements ft0, yt0 {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private ut0 mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private gt0 mMenu;
    et0 mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        @ViewDebug.ExportedProperty
        public int cellsUsed;

        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;

        @ViewDebug.ExportedProperty
        public int extraPixels;

        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;

        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }

        public LayoutParams(int i, int i2, boolean z) {
            super(i, i2);
            this.isOverflowButton = z;
        }
    }

    public class MenuBuilderCallback implements et0 {
        public MenuBuilderCallback() {
        }

        @Override // defpackage.et0
        public boolean onMenuItemSelected(gt0 gt0Var, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.mOnMenuItemClickListener;
            return onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem);
        }

        @Override // defpackage.et0
        public void onMenuModeChange(gt0 gt0Var) {
            et0 et0Var = ActionMenuView.this.mMenuBuilderCallback;
            if (et0Var != null) {
                et0Var.onMenuModeChange(gt0Var);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int measureChildForCells(android.view.View r5, int r6, int r7, int r8, int r9) {
        /*
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$LayoutParams r0 = (androidx.appcompat.widget.ActionMenuView.LayoutParams) r0
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            int r1 = r1 - r9
            int r8 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            boolean r9 = r5 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r9 == 0) goto L1b
            r9 = r5
            androidx.appcompat.view.menu.ActionMenuItemView r9 = (androidx.appcompat.view.menu.ActionMenuItemView) r9
            goto L1c
        L1b:
            r9 = 0
        L1c:
            r1 = 1
            r2 = 0
            if (r9 == 0) goto L2c
            java.lang.CharSequence r9 = r9.getText()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L2c
            r9 = 1
            goto L2d
        L2c:
            r9 = 0
        L2d:
            if (r7 <= 0) goto L51
            r3 = 2
            if (r9 == 0) goto L34
            if (r7 < r3) goto L51
        L34:
            int r7 = r7 * r6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4)
            r5.measure(r7, r8)
            int r7 = r5.getMeasuredWidth()
            int r4 = r7 / r6
            int r7 = r7 % r6
            if (r7 == 0) goto L4a
            int r4 = r4 + 1
        L4a:
            if (r9 == 0) goto L4f
            if (r4 >= r3) goto L4f
            goto L52
        L4f:
            r3 = r4
            goto L52
        L51:
            r3 = 0
        L52:
            boolean r7 = r0.isOverflowButton
            if (r7 != 0) goto L59
            if (r9 == 0) goto L59
            goto L5a
        L59:
            r1 = 0
        L5a:
            r0.expandable = r1
            r0.cellsUsed = r3
            int r6 = r6 * r3
            r7 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r5.measure(r6, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.measureChildForCells(android.view.View, int, int, int, int):int");
    }

    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    private void onMeasureExactFormat(int i, int i2) {
        int i3;
        int i4;
        long j;
        int i5;
        boolean z;
        ?? r3;
        int i6;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
        int i7 = size - paddingRight;
        int i8 = this.mMinCellSize;
        int i9 = i7 / i8;
        int i10 = i7 % i8;
        if (i9 == 0) {
            setMeasuredDimension(i7, 0);
            return;
        }
        int i11 = (i10 / i9) + i8;
        int childCount = getChildCount();
        int iMax = 0;
        int i12 = 0;
        boolean z2 = false;
        int i13 = 0;
        int iMax2 = 0;
        int i14 = 0;
        long j2 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            int i15 = size2;
            if (childAt.getVisibility() == 8) {
                i6 = paddingBottom;
            } else {
                boolean z3 = childAt instanceof ActionMenuItemView;
                i13++;
                if (z3) {
                    int i16 = this.mGeneratedItemPadding;
                    z = z3;
                    r3 = 0;
                    childAt.setPadding(i16, 0, i16, 0);
                } else {
                    z = z3;
                    r3 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.expanded = r3;
                layoutParams.extraPixels = r3;
                layoutParams.cellsUsed = r3;
                layoutParams.expandable = r3;
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = r3;
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = r3;
                layoutParams.preventEdgeOffset = z && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int iMeasureChildForCells = measureChildForCells(childAt, i11, layoutParams.isOverflowButton ? 1 : i9, childMeasureSpec, paddingBottom);
                iMax2 = Math.max(iMax2, iMeasureChildForCells);
                i6 = paddingBottom;
                if (layoutParams.expandable) {
                    i14++;
                }
                if (layoutParams.isOverflowButton) {
                    z2 = true;
                }
                i9 -= iMeasureChildForCells;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iMeasureChildForCells == 1) {
                    j2 |= (long) (1 << i12);
                    i9 = i9;
                }
            }
            i12++;
            size2 = i15;
            paddingBottom = i6;
        }
        int i17 = size2;
        boolean z4 = z2 && i13 == 2;
        boolean z5 = false;
        while (i14 > 0 && i9 > 0) {
            long j3 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            j = 1;
            while (i19 < childCount) {
                boolean z6 = z4;
                LayoutParams layoutParams2 = (LayoutParams) getChildAt(i19).getLayoutParams();
                int i21 = i11;
                if (layoutParams2.expandable) {
                    int i22 = layoutParams2.cellsUsed;
                    if (i22 < i20) {
                        j3 = 1 << i19;
                        i20 = i22;
                        i18 = 1;
                    } else if (i22 == i20) {
                        j3 |= 1 << i19;
                        i18++;
                    }
                }
                i19++;
                i11 = i21;
                z4 = z6;
            }
            boolean z7 = z4;
            i3 = i11;
            j2 |= j3;
            if (i18 > i9) {
                i4 = iMax;
                break;
            }
            int i23 = i20 + 1;
            int i24 = 0;
            while (i24 < childCount) {
                View childAt2 = getChildAt(i24);
                LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                int i25 = iMax;
                long j4 = 1 << i24;
                if ((j3 & j4) == 0) {
                    if (layoutParams3.cellsUsed == i23) {
                        j2 |= j4;
                    }
                    i5 = i24;
                } else {
                    if (z7 && layoutParams3.preventEdgeOffset && i9 == 1) {
                        int i26 = this.mGeneratedItemPadding;
                        i5 = i24;
                        childAt2.setPadding(i26 + i3, 0, i26, 0);
                    } else {
                        i5 = i24;
                    }
                    layoutParams3.cellsUsed++;
                    layoutParams3.expanded = true;
                    i9--;
                }
                i24 = i5 + 1;
                iMax = i25;
            }
            i11 = i3;
            z4 = z7;
            z5 = true;
        }
        i3 = i11;
        i4 = iMax;
        j = 1;
        boolean z8 = !z2 && i13 == 1;
        if (i9 > 0 && j2 != 0 && (i9 < i13 - 1 || z8 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j2);
            if (!z8) {
                if ((j2 & j) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset) {
                    fBitCount -= 0.5f;
                }
                int i27 = childCount - 1;
                if ((j2 & ((long) (1 << i27))) != 0 && !((LayoutParams) getChildAt(i27).getLayoutParams()).preventEdgeOffset) {
                    fBitCount -= 0.5f;
                }
            }
            int i28 = fBitCount > 0.0f ? (int) ((i9 * i3) / fBitCount) : 0;
            for (int i29 = 0; i29 < childCount; i29++) {
                if ((j2 & ((long) (1 << i29))) != 0) {
                    View childAt3 = getChildAt(i29);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.extraPixels = i28;
                        layoutParams4.expanded = true;
                        if (i29 == 0 && !layoutParams4.preventEdgeOffset) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = (-i28) / 2;
                        }
                    } else if (layoutParams4.isOverflowButton) {
                        layoutParams4.extraPixels = i28;
                        layoutParams4.expanded = true;
                        ((LinearLayout.LayoutParams) layoutParams4).rightMargin = (-i28) / 2;
                    } else {
                        if (i29 != 0) {
                            ((LinearLayout.LayoutParams) layoutParams4).leftMargin = i28 / 2;
                        }
                        if (i29 != childCount - 1) {
                            ((LinearLayout.LayoutParams) layoutParams4).rightMargin = i28 / 2;
                        }
                    }
                    z5 = true;
                }
            }
        }
        if (z5) {
            for (int i30 = 0; i30 < childCount; i30++) {
                View childAt4 = getChildAt(i30);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.expanded) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.cellsUsed * i3) + layoutParams5.extraPixels, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i7, mode != 1073741824 ? i4 : i17);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.isOverflowButton = true;
        return layoutParamsGenerateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            gt0 gt0Var = new gt0(context);
            this.mMenu = gt0Var;
            gt0Var.k = new MenuBuilderCallback();
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.mPresenter = actionMenuPresenter;
            actionMenuPresenter.setReserveOverflow(true);
            ActionMenuPresenter actionMenuPresenter2 = this.mPresenter;
            ut0 actionMenuPresenterCallback = this.mActionMenuPresenterCallback;
            if (actionMenuPresenterCallback == null) {
                actionMenuPresenterCallback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.setCallback(actionMenuPresenterCallback);
            this.mMenu.b(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean hasSupportDividerBeforeChildAt(int i) {
        boolean zNeedsDividerAfter = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            zNeedsDividerAfter = ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? zNeedsDividerAfter : ((ActionMenuChildView) childAt2).needsDividerBefore() | zNeedsDividerAfter;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu();
    }

    @Override // defpackage.yt0
    public void initialize(gt0 gt0Var) {
        this.mMenu = gt0Var;
    }

    @Override // defpackage.ft0
    public boolean invokeItem(mt0 mt0Var) {
        return this.mMenu.q(mt0Var, null, 0);
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.mFormatItems) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isOverflowButton) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i9)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zIsLayoutRtl) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i10 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i10, width, measuredHeight + i10);
                    paddingRight -= measuredWidth;
                    i7 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    hasSupportDividerBeforeChildAt(i9);
                    i8++;
                }
            }
        }
        if (childCount == 1 && i7 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i11 = (i6 / 2) - (measuredWidth2 / 2);
            int i12 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i11, i12, measuredWidth2 + i11, measuredHeight2 + i12);
            return;
        }
        int i13 = i8 - (i7 ^ 1);
        int iMax = Math.max(0, i13 > 0 ? paddingRight / i13 : 0);
        if (zIsLayoutRtl) {
            int width2 = getWidth() - getPaddingRight();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt3 = getChildAt(i14);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.isOverflowButton) {
                    int i15 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt4 = getChildAt(i17);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.isOverflowButton) {
                int i18 = paddingLeft2 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth4, measuredHeight4 + i19);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + iMax + i18;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        gt0 gt0Var;
        boolean z = this.mFormatItems;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.mFormatItems = z2;
        if (z != z2) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.mFormatItems && (gt0Var = this.mMenu) != null && size != this.mFormatItemsWidth) {
            this.mFormatItemsWidth = size;
            gt0Var.p(true);
        }
        int childCount = getChildCount();
        if (this.mFormatItems && childCount > 0) {
            onMeasureExactFormat(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
            ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public gt0 peekMenu() {
        return this.mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.setExpandedActionViewsExclusive(z);
    }

    public void setMenuCallbacks(ut0 ut0Var, et0 et0Var) {
        this.mActionMenuPresenterCallback = ut0Var;
        this.mMenuBuilderCallback = et0Var;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu();
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (f * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
            } else {
                layoutParams2 = new LayoutParams(layoutParams);
            }
            if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
                ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }

    public static class ActionMenuPresenterCallback implements ut0 {
        @Override // defpackage.ut0
        public boolean onOpenSubMenu(gt0 gt0Var) {
            return false;
        }

        @Override // defpackage.ut0
        public void onCloseMenu(gt0 gt0Var, boolean z) {
        }
    }
}
