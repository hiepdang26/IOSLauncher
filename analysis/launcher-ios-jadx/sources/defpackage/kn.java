package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class kn extends jn {
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public gh[] E0;
    public gh[] F0;
    public int G0;
    public boolean H0;
    public boolean I0;
    public WeakReference J0;
    public WeakReference K0;
    public WeakReference L0;
    public WeakReference M0;
    public final HashSet N0;
    public final ub O0;
    public ArrayList t0 = new ArrayList();
    public final wb2 u0 = new wb2(this);
    public final uu v0;
    public int w0;
    public om x0;
    public boolean y0;
    public final qn0 z0;

    public kn() {
        uu uuVar = new uu();
        uuVar.b = true;
        uuVar.c = true;
        uuVar.e = new ArrayList();
        new ArrayList();
        uuVar.f = null;
        uuVar.g = new ub();
        uuVar.h = new ArrayList();
        uuVar.a = this;
        uuVar.d = this;
        this.v0 = uuVar;
        this.x0 = null;
        this.y0 = false;
        this.z0 = new qn0();
        this.C0 = 0;
        this.D0 = 0;
        this.E0 = new gh[4];
        this.F0 = new gh[4];
        this.G0 = 257;
        this.H0 = false;
        this.I0 = false;
        this.J0 = null;
        this.K0 = null;
        this.L0 = null;
        this.M0 = null;
        this.N0 = new HashSet();
        this.O0 = new ub();
    }

    public static void U(jn jnVar, om omVar, ub ubVar) {
        int i;
        int i2;
        if (omVar == null) {
            return;
        }
        if (jnVar.h0 == 8 || (jnVar instanceof va0) || (jnVar instanceof sa)) {
            ubVar.e = 0;
            ubVar.f = 0;
            return;
        }
        in[] inVarArr = jnVar.T;
        ubVar.a = inVarArr[0];
        ubVar.b = inVarArr[1];
        ubVar.c = jnVar.r();
        ubVar.d = jnVar.l();
        ubVar.i = false;
        ubVar.j = 0;
        in inVar = ubVar.a;
        in inVar2 = in.i;
        boolean z = inVar == inVar2;
        boolean z2 = ubVar.b == inVar2;
        boolean z3 = z && jnVar.X > 0.0f;
        boolean z4 = z2 && jnVar.X > 0.0f;
        in inVar3 = in.h;
        in inVar4 = in.g;
        if (z && jnVar.u(0) && jnVar.r == 0 && !z3) {
            ubVar.a = inVar3;
            if (z2 && jnVar.s == 0) {
                ubVar.a = inVar4;
            }
            z = false;
        }
        if (z2 && jnVar.u(1) && jnVar.s == 0 && !z4) {
            ubVar.b = inVar3;
            if (z && jnVar.r == 0) {
                ubVar.b = inVar4;
            }
            z2 = false;
        }
        if (jnVar.B()) {
            ubVar.a = inVar4;
            z = false;
        }
        if (jnVar.C()) {
            ubVar.b = inVar4;
            z2 = false;
        }
        int[] iArr = jnVar.t;
        if (z3) {
            if (iArr[0] == 4) {
                ubVar.a = inVar4;
            } else if (!z2) {
                if (ubVar.b == inVar4) {
                    i2 = ubVar.d;
                } else {
                    ubVar.a = inVar3;
                    omVar.b(jnVar, ubVar);
                    i2 = ubVar.f;
                }
                ubVar.a = inVar4;
                ubVar.c = (int) (jnVar.X * i2);
            }
        }
        if (z4) {
            if (iArr[1] == 4) {
                ubVar.b = inVar4;
            } else if (!z) {
                if (ubVar.a == inVar4) {
                    i = ubVar.c;
                } else {
                    ubVar.b = inVar3;
                    omVar.b(jnVar, ubVar);
                    i = ubVar.e;
                }
                ubVar.b = inVar4;
                if (jnVar.Y == -1) {
                    ubVar.d = (int) (i / jnVar.X);
                } else {
                    ubVar.d = (int) (jnVar.X * i);
                }
            }
        }
        omVar.b(jnVar, ubVar);
        jnVar.N(ubVar.e);
        jnVar.K(ubVar.f);
        jnVar.E = ubVar.h;
        int i3 = ubVar.g;
        jnVar.b0 = i3;
        jnVar.E = i3 > 0;
        ubVar.j = 0;
    }

    @Override // defpackage.jn
    public final void D() {
        this.z0.t();
        this.A0 = 0;
        this.B0 = 0;
        this.t0.clear();
        super.D();
    }

    @Override // defpackage.jn
    public final void F(wb2 wb2Var) {
        super.F(wb2Var);
        int size = this.t0.size();
        for (int i = 0; i < size; i++) {
            ((jn) this.t0.get(i)).F(wb2Var);
        }
    }

    @Override // defpackage.jn
    public final void O(boolean z, boolean z2) {
        super.O(z, z2);
        int size = this.t0.size();
        for (int i = 0; i < size; i++) {
            ((jn) this.t0.get(i)).O(z, z2);
        }
    }

    public final void Q(jn jnVar, int i) {
        if (i == 0) {
            int i2 = this.C0 + 1;
            gh[] ghVarArr = this.F0;
            if (i2 >= ghVarArr.length) {
                this.F0 = (gh[]) Arrays.copyOf(ghVarArr, ghVarArr.length * 2);
            }
            gh[] ghVarArr2 = this.F0;
            int i3 = this.C0;
            ghVarArr2[i3] = new gh(jnVar, 0, this.y0);
            this.C0 = i3 + 1;
            return;
        }
        if (i == 1) {
            int i4 = this.D0 + 1;
            gh[] ghVarArr3 = this.E0;
            if (i4 >= ghVarArr3.length) {
                this.E0 = (gh[]) Arrays.copyOf(ghVarArr3, ghVarArr3.length * 2);
            }
            gh[] ghVarArr4 = this.E0;
            int i5 = this.D0;
            ghVarArr4[i5] = new gh(jnVar, 1, this.y0);
            this.D0 = i5 + 1;
        }
    }

    public final void R(qn0 qn0Var) {
        kn knVar;
        qn0 qn0Var2;
        boolean zV = V(64);
        c(qn0Var, zV);
        int size = this.t0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            jn jnVar = (jn) this.t0.get(i);
            boolean[] zArr = jnVar.S;
            zArr[0] = false;
            zArr[1] = false;
            if (jnVar instanceof sa) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                jn jnVar2 = (jn) this.t0.get(i2);
                if (jnVar2 instanceof sa) {
                    sa saVar = (sa) jnVar2;
                    for (int i3 = 0; i3 < saVar.u0; i3++) {
                        jn jnVar3 = saVar.t0[i3];
                        if (saVar.w0 || jnVar3.d()) {
                            int i4 = saVar.v0;
                            if (i4 == 0 || i4 == 1) {
                                jnVar3.S[0] = true;
                            } else if (i4 == 2 || i4 == 3) {
                                jnVar3.S[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.N0;
        hashSet.clear();
        for (int i5 = 0; i5 < size; i5++) {
            jn jnVar4 = (jn) this.t0.get(i5);
            jnVar4.getClass();
            boolean z2 = jnVar4 instanceof vu1;
            if (z2 || (jnVar4 instanceof va0)) {
                if (z2) {
                    hashSet.add(jnVar4);
                } else {
                    jnVar4.c(qn0Var, zV);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                vu1 vu1Var = (vu1) ((jn) it.next());
                for (int i6 = 0; i6 < vu1Var.u0; i6++) {
                    if (hashSet.contains(vu1Var.t0[i6])) {
                        vu1Var.c(qn0Var, zV);
                        hashSet.remove(vu1Var);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((jn) it2.next()).c(qn0Var, zV);
                }
                hashSet.clear();
            }
        }
        boolean z3 = qn0.q;
        in inVar = in.h;
        if (z3) {
            HashSet<jn> hashSet2 = new HashSet();
            for (int i7 = 0; i7 < size; i7++) {
                jn jnVar5 = (jn) this.t0.get(i7);
                jnVar5.getClass();
                if (!(jnVar5 instanceof vu1) && !(jnVar5 instanceof va0)) {
                    hashSet2.add(jnVar5);
                }
            }
            knVar = this;
            qn0Var2 = qn0Var;
            knVar.b(this, qn0Var2, hashSet2, this.T[0] == inVar ? 0 : 1, false);
            for (jn jnVar6 : hashSet2) {
                az1.c(this, qn0Var2, jnVar6);
                jnVar6.c(qn0Var2, zV);
            }
        } else {
            knVar = this;
            qn0Var2 = qn0Var;
            for (int i8 = 0; i8 < size; i8++) {
                jn jnVar7 = (jn) knVar.t0.get(i8);
                if (jnVar7 instanceof kn) {
                    in[] inVarArr = jnVar7.T;
                    in inVar2 = inVarArr[0];
                    in inVar3 = inVarArr[1];
                    in inVar4 = in.g;
                    if (inVar2 == inVar) {
                        jnVar7.L(inVar4);
                    }
                    if (inVar3 == inVar) {
                        jnVar7.M(inVar4);
                    }
                    jnVar7.c(qn0Var2, zV);
                    if (inVar2 == inVar) {
                        jnVar7.L(inVar2);
                    }
                    if (inVar3 == inVar) {
                        jnVar7.M(inVar3);
                    }
                } else {
                    az1.c(this, qn0Var2, jnVar7);
                    if (!(jnVar7 instanceof vu1) && !(jnVar7 instanceof va0)) {
                        jnVar7.c(qn0Var2, zV);
                    }
                }
            }
        }
        if (knVar.C0 > 0) {
            e42.a(this, qn0Var2, null, 0);
        }
        if (knVar.D0 > 0) {
            e42.a(this, qn0Var2, null, 1);
        }
    }

    public final boolean S(int i, boolean z) {
        boolean z2;
        in inVar;
        boolean z3;
        uu uuVar = this.v0;
        kn knVar = uuVar.a;
        boolean z4 = false;
        in inVarK = knVar.k(0);
        in inVarK2 = knVar.k(1);
        int iS = knVar.s();
        int iT = knVar.t();
        ArrayList arrayList = uuVar.e;
        in inVar2 = in.g;
        if (z && (inVarK == (inVar = in.h) || inVarK2 == inVar)) {
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z3 = z;
                    break;
                }
                Object obj = arrayList.get(i2);
                i2++;
                hx1 hx1Var = (hx1) obj;
                if (hx1Var.f == i && !hx1Var.k()) {
                    z3 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z3 && inVarK == inVar) {
                    knVar.L(inVar2);
                    knVar.N(uuVar.d(knVar, 0));
                    knVar.d.e.d(knVar.r());
                }
            } else if (z3 && inVarK2 == inVar) {
                knVar.M(inVar2);
                knVar.K(uuVar.d(knVar, 1));
                knVar.e.e.d(knVar.l());
            }
        }
        in inVar3 = in.j;
        if (i == 0) {
            in inVar4 = knVar.T[0];
            if (inVar4 == inVar2 || inVar4 == inVar3) {
                int iR = knVar.r() + iS;
                knVar.d.i.d(iR);
                knVar.d.e.d(iR - iS);
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            in inVar5 = knVar.T[1];
            if (inVar5 == inVar2 || inVar5 == inVar3) {
                int iL = knVar.l() + iT;
                knVar.e.i.d(iL);
                knVar.e.e.d(iL - iT);
                z2 = true;
            } else {
                z2 = false;
            }
        }
        uuVar.g();
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            hx1 hx1Var2 = (hx1) obj2;
            if (hx1Var2.f == i && (hx1Var2.b != knVar || hx1Var2.g)) {
                hx1Var2.e();
            }
        }
        int size3 = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size3) {
                z4 = true;
                break;
            }
            Object obj3 = arrayList.get(i4);
            i4++;
            hx1 hx1Var3 = (hx1) obj3;
            if (hx1Var3.f == i && (z2 || hx1Var3.b != knVar)) {
                if (!hx1Var3.h.j || !hx1Var3.i.j || (!(hx1Var3 instanceof hh) && !hx1Var3.e.j)) {
                    break;
                }
            }
        }
        knVar.L(inVarK);
        knVar.M(inVarK2);
        return z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:338:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x062f  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x069c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x06d9  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x07d0  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0859 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:507:0x08c1  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x08d3  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x08ef  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x08fb  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0936 A[PHI: r15 r25
  0x0936: PHI (r15v10 boolean) = (r15v9 boolean), (r15v14 boolean), (r15v14 boolean), (r15v14 boolean) binds: [B:515:0x08fc, B:523:0x091e, B:524:0x0920, B:526:0x0926] A[DONT_GENERATE, DONT_INLINE]
  0x0936: PHI (r25v6 boolean) = (r25v5 boolean), (r25v7 boolean), (r25v7 boolean), (r25v7 boolean) binds: [B:515:0x08fc, B:523:0x091e, B:524:0x0920, B:526:0x0926] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:530:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x094c  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x093d A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T() {
        /*
            Method dump skipped, instruction units count: 2396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kn.T():void");
    }

    public final boolean V(int i) {
        return (this.G0 & i) == i;
    }

    @Override // defpackage.jn
    public final void o(StringBuilder sb) {
        sb.append(this.j + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.V);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.W);
        sb.append("\n");
        ArrayList arrayList = this.t0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((jn) obj).o(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
