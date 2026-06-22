package com.luutinhit.launcher6.editscreen;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.e51;
import defpackage.g71;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayoutRound extends ConstraintLayout {
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public final Paint l;
    public final RectF m;
    public float n;
    public float o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public boolean t;
    public final boolean u;
    public final Path v;

    public ConstraintLayoutRound(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = 400.0f;
        this.h = 400.0f;
        this.i = 80.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.m = new RectF();
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = true;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = true;
        this.u = true;
        int color = -2565928;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.ConstraintLayoutSmoothCorners);
            this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.ViewSmoothCorners_roundRadius, getResources().getDimensionPixelSize(e51.widget_round_corner));
            this.t = typedArrayObtainStyledAttributes.getBoolean(g71.ConstraintLayoutSmoothCorners_isSquare, false);
            this.u = typedArrayObtainStyledAttributes.getBoolean(g71.ConstraintLayoutSmoothCorners_isSlidingBackground, false);
            this.p = typedArrayObtainStyledAttributes.getBoolean(g71.ConstraintLayoutSmoothCorners_roundTopLeft, true);
            this.q = typedArrayObtainStyledAttributes.getBoolean(g71.ConstraintLayoutSmoothCorners_roundTopRight, true);
            this.r = typedArrayObtainStyledAttributes.getBoolean(g71.ConstraintLayoutSmoothCorners_roundBottomLeft, true);
            this.s = typedArrayObtainStyledAttributes.getBoolean(g71.ConstraintLayoutSmoothCorners_roundBottomRight, true);
            color = typedArrayObtainStyledAttributes.getColor(g71.ConstraintLayoutSmoothCorners_backgroundColor, -2565928);
        }
        setWillNotDraw(false);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        Paint paint2 = new Paint(1);
        this.l = paint2;
        paint2.setColor(1062228048);
        this.v = new Path();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        canvas.clipPath(this.v);
        super.draw(canvas);
    }

    public float getRectHeight() {
        return this.h;
    }

    public float getRectWidth() {
        return this.g;
    }

    public float getRoundRadius() {
        return this.i;
    }

    public final Path l(float f, float f2, float f3, boolean z, boolean z2, boolean z3, boolean z4) {
        float f4;
        float f5;
        float f6;
        Path path = new Path();
        float f7 = f3 < 0.0f ? 0.0f : f3;
        float f8 = f - 0.0f;
        float f9 = f2 - 0.0f;
        float f10 = f8 / 2.0f;
        float f11 = this.j - f10;
        float f12 = f9 / 2.0f;
        float f13 = this.k - f12;
        float fMin = ((double) (f7 / Math.min(f10, f12))) > 0.5d ? 1.0f - (Math.min(1.0f, ((f7 / Math.min(f10, f12)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float fMin2 = ((double) (f7 / Math.min(f10, f12))) > 0.6d ? 1.0f + (Math.min(1.0f, ((f7 / Math.min(f10, f12)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        path.moveTo(f11 + f10, f13);
        if (z2) {
            float f14 = f7 / 100.0f;
            float f15 = f14 * 128.19f * fMin;
            path.lineTo(uo.b(f8, f15, f10, f11), f13);
            float f16 = f11 + f8;
            float f17 = f14 * 83.62f * fMin2;
            float f18 = f14 * 67.45f;
            float f19 = f14 * 4.64f;
            float f20 = f14 * 51.16f;
            float f21 = f14 * 13.36f;
            path.cubicTo(f16 - f17, f13, f16 - f18, f13 + f19, f16 - f20, f13 + f21);
            float f22 = f14 * 34.86f;
            float f23 = f14 * 22.07f;
            f4 = f7;
            f5 = f13;
            path.cubicTo(f16 - f22, f13 + f23, f16 - f23, f22 + f13, f16 - f21, f13 + f20);
            path.cubicTo(f16 - f19, f5 + f18, f16, f5 + f17, f16, Math.min(f12, f15) + f5);
        } else {
            path.lineTo(f11 + f8, f13);
            f4 = f7;
            f5 = f13;
        }
        if (z4) {
            float f24 = f11 + f8;
            float f25 = f4 / 100.0f;
            float f26 = f25 * 128.19f * fMin;
            path.lineTo(f24, uo.b(f9, f26, f12, f5));
            float f27 = f5 + f9;
            float f28 = f25 * 83.62f * fMin2;
            float f29 = f25 * 4.64f;
            float f30 = f25 * 67.45f;
            float f31 = f25 * 13.36f;
            float f32 = f25 * 51.16f;
            path.cubicTo(f24, f27 - f28, f24 - f29, f27 - f30, f24 - f31, f27 - f32);
            float f33 = f25 * 22.07f;
            float f34 = f25 * 34.86f;
            path.cubicTo(f24 - f33, f27 - f34, f24 - f34, f27 - f33, f24 - f32, f27 - f31);
            path.cubicTo(f24 - f30, f27 - f29, f24 - f28, f27, uo.b(f8, f26, f10, f11), f27);
        } else {
            path.lineTo(f8 + f11, f5 + f9);
        }
        if (z3) {
            float f35 = f4 / 100.0f;
            float f36 = f35 * 128.19f * fMin;
            float f37 = f5 + f9;
            path.lineTo(Math.min(f10, f36) + f11, f37);
            float f38 = f35 * 83.62f * fMin2;
            float f39 = f35 * 67.45f;
            float f40 = f35 * 4.64f;
            float f41 = f35 * 51.16f;
            float f42 = f35 * 13.36f;
            path.cubicTo(f11 + f38, f37, f11 + f39, f37 - f40, f11 + f41, f37 - f42);
            float f43 = f35 * 34.86f;
            float f44 = f35 * 22.07f;
            path.cubicTo(f11 + f43, f37 - f44, f44 + f11, f37 - f43, f11 + f42, f37 - f41);
            f6 = f11;
            path.cubicTo(f11 + f40, f37 - f39, f6, f37 - f38, f11, uo.b(f9, f36, f12, f5));
        } else {
            path.lineTo(f11, f5 + f9);
            f6 = f11;
        }
        if (z) {
            float f45 = f4 / 100.0f;
            float f46 = 128.19f * f45 * fMin;
            path.lineTo(f6, Math.min(f12, f46) + f5);
            float f47 = 83.62f * f45 * fMin2;
            float f48 = 4.64f * f45;
            float f49 = 67.45f * f45;
            float f50 = 13.36f * f45;
            float f51 = 51.16f * f45;
            path.cubicTo(f6, f5 + f47, f6 + f48, f5 + f49, f6 + f50, f5 + f51);
            float f52 = 22.07f * f45;
            float f53 = f45 * 34.86f;
            path.cubicTo(f6 + f52, f5 + f53, f53 + f6, f5 + f52, f6 + f51, f5 + f50);
            path.cubicTo(f6 + f49, f5 + f48, f6 + f47, f5, Math.min(f10, f46) + f6, f5);
        } else {
            path.lineTo(f6, f5);
        }
        path.close();
        return path;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.u) {
            canvas.save();
            canvas.translate(this.j - (this.g / 2.0f), this.k - (this.h / 2.0f));
            canvas.translate((this.g / 2.0f) - (this.n / 2.0f), this.o * 2.0f);
            RectF rectF = this.m;
            float f = this.o;
            canvas.drawRoundRect(rectF, f, f, this.l);
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setRectWidth(getWidth());
        setRectHeight(getHeight());
        setIsSquare(this.g == this.h);
        float f = this.g / 10.0f;
        this.n = f;
        float f2 = f / 8.0f;
        this.o = f2;
        this.m.set(0.0f, 0.0f, f, f2);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        this.j = (f * 1.0f) / 2.0f;
        float f2 = i2;
        this.k = (1.0f * f2) / 2.0f;
        this.g = f;
        this.h = f2;
        Path path = this.v;
        path.reset();
        if (!this.t) {
            if (this.i != Math.min(this.g, this.h) / 2.0f) {
                path.addPath(l(this.g, this.h, this.i, this.p, this.q, this.r, this.s));
                return;
            }
            RectF rectF = new RectF(0.0f, 0.0f, this.g, this.h);
            float f3 = this.i;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
            return;
        }
        float f4 = this.i;
        float f5 = this.g;
        if (f4 != f5 / 2.0f) {
            path.addPath(l(f5, f5, f4, this.p, this.q, this.r, this.s));
            return;
        }
        RectF rectF2 = new RectF(0.0f, 0.0f, this.g, this.h);
        float f6 = this.i;
        path.addRoundRect(rectF2, f6, f6, Path.Direction.CW);
    }

    public void setDarkModeBackgroundColor(int i) {
        setBackgroundColor(i);
    }

    public void setIsSquare(boolean z) {
        this.t = z;
    }

    public void setRectHeight(float f) {
        this.h = f;
    }

    public void setRectWidth(float f) {
        this.g = f;
    }

    public void setRoundRadius(float f) {
        this.i = f;
        invalidate();
    }
}
