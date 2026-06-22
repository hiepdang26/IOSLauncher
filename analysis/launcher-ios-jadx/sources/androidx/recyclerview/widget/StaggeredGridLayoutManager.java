package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.RtlSpacingHelper;
import defpackage.c80;
import defpackage.c91;
import defpackage.cm0;
import defpackage.fl0;
import defpackage.h91;
import defpackage.i91;
import defpackage.m90;
import defpackage.pn0;
import defpackage.qi1;
import defpackage.qs1;
import defpackage.ri1;
import defpackage.si1;
import defpackage.t81;
import defpackage.ti1;
import defpackage.u81;
import defpackage.ui1;
import defpackage.v21;
import defpackage.v81;
import defpackage.wy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends u81 implements h91 {
    public int A;
    public final v21 B;
    public int C;
    public boolean D;
    public boolean E;
    public ti1 F;
    public int G;
    public final Rect H;
    public final qi1 I;
    public boolean J;
    public final boolean K;
    public int[] L;
    public final fl0 M;
    public int p;
    public ui1[] q;
    public final wy r;
    public final wy s;
    public final int t;
    public int u;
    public final cm0 v;
    public boolean w;
    public boolean x;
    public BitSet y;
    public int z;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.p = -1;
        this.w = false;
        this.x = false;
        this.z = -1;
        this.A = RtlSpacingHelper.UNDEFINED;
        this.B = new v21(7);
        this.C = 2;
        this.H = new Rect();
        this.I = new qi1(this);
        this.J = false;
        this.K = true;
        this.M = new fl0(this, 14);
        t81 t81VarK = u81.K(context, attributeSet, i, i2);
        int i3 = t81VarK.a;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i3 != this.t) {
            this.t = i3;
            wy wyVar = this.r;
            this.r = this.s;
            this.s = wyVar;
            p0();
        }
        e1(t81VarK.b);
        boolean z = t81VarK.c;
        c(null);
        ti1 ti1Var = this.F;
        if (ti1Var != null && ti1Var.n != z) {
            ti1Var.n = z;
        }
        this.w = z;
        p0();
        this.v = new cm0();
        this.r = wy.a(this, this.t);
        this.s = wy.a(this, 1 - this.t);
    }

    public static int i1(int i, int i2, int i3) {
        int mode;
        return (!(i2 == 0 && i3 == 0) && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // defpackage.u81
    public final void B0(RecyclerView recyclerView, int i) {
        pn0 pn0Var = new pn0(recyclerView.getContext());
        pn0Var.a = i;
        C0(pn0Var);
    }

    @Override // defpackage.u81
    public final boolean D0() {
        return this.F == null;
    }

    public final boolean E0() {
        int iN0;
        int iO0;
        if (v() != 0 && this.C != 0 && this.g) {
            if (this.x) {
                iN0 = O0();
                iO0 = N0();
            } else {
                iN0 = N0();
                iO0 = O0();
            }
            v21 v21Var = this.B;
            if (iN0 == 0 && S0() != null) {
                v21Var.b();
                this.f = true;
                p0();
                return true;
            }
            if (this.J) {
                int i = this.x ? -1 : 1;
                int i2 = iO0 + 1;
                si1 si1VarJ = v21Var.j(iN0, i2, i);
                if (si1VarJ == null) {
                    this.J = false;
                    v21Var.i(i2);
                    return false;
                }
                si1 si1VarJ2 = v21Var.j(iN0, si1VarJ.g, i * (-1));
                if (si1VarJ2 == null) {
                    v21Var.i(si1VarJ.g);
                } else {
                    v21Var.i(si1VarJ2.g + 1);
                }
                this.f = true;
                p0();
                return true;
            }
        }
        return false;
    }

    public final int F0(i91 i91Var) {
        if (v() == 0) {
            return 0;
        }
        wy wyVar = this.r;
        boolean z = !this.K;
        return m90.d(i91Var, wyVar, K0(z), J0(z), this, this.K);
    }

    public final int G0(i91 i91Var) {
        if (v() == 0) {
            return 0;
        }
        wy wyVar = this.r;
        boolean z = !this.K;
        return m90.e(i91Var, wyVar, K0(z), J0(z), this, this.K, this.x);
    }

    public final int H0(i91 i91Var) {
        if (v() == 0) {
            return 0;
        }
        wy wyVar = this.r;
        boolean z = !this.K;
        return m90.f(i91Var, wyVar, K0(z), J0(z), this, this.K);
    }

    public final int I0(c91 c91Var, cm0 cm0Var, i91 i91Var) {
        ui1 ui1Var;
        boolean z;
        int i;
        int iQ0;
        int iC;
        int i2;
        int iK;
        int iC2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        c91 c91Var2 = c91Var;
        char c = 0;
        int i6 = 1;
        this.y.set(0, this.p, true);
        cm0 cm0Var2 = this.v;
        int i7 = cm0Var2.i ? cm0Var.e == 1 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : RtlSpacingHelper.UNDEFINED : cm0Var.e == 1 ? cm0Var.g + cm0Var.b : cm0Var.f - cm0Var.b;
        f1(cm0Var.e, i7);
        int iG = this.x ? this.r.g() : this.r.k();
        boolean z3 = false;
        while (true) {
            int i8 = cm0Var.c;
            if (!(i8 >= 0 && i8 < i91Var.b()) || (!cm0Var2.i && this.y.isEmpty())) {
                break;
            }
            View view = c91Var2.k(cm0Var.c, Long.MAX_VALUE).g;
            cm0Var.c += cm0Var.d;
            ri1 ri1Var = (ri1) view.getLayoutParams();
            int iF = ri1Var.a.f();
            v21 v21Var = this.B;
            int[] iArr = (int[]) v21Var.h;
            int i9 = (iArr == null || iF >= iArr.length) ? -1 : iArr[iF];
            boolean z4 = i9 == -1;
            if (z4) {
                if (ri1Var.f) {
                    ui1Var = this.q[c];
                } else {
                    if (W0(cm0Var.e)) {
                        i4 = this.p - i6;
                        i3 = -1;
                        i5 = -1;
                    } else {
                        i3 = this.p;
                        i4 = 0;
                        i5 = 1;
                    }
                    ui1 ui1Var2 = null;
                    if (cm0Var.e == i6) {
                        int iK2 = this.r.k();
                        int i10 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        while (i4 != i3) {
                            ui1 ui1Var3 = this.q[i4];
                            int i11 = i4;
                            int iH = ui1Var3.h(iK2);
                            if (iH < i10) {
                                ui1Var2 = ui1Var3;
                                i10 = iH;
                            }
                            i4 = i11 + i5;
                        }
                    } else {
                        int iG2 = this.r.g();
                        int i12 = RtlSpacingHelper.UNDEFINED;
                        while (i4 != i3) {
                            ui1 ui1Var4 = this.q[i4];
                            int i13 = i4;
                            int iJ = ui1Var4.j(iG2);
                            if (iJ > i12) {
                                i12 = iJ;
                                ui1Var2 = ui1Var4;
                            }
                            i4 = i13 + i5;
                        }
                    }
                    ui1Var = ui1Var2;
                }
                v21Var.g(iF);
                ((int[]) v21Var.h)[iF] = ui1Var.j;
            } else {
                ui1Var = this.q[i9];
            }
            ri1Var.e = ui1Var;
            if (cm0Var.e == 1) {
                b(view, -1, false);
            } else {
                b(view, 0, false);
            }
            if (ri1Var.f) {
                if (this.t == 1) {
                    z = z4;
                    U0(view, this.G, u81.w(true, this.o, this.m, F() + I(), ((ViewGroup.MarginLayoutParams) ri1Var).height));
                } else {
                    z = z4;
                    U0(view, u81.w(true, this.n, this.l, H() + G(), ((ViewGroup.MarginLayoutParams) ri1Var).width), this.G);
                }
                i = 1;
            } else {
                z = z4;
                if (this.t == 1) {
                    i = 1;
                    U0(view, u81.w(false, this.u, this.l, 0, ((ViewGroup.MarginLayoutParams) ri1Var).width), u81.w(true, this.o, this.m, F() + I(), ((ViewGroup.MarginLayoutParams) ri1Var).height));
                } else {
                    i = 1;
                    U0(view, u81.w(true, this.n, this.l, H() + G(), ((ViewGroup.MarginLayoutParams) ri1Var).width), u81.w(false, this.u, this.m, 0, ((ViewGroup.MarginLayoutParams) ri1Var).height));
                }
            }
            if (cm0Var.e == i) {
                iC = ri1Var.f ? P0(iG) : ui1Var.h(iG);
                iQ0 = this.r.c(view) + iC;
                if (z && ri1Var.f) {
                    si1 si1Var = new si1();
                    si1Var.i = new int[this.p];
                    for (int i14 = 0; i14 < this.p; i14++) {
                        si1Var.i[i14] = iC - this.q[i14].h(iC);
                    }
                    si1Var.h = -1;
                    si1Var.g = iF;
                    v21Var.a(si1Var);
                }
            } else {
                iQ0 = ri1Var.f ? Q0(iG) : ui1Var.j(iG);
                iC = iQ0 - this.r.c(view);
                if (z && ri1Var.f) {
                    si1 si1Var2 = new si1();
                    si1Var2.i = new int[this.p];
                    for (int i15 = 0; i15 < this.p; i15++) {
                        si1Var2.i[i15] = this.q[i15].j(iQ0) - iQ0;
                    }
                    si1Var2.h = 1;
                    si1Var2.g = iF;
                    v21Var.a(si1Var2);
                }
            }
            if (!ri1Var.f || cm0Var.d != -1) {
                i2 = 1;
            } else if (z) {
                i2 = 1;
                this.J = true;
            } else {
                if (cm0Var.e != 1) {
                    int iJ2 = this.q[0].j(RtlSpacingHelper.UNDEFINED);
                    int i16 = 1;
                    while (true) {
                        if (i16 >= this.p) {
                            z2 = true;
                            break;
                        }
                        if (this.q[i16].j(RtlSpacingHelper.UNDEFINED) != iJ2) {
                            z2 = false;
                            break;
                        }
                        i16++;
                    }
                } else {
                    int iH2 = this.q[0].h(RtlSpacingHelper.UNDEFINED);
                    int i17 = 1;
                    while (true) {
                        if (i17 >= this.p) {
                            z2 = true;
                            break;
                        }
                        if (this.q[i17].h(RtlSpacingHelper.UNDEFINED) != iH2) {
                            z2 = false;
                            break;
                        }
                        i17++;
                    }
                }
                i2 = 1;
                if (!z2) {
                    si1 si1VarL = v21Var.l(iF);
                    if (si1VarL != null) {
                        si1VarL.j = true;
                    }
                    this.J = true;
                }
            }
            if (cm0Var.e == i2) {
                if (ri1Var.f) {
                    for (int i18 = this.p - i2; i18 >= 0; i18--) {
                        this.q[i18].a(view);
                    }
                } else {
                    ri1Var.e.a(view);
                }
            } else if (ri1Var.f) {
                for (int i19 = this.p - 1; i19 >= 0; i19--) {
                    this.q[i19].m(view);
                }
            } else {
                ri1Var.e.m(view);
            }
            if (T0() && this.t == 1) {
                iC2 = ri1Var.f ? this.s.g() : this.s.g() - (((this.p - 1) - ui1Var.j) * this.u);
                iK = iC2 - this.s.c(view);
            } else {
                iK = ri1Var.f ? this.s.k() : this.s.k() + (ui1Var.j * this.u);
                iC2 = this.s.c(view) + iK;
            }
            if (this.t == 1) {
                u81.P(view, iK, iC, iC2, iQ0);
            } else {
                u81.P(view, iC, iK, iQ0, iC2);
            }
            if (ri1Var.f) {
                f1(cm0Var2.e, i7);
            } else {
                h1(ui1Var, cm0Var2.e, i7);
            }
            c91Var2 = c91Var;
            Y0(c91Var2, cm0Var2);
            if (cm0Var2.h && view.hasFocusable()) {
                if (ri1Var.f) {
                    this.y.clear();
                } else {
                    this.y.set(ui1Var.j, false);
                }
            }
            c = 0;
            i6 = 1;
            z3 = true;
        }
        if (!z3) {
            Y0(c91Var2, cm0Var2);
        }
        int iK3 = cm0Var2.e == -1 ? this.r.k() - Q0(this.r.k()) : P0(this.r.g()) - this.r.g();
        if (iK3 > 0) {
            return Math.min(cm0Var.b, iK3);
        }
        return 0;
    }

    public final View J0(boolean z) {
        int iK = this.r.k();
        int iG = this.r.g();
        View view = null;
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            int iE = this.r.e(viewU);
            int iB = this.r.b(viewU);
            if (iB > iK && iE < iG) {
                if (iB <= iG || !z) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final View K0(boolean z) {
        int iK = this.r.k();
        int iG = this.r.g();
        int iV = v();
        View view = null;
        for (int i = 0; i < iV; i++) {
            View viewU = u(i);
            int iE = this.r.e(viewU);
            if (this.r.b(viewU) > iK && iE < iG) {
                if (iE >= iK || !z) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final void L0(c91 c91Var, i91 i91Var, boolean z) {
        int iG;
        int iP0 = P0(RtlSpacingHelper.UNDEFINED);
        if (iP0 != Integer.MIN_VALUE && (iG = this.r.g() - iP0) > 0) {
            int i = iG - (-c1(-iG, c91Var, i91Var));
            if (!z || i <= 0) {
                return;
            }
            this.r.o(i);
        }
    }

    public final void M0(c91 c91Var, i91 i91Var, boolean z) {
        int iK;
        int iQ0 = Q0(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        if (iQ0 != Integer.MAX_VALUE && (iK = iQ0 - this.r.k()) > 0) {
            int iC1 = iK - c1(iK, c91Var, i91Var);
            if (!z || iC1 <= 0) {
                return;
            }
            this.r.o(-iC1);
        }
    }

    @Override // defpackage.u81
    public final boolean N() {
        return this.C != 0;
    }

    public final int N0() {
        if (v() == 0) {
            return 0;
        }
        return u81.J(u(0));
    }

    public final int O0() {
        int iV = v();
        if (iV == 0) {
            return 0;
        }
        return u81.J(u(iV - 1));
    }

    public final int P0(int i) {
        int iH = this.q[0].h(i);
        for (int i2 = 1; i2 < this.p; i2++) {
            int iH2 = this.q[i2].h(i);
            if (iH2 > iH) {
                iH = iH2;
            }
        }
        return iH;
    }

    @Override // defpackage.u81
    public final void Q(int i) {
        super.Q(i);
        for (int i2 = 0; i2 < this.p; i2++) {
            ui1 ui1Var = this.q[i2];
            int i3 = ui1Var.g;
            if (i3 != Integer.MIN_VALUE) {
                ui1Var.g = i3 + i;
            }
            int i4 = ui1Var.h;
            if (i4 != Integer.MIN_VALUE) {
                ui1Var.h = i4 + i;
            }
        }
    }

    public final int Q0(int i) {
        int iJ = this.q[0].j(i);
        for (int i2 = 1; i2 < this.p; i2++) {
            int iJ2 = this.q[i2].j(i);
            if (iJ2 < iJ) {
                iJ = iJ2;
            }
        }
        return iJ;
    }

    @Override // defpackage.u81
    public final void R(int i) {
        super.R(i);
        for (int i2 = 0; i2 < this.p; i2++) {
            ui1 ui1Var = this.q[i2];
            int i3 = ui1Var.g;
            if (i3 != Integer.MIN_VALUE) {
                ui1Var.g = i3 + i;
            }
            int i4 = ui1Var.h;
            if (i4 != Integer.MIN_VALUE) {
                ui1Var.h = i4 + i;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R0(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.x
            if (r0 == 0) goto L9
            int r0 = r7.O0()
            goto Ld
        L9:
            int r0 = r7.N0()
        Ld:
            r1 = 8
            if (r10 != r1) goto L1b
            if (r8 >= r9) goto L17
            int r2 = r9 + 1
        L15:
            r3 = r8
            goto L1e
        L17:
            int r2 = r8 + 1
            r3 = r9
            goto L1e
        L1b:
            int r2 = r8 + r9
            goto L15
        L1e:
            v21 r4 = r7.B
            r4.q(r3)
            r5 = 1
            if (r10 == r5) goto L37
            r6 = 2
            if (r10 == r6) goto L33
            if (r10 == r1) goto L2c
            goto L3a
        L2c:
            r4.s(r8, r5)
            r4.r(r9, r5)
            goto L3a
        L33:
            r4.s(r8, r9)
            goto L3a
        L37:
            r4.r(r8, r9)
        L3a:
            if (r2 > r0) goto L3d
            goto L4f
        L3d:
            boolean r8 = r7.x
            if (r8 == 0) goto L46
            int r8 = r7.N0()
            goto L4a
        L46:
            int r8 = r7.O0()
        L4a:
            if (r3 > r8) goto L4f
            r7.p0()
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.R0(int, int, int):void");
    }

    @Override // defpackage.u81
    public final void S() {
        this.B.b();
        for (int i = 0; i < this.p; i++) {
            this.q[i].d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00fa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View S0() {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.S0():android.view.View");
    }

    @Override // defpackage.u81
    public final void T(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.M);
        }
        for (int i = 0; i < this.p; i++) {
            this.q[i].d();
        }
        recyclerView.requestLayout();
    }

    public final boolean T0() {
        return E() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0054  */
    @Override // defpackage.u81
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View U(android.view.View r10, int r11, defpackage.c91 r12, defpackage.i91 r13) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.U(android.view.View, int, c91, i91):android.view.View");
    }

    public final void U0(View view, int i, int i2) {
        RecyclerView recyclerView = this.b;
        Rect rect = this.H;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.R(view));
        }
        ri1 ri1Var = (ri1) view.getLayoutParams();
        int iI1 = i1(i, ((ViewGroup.MarginLayoutParams) ri1Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) ri1Var).rightMargin + rect.right);
        int iI12 = i1(i2, ((ViewGroup.MarginLayoutParams) ri1Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) ri1Var).bottomMargin + rect.bottom);
        if (y0(view, iI1, iI12, ri1Var)) {
            view.measure(iI1, iI12);
        }
    }

    @Override // defpackage.u81
    public final void V(AccessibilityEvent accessibilityEvent) {
        super.V(accessibilityEvent);
        if (v() > 0) {
            View viewK0 = K0(false);
            View viewJ0 = J0(false);
            if (viewK0 == null || viewJ0 == null) {
                return;
            }
            int iJ = u81.J(viewK0);
            int iJ2 = u81.J(viewJ0);
            if (iJ < iJ2) {
                accessibilityEvent.setFromIndex(iJ);
                accessibilityEvent.setToIndex(iJ2);
            } else {
                accessibilityEvent.setFromIndex(iJ2);
                accessibilityEvent.setToIndex(iJ);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0435  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V0(defpackage.c91 r17, defpackage.i91 r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 1104
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.V0(c91, i91, boolean):void");
    }

    public final boolean W0(int i) {
        if (this.t == 0) {
            return (i == -1) != this.x;
        }
        return ((i == -1) == this.x) == T0();
    }

    public final void X0(int i, i91 i91Var) {
        int iN0;
        int i2;
        if (i > 0) {
            iN0 = O0();
            i2 = 1;
        } else {
            iN0 = N0();
            i2 = -1;
        }
        cm0 cm0Var = this.v;
        cm0Var.a = true;
        g1(iN0, i91Var);
        d1(i2);
        cm0Var.c = iN0 + cm0Var.d;
        cm0Var.b = Math.abs(i);
    }

    public final void Y0(c91 c91Var, cm0 cm0Var) {
        if (!cm0Var.a || cm0Var.i) {
            return;
        }
        if (cm0Var.b == 0) {
            if (cm0Var.e == -1) {
                Z0(c91Var, cm0Var.g);
                return;
            } else {
                a1(c91Var, cm0Var.f);
                return;
            }
        }
        int i = 1;
        if (cm0Var.e == -1) {
            int i2 = cm0Var.f;
            int iJ = this.q[0].j(i2);
            while (i < this.p) {
                int iJ2 = this.q[i].j(i2);
                if (iJ2 > iJ) {
                    iJ = iJ2;
                }
                i++;
            }
            int i3 = i2 - iJ;
            Z0(c91Var, i3 < 0 ? cm0Var.g : cm0Var.g - Math.min(i3, cm0Var.b));
            return;
        }
        int i4 = cm0Var.g;
        int iH = this.q[0].h(i4);
        while (i < this.p) {
            int iH2 = this.q[i].h(i4);
            if (iH2 < iH) {
                iH = iH2;
            }
            i++;
        }
        int i5 = iH - cm0Var.g;
        a1(c91Var, i5 < 0 ? cm0Var.f : Math.min(i5, cm0Var.b) + cm0Var.f);
    }

    @Override // defpackage.u81
    public final void Z(int i, int i2) {
        R0(i, i2, 1);
    }

    public final void Z0(c91 c91Var, int i) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            if (this.r.e(viewU) < i || this.r.n(viewU) < i) {
                return;
            }
            ri1 ri1Var = (ri1) viewU.getLayoutParams();
            if (ri1Var.f) {
                for (int i2 = 0; i2 < this.p; i2++) {
                    if (((ArrayList) this.q[i2].k).size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.p; i3++) {
                    this.q[i3].k();
                }
            } else if (((ArrayList) ri1Var.e.k).size() == 1) {
                return;
            } else {
                ri1Var.e.k();
            }
            m0(viewU, c91Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    @Override // defpackage.h91
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF a(int r4) {
        /*
            r3 = this;
            int r0 = r3.v()
            r1 = -1
            r2 = 1
            if (r0 != 0) goto Le
            boolean r4 = r3.x
            if (r4 == 0) goto L1b
        Lc:
            r1 = 1
            goto L1b
        Le:
            int r0 = r3.N0()
            if (r4 >= r0) goto L16
            r4 = 1
            goto L17
        L16:
            r4 = 0
        L17:
            boolean r0 = r3.x
            if (r4 == r0) goto Lc
        L1b:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>()
            if (r1 != 0) goto L24
            r4 = 0
            return r4
        L24:
            int r0 = r3.t
            r2 = 0
            if (r0 != 0) goto L2f
            float r0 = (float) r1
            r4.x = r0
            r4.y = r2
            return r4
        L2f:
            r4.x = r2
            float r0 = (float) r1
            r4.y = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int):android.graphics.PointF");
    }

    @Override // defpackage.u81
    public final void a0() {
        this.B.b();
        p0();
    }

    public final void a1(c91 c91Var, int i) {
        while (v() > 0) {
            View viewU = u(0);
            if (this.r.b(viewU) > i || this.r.m(viewU) > i) {
                return;
            }
            ri1 ri1Var = (ri1) viewU.getLayoutParams();
            if (ri1Var.f) {
                for (int i2 = 0; i2 < this.p; i2++) {
                    if (((ArrayList) this.q[i2].k).size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.p; i3++) {
                    this.q[i3].l();
                }
            } else if (((ArrayList) ri1Var.e.k).size() == 1) {
                return;
            } else {
                ri1Var.e.l();
            }
            m0(viewU, c91Var);
        }
    }

    @Override // defpackage.u81
    public final void b0(int i, int i2) {
        R0(i, i2, 8);
    }

    public final void b1() {
        if (this.t == 1 || !T0()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    @Override // defpackage.u81
    public final void c(String str) {
        RecyclerView recyclerView;
        if (this.F != null || (recyclerView = this.b) == null) {
            return;
        }
        recyclerView.m(str);
    }

    @Override // defpackage.u81
    public final void c0(int i, int i2) {
        R0(i, i2, 2);
    }

    public final int c1(int i, c91 c91Var, i91 i91Var) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        X0(i, i91Var);
        cm0 cm0Var = this.v;
        int iI0 = I0(c91Var, cm0Var, i91Var);
        if (cm0Var.b >= iI0) {
            i = i < 0 ? -iI0 : iI0;
        }
        this.r.o(-i);
        this.D = this.x;
        cm0Var.b = 0;
        Y0(c91Var, cm0Var);
        return i;
    }

    @Override // defpackage.u81
    public final boolean d() {
        return this.t == 0;
    }

    @Override // defpackage.u81
    public final void d0(int i, int i2) {
        R0(i, i2, 4);
    }

    public final void d1(int i) {
        cm0 cm0Var = this.v;
        cm0Var.e = i;
        cm0Var.d = this.x != (i == -1) ? -1 : 1;
    }

    @Override // defpackage.u81
    public final boolean e() {
        return this.t == 1;
    }

    @Override // defpackage.u81
    public void e0(c91 c91Var, i91 i91Var) {
        V0(c91Var, i91Var, true);
    }

    public final void e1(int i) {
        c(null);
        if (i != this.p) {
            this.B.b();
            p0();
            this.p = i;
            this.y = new BitSet(this.p);
            this.q = new ui1[this.p];
            for (int i2 = 0; i2 < this.p; i2++) {
                this.q[i2] = new ui1(this, i2);
            }
            p0();
        }
    }

    @Override // defpackage.u81
    public final boolean f(v81 v81Var) {
        return v81Var instanceof ri1;
    }

    @Override // defpackage.u81
    public final void f0(i91 i91Var) {
        this.z = -1;
        this.A = RtlSpacingHelper.UNDEFINED;
        this.F = null;
        this.I.a();
    }

    public final void f1(int i, int i2) {
        for (int i3 = 0; i3 < this.p; i3++) {
            if (!((ArrayList) this.q[i3].k).isEmpty()) {
                h1(this.q[i3], i, i2);
            }
        }
    }

    @Override // defpackage.u81
    public final void g0(Parcelable parcelable) {
        if (parcelable instanceof ti1) {
            ti1 ti1Var = (ti1) parcelable;
            this.F = ti1Var;
            if (this.z != -1) {
                ti1Var.j = null;
                ti1Var.i = 0;
                ti1Var.g = -1;
                ti1Var.h = -1;
                ti1Var.j = null;
                ti1Var.i = 0;
                ti1Var.k = 0;
                ti1Var.l = null;
                ti1Var.m = null;
            }
            p0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g1(int r5, defpackage.i91 r6) {
        /*
            r4 = this;
            cm0 r0 = r4.v
            r1 = 0
            r0.b = r1
            r0.c = r5
            pn0 r2 = r4.e
            r3 = 1
            if (r2 == 0) goto L12
            boolean r2 = r2.e
            if (r2 == 0) goto L12
            r2 = 1
            goto L13
        L12:
            r2 = 0
        L13:
            if (r2 == 0) goto L34
            int r6 = r6.a
            r2 = -1
            if (r6 == r2) goto L34
            boolean r2 = r4.x
            if (r6 >= r5) goto L20
            r5 = 1
            goto L21
        L20:
            r5 = 0
        L21:
            if (r2 != r5) goto L2b
            wy r5 = r4.r
            int r5 = r5.l()
        L29:
            r6 = 0
            goto L36
        L2b:
            wy r5 = r4.r
            int r5 = r5.l()
            r6 = r5
            r5 = 0
            goto L36
        L34:
            r5 = 0
            goto L29
        L36:
            androidx.recyclerview.widget.RecyclerView r2 = r4.b
            if (r2 == 0) goto L51
            boolean r2 = r2.n
            if (r2 == 0) goto L51
            wy r2 = r4.r
            int r2 = r2.k()
            int r2 = r2 - r6
            r0.f = r2
            wy r6 = r4.r
            int r6 = r6.g()
            int r6 = r6 + r5
            r0.g = r6
            goto L5d
        L51:
            wy r2 = r4.r
            int r2 = r2.f()
            int r2 = r2 + r5
            r0.g = r2
            int r5 = -r6
            r0.f = r5
        L5d:
            r0.h = r1
            r0.a = r3
            wy r5 = r4.r
            int r5 = r5.i()
            if (r5 != 0) goto L72
            wy r5 = r4.r
            int r5 = r5.f()
            if (r5 != 0) goto L72
            r1 = 1
        L72:
            r0.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.g1(int, i91):void");
    }

    @Override // defpackage.u81
    public final void h(int i, int i2, i91 i91Var, c80 c80Var) {
        cm0 cm0Var;
        int iH;
        int iJ;
        if (this.t != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        X0(i, i91Var);
        int[] iArr = this.L;
        if (iArr == null || iArr.length < this.p) {
            this.L = new int[this.p];
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = this.p;
            cm0Var = this.v;
            if (i3 >= i5) {
                break;
            }
            if (cm0Var.d == -1) {
                iH = cm0Var.f;
                iJ = this.q[i3].j(iH);
            } else {
                iH = this.q[i3].h(cm0Var.g);
                iJ = cm0Var.g;
            }
            int i6 = iH - iJ;
            if (i6 >= 0) {
                this.L[i4] = i6;
                i4++;
            }
            i3++;
        }
        Arrays.sort(this.L, 0, i4);
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = cm0Var.c;
            if (i8 < 0 || i8 >= i91Var.b()) {
                return;
            }
            c80Var.b(cm0Var.c, this.L[i7]);
            cm0Var.c += cm0Var.d;
        }
    }

    @Override // defpackage.u81
    public final Parcelable h0() {
        int iJ;
        int iK;
        int[] iArr;
        ti1 ti1Var = this.F;
        if (ti1Var != null) {
            ti1 ti1Var2 = new ti1();
            ti1Var2.i = ti1Var.i;
            ti1Var2.g = ti1Var.g;
            ti1Var2.h = ti1Var.h;
            ti1Var2.j = ti1Var.j;
            ti1Var2.k = ti1Var.k;
            ti1Var2.l = ti1Var.l;
            ti1Var2.n = ti1Var.n;
            ti1Var2.o = ti1Var.o;
            ti1Var2.p = ti1Var.p;
            ti1Var2.m = ti1Var.m;
            return ti1Var2;
        }
        ti1 ti1Var3 = new ti1();
        ti1Var3.n = this.w;
        ti1Var3.o = this.D;
        ti1Var3.p = this.E;
        v21 v21Var = this.B;
        if (v21Var == null || (iArr = (int[]) v21Var.h) == null) {
            ti1Var3.k = 0;
        } else {
            ti1Var3.l = iArr;
            ti1Var3.k = iArr.length;
            ti1Var3.m = (ArrayList) v21Var.i;
        }
        if (v() <= 0) {
            ti1Var3.g = -1;
            ti1Var3.h = -1;
            ti1Var3.i = 0;
            return ti1Var3;
        }
        ti1Var3.g = this.D ? O0() : N0();
        View viewJ0 = this.x ? J0(true) : K0(true);
        ti1Var3.h = viewJ0 != null ? u81.J(viewJ0) : -1;
        int i = this.p;
        ti1Var3.i = i;
        ti1Var3.j = new int[i];
        for (int i2 = 0; i2 < this.p; i2++) {
            if (this.D) {
                iJ = this.q[i2].h(RtlSpacingHelper.UNDEFINED);
                if (iJ != Integer.MIN_VALUE) {
                    iK = this.r.g();
                    iJ -= iK;
                }
            } else {
                iJ = this.q[i2].j(RtlSpacingHelper.UNDEFINED);
                if (iJ != Integer.MIN_VALUE) {
                    iK = this.r.k();
                    iJ -= iK;
                }
            }
            ti1Var3.j[i2] = iJ;
        }
        return ti1Var3;
    }

    public final void h1(ui1 ui1Var, int i, int i2) {
        int i3 = ui1Var.i;
        int i4 = ui1Var.j;
        if (i == -1) {
            int i5 = ui1Var.g;
            if (i5 == Integer.MIN_VALUE) {
                ui1Var.c();
                i5 = ui1Var.g;
            }
            if (i5 + i3 <= i2) {
                this.y.set(i4, false);
                return;
            }
            return;
        }
        int i6 = ui1Var.h;
        if (i6 == Integer.MIN_VALUE) {
            ui1Var.b();
            i6 = ui1Var.h;
        }
        if (i6 - i3 >= i2) {
            this.y.set(i4, false);
        }
    }

    @Override // defpackage.u81
    public final void i0(int i) {
        if (i == 0) {
            E0();
        }
    }

    @Override // defpackage.u81
    public final int j(i91 i91Var) {
        return F0(i91Var);
    }

    @Override // defpackage.u81
    public final int k(i91 i91Var) {
        return G0(i91Var);
    }

    @Override // defpackage.u81
    public final int l(i91 i91Var) {
        return H0(i91Var);
    }

    @Override // defpackage.u81
    public final int m(i91 i91Var) {
        return F0(i91Var);
    }

    @Override // defpackage.u81
    public final int n(i91 i91Var) {
        return G0(i91Var);
    }

    @Override // defpackage.u81
    public final int o(i91 i91Var) {
        return H0(i91Var);
    }

    @Override // defpackage.u81
    public final int q0(int i, c91 c91Var, i91 i91Var) {
        return c1(i, c91Var, i91Var);
    }

    @Override // defpackage.u81
    public final v81 r() {
        return this.t == 0 ? new ri1(-2, -1) : new ri1(-1, -2);
    }

    @Override // defpackage.u81
    public final void r0(int i) {
        ti1 ti1Var = this.F;
        if (ti1Var != null && ti1Var.g != i) {
            ti1Var.j = null;
            ti1Var.i = 0;
            ti1Var.g = -1;
            ti1Var.h = -1;
        }
        this.z = i;
        this.A = RtlSpacingHelper.UNDEFINED;
        p0();
    }

    @Override // defpackage.u81
    public final v81 s(Context context, AttributeSet attributeSet) {
        return new ri1(context, attributeSet);
    }

    @Override // defpackage.u81
    public final int s0(int i, c91 c91Var, i91 i91Var) {
        return c1(i, c91Var, i91Var);
    }

    @Override // defpackage.u81
    public final v81 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new ri1((ViewGroup.MarginLayoutParams) layoutParams) : new ri1(layoutParams);
    }

    @Override // defpackage.u81
    public final void v0(int i, int i2, Rect rect) {
        int iG;
        int iG2;
        int iH = H() + G();
        int iF = F() + I();
        if (this.t == 1) {
            int iHeight = rect.height() + iF;
            RecyclerView recyclerView = this.b;
            WeakHashMap weakHashMap = qs1.a;
            iG2 = u81.g(i2, iHeight, recyclerView.getMinimumHeight());
            iG = u81.g(i, (this.u * this.p) + iH, this.b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iH;
            RecyclerView recyclerView2 = this.b;
            WeakHashMap weakHashMap2 = qs1.a;
            iG = u81.g(i, iWidth, recyclerView2.getMinimumWidth());
            iG2 = u81.g(i2, (this.u * this.p) + iF, this.b.getMinimumHeight());
        }
        this.b.setMeasuredDimension(iG, iG2);
    }

    public StaggeredGridLayoutManager() {
        this.p = -1;
        this.w = false;
        this.x = false;
        this.z = -1;
        this.A = RtlSpacingHelper.UNDEFINED;
        this.B = new v21(7);
        this.C = 2;
        this.H = new Rect();
        this.I = new qi1(this);
        this.J = false;
        this.K = true;
        this.M = new fl0(this, 14);
        this.t = 1;
        e1(2);
        this.v = new cm0();
        this.r = wy.a(this, this.t);
        this.s = wy.a(this, 1 - this.t);
    }
}
