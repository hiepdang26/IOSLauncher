package defpackage;

import android.view.View;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Workspace;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ui1 implements my0 {
    public int g;
    public int h;
    public int i;
    public final int j;
    public final Object k;
    public final /* synthetic */ Object l;

    public ui1(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.l = staggeredGridLayoutManager;
        this.k = new ArrayList();
        this.g = RtlSpacingHelper.UNDEFINED;
        this.h = RtlSpacingHelper.UNDEFINED;
        this.i = 0;
        this.j = i;
    }

    public void a(View view) {
        ri1 ri1Var = (ri1) view.getLayoutParams();
        ri1Var.e = this;
        ArrayList arrayList = (ArrayList) this.k;
        arrayList.add(view);
        this.h = RtlSpacingHelper.UNDEFINED;
        if (arrayList.size() == 1) {
            this.g = RtlSpacingHelper.UNDEFINED;
        }
        if (ri1Var.a.m() || ri1Var.a.p()) {
            this.i = ((StaggeredGridLayoutManager) this.l).r.c(view) + this.i;
        }
    }

    public void b() {
        si1 si1VarL;
        ArrayList arrayList = (ArrayList) this.k;
        View view = (View) arrayList.get(arrayList.size() - 1);
        ri1 ri1Var = (ri1) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.l;
        this.h = staggeredGridLayoutManager.r.b(view);
        if (ri1Var.f && (si1VarL = staggeredGridLayoutManager.B.l(ri1Var.a.f())) != null && si1VarL.h == 1) {
            int i = this.h;
            int[] iArr = si1VarL.i;
            this.h = (iArr == null ? 0 : iArr[this.j]) + i;
        }
    }

    public void c() {
        si1 si1VarL;
        View view = (View) ((ArrayList) this.k).get(0);
        ri1 ri1Var = (ri1) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.l;
        this.g = staggeredGridLayoutManager.r.e(view);
        if (ri1Var.f && (si1VarL = staggeredGridLayoutManager.B.l(ri1Var.a.f())) != null && si1VarL.h == -1) {
            int i = this.g;
            int[] iArr = si1VarL.i;
            this.g = i - (iArr != null ? iArr[this.j] : 0);
        }
    }

    public void d() {
        ((ArrayList) this.k).clear();
        this.g = RtlSpacingHelper.UNDEFINED;
        this.h = RtlSpacingHelper.UNDEFINED;
        this.i = 0;
    }

    public int e() {
        return ((StaggeredGridLayoutManager) this.l).w ? g(r1.size() - 1, -1) : g(0, ((ArrayList) this.k).size());
    }

    public int f() {
        return ((StaggeredGridLayoutManager) this.l).w ? g(0, ((ArrayList) this.k).size()) : g(r1.size() - 1, -1);
    }

    public int g(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.l;
        int iK = staggeredGridLayoutManager.r.k();
        int iG = staggeredGridLayoutManager.r.g();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View view = (View) ((ArrayList) this.k).get(i);
            int iE = staggeredGridLayoutManager.r.e(view);
            int iB = staggeredGridLayoutManager.r.b(view);
            boolean z = iE <= iG;
            boolean z2 = iB >= iK;
            if (z && z2 && (iE < iK || iB > iG)) {
                return u81.J(view);
            }
            i += i3;
        }
        return -1;
    }

    public int h(int i) {
        int i2 = this.h;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (((ArrayList) this.k).size() == 0) {
            return i;
        }
        b();
        return this.h;
    }

    public View i(int i, int i2) {
        ArrayList arrayList = (ArrayList) this.k;
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.l;
        View view = null;
        if (i2 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.w && u81.J(view2) >= i) || ((!staggeredGridLayoutManager.w && u81.J(view2) <= i) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            View view3 = (View) arrayList.get(i3);
            if ((staggeredGridLayoutManager.w && u81.J(view3) <= i) || ((!staggeredGridLayoutManager.w && u81.J(view3) >= i) || !view3.hasFocusable())) {
                break;
            }
            i3++;
            view = view3;
        }
        return view;
    }

    public int j(int i) {
        int i2 = this.g;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (((ArrayList) this.k).size() == 0) {
            return i;
        }
        c();
        return this.g;
    }

    public void k() {
        ArrayList arrayList = (ArrayList) this.k;
        int size = arrayList.size();
        View view = (View) arrayList.remove(size - 1);
        ri1 ri1Var = (ri1) view.getLayoutParams();
        ri1Var.e = null;
        if (ri1Var.a.m() || ri1Var.a.p()) {
            this.i -= ((StaggeredGridLayoutManager) this.l).r.c(view);
        }
        if (size == 1) {
            this.g = RtlSpacingHelper.UNDEFINED;
        }
        this.h = RtlSpacingHelper.UNDEFINED;
    }

    public void l() {
        ArrayList arrayList = (ArrayList) this.k;
        View view = (View) arrayList.remove(0);
        ri1 ri1Var = (ri1) view.getLayoutParams();
        ri1Var.e = null;
        if (arrayList.size() == 0) {
            this.h = RtlSpacingHelper.UNDEFINED;
        }
        if (ri1Var.a.m() || ri1Var.a.p()) {
            this.i -= ((StaggeredGridLayoutManager) this.l).r.c(view);
        }
        this.g = RtlSpacingHelper.UNDEFINED;
    }

    public void m(View view) {
        ri1 ri1Var = (ri1) view.getLayoutParams();
        ri1Var.e = this;
        ArrayList arrayList = (ArrayList) this.k;
        arrayList.add(0, view);
        this.g = RtlSpacingHelper.UNDEFINED;
        if (arrayList.size() == 1) {
            this.h = RtlSpacingHelper.UNDEFINED;
        }
        if (ri1Var.a.m() || ri1Var.a.p()) {
            this.i = ((StaggeredGridLayoutManager) this.l).r.c(view) + this.i;
        }
    }

    @Override // defpackage.my0
    public void p(g3 g3Var) {
        Objects.toString(g3Var);
        Workspace workspace = (Workspace) this.l;
        float[] fArr = workspace.X0;
        workspace.G0 = Workspace.z0((int) fArr[0], (int) fArr[1], this.g, this.h, workspace.P0, workspace.G0);
        int[] iArr = workspace.G0;
        workspace.z1 = iArr[0];
        workspace.A1 = iArr[1];
        CellLayout cellLayout = workspace.P0;
        float[] fArr2 = workspace.X0;
        int i = (int) fArr2[0];
        int i2 = (int) fArr2[1];
        View view = (View) this.k;
        int[] iArrA = cellLayout.A(i, i2, this.g, this.h, this.i, this.j, view, iArr, new int[2], 1);
        workspace.G0 = iArrA;
        if (iArrA[0] < 0 || iArrA[1] < 0) {
            workspace.P0.E();
        } else {
            workspace.setDragMode(3);
        }
    }

    public ui1(Workspace workspace, int i, int i2, int i3, int i4, View view) {
        this.l = workspace;
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = i4;
        this.k = view;
    }
}
