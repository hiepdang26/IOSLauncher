package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.material.tabs.TabLayout;
import defpackage.d11;
import defpackage.fl0;
import defpackage.hs1;
import defpackage.jl1;
import defpackage.jq;
import defpackage.kt1;
import defpackage.lt1;
import defpackage.md;
import defpackage.mt1;
import defpackage.nt1;
import defpackage.ot1;
import defpackage.q11;
import defpackage.qs1;
import defpackage.vl1;
import defpackage.y4;
import defpackage.yh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    public static final int[] i0 = {R.attr.layout_gravity};
    public static final y4 j0 = new y4(10);
    public static final md k0 = new md(7);
    public static final y4 l0 = new y4(11);
    public boolean A;
    public int B;
    public boolean C;
    public boolean D;
    public final int E;
    public int F;
    public final int G;
    public float H;
    public float I;
    public float J;
    public float K;
    public int L;
    public VelocityTracker M;
    public final int N;
    public final int O;
    public final int P;
    public final int Q;
    public final EdgeEffect R;
    public final EdgeEffect S;
    public boolean T;
    public boolean U;
    public int V;
    public ArrayList W;
    public nt1 a0;
    public ArrayList b0;
    public jl1 c0;
    public int d0;
    public int e0;
    public ArrayList f0;
    public int g;
    public final fl0 g0;
    public final ArrayList h;
    public int h0;
    public final lt1 i;
    public final Rect j;
    public d11 k;
    public int l;
    public int m;
    public Parcelable n;
    public final Scroller o;
    public boolean p;
    public jq q;
    public int r;
    public Drawable s;
    public int t;
    public int u;
    public float v;
    public float w;
    public int x;
    public boolean y;
    public boolean z;

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new ArrayList();
        this.i = new lt1();
        this.j = new Rect();
        this.m = -1;
        this.n = null;
        this.v = -3.4028235E38f;
        this.w = Float.MAX_VALUE;
        this.B = 1;
        this.L = -1;
        this.T = true;
        this.g0 = new fl0(this, 19);
        this.h0 = 0;
        setWillNotDraw(false);
        setDescendantFocusability(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION);
        setFocusable(true);
        Context context2 = getContext();
        this.o = new Scroller(context2, k0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.G = viewConfiguration.getScaledPagingTouchSlop();
        this.N = (int) (400.0f * f);
        this.O = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new EdgeEffect(context2);
        this.S = new EdgeEffect(context2);
        this.P = (int) (25.0f * f);
        this.Q = (int) (2.0f * f);
        this.E = (int) (f * 16.0f);
        qs1.p(this, new yh(this, 5));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        hs1.m(this, new q11(this));
    }

    public static boolean c(View view, int i, int i2, int i3, boolean z) {
        int i4;
        if (!(view instanceof ViewGroup)) {
            return z ? false : false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            int i5 = i2 + scrollX;
            if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && c(childAt, i, i5 - childAt.getLeft(), i4 - childAt.getTop(), true)) {
                break;
            }
        }
        if (z || !view.canScrollHorizontally(-i)) {
        }
        return true;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.z != z) {
            this.z = z;
        }
    }

    public final lt1 a(int i, int i2) {
        lt1 lt1Var = new lt1();
        lt1Var.b = i;
        lt1Var.a = this.k.e(this, i);
        this.k.getClass();
        lt1Var.d = 1.0f;
        ArrayList arrayList = this.h;
        if (i2 < 0 || i2 >= arrayList.size()) {
            arrayList.add(lt1Var);
            return lt1Var;
        }
        arrayList.add(i2, lt1Var);
        return lt1Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        lt1 lt1VarH;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (lt1VarH = h(childAt)) != null && lt1VarH.b == this.l) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList arrayList) {
        lt1 lt1VarH;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (lt1VarH = h(childAt)) != null && lt1VarH.b == this.l) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateDefaultLayoutParams();
        }
        mt1 mt1Var = (mt1) layoutParams;
        boolean z = mt1Var.a | (view.getClass().getAnnotation(kt1.class) != null);
        mt1Var.a = z;
        if (!this.y) {
            super.addView(view, i, layoutParams);
        } else {
            if (z) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            mt1Var.d = true;
            addViewInLayout(view, i, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r8) {
        /*
            r7 = this;
            android.view.View r0 = r7.findFocus()
            r1 = 0
            if (r0 != r7) goto L9
        L7:
            r0 = r1
            goto L2b
        L9:
            if (r0 == 0) goto L2b
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r7) goto L16
            goto L2b
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            android.view.ViewParent r0 = r0.getParent()
        L1f:
            boolean r2 = r0 instanceof android.view.ViewGroup
            if (r2 == 0) goto L7
            r0.getClass()
            android.view.ViewParent r0 = r0.getParent()
            goto L1f
        L2b:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r7, r0, r8)
            r2 = 1
            r3 = 0
            r4 = 66
            r5 = 17
            if (r1 == 0) goto L7e
            if (r1 == r0) goto L7e
            android.graphics.Rect r6 = r7.j
            if (r8 != r5) goto L62
            android.graphics.Rect r4 = r7.g(r1, r6)
            int r4 = r4.left
            android.graphics.Rect r5 = r7.g(r0, r6)
            int r5 = r5.left
            if (r0 == 0) goto L5c
            if (r4 < r5) goto L5c
            int r0 = r7.l
            if (r0 <= 0) goto L98
            int r0 = r0 - r2
            r7.A = r3
            r7.u(r0, r3, r2, r3)
            goto L99
        L5c:
            boolean r0 = r1.requestFocus()
        L60:
            r3 = r0
            goto L9a
        L62:
            if (r8 != r4) goto L9a
            android.graphics.Rect r2 = r7.g(r1, r6)
            int r2 = r2.left
            android.graphics.Rect r3 = r7.g(r0, r6)
            int r3 = r3.left
            if (r0 == 0) goto L79
            if (r2 > r3) goto L79
            boolean r0 = r7.m()
            goto L60
        L79:
            boolean r0 = r1.requestFocus()
            goto L60
        L7e:
            if (r8 == r5) goto L8d
            if (r8 != r2) goto L83
            goto L8d
        L83:
            if (r8 == r4) goto L88
            r0 = 2
            if (r8 != r0) goto L9a
        L88:
            boolean r3 = r7.m()
            goto L9a
        L8d:
            int r0 = r7.l
            if (r0 <= 0) goto L98
            int r0 = r0 - r2
            r7.A = r3
            r7.u(r0, r3, r2, r3)
            goto L99
        L98:
            r2 = 0
        L99:
            r3 = r2
        L9a:
            if (r3 == 0) goto La3
            int r8 = android.view.SoundEffectConstants.getContantForFocusDirection(r8)
            r7.playSoundEffect(r8)
        La3:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.b(int):boolean");
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        if (this.k == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.v)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.w));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof mt1) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.p = true;
        Scroller scroller = this.o;
        if (scroller.isFinished() || !scroller.computeScrollOffset()) {
            d(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = scroller.getCurrX();
        int currY = scroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!n(currX)) {
                scroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap weakHashMap = qs1.a;
        postInvalidateOnAnimation();
    }

    public final void d(boolean z) {
        Scroller scroller = this.o;
        boolean z2 = this.h0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!scroller.isFinished()) {
                scroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = scroller.getCurrX();
                int currY = scroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        n(currX);
                    }
                }
            }
        }
        this.A = false;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.h;
            if (i >= arrayList.size()) {
                break;
            }
            lt1 lt1Var = (lt1) arrayList.get(i);
            if (lt1Var.c) {
                lt1Var.c = false;
                z2 = true;
            }
            i++;
        }
        if (z2) {
            fl0 fl0Var = this.g0;
            if (!z) {
                fl0Var.run();
            } else {
                WeakHashMap weakHashMap = qs1.a;
                postOnAnimation(fl0Var);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065 A[RETURN] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 1
            if (r0 != 0) goto L66
            int r0 = r6.getAction()
            r2 = 0
            if (r0 != 0) goto L61
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L48
            r3 = 22
            if (r0 == r3) goto L36
            r3 = 61
            if (r0 == r3) goto L20
            goto L61
        L20:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L2b
            boolean r6 = r5.b(r4)
            goto L62
        L2b:
            boolean r6 = r6.hasModifiers(r1)
            if (r6 == 0) goto L61
            boolean r6 = r5.b(r1)
            goto L62
        L36:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L41
            boolean r6 = r5.m()
            goto L62
        L41:
            r6 = 66
            boolean r6 = r5.b(r6)
            goto L62
        L48:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L5a
            int r6 = r5.l
            if (r6 <= 0) goto L61
            int r6 = r6 - r1
            r5.A = r2
            r5.u(r6, r2, r1, r2)
            r6 = 1
            goto L62
        L5a:
            r6 = 17
            boolean r6 = r5.b(r6)
            goto L62
        L61:
            r6 = 0
        L62:
            if (r6 == 0) goto L65
            goto L66
        L65:
            return r2
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        lt1 lt1VarH;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (lt1VarH = h(childAt)) != null && lt1VarH.b == this.l && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        d11 d11Var;
        EdgeEffect edgeEffect = this.S;
        EdgeEffect edgeEffect2 = this.R;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (d11Var = this.k) != null && d11Var.c() > 1)) {
            if (!edgeEffect2.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.v * width);
                edgeEffect2.setSize(height, width);
                zDraw = edgeEffect2.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!edgeEffect.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.w + 1.0f)) * width2);
                edgeEffect.setSize(height2, width2);
                zDraw |= edgeEffect.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            edgeEffect2.finish();
            edgeEffect.finish();
        }
        if (zDraw) {
            WeakHashMap weakHashMap = qs1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.s;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e() {
        int iC = this.k.c();
        this.g = iC;
        ArrayList arrayList = this.h;
        boolean z = arrayList.size() < (this.B * 2) + 1 && arrayList.size() < iC;
        int iMax = this.l;
        int i = 0;
        boolean z2 = false;
        while (i < arrayList.size()) {
            lt1 lt1Var = (lt1) arrayList.get(i);
            d11 d11Var = this.k;
            Object obj = lt1Var.a;
            int iD = d11Var.d();
            if (iD != -1) {
                if (iD == -2) {
                    arrayList.remove(i);
                    i--;
                    if (!z2) {
                        this.k.j(this);
                        z2 = true;
                    }
                    this.k.a(this, lt1Var.a);
                    int i2 = this.l;
                    if (i2 == lt1Var.b) {
                        iMax = Math.max(0, Math.min(i2, iC - 1));
                    }
                } else {
                    int i3 = lt1Var.b;
                    if (i3 != iD) {
                        if (i3 == this.l) {
                            iMax = iD;
                        }
                        lt1Var.b = iD;
                    }
                }
                z = true;
            }
            i++;
        }
        if (z2) {
            this.k.b();
        }
        Collections.sort(arrayList, j0);
        if (z) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                mt1 mt1Var = (mt1) getChildAt(i4).getLayoutParams();
                if (!mt1Var.a) {
                    mt1Var.c = 0.0f;
                }
            }
            u(iMax, 0, false, true);
            requestLayout();
        }
    }

    public final void f(int i) {
        nt1 nt1Var = this.a0;
        if (nt1Var != null) {
            nt1Var.b(i);
        }
        ArrayList arrayList = this.W;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                nt1 nt1Var2 = (nt1) this.W.get(i2);
                if (nt1Var2 != null) {
                    nt1Var2.b(i);
                }
            }
        }
    }

    public final Rect g(View view, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        mt1 mt1Var = new mt1(-1, -1);
        mt1Var.c = 0.0f;
        return mt1Var;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public d11 getAdapter() {
        return this.k;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        if (this.e0 == 2) {
            i2 = (i - 1) - i2;
        }
        return ((mt1) ((View) this.f0.get(i2)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.l;
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getPageMargin() {
        return this.r;
    }

    public final lt1 h(View view) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.h;
            if (i >= arrayList.size()) {
                return null;
            }
            lt1 lt1Var = (lt1) arrayList.get(i);
            if (this.k.f(view, lt1Var.a)) {
                return lt1Var;
            }
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.lt1 i() {
        /*
            r13 = this;
            int r0 = r13.getClientWidth()
            r1 = 0
            if (r0 <= 0) goto Lf
            int r2 = r13.getScrollX()
            float r2 = (float) r2
            float r3 = (float) r0
            float r2 = r2 / r3
            goto L10
        Lf:
            r2 = 0
        L10:
            if (r0 <= 0) goto L18
            int r3 = r13.r
            float r3 = (float) r3
            float r0 = (float) r0
            float r3 = r3 / r0
            goto L19
        L18:
            r3 = 0
        L19:
            r0 = 0
            r4 = -1
            r5 = 1
            r6 = 0
            r7 = r6
            r4 = 0
            r6 = -1
            r8 = 0
            r9 = 1
        L22:
            java.util.ArrayList r10 = r13.h
            int r11 = r10.size()
            if (r8 >= r11) goto L72
            java.lang.Object r11 = r10.get(r8)
            lt1 r11 = (defpackage.lt1) r11
            if (r9 != 0) goto L4c
            int r12 = r11.b
            int r6 = r6 + r5
            if (r12 == r6) goto L4c
            float r1 = r1 + r4
            float r1 = r1 + r3
            lt1 r4 = r13.i
            r4.e = r1
            r4.b = r6
            d11 r1 = r13.k
            r1.getClass()
            r1 = 1065353216(0x3f800000, float:1.0)
            r4.d = r1
            int r8 = r8 + (-1)
            r6 = r4
            goto L4d
        L4c:
            r6 = r11
        L4d:
            float r1 = r6.e
            float r4 = r6.d
            float r4 = r4 + r1
            float r4 = r4 + r3
            if (r9 != 0) goto L59
            int r9 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r9 < 0) goto L72
        L59:
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L71
            int r4 = r10.size()
            int r4 = r4 - r5
            if (r8 != r4) goto L65
            goto L71
        L65:
            int r4 = r6.b
            float r7 = r6.d
            int r8 = r8 + 1
            r9 = r6
            r6 = r4
            r4 = r7
            r7 = r9
            r9 = 0
            goto L22
        L71:
            return r6
        L72:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.i():lt1");
    }

    public final lt1 j(int i) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.h;
            if (i2 >= arrayList.size()) {
                return null;
            }
            lt1 lt1Var = (lt1) arrayList.get(i2);
            if (lt1Var.b == i) {
                return lt1Var;
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k(int r12, float r13, int r14) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.k(int, float, int):void");
    }

    public final void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.L) {
            int i = actionIndex == 0 ? 1 : 0;
            this.H = motionEvent.getX(i);
            this.L = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.M;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean m() {
        d11 d11Var = this.k;
        if (d11Var == null || this.l >= d11Var.c() - 1) {
            return false;
        }
        int i = this.l + 1;
        this.A = false;
        u(i, 0, true, false);
        return true;
    }

    public final boolean n(int i) {
        if (this.h.size() == 0) {
            if (!this.T) {
                this.U = false;
                k(0, 0.0f, 0);
                if (!this.U) {
                    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
                }
            }
            return false;
        }
        lt1 lt1VarI = i();
        int clientWidth = getClientWidth();
        int i2 = this.r;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = lt1VarI.b;
        float f2 = ((i / f) - lt1VarI.e) / (lt1VarI.d + (i2 / f));
        this.U = false;
        k(i4, f2, (int) (i3 * f2));
        if (this.U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final boolean o(float f) {
        boolean z;
        boolean z2;
        float f2 = this.H - f;
        this.H = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.v * clientWidth;
        float f4 = this.w * clientWidth;
        ArrayList arrayList = this.h;
        boolean z3 = false;
        lt1 lt1Var = (lt1) arrayList.get(0);
        lt1 lt1Var2 = (lt1) arrayList.get(arrayList.size() - 1);
        if (lt1Var.b != 0) {
            f3 = lt1Var.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (lt1Var2.b != this.k.c() - 1) {
            f4 = lt1Var2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.R.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.S.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.H = (scrollX - i) + this.H;
        scrollTo(i, getScrollY());
        n(i);
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.g0);
        Scroller scroller = this.o;
        if (scroller != null && !scroller.isFinished()) {
            this.o.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i;
        float f;
        ArrayList arrayList;
        int i2;
        super.onDraw(canvas);
        if (this.r <= 0 || this.s == null) {
            return;
        }
        ArrayList arrayList2 = this.h;
        if (arrayList2.size() <= 0 || this.k == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f2 = this.r / width;
        int i3 = 0;
        lt1 lt1Var = (lt1) arrayList2.get(0);
        float f3 = lt1Var.e;
        int size = arrayList2.size();
        int i4 = lt1Var.b;
        int i5 = ((lt1) arrayList2.get(size - 1)).b;
        while (i4 < i5) {
            while (true) {
                i = lt1Var.b;
                if (i4 <= i || i3 >= size) {
                    break;
                }
                i3++;
                lt1Var = (lt1) arrayList2.get(i3);
            }
            if (i4 == i) {
                float f4 = lt1Var.e;
                float f5 = lt1Var.d;
                f = (f4 + f5) * width;
                f3 = f4 + f5 + f2;
            } else {
                this.k.getClass();
                f = (f3 + 1.0f) * width;
                f3 = 1.0f + f2 + f3;
            }
            if (this.r + f > scrollX) {
                arrayList = arrayList2;
                i2 = scrollX;
                this.s.setBounds(Math.round(f), this.t, Math.round(this.r + f), this.u);
                this.s.draw(canvas);
            } else {
                arrayList = arrayList2;
                i2 = scrollX;
            }
            if (f > i2 + r3) {
                return;
            }
            i4++;
            arrayList2 = arrayList;
            scrollX = i2;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = this.G;
        Scroller scroller = this.o;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            s();
            return false;
        }
        if (action != 0) {
            if (this.C) {
                return true;
            }
            if (this.D) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.J = x;
            this.H = x;
            float y = motionEvent.getY();
            this.K = y;
            this.I = y;
            this.L = motionEvent.getPointerId(0);
            this.D = false;
            this.p = true;
            scroller.computeScrollOffset();
            if (this.h0 != 2 || Math.abs(scroller.getFinalX() - scroller.getCurrX()) <= this.Q) {
                d(false);
                this.C = false;
            } else {
                scroller.abortAnimation();
                this.A = false;
                p();
                this.C = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.L;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f = x2 - this.H;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.K);
                if (f != 0.0f) {
                    float f2 = this.H;
                    if ((f2 >= this.F || f <= 0.0f) && ((f2 <= getWidth() - this.F || f >= 0.0f) && c(this, (int) f, (int) x2, (int) y2, false))) {
                        this.H = x2;
                        this.I = y2;
                        this.D = true;
                        return false;
                    }
                }
                float f3 = i;
                if (fAbs > f3 && fAbs * 0.5f > fAbs2) {
                    this.C = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f4 = this.J;
                    float f5 = i;
                    this.H = f > 0.0f ? f4 + f5 : f4 - f5;
                    this.I = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > f3) {
                    this.D = true;
                }
                if (this.C && o(x2)) {
                    WeakHashMap weakHashMap = qs1.a;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            l(motionEvent);
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        return this.C;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        lt1 lt1VarH;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (lt1VarH = h(childAt)) != null && lt1VarH.b == this.l && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ot1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ot1 ot1Var = (ot1) parcelable;
        super.onRestoreInstanceState(ot1Var.getSuperState());
        if (this.k != null) {
            u(ot1Var.g, 0, false, true);
        } else {
            this.m = ot1Var.g;
            this.n = ot1Var.h;
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ot1 ot1Var = new ot1(super.onSaveInstanceState());
        ot1Var.g = this.l;
        if (this.k != null) {
            ot1Var.h = null;
        }
        return ot1Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.r;
            r(i, i3, i5, i5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        q(this.l);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c7 A[PHI: r7 r11 r15
  0x00c7: PHI (r7v15 int) = (r7v14 int), (r7v4 int), (r7v18 int) binds: [B:64:0x00eb, B:61:0x00d7, B:52:0x00be] A[DONT_GENERATE, DONT_INLINE]
  0x00c7: PHI (r11v32 int) = (r11v1 int), (r11v31 int), (r11v35 int) binds: [B:64:0x00eb, B:61:0x00d7, B:52:0x00be] A[DONT_GENERATE, DONT_INLINE]
  0x00c7: PHI (r15v6 float) = (r15v4 float), (r15v5 float), (r15v3 float) binds: [B:64:0x00eb, B:61:0x00d7, B:52:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0148 A[PHI: r3 r12
  0x0148: PHI (r3v20 float) = (r3v18 float), (r3v19 float), (r3v17 float) binds: [B:98:0x016f, B:95:0x0159, B:88:0x013f] A[DONT_GENERATE, DONT_INLINE]
  0x0148: PHI (r12v25 int) = (r12v23 int), (r12v24 int), (r12v22 int) binds: [B:98:0x016f, B:95:0x0159, B:88:0x013f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(int r18) {
        /*
            Method dump skipped, instruction units count: 890
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.q(int):void");
    }

    public final void r(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.h.isEmpty()) {
            if (!this.o.isFinished()) {
                this.o.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        lt1 lt1VarJ = j(this.l);
        int iMin = (int) ((lt1VarJ != null ? Math.min(lt1VarJ.e, this.w) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            d(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.y) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final boolean s() {
        this.L = -1;
        this.C = false;
        this.D = false;
        VelocityTracker velocityTracker = this.M;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.M = null;
        }
        this.R.onRelease();
        this.S.onRelease();
        return this.R.isFinished() || this.S.isFinished();
    }

    public void setAdapter(d11 d11Var) {
        ArrayList arrayList;
        d11 d11Var2 = this.k;
        if (d11Var2 != null) {
            synchronized (d11Var2) {
                d11Var2.b = null;
            }
            this.k.j(this);
            int i = 0;
            while (true) {
                arrayList = this.h;
                if (i >= arrayList.size()) {
                    break;
                }
                lt1 lt1Var = (lt1) arrayList.get(i);
                d11 d11Var3 = this.k;
                int i2 = lt1Var.b;
                d11Var3.a(this, lt1Var.a);
                i++;
            }
            this.k.b();
            arrayList.clear();
            int i3 = 0;
            while (i3 < getChildCount()) {
                if (!((mt1) getChildAt(i3).getLayoutParams()).a) {
                    removeViewAt(i3);
                    i3--;
                }
                i3++;
            }
            this.l = 0;
            scrollTo(0, 0);
        }
        this.k = d11Var;
        this.g = 0;
        if (d11Var != null) {
            if (this.q == null) {
                this.q = new jq(this, 2);
            }
            this.k.i(this.q);
            this.A = false;
            boolean z = this.T;
            this.T = true;
            this.g = this.k.c();
            if (this.m >= 0) {
                this.k.getClass();
                u(this.m, 0, false, true);
                this.m = -1;
                this.n = null;
            } else if (z) {
                requestLayout();
            } else {
                p();
            }
        }
        ArrayList arrayList2 = this.b0;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        int size = this.b0.size();
        for (int i4 = 0; i4 < size; i4++) {
            vl1 vl1Var = (vl1) this.b0.get(i4);
            TabLayout tabLayout = vl1Var.b;
            if (tabLayout.Q == this) {
                tabLayout.k(d11Var, vl1Var.a);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.A = false;
        u(i, 0, !this.T, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            i = 1;
        }
        if (i != this.B) {
            this.B = i;
            p();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(nt1 nt1Var) {
        this.a0 = nt1Var;
    }

    public void setPageMargin(int i) {
        int i2 = this.r;
        this.r = i;
        int width = getWidth();
        r(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.s = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.h0 == i) {
            return;
        }
        this.h0 = i;
        if (this.c0 != null) {
            boolean z = i != 0;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).setLayerType(z ? this.d0 : 0, null);
            }
        }
        nt1 nt1Var = this.a0;
        if (nt1Var != null) {
            nt1Var.a(i);
        }
        ArrayList arrayList = this.W;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                nt1 nt1Var2 = (nt1) this.W.get(i3);
                if (nt1Var2 != null) {
                    nt1Var2.a(i);
                }
            }
        }
    }

    public final void t(int i, int i2, boolean z, boolean z2) {
        int scrollX;
        int iAbs;
        Scroller scroller = this.o;
        lt1 lt1VarJ = j(i);
        int iMax = lt1VarJ != null ? (int) (Math.max(this.v, Math.min(lt1VarJ.e, this.w)) * getClientWidth()) : 0;
        if (!z) {
            if (z2) {
                f(i);
            }
            d(false);
            scrollTo(iMax, 0);
            n(iMax);
            return;
        }
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
        } else {
            if (scroller == null || scroller.isFinished()) {
                scrollX = getScrollX();
            } else {
                scrollX = this.p ? scroller.getCurrX() : scroller.getStartX();
                scroller.abortAnimation();
                setScrollingCacheEnabled(false);
            }
            int i3 = scrollX;
            int scrollY = getScrollY();
            int i4 = iMax - i3;
            int i5 = 0 - scrollY;
            if (i4 == 0 && i5 == 0) {
                d(false);
                p();
                setScrollState(0);
            } else {
                setScrollingCacheEnabled(true);
                setScrollState(2);
                int clientWidth = getClientWidth();
                int i6 = clientWidth / 2;
                float f = clientWidth;
                float f2 = i6;
                float fSin = (((float) Math.sin((Math.min(1.0f, (Math.abs(i4) * 1.0f) / f) - 0.5f) * 0.47123894f)) * f2) + f2;
                int iAbs2 = Math.abs(i2);
                if (iAbs2 > 0) {
                    iAbs = Math.round(Math.abs(fSin / iAbs2) * 1000.0f) * 4;
                } else {
                    this.k.getClass();
                    iAbs = (int) (((Math.abs(i4) / ((f * 1.0f) + this.r)) + 1.0f) * 100.0f);
                }
                int iMin = Math.min(iAbs, 600);
                this.p = false;
                this.o.startScroll(i3, scrollY, i4, i5, iMin);
                WeakHashMap weakHashMap = qs1.a;
                postInvalidateOnAnimation();
            }
        }
        if (z2) {
            f(i);
        }
    }

    public final void u(int i, int i2, boolean z, boolean z2) {
        d11 d11Var = this.k;
        if (d11Var == null || d11Var.c() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        ArrayList arrayList = this.h;
        if (!z2 && this.l == i && arrayList.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.k.c()) {
            i = this.k.c() - 1;
        }
        int i3 = this.B;
        int i4 = this.l;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                ((lt1) arrayList.get(i5)).c = true;
            }
        }
        boolean z3 = this.l != i;
        if (!this.T) {
            q(i);
            t(i, i2, z, z3);
        } else {
            this.l = i;
            if (z3) {
                f(i);
            }
            requestLayout();
        }
    }

    public final void v() {
        if (this.e0 != 0) {
            ArrayList arrayList = this.f0;
            if (arrayList == null) {
                this.f0 = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f0.add(getChildAt(i));
            }
            Collections.sort(this.f0, l0);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.s;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        mt1 mt1Var = new mt1(context, attributeSet);
        mt1Var.c = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i0);
        mt1Var.b = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
        return mt1Var;
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getDrawable(i));
    }
}
