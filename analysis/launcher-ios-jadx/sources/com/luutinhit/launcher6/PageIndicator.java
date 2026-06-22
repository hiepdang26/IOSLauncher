package com.luutinhit.launcher6;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.ActivityChooserView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import defpackage.ar1;
import defpackage.e51;
import defpackage.fd;
import defpackage.fl0;
import defpackage.g71;
import defpackage.m61;
import defpackage.v01;
import defpackage.v51;
import defpackage.vc;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class PageIndicator extends LinearLayout {
    public final LayoutInflater g;
    public final int[] h;
    public final int i;
    public final boolean j;
    public int k;
    public int l;
    public final ArrayList m;
    public int n;
    public final vc o;
    public final Path p;
    public final RectF q;
    public final Rect r;
    public final int[] s;
    public int t;
    public int u;
    public final float v;
    public TextViewCustomFont w;
    public final fl0 x;

    public PageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.h = new int[]{0, 0};
        this.m = new ArrayList();
        this.o = null;
        this.p = new Path();
        this.q = new RectF();
        this.r = new Rect();
        this.s = new int[2];
        this.t = -1;
        this.u = -1;
        this.x = new fl0(this, 5);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.PageIndicator, 0, 0);
        this.i = typedArrayObtainStyledAttributes.getInteger(g71.PageIndicator_windowSize, 15);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(g71.PageIndicator_hasBackground, true);
        this.j = z;
        typedArrayObtainStyledAttributes.recycle();
        this.g = LayoutInflater.from(context);
        if (z) {
            float dimensionPixelSize = getResources().getDimensionPixelSize(e51.dynamic_grid_page_indicator_round_corner);
            this.v = dimensionPixelSize;
            fd blurWallpaperProvider = ((t) context).getBlurWallpaperProvider();
            blurWallpaperProvider.getClass();
            vc vcVar = new vc(blurWallpaperProvider, dimensionPixelSize, 4);
            this.o = vcVar;
            setBackground(vcVar);
        }
        getLayoutTransition().setDuration(268L);
        setGravity(17);
    }

    public void a(int i, v01 v01Var) {
        ArrayList arrayList = this.m;
        int iMax = Math.max(0, Math.min(i, arrayList.size()));
        PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) this.g.inflate(m61.page_indicator_marker, (ViewGroup) this, false);
        pageIndicatorMarker.setMarkerDrawables(v01Var.a);
        arrayList.add(iMax, pageIndicatorMarker);
        c(this.n, true);
    }

    public void b() {
        removeCallbacks(this.x);
        TextViewCustomFont textViewCustomFont = this.w;
        if (textViewCustomFont != null) {
            textViewCustomFont.setVisibility(8);
        }
        ArrayList arrayList = this.m;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) obj;
            if (pageIndicatorMarker != null) {
                pageIndicatorMarker.setVisibility(0);
            }
        }
    }

    public final void c(int i, boolean z) {
        View view;
        int iIndexOf;
        if (i < 0) {
            new Throwable().printStackTrace();
        }
        ArrayList arrayList = this.m;
        int size = arrayList.size();
        int i2 = this.i;
        int iMin = Math.min(size, i2);
        int iMin2 = Math.min(arrayList.size(), Math.max(0, i - (iMin / 2)) + i2);
        int iMin3 = iMin2 - Math.min(arrayList.size(), iMin);
        arrayList.size();
        int[] iArr = this.h;
        boolean z2 = (iArr[0] == iMin3 && iArr[1] == iMin2) ? false : true;
        if (!z) {
            LayoutTransition layoutTransition = getLayoutTransition();
            layoutTransition.disableTransitionType(2);
            layoutTransition.disableTransitionType(3);
            layoutTransition.disableTransitionType(0);
            layoutTransition.disableTransitionType(1);
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if ((childAt instanceof PageIndicatorMarker) && ((iIndexOf = arrayList.indexOf((view = (PageIndicatorMarker) childAt))) < iMin3 || iIndexOf >= iMin2)) {
                removeView(view);
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) arrayList.get(i3);
            if (iMin3 > i3 || i3 >= iMin2) {
                pageIndicatorMarker.b(true);
            } else {
                if (indexOfChild(pageIndicatorMarker) < 0) {
                    addView(pageIndicatorMarker, i3 - iMin3);
                }
                if (i3 == i) {
                    pageIndicatorMarker.a(z2);
                } else {
                    pageIndicatorMarker.b(z2);
                }
            }
        }
        if (!z) {
            LayoutTransition layoutTransition2 = getLayoutTransition();
            layoutTransition2.enableTransitionType(2);
            layoutTransition2.enableTransitionType(3);
            layoutTransition2.enableTransitionType(0);
            layoutTransition2.enableTransitionType(1);
        }
        iArr[0] = iMin3;
        iArr[1] = iMin2;
    }

    public void d() {
        while (!this.m.isEmpty()) {
            e(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!ar1.p) {
            Path path = this.p;
            if (!path.isEmpty()) {
                canvas.clipPath(path);
            }
        }
        super.draw(canvas);
    }

    public void e(int i) {
        ArrayList arrayList = this.m;
        if (arrayList.isEmpty()) {
            return;
        }
        arrayList.remove(Math.max(0, Math.min(arrayList.size() - 1, i)));
        c(this.n, true);
    }

    public void f() {
        fl0 fl0Var = this.x;
        removeCallbacks(fl0Var);
        postOnAnimationDelayed(fl0Var, 1369L);
    }

    public int getBottomPosition() {
        return this.l;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        vc vcVar;
        Rect rect = this.r;
        super.onLayout(z, i, i2, i3, i4);
        this.l = i4;
        if (this.j && (vcVar = this.o) != null && z) {
            try {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, this.k);
                this.k = iMax;
                if (ar1.p) {
                    rect.set(0, 0, iMax, height);
                    setClipBounds(rect);
                }
                int[] iArr = this.s;
                if (iArr != null && iArr.length != 0) {
                    getLocationOnScreen(iArr);
                    int i5 = iArr[0];
                    if (i5 >= 0 && iArr[1] >= 0) {
                        if (this.t != i5) {
                            this.t = i5;
                            vcVar.c(i5);
                        }
                        int i6 = this.u;
                        int i7 = iArr[1];
                        if (i6 != i7) {
                            this.u = i7;
                            vcVar.d(i7);
                        }
                    }
                }
                RectF rectF = this.q;
                rectF.set(0.0f, 0.0f, width, height);
                Path path = this.p;
                float f = this.v;
                path.addRoundRect(rectF, f, f, Path.Direction.CW);
                vcVar.i = true;
                vcVar.j.set(rectF);
                vcVar.d(i2);
                setBackground(vcVar);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof TextViewCustomFont) {
            TextViewCustomFont textViewCustomFont = (TextViewCustomFont) findViewById(v51.search_spotlight);
            this.w = textViewCustomFont;
            Objects.toString(textViewCustomFont);
        }
    }

    public void setActiveMarker(int i) {
        if (i != this.n) {
            this.n = i;
            c(i, false);
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        vc vcVar = this.o;
        if (vcVar != null) {
            vcVar.c(f + this.t);
        }
    }
}
