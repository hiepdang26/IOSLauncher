package com.luutinhit.launcher6.editscreen;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import defpackage.e51;
import defpackage.g71;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
public class FrameLayoutRound extends FrameLayout {
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public final Paint l;
    public final Paint m;
    public final RectF n;
    public float o;
    public float p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public boolean u;
    public final boolean v;

    public FrameLayoutRound(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = 400.0f;
        this.h = 400.0f;
        this.i = 80.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.n = new RectF();
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = true;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = true;
        int color = -2565928;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.FrameLayoutSmoothCorners);
            this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.ViewSmoothCorners_roundRadius, getResources().getDimensionPixelSize(e51.sliding_background_round_corner));
            this.u = typedArrayObtainStyledAttributes.getBoolean(g71.FrameLayoutSmoothCorners_isSquare, false);
            this.v = typedArrayObtainStyledAttributes.getBoolean(g71.FrameLayoutSmoothCorners_isSlidingBackground, true);
            this.q = typedArrayObtainStyledAttributes.getBoolean(g71.FrameLayoutSmoothCorners_roundTopLeft, true);
            this.r = typedArrayObtainStyledAttributes.getBoolean(g71.FrameLayoutSmoothCorners_roundTopRight, true);
            this.s = typedArrayObtainStyledAttributes.getBoolean(g71.FrameLayoutSmoothCorners_roundBottomLeft, false);
            this.t = typedArrayObtainStyledAttributes.getBoolean(g71.FrameLayoutSmoothCorners_roundBottomRight, false);
            color = typedArrayObtainStyledAttributes.getColor(g71.FrameLayoutSmoothCorners_backgroundColor, -2565928);
        }
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.l = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        Paint paint2 = new Paint(1);
        this.m = paint2;
        paint2.setColor(1062228048);
    }

    public final Path a(float f, float f2, float f3, boolean z, boolean z2, boolean z3, boolean z4) {
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

    public final void b(float f, float f2, float f3, float f4, boolean z, boolean z2, boolean z3, boolean z4, Canvas canvas) {
        Canvas canvas2;
        float f5;
        float f6;
        float f7 = f - 0.0f;
        float f8 = f2 - 0.0f;
        int i = (int) 0.0f;
        RectF rectF = new RectF(new Rect(i, i, (int) f, (int) f2));
        Paint paint = this.l;
        canvas.drawRoundRect(rectF, f3, f4, paint);
        if (z) {
            canvas2 = canvas;
        } else {
            float f9 = f7 / 2.0f;
            float f10 = f8 / 2.0f;
            canvas.drawRect(0.0f, 0.0f, f9, f10, paint);
            canvas2 = canvas;
            Path path = new Path();
            path.moveTo(0.0f, f10);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(f9, 0.0f);
            canvas2.drawPath(path, paint);
        }
        if (z2) {
            f5 = f7;
        } else {
            float f11 = f7 / 2.0f;
            float f12 = f8 / 2.0f;
            canvas2.drawRect(f11, 0.0f, f7, f12, paint);
            f5 = f7;
            Path path2 = new Path();
            path2.moveTo(f11, 0.0f);
            path2.lineTo(f5, 0.0f);
            path2.lineTo(f5, f12);
            canvas2.drawPath(path2, paint);
        }
        if (z3) {
            f6 = f8;
        } else {
            float f13 = f8 / 2.0f;
            float f14 = f5 / 2.0f;
            f6 = f8;
            canvas2.drawRect(0.0f, f13, f14, f6, paint);
            Path path3 = new Path();
            path3.moveTo(0.0f, f13);
            path3.lineTo(0.0f, f6);
            path3.lineTo(f14, f6);
            canvas2.drawPath(path3, paint);
        }
        if (z4) {
            return;
        }
        float f15 = f5 / 2.0f;
        float f16 = f6 / 2.0f;
        float f17 = f5;
        canvas2.drawRect(f15, f16, f17, f6, paint);
        Path path4 = new Path();
        path4.moveTo(f15, f6);
        path4.lineTo(f17, f6);
        path4.lineTo(f17, f16);
        canvas2.drawPath(path4, paint);
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

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        boolean z = this.u;
        Paint paint = this.l;
        if (z) {
            float f = this.i;
            float f2 = this.g;
            float f3 = f2 / 2.0f;
            if (f == f3) {
                canvas.translate(this.j - f3, this.k - (this.h / 2.0f));
                float f4 = this.g;
                float f5 = this.h;
                float f6 = this.i;
                b(f4, f5, f6, f6, this.q, this.r, this.s, this.t, canvas);
            } else {
                canvas.drawPath(a(f2, f2, f, this.q, this.r, this.s, this.t), paint);
            }
        } else {
            if (this.i == Math.min(this.g, this.h) / 2.0f) {
                canvas.translate(this.j - (this.g / 2.0f), this.k - (this.h / 2.0f));
                float f7 = this.g;
                float f8 = this.h;
                float f9 = this.i;
                b(f7, f8, f9, f9, this.q, this.r, this.s, this.t, canvas);
            } else {
                canvas.drawPath(a(this.g, this.h, this.i, this.q, this.r, this.s, this.t), paint);
            }
            if (this.v) {
                canvas.translate((this.g / 2.0f) - (this.o / 2.0f), this.p * 2.0f);
                RectF rectF = this.n;
                float f10 = this.p;
                canvas.drawRoundRect(rectF, f10, f10, this.m);
            }
        }
        canvas.restore();
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setRectWidth(getWidth());
        setRectHeight(getHeight());
        setIsSquare(this.g == this.h);
        float f = this.g / 10.0f;
        this.o = f;
        float f2 = f / 8.0f;
        this.p = f2;
        this.n.set(0.0f, 0.0f, f, f2);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.j = (i * 1.0f) / 2.0f;
        this.k = (i2 * 1.0f) / 2.0f;
    }

    public void setDarkModeBackgroundColor(int i) {
        this.l.setColor(i);
        invalidate();
    }

    public void setIsSquare(boolean z) {
        this.u = z;
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
