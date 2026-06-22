package defpackage;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c91 {
    public final ArrayList a;
    public ArrayList b;
    public final ArrayList c;
    public final List d;
    public int e;
    public int f;
    public b91 g;
    public final /* synthetic */ RecyclerView h;

    public c91(RecyclerView recyclerView) {
        this.h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = null;
        this.c = new ArrayList();
        this.d = Collections.unmodifiableList(arrayList);
        this.e = 2;
        this.f = 2;
    }

    public final void a(m91 m91Var, boolean z) {
        RecyclerView.n(m91Var);
        RecyclerView recyclerView = this.h;
        o91 o91Var = recyclerView.u0;
        View view = m91Var.g;
        if (o91Var != null) {
            e0 e0VarJ = o91Var.j();
            qs1.p(view, e0VarJ instanceof n91 ? (e0) ((n91) e0VarJ).k.remove(view) : null);
        }
        if (z) {
            ArrayList arrayList = recyclerView.u;
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                throw new ClassCastException();
            }
            m81 m81Var = recyclerView.s;
            if (m81Var != null) {
                m81Var.n(m91Var);
            }
            if (recyclerView.n0 != null) {
                recyclerView.m.o(m91Var);
            }
            if (RecyclerView.H0) {
                Objects.toString(m91Var);
            }
        }
        m91Var.y = null;
        m91Var.x = null;
        b91 b91VarC = c();
        b91VarC.getClass();
        int i = m91Var.l;
        ArrayList arrayList2 = b91VarC.a(i).a;
        if (((a91) b91VarC.a.get(i)).b <= arrayList2.size()) {
            i21.a(view);
        } else {
            if (RecyclerView.G0 && arrayList2.contains(m91Var)) {
                throw new IllegalArgumentException("this scrap item already exists");
            }
            m91Var.r();
            arrayList2.add(m91Var);
        }
    }

    public final int b(int i) {
        RecyclerView recyclerView = this.h;
        if (i >= 0 && i < recyclerView.n0.b()) {
            return !recyclerView.n0.g ? i : recyclerView.k.g(i, 0);
        }
        StringBuilder sbL = uo.l(i, "invalid position ", ". State item count is ");
        sbL.append(recyclerView.n0.b());
        sbL.append(recyclerView.F());
        throw new IndexOutOfBoundsException(sbL.toString());
    }

    public final b91 c() {
        if (this.g == null) {
            b91 b91Var = new b91();
            b91Var.a = new SparseArray();
            b91Var.b = 0;
            b91Var.c = Collections.newSetFromMap(new IdentityHashMap());
            this.g = b91Var;
            d();
        }
        return this.g;
    }

    public final void d() {
        RecyclerView recyclerView;
        m81 m81Var;
        b91 b91Var = this.g;
        if (b91Var == null || (m81Var = (recyclerView = this.h).s) == null || !recyclerView.y) {
            return;
        }
        b91Var.c.add(m81Var);
    }

    public final void e(m81 m81Var, boolean z) {
        b91 b91Var = this.g;
        if (b91Var == null) {
            return;
        }
        Set set = b91Var.c;
        set.remove(m81Var);
        if (set.size() != 0 || z) {
            return;
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = b91Var.a;
            if (i >= sparseArray.size()) {
                return;
            }
            ArrayList arrayList = ((a91) sparseArray.get(sparseArray.keyAt(i))).a;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                i21.a(((m91) arrayList.get(i2)).g);
            }
            i++;
        }
    }

    public final void f() {
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g(size);
        }
        arrayList.clear();
        if (RecyclerView.M0) {
            c80 c80Var = this.h.m0;
            int[] iArr = (int[]) c80Var.d;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            c80Var.c = 0;
        }
    }

    public final void g(int i) {
        boolean z = RecyclerView.G0;
        ArrayList arrayList = this.c;
        m91 m91Var = (m91) arrayList.get(i);
        if (RecyclerView.H0) {
            Objects.toString(m91Var);
        }
        a(m91Var, true);
        arrayList.remove(i);
    }

    public final void h(View view) {
        m91 m91VarQ = RecyclerView.Q(view);
        boolean zO = m91VarQ.o();
        RecyclerView recyclerView = this.h;
        if (zO) {
            recyclerView.removeDetachedView(view, false);
        }
        if (m91VarQ.n()) {
            m91VarQ.t.l(m91VarQ);
        } else if (m91VarQ.u()) {
            m91VarQ.p &= -33;
        }
        i(m91VarQ);
        if (recyclerView.S == null || m91VarQ.l()) {
            return;
        }
        recyclerView.S.d(m91VarQ);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d3, code lost:
    
        r5 = r5 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(defpackage.m91 r13) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c91.i(m91):void");
    }

    public final void j(View view) {
        r81 r81Var;
        m91 m91VarQ = RecyclerView.Q(view);
        boolean z = (m91VarQ.p & 12) != 0;
        RecyclerView recyclerView = this.h;
        if (!z && m91VarQ.p() && (r81Var = recyclerView.S) != null) {
            lt ltVar = (lt) r81Var;
            if (m91VarQ.h().isEmpty() && ltVar.g && !m91VarQ.k()) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                m91VarQ.t = this;
                m91VarQ.u = true;
                this.b.add(m91VarQ);
                return;
            }
        }
        if (m91VarQ.k() && !m91VarQ.m() && !recyclerView.s.h) {
            throw new IllegalArgumentException(uo.e(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        m91VarQ.t = this;
        m91VarQ.u = false;
        this.a.add(m91VarQ);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.m91 k(int r30, long r31) {
        /*
            Method dump skipped, instruction units count: 1581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c91.k(int, long):m91");
    }

    public final void l(m91 m91Var) {
        if (m91Var.u) {
            this.b.remove(m91Var);
        } else {
            this.a.remove(m91Var);
        }
        m91Var.t = null;
        m91Var.u = false;
        m91Var.p &= -33;
    }

    public final void m() {
        u81 u81Var = this.h.t;
        this.f = this.e + (u81Var != null ? u81Var.j : 0);
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f; size--) {
            g(size);
        }
    }
}
