package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import defpackage.c80;
import defpackage.c91;
import defpackage.i91;
import defpackage.k31;
import defpackage.ln0;
import defpackage.mn0;
import defpackage.na0;
import defpackage.nn0;
import defpackage.nx0;
import defpackage.oa0;
import defpackage.pa0;
import defpackage.qs1;
import defpackage.r0;
import defpackage.u81;
import defpackage.uo;
import defpackage.v81;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public pa0 K;
    public final Rect L;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new na0();
        this.L = new Rect();
        r1(u81.K(context, attributeSet, i, i2).b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final boolean D0() {
        return this.z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void F0(i91 i91Var, nn0 nn0Var, c80 c80Var) {
        int i;
        int iD = this.F;
        for (int i2 = 0; i2 < this.F && (i = nn0Var.d) >= 0 && i < i91Var.b() && iD > 0; i2++) {
            int i3 = nn0Var.d;
            c80Var.b(i3, Math.max(0, nn0Var.g));
            iD -= this.K.d(i3);
            nn0Var.d += nn0Var.e;
        }
    }

    @Override // defpackage.u81
    public int L(c91 c91Var, i91 i91Var) {
        if (this.p == 0) {
            return this.F;
        }
        if (i91Var.b() < 1) {
            return 0;
        }
        return n1(i91Var.b() - 1, c91Var, i91Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View S0(c91 c91Var, i91 i91Var, boolean z, boolean z2) {
        int i;
        int iV;
        int iV2 = v();
        int i2 = 1;
        if (z2) {
            iV = v() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iV2;
            iV = 0;
        }
        int iB = i91Var.b();
        K0();
        int iK = this.r.k();
        int iG = this.r.g();
        View view = null;
        View view2 = null;
        while (iV != i) {
            View viewU = u(iV);
            int iJ = u81.J(viewU);
            if (iJ >= 0 && iJ < iB && o1(iJ, c91Var, i91Var) == 0) {
                if (((v81) viewU.getLayoutParams()).a.m()) {
                    if (view2 == null) {
                        view2 = viewU;
                    }
                } else {
                    if (this.r.e(viewU) < iG && this.r.b(viewU) >= iK) {
                        return viewU;
                    }
                    if (view == null) {
                        view = viewU;
                    }
                }
            }
            iV += i2;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e2, code lost:
    
        if (r13 == (r2 > r15)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0142, code lost:
    
        if (r16 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0144, code lost:
    
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0145, code lost:
    
        return r17;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View U(android.view.View r23, int r24, defpackage.c91 r25, defpackage.i91 r26) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.U(android.view.View, int, c91, i91):android.view.View");
    }

    @Override // defpackage.u81
    public final void W(c91 c91Var, i91 i91Var, r0 r0Var) {
        super.W(c91Var, i91Var, r0Var);
        r0Var.i(GridView.class.getName());
    }

    @Override // defpackage.u81
    public void X(c91 c91Var, i91 i91Var, View view, r0 r0Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof oa0)) {
            Y(view, r0Var);
            return;
        }
        oa0 oa0Var = (oa0) layoutParams;
        int iN1 = n1(oa0Var.a.f(), c91Var, i91Var);
        if (this.p == 0) {
            r0Var.j(nx0.v(oa0Var.e, oa0Var.f, iN1, 1, false, false));
        } else {
            r0Var.j(nx0.v(iN1, 1, oa0Var.e, oa0Var.f, false, false));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v37 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void Y0(c91 c91Var, i91 i91Var, nn0 nn0Var, mn0 mn0Var) {
        int i;
        int i2;
        int i3;
        int iD;
        int iG;
        int I;
        int iD2;
        int iW;
        int iW2;
        ?? r8;
        int i4;
        View viewB;
        int iJ = this.r.j();
        boolean z = iJ != 1073741824;
        int i5 = v() > 0 ? this.G[this.F] : 0;
        if (z) {
            s1();
        }
        boolean z2 = nn0Var.e == 1;
        int iO1 = this.F;
        if (!z2) {
            iO1 = o1(nn0Var.d, c91Var, i91Var) + p1(nn0Var.d, c91Var, i91Var);
        }
        int i6 = 0;
        while (i6 < this.F && (i4 = nn0Var.d) >= 0 && i4 < i91Var.b() && iO1 > 0) {
            int i7 = nn0Var.d;
            int iP1 = p1(i7, c91Var, i91Var);
            if (iP1 > this.F) {
                throw new IllegalArgumentException(uo.j(uo.n("Item at position ", i7, " requires ", iP1, " spans but GridLayoutManager has only "), this.F, " spans."));
            }
            iO1 -= iP1;
            if (iO1 < 0 || (viewB = nn0Var.b(c91Var)) == null) {
                break;
            }
            this.H[i6] = viewB;
            i6++;
        }
        if (i6 == 0) {
            mn0Var.b = true;
            return;
        }
        if (z2) {
            i2 = i6;
            i = 0;
            i3 = 1;
        } else {
            i = i6 - 1;
            i2 = -1;
            i3 = -1;
        }
        int i8 = 0;
        while (i != i2) {
            View view = this.H[i];
            oa0 oa0Var = (oa0) view.getLayoutParams();
            int iP12 = p1(u81.J(view), c91Var, i91Var);
            oa0Var.f = iP12;
            oa0Var.e = i8;
            i8 += iP12;
            i += i3;
        }
        float f = 0.0f;
        int i9 = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            View view2 = this.H[i10];
            if (nn0Var.k != null) {
                r8 = 0;
                r8 = 0;
                if (z2) {
                    b(view2, -1, true);
                } else {
                    b(view2, 0, true);
                }
            } else if (z2) {
                r8 = 0;
                b(view2, -1, false);
            } else {
                r8 = 0;
                b(view2, 0, false);
            }
            RecyclerView recyclerView = this.b;
            Rect rect = this.L;
            if (recyclerView == null) {
                rect.set(r8, r8, r8, r8);
            } else {
                rect.set(recyclerView.R(view2));
            }
            q1(view2, iJ, r8);
            int iC = this.r.c(view2);
            if (iC > i9) {
                i9 = iC;
            }
            float fD = (this.r.d(view2) * 1.0f) / ((oa0) view2.getLayoutParams()).f;
            if (fD > f) {
                f = fD;
            }
        }
        if (z) {
            k1(Math.max(Math.round(f * this.F), i5));
            i9 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                View view3 = this.H[i11];
                q1(view3, 1073741824, true);
                int iC2 = this.r.c(view3);
                if (iC2 > i9) {
                    i9 = iC2;
                }
            }
        }
        for (int i12 = 0; i12 < i6; i12++) {
            View view4 = this.H[i12];
            if (this.r.c(view4) != i9) {
                oa0 oa0Var2 = (oa0) view4.getLayoutParams();
                Rect rect2 = oa0Var2.b;
                int i13 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) oa0Var2).topMargin + ((ViewGroup.MarginLayoutParams) oa0Var2).bottomMargin;
                int i14 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) oa0Var2).leftMargin + ((ViewGroup.MarginLayoutParams) oa0Var2).rightMargin;
                int iM1 = m1(oa0Var2.e, oa0Var2.f);
                if (this.p == 1) {
                    iW2 = u81.w(false, iM1, 1073741824, i14, ((ViewGroup.MarginLayoutParams) oa0Var2).width);
                    iW = View.MeasureSpec.makeMeasureSpec(i9 - i13, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - i14, 1073741824);
                    iW = u81.w(false, iM1, 1073741824, i13, ((ViewGroup.MarginLayoutParams) oa0Var2).height);
                    iW2 = iMakeMeasureSpec;
                }
                if (A0(view4, iW2, iW, (v81) view4.getLayoutParams())) {
                    view4.measure(iW2, iW);
                }
            }
        }
        mn0Var.a = i9;
        if (this.p != 1) {
            if (nn0Var.f == -1) {
                int i15 = nn0Var.b;
                iG = i15 - i9;
                iD = i15;
            } else {
                int i16 = nn0Var.b;
                iD = i16 + i9;
                iG = i16;
            }
            I = 0;
            iD2 = 0;
        } else if (nn0Var.f == -1) {
            iD2 = nn0Var.b;
            I = iD2 - i9;
            iG = 0;
            iD = 0;
        } else {
            int i17 = nn0Var.b;
            I = i17;
            iD = 0;
            iD2 = i17 + i9;
            iG = 0;
        }
        for (int i18 = 0; i18 < i6; i18++) {
            View view5 = this.H[i18];
            oa0 oa0Var3 = (oa0) view5.getLayoutParams();
            if (this.p != 1) {
                I = I() + this.G[oa0Var3.e];
                iD2 = this.r.d(view5) + I;
            } else if (X0()) {
                int iG2 = G() + this.G[this.F - oa0Var3.e];
                iD = iG2;
                iG = iG2 - this.r.d(view5);
            } else {
                iG = G() + this.G[oa0Var3.e];
                iD = this.r.d(view5) + iG;
            }
            u81.P(view5, iG, I, iD, iD2);
            if (oa0Var3.a.m() || oa0Var3.a.p()) {
                mn0Var.c = true;
            }
            mn0Var.d = view5.hasFocusable() | mn0Var.d;
        }
        Arrays.fill(this.H, (Object) null);
    }

    @Override // defpackage.u81
    public final void Z(int i, int i2) {
        this.K.f();
        ((SparseIntArray) this.K.c).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void Z0(c91 c91Var, i91 i91Var, ln0 ln0Var, int i) {
        s1();
        if (i91Var.b() > 0 && !i91Var.g) {
            boolean z = i == 1;
            int iO1 = o1(ln0Var.b, c91Var, i91Var);
            if (z) {
                while (iO1 > 0) {
                    int i2 = ln0Var.b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    ln0Var.b = i3;
                    iO1 = o1(i3, c91Var, i91Var);
                }
            } else {
                int iB = i91Var.b() - 1;
                int i4 = ln0Var.b;
                while (i4 < iB) {
                    int i5 = i4 + 1;
                    int iO12 = o1(i5, c91Var, i91Var);
                    if (iO12 <= iO1) {
                        break;
                    }
                    i4 = i5;
                    iO1 = iO12;
                }
                ln0Var.b = i4;
            }
        }
        l1();
    }

    @Override // defpackage.u81
    public final void a0() {
        this.K.f();
        ((SparseIntArray) this.K.c).clear();
    }

    @Override // defpackage.u81
    public final void b0(int i, int i2) {
        this.K.f();
        ((SparseIntArray) this.K.c).clear();
    }

    @Override // defpackage.u81
    public final void c0(int i, int i2) {
        this.K.f();
        ((SparseIntArray) this.K.c).clear();
    }

    @Override // defpackage.u81
    public final void d0(int i, int i2) {
        this.K.f();
        ((SparseIntArray) this.K.c).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final void e0(c91 c91Var, i91 i91Var) {
        boolean z = i91Var.g;
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z) {
            int iV = v();
            for (int i = 0; i < iV; i++) {
                oa0 oa0Var = (oa0) u(i).getLayoutParams();
                int iF = oa0Var.a.f();
                sparseIntArray2.put(iF, oa0Var.f);
                sparseIntArray.put(iF, oa0Var.e);
            }
        }
        super.e0(c91Var, i91Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // defpackage.u81
    public final boolean f(v81 v81Var) {
        return v81Var instanceof oa0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final void f0(i91 i91Var) {
        super.f0(i91Var);
        this.E = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void g1(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.g1(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final int k(i91 i91Var) {
        return H0(i91Var);
    }

    public final void k1(int i) {
        int i2;
        int[] iArr = this.G;
        int i3 = this.F;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.G = iArr;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final int l(i91 i91Var) {
        return I0(i91Var);
    }

    public final void l1() {
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    public final int m1(int i, int i2) {
        if (this.p != 1 || !X0()) {
            int[] iArr = this.G;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.G;
        int i3 = this.F;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final int n(i91 i91Var) {
        return H0(i91Var);
    }

    public final int n1(int i, c91 c91Var, i91 i91Var) {
        if (!i91Var.g) {
            return this.K.b(i, this.F);
        }
        int iB = c91Var.b(i);
        if (iB == -1) {
            return 0;
        }
        return this.K.b(iB, this.F);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final int o(i91 i91Var) {
        return I0(i91Var);
    }

    public final int o1(int i, c91 c91Var, i91 i91Var) {
        if (!i91Var.g) {
            pa0 pa0Var = this.K;
            int i2 = this.F;
            if (!pa0Var.a) {
                return pa0Var.c(i, i2);
            }
            SparseIntArray sparseIntArray = (SparseIntArray) pa0Var.b;
            int i3 = sparseIntArray.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iC = pa0Var.c(i, i2);
            sparseIntArray.put(i, iC);
            return iC;
        }
        int i4 = this.J.get(i, -1);
        if (i4 != -1) {
            return i4;
        }
        int iB = c91Var.b(i);
        if (iB == -1) {
            return 0;
        }
        pa0 pa0Var2 = this.K;
        int i5 = this.F;
        if (!pa0Var2.a) {
            return pa0Var2.c(iB, i5);
        }
        SparseIntArray sparseIntArray2 = (SparseIntArray) pa0Var2.b;
        int i6 = sparseIntArray2.get(iB, -1);
        if (i6 != -1) {
            return i6;
        }
        int iC2 = pa0Var2.c(iB, i5);
        sparseIntArray2.put(iB, iC2);
        return iC2;
    }

    public final int p1(int i, c91 c91Var, i91 i91Var) {
        if (!i91Var.g) {
            return this.K.d(i);
        }
        int i2 = this.I.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = c91Var.b(i);
        if (iB == -1) {
            return 1;
        }
        return this.K.d(iB);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final int q0(int i, c91 c91Var, i91 i91Var) {
        s1();
        l1();
        return super.q0(i, c91Var, i91Var);
    }

    public final void q1(View view, int i, boolean z) {
        int iW;
        int iW2;
        oa0 oa0Var = (oa0) view.getLayoutParams();
        Rect rect = oa0Var.b;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) oa0Var).topMargin + ((ViewGroup.MarginLayoutParams) oa0Var).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) oa0Var).leftMargin + ((ViewGroup.MarginLayoutParams) oa0Var).rightMargin;
        int iM1 = m1(oa0Var.e, oa0Var.f);
        if (this.p == 1) {
            iW2 = u81.w(false, iM1, i, i3, ((ViewGroup.MarginLayoutParams) oa0Var).width);
            iW = u81.w(true, this.r.l(), this.m, i2, ((ViewGroup.MarginLayoutParams) oa0Var).height);
        } else {
            int iW3 = u81.w(false, iM1, i, i2, ((ViewGroup.MarginLayoutParams) oa0Var).height);
            int iW4 = u81.w(true, this.r.l(), this.l, i3, ((ViewGroup.MarginLayoutParams) oa0Var).width);
            iW = iW3;
            iW2 = iW4;
        }
        v81 v81Var = (v81) view.getLayoutParams();
        if (z ? A0(view, iW2, iW, v81Var) : y0(view, iW2, iW, v81Var)) {
            view.measure(iW2, iW);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final v81 r() {
        return this.p == 0 ? new oa0(-2, -1) : new oa0(-1, -2);
    }

    public final void r1(int i) {
        if (i == this.F) {
            return;
        }
        this.E = true;
        if (i < 1) {
            throw new IllegalArgumentException(k31.k(i, "Span count should be at least 1. Provided "));
        }
        this.F = i;
        this.K.f();
        p0();
    }

    @Override // defpackage.u81
    public final v81 s(Context context, AttributeSet attributeSet) {
        oa0 oa0Var = new oa0(context, attributeSet);
        oa0Var.e = -1;
        oa0Var.f = 0;
        return oa0Var;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final int s0(int i, c91 c91Var, i91 i91Var) {
        s1();
        l1();
        return super.s0(i, c91Var, i91Var);
    }

    public final void s1() {
        int iF;
        int I;
        if (this.p == 1) {
            iF = this.n - H();
            I = G();
        } else {
            iF = this.o - F();
            I = I();
        }
        k1(iF - I);
    }

    @Override // defpackage.u81
    public final v81 t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            oa0 oa0Var = new oa0((ViewGroup.MarginLayoutParams) layoutParams);
            oa0Var.e = -1;
            oa0Var.f = 0;
            return oa0Var;
        }
        oa0 oa0Var2 = new oa0(layoutParams);
        oa0Var2.e = -1;
        oa0Var2.f = 0;
        return oa0Var2;
    }

    @Override // defpackage.u81
    public final void v0(int i, int i2, Rect rect) {
        int iG;
        int iG2;
        if (this.G == null) {
            super.v0(i, i2, rect);
        }
        int iH = H() + G();
        int iF = F() + I();
        if (this.p == 1) {
            int iHeight = rect.height() + iF;
            RecyclerView recyclerView = this.b;
            WeakHashMap weakHashMap = qs1.a;
            iG2 = u81.g(i2, iHeight, recyclerView.getMinimumHeight());
            int[] iArr = this.G;
            iG = u81.g(i, iArr[iArr.length - 1] + iH, this.b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iH;
            RecyclerView recyclerView2 = this.b;
            WeakHashMap weakHashMap2 = qs1.a;
            iG = u81.g(i, iWidth, recyclerView2.getMinimumWidth());
            int[] iArr2 = this.G;
            iG2 = u81.g(i2, iArr2[iArr2.length - 1] + iF, this.b.getMinimumHeight());
        }
        this.b.setMeasuredDimension(iG, iG2);
    }

    @Override // defpackage.u81
    public final int x(c91 c91Var, i91 i91Var) {
        if (this.p == 1) {
            return this.F;
        }
        if (i91Var.b() < 1) {
            return 0;
        }
        return n1(i91Var.b() - 1, c91Var, i91Var) + 1;
    }

    public GridLayoutManager(int i, int i2) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new na0();
        this.L = new Rect();
        r1(i);
    }

    public GridLayoutManager(int i) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new na0();
        this.L = new Rect();
        r1(i);
    }
}
