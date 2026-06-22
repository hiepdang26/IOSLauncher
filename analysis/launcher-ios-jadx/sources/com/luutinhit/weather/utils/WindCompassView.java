package com.luutinhit.weather.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import defpackage.x41;

/* JADX INFO: loaded from: classes.dex */
public class WindCompassView extends View {
    public Canvas g;
    public int h;
    public int i;
    public int j;
    public int k;
    public float l;
    public final Paint m;
    public final Paint n;
    public final Paint o;
    public final Paint p;
    public final Path q;
    public final Paint r;
    public final Paint s;
    public final Rect t;
    public final Rect u;
    public final Rect v;
    public final Paint w;
    public final Paint x;
    public double y;
    public int z;

    public WindCompassView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.y = 0.0d;
        this.z = 0;
        Paint paint = new Paint();
        this.m = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        paint.setColor(context.getResources().getColor(x41.white));
        Paint paint2 = new Paint();
        this.n = paint2;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        paint2.setColor(context.getResources().getColor(x41.lightGray));
        Paint paint3 = new Paint();
        this.o = paint3;
        paint3.setStyle(style);
        paint3.setAntiAlias(true);
        paint3.setColor(context.getResources().getColor(x41.gray));
        Paint paint4 = new Paint();
        this.p = paint4;
        paint4.setStyle(style);
        paint4.setAntiAlias(true);
        paint4.setColor(context.getResources().getColor(x41.red));
        this.q = new Path();
        Paint paint5 = new Paint();
        this.r = paint5;
        paint5.setStyle(style);
        paint5.setAntiAlias(true);
        paint5.setTextSize(40.0f);
        paint5.setColor(context.getResources().getColor(x41.red));
        Paint paint6 = new Paint();
        this.s = paint6;
        paint6.setStyle(style);
        paint6.setAntiAlias(true);
        paint6.setTextSize(40.0f);
        paint6.setColor(context.getResources().getColor(x41.white));
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        Paint paint7 = new Paint();
        this.w = paint7;
        paint7.setStyle(style);
        paint7.setAntiAlias(true);
        paint7.setColor(context.getResources().getColor(x41.white));
        Paint paint8 = new Paint();
        this.x = paint8;
        paint8.setStyle(style);
        paint8.setAntiAlias(true);
        paint8.setColor(context.getResources().getColor(x41.white));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        this.g = canvas;
        canvas.save();
        int i = this.k;
        int i2 = i / 8;
        this.g.rotate(this.z, this.i, i);
        Path path = this.q;
        path.moveTo(this.i, 0.0f);
        float f2 = 2.0f;
        float fSqrt = ((float) ((((double) i2) / Math.sqrt(3.0d)) * 2.0d)) / 2.0f;
        float f3 = i2;
        path.lineTo(this.i - fSqrt, f3);
        path.lineTo(this.i + fSqrt, f3);
        path.close();
        this.g.drawPath(path, this.p);
        this.g.rotate(-this.z, this.i, this.k);
        Paint paint = this.r;
        paint.setTextSize(this.k / 5.0f);
        Paint paint2 = this.s;
        paint2.setTextSize(this.k / 5.0f);
        Rect rect = this.t;
        paint.getTextBounds("N", 0, 1, rect);
        int iWidth = rect.width();
        int iHeight = rect.height();
        paint.getTextBounds("W", 0, 1, rect);
        rect.width();
        int iHeight2 = rect.height();
        float f4 = this.l / 2.0f;
        int i3 = 0;
        while (i3 < 180) {
            if (i3 == 0 || i3 == 45 || i3 == 90 || i3 == 135) {
                f = 2.0f;
                this.g.drawLine(getWidth() / 2.0f, 0.0f, getWidth() / 2.0f, this.l, this.m);
            } else if (i3 % 15 == 0) {
                f = 2.0f;
                this.g.drawLine(getWidth() / f2, 0.0f, getWidth() / f2, this.l, this.n);
            } else {
                f = 2.0f;
                this.g.drawLine(getWidth() / 2.0f, 0.0f, getWidth() / 2.0f, this.l, this.o);
            }
            if (i3 == 0) {
                this.g.drawText("N", this.i - (iWidth / f), (this.j - this.k) + f4 + iHeight + this.l, paint);
            } else if (i3 == 45) {
                this.g.rotate(-90.0f, this.i, this.k);
                this.g.drawText("E", (((this.i + this.k) - iWidth) - this.l) - f4, (iHeight / f) + this.j, paint2);
                this.g.rotate(90.0f, this.i, this.k);
            } else if (i3 == 90) {
                this.g.rotate(-180.0f, this.i, this.k);
                this.g.drawText("S", this.i - (iWidth / f), ((this.j + this.k) - f4) - this.l, paint2);
                this.g.rotate(180.0f, this.i, this.k);
            } else if (i3 == 135) {
                this.g.rotate(-270.0f, this.i, this.k);
                this.g.drawText("W", (this.i - this.k) + this.l + f4, (iHeight2 / f) + this.j, paint2);
                this.g.rotate(270.0f, this.i, this.k);
            }
            this.g.rotate(2.0f, this.i, this.k);
            i3++;
            f2 = 2.0f;
        }
        this.g.restore();
        String strValueOf = String.valueOf((int) this.y);
        Paint paint3 = this.w;
        paint3.setTextSize(this.k / 3.0f);
        int length = strValueOf.length();
        Rect rect2 = this.u;
        paint3.getTextBounds(strValueOf, 0, length, rect2);
        Paint paint4 = this.x;
        paint4.setTextSize(this.k / 5.0f);
        Rect rect3 = this.v;
        paint4.getTextBounds("km/h", 0, 4, rect3);
        int iWidth2 = rect2.width();
        int iHeight3 = rect2.height();
        int iWidth3 = rect3.width();
        int iHeight4 = rect3.height();
        Canvas canvas2 = this.g;
        float f5 = this.i - (iWidth2 / 2.0f);
        float f6 = (this.j + iHeight3) - iHeight4;
        float f7 = iHeight3 / 3.0f;
        canvas2.drawText(strValueOf, f5, f6 - f7, paint3);
        this.g.drawText("km/h", this.i - (iWidth3 / 2.0f), this.j + iHeight4 + f7, paint4);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.h = Math.min(size, size2);
        if (mode == 0) {
            this.h = size2;
        } else if (mode2 == 0) {
            this.h = size;
        }
        this.i = size / 2;
        int i3 = this.h;
        this.j = i3 / 2;
        int i4 = i3 / 2;
        this.k = i4;
        this.l = i4 / 9.0f;
    }
}
