package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class u81 {
    public ei a;
    public RecyclerView b;
    public final q11 c;
    public final q11 d;
    public pn0 e;
    public boolean f;
    public boolean g;
    public final boolean h;
    public final boolean i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;

    public u81() {
        fz1 fz1Var = new fz1(this, 24);
        mc1 mc1Var = new mc1(this, 21);
        this.c = new q11(fz1Var);
        this.d = new q11(mc1Var);
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = true;
    }

    public static int A(View view) {
        return view.getLeft() - ((v81) view.getLayoutParams()).b.left;
    }

    public static int B(View view) {
        Rect rect = ((v81) view.getLayoutParams()).b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public static int C(View view) {
        return view.getRight() + ((v81) view.getLayoutParams()).b.right;
    }

    public static int D(View view) {
        return view.getTop() - ((v81) view.getLayoutParams()).b.top;
    }

    public static int J(View view) {
        return ((v81) view.getLayoutParams()).a.f();
    }

    public static t81 K(Context context, AttributeSet attributeSet, int i, int i2) {
        t81 t81Var = new t81();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p71.RecyclerView, i, i2);
        t81Var.a = typedArrayObtainStyledAttributes.getInt(p71.RecyclerView_android_orientation, 1);
        t81Var.b = typedArrayObtainStyledAttributes.getInt(p71.RecyclerView_spanCount, 1);
        t81Var.c = typedArrayObtainStyledAttributes.getBoolean(p71.RecyclerView_reverseLayout, false);
        t81Var.d = typedArrayObtainStyledAttributes.getBoolean(p71.RecyclerView_stackFromEnd, false);
        typedArrayObtainStyledAttributes.recycle();
        return t81Var;
    }

    public static boolean O(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    public static void P(View view, int i, int i2, int i3, int i4) {
        v81 v81Var = (v81) view.getLayoutParams();
        Rect rect = v81Var.b;
        view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) v81Var).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) v81Var).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) v81Var).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) v81Var).bottomMargin);
    }

    public static int g(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            int r5 = r5 - r7
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L1e
            if (r8 < 0) goto L13
        L10:
            r6 = 1073741824(0x40000000, float:2.0)
            goto L32
        L13:
            if (r8 != r1) goto L1b
            if (r6 == r2) goto L23
            if (r6 == 0) goto L1b
            if (r6 == r3) goto L23
        L1b:
            r6 = 0
            r8 = 0
            goto L32
        L1e:
            if (r8 < 0) goto L21
            goto L10
        L21:
            if (r8 != r1) goto L25
        L23:
            r8 = r5
            goto L32
        L25:
            if (r8 != r0) goto L1b
            if (r6 == r2) goto L2f
            if (r6 != r3) goto L2c
            goto L2f
        L2c:
            r8 = r5
            r6 = 0
            goto L32
        L2f:
            r8 = r5
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
        L32:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u81.w(boolean, int, int, int, int):int");
    }

    public static int y(View view) {
        return view.getBottom() + ((v81) view.getLayoutParams()).b.bottom;
    }

    public static void z(View view, Rect rect) {
        boolean z = RecyclerView.G0;
        v81 v81Var = (v81) view.getLayoutParams();
        Rect rect2 = v81Var.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) v81Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) v81Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) v81Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) v81Var).bottomMargin);
    }

    public final boolean A0(View view, int i, int i2, v81 v81Var) {
        return (this.h && O(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) v81Var).width) && O(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) v81Var).height)) ? false : true;
    }

    public abstract void B0(RecyclerView recyclerView, int i);

    public final void C0(pn0 pn0Var) {
        pn0 pn0Var2 = this.e;
        if (pn0Var2 != null && pn0Var != pn0Var2 && pn0Var2.e) {
            pn0Var2.g();
        }
        this.e = pn0Var;
        RecyclerView recyclerView = this.b;
        l91 l91Var = recyclerView.k0;
        l91Var.m.removeCallbacks(l91Var);
        l91Var.i.abortAnimation();
        pn0Var.b = recyclerView;
        pn0Var.c = this;
        int i = pn0Var.a;
        if (i == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.n0.a = i;
        pn0Var.e = true;
        pn0Var.d = true;
        pn0Var.f = recyclerView.t.q(i);
        pn0Var.b.k0.b();
    }

    public abstract boolean D0();

    public final int E() {
        RecyclerView recyclerView = this.b;
        WeakHashMap weakHashMap = qs1.a;
        return recyclerView.getLayoutDirection();
    }

    public final int F() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int G() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int H() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int I() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int L(c91 c91Var, i91 i91Var) {
        return -1;
    }

    public final void M(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((v81) view.getLayoutParams()).b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.b.r;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public abstract boolean N();

    public void Q(int i) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            int iG = recyclerView.l.g();
            for (int i2 = 0; i2 < iG; i2++) {
                recyclerView.l.f(i2).offsetLeftAndRight(i);
            }
        }
    }

    public void R(int i) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            int iG = recyclerView.l.g();
            for (int i2 = 0; i2 < iG; i2++) {
                recyclerView.l.f(i2).offsetTopAndBottom(i);
            }
        }
    }

    public abstract void T(RecyclerView recyclerView);

    public abstract View U(View view, int i, c91 c91Var, i91 i91Var);

    public void V(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.b;
        c91 c91Var = recyclerView.i;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z = true;
        if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
            z = false;
        }
        accessibilityEvent.setScrollable(z);
        m81 m81Var = this.b.s;
        if (m81Var != null) {
            accessibilityEvent.setItemCount(m81Var.c());
        }
    }

    public void W(c91 c91Var, i91 i91Var, r0 r0Var) {
        boolean zCanScrollVertically = this.b.canScrollVertically(-1);
        AccessibilityNodeInfo accessibilityNodeInfo = r0Var.a;
        if (zCanScrollVertically || this.b.canScrollHorizontally(-1)) {
            r0Var.a(8192);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
            r0Var.a(MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
            accessibilityNodeInfo.setScrollable(true);
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) mc1.v(L(c91Var, i91Var), x(c91Var, i91Var), 0).h);
    }

    public final void Y(View view, r0 r0Var) {
        m91 m91VarQ = RecyclerView.Q(view);
        if (m91VarQ == null || m91VarQ.m() || ((ArrayList) this.a.e).contains(m91VarQ.g)) {
            return;
        }
        RecyclerView recyclerView = this.b;
        X(recyclerView.i, recyclerView.n0, view, r0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.view.View r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u81.b(android.view.View, int, boolean):void");
    }

    public abstract void c(String str);

    public abstract boolean d();

    public abstract boolean e();

    public abstract void e0(c91 c91Var, i91 i91Var);

    public boolean f(v81 v81Var) {
        return v81Var != null;
    }

    public abstract void f0(i91 i91Var);

    public abstract void g0(Parcelable parcelable);

    public abstract void h(int i, int i2, i91 i91Var, c80 c80Var);

    public abstract Parcelable h0();

    public abstract int j(i91 i91Var);

    /* JADX WARN: Removed duplicated region for block: B:31:0x008b A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean j0(defpackage.c91 r3, defpackage.i91 r4, int r5, android.os.Bundle r6) {
        /*
            r2 = this;
            androidx.recyclerview.widget.RecyclerView r3 = r2.b
            r4 = 0
            if (r3 != 0) goto L7
            goto L8d
        L7:
            int r3 = r2.o
            int r6 = r2.n
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            androidx.recyclerview.widget.RecyclerView r1 = r2.b
            android.graphics.Matrix r1 = r1.getMatrix()
            boolean r1 = r1.isIdentity()
            if (r1 == 0) goto L2c
            androidx.recyclerview.widget.RecyclerView r1 = r2.b
            boolean r1 = r1.getGlobalVisibleRect(r0)
            if (r1 == 0) goto L2c
            int r3 = r0.height()
            int r6 = r0.width()
        L2c:
            r0 = 4096(0x1000, float:5.74E-42)
            r1 = 1
            if (r5 == r0) goto L62
            r0 = 8192(0x2000, float:1.148E-41)
            if (r5 == r0) goto L38
            r3 = 0
        L36:
            r5 = 0
            goto L89
        L38:
            androidx.recyclerview.widget.RecyclerView r5 = r2.b
            r0 = -1
            boolean r5 = r5.canScrollVertically(r0)
            if (r5 == 0) goto L4d
            int r5 = r2.I()
            int r3 = r3 - r5
            int r5 = r2.F()
            int r3 = r3 - r5
            int r3 = -r3
            goto L4e
        L4d:
            r3 = 0
        L4e:
            androidx.recyclerview.widget.RecyclerView r5 = r2.b
            boolean r5 = r5.canScrollHorizontally(r0)
            if (r5 == 0) goto L36
            int r5 = r2.G()
            int r6 = r6 - r5
            int r5 = r2.H()
            int r6 = r6 - r5
            int r5 = -r6
            goto L89
        L62:
            androidx.recyclerview.widget.RecyclerView r5 = r2.b
            boolean r5 = r5.canScrollVertically(r1)
            if (r5 == 0) goto L75
            int r5 = r2.I()
            int r3 = r3 - r5
            int r5 = r2.F()
            int r3 = r3 - r5
            goto L76
        L75:
            r3 = 0
        L76:
            androidx.recyclerview.widget.RecyclerView r5 = r2.b
            boolean r5 = r5.canScrollHorizontally(r1)
            if (r5 == 0) goto L36
            int r5 = r2.G()
            int r6 = r6 - r5
            int r5 = r2.H()
            int r5 = r6 - r5
        L89:
            if (r3 != 0) goto L8e
            if (r5 != 0) goto L8e
        L8d:
            return r4
        L8e:
            androidx.recyclerview.widget.RecyclerView r4 = r2.b
            r4.n0(r5, r3, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u81.j0(c91, i91, int, android.os.Bundle):boolean");
    }

    public abstract int k(i91 i91Var);

    public final void k0(c91 c91Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            if (!RecyclerView.Q(u(iV)).t()) {
                View viewU = u(iV);
                n0(iV);
                c91Var.h(viewU);
            }
        }
    }

    public abstract int l(i91 i91Var);

    public final void l0(c91 c91Var) {
        ArrayList arrayList;
        int size = c91Var.a.size();
        int i = size - 1;
        while (true) {
            arrayList = c91Var.a;
            if (i < 0) {
                break;
            }
            View view = ((m91) arrayList.get(i)).g;
            m91 m91VarQ = RecyclerView.Q(view);
            if (!m91VarQ.t()) {
                m91VarQ.s(false);
                if (m91VarQ.o()) {
                    this.b.removeDetachedView(view, false);
                }
                r81 r81Var = this.b.S;
                if (r81Var != null) {
                    r81Var.d(m91VarQ);
                }
                m91VarQ.s(true);
                m91 m91VarQ2 = RecyclerView.Q(view);
                m91VarQ2.t = null;
                m91VarQ2.u = false;
                m91VarQ2.p &= -33;
                c91Var.i(m91VarQ2);
            }
            i--;
        }
        arrayList.clear();
        ArrayList arrayList2 = c91Var.b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.b.invalidate();
        }
    }

    public abstract int m(i91 i91Var);

    public final void m0(View view, c91 c91Var) {
        ei eiVar = this.a;
        mc1 mc1Var = (mc1) eiVar.c;
        int i = eiVar.b;
        if (i == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            eiVar.b = 1;
            eiVar.f = view;
            int iIndexOfChild = ((RecyclerView) mc1Var.h).indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (((di) eiVar.d).f(iIndexOfChild)) {
                    eiVar.r(view);
                }
                mc1Var.A(iIndexOfChild);
            }
            eiVar.b = 0;
            eiVar.f = null;
            c91Var.h(view);
        } catch (Throwable th) {
            eiVar.b = 0;
            eiVar.f = null;
            throw th;
        }
    }

    public abstract int n(i91 i91Var);

    public final void n0(int i) {
        if (u(i) != null) {
            ei eiVar = this.a;
            mc1 mc1Var = (mc1) eiVar.c;
            int i2 = eiVar.b;
            if (i2 == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            }
            if (i2 == 2) {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            try {
                int iH = eiVar.h(i);
                View childAt = ((RecyclerView) mc1Var.h).getChildAt(iH);
                if (childAt != null) {
                    eiVar.b = 1;
                    eiVar.f = childAt;
                    if (((di) eiVar.d).f(iH)) {
                        eiVar.r(childAt);
                    }
                    mc1Var.A(iH);
                }
                eiVar.b = 0;
                eiVar.f = null;
            } catch (Throwable th) {
                eiVar.b = 0;
                eiVar.f = null;
                throw th;
            }
        }
    }

    public abstract int o(i91 i91Var);

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.G()
            int r1 = r8.I()
            int r2 = r8.n
            int r3 = r8.H()
            int r2 = r2 - r3
            int r3 = r8.o
            int r4 = r8.F()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.E()
            r7 = 1
            if (r3 != r7) goto L5c
            if (r2 == 0) goto L57
            goto L64
        L57:
            int r2 = java.lang.Math.max(r6, r10)
            goto L64
        L5c:
            if (r6 == 0) goto L5f
            goto L63
        L5f:
            int r6 = java.lang.Math.min(r4, r2)
        L63:
            r2 = r6
        L64:
            if (r1 == 0) goto L67
            goto L6b
        L67:
            int r1 = java.lang.Math.min(r5, r11)
        L6b:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lae
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L7c
            goto Lb3
        L7c:
            int r1 = r8.G()
            int r2 = r8.I()
            int r3 = r8.n
            int r4 = r8.H()
            int r3 = r3 - r4
            int r4 = r8.o
            int r5 = r8.F()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.b
            android.graphics.Rect r5 = r5.p
            z(r13, r5)
            int r13 = r5.left
            int r13 = r13 - r11
            if (r13 >= r3) goto Lb3
            int r13 = r5.right
            int r13 = r13 - r11
            if (r13 <= r1) goto Lb3
            int r13 = r5.top
            int r13 = r13 - r10
            if (r13 >= r4) goto Lb3
            int r13 = r5.bottom
            int r13 = r13 - r10
            if (r13 > r2) goto Lae
            goto Lb3
        Lae:
            if (r11 != 0) goto Lb4
            if (r10 == 0) goto Lb3
            goto Lb4
        Lb3:
            return r0
        Lb4:
            if (r12 == 0) goto Lba
            r9.scrollBy(r11, r10)
            return r7
        Lba:
            r9.n0(r11, r10, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u81.o0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public final void p(c91 c91Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            m91 m91VarQ = RecyclerView.Q(viewU);
            if (m91VarQ.t()) {
                if (RecyclerView.H0) {
                    m91VarQ.toString();
                }
            } else if (!m91VarQ.k() || m91VarQ.m() || this.b.s.h) {
                u(iV);
                this.a.e(iV);
                c91Var.j(viewU);
                this.b.m.n(m91VarQ);
            } else {
                n0(iV);
                c91Var.i(m91VarQ);
            }
        }
    }

    public final void p0() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public View q(int i) {
        int iV = v();
        for (int i2 = 0; i2 < iV; i2++) {
            View viewU = u(i2);
            m91 m91VarQ = RecyclerView.Q(viewU);
            if (m91VarQ != null && m91VarQ.f() == i && !m91VarQ.t() && (this.b.n0.g || !m91VarQ.m())) {
                return viewU;
            }
        }
        return null;
    }

    public abstract int q0(int i, c91 c91Var, i91 i91Var);

    public abstract v81 r();

    public abstract void r0(int i);

    public v81 s(Context context, AttributeSet attributeSet) {
        return new v81(context, attributeSet);
    }

    public abstract int s0(int i, c91 c91Var, i91 i91Var);

    public v81 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof v81 ? new v81((v81) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new v81((ViewGroup.MarginLayoutParams) layoutParams) : new v81(layoutParams);
    }

    public final void t0(RecyclerView recyclerView) {
        u0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public final View u(int i) {
        ei eiVar = this.a;
        if (eiVar != null) {
            return eiVar.f(i);
        }
        return null;
    }

    public final void u0(int i, int i2) {
        this.n = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        this.l = mode;
        if (mode == 0 && !RecyclerView.K0) {
            this.n = 0;
        }
        this.o = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.m = mode2;
        if (mode2 != 0 || RecyclerView.K0) {
            return;
        }
        this.o = 0;
    }

    public final int v() {
        ei eiVar = this.a;
        if (eiVar != null) {
            return eiVar.g();
        }
        return 0;
    }

    public void v0(int i, int i2, Rect rect) {
        int iH = H() + G() + rect.width();
        int iF = F() + I() + rect.height();
        RecyclerView recyclerView = this.b;
        WeakHashMap weakHashMap = qs1.a;
        this.b.setMeasuredDimension(g(i, iH, recyclerView.getMinimumWidth()), g(i2, iF, this.b.getMinimumHeight()));
    }

    public final void w0(int i, int i2) {
        int iV = v();
        if (iV == 0) {
            this.b.s(i, i2);
            return;
        }
        int i3 = RtlSpacingHelper.UNDEFINED;
        int i4 = RtlSpacingHelper.UNDEFINED;
        int i5 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i6 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i7 = 0; i7 < iV; i7++) {
            View viewU = u(i7);
            Rect rect = this.b.p;
            z(viewU, rect);
            int i8 = rect.left;
            if (i8 < i5) {
                i5 = i8;
            }
            int i9 = rect.right;
            if (i9 > i3) {
                i3 = i9;
            }
            int i10 = rect.top;
            if (i10 < i6) {
                i6 = i10;
            }
            int i11 = rect.bottom;
            if (i11 > i4) {
                i4 = i11;
            }
        }
        this.b.p.set(i5, i6, i3, i4);
        v0(i, i2, this.b.p);
    }

    public int x(c91 c91Var, i91 i91Var) {
        return -1;
    }

    public final void x0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.b = null;
            this.a = null;
            this.n = 0;
            this.o = 0;
        } else {
            this.b = recyclerView;
            this.a = recyclerView.l;
            this.n = recyclerView.getWidth();
            this.o = recyclerView.getHeight();
        }
        this.l = 1073741824;
        this.m = 1073741824;
    }

    public final boolean y0(View view, int i, int i2, v81 v81Var) {
        return (!view.isLayoutRequested() && this.h && O(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) v81Var).width) && O(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) v81Var).height)) ? false : true;
    }

    public boolean z0() {
        return false;
    }

    public void S() {
    }

    public void a0() {
    }

    public void i0(int i) {
    }

    public void Z(int i, int i2) {
    }

    public void b0(int i, int i2) {
    }

    public void c0(int i, int i2) {
    }

    public void d0(int i, int i2) {
    }

    public void i(int i, c80 c80Var) {
    }

    public void X(c91 c91Var, i91 i91Var, View view, r0 r0Var) {
    }
}
