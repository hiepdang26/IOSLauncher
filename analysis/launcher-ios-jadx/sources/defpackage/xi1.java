package defpackage;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.MenuPopupWindow;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class xi1 extends rt0 implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public static final int B = n61.abc_popup_menu_item_layout;
    public boolean A;
    public final Context h;
    public final gt0 i;
    public final dt0 j;
    public final boolean k;
    public final int l;
    public final int m;
    public final int n;
    public final MenuPopupWindow o;
    public PopupWindow.OnDismissListener r;
    public View s;
    public View t;
    public ut0 u;
    public ViewTreeObserver v;
    public boolean w;
    public boolean x;
    public int y;
    public final lg p = new lg(this, 4);
    public final mg q = new mg(this, 3);
    public int z = 0;

    public xi1(int i, int i2, gt0 gt0Var, Context context, View view, boolean z) {
        this.h = context;
        this.i = gt0Var;
        this.k = z;
        this.j = new dt0(gt0Var, LayoutInflater.from(context), z, B);
        this.m = i;
        this.n = i2;
        Resources resources = context.getResources();
        this.l = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(f51.abc_config_prefDialogWidth));
        this.s = view;
        this.o = new MenuPopupWindow(context, null, i, i2);
        gt0Var.b(this, context);
    }

    @Override // defpackage.rt0
    public final void c(View view) {
        this.s = view;
    }

    @Override // defpackage.rt0
    public final void d(boolean z) {
        this.j.i = z;
    }

    @Override // defpackage.qg1
    public final void dismiss() {
        if (isShowing()) {
            this.o.dismiss();
        }
    }

    @Override // defpackage.rt0
    public final void e(int i) {
        this.z = i;
    }

    @Override // defpackage.rt0
    public final void f(int i) {
        this.o.setHorizontalOffset(i);
    }

    @Override // defpackage.vt0
    public final boolean flagActionItems() {
        return false;
    }

    @Override // defpackage.rt0
    public final void g(PopupWindow.OnDismissListener onDismissListener) {
        this.r = onDismissListener;
    }

    @Override // defpackage.qg1
    public final ListView getListView() {
        return this.o.getListView();
    }

    @Override // defpackage.rt0
    public final void h(boolean z) {
        this.A = z;
    }

    @Override // defpackage.rt0
    public final void i(int i) {
        this.o.setVerticalOffset(i);
    }

    @Override // defpackage.qg1
    public final boolean isShowing() {
        return !this.w && this.o.isShowing();
    }

    @Override // defpackage.vt0
    public final void onCloseMenu(gt0 gt0Var, boolean z) {
        if (gt0Var != this.i) {
            return;
        }
        dismiss();
        ut0 ut0Var = this.u;
        if (ut0Var != null) {
            ut0Var.onCloseMenu(gt0Var, z);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.w = true;
        this.i.c(true);
        ViewTreeObserver viewTreeObserver = this.v;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.v = this.t.getViewTreeObserver();
            }
            this.v.removeGlobalOnLayoutListener(this.p);
            this.v = null;
        }
        this.t.removeOnAttachStateChangeListener(this.q);
        PopupWindow.OnDismissListener onDismissListener = this.r;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // defpackage.vt0
    public final Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // defpackage.vt0
    public final boolean onSubMenuSelected(ik1 ik1Var) {
        if (ik1Var.hasVisibleItems()) {
            View view = this.t;
            tt0 tt0Var = new tt0(this.m, this.n, ik1Var, this.h, view, this.k);
            tt0Var.setPresenterCallback(this.u);
            tt0Var.setForceShowIcon(rt0.j(ik1Var));
            tt0Var.setOnDismissListener(this.r);
            this.r = null;
            this.i.c(false);
            MenuPopupWindow menuPopupWindow = this.o;
            int horizontalOffset = menuPopupWindow.getHorizontalOffset();
            int verticalOffset = menuPopupWindow.getVerticalOffset();
            int i = this.z;
            View view2 = this.s;
            WeakHashMap weakHashMap = qs1.a;
            if ((Gravity.getAbsoluteGravity(i, view2.getLayoutDirection()) & 7) == 5) {
                horizontalOffset += this.s.getWidth();
            }
            if (tt0Var.tryShow(horizontalOffset, verticalOffset)) {
                ut0 ut0Var = this.u;
                if (ut0Var == null) {
                    return true;
                }
                ut0Var.onOpenSubMenu(ik1Var);
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.vt0
    public final void setCallback(ut0 ut0Var) {
        this.u = ut0Var;
    }

    @Override // defpackage.qg1
    public final void show() {
        View view;
        if (isShowing()) {
            return;
        }
        if (this.w || (view = this.s) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.t = view;
        MenuPopupWindow menuPopupWindow = this.o;
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setModal(true);
        View view2 = this.t;
        boolean z = this.v == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.v = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.p);
        }
        view2.addOnAttachStateChangeListener(this.q);
        menuPopupWindow.setAnchorView(view2);
        menuPopupWindow.setDropDownGravity(this.z);
        boolean z2 = this.x;
        Context context = this.h;
        dt0 dt0Var = this.j;
        if (!z2) {
            this.y = rt0.b(dt0Var, context, this.l);
            this.x = true;
        }
        menuPopupWindow.setContentWidth(this.y);
        menuPopupWindow.setInputMethodMode(2);
        menuPopupWindow.setEpicenterBounds(this.g);
        menuPopupWindow.show();
        ListView listView = menuPopupWindow.getListView();
        listView.setOnKeyListener(this);
        if (this.A) {
            gt0 gt0Var = this.i;
            if (gt0Var.s != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(n61.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
                TextView textView = (TextView) frameLayout.findViewById(R.id.title);
                if (textView != null) {
                    textView.setText(gt0Var.s);
                }
                frameLayout.setEnabled(false);
                listView.addHeaderView(frameLayout, null, false);
            }
        }
        menuPopupWindow.setAdapter(dt0Var);
        menuPopupWindow.show();
    }

    @Override // defpackage.vt0
    public final void updateMenuView(boolean z) {
        this.x = false;
        dt0 dt0Var = this.j;
        if (dt0Var != null) {
            dt0Var.notifyDataSetChanged();
        }
    }

    @Override // defpackage.rt0
    public final void a(gt0 gt0Var) {
    }

    @Override // defpackage.vt0
    public final void onRestoreInstanceState(Parcelable parcelable) {
    }
}
