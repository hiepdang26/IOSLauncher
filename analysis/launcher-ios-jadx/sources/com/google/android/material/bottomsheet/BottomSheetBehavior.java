package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.ay;
import defpackage.b71;
import defpackage.d0;
import defpackage.d51;
import defpackage.e0;
import defpackage.f71;
import defpackage.fs1;
import defpackage.hs1;
import defpackage.jd;
import defpackage.k31;
import defpackage.kd;
import defpackage.ld;
import defpackage.mo;
import defpackage.n0;
import defpackage.np1;
import defpackage.po;
import defpackage.q41;
import defpackage.q7;
import defpackage.qr0;
import defpackage.qs1;
import defpackage.rr0;
import defpackage.rw;
import defpackage.s1;
import defpackage.ss1;
import defpackage.t3;
import defpackage.uo;
import defpackage.v21;
import defpackage.v61;
import defpackage.vs1;
import defpackage.wf1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends mo {
    public static final int b0 = b71.Widget_Design_BottomSheet_Modal;
    public final int A;
    public int B;
    public int C;
    public final float D;
    public int E;
    public final float F;
    public boolean G;
    public boolean H;
    public final boolean I;
    public int J;
    public vs1 K;
    public boolean L;
    public int M;
    public boolean N;
    public int O;
    public int P;
    public int Q;
    public WeakReference R;
    public WeakReference S;
    public final ArrayList T;
    public VelocityTracker U;
    public int V;
    public int W;
    public boolean X;
    public HashMap Y;
    public int Z;
    public final int a;
    public final rw a0;
    public boolean b;
    public final float c;
    public int d;
    public boolean e;
    public int f;
    public final int g;
    public final rr0 h;
    public final ColorStateList i;
    public final int j;
    public final int k;
    public int l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public int u;
    public int v;
    public final wf1 w;
    public boolean x;
    public final ld y;
    public final ValueAnimator z;

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.j = -1;
        this.k = -1;
        this.y = new ld(this);
        this.D = 0.5f;
        this.F = -1.0f;
        this.I = true;
        this.J = 4;
        this.T = new ArrayList();
        this.Z = -1;
        this.a0 = new rw(this, 2);
    }

    public static View v(View view) {
        WeakHashMap weakHashMap = qs1.a;
        if (hs1.i(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewV = v(viewGroup.getChildAt(i));
            if (viewV != null) {
                return viewV;
            }
        }
        return null;
    }

    public static int w(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, RtlSpacingHelper.UNDEFINED);
    }

    public final void A(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(uo.k(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (this.G || i != 5) {
            int i2 = (i == 6 && this.b && y(i) <= this.B) ? 3 : i;
            WeakReference weakReference = this.R;
            if (weakReference == null || weakReference.get() == null) {
                B(i);
                return;
            }
            View view = (View) this.R.get();
            s1 s1Var = new s1(this, view, i2, 1, false);
            ViewParent parent = view.getParent();
            if (parent != null && parent.isLayoutRequested()) {
                WeakHashMap weakHashMap = qs1.a;
                if (view.isAttachedToWindow()) {
                    view.post(s1Var);
                    return;
                }
            }
            s1Var.run();
        }
    }

    public final void B(int i) {
        if (this.J == i) {
            return;
        }
        this.J = i;
        if (i != 4 && i != 3 && i != 6) {
            boolean z = this.G;
        }
        WeakReference weakReference = this.R;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            G(true);
        } else if (i == 6 || i == 5 || i == 4) {
            G(false);
        }
        F(i);
        ArrayList arrayList = this.T;
        if (arrayList.size() <= 0) {
            E();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final boolean C(View view, float f) {
        if (this.H) {
            return true;
        }
        if (view.getTop() < this.E) {
            return false;
        }
        return Math.abs(((f * 0.1f) + ((float) view.getTop())) - ((float) this.E)) / ((float) t()) > 0.5f;
    }

    public final void D(View view, int i, boolean z) {
        int iY = y(i);
        vs1 vs1Var = this.K;
        if (vs1Var == null || (!z ? vs1Var.s(view, view.getLeft(), iY) : vs1Var.q(view.getLeft(), iY))) {
            B(i);
            return;
        }
        B(2);
        F(i);
        this.y.c(i);
    }

    public final void E() {
        View view;
        int iA;
        WeakReference weakReference = this.R;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        qs1.m(524288, view);
        qs1.h(0, view);
        qs1.m(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION, view);
        qs1.h(0, view);
        qs1.m(1048576, view);
        qs1.h(0, view);
        int i = this.Z;
        if (i != -1) {
            qs1.m(i, view);
            qs1.h(0, view);
        }
        if (!this.b && this.J != 6) {
            String string = view.getResources().getString(v61.bottomsheet_action_expand_halfway);
            t3 t3Var = new t3(this, i);
            ArrayList arrayListE = qs1.e(view);
            int i2 = 0;
            while (true) {
                if (i2 >= arrayListE.size()) {
                    int i3 = -1;
                    for (int i4 = 0; i4 < 32 && i3 == -1; i4++) {
                        int i5 = qs1.e[i4];
                        boolean z = true;
                        for (int i6 = 0; i6 < arrayListE.size(); i6++) {
                            z &= ((n0) arrayListE.get(i6)).a() != i5;
                        }
                        if (z) {
                            i3 = i5;
                        }
                    }
                    iA = i3;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((n0) arrayListE.get(i2)).a).getLabel())) {
                        iA = ((n0) arrayListE.get(i2)).a();
                        break;
                    }
                    i2++;
                }
            }
            if (iA != -1) {
                n0 n0Var = new n0(null, iA, string, t3Var, null);
                View.AccessibilityDelegate accessibilityDelegateD = qs1.d(view);
                e0 e0Var = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof d0 ? ((d0) accessibilityDelegateD).a : new e0(accessibilityDelegateD);
                if (e0Var == null) {
                    e0Var = new e0();
                }
                qs1.p(view, e0Var);
                qs1.m(n0Var.a(), view);
                qs1.e(view).add(n0Var);
                qs1.h(0, view);
            }
            this.Z = iA;
        }
        if (this.G) {
            int i7 = 5;
            if (this.J != 5) {
                qs1.n(view, n0.l, new t3(this, i7));
            }
        }
        int i8 = this.J;
        int i9 = 4;
        int i10 = 3;
        if (i8 == 3) {
            qs1.n(view, n0.k, new t3(this, this.b ? 4 : 6));
            return;
        }
        if (i8 == 4) {
            qs1.n(view, n0.j, new t3(this, this.b ? 3 : 6));
        } else {
            if (i8 != 6) {
                return;
            }
            qs1.n(view, n0.k, new t3(this, i9));
            qs1.n(view, n0.j, new t3(this, i10));
        }
    }

    public final void F(int i) {
        ValueAnimator valueAnimator = this.z;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.x != z) {
            this.x = z;
            if (this.h == null || valueAnimator == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            }
            float f = z ? 0.0f : 1.0f;
            valueAnimator.setFloatValues(1.0f - f, f);
            valueAnimator.start();
        }
    }

    public final void G(boolean z) {
        WeakReference weakReference = this.R;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.Y != null) {
                    return;
                } else {
                    this.Y = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.R.get() && z) {
                    this.Y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.Y = null;
        }
    }

    public final void H() {
        View view;
        if (this.R != null) {
            s();
            if (this.J != 4 || (view = (View) this.R.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // defpackage.mo
    public final void c(po poVar) {
        this.R = null;
        this.K = null;
    }

    @Override // defpackage.mo
    public final void e() {
        this.R = null;
        this.K = null;
    }

    @Override // defpackage.mo
    public final boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        vs1 vs1Var;
        if (!view.isShown() || !this.I) {
            this.L = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.V = -1;
            VelocityTracker velocityTracker = this.U;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.U = null;
            }
        }
        if (this.U == null) {
            this.U = VelocityTracker.obtain();
        }
        this.U.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.W = (int) motionEvent.getY();
            if (this.J != 2) {
                WeakReference weakReference = this.S;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.h(view2, x, this.W)) {
                    this.V = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.X = true;
                }
            }
            this.L = this.V == -1 && !coordinatorLayout.h(view, x, this.W);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.X = false;
            this.V = -1;
            if (this.L) {
                this.L = false;
                return false;
            }
        }
        if (this.L || (vs1Var = this.K) == null || !vs1Var.r(motionEvent)) {
            WeakReference weakReference2 = this.S;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.L || this.J == 1 || coordinatorLayout.h(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.K == null || Math.abs(this.W - motionEvent.getY()) <= this.K.b) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.mo
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i2 = 1;
        rr0 rr0Var = this.h;
        WeakHashMap weakHashMap = qs1.a;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.R == null) {
            this.f = coordinatorLayout.getResources().getDimensionPixelSize(d51.design_bottom_sheet_peek_height_min);
            boolean z = (Build.VERSION.SDK_INT < 29 || this.m || this.e) ? false : true;
            if (this.n || this.o || this.p || this.r || this.s || this.t || z) {
                jd jdVar = new jd(this, z);
                int paddingStart = view.getPaddingStart();
                view.getPaddingTop();
                int paddingEnd = view.getPaddingEnd();
                int paddingBottom = view.getPaddingBottom();
                ay ayVar = new ay();
                ayVar.a = paddingStart;
                ayVar.b = paddingEnd;
                ayVar.c = paddingBottom;
                hs1.m(view, new v21(jdVar, ayVar, 8));
                if (view.isAttachedToWindow()) {
                    fs1.c(view);
                } else {
                    view.addOnAttachStateChangeListener(new ss1(i2));
                }
            }
            this.R = new WeakReference(view);
            if (rr0Var != null) {
                view.setBackground(rr0Var);
                float fE = this.F;
                if (fE == -1.0f) {
                    fE = hs1.e(view);
                }
                rr0Var.j(fE);
                boolean z2 = this.J == 3;
                this.x = z2;
                float f = z2 ? 0.0f : 1.0f;
                qr0 qr0Var = rr0Var.g;
                if (qr0Var.i != f) {
                    qr0Var.i = f;
                    rr0Var.k = true;
                    rr0Var.invalidateSelf();
                }
            } else {
                ColorStateList colorStateList = this.i;
                if (colorStateList != null) {
                    qs1.r(view, colorStateList);
                }
            }
            E();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.K == null) {
            this.K = new vs1(coordinatorLayout.getContext(), coordinatorLayout, this.a0);
        }
        int top = view.getTop();
        coordinatorLayout.j(i, view);
        this.P = coordinatorLayout.getWidth();
        this.Q = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.O = height;
        int i3 = this.Q;
        int i4 = i3 - height;
        int i5 = this.v;
        if (i4 < i5) {
            if (this.q) {
                this.O = i3;
            } else {
                this.O = i3 - i5;
            }
        }
        this.B = Math.max(0, i3 - this.O);
        this.C = (int) ((1.0f - this.D) * this.Q);
        s();
        int i6 = this.J;
        if (i6 == 3) {
            qs1.j(x(), view);
        } else if (i6 == 6) {
            qs1.j(this.C, view);
        } else if (this.G && i6 == 5) {
            qs1.j(this.Q, view);
        } else if (i6 == 4) {
            qs1.j(this.E, view);
        } else if (i6 == 1 || i6 == 2) {
            qs1.j(top - view.getTop(), view);
        }
        this.S = new WeakReference(v(view));
        ArrayList arrayList = this.T;
        if (arrayList.size() <= 0) {
            return true;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.mo
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(w(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.j, marginLayoutParams.width), w(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.k, marginLayoutParams.height));
        return true;
    }

    @Override // defpackage.mo
    public final boolean i(View view, View view2, float f) {
        WeakReference weakReference = this.S;
        return (weakReference == null || view2 != weakReference.get() || this.J == 3) ? false : true;
    }

    @Override // defpackage.mo
    public final void j(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference weakReference = this.S;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i4 = top - i2;
        if (i2 > 0) {
            if (i4 < x()) {
                int iX = top - x();
                iArr[1] = iX;
                qs1.j(-iX, view);
                B(3);
            } else {
                if (!this.I) {
                    return;
                }
                iArr[1] = i2;
                qs1.j(-i2, view);
                B(1);
            }
        } else if (i2 < 0 && !view2.canScrollVertically(-1)) {
            int i5 = this.E;
            if (i4 > i5 && !this.G) {
                int i6 = top - i5;
                iArr[1] = i6;
                qs1.j(-i6, view);
                B(4);
            } else {
                if (!this.I) {
                    return;
                }
                iArr[1] = i2;
                qs1.j(-i2, view);
                B(1);
            }
        }
        u(view.getTop());
        this.M = i2;
        this.N = true;
    }

    @Override // defpackage.mo
    public final void l(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // defpackage.mo
    public final void n(View view, Parcelable parcelable) {
        kd kdVar = (kd) parcelable;
        kdVar.getSuperState();
        int i = this.a;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.d = kdVar.h;
            }
            if (i == -1 || (i & 2) == 2) {
                this.b = kdVar.i;
            }
            if (i == -1 || (i & 4) == 4) {
                this.G = kdVar.j;
            }
            if (i == -1 || (i & 8) == 8) {
                this.H = kdVar.k;
            }
        }
        int i2 = kdVar.g;
        if (i2 == 1 || i2 == 2) {
            this.J = 4;
        } else {
            this.J = i2;
        }
    }

    @Override // defpackage.mo
    public final Parcelable o(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new kd(this);
    }

    @Override // defpackage.mo
    public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        this.M = 0;
        this.N = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // defpackage.mo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.x()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.B(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.S
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.N
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.M
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.b
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.C
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.G
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.U
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.c
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.U
            int r6 = r2.V
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.C(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.M
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.b
            if (r1 == 0) goto L74
            int r5 = r2.B
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.E
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.C
            if (r3 >= r1) goto L83
            int r6 = r2.E
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.E
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.b
            if (r3 == 0) goto L99
        L97:
            r0 = 4
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.C
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.E
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = 6
        Laf:
            r3 = 0
            r2.D(r4, r0, r3)
            r2.N = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.q(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // defpackage.mo
    public final boolean r(View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.J;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        vs1 vs1Var = this.K;
        if (vs1Var != null && (this.I || i == 1)) {
            vs1Var.k(motionEvent);
        }
        if (actionMasked == 0) {
            this.V = -1;
            VelocityTracker velocityTracker = this.U;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.U = null;
            }
        }
        if (this.U == null) {
            this.U = VelocityTracker.obtain();
        }
        this.U.addMovement(motionEvent);
        if (this.K != null && ((this.I || this.J == 1) && actionMasked == 2 && !this.L)) {
            float fAbs = Math.abs(this.W - motionEvent.getY());
            vs1 vs1Var2 = this.K;
            if (fAbs > vs1Var2.b) {
                vs1Var2.b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.L;
    }

    public final void s() {
        int iT = t();
        if (this.b) {
            this.E = Math.max(this.Q - iT, this.B);
        } else {
            this.E = this.Q - iT;
        }
    }

    public final int t() {
        int i;
        return this.e ? Math.min(Math.max(this.f, this.Q - ((this.P * 9) / 16)), this.O) + this.u : (this.m || this.n || (i = this.l) <= 0) ? this.d + this.u : Math.max(this.d, i + this.g);
    }

    public final void u(int i) {
        if (((View) this.R.get()) != null) {
            ArrayList arrayList = this.T;
            if (arrayList.isEmpty()) {
                return;
            }
            int i2 = this.E;
            if (i <= i2 && i2 != x()) {
                x();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final int x() {
        if (this.b) {
            return this.B;
        }
        return Math.max(this.A, this.q ? 0 : this.v);
    }

    public final int y(int i) {
        if (i == 3) {
            return x();
        }
        if (i == 4) {
            return this.E;
        }
        if (i == 5) {
            return this.Q;
        }
        if (i == 6) {
            return this.C;
        }
        throw new IllegalArgumentException(k31.k(i, "Invalid state to get top offset: "));
    }

    public final void z(int i) {
        if (i == -1) {
            if (this.e) {
                return;
            } else {
                this.e = true;
            }
        } else {
            if (!this.e && this.d == i) {
                return;
            }
            this.e = false;
            this.d = Math.max(0, i);
        }
        H();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        int i2 = 2;
        this.a = 0;
        this.b = true;
        this.j = -1;
        this.k = -1;
        this.y = new ld(this);
        this.D = 0.5f;
        this.F = -1.0f;
        this.I = true;
        this.J = 4;
        this.T = new ArrayList();
        this.Z = -1;
        this.a0 = new rw(this, i2);
        this.g = context.getResources().getDimensionPixelSize(d51.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f71.BottomSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(f71.BottomSheetBehavior_Layout_backgroundTint)) {
            this.i = np1.l(context, typedArrayObtainStyledAttributes, f71.BottomSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(f71.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.w = wf1.b(context, attributeSet, q41.bottomSheetStyle, b0).a();
        }
        wf1 wf1Var = this.w;
        if (wf1Var != null) {
            rr0 rr0Var = new rr0(wf1Var);
            this.h = rr0Var;
            rr0Var.i(context);
            ColorStateList colorStateList = this.i;
            if (colorStateList != null) {
                this.h.k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
                this.h.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.z.addUpdateListener(new q7(this, i2));
        this.F = typedArrayObtainStyledAttributes.getDimension(f71.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(f71.BottomSheetBehavior_Layout_android_maxWidth)) {
            this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.BottomSheetBehavior_Layout_android_maxWidth, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(f71.BottomSheetBehavior_Layout_android_maxHeight)) {
            this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.BottomSheetBehavior_Layout_android_maxHeight, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(f71.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            z(i);
        } else {
            z(typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_behavior_hideable, false);
        if (this.G != z) {
            this.G = z;
            if (!z && this.J == 5) {
                A(4);
            }
            E();
        }
        this.m = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_behavior_fitToContents, true);
        if (this.b != z2) {
            this.b = z2;
            if (this.R != null) {
                s();
            }
            B((this.b && this.J == 6) ? 3 : this.J);
            E();
        }
        this.H = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.I = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.a = typedArrayObtainStyledAttributes.getInt(f71.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(f71.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f > 0.0f && f < 1.0f) {
            this.D = f;
            if (this.R != null) {
                this.C = (int) ((1.0f - f) * this.Q);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(f71.BottomSheetBehavior_Layout_behavior_expandedOffset);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i3 = typedValuePeekValue2.data;
                if (i3 >= 0) {
                    this.A = i3;
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(f71.BottomSheetBehavior_Layout_behavior_expandedOffset, 0);
                if (dimensionPixelOffset >= 0) {
                    this.A = dimensionPixelOffset;
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.n = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
            this.o = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
            this.p = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
            this.q = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
            this.r = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
            this.s = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
            this.t = typedArrayObtainStyledAttributes.getBoolean(f71.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
            typedArrayObtainStyledAttributes.recycle();
            this.c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}
