package defpackage;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f11 extends x81 {
    public RecyclerView a;
    public final ai1 b = new ai1(this);
    public j01 c;
    public j01 d;

    public static int c(View view, wy wyVar) {
        return ((wyVar.c(view) / 2) + wyVar.e(view)) - ((wyVar.l() / 2) + wyVar.k());
    }

    public static View d(u81 u81Var, wy wyVar) {
        int iV = u81Var.v();
        View view = null;
        if (iV == 0) {
            return null;
        }
        int iL = (wyVar.l() / 2) + wyVar.k();
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i2 = 0; i2 < iV; i2++) {
            View viewU = u81Var.u(i2);
            int iAbs = Math.abs(((wyVar.c(viewU) / 2) + wyVar.e(viewU)) - iL);
            if (iAbs < i) {
                view = viewU;
                i = iAbs;
            }
        }
        return view;
    }

    public final void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        ai1 ai1Var = this.b;
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.p0;
            if (arrayList != null) {
                arrayList.remove(ai1Var);
            }
            this.a.setOnFlingListener(null);
        }
        this.a = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.a.l(ai1Var);
            this.a.setOnFlingListener(this);
            new Scroller(this.a.getContext(), new DecelerateInterpolator());
            h();
        }
    }

    public final int[] b(u81 u81Var, View view) {
        int[] iArr = new int[2];
        if (u81Var.d()) {
            iArr[0] = c(view, f(u81Var));
        } else {
            iArr[0] = 0;
        }
        if (u81Var.e()) {
            iArr[1] = c(view, g(u81Var));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    public View e(u81 u81Var) {
        if (u81Var.e()) {
            return d(u81Var, g(u81Var));
        }
        if (u81Var.d()) {
            return d(u81Var, f(u81Var));
        }
        return null;
    }

    public final wy f(u81 u81Var) {
        j01 j01Var = this.d;
        if (j01Var == null || ((u81) j01Var.b) != u81Var) {
            this.d = new j01(u81Var, 0);
        }
        return this.d;
    }

    public final wy g(u81 u81Var) {
        j01 j01Var = this.c;
        if (j01Var == null || ((u81) j01Var.b) != u81Var) {
            this.c = new j01(u81Var, 1);
        }
        return this.c;
    }

    public final void h() {
        u81 layoutManager;
        View viewE;
        RecyclerView recyclerView = this.a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewE = e(layoutManager)) == null) {
            return;
        }
        int[] iArrB = b(layoutManager, viewE);
        int i = iArrB[0];
        if (i == 0 && iArrB[1] == 0) {
            return;
        }
        this.a.n0(i, iArrB[1], false);
    }
}
