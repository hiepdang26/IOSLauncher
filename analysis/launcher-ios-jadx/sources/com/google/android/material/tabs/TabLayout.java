package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.viewpager.widget.ViewPager;
import com.luutinhit.launcher6.t;
import defpackage.am1;
import defpackage.az1;
import defpackage.b71;
import defpackage.bm1;
import defpackage.cm1;
import defpackage.d11;
import defpackage.d51;
import defpackage.em1;
import defpackage.f71;
import defpackage.hg0;
import defpackage.hs1;
import defpackage.jq;
import defpackage.k21;
import defpackage.kt1;
import defpackage.l21;
import defpackage.mc1;
import defpackage.mn1;
import defpackage.n5;
import defpackage.np1;
import defpackage.q41;
import defpackage.q7;
import defpackage.q71;
import defpackage.qg0;
import defpackage.qs1;
import defpackage.rr0;
import defpackage.sy;
import defpackage.ta1;
import defpackage.tr0;
import defpackage.uo0;
import defpackage.vl1;
import defpackage.wl1;
import defpackage.xl1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@kt1
public class TabLayout extends HorizontalScrollView {
    public static final int a0 = b71.Widget_Design_TabLayout;
    public static final l21 b0 = new l21(16);
    public final int A;
    public final int B;
    public int C;
    public final int D;
    public int E;
    public int F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public boolean K;
    public ta1 L;
    public wl1 M;
    public final ArrayList N;
    public uo0 O;
    public ValueAnimator P;
    public ViewPager Q;
    public d11 R;
    public jq S;
    public cm1 T;
    public vl1 U;
    public boolean V;
    public final k21 W;
    public final ArrayList g;
    public bm1 h;
    public final am1 i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public ColorStateList o;
    public ColorStateList p;
    public ColorStateList q;
    public Drawable r;
    public int s;
    public final PorterDuff.Mode t;
    public final float u;
    public final float v;
    public final int w;
    public int x;
    public final int y;
    public final int z;

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet) {
        int i = q41.tabStyle;
        int i2 = a0;
        super(tr0.a(context, attributeSet, i, i2), attributeSet, i);
        this.g = new ArrayList();
        this.r = new GradientDrawable();
        this.s = 0;
        this.x = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.I = -1;
        this.N = new ArrayList();
        this.W = new k21(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        am1 am1Var = new am1(this, context2);
        this.i = am1Var;
        super.addView(am1Var, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayD = mn1.d(context2, attributeSet, f71.TabLayout, i, i2, f71.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            rr0 rr0Var = new rr0();
            rr0Var.k(ColorStateList.valueOf(colorDrawable.getColor()));
            rr0Var.i(context2);
            WeakHashMap weakHashMap = qs1.a;
            rr0Var.j(hs1.e(this));
            setBackground(rr0Var);
        }
        setSelectedTabIndicator(np1.n(context2, typedArrayD, f71.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayD.getColor(f71.TabLayout_tabIndicatorColor, 0));
        am1Var.b(typedArrayD.getDimensionPixelSize(f71.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayD.getInt(f71.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayD.getInt(f71.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayD.getBoolean(f71.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(f71.TabLayout_tabPadding, 0);
        this.m = dimensionPixelSize;
        this.l = dimensionPixelSize;
        this.k = dimensionPixelSize;
        this.j = dimensionPixelSize;
        this.j = typedArrayD.getDimensionPixelSize(f71.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.k = typedArrayD.getDimensionPixelSize(f71.TabLayout_tabPaddingTop, dimensionPixelSize);
        this.l = typedArrayD.getDimensionPixelSize(f71.TabLayout_tabPaddingEnd, dimensionPixelSize);
        this.m = typedArrayD.getDimensionPixelSize(f71.TabLayout_tabPaddingBottom, dimensionPixelSize);
        int resourceId = typedArrayD.getResourceId(f71.TabLayout_tabTextAppearance, b71.TextAppearance_Design_Tab);
        this.n = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, q71.TextAppearance);
        try {
            this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(q71.TextAppearance_android_textSize, 0);
            this.o = np1.l(context2, typedArrayObtainStyledAttributes, q71.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayD.hasValue(f71.TabLayout_tabTextColor)) {
                this.o = np1.l(context2, typedArrayD, f71.TabLayout_tabTextColor);
            }
            if (typedArrayD.hasValue(f71.TabLayout_tabSelectedTextColor)) {
                this.o = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{typedArrayD.getColor(f71.TabLayout_tabSelectedTextColor, 0), this.o.getDefaultColor()});
            }
            this.p = np1.l(context2, typedArrayD, f71.TabLayout_tabIconTint);
            this.t = qg0.C(typedArrayD.getInt(f71.TabLayout_tabIconTintMode, -1), null);
            this.q = np1.l(context2, typedArrayD, f71.TabLayout_tabRippleColor);
            this.D = typedArrayD.getInt(f71.TabLayout_tabIndicatorAnimationDuration, t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT);
            this.y = typedArrayD.getDimensionPixelSize(f71.TabLayout_tabMinWidth, -1);
            this.z = typedArrayD.getDimensionPixelSize(f71.TabLayout_tabMaxWidth, -1);
            this.w = typedArrayD.getResourceId(f71.TabLayout_tabBackground, 0);
            this.B = typedArrayD.getDimensionPixelSize(f71.TabLayout_tabContentStart, 0);
            this.F = typedArrayD.getInt(f71.TabLayout_tabMode, 1);
            this.C = typedArrayD.getInt(f71.TabLayout_tabGravity, 0);
            this.G = typedArrayD.getBoolean(f71.TabLayout_tabInlineLabel, false);
            this.K = typedArrayD.getBoolean(f71.TabLayout_tabUnboundedRipple, false);
            typedArrayD.recycle();
            Resources resources = getResources();
            this.v = resources.getDimensionPixelSize(d51.design_tab_text_size_2line);
            this.A = resources.getDimensionPixelSize(d51.design_tab_scrollable_min_width);
            d();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bm1 bm1Var = (bm1) arrayList.get(i);
            if (bm1Var != null && bm1Var.a != null && !TextUtils.isEmpty(bm1Var.b)) {
                return !this.G ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i = this.y;
        if (i != -1) {
            return i;
        }
        int i2 = this.F;
        if (i2 == 0 || i2 == 2) {
            return this.A;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.i.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        am1 am1Var = this.i;
        int childCount = am1Var.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = am1Var.getChildAt(i2);
                boolean z = true;
                childAt.setSelected(i2 == i);
                if (i2 != i) {
                    z = false;
                }
                childAt.setActivated(z);
                i2++;
            }
        }
    }

    public final void a(bm1 bm1Var, boolean z) {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        if (bm1Var.f != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        bm1Var.d = size;
        arrayList.add(size, bm1Var);
        int size2 = arrayList.size();
        for (int i = size + 1; i < size2; i++) {
            ((bm1) arrayList.get(i)).d = i;
        }
        em1 em1Var = bm1Var.g;
        em1Var.setSelected(false);
        em1Var.setActivated(false);
        int i2 = bm1Var.d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (this.F == 1 && this.C == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
        this.i.addView(em1Var, i2, layoutParams);
        if (z) {
            bm1Var.a();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        b(view);
    }

    public final void b(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        TabItem tabItem = (TabItem) view;
        bm1 bm1VarH = h();
        CharSequence charSequence = tabItem.g;
        if (charSequence != null) {
            if (TextUtils.isEmpty(bm1VarH.c) && !TextUtils.isEmpty(charSequence)) {
                bm1VarH.g.setContentDescription(charSequence);
            }
            bm1VarH.b = charSequence;
            em1 em1Var = bm1VarH.g;
            if (em1Var != null) {
                em1Var.e();
            }
        }
        Drawable drawable = tabItem.h;
        if (drawable != null) {
            bm1VarH.a = drawable;
            TabLayout tabLayout = bm1VarH.f;
            if (tabLayout.C == 1 || tabLayout.F == 2) {
                tabLayout.n(true);
            }
            em1 em1Var2 = bm1VarH.g;
            if (em1Var2 != null) {
                em1Var2.e();
            }
        }
        int i = tabItem.i;
        if (i != 0) {
            bm1VarH.e = LayoutInflater.from(bm1VarH.g.getContext()).inflate(i, (ViewGroup) bm1VarH.g, false);
            em1 em1Var3 = bm1VarH.g;
            if (em1Var3 != null) {
                em1Var3.e();
            }
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            bm1VarH.c = tabItem.getContentDescription();
            em1 em1Var4 = bm1VarH.g;
            if (em1Var4 != null) {
                em1Var4.e();
            }
        }
        a(bm1VarH, this.g.isEmpty());
    }

    public final void c(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = qs1.a;
            if (isLaidOut()) {
                am1 am1Var = this.i;
                int childCount = am1Var.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (am1Var.getChildAt(i2).getWidth() > 0) {
                    }
                }
                int scrollX = getScrollX();
                int iE = e(0.0f, i);
                if (scrollX != iE) {
                    f();
                    this.P.setIntValues(scrollX, iE);
                    this.P.start();
                }
                ValueAnimator valueAnimator = am1Var.g;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    am1Var.g.cancel();
                }
                am1Var.d(i, this.D, true);
                return;
            }
        }
        l(i, 0.0f, true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r4 = this;
            int r0 = r4.F
            r1 = 2
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r0 = 0
            goto L14
        Lb:
            int r0 = r4.B
            int r3 = r4.j
            int r0 = r0 - r3
            int r0 = java.lang.Math.max(r2, r0)
        L14:
            java.util.WeakHashMap r3 = defpackage.qs1.a
            am1 r3 = r4.i
            r3.setPaddingRelative(r0, r2, r2, r2)
            int r0 = r4.F
            r2 = 1
            if (r0 == 0) goto L29
            if (r0 == r2) goto L25
            if (r0 == r1) goto L25
            goto L3c
        L25:
            r3.setGravity(r2)
            goto L3c
        L29:
            int r0 = r4.C
            if (r0 == 0) goto L36
            if (r0 == r2) goto L32
            if (r0 == r1) goto L36
            goto L3c
        L32:
            r3.setGravity(r2)
            goto L3c
        L36:
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r0)
        L3c:
            r4.n(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.d():void");
    }

    public final int e(float f, int i) {
        am1 am1Var;
        View childAt;
        int i2 = this.F;
        if ((i2 != 0 && i2 != 2) || (childAt = (am1Var = this.i).getChildAt(i)) == null) {
            return 0;
        }
        int i3 = i + 1;
        View childAt2 = i3 < am1Var.getChildCount() ? am1Var.getChildAt(i3) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f);
        WeakHashMap weakHashMap = qs1.a;
        return getLayoutDirection() == 0 ? left + i4 : left - i4;
    }

    public final void f() {
        if (this.P == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.P = valueAnimator;
            valueAnimator.setInterpolator(n5.b);
            this.P.setDuration(this.D);
            this.P.addUpdateListener(new q7(this, 11));
        }
    }

    public final bm1 g(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return (bm1) this.g.get(i);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        bm1 bm1Var = this.h;
        if (bm1Var != null) {
            return bm1Var.d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.g.size();
    }

    public int getTabGravity() {
        return this.C;
    }

    public ColorStateList getTabIconTint() {
        return this.p;
    }

    public int getTabIndicatorAnimationMode() {
        return this.J;
    }

    public int getTabIndicatorGravity() {
        return this.E;
    }

    public int getTabMaxWidth() {
        return this.x;
    }

    public int getTabMode() {
        return this.F;
    }

    public ColorStateList getTabRippleColor() {
        return this.q;
    }

    public Drawable getTabSelectedIndicator() {
        return this.r;
    }

    public ColorStateList getTabTextColors() {
        return this.o;
    }

    public final bm1 h() {
        bm1 bm1Var = (bm1) b0.a();
        if (bm1Var == null) {
            bm1Var = new bm1();
            bm1Var.d = -1;
        }
        bm1Var.f = this;
        k21 k21Var = this.W;
        em1 em1Var = k21Var != null ? (em1) k21Var.a() : null;
        if (em1Var == null) {
            em1Var = new em1(this, getContext());
        }
        em1Var.setTab(bm1Var);
        em1Var.setFocusable(true);
        em1Var.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(bm1Var.c)) {
            em1Var.setContentDescription(bm1Var.b);
        } else {
            em1Var.setContentDescription(bm1Var.c);
        }
        bm1Var.g = em1Var;
        return bm1Var;
    }

    public final void i() {
        int currentItem;
        am1 am1Var = this.i;
        for (int childCount = am1Var.getChildCount() - 1; childCount >= 0; childCount--) {
            em1 em1Var = (em1) am1Var.getChildAt(childCount);
            am1Var.removeViewAt(childCount);
            if (em1Var != null) {
                em1Var.setTab(null);
                em1Var.setSelected(false);
                this.W.c(em1Var);
            }
            requestLayout();
        }
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            bm1 bm1Var = (bm1) it.next();
            it.remove();
            bm1Var.f = null;
            bm1Var.g = null;
            bm1Var.a = null;
            bm1Var.b = null;
            bm1Var.c = null;
            bm1Var.d = -1;
            bm1Var.e = null;
            b0.c(bm1Var);
        }
        this.h = null;
        d11 d11Var = this.R;
        if (d11Var != null) {
            int iC = d11Var.c();
            for (int i = 0; i < iC; i++) {
                bm1 bm1VarH = h();
                this.R.getClass();
                if (TextUtils.isEmpty(bm1VarH.c) && !TextUtils.isEmpty(null)) {
                    bm1VarH.g.setContentDescription(null);
                }
                bm1VarH.b = null;
                em1 em1Var2 = bm1VarH.g;
                if (em1Var2 != null) {
                    em1Var2.e();
                }
                a(bm1VarH, false);
            }
            ViewPager viewPager = this.Q;
            if (viewPager == null || iC <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            j(g(currentItem), true);
        }
    }

    public final void j(bm1 bm1Var, boolean z) {
        bm1 bm1Var2 = this.h;
        ArrayList arrayList = this.N;
        if (bm1Var2 == bm1Var) {
            if (bm1Var2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((wl1) arrayList.get(size)).a(bm1Var);
                }
                c(bm1Var.d);
                return;
            }
            return;
        }
        int i = bm1Var != null ? bm1Var.d : -1;
        if (z) {
            if ((bm1Var2 == null || bm1Var2.d == -1) && i != -1) {
                l(i, 0.0f, true, true);
            } else {
                c(i);
            }
            if (i != -1) {
                setSelectedTabView(i);
            }
        }
        this.h = bm1Var;
        if (bm1Var2 != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((wl1) arrayList.get(size2)).getClass();
            }
        }
        if (bm1Var != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((wl1) arrayList.get(size3)).b(bm1Var);
            }
        }
    }

    public final void k(d11 d11Var, boolean z) {
        jq jqVar;
        d11 d11Var2 = this.R;
        if (d11Var2 != null && (jqVar = this.S) != null) {
            d11Var2.a.unregisterObserver(jqVar);
        }
        this.R = d11Var;
        if (z && d11Var != null) {
            if (this.S == null) {
                this.S = new jq(this, 1);
            }
            d11Var.a.registerObserver(this.S);
        }
        i();
    }

    public final void l(int i, float f, boolean z, boolean z2) {
        int iRound = Math.round(i + f);
        if (iRound >= 0) {
            am1 am1Var = this.i;
            if (iRound >= am1Var.getChildCount()) {
                return;
            }
            if (z2) {
                ValueAnimator valueAnimator = am1Var.g;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    am1Var.g.cancel();
                }
                am1Var.h = i;
                am1Var.i = f;
                am1Var.c(am1Var.getChildAt(i), am1Var.getChildAt(am1Var.h + 1), am1Var.i);
            }
            ValueAnimator valueAnimator2 = this.P;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.P.cancel();
            }
            scrollTo(i < 0 ? 0 : e(f, i), 0);
            if (z) {
                setSelectedTabView(iRound);
            }
        }
    }

    public final void m(ViewPager viewPager, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ViewPager viewPager2 = this.Q;
        if (viewPager2 != null) {
            cm1 cm1Var = this.T;
            if (cm1Var != null && (arrayList2 = viewPager2.W) != null) {
                arrayList2.remove(cm1Var);
            }
            vl1 vl1Var = this.U;
            if (vl1Var != null && (arrayList = this.Q.b0) != null) {
                arrayList.remove(vl1Var);
            }
        }
        uo0 uo0Var = this.O;
        ArrayList arrayList3 = this.N;
        if (uo0Var != null) {
            arrayList3.remove(uo0Var);
            this.O = null;
        }
        if (viewPager != null) {
            this.Q = viewPager;
            if (this.T == null) {
                this.T = new cm1(this);
            }
            cm1 cm1Var2 = this.T;
            cm1Var2.i = 0;
            cm1Var2.h = 0;
            if (viewPager.W == null) {
                viewPager.W = new ArrayList();
            }
            viewPager.W.add(cm1Var2);
            uo0 uo0Var2 = new uo0(viewPager, 1);
            this.O = uo0Var2;
            if (!arrayList3.contains(uo0Var2)) {
                arrayList3.add(uo0Var2);
            }
            d11 adapter = viewPager.getAdapter();
            if (adapter != null) {
                k(adapter, true);
            }
            if (this.U == null) {
                this.U = new vl1(this);
            }
            vl1 vl1Var2 = this.U;
            vl1Var2.a = true;
            if (viewPager.b0 == null) {
                viewPager.b0 = new ArrayList();
            }
            viewPager.b0.add(vl1Var2);
            l(viewPager.getCurrentItem(), 0.0f, true, true);
        } else {
            this.Q = null;
            k(null, false);
        }
        this.V = z;
    }

    public final void n(boolean z) {
        int i = 0;
        while (true) {
            am1 am1Var = this.i;
            if (i >= am1Var.getChildCount()) {
                return;
            }
            View childAt = am1Var.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.F == 1 && this.C == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z) {
                childAt.requestLayout();
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof rr0) {
            az1.H(this, (rr0) background);
        }
        if (this.Q == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m((ViewPager) parent, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.V) {
            setupWithViewPager(null);
            this.V = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        em1 em1Var;
        Drawable drawable;
        int i = 0;
        while (true) {
            am1 am1Var = this.i;
            if (i >= am1Var.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = am1Var.getChildAt(i);
            if ((childAt instanceof em1) && (drawable = (em1Var = (em1) childAt).o) != null) {
                drawable.setBounds(em1Var.getLeft(), em1Var.getTop(), em1Var.getRight(), em1Var.getBottom());
                em1Var.o.draw(canvas);
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) mc1.v(1, getTabCount(), 1).h);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = defpackage.qg0.q(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.z
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = defpackage.qg0.q(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.x = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Laa
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.F
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto Laa
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L81
            goto L8c
        L81:
            return
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto Laa
        L8c:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r1, r0)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            r7.measure(r0, r8)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof rr0) {
            ((rr0) background).j(f);
        }
    }

    public void setInlineLabel(boolean z) {
        if (this.G == z) {
            return;
        }
        this.G = z;
        int i = 0;
        while (true) {
            am1 am1Var = this.i;
            if (i >= am1Var.getChildCount()) {
                d();
                return;
            }
            View childAt = am1Var.getChildAt(i);
            if (childAt instanceof em1) {
                em1 em1Var = (em1) childAt;
                em1Var.setOrientation(!em1Var.q.G ? 1 : 0);
                TextView textView = em1Var.m;
                if (textView == null && em1Var.n == null) {
                    em1Var.g(em1Var.h, em1Var.i);
                } else {
                    em1Var.g(textView, em1Var.n);
                }
            }
            i++;
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(xl1 xl1Var) {
        setOnTabSelectedListener((wl1) xl1Var);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.P.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.r != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.r = drawable;
            int intrinsicHeight = this.I;
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable.getIntrinsicHeight();
            }
            this.i.b(intrinsicHeight);
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.s = i;
        n(false);
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.E != i) {
            this.E = i;
            WeakHashMap weakHashMap = qs1.a;
            this.i.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.I = i;
        this.i.b(i);
    }

    public void setTabGravity(int i) {
        if (this.C != i) {
            this.C = i;
            d();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            ArrayList arrayList = this.g;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                em1 em1Var = ((bm1) arrayList.get(i)).g;
                if (em1Var != null) {
                    em1Var.e();
                }
            }
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(hg0.m(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.J = i;
        if (i == 0) {
            this.L = new ta1(4);
            return;
        }
        if (i == 1) {
            this.L = new sy(0);
        } else {
            if (i == 2) {
                this.L = new sy(1);
                return;
            }
            throw new IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.H = z;
        int i = am1.l;
        am1 am1Var = this.i;
        am1Var.a();
        WeakHashMap weakHashMap = qs1.a;
        am1Var.postInvalidateOnAnimation();
    }

    public void setTabMode(int i) {
        if (i != this.F) {
            this.F = i;
            d();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.q == colorStateList) {
            return;
        }
        this.q = colorStateList;
        int i = 0;
        while (true) {
            am1 am1Var = this.i;
            if (i >= am1Var.getChildCount()) {
                return;
            }
            View childAt = am1Var.getChildAt(i);
            if (childAt instanceof em1) {
                Context context = getContext();
                int i2 = em1.r;
                ((em1) childAt).f(context);
            }
            i++;
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(hg0.m(getContext(), i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            ArrayList arrayList = this.g;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                em1 em1Var = ((bm1) arrayList.get(i)).g;
                if (em1Var != null) {
                    em1Var.e();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(d11 d11Var) {
        k(d11Var, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.K == z) {
            return;
        }
        this.K = z;
        int i = 0;
        while (true) {
            am1 am1Var = this.i;
            if (i >= am1Var.getChildCount()) {
                return;
            }
            View childAt = am1Var.getChildAt(i);
            if (childAt instanceof em1) {
                Context context = getContext();
                int i2 = em1.r;
                ((em1) childAt).f(context);
            }
            i++;
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        m(viewPager, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i) {
        b(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(wl1 wl1Var) {
        wl1 wl1Var2 = this.M;
        ArrayList arrayList = this.N;
        if (wl1Var2 != null) {
            arrayList.remove(wl1Var2);
        }
        this.M = wl1Var;
        if (wl1Var == null || arrayList.contains(wl1Var)) {
            return;
        }
        arrayList.add(wl1Var);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(hg0.o(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
