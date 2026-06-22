package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import defpackage.az1;
import defpackage.fs1;
import defpackage.hs1;
import defpackage.k71;
import defpackage.l21;
import defpackage.l41;
import defpackage.lo;
import defpackage.ly1;
import defpackage.mo;
import defpackage.no;
import defpackage.nx0;
import defpackage.oo;
import defpackage.po;
import defpackage.qm0;
import defpackage.qo;
import defpackage.qs1;
import defpackage.ro;
import defpackage.ug1;
import defpackage.ww0;
import defpackage.xs1;
import defpackage.xw0;
import defpackage.y4;
import defpackage.yw0;
import defpackage.z61;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements ww0, xw0 {
    public static final Class[] A;
    public static final ThreadLocal B;
    public static final y4 C;
    public static final l21 D;
    public static final String z;
    public final ArrayList g;
    public final qm0 h;
    public final ArrayList i;
    public final ArrayList j;
    public final int[] k;
    public final int[] l;
    public boolean m;
    public boolean n;
    public final int[] o;
    public View p;
    public View q;
    public qo r;
    public boolean s;
    public ly1 t;
    public boolean u;
    public Drawable v;
    public ViewGroup.OnHierarchyChangeListener w;
    public nx0 x;
    public final yw0 y;

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        z = r0 != null ? r0.getName() : null;
        C = new y4(3);
        A = new Class[]{Context.class, AttributeSet.class};
        B = new ThreadLocal();
        D = new l21(12);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        int i = l41.coordinatorLayoutStyle;
        super(context, attributeSet, i);
        this.g = new ArrayList();
        this.h = new qm0(2);
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new int[2];
        this.l = new int[2];
        this.y = new yw0();
        TypedArray typedArrayObtainStyledAttributes = i == 0 ? context.obtainStyledAttributes(attributeSet, k71.CoordinatorLayout, 0, z61.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, k71.CoordinatorLayout, i, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, k71.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, z61.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, k71.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(k71.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.o = intArray;
            float f = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.o[i2] = (int) (r3[i2] * f);
            }
        }
        this.v = typedArrayObtainStyledAttributes.getDrawable(k71.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        p();
        super.setOnHierarchyChangeListener(new oo(this));
        WeakHashMap weakHashMap = qs1.a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect a() {
        Rect rect = (Rect) D.a();
        return rect == null ? new Rect() : rect;
    }

    public static void f(int i, Rect rect, Rect rect2, po poVar, int i2, int i3) {
        int i4 = poVar.c;
        if (i4 == 0) {
            i4 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i5 = poVar.d;
        if ((i5 & 7) == 0) {
            i5 |= 8388611;
        }
        if ((i5 & 112) == 0) {
            i5 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i5, i);
        int i6 = absoluteGravity & 7;
        int i7 = absoluteGravity & 112;
        int i8 = absoluteGravity2 & 7;
        int i9 = absoluteGravity2 & 112;
        int iWidth = i8 != 1 ? i8 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i9 != 16 ? i9 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i6 == 1) {
            iWidth -= i2 / 2;
        } else if (i6 != 5) {
            iWidth -= i2;
        }
        if (i7 == 16) {
            iHeight -= i3 / 2;
        } else if (i7 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static po g(View view) {
        po poVar = (po) view.getLayoutParams();
        if (!poVar.b) {
            if (view instanceof lo) {
                mo behavior = ((lo) view).getBehavior();
                mo moVar = poVar.a;
                if (moVar != behavior) {
                    if (moVar != null) {
                        moVar.e();
                    }
                    poVar.a = behavior;
                    poVar.b = true;
                    if (behavior != null) {
                        behavior.c(poVar);
                    }
                }
                poVar.b = true;
                return poVar;
            }
            no noVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                noVar = (no) superclass.getAnnotation(no.class);
                if (noVar != null) {
                    break;
                }
            }
            if (noVar != null) {
                try {
                    mo moVar2 = (mo) noVar.value().getDeclaredConstructor(null).newInstance(null);
                    mo moVar3 = poVar.a;
                    if (moVar3 != moVar2) {
                        if (moVar3 != null) {
                            moVar3.e();
                        }
                        poVar.a = moVar2;
                        poVar.b = true;
                        if (moVar2 != null) {
                            moVar2.c(poVar);
                        }
                    }
                } catch (Exception unused) {
                    noVar.value().getClass();
                }
            }
            poVar.b = true;
        }
        return poVar;
    }

    public static void n(int i, View view) {
        po poVar = (po) view.getLayoutParams();
        int i2 = poVar.i;
        if (i2 != i) {
            qs1.i(i - i2, view);
            poVar.i = i;
        }
    }

    public static void o(int i, View view) {
        po poVar = (po) view.getLayoutParams();
        int i2 = poVar.j;
        if (i2 != i) {
            qs1.j(i - i2, view);
            poVar.j = i;
        }
    }

    public final void b(po poVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) poVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) poVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) poVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) poVar).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i2 + iMax2);
    }

    public final void c(View view, Rect rect, boolean z2) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            e(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof po) && super.checkLayoutParams(layoutParams);
    }

    public final ArrayList d(View view) {
        ug1 ug1Var = (ug1) this.h.b;
        int i = ug1Var.i;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList2 = (ArrayList) ug1Var.j(i2);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(ug1Var.f(i2));
            }
        }
        ArrayList arrayList3 = this.j;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        mo moVar = ((po) view.getLayoutParams()).a;
        if (moVar != null) {
            moVar.getClass();
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.v;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public final void e(View view, Rect rect) {
        ThreadLocal threadLocal = xs1.a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = xs1.a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        xs1.a(this, view, matrix);
        ThreadLocal threadLocal3 = xs1.b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new po();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new po(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        l();
        return Collections.unmodifiableList(this.g);
    }

    public final ly1 getLastWindowInsets() {
        return this.t;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        yw0 yw0Var = this.y;
        return yw0Var.b | yw0Var.a;
    }

    public Drawable getStatusBarBackground() {
        return this.v;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final boolean h(View view, int i, int i2) {
        l21 l21Var = D;
        Rect rectA = a();
        e(view, rectA);
        try {
            return rectA.contains(i, i2);
        } finally {
            rectA.setEmpty();
            l21Var.c(rectA);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x028c A[EDGE_INSN: B:147:0x028c->B:113:0x028c BREAK  A[LOOP:2: B:118:0x02a4->B:136:0x02dd], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(int r26) {
        /*
            Method dump skipped, instruction units count: 773
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.i(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(int r13, android.view.View r14) {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.j(int, android.view.View):void");
    }

    public final boolean k(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.i;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        y4 y4Var = C;
        if (y4Var != null) {
            Collections.sort(arrayList, y4Var);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zF = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) arrayList.get(i3);
            mo moVar = ((po) view.getLayoutParams()).a;
            if (zF && actionMasked != 0) {
                if (moVar != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i == 0) {
                        moVar.f(this, view, motionEventObtain);
                    } else if (i == 1) {
                        moVar.r(view, motionEventObtain);
                    }
                }
            } else if (!zF && moVar != null) {
                if (i == 0) {
                    zF = moVar.f(this, view, motionEvent);
                } else if (i == 1) {
                    zF = moVar.r(view, motionEvent);
                }
                if (zF) {
                    this.p = view;
                }
            }
        }
        arrayList.clear();
        return zF;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.l():void");
    }

    public final void m(boolean z2) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            mo moVar = ((po) childAt.getLayoutParams()).a;
            if (moVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    moVar.f(this, childAt, motionEventObtain);
                } else {
                    moVar.r(childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((po) getChildAt(i2).getLayoutParams()).getClass();
        }
        this.p = null;
        this.m = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = 0;
        m(false);
        if (this.s) {
            if (this.r == null) {
                this.r = new qo(this, i);
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        if (this.t == null) {
            WeakHashMap weakHashMap = qs1.a;
            if (getFitsSystemWindows()) {
                fs1.c(this);
            }
        }
        this.n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m(false);
        if (this.s && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        View view = this.q;
        if (view != null) {
            onStopNestedScroll(view, 0);
        }
        this.n = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.u || this.v == null) {
            return;
        }
        ly1 ly1Var = this.t;
        int iD = ly1Var != null ? ly1Var.d() : 0;
        if (iD > 0) {
            this.v.setBounds(0, 0, getWidth(), iD);
            this.v.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m(true);
        }
        boolean zK = k(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zK;
        }
        m(true);
        return zK;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        mo moVar;
        WeakHashMap weakHashMap = qs1.a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) arrayList.get(i5);
            if (view.getVisibility() != 8 && ((moVar = ((po) view.getLayoutParams()).a) == null || !moVar.g(this, view, layoutDirection))) {
                j(layoutDirection, view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0125 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a0  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z2) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                po poVar = (po) childAt.getLayoutParams();
                if (poVar.a(0)) {
                    mo moVar = poVar.a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        mo moVar;
        int childCount = getChildCount();
        boolean zI = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                po poVar = (po) childAt.getLayoutParams();
                if (poVar.a(0) && (moVar = poVar.a) != null) {
                    zI |= moVar.i(childAt, view, f2);
                }
            }
        }
        return zI;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // defpackage.ww0
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        yw0 yw0Var = this.y;
        if (i2 == 1) {
            yw0Var.b = i;
        } else {
            yw0Var.a = i;
        }
        this.q = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((po) getChildAt(i3).getLayoutParams()).getClass();
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof ro)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ro roVar = (ro) parcelable;
        super.onRestoreInstanceState(roVar.getSuperState());
        SparseArray sparseArray = roVar.g;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            mo moVar = g(childAt).a;
            if (id != -1 && moVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                moVar.n(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableO;
        ro roVar = new ro(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            mo moVar = ((po) childAt.getLayoutParams()).a;
            if (id != -1 && moVar != null && (parcelableO = moVar.o(childAt)) != null) {
                sparseArray.append(id, parcelableO);
            }
        }
        roVar.g = sparseArray;
        return roVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // defpackage.ww0
    public final void onStopNestedScroll(View view, int i) {
        yw0 yw0Var = this.y;
        if (i == 1) {
            yw0Var.b = 0;
        } else {
            yw0Var.a = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            po poVar = (po) childAt.getLayoutParams();
            if (poVar.a(i)) {
                mo moVar = poVar.a;
                if (moVar != null) {
                    moVar.q(this, childAt, view, i);
                }
                if (i == 0) {
                    poVar.m = false;
                } else if (i == 1) {
                    poVar.n = false;
                }
                poVar.o = false;
            }
        }
        this.q = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
  0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.p
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.k(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = 0
            goto L2a
        L17:
            r3 = 0
        L18:
            android.view.View r6 = r0.p
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            po r6 = (defpackage.po) r6
            mo r6 = r6.a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.p
            boolean r6 = r6.r(r7, r1)
        L2a:
            android.view.View r7 = r0.p
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r9 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L53
            goto L54
        L53:
            return r6
        L54:
            r0.m(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        WeakHashMap weakHashMap = qs1.a;
        if (!getFitsSystemWindows()) {
            hs1.m(this, null);
            return;
        }
        if (this.x == null) {
            this.x = new nx0(this, 9);
        }
        hs1.m(this, this.x);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        mo moVar = ((po) view.getLayoutParams()).a;
        if (moVar != null) {
            moVar.m(this, view);
        }
        return super.requestChildRectangleOnScreen(view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (!z2 || this.m) {
            return;
        }
        m(false);
        this.m = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        p();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.w = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.v;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.v = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.v.setState(getDrawableState());
                }
                Drawable drawable3 = this.v;
                WeakHashMap weakHashMap = qs1.a;
                az1.G(drawable3, getLayoutDirection());
                this.v.setVisible(getVisibility() == 0, false);
                this.v.setCallback(this);
            }
            WeakHashMap weakHashMap2 = qs1.a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? getContext().getDrawable(i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z2 = i == 0;
        Drawable drawable = this.v;
        if (drawable == null || drawable.isVisible() == z2) {
            return;
        }
        this.v.setVisible(z2, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.v;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof po ? new po((po) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new po((ViewGroup.MarginLayoutParams) layoutParams) : new po(layoutParams);
    }

    @Override // defpackage.ww0
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        mo moVar;
        int childCount = getChildCount();
        boolean z2 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                po poVar = (po) childAt.getLayoutParams();
                if (poVar.a(i3) && (moVar = poVar.a) != null) {
                    int[] iArr2 = this.k;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    moVar.j(this, childAt, view, i, i2, iArr2, i3);
                    iMax = i > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i2 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z2) {
            i(1);
        }
    }

    @Override // defpackage.ww0
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.l);
    }

    @Override // defpackage.ww0
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                po poVar = (po) childAt.getLayoutParams();
                mo moVar = poVar.a;
                if (moVar != null) {
                    boolean zP = moVar.p(this, childAt, view, view2, i, i2);
                    z2 |= zP;
                    if (i2 == 0) {
                        poVar.m = zP;
                    } else if (i2 == 1) {
                        poVar.n = zP;
                    }
                } else if (i2 == 0) {
                    poVar.m = false;
                } else if (i2 == 1) {
                    poVar.n = false;
                }
            }
        }
        return z2;
    }

    @Override // defpackage.xw0
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        mo moVar;
        int iMin;
        int iMin2;
        int childCount = getChildCount();
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                po poVar = (po) childAt.getLayoutParams();
                if (poVar.a(i5) && (moVar = poVar.a) != null) {
                    int[] iArr2 = this.k;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    moVar.l(this, childAt, view, i, i2, i3, i4, i5, iArr2);
                    if (i3 > 0) {
                        iMin = Math.max(i6, iArr2[0]);
                    } else {
                        iMin = Math.min(i6, iArr2[0]);
                    }
                    i6 = iMin;
                    if (i4 > 0) {
                        iMin2 = Math.max(i7, iArr2[1]);
                    } else {
                        iMin2 = Math.min(i7, iArr2[1]);
                    }
                    i7 = iMin2;
                    z2 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (z2) {
            i(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }
}
