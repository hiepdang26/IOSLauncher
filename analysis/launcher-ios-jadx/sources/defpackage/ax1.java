package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ax1 {
    public static int f;
    public ArrayList a;
    public int b;
    public int c;
    public ArrayList d;
    public int e;

    public final void a(ArrayList arrayList) {
        int size = this.a.size();
        if (this.e != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                ax1 ax1Var = (ax1) arrayList.get(i);
                if (this.e == ax1Var.b) {
                    c(this.c, ax1Var);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(qn0 qn0Var, int i) {
        int iN;
        int iN2;
        ArrayList arrayList = this.a;
        if (arrayList.size() == 0) {
            return 0;
        }
        kn knVar = (kn) ((jn) arrayList.get(0)).U;
        qn0Var.t();
        knVar.c(qn0Var, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((jn) arrayList.get(i2)).c(qn0Var, false);
        }
        if (i == 0 && knVar.C0 > 0) {
            e42.a(knVar, qn0Var, arrayList, 0);
        }
        if (i == 1 && knVar.D0 > 0) {
            e42.a(knVar, qn0Var, arrayList, 1);
        }
        try {
            qn0Var.p();
        } catch (Exception e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.d = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            jn jnVar = (jn) arrayList.get(i3);
            b21 b21Var = new b21(9);
            new WeakReference(jnVar);
            qn0.n(jnVar.I);
            qn0.n(jnVar.J);
            qn0.n(jnVar.K);
            qn0.n(jnVar.L);
            qn0.n(jnVar.M);
            this.d.add(b21Var);
        }
        if (i == 0) {
            iN = qn0.n(knVar.I);
            iN2 = qn0.n(knVar.K);
            qn0Var.t();
        } else {
            iN = qn0.n(knVar.J);
            iN2 = qn0.n(knVar.L);
            qn0Var.t();
        }
        return iN2 - iN;
    }

    public final void c(int i, ax1 ax1Var) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            jn jnVar = (jn) obj;
            ArrayList arrayList2 = ax1Var.a;
            if (!arrayList2.contains(jnVar)) {
                arrayList2.add(jnVar);
            }
            int i3 = ax1Var.b;
            if (i == 0) {
                jnVar.r0 = i3;
            } else {
                jnVar.s0 = i3;
            }
        }
        this.e = ax1Var.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.c;
        sb.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb.append(" [");
        String strJ = uo.j(sb, this.b, "] <");
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            StringBuilder sbM = k31.m(strJ, " ");
            sbM.append(((jn) obj).j0);
            strJ = sbM.toString();
        }
        return uo.h(strJ, " >");
    }
}
