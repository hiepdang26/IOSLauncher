package com.google.android.material.timepicker;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import defpackage.b71;
import defpackage.d51;
import defpackage.f71;
import defpackage.hg0;
import defpackage.l61;
import defpackage.mc1;
import defpackage.np1;
import defpackage.oj;
import defpackage.q41;
import defpackage.qs1;
import defpackage.s71;
import defpackage.u51;
import defpackage.w41;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends s71 implements oj {
    public final ClockHandView j;
    public final Rect k;
    public final RectF l;
    public final SparseArray m;
    public final c n;
    public final int[] o;
    public final float[] p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final String[] u;
    public float v;
    public final ColorStateList w;

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockFaceView(Context context, AttributeSet attributeSet) {
        int i = q41.materialClockStyle;
        super(context, attributeSet, i);
        this.k = new Rect();
        this.l = new RectF();
        SparseArray sparseArray = new SparseArray();
        this.m = sparseArray;
        this.p = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f71.ClockFaceView, i, b71.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListL = np1.l(context, typedArrayObtainStyledAttributes, f71.ClockFaceView_clockNumberTextColor);
        this.w = colorStateListL;
        LayoutInflater.from(context).inflate(l61.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(u51.material_clock_hand);
        this.j = clockHandView;
        this.q = resources.getDimensionPixelSize(d51.material_clock_hand_padding);
        int colorForState = colorStateListL.getColorForState(new int[]{R.attr.state_selected}, colorStateListL.getDefaultColor());
        this.o = new int[]{colorForState, colorForState, colorStateListL.getDefaultColor()};
        clockHandView.g.add(this);
        int defaultColor = hg0.m(context, w41.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListL2 = np1.l(context, typedArrayObtainStyledAttributes, f71.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListL2 != null ? colorStateListL2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.n = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.u = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        for (int i2 = 0; i2 < Math.max(this.u.length, size); i2++) {
            TextView textView = (TextView) sparseArray.get(i2);
            if (i2 >= this.u.length) {
                removeView(textView);
                sparseArray.remove(i2);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(l61.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i2, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.u[i2]);
                textView.setTag(u51.material_value_index, Integer.valueOf(i2));
                qs1.p(textView, this.n);
                textView.setTextColor(this.w);
            }
        }
        this.r = resources.getDimensionPixelSize(d51.material_time_picker_minimum_screen_height);
        this.s = resources.getDimensionPixelSize(d51.material_time_picker_minimum_screen_width);
        this.t = resources.getDimensionPixelSize(d51.material_clock_size);
    }

    public final void n() {
        RadialGradient radialGradient;
        RectF rectF = this.j.k;
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.m;
            if (i >= sparseArray.size()) {
                return;
            }
            TextView textView = (TextView) sparseArray.get(i);
            if (textView != null) {
                Rect rect = this.k;
                textView.getDrawingRect(rect);
                offsetDescendantRectToMyCoords(textView, rect);
                textView.setSelected(rectF.contains(rect.centerX(), rect.centerY()));
                RectF rectF2 = this.l;
                rectF2.set(rect);
                rectF2.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                if (RectF.intersects(rectF, rectF2)) {
                    radialGradient = new RadialGradient(rectF.centerX() - rectF2.left, rectF.centerY() - rectF2.top, 0.5f * rectF.width(), this.o, this.p, Shader.TileMode.CLAMP);
                } else {
                    radialGradient = null;
                }
                textView.getPaint().setShader(radialGradient);
                textView.invalidate();
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) mc1.v(1, this.u.length, 1).h);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.t / Math.max(Math.max(this.r / displayMetrics.heightPixels, this.s / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
