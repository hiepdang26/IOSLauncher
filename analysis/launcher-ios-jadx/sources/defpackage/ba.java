package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ba extends xo1 {
    public ArrayList C;
    public boolean D;
    public int E;
    public boolean F;
    public int G;

    @Override // defpackage.xo1
    public final void A(b21 b21Var) {
        super.A(b21Var);
        this.G |= 4;
        if (this.C != null) {
            for (int i = 0; i < this.C.size(); i++) {
                ((xo1) this.C.get(i)).A(b21Var);
            }
        }
    }

    @Override // defpackage.xo1
    public final void B() {
        this.G |= 2;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((xo1) this.C.get(i)).B();
        }
    }

    @Override // defpackage.xo1
    public final void C(long j) {
        this.h = j;
    }

    @Override // defpackage.xo1
    public final String E(String str) {
        String strE = super.E(str);
        for (int i = 0; i < this.C.size(); i++) {
            StringBuilder sbM = k31.m(strE, "\n");
            sbM.append(((xo1) this.C.get(i)).E(str + "  "));
            strE = sbM.toString();
        }
        return strE;
    }

    public final void F(xo1 xo1Var) {
        this.C.add(xo1Var);
        xo1Var.o = this;
        long j = this.i;
        if (j >= 0) {
            xo1Var.x(j);
        }
        if ((this.G & 1) != 0) {
            xo1Var.z(this.j);
        }
        if ((this.G & 2) != 0) {
            xo1Var.B();
        }
        if ((this.G & 4) != 0) {
            xo1Var.A(this.y);
        }
        if ((this.G & 8) != 0) {
            xo1Var.y(null);
        }
    }

    @Override // defpackage.xo1
    public final void c(fp1 fp1Var) {
        if (r(fp1Var.b)) {
            ArrayList arrayList = this.C;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                xo1 xo1Var = (xo1) obj;
                if (xo1Var.r(fp1Var.b)) {
                    xo1Var.c(fp1Var);
                    fp1Var.c.add(xo1Var);
                }
            }
        }
    }

    @Override // defpackage.xo1
    public final void cancel() {
        super.cancel();
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((xo1) this.C.get(i)).cancel();
        }
    }

    @Override // defpackage.xo1
    public final void e(fp1 fp1Var) {
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((xo1) this.C.get(i)).e(fp1Var);
        }
    }

    @Override // defpackage.xo1
    public final void f(fp1 fp1Var) {
        if (r(fp1Var.b)) {
            ArrayList arrayList = this.C;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                xo1 xo1Var = (xo1) obj;
                if (xo1Var.r(fp1Var.b)) {
                    xo1Var.f(fp1Var);
                    fp1Var.c.add(xo1Var);
                }
            }
        }
    }

    @Override // defpackage.xo1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final xo1 clone() {
        ba baVar = (ba) super.clone();
        baVar.C = new ArrayList();
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            xo1 xo1VarClone = ((xo1) this.C.get(i)).clone();
            baVar.C.add(xo1VarClone);
            xo1VarClone.o = baVar;
        }
        return baVar;
    }

    @Override // defpackage.xo1
    public final void k(ViewGroup viewGroup, qm0 qm0Var, qm0 qm0Var2, ArrayList arrayList, ArrayList arrayList2) {
        long j = this.h;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            xo1 xo1Var = (xo1) this.C.get(i);
            if (j > 0 && (this.D || i == 0)) {
                long j2 = xo1Var.h;
                if (j2 > 0) {
                    xo1Var.C(j2 + j);
                } else {
                    xo1Var.C(j);
                }
            }
            xo1Var.k(viewGroup, qm0Var, qm0Var2, arrayList, arrayList2);
        }
    }

    @Override // defpackage.xo1
    public final void t(ViewGroup viewGroup) {
        super.t(viewGroup);
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((xo1) this.C.get(i)).t(viewGroup);
        }
    }

    @Override // defpackage.xo1
    public final void v(View view) {
        super.v(view);
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((xo1) this.C.get(i)).v(view);
        }
    }

    @Override // defpackage.xo1
    public final void w() {
        if (this.C.isEmpty()) {
            D();
            l();
            return;
        }
        k20 k20Var = new k20();
        k20Var.h = this;
        ArrayList arrayList = this.C;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((xo1) obj).a(k20Var);
        }
        this.E = this.C.size();
        if (this.D) {
            ArrayList arrayList2 = this.C;
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                ((xo1) obj2).w();
            }
            return;
        }
        for (int i3 = 1; i3 < this.C.size(); i3++) {
            ((xo1) this.C.get(i3 - 1)).a(new k20((xo1) this.C.get(i3), 1));
        }
        xo1 xo1Var = (xo1) this.C.get(0);
        if (xo1Var != null) {
            xo1Var.w();
        }
    }

    @Override // defpackage.xo1
    public final void x(long j) {
        ArrayList arrayList;
        this.i = j;
        if (j < 0 || (arrayList = this.C) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((xo1) this.C.get(i)).x(j);
        }
    }

    @Override // defpackage.xo1
    public final void y(bf1 bf1Var) {
        this.G |= 8;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            ((xo1) this.C.get(i)).y(bf1Var);
        }
    }

    @Override // defpackage.xo1
    public final void z(LinearInterpolator linearInterpolator) {
        this.G |= 1;
        ArrayList arrayList = this.C;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((xo1) this.C.get(i)).z(linearInterpolator);
            }
        }
        this.j = linearInterpolator;
    }
}
