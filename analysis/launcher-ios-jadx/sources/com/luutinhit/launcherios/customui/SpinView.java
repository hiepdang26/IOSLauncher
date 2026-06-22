package com.luutinhit.launcherios.customui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import defpackage.fl0;
import defpackage.g71;

/* JADX INFO: loaded from: classes.dex */
public class SpinView extends View {
    public static final /* synthetic */ int z = 0;
    public int g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public float r;
    public float s;
    public final Paint t;
    public final Paint u;
    public int v;
    public final HandlerThread w;
    public final Handler x;
    public final RectF y;

    public SpinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g71.SpinView, 0, 0);
        this.g = typedArrayObtainStyledAttributes.getInt(g71.SpinView_lines, 12);
        this.h = typedArrayObtainStyledAttributes.getDimension(g71.SpinView_length, TypedValue.applyDimension(1, 12.0f, displayMetrics));
        this.i = typedArrayObtainStyledAttributes.getDimension(g71.SpinView_width, TypedValue.applyDimension(1, 4.0f, displayMetrics));
        this.j = typedArrayObtainStyledAttributes.getDimension(g71.SpinView_radius, TypedValue.applyDimension(1, 10.0f, displayMetrics));
        this.k = typedArrayObtainStyledAttributes.getFloat(g71.SpinView_scale, 1.0f);
        this.l = typedArrayObtainStyledAttributes.getFloat(g71.SpinView_corners, 1.0f);
        this.m = typedArrayObtainStyledAttributes.getColor(g71.SpinView_ccolor, -1);
        this.n = typedArrayObtainStyledAttributes.getColor(g71.SpinView_fadeColor, 0);
        this.o = (int) (typedArrayObtainStyledAttributes.getFloat(g71.SpinView_opacity, 0.25f) * 255.0f);
        this.p = typedArrayObtainStyledAttributes.getInt(g71.SpinView_rotate, 0);
        this.q = typedArrayObtainStyledAttributes.getInt(g71.SpinView_direction, 1);
        this.r = typedArrayObtainStyledAttributes.getFloat(g71.SpinView_speed, 1.0f);
        this.s = typedArrayObtainStyledAttributes.getInt(g71.SpinView_trail, 60) / 100.0f;
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.t = paint;
        paint.setColor(this.m);
        Paint paint2 = new Paint(1);
        this.u = paint2;
        paint2.setColor(this.n);
        HandlerThread handlerThread = new HandlerThread("SpinView");
        this.w = handlerThread;
        handlerThread.start();
        this.x = new Handler(this.w.getLooper());
        float f = this.j;
        float f2 = this.k;
        float f3 = this.i;
        this.y = new RectF(f * f2, ((-f3) / 2.0f) * f2, (f + this.h) * f2, (f3 / 2.0f) * f2);
    }

    public int getColor() {
        return this.m;
    }

    public float getCorners() {
        return this.l;
    }

    public int getDirection() {
        return this.q;
    }

    public int getFadeColor() {
        return this.n;
    }

    public float getLength() {
        return this.h;
    }

    public float getLineWidth() {
        return this.i;
    }

    public int getLines() {
        return this.g;
    }

    public int getOpacity() {
        return this.o;
    }

    public float getRadius() {
        return this.j;
    }

    public int getRotate() {
        return this.p;
    }

    public float getScale() {
        return this.k;
    }

    public float getSpeed() {
        return this.r;
    }

    public float getTrail() {
        return this.s;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.x.post(new fl0(this, 13));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int i2 = 0;
        while (i2 < this.g) {
            canvas.save();
            canvas.translate(getWidth() / 2.0f, getHeight() / 2.0f);
            canvas.rotate((float) Math.floor(((360.0f / this.g) * i2) + this.p));
            if (Color.alpha(this.n) > 0) {
                RectF rectF = this.y;
                float f = this.l;
                float f2 = this.i;
                float f3 = this.k;
                canvas.drawRoundRect(rectF, f * f2 * f3, f * f2 * f3, this.u);
            }
            Paint paint = this.t;
            i2++;
            float f4 = this.q;
            float f5 = (((this.v / 50) * this.r) % 1.0f) - ((i2 / this.g) * f4);
            if (f5 < 0.0f || f5 > 1.0f) {
                f5 += f4;
            }
            float f6 = 1.0f - (f5 / this.s);
            if (f6 < 0.0f) {
                i = this.o;
            } else {
                i = this.o + ((int) ((255 - r2) * f6));
            }
            paint.setAlpha(i);
            RectF rectF2 = this.y;
            float f7 = this.l;
            float f8 = this.i;
            float f9 = this.k;
            canvas.drawRoundRect(rectF2, f7 * f8 * f9, f7 * f8 * f9, this.t);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int) ((this.j + this.h) * 2.0f * this.k), 1073741824), View.MeasureSpec.makeMeasureSpec((int) ((this.j + this.h) * 2.0f * this.k), 1073741824));
    }

    public void setColor(int i) {
        this.m = i;
    }

    public void setCorners(float f) {
        this.l = f;
    }

    public void setDirection(int i) {
        this.q = i;
    }

    public void setFadeColor(int i) {
        this.n = i;
    }

    public void setLength(float f) {
        this.h = f;
    }

    public void setLineWidth(float f) {
        this.i = f;
    }

    public void setLines(int i) {
        this.g = i;
    }

    public void setOpacity(int i) {
        this.o = i;
    }

    public void setRadius(float f) {
        this.j = f;
    }

    public void setRotate(int i) {
        this.p = i;
    }

    public void setScale(float f) {
        this.k = f;
    }

    public void setSpeed(float f) {
        this.r = f;
    }

    public void setTrail(float f) {
        this.s = f;
    }
}
