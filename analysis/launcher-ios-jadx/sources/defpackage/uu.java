package defpackage;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class uu {
    public kn a;
    public boolean b;
    public boolean c;
    public kn d;
    public ArrayList e;
    public om f;
    public ub g;
    public ArrayList h;

    public final void a(vu vuVar, int i, ArrayList arrayList, xc1 xc1Var) {
        hx1 hx1Var = vuVar.d;
        if (hx1Var.c == null) {
            kn knVar = this.a;
            if (hx1Var == knVar.d || hx1Var == knVar.e) {
                return;
            }
            if (xc1Var == null) {
                xc1Var = new xc1();
                xc1Var.a = null;
                xc1Var.b = new ArrayList();
                xc1Var.a = hx1Var;
                arrayList.add(xc1Var);
            }
            hx1Var.c = xc1Var;
            xc1Var.b.add(hx1Var);
            vu vuVar2 = hx1Var.h;
            ArrayList arrayList2 = vuVar2.k;
            int size = arrayList2.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                ru ruVar = (ru) obj;
                if (ruVar instanceof vu) {
                    a((vu) ruVar, i, arrayList, xc1Var);
                }
            }
            vu vuVar3 = hx1Var.i;
            ArrayList arrayList3 = vuVar3.k;
            int size2 = arrayList3.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList3.get(i4);
                i4++;
                ru ruVar2 = (ru) obj2;
                if (ruVar2 instanceof vu) {
                    a((vu) ruVar2, i, arrayList, xc1Var);
                }
            }
            if (i == 1 && (hx1Var instanceof sr1)) {
                ArrayList arrayList4 = ((sr1) hx1Var).k.k;
                int size3 = arrayList4.size();
                int i5 = 0;
                while (i5 < size3) {
                    Object obj3 = arrayList4.get(i5);
                    i5++;
                    ru ruVar3 = (ru) obj3;
                    if (ruVar3 instanceof vu) {
                        a((vu) ruVar3, i, arrayList, xc1Var);
                    }
                }
            }
            ArrayList arrayList5 = vuVar2.l;
            int size4 = arrayList5.size();
            int i6 = 0;
            while (i6 < size4) {
                Object obj4 = arrayList5.get(i6);
                i6++;
                a((vu) obj4, i, arrayList, xc1Var);
            }
            ArrayList arrayList6 = vuVar3.l;
            int size5 = arrayList6.size();
            int i7 = 0;
            while (i7 < size5) {
                Object obj5 = arrayList6.get(i7);
                i7++;
                a((vu) obj5, i, arrayList, xc1Var);
            }
            if (i == 1 && (hx1Var instanceof sr1)) {
                ArrayList arrayList7 = ((sr1) hx1Var).k.l;
                int size6 = arrayList7.size();
                while (i2 < size6) {
                    Object obj6 = arrayList7.get(i2);
                    i2++;
                    a((vu) obj6, i, arrayList, xc1Var);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x02ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(defpackage.kn r24) {
        /*
            Method dump skipped, instruction units count: 802
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uu.b(kn):void");
    }

    public final void c() {
        ArrayList arrayList = this.e;
        arrayList.clear();
        kn knVar = this.d;
        knVar.d.f();
        knVar.e.f();
        arrayList.add(knVar.d);
        arrayList.add(knVar.e);
        ArrayList arrayList2 = knVar.t0;
        int size = arrayList2.size();
        HashSet hashSet = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            jn jnVar = (jn) obj;
            if (jnVar instanceof va0) {
                wa0 wa0Var = new wa0(jnVar);
                jnVar.d.f();
                jnVar.e.f();
                wa0Var.f = ((va0) jnVar).x0;
                arrayList.add(wa0Var);
            } else {
                if (jnVar.y()) {
                    if (jnVar.b == null) {
                        jnVar.b = new hh(jnVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(jnVar.b);
                } else {
                    arrayList.add(jnVar.d);
                }
                if (jnVar.z()) {
                    if (jnVar.c == null) {
                        jnVar.c = new hh(jnVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(jnVar.c);
                } else {
                    arrayList.add(jnVar.e);
                }
                if (jnVar instanceof zb0) {
                    arrayList.add(new yb0(jnVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        int size2 = arrayList.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList.get(i2);
            i2++;
            ((hx1) obj2).f();
        }
        int size3 = arrayList.size();
        int i3 = 0;
        while (i3 < size3) {
            Object obj3 = arrayList.get(i3);
            i3++;
            hx1 hx1Var = (hx1) obj3;
            if (hx1Var.b != knVar) {
                hx1Var.d();
            }
        }
        ArrayList arrayList3 = this.h;
        arrayList3.clear();
        kn knVar2 = this.a;
        e(knVar2.d, 0, arrayList3);
        e(knVar2.e, 1, arrayList3);
        this.b = false;
    }

    public final int d(kn knVar, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        long jMax;
        float f;
        kn knVar2 = knVar;
        ArrayList arrayList2 = this.h;
        int size = arrayList2.size();
        int i4 = 0;
        long jMax2 = 0;
        while (i4 < size) {
            hx1 hx1Var = ((xc1) arrayList2.get(i4)).a;
            if (!(hx1Var instanceof hh) ? !(i != 0 ? (hx1Var instanceof sr1) : (hx1Var instanceof dc0)) : ((hh) hx1Var).f != i) {
                vu vuVar = (i == 0 ? knVar2.d : knVar2.e).h;
                vu vuVar2 = (i == 0 ? knVar2.d : knVar2.e).i;
                boolean zContains = hx1Var.h.l.contains(vuVar);
                vu vuVar3 = hx1Var.i;
                boolean zContains2 = vuVar3.l.contains(vuVar2);
                long j = hx1Var.j();
                vu vuVar4 = hx1Var.h;
                if (zContains && zContains2) {
                    long jB = xc1.b(vuVar4, 0L);
                    ArrayList arrayList3 = arrayList2;
                    i2 = size;
                    long jA = xc1.a(vuVar3, 0L);
                    long j2 = jB - j;
                    int i5 = vuVar3.f;
                    arrayList = arrayList3;
                    i3 = i4;
                    if (j2 >= (-i5)) {
                        j2 += (long) i5;
                    }
                    long j3 = (-jA) - j;
                    long j4 = vuVar4.f;
                    long j5 = j3 - j4;
                    if (j5 >= j4) {
                        j5 -= j4;
                    }
                    jn jnVar = hx1Var.b;
                    if (i == 0) {
                        f = jnVar.e0;
                    } else if (i == 1) {
                        f = jnVar.f0;
                    } else {
                        jnVar.getClass();
                        f = -1.0f;
                    }
                    float f2 = f > 0.0f ? (long) ((j2 / (1.0f - f)) + (j5 / f)) : 0L;
                    jMax = (((long) vuVar4.f) + ((((long) ((f2 * f) + 0.5f)) + j) + ((long) uo.s(1.0f, f, f2, 0.5f)))) - ((long) vuVar3.f);
                } else {
                    arrayList = arrayList2;
                    i2 = size;
                    i3 = i4;
                    jMax = zContains ? Math.max(xc1.b(vuVar4, vuVar4.f), ((long) vuVar4.f) + j) : zContains2 ? Math.max(-xc1.a(vuVar3, vuVar3.f), ((long) (-vuVar3.f)) + j) : (hx1Var.j() + ((long) vuVar4.f)) - ((long) vuVar3.f);
                }
            } else {
                arrayList = arrayList2;
                i2 = size;
                i3 = i4;
                jMax = 0;
            }
            jMax2 = Math.max(jMax2, jMax);
            i4 = i3 + 1;
            knVar2 = knVar;
            size = i2;
            arrayList2 = arrayList;
        }
        return (int) jMax2;
    }

    public final void e(hx1 hx1Var, int i, ArrayList arrayList) {
        vu vuVar;
        ArrayList arrayList2 = hx1Var.h.k;
        int size = arrayList2.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            vuVar = hx1Var.i;
            if (i3 >= size) {
                break;
            }
            Object obj = arrayList2.get(i3);
            i3++;
            ru ruVar = (ru) obj;
            if (ruVar instanceof vu) {
                a((vu) ruVar, i, arrayList, null);
            } else if (ruVar instanceof hx1) {
                a(((hx1) ruVar).h, i, arrayList, null);
            }
        }
        ArrayList arrayList3 = vuVar.k;
        int size2 = arrayList3.size();
        int i4 = 0;
        while (i4 < size2) {
            Object obj2 = arrayList3.get(i4);
            i4++;
            ru ruVar2 = (ru) obj2;
            if (ruVar2 instanceof vu) {
                a((vu) ruVar2, i, arrayList, null);
            } else if (ruVar2 instanceof hx1) {
                a(((hx1) ruVar2).i, i, arrayList, null);
            }
        }
        if (i == 1) {
            ArrayList arrayList4 = ((sr1) hx1Var).k.k;
            int size3 = arrayList4.size();
            while (i2 < size3) {
                Object obj3 = arrayList4.get(i2);
                i2++;
                ru ruVar3 = (ru) obj3;
                if (ruVar3 instanceof vu) {
                    a((vu) ruVar3, i, arrayList, null);
                }
            }
        }
    }

    public final void f(jn jnVar, in inVar, int i, in inVar2, int i2) {
        ub ubVar = this.g;
        ubVar.a = inVar;
        ubVar.b = inVar2;
        ubVar.c = i;
        ubVar.d = i2;
        this.f.b(jnVar, ubVar);
        jnVar.N(ubVar.e);
        jnVar.K(ubVar.f);
        jnVar.E = ubVar.h;
        int i3 = ubVar.g;
        jnVar.b0 = i3;
        jnVar.E = i3 > 0;
    }

    public final void g() {
        sb sbVar;
        uu uuVar = this;
        ArrayList arrayList = uuVar.a.t0;
        int size = arrayList.size();
        char c = 0;
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            jn jnVar = (jn) arrayList.get(i);
            if (!jnVar.a) {
                in[] inVarArr = jnVar.T;
                in inVar = inVarArr[c];
                in inVar2 = inVarArr[1];
                int i3 = jnVar.r;
                int i4 = jnVar.s;
                in inVar3 = in.h;
                in inVar4 = in.i;
                boolean z = inVar == inVar3 || (inVar == inVar4 && i3 == 1);
                boolean z2 = inVar2 == inVar3 || (inVar2 == inVar4 && i4 == 1);
                gv gvVar = jnVar.d.e;
                boolean z3 = gvVar.j;
                gv gvVar2 = jnVar.e.e;
                boolean z4 = gvVar2.j;
                boolean z5 = z;
                in inVar5 = in.g;
                if (z3 && z4) {
                    uuVar.f(jnVar, inVar5, gvVar.g, inVar5, gvVar2.g);
                    jnVar.a = true;
                } else if (z3 && z2) {
                    f(jnVar, inVar5, gvVar.g, inVar3, gvVar2.g);
                    if (inVar2 == inVar4) {
                        jnVar.e.e.m = jnVar.l();
                    } else {
                        jnVar.e.e.d(jnVar.l());
                        jnVar.a = true;
                    }
                } else if (z4 && z5) {
                    f(jnVar, inVar3, gvVar.g, inVar5, gvVar2.g);
                    if (inVar == inVar4) {
                        jnVar.d.e.m = jnVar.r();
                    } else {
                        jnVar.d.e.d(jnVar.r());
                        jnVar.a = true;
                    }
                }
                if (jnVar.a && (sbVar = jnVar.e.l) != null) {
                    sbVar.d(jnVar.b0);
                }
                c = 0;
                uuVar = this;
            }
            i = i2;
        }
    }
}
