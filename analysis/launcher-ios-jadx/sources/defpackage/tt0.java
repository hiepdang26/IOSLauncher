package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class tt0 {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private boolean mForceShowIcon;
    private final gt0 mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private rt0 mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private ut0 mPresenterCallback;
    private int mDropDownGravity = 8388611;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener = new st0(this);

    public tt0(int i, int i2, gt0 gt0Var, Context context, View view, boolean z) {
        this.mContext = context;
        this.mMenu = gt0Var;
        this.mAnchorView = view;
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
    }

    public final void a(int i, int i2, boolean z, boolean z2) {
        rt0 popup = getPopup();
        popup.h(z2);
        if (z) {
            int i3 = this.mDropDownGravity;
            View view = this.mAnchorView;
            WeakHashMap weakHashMap = qs1.a;
            if ((Gravity.getAbsoluteGravity(i3, view.getLayoutDirection()) & 7) == 5) {
                i -= this.mAnchorView.getWidth();
            }
            popup.f(i);
            popup.i(i2);
            int i4 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.g = new Rect(i - i4, i2 - i4, i + i4, i2 + i4);
        }
        popup.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    public rt0 getPopup() {
        rt0 xi1Var;
        if (this.mPopup == null) {
            Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(f51.abc_cascading_menus_min_smallest_width)) {
                xi1Var = new pg(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
            } else {
                Context context = this.mContext;
                xi1Var = new xi1(this.mPopupStyleAttr, this.mPopupStyleRes, this.mMenu, context, this.mAnchorView, this.mOverflowOnly);
            }
            xi1Var.a(this.mMenu);
            xi1Var.g(this.mInternalOnDismissListener);
            xi1Var.c(this.mAnchorView);
            xi1Var.setCallback(this.mPresenterCallback);
            xi1Var.d(this.mForceShowIcon);
            xi1Var.e(this.mDropDownGravity);
            this.mPopup = xi1Var;
        }
        return this.mPopup;
    }

    public boolean isShowing() {
        rt0 rt0Var = this.mPopup;
        return rt0Var != null && rt0Var.isShowing();
    }

    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
        rt0 rt0Var = this.mPopup;
        if (rt0Var != null) {
            rt0Var.d(z);
        }
    }

    public void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setPresenterCallback(ut0 ut0Var) {
        this.mPresenterCallback = ut0Var;
        rt0 rt0Var = this.mPopup;
        if (rt0Var != null) {
            rt0Var.setCallback(ut0Var);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public void show(int i, int i2) {
        if (!tryShow(i, i2)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }
}
