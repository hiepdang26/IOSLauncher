package defpackage;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class et1 extends mo {
    public mr0 a;

    @Override // defpackage.mo
    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        s(coordinatorLayout, view, i);
        if (this.a == null) {
            this.a = new mr0(view);
        }
        mr0 mr0Var = this.a;
        View view2 = mr0Var.g;
        mr0Var.h = view2.getTop();
        mr0Var.i = view2.getLeft();
        mr0 mr0Var2 = this.a;
        View view3 = mr0Var2.g;
        qs1.j(0 - (view3.getTop() - mr0Var2.h), view3);
        qs1.i(0 - (view3.getLeft() - mr0Var2.i), view3);
        return true;
    }

    public void s(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.j(i, view);
    }
}
