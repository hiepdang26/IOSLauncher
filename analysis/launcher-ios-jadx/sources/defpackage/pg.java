package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.widget.MenuPopupWindow;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class pg extends rt0 implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int H = n61.abc_cascading_menu_item_layout;
    public int A;
    public boolean C;
    public ut0 D;
    public ViewTreeObserver E;
    public PopupWindow.OnDismissListener F;
    public boolean G;
    public final Context h;
    public final int i;
    public final int j;
    public final int k;
    public final boolean l;
    public final Handler m;
    public final lg p;
    public final mg q;
    public View u;
    public View v;
    public int w;
    public boolean x;
    public boolean y;
    public int z;
    public final ArrayList n = new ArrayList();
    public final ArrayList o = new ArrayList();
    public final mc1 r = new mc1(this, 6);
    public int s = 0;
    public int t = 0;
    public boolean B = false;

    public pg(Context context, View view, int i, int i2, boolean z) {
        this.p = new lg(this, i);
        this.q = new mg(this, i);
        this.h = context;
        this.u = view;
        this.j = i;
        this.k = i2;
        this.l = z;
        WeakHashMap weakHashMap = qs1.a;
        this.w = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(f51.abc_config_prefDialogWidth));
        this.m = new Handler();
    }

    @Override // defpackage.rt0
    public final void a(gt0 gt0Var) {
        gt0Var.b(this, this.h);
        if (isShowing()) {
            k(gt0Var);
        } else {
            this.n.add(gt0Var);
        }
    }

    @Override // defpackage.rt0
    public final void c(View view) {
        if (this.u != view) {
            this.u = view;
            int i = this.s;
            WeakHashMap weakHashMap = qs1.a;
            this.t = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        }
    }

    @Override // defpackage.rt0
    public final void d(boolean z) {
        this.B = z;
    }

    @Override // defpackage.qg1
    public final void dismiss() {
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        if (size > 0) {
            og[] ogVarArr = (og[]) arrayList.toArray(new og[size]);
            for (int i = size - 1; i >= 0; i--) {
                og ogVar = ogVarArr[i];
                if (ogVar.a.isShowing()) {
                    ogVar.a.dismiss();
                }
            }
        }
    }

    @Override // defpackage.rt0
    public final void e(int i) {
        if (this.s != i) {
            this.s = i;
            View view = this.u;
            WeakHashMap weakHashMap = qs1.a;
            this.t = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        }
    }

    @Override // defpackage.rt0
    public final void f(int i) {
        this.x = true;
        this.z = i;
    }

    @Override // defpackage.vt0
    public final boolean flagActionItems() {
        return false;
    }

    @Override // defpackage.rt0
    public final void g(PopupWindow.OnDismissListener onDismissListener) {
        this.F = onDismissListener;
    }

    @Override // defpackage.qg1
    public final ListView getListView() {
        ArrayList arrayList = this.o;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((og) arrayList.get(arrayList.size() - 1)).a.getListView();
    }

    @Override // defpackage.rt0
    public final void h(boolean z) {
        this.C = z;
    }

    @Override // defpackage.rt0
    public final void i(int i) {
        this.y = true;
        this.A = i;
    }

    @Override // defpackage.qg1
    public final boolean isShowing() {
        ArrayList arrayList = this.o;
        return arrayList.size() > 0 && ((og) arrayList.get(0)).a.isShowing();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(defpackage.gt0 r18) {
        /*
            Method dump skipped, instruction units count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pg.k(gt0):void");
    }

    @Override // defpackage.vt0
    public final void onCloseMenu(gt0 gt0Var, boolean z) {
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (gt0Var == ((og) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            ((og) arrayList.get(i2)).b.c(false);
        }
        og ogVar = (og) arrayList.remove(i);
        ogVar.b.r(this);
        boolean z2 = this.G;
        MenuPopupWindow menuPopupWindow = ogVar.a;
        if (z2) {
            menuPopupWindow.setExitTransition(null);
            menuPopupWindow.setAnimationStyle(0);
        }
        menuPopupWindow.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.w = ((og) arrayList.get(size2 - 1)).c;
        } else {
            View view = this.u;
            WeakHashMap weakHashMap = qs1.a;
            this.w = view.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((og) arrayList.get(0)).b.c(false);
                return;
            }
            return;
        }
        dismiss();
        ut0 ut0Var = this.D;
        if (ut0Var != null) {
            ut0Var.onCloseMenu(gt0Var, true);
        }
        ViewTreeObserver viewTreeObserver = this.E;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.E.removeGlobalOnLayoutListener(this.p);
            }
            this.E = null;
        }
        this.v.removeOnAttachStateChangeListener(this.q);
        this.F.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        og ogVar;
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                ogVar = null;
                break;
            }
            ogVar = (og) arrayList.get(i);
            if (!ogVar.a.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (ogVar != null) {
            ogVar.b.c(false);
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
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            og ogVar = (og) obj;
            if (ik1Var == ogVar.b) {
                ogVar.a.getListView().requestFocus();
                return true;
            }
        }
        if (!ik1Var.hasVisibleItems()) {
            return false;
        }
        a(ik1Var);
        ut0 ut0Var = this.D;
        if (ut0Var != null) {
            ut0Var.onOpenSubMenu(ik1Var);
        }
        return true;
    }

    @Override // defpackage.vt0
    public final void setCallback(ut0 ut0Var) {
        this.D = ut0Var;
    }

    @Override // defpackage.qg1
    public final void show() {
        if (isShowing()) {
            return;
        }
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            k((gt0) obj);
        }
        arrayList.clear();
        View view = this.u;
        this.v = view;
        if (view != null) {
            boolean z = this.E == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.E = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.p);
            }
            this.v.addOnAttachStateChangeListener(this.q);
        }
    }

    @Override // defpackage.vt0
    public final void updateMenuView(boolean z) {
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ListAdapter adapter = ((og) obj).a.getListView().getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((dt0) adapter).notifyDataSetChanged();
        }
    }

    @Override // defpackage.vt0
    public final void onRestoreInstanceState(Parcelable parcelable) {
    }
}
