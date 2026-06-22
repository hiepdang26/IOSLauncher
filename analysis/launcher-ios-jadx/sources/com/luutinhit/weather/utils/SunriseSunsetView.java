package com.luutinhit.weather.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public class SunriseSunsetView extends View {
    public final Paint g;
    public final Paint h;
    public final Paint i;
    public Paint j;
    public float k;
    public float l;
    public float m;

    public SunriseSunsetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Paint paint = new Paint(1);
        this.g = paint;
        Paint paint2 = new Paint(1);
        this.h = paint2;
        Paint paint3 = new Paint(1);
        this.i = paint3;
        Paint.Style style = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style);
        paint2.setStyle(style);
        paint2.setColor(-1);
        paint2.setStrokeWidth(2.0f);
        paint3.setColor(-2130706433);
        paint3.setStrokeWidth(2.0f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f;
        Paint paint = this.i;
        super.onDraw(canvas);
        float f2 = this.l;
        canvas.drawLine(0.0f, f2 / 2.0f, this.k, f2 / 2.0f, this.h);
        int i = 0;
        while (true) {
            float f3 = i;
            f = this.k;
            if (f3 >= f) {
                break;
            }
            float f4 = this.l;
            float fSin = ((f4 / 3.6f) * ((float) Math.sin(((f3 - (f / 1.32f)) / f) * 6.2f))) + (f4 / 2.0f);
            int i2 = i + 3;
            float f5 = i2;
            float f6 = this.l;
            float f7 = this.k;
            float fSin2 = ((f6 / 3.6f) * ((float) Math.sin(((f5 - (f7 / 1.32f)) / f7) * 6.2f))) + (f6 / 2.0f);
            float f8 = this.l;
            float f9 = f8 / 2.0f;
            Paint paint2 = this.g;
            if (fSin >= f9 || fSin2 >= f8 / 2.0f) {
                paint2.setColor(RtlSpacingHelper.UNDEFINED);
            } else {
                paint2.setColor(-2130706433);
            }
            canvas.drawLine(f3, fSin, f5, fSin2, paint2);
            i = i2;
        }
        float f10 = ((this.m * f) / 2.0f) + (f / 4.0f);
        float f11 = this.l;
        float fSin3 = ((f11 / 3.6f) * ((float) Math.sin(((f10 - (f / 1.32f)) / f) * 6.2f))) + (f11 / 2.0f);
        try {
            float f12 = this.m;
            if (f12 < 0.0f || f12 > 1.0f) {
                canvas.drawCircle(f10, fSin3, this.l / 11.0f, paint);
                return;
            }
            if (this.j == null) {
                Paint paint3 = new Paint(1);
                this.j = paint3;
                paint3.setColor(-1);
                this.j.setShadowLayer(this.l / 11.0f, 0.0f, 0.0f, -1);
            }
            canvas.drawCircle(f10, fSin3, this.l / 11.0f, this.j);
        } catch (Throwable unused) {
            canvas.drawCircle(f10, fSin3, this.l / 11.0f, paint);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        this.k = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.l = measuredHeight;
        this.g.setStrokeWidth(measuredHeight / 18.0f);
        super.onMeasure(i, i2);
    }

    public void setSunriseSunsetTime(float f) {
        this.m = f;
        this.i.setStyle((f < 0.0f || f > 1.0f) ? Paint.Style.STROKE : Paint.Style.FILL_AND_STROKE);
        invalidate();
    }
}
