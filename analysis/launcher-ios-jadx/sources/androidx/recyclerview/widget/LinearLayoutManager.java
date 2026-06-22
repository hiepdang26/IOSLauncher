package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.widget.RtlSpacingHelper;
import defpackage.c80;
import defpackage.c91;
import defpackage.h91;
import defpackage.i91;
import defpackage.k31;
import defpackage.ln0;
import defpackage.m90;
import defpackage.mn0;
import defpackage.nn0;
import defpackage.on0;
import defpackage.pn0;
import defpackage.t81;
import defpackage.u81;
import defpackage.v81;
import defpackage.wy;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends u81 implements h91 {
    public final ln0 A;
    public final mn0 B;
    public final int C;
    public final int[] D;
    public int p;
    public nn0 q;
    public wy r;
    public boolean s;
    public final boolean t;
    public boolean u;
    public boolean v;
    public final boolean w;
    public int x;
    public int y;
    public on0 z;

    public LinearLayoutManager(int i) {
        this.p = 1;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = -1;
        this.y = RtlSpacingHelper.UNDEFINED;
        this.z = null;
        this.A = new ln0();
        this.B = new mn0();
        this.C = 2;
        this.D = new int[2];
        f1(i);
        c(null);
        if (this.t) {
            this.t = false;
            p0();
        }
    }

    @Override // defpackage.u81
    public void B0(RecyclerView recyclerView, int i) {
        pn0 pn0Var = new pn0(recyclerView.getContext());
        pn0Var.a = i;
        C0(pn0Var);
    }

    @Override // defpackage.u81
    public boolean D0() {
        return this.z == null && this.s == this.v;
    }

    public void E0(i91 i91Var, int[] iArr) {
        int i;
        int iL = i91Var.a != -1 ? this.r.l() : 0;
        if (this.q.f == -1) {
            i = 0;
        } else {
            i = iL;
            iL = 0;
        }
        iArr[0] = iL;
        iArr[1] = i;
    }

    public void F0(i91 i91Var, nn0 nn0Var, c80 c80Var) {
        int i = nn0Var.d;
        if (i < 0 || i >= i91Var.b()) {
            return;
        }
        c80Var.b(i, Math.max(0, nn0Var.g));
    }

    public final int G0(i91 i91Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        wy wyVar = this.r;
        boolean z = !this.w;
        return m90.d(i91Var, wyVar, N0(z), M0(z), this, this.w);
    }

    public final int H0(i91 i91Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        wy wyVar = this.r;
        boolean z = !this.w;
        return m90.e(i91Var, wyVar, N0(z), M0(z), this, this.w, this.u);
    }

    public final int I0(i91 i91Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        wy wyVar = this.r;
        boolean z = !this.w;
        return m90.f(i91Var, wyVar, N0(z), M0(z), this, this.w);
    }

    public final int J0(int i) {
        if (i == 1) {
            return (this.p != 1 && X0()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.p != 1 && X0()) ? -1 : 1;
        }
        if (i == 17) {
            if (this.p == 0) {
                return -1;
            }
            return RtlSpacingHelper.UNDEFINED;
        }
        if (i == 33) {
            if (this.p == 1) {
                return -1;
            }
            return RtlSpacingHelper.UNDEFINED;
        }
        if (i == 66) {
            if (this.p == 0) {
                return 1;
            }
            return RtlSpacingHelper.UNDEFINED;
        }
        if (i == 130 && this.p == 1) {
            return 1;
        }
        return RtlSpacingHelper.UNDEFINED;
    }

    public final void K0() {
        if (this.q == null) {
            nn0 nn0Var = new nn0();
            nn0Var.a = true;
            nn0Var.h = 0;
            nn0Var.i = 0;
            nn0Var.k = null;
            this.q = nn0Var;
        }
    }

    public final int L0(c91 c91Var, nn0 nn0Var, i91 i91Var, boolean z) {
        int i;
        int i2 = nn0Var.c;
        int i3 = nn0Var.g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                nn0Var.g = i3 + i2;
            }
            a1(c91Var, nn0Var);
        }
        int i4 = nn0Var.c + nn0Var.h;
        while (true) {
            if ((!nn0Var.l && i4 <= 0) || (i = nn0Var.d) < 0 || i >= i91Var.b()) {
                break;
            }
            mn0 mn0Var = this.B;
            mn0Var.a = 0;
            mn0Var.b = false;
            mn0Var.c = false;
            mn0Var.d = false;
            Y0(c91Var, i91Var, nn0Var, mn0Var);
            if (!mn0Var.b) {
                int i5 = nn0Var.b;
                int i6 = mn0Var.a;
                nn0Var.b = (nn0Var.f * i6) + i5;
                if (!mn0Var.c || nn0Var.k != null || !i91Var.g) {
                    nn0Var.c -= i6;
                    i4 -= i6;
                }
                int i7 = nn0Var.g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + i6;
                    nn0Var.g = i8;
                    int i9 = nn0Var.c;
                    if (i9 < 0) {
                        nn0Var.g = i8 + i9;
                    }
                    a1(c91Var, nn0Var);
                }
                if (z && mn0Var.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - nn0Var.c;
    }

    public final View M0(boolean z) {
        return this.u ? R0(0, v(), z, true) : R0(v() - 1, -1, z, true);
    }

    @Override // defpackage.u81
    public final boolean N() {
        return true;
    }

    public final View N0(boolean z) {
        return this.u ? R0(v() - 1, -1, z, true) : R0(0, v(), z, true);
    }

    public final int O0() {
        View viewR0 = R0(0, v(), false, true);
        if (viewR0 == null) {
            return -1;
        }
        return u81.J(viewR0);
    }

    public final int P0() {
        View viewR0 = R0(v() - 1, -1, false, true);
        if (viewR0 == null) {
            return -1;
        }
        return u81.J(viewR0);
    }

    public final View Q0(int i, int i2) {
        int i3;
        int i4;
        K0();
        if (i2 <= i && i2 >= i) {
            return u(i);
        }
        if (this.r.e(u(i)) < this.r.k()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.p == 0 ? this.c.C(i, i2, i3, i4) : this.d.C(i, i2, i3, i4);
    }

    public final View R0(int i, int i2, boolean z, boolean z2) {
        K0();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        return this.p == 0 ? this.c.C(i, i2, i3, i4) : this.d.C(i, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View S0(defpackage.c91 r17, defpackage.i91 r18, boolean r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r0.K0()
            int r1 = r0.v()
            r2 = 0
            r3 = 1
            if (r20 == 0) goto L15
            int r1 = r0.v()
            int r1 = r1 - r3
            r4 = -1
            r5 = -1
            goto L18
        L15:
            r4 = r1
            r1 = 0
            r5 = 1
        L18:
            int r6 = r18.b()
            wy r7 = r0.r
            int r7 = r7.k()
            wy r8 = r0.r
            int r8 = r8.g()
            r9 = 0
            r10 = r9
            r11 = r10
        L2b:
            if (r1 == r4) goto L7c
            android.view.View r12 = r0.u(r1)
            int r13 = defpackage.u81.J(r12)
            wy r14 = r0.r
            int r14 = r14.e(r12)
            wy r15 = r0.r
            int r15 = r15.b(r12)
            if (r13 < 0) goto L7a
            if (r13 >= r6) goto L7a
            android.view.ViewGroup$LayoutParams r13 = r12.getLayoutParams()
            v81 r13 = (defpackage.v81) r13
            m91 r13 = r13.a
            boolean r13 = r13.m()
            if (r13 == 0) goto L57
            if (r11 != 0) goto L7a
            r11 = r12
            goto L7a
        L57:
            if (r15 > r7) goto L5d
            if (r14 >= r7) goto L5d
            r13 = 1
            goto L5e
        L5d:
            r13 = 0
        L5e:
            if (r14 < r8) goto L64
            if (r15 <= r8) goto L64
            r14 = 1
            goto L65
        L64:
            r14 = 0
        L65:
            if (r13 != 0) goto L6b
            if (r14 == 0) goto L6a
            goto L6b
        L6a:
            return r12
        L6b:
            if (r19 == 0) goto L73
            if (r14 == 0) goto L70
            goto L75
        L70:
            if (r9 != 0) goto L7a
            goto L79
        L73:
            if (r13 == 0) goto L77
        L75:
            r10 = r12
            goto L7a
        L77:
            if (r9 != 0) goto L7a
        L79:
            r9 = r12
        L7a:
            int r1 = r1 + r5
            goto L2b
        L7c:
            if (r9 == 0) goto L7f
            return r9
        L7f:
            if (r10 == 0) goto L82
            return r10
        L82:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.S0(c91, i91, boolean, boolean):android.view.View");
    }

    public final int T0(int i, c91 c91Var, i91 i91Var, boolean z) {
        int iG;
        int iG2 = this.r.g() - i;
        if (iG2 <= 0) {
            return 0;
        }
        int i2 = -d1(-iG2, c91Var, i91Var);
        int i3 = i + i2;
        if (!z || (iG = this.r.g() - i3) <= 0) {
            return i2;
        }
        this.r.o(iG);
        return iG + i2;
    }

    @Override // defpackage.u81
    public View U(View view, int i, c91 c91Var, i91 i91Var) {
        int iJ0;
        c1();
        if (v() != 0 && (iJ0 = J0(i)) != Integer.MIN_VALUE) {
            K0();
            h1(iJ0, (int) (this.r.l() * 0.33333334f), false, i91Var);
            nn0 nn0Var = this.q;
            nn0Var.g = RtlSpacingHelper.UNDEFINED;
            nn0Var.a = false;
            L0(c91Var, nn0Var, i91Var, true);
            View viewQ0 = iJ0 == -1 ? this.u ? Q0(v() - 1, -1) : Q0(0, v()) : this.u ? Q0(0, v()) : Q0(v() - 1, -1);
            View viewW0 = iJ0 == -1 ? W0() : V0();
            if (!viewW0.hasFocusable()) {
                return viewQ0;
            }
            if (viewQ0 != null) {
                return viewW0;
            }
        }
        return null;
    }

    public final int U0(int i, c91 c91Var, i91 i91Var, boolean z) {
        int iK;
        int iK2 = i - this.r.k();
        if (iK2 <= 0) {
            return 0;
        }
        int i2 = -d1(iK2, c91Var, i91Var);
        int i3 = i + i2;
        if (!z || (iK = i3 - this.r.k()) <= 0) {
            return i2;
        }
        this.r.o(-iK);
        return i2 - iK;
    }

    @Override // defpackage.u81
    public void V(AccessibilityEvent accessibilityEvent) {
        super.V(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(O0());
            accessibilityEvent.setToIndex(P0());
        }
    }

    public final View V0() {
        return u(this.u ? 0 : v() - 1);
    }

    public final View W0() {
        return u(this.u ? v() - 1 : 0);
    }

    public final boolean X0() {
        return E() == 1;
    }

    public void Y0(c91 c91Var, i91 i91Var, nn0 nn0Var, mn0 mn0Var) {
        int iG;
        int i;
        int i2;
        int iD;
        View viewB = nn0Var.b(c91Var);
        if (viewB == null) {
            mn0Var.b = true;
            return;
        }
        v81 v81Var = (v81) viewB.getLayoutParams();
        if (nn0Var.k == null) {
            if (this.u == (nn0Var.f == -1)) {
                b(viewB, -1, false);
            } else {
                b(viewB, 0, false);
            }
        } else {
            if (this.u == (nn0Var.f == -1)) {
                b(viewB, -1, true);
            } else {
                b(viewB, 0, true);
            }
        }
        v81 v81Var2 = (v81) viewB.getLayoutParams();
        Rect rectR = this.b.R(viewB);
        int i3 = rectR.left + rectR.right;
        int i4 = rectR.top + rectR.bottom;
        int iW = u81.w(d(), this.n, this.l, H() + G() + ((ViewGroup.MarginLayoutParams) v81Var2).leftMargin + ((ViewGroup.MarginLayoutParams) v81Var2).rightMargin + i3, ((ViewGroup.MarginLayoutParams) v81Var2).width);
        int iW2 = u81.w(e(), this.o, this.m, F() + I() + ((ViewGroup.MarginLayoutParams) v81Var2).topMargin + ((ViewGroup.MarginLayoutParams) v81Var2).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) v81Var2).height);
        if (y0(viewB, iW, iW2, v81Var2)) {
            viewB.measure(iW, iW2);
        }
        mn0Var.a = this.r.c(viewB);
        if (this.p == 1) {
            if (X0()) {
                iD = this.n - H();
                iG = iD - this.r.d(viewB);
            } else {
                iG = G();
                iD = this.r.d(viewB) + iG;
            }
            if (nn0Var.f == -1) {
                i = nn0Var.b;
                i2 = i - mn0Var.a;
            } else {
                i2 = nn0Var.b;
                i = mn0Var.a + i2;
            }
        } else {
            int I = I();
            int iD2 = this.r.d(viewB) + I;
            if (nn0Var.f == -1) {
                int i5 = nn0Var.b;
                int i6 = i5 - mn0Var.a;
                iD = i5;
                i = iD2;
                iG = i6;
                i2 = I;
            } else {
                int i7 = nn0Var.b;
                int i8 = mn0Var.a + i7;
                iG = i7;
                i = iD2;
                i2 = I;
                iD = i8;
            }
        }
        u81.P(viewB, iG, i2, iD, i);
        if (v81Var.a.m() || v81Var.a.p()) {
            mn0Var.c = true;
        }
        mn0Var.d = viewB.hasFocusable();
    }

    @Override // defpackage.h91
    public final PointF a(int i) {
        if (v() == 0) {
            return null;
        }
        int i2 = (i < u81.J(u(0))) != this.u ? -1 : 1;
        return this.p == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    public final void a1(c91 c91Var, nn0 nn0Var) {
        if (!nn0Var.a || nn0Var.l) {
            return;
        }
        int i = nn0Var.g;
        int i2 = nn0Var.i;
        if (nn0Var.f == -1) {
            int iV = v();
            if (i < 0) {
                return;
            }
            int iF = (this.r.f() - i) + i2;
            if (this.u) {
                for (int i3 = 0; i3 < iV; i3++) {
                    View viewU = u(i3);
                    if (this.r.e(viewU) < iF || this.r.n(viewU) < iF) {
                        b1(c91Var, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = iV - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View viewU2 = u(i5);
                if (this.r.e(viewU2) < iF || this.r.n(viewU2) < iF) {
                    b1(c91Var, i4, i5);
                    return;
                }
            }
            return;
        }
        if (i < 0) {
            return;
        }
        int i6 = i - i2;
        int iV2 = v();
        if (!this.u) {
            for (int i7 = 0; i7 < iV2; i7++) {
                View viewU3 = u(i7);
                if (this.r.b(viewU3) > i6 || this.r.m(viewU3) > i6) {
                    b1(c91Var, 0, i7);
                    return;
                }
            }
            return;
        }
        int i8 = iV2 - 1;
        for (int i9 = i8; i9 >= 0; i9--) {
            View viewU4 = u(i9);
            if (this.r.b(viewU4) > i6 || this.r.m(viewU4) > i6) {
                b1(c91Var, i8, i9);
                return;
            }
        }
    }

    public final void b1(c91 c91Var, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                View viewU = u(i);
                n0(i);
                c91Var.h(viewU);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            View viewU2 = u(i3);
            n0(i3);
            c91Var.h(viewU2);
        }
    }

    @Override // defpackage.u81
    public final void c(String str) {
        RecyclerView recyclerView;
        if (this.z != null || (recyclerView = this.b) == null) {
            return;
        }
        recyclerView.m(str);
    }

    public final void c1() {
        if (this.p == 1 || !X0()) {
            this.u = this.t;
        } else {
            this.u = !this.t;
        }
    }

    @Override // defpackage.u81
    public final boolean d() {
        return this.p == 0;
    }

    public final int d1(int i, c91 c91Var, i91 i91Var) {
        if (v() != 0 && i != 0) {
            K0();
            this.q.a = true;
            int i2 = i > 0 ? 1 : -1;
            int iAbs = Math.abs(i);
            h1(i2, iAbs, true, i91Var);
            nn0 nn0Var = this.q;
            int iL0 = L0(c91Var, nn0Var, i91Var, false) + nn0Var.g;
            if (iL0 >= 0) {
                if (iAbs > iL0) {
                    i = i2 * iL0;
                }
                this.r.o(-i);
                this.q.j = i;
                return i;
            }
        }
        return 0;
    }

    @Override // defpackage.u81
    public final boolean e() {
        return this.p == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0194  */
    @Override // defpackage.u81
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e0(defpackage.c91 r18, defpackage.i91 r19) {
        /*
            Method dump skipped, instruction units count: 1084
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.e0(c91, i91):void");
    }

    public final void e1(int i, int i2) {
        this.x = i;
        this.y = i2;
        on0 on0Var = this.z;
        if (on0Var != null) {
            on0Var.g = -1;
        }
        p0();
    }

    @Override // defpackage.u81
    public void f0(i91 i91Var) {
        this.z = null;
        this.x = -1;
        this.y = RtlSpacingHelper.UNDEFINED;
        this.A.d();
    }

    public final void f1(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(k31.k(i, "invalid orientation:"));
        }
        c(null);
        if (i != this.p || this.r == null) {
            wy wyVarA = wy.a(this, i);
            this.r = wyVarA;
            this.A.a = wyVarA;
            this.p = i;
            p0();
        }
    }

    @Override // defpackage.u81
    public final void g0(Parcelable parcelable) {
        if (parcelable instanceof on0) {
            on0 on0Var = (on0) parcelable;
            this.z = on0Var;
            if (this.x != -1) {
                on0Var.g = -1;
            }
            p0();
        }
    }

    public void g1(boolean z) {
        c(null);
        if (this.v == z) {
            return;
        }
        this.v = z;
        p0();
    }

    @Override // defpackage.u81
    public final void h(int i, int i2, i91 i91Var, c80 c80Var) {
        if (this.p != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        K0();
        h1(i > 0 ? 1 : -1, Math.abs(i), true, i91Var);
        F0(i91Var, this.q, c80Var);
    }

    @Override // defpackage.u81
    public final Parcelable h0() {
        on0 on0Var = this.z;
        if (on0Var != null) {
            on0 on0Var2 = new on0();
            on0Var2.g = on0Var.g;
            on0Var2.h = on0Var.h;
            on0Var2.i = on0Var.i;
            return on0Var2;
        }
        on0 on0Var3 = new on0();
        if (v() <= 0) {
            on0Var3.g = -1;
            return on0Var3;
        }
        K0();
        boolean z = this.s ^ this.u;
        on0Var3.i = z;
        if (z) {
            View viewV0 = V0();
            on0Var3.h = this.r.g() - this.r.b(viewV0);
            on0Var3.g = u81.J(viewV0);
            return on0Var3;
        }
        View viewW0 = W0();
        on0Var3.g = u81.J(viewW0);
        on0Var3.h = this.r.e(viewW0) - this.r.k();
        return on0Var3;
    }

    public final void h1(int i, int i2, boolean z, i91 i91Var) {
        int iK;
        this.q.l = this.r.i() == 0 && this.r.f() == 0;
        this.q.f = i;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        E0(i91Var, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z2 = i == 1;
        nn0 nn0Var = this.q;
        int i3 = z2 ? iMax2 : iMax;
        nn0Var.h = i3;
        if (!z2) {
            iMax = iMax2;
        }
        nn0Var.i = iMax;
        if (z2) {
            nn0Var.h = this.r.h() + i3;
            View viewV0 = V0();
            nn0 nn0Var2 = this.q;
            nn0Var2.e = this.u ? -1 : 1;
            int iJ = u81.J(viewV0);
            nn0 nn0Var3 = this.q;
            nn0Var2.d = iJ + nn0Var3.e;
            nn0Var3.b = this.r.b(viewV0);
            iK = this.r.b(viewV0) - this.r.g();
        } else {
            View viewW0 = W0();
            nn0 nn0Var4 = this.q;
            nn0Var4.h = this.r.k() + nn0Var4.h;
            nn0 nn0Var5 = this.q;
            nn0Var5.e = this.u ? 1 : -1;
            int iJ2 = u81.J(viewW0);
            nn0 nn0Var6 = this.q;
            nn0Var5.d = iJ2 + nn0Var6.e;
            nn0Var6.b = this.r.e(viewW0);
            iK = (-this.r.e(viewW0)) + this.r.k();
        }
        nn0 nn0Var7 = this.q;
        nn0Var7.c = i2;
        if (z) {
            nn0Var7.c = i2 - iK;
        }
        nn0Var7.g = iK;
    }

    @Override // defpackage.u81
    public final void i(int i, c80 c80Var) {
        boolean z;
        int i2;
        on0 on0Var = this.z;
        if (on0Var == null || (i2 = on0Var.g) < 0) {
            c1();
            z = this.u;
            i2 = this.x;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            z = on0Var.i;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.C && i2 >= 0 && i2 < i; i4++) {
            c80Var.b(i2, 0);
            i2 += i3;
        }
    }

    public final void i1(int i, int i2) {
        this.q.c = this.r.g() - i2;
        nn0 nn0Var = this.q;
        nn0Var.e = this.u ? -1 : 1;
        nn0Var.d = i;
        nn0Var.f = 1;
        nn0Var.b = i2;
        nn0Var.g = RtlSpacingHelper.UNDEFINED;
    }

    @Override // defpackage.u81
    public final int j(i91 i91Var) {
        return G0(i91Var);
    }

    public final void j1(int i, int i2) {
        this.q.c = i2 - this.r.k();
        nn0 nn0Var = this.q;
        nn0Var.d = i;
        nn0Var.e = this.u ? 1 : -1;
        nn0Var.f = -1;
        nn0Var.b = i2;
        nn0Var.g = RtlSpacingHelper.UNDEFINED;
    }

    @Override // defpackage.u81
    public int k(i91 i91Var) {
        return H0(i91Var);
    }

    @Override // defpackage.u81
    public int l(i91 i91Var) {
        return I0(i91Var);
    }

    @Override // defpackage.u81
    public final int m(i91 i91Var) {
        return G0(i91Var);
    }

    @Override // defpackage.u81
    public int n(i91 i91Var) {
        return H0(i91Var);
    }

    @Override // defpackage.u81
    public int o(i91 i91Var) {
        return I0(i91Var);
    }

    @Override // defpackage.u81
    public final View q(int i) {
        int iV = v();
        if (iV == 0) {
            return null;
        }
        int iJ = i - u81.J(u(0));
        if (iJ >= 0 && iJ < iV) {
            View viewU = u(iJ);
            if (u81.J(viewU) == i) {
                return viewU;
            }
        }
        return super.q(i);
    }

    @Override // defpackage.u81
    public int q0(int i, c91 c91Var, i91 i91Var) {
        if (this.p == 1) {
            return 0;
        }
        return d1(i, c91Var, i91Var);
    }

    @Override // defpackage.u81
    public v81 r() {
        return new v81(-2, -2);
    }

    @Override // defpackage.u81
    public final void r0(int i) {
        this.x = i;
        this.y = RtlSpacingHelper.UNDEFINED;
        on0 on0Var = this.z;
        if (on0Var != null) {
            on0Var.g = -1;
        }
        p0();
    }

    @Override // defpackage.u81
    public int s0(int i, c91 c91Var, i91 i91Var) {
        if (this.p == 0) {
            return 0;
        }
        return d1(i, c91Var, i91Var);
    }

    @Override // defpackage.u81
    public final boolean z0() {
        if (this.m != 1073741824 && this.l != 1073741824) {
            int iV = v();
            for (int i = 0; i < iV; i++) {
                ViewGroup.LayoutParams layoutParams = u(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.p = 1;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = -1;
        this.y = RtlSpacingHelper.UNDEFINED;
        this.z = null;
        this.A = new ln0();
        this.B = new mn0();
        this.C = 2;
        this.D = new int[2];
        t81 t81VarK = u81.K(context, attributeSet, i, i2);
        f1(t81VarK.a);
        boolean z = t81VarK.c;
        c(null);
        if (z != this.t) {
            this.t = z;
            p0();
        }
        g1(t81VarK.d);
    }

    @Override // defpackage.u81
    public final void T(RecyclerView recyclerView) {
    }

    public void Z0(c91 c91Var, i91 i91Var, ln0 ln0Var, int i) {
    }
}
