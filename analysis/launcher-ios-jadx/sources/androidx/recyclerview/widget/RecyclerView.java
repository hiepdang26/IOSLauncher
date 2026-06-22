package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.a91;
import defpackage.ao;
import defpackage.b91;
import defpackage.c51;
import defpackage.c80;
import defpackage.c91;
import defpackage.d91;
import defpackage.di;
import defpackage.e80;
import defpackage.e91;
import defpackage.ei;
import defpackage.f91;
import defpackage.fz1;
import defpackage.hs1;
import defpackage.i21;
import defpackage.i91;
import defpackage.ib;
import defpackage.j21;
import defpackage.j91;
import defpackage.k91;
import defpackage.ks1;
import defpackage.l81;
import defpackage.l91;
import defpackage.lt;
import defpackage.m81;
import defpackage.m91;
import defpackage.mc1;
import defpackage.md;
import defpackage.no1;
import defpackage.nx0;
import defpackage.o91;
import defpackage.ow1;
import defpackage.p41;
import defpackage.p71;
import defpackage.p81;
import defpackage.pn0;
import defpackage.q81;
import defpackage.qs1;
import defpackage.r20;
import defpackage.r81;
import defpackage.rs1;
import defpackage.s81;
import defpackage.tu;
import defpackage.u81;
import defpackage.ug1;
import defpackage.uo;
import defpackage.v81;
import defpackage.vw0;
import defpackage.w81;
import defpackage.wd;
import defpackage.x2;
import defpackage.x81;
import defpackage.xj;
import defpackage.xp0;
import defpackage.y2;
import defpackage.y81;
import defpackage.ys1;
import defpackage.z81;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup {
    public static boolean G0 = false;
    public static boolean H0 = false;
    public static final int[] I0 = {R.attr.nestedScrollingEnabled};
    public static final float J0 = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean K0;
    public static final boolean L0;
    public static final boolean M0;
    public static final Class[] N0;
    public static final md O0;
    public static final j91 P0;
    public boolean A;
    public final ArrayList A0;
    public int B;
    public final l81 B0;
    public boolean C;
    public boolean C0;
    public boolean D;
    public int D0;
    public boolean E;
    public int E0;
    public int F;
    public final fz1 F0;
    public boolean G;
    public final AccessibilityManager H;
    public ArrayList I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public q81 N;
    public EdgeEffect O;
    public EdgeEffect P;
    public EdgeEffect Q;
    public EdgeEffect R;
    public r81 S;
    public int T;
    public int U;
    public VelocityTracker V;
    public int W;
    public int a0;
    public int b0;
    public int c0;
    public int d0;
    public x81 e0;
    public final int f0;
    public final float g;
    public final int g0;
    public final e91 h;
    public final float h0;
    public final c91 i;
    public final float i0;
    public f91 j;
    public boolean j0;
    public final y2 k;
    public final l91 k0;
    public final ei l;
    public e80 l0;
    public final tu m;
    public final c80 m0;
    public boolean n;
    public final i91 n0;
    public final l81 o;
    public z81 o0;
    public final Rect p;
    public ArrayList p0;
    public final Rect q;
    public boolean q0;
    public final RectF r;
    public boolean r0;
    public m81 s;
    public final ow1 s0;
    public u81 t;
    public boolean t0;
    public final ArrayList u;
    public o91 u0;
    public final ArrayList v;
    public final int[] v0;
    public final ArrayList w;
    public vw0 w0;
    public y81 x;
    public final int[] x0;
    public boolean y;
    public final int[] y0;
    public boolean z;
    public final int[] z0;

    static {
        K0 = Build.VERSION.SDK_INT >= 23;
        L0 = true;
        M0 = true;
        Class cls = Integer.TYPE;
        N0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        O0 = new md(4);
        P0 = new j91();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p41.recyclerViewStyle);
    }

    public static RecyclerView K(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewK = K(viewGroup.getChildAt(i));
            if (recyclerViewK != null) {
                return recyclerViewK;
            }
        }
        return null;
    }

    public static int O(View view) {
        m91 m91VarQ = Q(view);
        if (m91VarQ != null) {
            return m91VarQ.d();
        }
        return -1;
    }

    public static m91 Q(View view) {
        if (view == null) {
            return null;
        }
        return ((v81) view.getLayoutParams()).a;
    }

    private vw0 getScrollingChildHelper() {
        if (this.w0 == null) {
            this.w0 = new vw0(this);
        }
        return this.w0;
    }

    public static void n(m91 m91Var) {
        WeakReference weakReference = m91Var.h;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == m91Var.g) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            m91Var.h = null;
        }
    }

    public static int q(int i, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i2) {
        if (i > 0 && edgeEffect != null && wd.s(edgeEffect) != 0.0f) {
            int iRound = Math.round(wd.y(edgeEffect, ((-i) * 4.0f) / i2, 0.5f) * ((-i2) / 4.0f));
            if (iRound != i) {
                edgeEffect.finish();
            }
            return i - iRound;
        }
        if (i >= 0 || edgeEffect2 == null || wd.s(edgeEffect2) == 0.0f) {
            return i;
        }
        float f = i2;
        int iRound2 = Math.round(wd.y(edgeEffect2, (i * 4.0f) / f, 0.5f) * (f / 4.0f));
        if (iRound2 != i) {
            edgeEffect2.finish();
        }
        return i - iRound2;
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        G0 = z;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        H0 = z;
    }

    public final void A(int i, int i2) {
        this.M++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        z81 z81Var = this.o0;
        if (z81Var != null) {
            z81Var.b(this, i, i2);
        }
        ArrayList arrayList = this.p0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((z81) this.p0.get(size)).b(this, i, i2);
            }
        }
        this.M--;
    }

    public final void B() {
        if (this.R != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.N.a(this, 3);
        this.R = edgeEffectA;
        if (this.n) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void C() {
        if (this.O != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.N.a(this, 0);
        this.O = edgeEffectA;
        if (this.n) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void D() {
        if (this.Q != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.N.a(this, 2);
        this.Q = edgeEffectA;
        if (this.n) {
            edgeEffectA.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectA.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void E() {
        if (this.P != null) {
            return;
        }
        EdgeEffect edgeEffectA = this.N.a(this, 1);
        this.P = edgeEffectA;
        if (this.n) {
            edgeEffectA.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectA.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String F() {
        return " " + super.toString() + ", adapter:" + this.s + ", layout:" + this.t + ", context:" + getContext();
    }

    public final void G(i91 i91Var) {
        if (getScrollState() != 2) {
            i91Var.getClass();
            return;
        }
        OverScroller overScroller = this.k0.i;
        overScroller.getFinalX();
        overScroller.getCurrX();
        i91Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final View H(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final boolean I(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.w;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            y81 y81Var = (y81) arrayList.get(i);
            if (y81Var.c(motionEvent) && action != 3) {
                this.x = y81Var;
                return true;
            }
        }
        return false;
    }

    public final void J(int[] iArr) {
        int iG = this.l.g();
        if (iG == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = RtlSpacingHelper.UNDEFINED;
        for (int i3 = 0; i3 < iG; i3++) {
            m91 m91VarQ = Q(this.l.f(i3));
            if (!m91VarQ.t()) {
                int iF = m91VarQ.f();
                if (iF < i) {
                    i = iF;
                }
                if (iF > i2) {
                    i2 = iF;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public final m91 L(int i) {
        m91 m91Var = null;
        if (this.J) {
            return null;
        }
        int iK = this.l.k();
        for (int i2 = 0; i2 < iK; i2++) {
            m91 m91VarQ = Q(this.l.j(i2));
            if (m91VarQ != null && !m91VarQ.m() && M(m91VarQ) == i) {
                if (!((ArrayList) this.l.e).contains(m91VarQ.g)) {
                    return m91VarQ;
                }
                m91Var = m91VarQ;
            }
        }
        return m91Var;
    }

    public final int M(m91 m91Var) {
        if (((m91Var.p & 524) != 0) || !m91Var.j()) {
            return -1;
        }
        y2 y2Var = this.k;
        int i = m91Var.i;
        ArrayList arrayList = (ArrayList) y2Var.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            x2 x2Var = (x2) arrayList.get(i2);
            int i3 = x2Var.a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = x2Var.b;
                    if (i4 <= i) {
                        int i5 = x2Var.d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = x2Var.b;
                    if (i6 == i) {
                        i = x2Var.d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (x2Var.d <= i) {
                            i++;
                        }
                    }
                }
            } else if (x2Var.b <= i) {
                i += x2Var.d;
            }
        }
        return i;
    }

    public final long N(m91 m91Var) {
        return this.s.h ? m91Var.k : m91Var.i;
    }

    public final m91 P(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return Q(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect R(View view) {
        v81 v81Var = (v81) view.getLayoutParams();
        boolean z = v81Var.c;
        Rect rect = v81Var.b;
        if (z) {
            i91 i91Var = this.n0;
            if (!i91Var.g || (!v81Var.a.p() && !v81Var.a.k())) {
                rect.set(0, 0, 0, 0);
                ArrayList arrayList = this.v;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Rect rect2 = this.p;
                    rect2.set(0, 0, 0, 0);
                    ((s81) arrayList.get(i)).f(rect2, view, this, i91Var);
                    rect.left += rect2.left;
                    rect.top += rect2.top;
                    rect.right += rect2.right;
                    rect.bottom += rect2.bottom;
                }
                v81Var.c = false;
                return rect;
            }
        }
        return rect;
    }

    public final boolean S() {
        return !this.A || this.J || this.k.h();
    }

    public final boolean T() {
        return this.L > 0;
    }

    public final void U(int i) {
        if (this.t == null) {
            return;
        }
        setScrollState(2);
        this.t.r0(i);
        awakenScrollBars();
    }

    public final void V() {
        int iK = this.l.k();
        for (int i = 0; i < iK; i++) {
            ((v81) this.l.j(i).getLayoutParams()).c = true;
        }
        ArrayList arrayList = this.i.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            v81 v81Var = (v81) ((m91) arrayList.get(i2)).g.getLayoutParams();
            if (v81Var != null) {
                v81Var.c = true;
            }
        }
    }

    public final void W(int i, int i2, boolean z) {
        int i3 = i + i2;
        int iK = this.l.k();
        for (int i4 = 0; i4 < iK; i4++) {
            m91 m91VarQ = Q(this.l.j(i4));
            if (m91VarQ != null && !m91VarQ.t()) {
                int i5 = m91VarQ.i;
                i91 i91Var = this.n0;
                if (i5 >= i3) {
                    if (H0) {
                        m91VarQ.toString();
                    }
                    m91VarQ.q(-i2, z);
                    i91Var.f = true;
                } else if (i5 >= i) {
                    if (H0) {
                        m91VarQ.toString();
                    }
                    m91VarQ.c(8);
                    m91VarQ.q(-i2, z);
                    m91VarQ.i = i - 1;
                    i91Var.f = true;
                }
            }
        }
        c91 c91Var = this.i;
        ArrayList arrayList = c91Var.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            m91 m91Var = (m91) arrayList.get(size);
            if (m91Var != null) {
                int i6 = m91Var.i;
                if (i6 >= i3) {
                    if (H0) {
                        m91Var.toString();
                    }
                    m91Var.q(-i2, z);
                } else if (i6 >= i) {
                    m91Var.c(8);
                    c91Var.g(size);
                }
            }
        }
        requestLayout();
    }

    public final void X() {
        this.L++;
    }

    public final void Y(boolean z) {
        int i;
        AccessibilityManager accessibilityManager;
        int i2 = this.L - 1;
        this.L = i2;
        if (i2 < 1) {
            if (G0 && i2 < 0) {
                throw new IllegalStateException(uo.e(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.L = 0;
            if (z) {
                int i3 = this.F;
                this.F = 0;
                if (i3 != 0 && (accessibilityManager = this.H) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i3);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.A0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    m91 m91Var = (m91) arrayList.get(size);
                    if (m91Var.g.getParent() == this && !m91Var.t() && (i = m91Var.w) != -1) {
                        WeakHashMap weakHashMap = qs1.a;
                        m91Var.g.setImportantForAccessibility(i);
                        m91Var.w = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void Z(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.U) {
            int i = actionIndex == 0 ? 1 : 0;
            this.U = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.b0 = x;
            this.W = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.c0 = y;
            this.a0 = y;
        }
    }

    public final void a0() {
        if (this.t0 || !this.y) {
            return;
        }
        WeakHashMap weakHashMap = qs1.a;
        postOnAnimation(this.B0);
        this.t0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        u81 u81Var = this.t;
        if (u81Var != null) {
            u81Var.getClass();
        }
        super.addFocusables(arrayList, i, i2);
    }

    public final void b0() {
        boolean z;
        boolean z2 = false;
        if (this.J) {
            y2 y2Var = this.k;
            y2Var.l((ArrayList) y2Var.c);
            y2Var.l((ArrayList) y2Var.d);
            y2Var.a = 0;
            if (this.K) {
                this.t.a0();
            }
        }
        if (this.S == null || !this.t.D0()) {
            this.k.c();
        } else {
            this.k.k();
        }
        boolean z3 = this.q0 || this.r0;
        boolean z4 = this.A && this.S != null && ((z = this.J) || z3 || this.t.f) && (!z || this.s.h);
        i91 i91Var = this.n0;
        i91Var.j = z4;
        if (z4 && z3 && !this.J && this.S != null && this.t.D0()) {
            z2 = true;
        }
        i91Var.k = z2;
    }

    public final void c0(boolean z) {
        this.K = z | this.K;
        this.J = true;
        int iK = this.l.k();
        for (int i = 0; i < iK; i++) {
            m91 m91VarQ = Q(this.l.j(i));
            if (m91VarQ != null && !m91VarQ.t()) {
                m91VarQ.c(6);
            }
        }
        V();
        c91 c91Var = this.i;
        ArrayList arrayList = c91Var.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            m91 m91Var = (m91) arrayList.get(i2);
            if (m91Var != null) {
                m91Var.c(6);
                m91Var.c(1024);
            }
        }
        m81 m81Var = c91Var.h.s;
        if (m81Var == null || !m81Var.h) {
            c91Var.f();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof v81) && this.t.f((v81) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        u81 u81Var = this.t;
        if (u81Var != null && u81Var.d()) {
            return this.t.j(this.n0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        u81 u81Var = this.t;
        if (u81Var != null && u81Var.d()) {
            return this.t.k(this.n0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        u81 u81Var = this.t;
        if (u81Var != null && u81Var.d()) {
            return this.t.l(this.n0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        u81 u81Var = this.t;
        if (u81Var != null && u81Var.e()) {
            return this.t.m(this.n0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        u81 u81Var = this.t;
        if (u81Var != null && u81Var.e()) {
            return this.t.n(this.n0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        u81 u81Var = this.t;
        if (u81Var != null && u81Var.e()) {
            return this.t.o(this.n0);
        }
        return 0;
    }

    public final void d0(m91 m91Var, ib ibVar) {
        m91Var.p &= -8193;
        boolean z = this.n0.h;
        tu tuVar = this.m;
        if (z && m91Var.p() && !m91Var.m() && !m91Var.t()) {
            ((xp0) tuVar.i).g(N(m91Var), m91Var);
        }
        ug1 ug1Var = (ug1) tuVar.h;
        ys1 ys1VarA = (ys1) ug1Var.get(m91Var);
        if (ys1VarA == null) {
            ys1VarA = ys1.a();
            ug1Var.put(m91Var, ys1VarA);
        }
        ys1VarA.b = ibVar;
        ys1VarA.a |= 4;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().a(f, f2, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().b(f, f2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i, i2, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().d(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        ArrayList arrayList = this.v;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            ((s81) arrayList.get(i)).h(canvas, this);
        }
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.n ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.O;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.n) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.P;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.Q;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.n ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.Q;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.R;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.n) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.R;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.S == null || arrayList.size() <= 0 || !this.S.f()) ? z : true) {
            WeakHashMap weakHashMap = qs1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public final int e0(float f, int i) {
        float height = f / getHeight();
        float width = i / getWidth();
        EdgeEffect edgeEffect = this.O;
        float f2 = 0.0f;
        if (edgeEffect == null || wd.s(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.Q;
            if (edgeEffect2 != null && wd.s(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.Q.onRelease();
                } else {
                    float fY = wd.y(this.Q, width, height);
                    if (wd.s(this.Q) == 0.0f) {
                        this.Q.onRelease();
                    }
                    f2 = fY;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.O.onRelease();
            } else {
                float f3 = -wd.y(this.O, -width, 1.0f - height);
                if (wd.s(this.O) == 0.0f) {
                    this.O.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getWidth());
    }

    public final int f0(float f, int i) {
        float width = f / getWidth();
        float height = i / getHeight();
        EdgeEffect edgeEffect = this.P;
        float f2 = 0.0f;
        if (edgeEffect == null || wd.s(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.R;
            if (edgeEffect2 != null && wd.s(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.R.onRelease();
                } else {
                    float fY = wd.y(this.R, height, 1.0f - width);
                    if (wd.s(this.R) == 0.0f) {
                        this.R.onRelease();
                    }
                    f2 = fY;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.P.onRelease();
            } else {
                float f3 = -wd.y(this.P, -height, width);
                if (wd.s(this.P) == 0.0f) {
                    this.P.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getHeight());
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0194 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d9  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g0(s81 s81Var) {
        u81 u81Var = this.t;
        if (u81Var != null) {
            u81Var.c("Cannot remove item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.v;
        arrayList.remove(s81Var);
        if (arrayList.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        V();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        u81 u81Var = this.t;
        if (u81Var != null) {
            return u81Var.r();
        }
        throw new IllegalStateException(uo.e(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        u81 u81Var = this.t;
        if (u81Var != null) {
            return u81Var.s(getContext(), attributeSet);
        }
        throw new IllegalStateException(uo.e(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public m81 getAdapter() {
        return this.s;
    }

    @Override // android.view.View
    public int getBaseline() {
        u81 u81Var = this.t;
        if (u81Var == null) {
            return super.getBaseline();
        }
        u81Var.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        return super.getChildDrawingOrder(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.n;
    }

    public o91 getCompatAccessibilityDelegate() {
        return this.u0;
    }

    public q81 getEdgeEffectFactory() {
        return this.N;
    }

    public r81 getItemAnimator() {
        return this.S;
    }

    public int getItemDecorationCount() {
        return this.v.size();
    }

    public u81 getLayoutManager() {
        return this.t;
    }

    public int getMaxFlingVelocity() {
        return this.g0;
    }

    public int getMinFlingVelocity() {
        return this.f0;
    }

    public long getNanoTime() {
        if (M0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public x81 getOnFlingListener() {
        return this.e0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.j0;
    }

    public b91 getRecycledViewPool() {
        return this.i.c();
    }

    public int getScrollState() {
        return this.T;
    }

    public final void h0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.p;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof v81) {
            v81 v81Var = (v81) layoutParams;
            if (!v81Var.c) {
                int i = rect.left;
                Rect rect2 = v81Var.b;
                rect.left = i - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.t.o0(this, view, this.p, !this.A, view2 == null);
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i0() {
        VelocityTracker velocityTracker = this.V;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        r0(0);
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.O.isFinished();
        }
        EdgeEffect edgeEffect2 = this.P;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.P.isFinished();
        }
        EdgeEffect edgeEffect3 = this.Q;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect4 = this.R;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.R.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = qs1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.y;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.D;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    public final void j(m91 m91Var) {
        View view = m91Var.g;
        boolean z = view.getParent() == this;
        this.i.l(P(view));
        if (m91Var.o()) {
            this.l.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z) {
            this.l.b(view, -1, true);
            return;
        }
        ei eiVar = this.l;
        int iIndexOfChild = ((RecyclerView) ((mc1) eiVar.c).h).indexOfChild(view);
        if (iIndexOfChild >= 0) {
            ((di) eiVar.d).h(iIndexOfChild);
            eiVar.m(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j0(int r18, int r19, int r20, android.view.MotionEvent r21) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.j0(int, int, int, android.view.MotionEvent):boolean");
    }

    public final void k(s81 s81Var) {
        u81 u81Var = this.t;
        if (u81Var != null) {
            u81Var.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.v;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(s81Var);
        V();
        requestLayout();
    }

    public final void k0(int[] iArr, int i, int i2) {
        m91 m91Var;
        ei eiVar = this.l;
        p0();
        X();
        int i3 = no1.a;
        Trace.beginSection("RV Scroll");
        i91 i91Var = this.n0;
        G(i91Var);
        c91 c91Var = this.i;
        int iQ0 = i != 0 ? this.t.q0(i, c91Var, i91Var) : 0;
        int iS0 = i2 != 0 ? this.t.s0(i2, c91Var, i91Var) : 0;
        Trace.endSection();
        int iG = eiVar.g();
        for (int i4 = 0; i4 < iG; i4++) {
            View viewF = eiVar.f(i4);
            m91 m91VarP = P(viewF);
            if (m91VarP != null && (m91Var = m91VarP.o) != null) {
                int left = viewF.getLeft();
                int top = viewF.getTop();
                View view = m91Var.g;
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        Y(true);
        q0(false);
        if (iArr != null) {
            iArr[0] = iQ0;
            iArr[1] = iS0;
        }
    }

    public final void l(z81 z81Var) {
        if (this.p0 == null) {
            this.p0 = new ArrayList();
        }
        this.p0.add(z81Var);
    }

    public final void l0(int i) {
        if (this.D) {
            return;
        }
        s0();
        u81 u81Var = this.t;
        if (u81Var == null) {
            return;
        }
        u81Var.r0(i);
        awakenScrollBars();
    }

    public final void m(String str) {
        if (T()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(uo.e(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.M > 0) {
            new IllegalStateException(uo.e(this, new StringBuilder("")));
        }
    }

    public final boolean m0(EdgeEffect edgeEffect, int i, int i2) {
        if (i > 0) {
            return true;
        }
        float fS = wd.s(edgeEffect) * i2;
        float fAbs = Math.abs(-i) * 0.35f;
        float f = this.g * 0.015f;
        double dLog = Math.log(fAbs / f);
        double d = J0;
        return ((float) (Math.exp((d / (d - 1.0d)) * dLog) * ((double) f))) < fS;
    }

    public final void n0(int i, int i2, boolean z) {
        u81 u81Var = this.t;
        if (u81Var == null || this.D) {
            return;
        }
        if (!u81Var.d()) {
            i = 0;
        }
        if (!this.t.e()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        if (z) {
            int i3 = i != 0 ? 1 : 0;
            if (i2 != 0) {
                i3 |= 2;
            }
            getScrollingChildHelper().g(i3, 1);
        }
        this.k0.c(i, i2, RtlSpacingHelper.UNDEFINED, null);
    }

    public final void o() {
        int iK = this.l.k();
        for (int i = 0; i < iK; i++) {
            m91 m91VarQ = Q(this.l.j(i));
            if (!m91VarQ.t()) {
                m91VarQ.j = -1;
                m91VarQ.m = -1;
            }
        }
        c91 c91Var = this.i;
        ArrayList arrayList = c91Var.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            m91 m91Var = (m91) arrayList.get(i2);
            m91Var.j = -1;
            m91Var.m = -1;
        }
        ArrayList arrayList2 = c91Var.a;
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            m91 m91Var2 = (m91) arrayList2.get(i3);
            m91Var2.j = -1;
            m91Var2.m = -1;
        }
        ArrayList arrayList3 = c91Var.b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                m91 m91Var3 = (m91) c91Var.b.get(i4);
                m91Var3.j = -1;
                m91Var3.m = -1;
            }
        }
    }

    public final void o0(int i) {
        u81 u81Var;
        if (this.D || (u81Var = this.t) == null) {
            return;
        }
        u81Var.B0(this, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.L = r0
            r1 = 1
            r5.y = r1
            boolean r2 = r5.A
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = 1
            goto L16
        L15:
            r2 = 0
        L16:
            r5.A = r2
            c91 r2 = r5.i
            r2.d()
            u81 r2 = r5.t
            if (r2 == 0) goto L23
            r2.g = r1
        L23:
            r5.t0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.M0
            if (r0 == 0) goto L8e
            java.lang.ThreadLocal r0 = defpackage.e80.k
            java.lang.Object r1 = r0.get()
            e80 r1 = (defpackage.e80) r1
            r5.l0 = r1
            if (r1 != 0) goto L71
            e80 r1 = new e80
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.g = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.j = r2
            r5.l0 = r1
            java.util.WeakHashMap r1 = defpackage.qs1.a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L63
            if (r1 == 0) goto L63
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L63
            goto L65
        L63:
            r1 = 1114636288(0x42700000, float:60.0)
        L65:
            e80 r2 = r5.l0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.i = r3
            r0.set(r2)
        L71:
            e80 r0 = r5.l0
            r0.getClass()
            boolean r1 = androidx.recyclerview.widget.RecyclerView.G0
            java.util.ArrayList r0 = r0.g
            if (r1 == 0) goto L8b
            boolean r1 = r0.contains(r5)
            if (r1 != 0) goto L83
            goto L8b
        L83:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "RecyclerView already present in worker list!"
            r0.<init>(r1)
            throw r0
        L8b:
            r0.add(r5)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        c91 c91Var;
        e80 e80Var;
        super.onDetachedFromWindow();
        r81 r81Var = this.S;
        if (r81Var != null) {
            r81Var.e();
        }
        s0();
        int i = 0;
        this.y = false;
        u81 u81Var = this.t;
        if (u81Var != null) {
            u81Var.g = false;
            u81Var.T(this);
        }
        this.A0.clear();
        removeCallbacks(this.B0);
        this.m.getClass();
        while (ys1.d.a() != null) {
        }
        int i2 = 0;
        while (true) {
            c91Var = this.i;
            ArrayList arrayList = c91Var.c;
            if (i2 >= arrayList.size()) {
                break;
            }
            i21.a(((m91) arrayList.get(i2)).g);
            i2++;
        }
        c91Var.e(c91Var.h.s, false);
        int i3 = i21.a;
        while (i < getChildCount()) {
            int i4 = i + 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            int i5 = i21.a;
            j21 j21Var = (j21) childAt.getTag(i5);
            if (j21Var == null) {
                j21Var = new j21();
                childAt.setTag(i5, j21Var);
            }
            ArrayList arrayList2 = j21Var.a;
            int iU = xj.u(arrayList2);
            if (-1 < iU) {
                arrayList2.get(iU).getClass();
                throw new ClassCastException();
            }
            i = i4;
        }
        if (!M0 || (e80Var = this.l0) == null) {
            return;
        }
        boolean zRemove = e80Var.g.remove(this);
        if (G0 && !zRemove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
        this.l0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.v;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((s81) arrayList.get(i)).g(canvas, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00dd  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (!this.D) {
            this.x = null;
            if (I(motionEvent)) {
                i0();
                setScrollState(0);
                return true;
            }
            u81 u81Var = this.t;
            if (u81Var != null) {
                boolean zD = u81Var.d();
                boolean zE = this.t.e();
                if (this.V == null) {
                    this.V = VelocityTracker.obtain();
                }
                this.V.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.E) {
                        this.E = false;
                    }
                    this.U = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.b0 = x;
                    this.W = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.c0 = y;
                    this.a0 = y;
                    EdgeEffect edgeEffect = this.O;
                    if (edgeEffect == null || wd.s(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                        z = false;
                    } else {
                        wd.y(this.O, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                        z = true;
                    }
                    EdgeEffect edgeEffect2 = this.Q;
                    if (edgeEffect2 != null && wd.s(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
                        wd.y(this.Q, 0.0f, motionEvent.getY() / getHeight());
                        z = true;
                    }
                    EdgeEffect edgeEffect3 = this.P;
                    if (edgeEffect3 != null && wd.s(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
                        wd.y(this.P, 0.0f, motionEvent.getX() / getWidth());
                        z = true;
                    }
                    EdgeEffect edgeEffect4 = this.R;
                    if (edgeEffect4 != null && wd.s(edgeEffect4) != 0.0f && !canScrollVertically(1)) {
                        wd.y(this.R, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                        z = true;
                    }
                    if (z || this.T == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        r0(1);
                    }
                    int[] iArr = this.y0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i = zD;
                    if (zE) {
                        i = (zD ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().g(i, 0);
                } else if (actionMasked == 1) {
                    this.V.clear();
                    r0(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.U);
                    if (iFindPointerIndex >= 0) {
                        int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                        int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                        if (this.T != 1) {
                            int i2 = x2 - this.W;
                            int i3 = y2 - this.a0;
                            if (!zD || Math.abs(i2) <= this.d0) {
                                z2 = false;
                            } else {
                                this.b0 = x2;
                                z2 = true;
                            }
                            if (zE && Math.abs(i3) > this.d0) {
                                this.c0 = y2;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                    }
                } else if (actionMasked == 3) {
                    i0();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.U = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.b0 = x3;
                    this.W = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.c0 = y3;
                    this.a0 = y3;
                } else if (actionMasked == 6) {
                    Z(motionEvent);
                }
                if (this.T == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = no1.a;
        Trace.beginSection("RV OnLayout");
        v();
        Trace.endSection();
        this.A = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        u81 u81Var = this.t;
        if (u81Var == null) {
            s(i, i2);
            return;
        }
        boolean zN = u81Var.N();
        boolean z = false;
        i91 i91Var = this.n0;
        if (zN) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.t.b.s(i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.C0 = z;
            if (z || this.s == null) {
                return;
            }
            if (i91Var.d == 1) {
                w();
            }
            this.t.u0(i, i2);
            i91Var.i = true;
            x();
            this.t.w0(i, i2);
            if (this.t.z0()) {
                this.t.u0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                i91Var.i = true;
                x();
                this.t.w0(i, i2);
            }
            this.D0 = getMeasuredWidth();
            this.E0 = getMeasuredHeight();
            return;
        }
        if (this.z) {
            this.t.b.s(i, i2);
            return;
        }
        if (this.G) {
            p0();
            X();
            b0();
            Y(true);
            if (i91Var.k) {
                i91Var.g = true;
            } else {
                this.k.c();
                i91Var.g = false;
            }
            this.G = false;
            q0(false);
        } else if (i91Var.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        m81 m81Var = this.s;
        if (m81Var != null) {
            i91Var.e = m81Var.c();
        } else {
            i91Var.e = 0;
        }
        p0();
        this.t.b.s(i, i2);
        q0(false);
        i91Var.g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (T()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof f91)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f91 f91Var = (f91) parcelable;
        this.j = f91Var;
        super.onRestoreInstanceState(f91Var.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        f91 f91Var = new f91(super.onSaveInstanceState());
        f91 f91Var2 = this.j;
        if (f91Var2 != null) {
            f91Var.g = f91Var2.g;
            return f91Var;
        }
        u81 u81Var = this.t;
        if (u81Var != null) {
            f91Var.g = u81Var.h0();
            return f91Var;
        }
        f91Var.g = null;
        return f91Var;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        this.R = null;
        this.P = null;
        this.Q = null;
        this.O = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0275 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e4 A[PHI: r1
  0x00e4: PHI (r1v69 int) = (r1v53 int), (r1v73 int) binds: [B:49:0x00cd, B:53:0x00e0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fd  */
    /* JADX WARN: Type inference failed for: r10v9, types: [u81] */
    /* JADX WARN: Type inference failed for: r1v17, types: [vw0] */
    /* JADX WARN: Type inference failed for: r1v22, types: [vw0] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r5v16, types: [f11] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r26) {
        /*
            Method dump skipped, instruction units count: 1084
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.O.onRelease();
            zIsFinished = this.O.isFinished();
        }
        EdgeEffect edgeEffect2 = this.Q;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.Q.onRelease();
            zIsFinished |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.P.onRelease();
            zIsFinished |= this.P.isFinished();
        }
        EdgeEffect edgeEffect4 = this.R;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.R.onRelease();
            zIsFinished |= this.R.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = qs1.a;
            postInvalidateOnAnimation();
        }
    }

    public final void p0() {
        int i = this.B + 1;
        this.B = i;
        if (i != 1 || this.D) {
            return;
        }
        this.C = false;
    }

    public final void q0(boolean z) {
        if (this.B < 1) {
            if (G0) {
                throw new IllegalStateException(uo.e(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.B = 1;
        }
        if (!z && !this.D) {
            this.C = false;
        }
        if (this.B == 1) {
            if (z && this.C && !this.D && this.t != null && this.s != null) {
                v();
            }
            if (!this.D) {
                this.C = false;
            }
        }
        this.B--;
    }

    public final void r() {
        ei eiVar = this.l;
        y2 y2Var = this.k;
        if (!this.A || this.J) {
            int i = no1.a;
            Trace.beginSection("RV FullInvalidate");
            v();
            Trace.endSection();
            return;
        }
        if (y2Var.h()) {
            int i2 = y2Var.a;
            if ((i2 & 4) == 0 || (i2 & 11) != 0) {
                if (y2Var.h()) {
                    int i3 = no1.a;
                    Trace.beginSection("RV FullInvalidate");
                    v();
                    Trace.endSection();
                    return;
                }
                return;
            }
            int i4 = no1.a;
            Trace.beginSection("RV PartialInvalidate");
            p0();
            X();
            y2Var.k();
            if (!this.C) {
                int iG = eiVar.g();
                int i5 = 0;
                while (true) {
                    if (i5 < iG) {
                        m91 m91VarQ = Q(eiVar.f(i5));
                        if (m91VarQ != null && !m91VarQ.t() && m91VarQ.p()) {
                            v();
                            break;
                        }
                        i5++;
                    } else {
                        y2Var.b();
                        break;
                    }
                }
            }
            q0(true);
            Y(true);
            Trace.endSection();
        }
    }

    public final void r0(int i) {
        getScrollingChildHelper().h(i);
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        m91 m91VarQ = Q(view);
        if (m91VarQ != null) {
            if (m91VarQ.o()) {
                m91VarQ.p &= -257;
            } else if (!m91VarQ.t()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(m91VarQ);
                throw new IllegalArgumentException(uo.e(this, sb));
            }
        } else if (G0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(uo.e(this, sb2));
        }
        view.clearAnimation();
        t(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        pn0 pn0Var = this.t.e;
        if ((pn0Var == null || !pn0Var.e) && !T() && view2 != null) {
            h0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.t.o0(this, view, rect, z, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.w;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((y81) arrayList.get(i)).e(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.B != 0 || this.D) {
            this.C = true;
        } else {
            super.requestLayout();
        }
    }

    public final void s(int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = qs1.a;
        setMeasuredDimension(u81.g(i, paddingRight, getMinimumWidth()), u81.g(i2, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public final void s0() {
        pn0 pn0Var;
        setScrollState(0);
        l91 l91Var = this.k0;
        l91Var.m.removeCallbacks(l91Var);
        l91Var.i.abortAnimation();
        u81 u81Var = this.t;
        if (u81Var == null || (pn0Var = u81Var.e) == null) {
            return;
        }
        pn0Var.g();
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i2) {
        u81 u81Var = this.t;
        if (u81Var == null || this.D) {
            return;
        }
        boolean zD = u81Var.d();
        boolean zE = this.t.e();
        if (zD || zE) {
            if (!zD) {
                i = 0;
            }
            if (!zE) {
                i2 = 0;
            }
            j0(i, i2, 0, null);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!T()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.F |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(o91 o91Var) {
        this.u0 = o91Var;
        qs1.p(this, o91Var);
    }

    public void setAdapter(m81 m81Var) {
        setLayoutFrozen(false);
        m81 m81Var2 = this.s;
        e91 e91Var = this.h;
        if (m81Var2 != null) {
            m81Var2.g.unregisterObserver(e91Var);
            this.s.getClass();
        }
        r81 r81Var = this.S;
        if (r81Var != null) {
            r81Var.e();
        }
        u81 u81Var = this.t;
        c91 c91Var = this.i;
        if (u81Var != null) {
            u81Var.k0(c91Var);
            this.t.l0(c91Var);
        }
        c91Var.a.clear();
        c91Var.f();
        y2 y2Var = this.k;
        y2Var.l((ArrayList) y2Var.c);
        y2Var.l((ArrayList) y2Var.d);
        y2Var.a = 0;
        m81 m81Var3 = this.s;
        this.s = m81Var;
        if (m81Var != null) {
            m81Var.g.registerObserver(e91Var);
            m81Var.h(this);
        }
        u81 u81Var2 = this.t;
        if (u81Var2 != null) {
            u81Var2.S();
        }
        m81 m81Var4 = this.s;
        c91Var.a.clear();
        c91Var.f();
        c91Var.e(m81Var3, true);
        b91 b91VarC = c91Var.c();
        if (m81Var3 != null) {
            b91VarC.b--;
        }
        if (b91VarC.b == 0) {
            int i = 0;
            while (true) {
                SparseArray sparseArray = b91VarC.a;
                if (i >= sparseArray.size()) {
                    break;
                }
                a91 a91Var = (a91) sparseArray.valueAt(i);
                ArrayList arrayList = a91Var.a;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    i21.a(((m91) obj).g);
                }
                a91Var.a.clear();
                i++;
            }
        }
        if (m81Var4 != null) {
            b91VarC.b++;
        }
        c91Var.d();
        this.n0.f = true;
        c0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(p81 p81Var) {
        if (p81Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(p81Var != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.n) {
            this.R = null;
            this.P = null;
            this.Q = null;
            this.O = null;
        }
        this.n = z;
        super.setClipToPadding(z);
        if (this.A) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(q81 q81Var) {
        q81Var.getClass();
        this.N = q81Var;
        this.R = null;
        this.P = null;
        this.Q = null;
        this.O = null;
    }

    public void setHasFixedSize(boolean z) {
        this.z = z;
    }

    public void setItemAnimator(r81 r81Var) {
        r81 r81Var2 = this.S;
        if (r81Var2 != null) {
            r81Var2.e();
            this.S.a = null;
        }
        this.S = r81Var;
        if (r81Var != null) {
            r81Var.a = this.s0;
        }
    }

    public void setItemViewCacheSize(int i) {
        c91 c91Var = this.i;
        c91Var.e = i;
        c91Var.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(u81 u81Var) {
        RecyclerView recyclerView;
        if (u81Var == this.t) {
            return;
        }
        s0();
        u81 u81Var2 = this.t;
        c91 c91Var = this.i;
        if (u81Var2 != null) {
            r81 r81Var = this.S;
            if (r81Var != null) {
                r81Var.e();
            }
            this.t.k0(c91Var);
            this.t.l0(c91Var);
            c91Var.a.clear();
            c91Var.f();
            if (this.y) {
                u81 u81Var3 = this.t;
                u81Var3.g = false;
                u81Var3.T(this);
            }
            this.t.x0(null);
            this.t = null;
        } else {
            c91Var.a.clear();
            c91Var.f();
        }
        ei eiVar = this.l;
        ((di) eiVar.d).g();
        ArrayList arrayList = (ArrayList) eiVar.e;
        int size = arrayList.size() - 1;
        while (true) {
            recyclerView = (RecyclerView) ((mc1) eiVar.c).h;
            if (size < 0) {
                break;
            }
            m91 m91VarQ = Q((View) arrayList.get(size));
            if (m91VarQ != null) {
                int i = m91VarQ.v;
                if (recyclerView.T()) {
                    m91VarQ.w = i;
                    recyclerView.A0.add(m91VarQ);
                } else {
                    WeakHashMap weakHashMap = qs1.a;
                    m91VarQ.g.setImportantForAccessibility(i);
                }
                m91VarQ.v = 0;
            }
            arrayList.remove(size);
            size--;
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            recyclerView.t(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.t = u81Var;
        if (u81Var != null) {
            if (u81Var.b != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(u81Var);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(uo.e(u81Var.b, sb));
            }
            u81Var.x0(this);
            if (this.y) {
                this.t.g = true;
            }
        }
        c91Var.m();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        vw0 scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.d) {
            WeakHashMap weakHashMap = qs1.a;
            hs1.n(scrollingChildHelper.c);
        }
        scrollingChildHelper.d = z;
    }

    public void setOnFlingListener(x81 x81Var) {
        this.e0 = x81Var;
    }

    @Deprecated
    public void setOnScrollListener(z81 z81Var) {
        this.o0 = z81Var;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.j0 = z;
    }

    public void setRecycledViewPool(b91 b91Var) {
        c91 c91Var = this.i;
        RecyclerView recyclerView = c91Var.h;
        c91Var.e(recyclerView.s, false);
        if (c91Var.g != null) {
            r2.b--;
        }
        c91Var.g = b91Var;
        if (b91Var != null && recyclerView.getAdapter() != null) {
            c91Var.g.b++;
        }
        c91Var.d();
    }

    public void setScrollState(int i) {
        pn0 pn0Var;
        if (i == this.T) {
            return;
        }
        if (H0) {
            new Exception();
        }
        this.T = i;
        if (i != 2) {
            l91 l91Var = this.k0;
            l91Var.m.removeCallbacks(l91Var);
            l91Var.i.abortAnimation();
            u81 u81Var = this.t;
            if (u81Var != null && (pn0Var = u81Var.e) != null) {
                pn0Var.g();
            }
        }
        u81 u81Var2 = this.t;
        if (u81Var2 != null) {
            u81Var2.i0(i);
        }
        z81 z81Var = this.o0;
        if (z81Var != null) {
            z81Var.a(this, i);
        }
        ArrayList arrayList = this.p0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((z81) this.p0.get(size)).a(this, i);
            }
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 1) {
            this.d0 = viewConfiguration.getScaledTouchSlop();
        } else {
            this.d0 = viewConfiguration.getScaledPagingTouchSlop();
        }
    }

    public void setViewCacheExtension(k91 k91Var) {
        this.i.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return getScrollingChildHelper().g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.D) {
            m("Do not suppressLayout in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.D = true;
                this.E = true;
                s0();
                return;
            }
            this.D = false;
            if (this.C && this.t != null && this.s != null) {
                requestLayout();
            }
            this.C = false;
        }
    }

    public final void t(View view) {
        m91 m91VarQ = Q(view);
        m81 m81Var = this.s;
        if (m81Var != null && m91VarQ != null) {
            m81Var.m(m91VarQ);
        }
        ArrayList arrayList = this.I;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((w81) this.I.get(size)).d(view);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0384  */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v() {
        /*
            Method dump skipped, instruction units count: 1002
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v():void");
    }

    public final void w() {
        ys1 ys1Var;
        View viewH;
        i91 i91Var = this.n0;
        i91Var.a(1);
        G(i91Var);
        i91Var.i = false;
        p0();
        tu tuVar = this.m;
        ((ug1) tuVar.h).clear();
        xp0 xp0Var = (xp0) tuVar.i;
        xp0Var.b();
        X();
        b0();
        m91 m91VarP = null;
        View focusedChild = (this.j0 && hasFocus() && this.s != null) ? getFocusedChild() : null;
        if (focusedChild != null && (viewH = H(focusedChild)) != null) {
            m91VarP = P(viewH);
        }
        if (m91VarP == null) {
            i91Var.m = -1L;
            i91Var.l = -1;
            i91Var.n = -1;
        } else {
            i91Var.m = this.s.h ? m91VarP.k : -1L;
            i91Var.l = this.J ? -1 : m91VarP.m() ? m91VarP.j : m91VarP.d();
            View focusedChild2 = m91VarP.g;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            i91Var.n = id;
        }
        i91Var.h = i91Var.j && this.r0;
        this.r0 = false;
        this.q0 = false;
        i91Var.g = i91Var.k;
        i91Var.e = this.s.c();
        J(this.v0);
        boolean z = i91Var.j;
        ug1 ug1Var = (ug1) tuVar.h;
        if (z) {
            int iG = this.l.g();
            for (int i = 0; i < iG; i++) {
                m91 m91VarQ = Q(this.l.f(i));
                if (!m91VarQ.t() && (!m91VarQ.k() || this.s.h)) {
                    r81 r81Var = this.S;
                    r81.b(m91VarQ);
                    m91VarQ.h();
                    r81Var.getClass();
                    ib ibVar = new ib();
                    ibVar.a(m91VarQ);
                    ys1 ys1VarA = (ys1) ug1Var.get(m91VarQ);
                    if (ys1VarA == null) {
                        ys1VarA = ys1.a();
                        ug1Var.put(m91VarQ, ys1VarA);
                    }
                    ys1VarA.b = ibVar;
                    ys1VarA.a |= 4;
                    if (i91Var.h && m91VarQ.p() && !m91VarQ.m() && !m91VarQ.t() && !m91VarQ.k()) {
                        xp0Var.g(N(m91VarQ), m91VarQ);
                    }
                }
            }
        }
        if (i91Var.k) {
            int iK = this.l.k();
            for (int i2 = 0; i2 < iK; i2++) {
                m91 m91VarQ2 = Q(this.l.j(i2));
                if (G0 && m91VarQ2.i == -1 && !m91VarQ2.m()) {
                    throw new IllegalStateException(uo.e(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
                }
                if (!m91VarQ2.t() && m91VarQ2.j == -1) {
                    m91VarQ2.j = m91VarQ2.i;
                }
            }
            boolean z2 = i91Var.f;
            i91Var.f = false;
            this.t.e0(this.i, i91Var);
            i91Var.f = z2;
            for (int i3 = 0; i3 < this.l.g(); i3++) {
                m91 m91VarQ3 = Q(this.l.f(i3));
                if (!m91VarQ3.t() && ((ys1Var = (ys1) ug1Var.get(m91VarQ3)) == null || (ys1Var.a & 4) == 0)) {
                    r81.b(m91VarQ3);
                    boolean z3 = (m91VarQ3.p & 8192) != 0;
                    r81 r81Var2 = this.S;
                    m91VarQ3.h();
                    r81Var2.getClass();
                    ib ibVar2 = new ib();
                    ibVar2.a(m91VarQ3);
                    if (z3) {
                        d0(m91VarQ3, ibVar2);
                    } else {
                        ys1 ys1VarA2 = (ys1) ug1Var.get(m91VarQ3);
                        if (ys1VarA2 == null) {
                            ys1VarA2 = ys1.a();
                            ug1Var.put(m91VarQ3, ys1VarA2);
                        }
                        ys1VarA2.a |= 2;
                        ys1VarA2.b = ibVar2;
                    }
                }
            }
            o();
        } else {
            o();
        }
        Y(true);
        q0(false);
        i91Var.d = 2;
    }

    public final void x() {
        p0();
        X();
        i91 i91Var = this.n0;
        i91Var.a(6);
        this.k.c();
        i91Var.e = this.s.c();
        i91Var.c = 0;
        if (this.j != null) {
            m81 m81Var = this.s;
            int iV = uo.v(m81Var.i);
            if (iV == 1 ? m81Var.c() > 0 : iV != 2) {
                Parcelable parcelable = this.j.g;
                if (parcelable != null) {
                    this.t.g0(parcelable);
                }
                this.j = null;
            }
        }
        i91Var.g = false;
        this.t.e0(this.i, i91Var);
        i91Var.f = false;
        i91Var.j = i91Var.j && this.S != null;
        i91Var.d = 4;
        Y(true);
        q0(false);
    }

    public final boolean y(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i, i2, i3, iArr, iArr2);
    }

    public final void z(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().d(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        float fA;
        TypedArray typedArray;
        char c;
        char c2;
        Constructor constructor;
        super(context, attributeSet, i);
        this.h = new e91(this);
        this.i = new c91(this);
        this.m = new tu(8);
        this.o = new l81(this, 0);
        this.p = new Rect();
        this.q = new Rect();
        this.r = new RectF();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.B = 0;
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = 0;
        this.N = P0;
        this.S = new lt();
        this.T = 0;
        this.U = -1;
        this.h0 = Float.MIN_VALUE;
        this.i0 = Float.MIN_VALUE;
        int i2 = 1;
        this.j0 = true;
        this.k0 = new l91(this);
        Object[] objArr = null;
        this.m0 = M0 ? new c80() : null;
        i91 i91Var = new i91();
        i91Var.a = -1;
        i91Var.b = 0;
        i91Var.c = 0;
        i91Var.d = 1;
        i91Var.e = 0;
        i91Var.f = false;
        i91Var.g = false;
        i91Var.h = false;
        i91Var.i = false;
        i91Var.j = false;
        i91Var.k = false;
        this.n0 = i91Var;
        this.q0 = false;
        this.r0 = false;
        ow1 ow1Var = new ow1(this, 24);
        this.s0 = ow1Var;
        this.t0 = false;
        this.v0 = new int[2];
        this.x0 = new int[2];
        this.y0 = new int[2];
        this.z0 = new int[2];
        this.A0 = new ArrayList();
        this.B0 = new l81(this, i2);
        this.D0 = 0;
        this.E0 = 0;
        this.F0 = new fz1(this, 23);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.d0 = viewConfiguration.getScaledTouchSlop();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            Method method = rs1.a;
            fA = ao.c(viewConfiguration);
        } else {
            fA = rs1.a(viewConfiguration, context);
        }
        this.h0 = fA;
        this.i0 = i3 >= 26 ? ao.d(viewConfiguration) : rs1.a(viewConfiguration, context);
        this.f0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.g0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.g = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.S.a = ow1Var;
        this.k = new y2(new nx0(this, 22));
        this.l = new ei(new mc1(this, 20));
        WeakHashMap weakHashMap = qs1.a;
        if ((i3 >= 26 ? ks1.a(this) : 0) == 0 && i3 >= 26) {
            ks1.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.H = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new o91(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p71.RecyclerView, i, 0);
        qs1.o(this, context, p71.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i);
        String string = typedArrayObtainStyledAttributes.getString(p71.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(p71.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION);
        }
        this.n = typedArrayObtainStyledAttributes.getBoolean(p71.RecyclerView_android_clipToPadding, true);
        if (typedArrayObtainStyledAttributes.getBoolean(p71.RecyclerView_fastScrollEnabled, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(p71.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(p71.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(p71.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(p71.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(uo.e(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            c = 2;
            c2 = 1;
            typedArray = typedArrayObtainStyledAttributes;
            new r20(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(c51.fastscroll_default_thickness), resources.getDimensionPixelSize(c51.fastscroll_minimum_range), resources.getDimensionPixelOffset(c51.fastscroll_margin));
        } else {
            typedArray = typedArrayObtainStyledAttributes;
            c = 2;
            c2 = 1;
        }
        typedArray.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(u81.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(N0);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = context;
                        objArr2[c2] = attributeSet;
                        objArr2[c] = Integer.valueOf(i);
                        objArr2[3] = 0;
                        objArr = objArr2;
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((u81) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e4);
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e6);
                } catch (InvocationTargetException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e7);
                }
            }
        }
        int[] iArr = I0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        qs1.o(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i);
        boolean z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z);
        int i4 = i21.a;
        setTag(i21.b, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        u81 u81Var = this.t;
        if (u81Var != null) {
            return u81Var.t(layoutParams);
        }
        throw new IllegalStateException(uo.e(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Deprecated
    public void setRecyclerListener(d91 d91Var) {
    }
}
