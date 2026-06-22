package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import defpackage.b71;
import defpackage.d51;
import defpackage.f71;
import defpackage.oj;
import defpackage.q41;
import defpackage.qs1;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {
    public final ArrayList g;
    public final int h;
    public final float i;
    public final Paint j;
    public final RectF k;
    public final int l;
    public float m;
    public boolean n;
    public double o;
    public int p;

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockHandView(Context context, AttributeSet attributeSet) {
        int i = q41.materialClockStyle;
        super(context, attributeSet, i);
        this.g = new ArrayList();
        Paint paint = new Paint();
        this.j = paint;
        this.k = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f71.ClockHandView, i, b71.Widget_MaterialComponents_TimePicker_Clock);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.ClockHandView_materialCircleRadius, 0);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.ClockHandView_selectorSize, 0);
        this.l = getResources().getDimensionPixelSize(d51.material_clock_hand_stroke_width);
        this.i = r0.getDimensionPixelSize(d51.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(f71.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        a(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = qs1.a;
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(float f) {
        float f2 = f % 360.0f;
        this.m = f2;
        this.o = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        float fCos = (this.p * ((float) Math.cos(this.o))) + (getWidth() / 2);
        float fSin = (this.p * ((float) Math.sin(this.o))) + height;
        float f3 = this.h;
        this.k.set(fCos - f3, fSin - f3, fCos + f3, fSin + f3);
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ClockFaceView clockFaceView = (ClockFaceView) ((oj) obj);
            if (Math.abs(clockFaceView.v - f2) > 0.001f) {
                clockFaceView.v = f2;
                clockFaceView.n();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float fCos = (this.p * ((float) Math.cos(this.o))) + width;
        float f = height;
        float fSin = (this.p * ((float) Math.sin(this.o))) + f;
        Paint paint = this.j;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.h, paint);
        double dSin = Math.sin(this.o);
        double dCos = Math.cos(this.o);
        paint.setStrokeWidth(this.l);
        canvas.drawLine(width, f, r1 + ((int) (dCos * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(width, f, this.i, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(this.m);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z3 = false;
        if (actionMasked != 0) {
            z = (actionMasked == 1 || actionMasked == 2) ? this.n : false;
            z2 = false;
        } else {
            this.n = false;
            z = false;
            z2 = true;
        }
        boolean z4 = this.n;
        int degrees = (int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x - (getWidth() / 2)));
        int i = degrees + 90;
        if (i < 0) {
            i = degrees + 450;
        }
        float f = i;
        boolean z5 = this.m != f;
        if (z2 && z5) {
            z3 = true;
        } else if (z5 || z) {
            a(f);
            z3 = true;
        }
        this.n = z4 | z3;
        return true;
    }
}
