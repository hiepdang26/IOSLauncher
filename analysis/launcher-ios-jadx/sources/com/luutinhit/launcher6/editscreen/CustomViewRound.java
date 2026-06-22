package com.luutinhit.launcher6.editscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.luutinhit.launcher6.t;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
public class CustomViewRound extends LinearLayout {
    public float g;
    public float h;
    public float i;
    public final Paint j;
    public final Path k;
    public final Paint l;
    public boolean m;

    public CustomViewRound(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = 80.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.k = new Path();
        this.m = true;
        setWillNotDraw(false);
        setLayerType(2, null);
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-2565928);
        if ((context instanceof t) && ((t) context).isUseLiquidGlass) {
            Paint paint2 = new Paint(1);
            this.l = paint2;
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(2.0f);
        }
    }

    public float getRoundRadius() {
        return this.g;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.m) {
            canvas.save();
            canvas.translate(0.0f, 0.0f);
            Path path = this.k;
            Paint paint = this.l;
            if (paint == null) {
                paint = this.j;
            }
            canvas.drawPath(path, paint);
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        float f2 = f / 2.0f;
        this.h = f2;
        float f3 = i2;
        float f4 = f3 / 2.0f;
        this.i = f4;
        this.g = Math.min(f2, f4) - 2.0f;
        Path path = this.k;
        path.reset();
        float f5 = f - 2.0f;
        float f6 = f3 - 2.0f;
        float f7 = this.g;
        Path path2 = new Path();
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        float f8 = f5 - 2.0f;
        float f9 = f6 - 2.0f;
        float f10 = f8 / 2.0f;
        float f11 = this.h - f10;
        float f12 = f9 / 2.0f;
        float f13 = this.i - f12;
        float fMin = ((double) (f7 / Math.min(f10, f12))) > 0.5d ? 1.0f - (Math.min(1.0f, ((f7 / Math.min(f10, f12)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float fMin2 = ((double) (f7 / Math.min(f10, f12))) > 0.6d ? 1.0f + (Math.min(1.0f, ((f7 / Math.min(f10, f12)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        path2.moveTo(f11 + f10, f13);
        float f14 = f7 / 100.0f;
        float f15 = f14 * 128.19f * fMin;
        path2.lineTo(uo.b(f8, f15, f10, f11), f13);
        float f16 = f11 + f8;
        float f17 = f14 * 83.62f * fMin2;
        float f18 = f14 * 67.45f;
        float f19 = f14 * 4.64f;
        float f20 = f14 * 51.16f;
        float f21 = f14 * 13.36f;
        float f22 = f7;
        path2.cubicTo(f16 - f17, f13, f16 - f18, f13 + f19, f16 - f20, f13 + f21);
        float f23 = f14 * 34.86f;
        float f24 = f14 * 22.07f;
        float f25 = fMin2;
        path2.cubicTo(f16 - f23, f13 + f24, f16 - f24, f23 + f13, f16 - f21, f13 + f20);
        path2.cubicTo(f16 - f19, f13 + f18, f16, f13 + f17, f16, Math.min(f12, f15) + f13);
        float f26 = f11 + f8;
        float f27 = f22 / 100.0f;
        float f28 = f27 * 128.19f * fMin;
        path2.lineTo(f26, uo.b(f9, f28, f12, f13));
        float f29 = f13 + f9;
        float f30 = f27 * 83.62f * f25;
        float f31 = f27 * 4.64f;
        float f32 = f27 * 67.45f;
        float f33 = f27 * 13.36f;
        float f34 = f27 * 51.16f;
        path2.cubicTo(f26, f29 - f30, f26 - f31, f29 - f32, f26 - f33, f29 - f34);
        float f35 = f27 * 22.07f;
        float f36 = f27 * 34.86f;
        path2.cubicTo(f26 - f35, f29 - f36, f26 - f36, f29 - f35, f26 - f34, f29 - f33);
        path2.cubicTo(f26 - f32, f29 - f31, f26 - f30, f29, uo.b(f8, f28, f10, f11), f29);
        float f37 = f22 / 100.0f;
        float f38 = f37 * 128.19f * fMin;
        float f39 = f13 + f9;
        path2.lineTo(Math.min(f10, f38) + f11, f39);
        float f40 = f37 * 83.62f * f25;
        float f41 = f37 * 67.45f;
        float f42 = f37 * 4.64f;
        float f43 = f37 * 51.16f;
        float f44 = f37 * 13.36f;
        path2.cubicTo(f11 + f40, f39, f11 + f41, f39 - f42, f11 + f43, f39 - f44);
        float f45 = f37 * 34.86f;
        float f46 = f37 * 22.07f;
        path2.cubicTo(f11 + f45, f39 - f46, f46 + f11, f39 - f45, f11 + f44, f39 - f43);
        path2.cubicTo(f11 + f42, f39 - f41, f11, f39 - f40, f11, uo.b(f9, f38, f12, f13));
        float f47 = f22 / 100.0f;
        float f48 = 128.19f * f47 * fMin;
        path2.lineTo(f11, Math.min(f12, f48) + f13);
        float f49 = 83.62f * f47 * f25;
        float f50 = 4.64f * f47;
        float f51 = 67.45f * f47;
        float f52 = 13.36f * f47;
        float f53 = 51.16f * f47;
        path2.cubicTo(f11, f13 + f49, f11 + f50, f13 + f51, f11 + f52, f13 + f53);
        float f54 = 22.07f * f47;
        float f55 = f47 * 34.86f;
        path2.cubicTo(f11 + f54, f13 + f55, f11 + f55, f13 + f54, f11 + f53, f13 + f52);
        path2.cubicTo(f11 + f51, f13 + f50, f11 + f49, f13, Math.min(f10, f48) + f11, f13);
        path2.close();
        path.addPath(path2);
        Paint paint = this.l;
        if (paint != null) {
            paint.setShader(new SweepGradient(this.h, this.i, new int[]{922746879, -855638017, 922746879, -855638017, 922746879}, new float[]{0.0f, 0.05f, 0.5f, 0.55f, 1.0f}));
        }
    }

    public void setDarkModeTransparentBackground(boolean z) {
        this.j.setColor(z ? -1726211044 : -1713447202);
        invalidate();
    }

    public void setRoundRadius(float f) {
        this.g = f;
        invalidate();
    }
}
