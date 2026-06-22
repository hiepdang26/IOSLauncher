package defpackage;

import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class jn {
    public int A;
    public float B;
    public int[] C;
    public float D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public final gm I;
    public final gm J;
    public final gm K;
    public final gm L;
    public final gm M;
    public final gm N;
    public final gm O;
    public final gm P;
    public final gm[] Q;
    public final ArrayList R;
    public final boolean[] S;
    public in[] T;
    public jn U;
    public int V;
    public int W;
    public float X;
    public int Y;
    public int Z;
    public int a0;
    public hh b;
    public int b0;
    public hh c;
    public int c0;
    public int d0;
    public float e0;
    public float f0;
    public View g0;
    public int h0;
    public boolean i0;
    public String j;
    public String j0;
    public boolean k;
    public int k0;
    public boolean l;
    public int l0;
    public boolean m;
    public final float[] m0;
    public boolean n;
    public final jn[] n0;
    public int o;
    public final jn[] o0;
    public int p;
    public jn p0;
    public int q;
    public jn q0;
    public int r;
    public int r0;
    public int s;
    public int s0;
    public final int[] t;
    public int u;
    public int v;
    public float w;
    public int x;
    public int y;
    public float z;
    public boolean a = false;
    public dc0 d = null;
    public sr1 e = null;
    public final boolean[] f = {true, true};
    public boolean g = true;
    public int h = -1;
    public int i = -1;

    public jn() {
        new HashMap();
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = new int[2];
        this.u = 0;
        this.v = 0;
        this.w = 1.0f;
        this.x = 0;
        this.y = 0;
        this.z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
        this.D = Float.NaN;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        gm gmVar = new gm(this, 2);
        this.I = gmVar;
        gm gmVar2 = new gm(this, 3);
        this.J = gmVar2;
        gm gmVar3 = new gm(this, 4);
        this.K = gmVar3;
        gm gmVar4 = new gm(this, 5);
        this.L = gmVar4;
        gm gmVar5 = new gm(this, 6);
        this.M = gmVar5;
        gm gmVar6 = new gm(this, 8);
        this.N = gmVar6;
        gm gmVar7 = new gm(this, 9);
        this.O = gmVar7;
        gm gmVar8 = new gm(this, 7);
        this.P = gmVar8;
        this.Q = new gm[]{gmVar, gmVar3, gmVar2, gmVar4, gmVar5, gmVar8};
        ArrayList arrayList = new ArrayList();
        this.R = arrayList;
        this.S = new boolean[2];
        in inVar = in.g;
        this.T = new in[]{inVar, inVar};
        this.U = null;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.e0 = 0.5f;
        this.f0 = 0.5f;
        this.h0 = 0;
        this.i0 = false;
        this.j0 = null;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = new float[]{-1.0f, -1.0f};
        this.n0 = new jn[]{null, null};
        this.o0 = new jn[]{null, null};
        this.p0 = null;
        this.q0 = null;
        this.r0 = -1;
        this.s0 = -1;
        arrayList.add(gmVar);
        arrayList.add(gmVar2);
        arrayList.add(gmVar3);
        arrayList.add(gmVar4);
        arrayList.add(gmVar6);
        arrayList.add(gmVar7);
        arrayList.add(gmVar8);
        arrayList.add(gmVar5);
    }

    public static void G(int i, int i2, String str, StringBuilder sb) {
        if (i == i2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    public static void H(StringBuilder sb, String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    public static void p(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, float f, in inVar) {
        sb.append(str);
        sb.append(" :  {\n");
        String string = inVar.toString();
        if (!"FIXED".equals(string)) {
            sb.append("      behavior");
            sb.append(" :   ");
            sb.append(string);
            sb.append(",\n");
        }
        G(i, 0, "      size", sb);
        G(i2, 0, "      min", sb);
        G(i3, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, "      max", sb);
        G(i4, 0, "      matchMin", sb);
        G(i5, 0, "      matchDef", sb);
        H(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    public static void q(StringBuilder sb, String str, gm gmVar) {
        if (gmVar.f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(gmVar.f);
        sb.append("'");
        if (gmVar.h != Integer.MIN_VALUE || gmVar.g != 0) {
            sb.append(",");
            sb.append(gmVar.g);
            if (gmVar.h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(gmVar.h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public final boolean A() {
        return this.g && this.h0 != 8;
    }

    public boolean B() {
        if (this.k) {
            return true;
        }
        return this.I.c && this.K.c;
    }

    public boolean C() {
        if (this.l) {
            return true;
        }
        return this.J.c && this.L.c;
    }

    public void D() {
        this.I.j();
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.U = null;
        this.D = Float.NaN;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0.5f;
        this.f0 = 0.5f;
        in[] inVarArr = this.T;
        in inVar = in.g;
        inVarArr[0] = inVar;
        inVarArr[1] = inVar;
        this.g0 = null;
        this.h0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        float[] fArr = this.m0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.o = -1;
        this.p = -1;
        int[] iArr = this.C;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.r = 0;
        this.s = 0;
        this.w = 1.0f;
        this.z = 1.0f;
        this.v = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.y = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.u = 0;
        this.x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        this.F = false;
        boolean[] zArr2 = this.S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.g = true;
        int[] iArr2 = this.t;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.h = -1;
        this.i = -1;
    }

    public final void E() {
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        ArrayList arrayList = this.R;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            gm gmVar = (gm) arrayList.get(i);
            gmVar.c = false;
            gmVar.b = 0;
        }
    }

    public void F(wb2 wb2Var) {
        this.I.k();
        this.J.k();
        this.K.k();
        this.L.k();
        this.M.k();
        this.P.k();
        this.N.k();
        this.O.k();
    }

    public final void I(int i, int i2) {
        if (this.k) {
            return;
        }
        this.I.l(i);
        this.K.l(i2);
        this.Z = i;
        this.V = i2 - i;
        this.k = true;
    }

    public final void J(int i, int i2) {
        if (this.l) {
            return;
        }
        this.J.l(i);
        this.L.l(i2);
        this.a0 = i;
        this.W = i2 - i;
        if (this.E) {
            this.M.l(i + this.b0);
        }
        this.l = true;
    }

    public final void K(int i) {
        this.W = i;
        int i2 = this.d0;
        if (i < i2) {
            this.W = i2;
        }
    }

    public final void L(in inVar) {
        this.T[0] = inVar;
    }

    public final void M(in inVar) {
        this.T[1] = inVar;
    }

    public final void N(int i) {
        this.V = i;
        int i2 = this.c0;
        if (i < i2) {
            this.V = i2;
        }
    }

    public void O(boolean z, boolean z2) {
        int i;
        int i2;
        dc0 dc0Var = this.d;
        boolean z3 = z & dc0Var.g;
        sr1 sr1Var = this.e;
        boolean z4 = z2 & sr1Var.g;
        int i3 = dc0Var.h.g;
        int i4 = sr1Var.h.g;
        int i5 = dc0Var.i.g;
        int i6 = sr1Var.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.Z = i3;
        }
        if (z4) {
            this.a0 = i4;
        }
        if (this.h0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        in inVar = in.g;
        if (z3) {
            if (this.T[0] == inVar && i8 < (i2 = this.V)) {
                i8 = i2;
            }
            this.V = i8;
            int i10 = this.c0;
            if (i8 < i10) {
                this.V = i10;
            }
        }
        if (z4) {
            if (this.T[1] == inVar && i9 < (i = this.W)) {
                i9 = i;
            }
            this.W = i9;
            int i11 = this.d0;
            if (i9 < i11) {
                this.W = i11;
            }
        }
    }

    public void P(qn0 qn0Var, boolean z) {
        int i;
        int i2;
        sr1 sr1Var;
        dc0 dc0Var;
        gm gmVar = this.I;
        qn0Var.getClass();
        int iN = qn0.n(gmVar);
        int iN2 = qn0.n(this.J);
        int iN3 = qn0.n(this.K);
        int iN4 = qn0.n(this.L);
        if (z && (dc0Var = this.d) != null) {
            vu vuVar = dc0Var.h;
            if (vuVar.j) {
                vu vuVar2 = dc0Var.i;
                if (vuVar2.j) {
                    iN = vuVar.g;
                    iN3 = vuVar2.g;
                }
            }
        }
        if (z && (sr1Var = this.e) != null) {
            vu vuVar3 = sr1Var.h;
            if (vuVar3.j) {
                vu vuVar4 = sr1Var.i;
                if (vuVar4.j) {
                    iN2 = vuVar3.g;
                    iN4 = vuVar4.g;
                }
            }
        }
        int i3 = iN4 - iN2;
        if (iN3 - iN < 0 || i3 < 0 || iN == Integer.MIN_VALUE || iN == Integer.MAX_VALUE || iN2 == Integer.MIN_VALUE || iN2 == Integer.MAX_VALUE || iN3 == Integer.MIN_VALUE || iN3 == Integer.MAX_VALUE || iN4 == Integer.MIN_VALUE || iN4 == Integer.MAX_VALUE) {
            iN = 0;
            iN2 = 0;
            iN3 = 0;
            iN4 = 0;
        }
        int i4 = iN3 - iN;
        int i5 = iN4 - iN2;
        this.Z = iN;
        this.a0 = iN2;
        if (this.h0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        in[] inVarArr = this.T;
        in inVar = inVarArr[0];
        in inVar2 = in.g;
        if (inVar == inVar2 && i4 < (i2 = this.V)) {
            i4 = i2;
        }
        if (inVarArr[1] == inVar2 && i5 < (i = this.W)) {
            i5 = i;
        }
        this.V = i4;
        this.W = i5;
        int i6 = this.d0;
        if (i5 < i6) {
            this.W = i6;
        }
        int i7 = this.c0;
        if (i4 < i7) {
            this.V = i7;
        }
        int i8 = this.v;
        in inVar3 = in.i;
        if (i8 > 0 && inVar == inVar3) {
            this.V = Math.min(this.V, i8);
        }
        int i9 = this.y;
        if (i9 > 0 && this.T[1] == inVar3) {
            this.W = Math.min(this.W, i9);
        }
        int i10 = this.V;
        if (i4 != i10) {
            this.h = i10;
        }
        int i11 = this.W;
        if (i5 != i11) {
            this.i = i11;
        }
    }

    public final void b(kn knVar, qn0 qn0Var, HashSet hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            az1.c(knVar, qn0Var, this);
            hashSet.remove(this);
            c(qn0Var, knVar.V(64));
        }
        if (i == 0) {
            HashSet hashSet2 = this.I.a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((gm) it.next()).d.b(knVar, qn0Var, hashSet, i, true);
                }
            }
            HashSet hashSet3 = this.K.a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((gm) it2.next()).d.b(knVar, qn0Var, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.J.a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((gm) it3.next()).d.b(knVar, qn0Var, hashSet, i, true);
            }
        }
        HashSet hashSet5 = this.L.a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((gm) it4.next()).d.b(knVar, qn0Var, hashSet, i, true);
            }
        }
        HashSet hashSet6 = this.M.a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((gm) it5.next()).d.b(knVar, qn0Var, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(defpackage.qn0 r61, boolean r62) {
        /*
            Method dump skipped, instruction units count: 1920
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jn.c(qn0, boolean):void");
    }

    public boolean d() {
        return this.h0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:216:0x03a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0477 A[PHI: r3
  0x0477: PHI (r3v16 int) = (r3v15 int), (r3v20 int), (r3v20 int), (r3v20 int) binds: [B:279:0x0467, B:281:0x046d, B:282:0x046f, B:284:0x0473] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x04b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:344:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(defpackage.qn0 r30, boolean r31, boolean r32, boolean r33, boolean r34, defpackage.di1 r35, defpackage.di1 r36, defpackage.in r37, boolean r38, defpackage.gm r39, defpackage.gm r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, int r51, int r52, int r53, int r54, float r55, boolean r56) {
        /*
            Method dump skipped, instruction units count: 1296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jn.e(qn0, boolean, boolean, boolean, boolean, di1, di1, in, boolean, gm, gm, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void f(int i, jn jnVar, int i2) {
        boolean z;
        if (i == 7) {
            if (i2 != 7) {
                if (i2 == 2 || i2 == 4) {
                    f(2, jnVar, i2);
                    f(4, jnVar, i2);
                    j(7).a(jnVar.j(i2));
                    return;
                } else {
                    if (i2 == 3 || i2 == 5) {
                        f(3, jnVar, i2);
                        f(5, jnVar, i2);
                        j(7).a(jnVar.j(i2));
                        return;
                    }
                    return;
                }
            }
            gm gmVarJ = j(2);
            gm gmVarJ2 = j(4);
            gm gmVarJ3 = j(3);
            gm gmVarJ4 = j(5);
            boolean z2 = false;
            if ((gmVarJ == null || !gmVarJ.h()) && (gmVarJ2 == null || !gmVarJ2.h())) {
                f(2, jnVar, 2);
                f(4, jnVar, 4);
                z = true;
            } else {
                z = false;
            }
            if ((gmVarJ3 == null || !gmVarJ3.h()) && (gmVarJ4 == null || !gmVarJ4.h())) {
                f(3, jnVar, 3);
                f(5, jnVar, 5);
                z2 = true;
            }
            if (z && z2) {
                j(7).a(jnVar.j(7));
                return;
            } else if (z) {
                j(8).a(jnVar.j(8));
                return;
            } else {
                if (z2) {
                    j(9).a(jnVar.j(9));
                    return;
                }
                return;
            }
        }
        if (i == 8 && (i2 == 2 || i2 == 4)) {
            gm gmVarJ5 = j(2);
            gm gmVarJ6 = jnVar.j(i2);
            gm gmVarJ7 = j(4);
            gmVarJ5.a(gmVarJ6);
            gmVarJ7.a(gmVarJ6);
            j(8).a(gmVarJ6);
            return;
        }
        if (i == 9 && (i2 == 3 || i2 == 5)) {
            gm gmVarJ8 = jnVar.j(i2);
            j(3).a(gmVarJ8);
            j(5).a(gmVarJ8);
            j(9).a(gmVarJ8);
            return;
        }
        if (i == 8 && i2 == 8) {
            j(2).a(jnVar.j(2));
            j(4).a(jnVar.j(4));
            j(8).a(jnVar.j(i2));
            return;
        }
        if (i == 9 && i2 == 9) {
            j(3).a(jnVar.j(3));
            j(5).a(jnVar.j(5));
            j(9).a(jnVar.j(i2));
            return;
        }
        gm gmVarJ9 = j(i);
        gm gmVarJ10 = jnVar.j(i2);
        if (gmVarJ9.i(gmVarJ10)) {
            if (i == 6) {
                gm gmVarJ11 = j(3);
                gm gmVarJ12 = j(5);
                if (gmVarJ11 != null) {
                    gmVarJ11.j();
                }
                if (gmVarJ12 != null) {
                    gmVarJ12.j();
                }
            } else if (i == 3 || i == 5) {
                gm gmVarJ13 = j(6);
                if (gmVarJ13 != null) {
                    gmVarJ13.j();
                }
                gm gmVarJ14 = j(7);
                if (gmVarJ14.f != gmVarJ10) {
                    gmVarJ14.j();
                }
                gm gmVarF = j(i).f();
                gm gmVarJ15 = j(9);
                if (gmVarJ15.h()) {
                    gmVarF.j();
                    gmVarJ15.j();
                }
            } else if (i == 2 || i == 4) {
                gm gmVarJ16 = j(7);
                if (gmVarJ16.f != gmVarJ10) {
                    gmVarJ16.j();
                }
                gm gmVarF2 = j(i).f();
                gm gmVarJ17 = j(8);
                if (gmVarJ17.h()) {
                    gmVarF2.j();
                    gmVarJ17.j();
                }
            }
            gmVarJ9.a(gmVarJ10);
        }
    }

    public void g(jn jnVar, HashMap map) {
        this.o = jnVar.o;
        this.p = jnVar.p;
        this.r = jnVar.r;
        this.s = jnVar.s;
        int[] iArr = jnVar.t;
        int i = iArr[0];
        int[] iArr2 = this.t;
        iArr2[0] = i;
        iArr2[1] = iArr[1];
        this.u = jnVar.u;
        this.v = jnVar.v;
        this.x = jnVar.x;
        this.y = jnVar.y;
        this.z = jnVar.z;
        this.A = jnVar.A;
        this.B = jnVar.B;
        int[] iArr3 = jnVar.C;
        this.C = Arrays.copyOf(iArr3, iArr3.length);
        this.D = jnVar.D;
        this.E = jnVar.E;
        this.I.j();
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.T = (in[]) Arrays.copyOf(this.T, 2);
        this.U = this.U == null ? null : (jn) map.get(jnVar.U);
        this.V = jnVar.V;
        this.W = jnVar.W;
        this.X = jnVar.X;
        this.Y = jnVar.Y;
        this.Z = jnVar.Z;
        this.a0 = jnVar.a0;
        this.b0 = jnVar.b0;
        this.c0 = jnVar.c0;
        this.d0 = jnVar.d0;
        this.e0 = jnVar.e0;
        this.f0 = jnVar.f0;
        this.g0 = jnVar.g0;
        this.h0 = jnVar.h0;
        this.i0 = jnVar.i0;
        this.j0 = jnVar.j0;
        this.k0 = jnVar.k0;
        this.l0 = jnVar.l0;
        float[] fArr = jnVar.m0;
        float f = fArr[0];
        float[] fArr2 = this.m0;
        fArr2[0] = f;
        fArr2[1] = fArr[1];
        jn[] jnVarArr = jnVar.n0;
        jn jnVar2 = jnVarArr[0];
        jn[] jnVarArr2 = this.n0;
        jnVarArr2[0] = jnVar2;
        jnVarArr2[1] = jnVarArr[1];
        jn[] jnVarArr3 = jnVar.o0;
        jn jnVar3 = jnVarArr3[0];
        jn[] jnVarArr4 = this.o0;
        jnVarArr4[0] = jnVar3;
        jnVarArr4[1] = jnVarArr3[1];
        jn jnVar4 = jnVar.p0;
        this.p0 = jnVar4 == null ? null : (jn) map.get(jnVar4);
        jn jnVar5 = jnVar.q0;
        this.q0 = jnVar5 != null ? (jn) map.get(jnVar5) : null;
    }

    public final void h(qn0 qn0Var) {
        qn0Var.k(this.I);
        qn0Var.k(this.J);
        qn0Var.k(this.K);
        qn0Var.k(this.L);
        if (this.b0 > 0) {
            qn0Var.k(this.M);
        }
    }

    public final void i() {
        if (this.d == null) {
            dc0 dc0Var = new dc0(this);
            dc0Var.h.e = 4;
            dc0Var.i.e = 5;
            dc0Var.f = 0;
            this.d = dc0Var;
        }
        if (this.e == null) {
            sr1 sr1Var = new sr1(this);
            vu vuVar = new vu(sr1Var);
            sr1Var.k = vuVar;
            sr1Var.l = null;
            sr1Var.h.e = 6;
            sr1Var.i.e = 7;
            vuVar.e = 8;
            sr1Var.f = 1;
            this.e = sr1Var;
        }
    }

    public gm j(int i) {
        switch (uo.v(i)) {
            case 0:
                return null;
            case 1:
                return this.I;
            case 2:
                return this.J;
            case 3:
                return this.K;
            case 4:
                return this.L;
            case 5:
                return this.M;
            case 6:
                return this.P;
            case 7:
                return this.N;
            case 8:
                return this.O;
            default:
                throw new AssertionError(uo.u(i));
        }
    }

    public final in k(int i) {
        if (i == 0) {
            return this.T[0];
        }
        if (i == 1) {
            return this.T[1];
        }
        return null;
    }

    public final int l() {
        if (this.h0 == 8) {
            return 0;
        }
        return this.W;
    }

    public final jn m(int i) {
        gm gmVar;
        gm gmVar2;
        if (i != 0) {
            if (i == 1 && (gmVar2 = (gmVar = this.L).f) != null && gmVar2.f == gmVar) {
                return gmVar2.d;
            }
            return null;
        }
        gm gmVar3 = this.K;
        gm gmVar4 = gmVar3.f;
        if (gmVar4 == null || gmVar4.f != gmVar3) {
            return null;
        }
        return gmVar4.d;
    }

    public final jn n(int i) {
        gm gmVar;
        gm gmVar2;
        if (i != 0) {
            if (i == 1 && (gmVar2 = (gmVar = this.J).f) != null && gmVar2.f == gmVar) {
                return gmVar2.d;
            }
            return null;
        }
        gm gmVar3 = this.I;
        gm gmVar4 = gmVar3.f;
        if (gmVar4 == null || gmVar4.f != gmVar3) {
            return null;
        }
        return gmVar4.d;
    }

    public void o(StringBuilder sb) {
        sb.append("  " + this.j + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.V);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.W);
        sb.append("\n");
        sb.append("    actualLeft:" + this.Z);
        sb.append("\n");
        sb.append("    actualTop:" + this.a0);
        sb.append("\n");
        q(sb, "left", this.I);
        q(sb, "top", this.J);
        q(sb, "right", this.K);
        q(sb, "bottom", this.L);
        q(sb, "baseline", this.M);
        q(sb, "centerX", this.N);
        q(sb, "centerY", this.O);
        int i = this.V;
        int i2 = this.c0;
        int i3 = this.C[0];
        int i4 = this.u;
        int i5 = this.r;
        float f = this.w;
        in inVar = this.T[0];
        float[] fArr = this.m0;
        float f2 = fArr[0];
        p(sb, "    width", i, i2, i3, i4, i5, f, inVar);
        int i6 = this.W;
        int i7 = this.d0;
        int i8 = this.C[1];
        int i9 = this.x;
        int i10 = this.s;
        float f3 = this.z;
        in inVar2 = this.T[1];
        float f4 = fArr[1];
        p(sb, "    height", i6, i7, i8, i9, i10, f3, inVar2);
        float f5 = this.X;
        int i11 = this.Y;
        if (f5 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f5);
            sb.append(",");
            sb.append(i11);
            sb.append("");
            sb.append("],\n");
        }
        H(sb, "    horizontalBias", this.e0, 0.5f);
        H(sb, "    verticalBias", this.f0, 0.5f);
        G(this.k0, 0, "    horizontalChainStyle", sb);
        G(this.l0, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public final int r() {
        if (this.h0 == 8) {
            return 0;
        }
        return this.V;
    }

    public final int s() {
        jn jnVar = this.U;
        return (jnVar == null || !(jnVar instanceof kn)) ? this.Z : ((kn) jnVar).A0 + this.Z;
    }

    public final int t() {
        jn jnVar = this.U;
        return (jnVar == null || !(jnVar instanceof kn)) ? this.a0 : ((kn) jnVar).B0 + this.a0;
    }

    public String toString() {
        StringBuilder sbM = uo.m("");
        sbM.append(this.j0 != null ? uo.k(new StringBuilder("id: "), this.j0, " ") : "");
        sbM.append("(");
        sbM.append(this.Z);
        sbM.append(", ");
        sbM.append(this.a0);
        sbM.append(") - (");
        sbM.append(this.V);
        sbM.append(" x ");
        return uo.j(sbM, this.W, ")");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean u(int r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L1b
            gm r5 = r4.I
            gm r5 = r5.f
            if (r5 == 0) goto Ld
            r5 = 1
            goto Le
        Ld:
            r5 = 0
        Le:
            gm r3 = r4.K
            gm r3 = r3.f
            if (r3 == 0) goto L16
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r5 = r5 + r3
            if (r5 >= r0) goto L3b
            goto L3a
        L1b:
            gm r5 = r4.J
            gm r5 = r5.f
            if (r5 == 0) goto L23
            r5 = 1
            goto L24
        L23:
            r5 = 0
        L24:
            gm r3 = r4.L
            gm r3 = r3.f
            if (r3 == 0) goto L2c
            r3 = 1
            goto L2d
        L2c:
            r3 = 0
        L2d:
            int r5 = r5 + r3
            gm r3 = r4.M
            gm r3 = r3.f
            if (r3 == 0) goto L36
            r3 = 1
            goto L37
        L36:
            r3 = 0
        L37:
            int r5 = r5 + r3
            if (r5 >= r0) goto L3b
        L3a:
            return r2
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jn.u(int):boolean");
    }

    public final boolean v(int i, int i2) {
        gm gmVar;
        gm gmVar2;
        gm gmVar3;
        gm gmVar4;
        if (i == 0) {
            gm gmVar5 = this.I;
            gm gmVar6 = gmVar5.f;
            if (gmVar6 == null || !gmVar6.c || (gmVar4 = (gmVar3 = this.K).f) == null || !gmVar4.c) {
                return false;
            }
            return (gmVar4.d() - gmVar3.e()) - (gmVar5.e() + gmVar5.f.d()) >= i2;
        }
        gm gmVar7 = this.J;
        gm gmVar8 = gmVar7.f;
        if (gmVar8 == null || !gmVar8.c || (gmVar2 = (gmVar = this.L).f) == null || !gmVar2.c) {
            return false;
        }
        return (gmVar2.d() - gmVar.e()) - (gmVar7.e() + gmVar7.f.d()) >= i2;
    }

    public final void w(int i, jn jnVar, int i2, int i3, int i4) {
        j(i).b(jnVar.j(i2), i3, i4, true);
    }

    public final boolean x(int i) {
        gm gmVar;
        gm gmVar2;
        int i2 = i * 2;
        gm[] gmVarArr = this.Q;
        gm gmVar3 = gmVarArr[i2];
        gm gmVar4 = gmVar3.f;
        return (gmVar4 == null || gmVar4.f == gmVar3 || (gmVar2 = (gmVar = gmVarArr[i2 + 1]).f) == null || gmVar2.f != gmVar) ? false : true;
    }

    public final boolean y() {
        gm gmVar = this.I;
        gm gmVar2 = gmVar.f;
        if (gmVar2 != null && gmVar2.f == gmVar) {
            return true;
        }
        gm gmVar3 = this.K;
        gm gmVar4 = gmVar3.f;
        return gmVar4 != null && gmVar4.f == gmVar3;
    }

    public final boolean z() {
        gm gmVar = this.J;
        gm gmVar2 = gmVar.f;
        if (gmVar2 != null && gmVar2.f == gmVar) {
            return true;
        }
        gm gmVar3 = this.L;
        gm gmVar4 = gmVar3.f;
        return gmVar4 != null && gmVar4.f == gmVar3;
    }
}
