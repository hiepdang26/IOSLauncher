package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class nw extends th0 {
    public final td d;
    public boolean e;
    public boolean f;

    public nw(td tdVar, boolean z, boolean z2) {
        qg0.l(tdVar, "adapter");
        this.d = tdVar;
        this.e = z;
        this.f = z2;
    }

    @Override // defpackage.th0
    public final void a(RecyclerView recyclerView, m91 m91Var) {
        qg0.l(recyclerView, "recyclerView");
        qg0.l(m91Var, "viewHolder");
        super.a(recyclerView, m91Var);
        td tdVar = this.d;
        if (uo.r(tdVar)) {
            tdVar.getClass();
        }
    }

    @Override // defpackage.th0
    public final int h(RecyclerView recyclerView, m91 m91Var) {
        qg0.l(recyclerView, "recyclerView");
        qg0.l(m91Var, "viewHolder");
        return th0.m(15, 48);
    }

    @Override // defpackage.th0
    public final boolean k() {
        return this.f;
    }

    @Override // defpackage.th0
    public final boolean l() {
        return this.e;
    }

    @Override // defpackage.th0
    public final boolean q(RecyclerView recyclerView, m91 m91Var, m91 m91Var2) {
        qg0.l(recyclerView, "recyclerView");
        qg0.l(m91Var, "viewHolder");
        if (!this.e) {
            return false;
        }
        td tdVar = this.d;
        if (!uo.r(tdVar)) {
            return false;
        }
        int iE = m91Var.e();
        int iE2 = m91Var2.e();
        mm0 mm0Var = (mm0) tdVar;
        ArrayList arrayList = mm0Var.k;
        if (iE >= arrayList.size() || iE2 >= arrayList.size()) {
            return true;
        }
        arrayList.add(iE2, (hm0) arrayList.remove(iE));
        mm0Var.g.c(iE, iE2);
        wq wqVar = mm0Var.j;
        wqVar.getClass();
        new Thread(new rq(wqVar, 3)).start();
        return true;
    }

    @Override // defpackage.th0
    public final void t(m91 m91Var, int i) {
        if (i != 0) {
            td tdVar = this.d;
            if (uo.r(tdVar)) {
                tdVar.getClass();
            }
        }
    }

    @Override // defpackage.th0
    public final void u(m91 m91Var, int i) {
        qg0.l(m91Var, "viewHolder");
        if (this.f) {
            td tdVar = this.d;
            if (uo.r(tdVar)) {
                if (i == 16) {
                    m91Var.e();
                    tdVar.getClass();
                } else {
                    if (i != 32) {
                        return;
                    }
                    m91Var.e();
                    tdVar.getClass();
                }
            }
        }
    }
}
