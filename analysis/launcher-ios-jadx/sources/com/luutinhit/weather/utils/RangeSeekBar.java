package com.luutinhit.weather.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import defpackage.e51;
import defpackage.g71;
import defpackage.np1;
import defpackage.qg0;
import defpackage.uo;
import defpackage.x41;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class RangeSeekBar extends View {
    public int A;
    public int B;
    public final Rect g;
    public final Rect h;
    public String i;
    public String j;
    public int k;
    public int l;
    public final Paint m;
    public final Paint n;
    public Paint o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public Point w;
    public Point x;
    public int y;
    public int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        qg0.l(context, "context");
        this.g = new Rect();
        this.h = new Rect();
        this.i = "";
        this.j = "";
        this.k = -16776961;
        this.l = -65536;
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(getResources().getDimensionPixelSize(e51.rsb_text_size));
        this.m = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        this.n = paint2;
        new RectF();
        this.y = 1;
        this.z = 100;
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(e51.rsb_trackDefaultThickness);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(e51.rsb_touchRadius);
        int iK = np1.k(context, x41.rsb_trackDefaultColor);
        int iK2 = np1.k(context, x41.rsb_trackSelectedDefaultColor);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, g71.RangeSeekBar, 0, 0);
        qg0.k(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            setMax(typedArrayObtainStyledAttributes.getInteger(g71.RangeSeekBar_rsb_max, 100));
            setMinRange(typedArrayObtainStyledAttributes.getInteger(g71.RangeSeekBar_rsb_minRange, 1));
            this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.RangeSeekBar_rsb_touchRadius, dimensionPixelSize2);
            this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.RangeSeekBar_rsb_trackThickness, dimensionPixelSize);
            this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.RangeSeekBar_rsb_trackSelectedThickness, dimensionPixelSize);
            this.r = typedArrayObtainStyledAttributes.getColor(g71.RangeSeekBar_rsb_trackColor, iK);
            this.s = typedArrayObtainStyledAttributes.getColor(g71.RangeSeekBar_rsb_trackSelectedColor, iK2);
            this.w = new Point(typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.RangeSeekBar_rsb_minThumbOffsetHorizontal, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.RangeSeekBar_rsb_minThumbOffsetVertical, 0));
            this.x = new Point(typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.RangeSeekBar_rsb_maxThumbOffsetHorizontal, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.RangeSeekBar_rsb_maxThumbOffsetVertical, 0));
            this.u = typedArrayObtainStyledAttributes.getBoolean(g71.RangeSeekBar_rsb_trackRoundedCaps, true);
            this.v = typedArrayObtainStyledAttributes.getBoolean(g71.RangeSeekBar_rsb_trackSelectedRoundedCaps, true);
            int integer = typedArrayObtainStyledAttributes.getInteger(g71.RangeSeekBar_rsb_initialMinThumbValue, -1);
            int integer2 = typedArrayObtainStyledAttributes.getInteger(g71.RangeSeekBar_rsb_initialMaxThumbValue, -1);
            if (integer != -1) {
                this.A = Math.max(0, integer);
                b(1);
            }
            if (integer2 != -1) {
                this.B = Math.min(this.z, integer2);
                b(2);
            }
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public static int a(float f, int i, int i2) {
        float[] fArr = new float[3];
        float[] fArr2 = new float[3];
        Color.colorToHSV(i, fArr);
        Color.colorToHSV(i2, fArr2);
        for (int i3 = 0; i3 < 3; i3++) {
            float f2 = fArr[i3];
            fArr2[i3] = uo.s(fArr2[i3], f2, f, f2);
        }
        return Color.HSVToColor(fArr2);
    }

    private final void setMaxThumbValue(int i) {
        this.B = Math.min(i, this.z);
        b(2);
        invalidate();
    }

    private final void setMinThumbValue(int i) {
        this.A = Math.max(i, 0);
        b(1);
        invalidate();
    }

    public final void b(int i) {
        if (i == 1) {
            int i2 = this.A;
            int i3 = this.B;
            int i4 = this.y;
            if (i2 > i3 - i4) {
                this.B = i2 + i4;
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        int i5 = this.B;
        int i6 = this.A;
        int i7 = this.y;
        if (i5 <= i6 + i7) {
            this.A = i5 - i7;
        }
    }

    public final void c(int i, int i2, int i3, int i4) {
        this.i = String.format("%s%s", Arrays.copyOf(new Object[]{Integer.valueOf(i), (char) 176}, 2));
        this.j = String.format("%s%s", Arrays.copyOf(new Object[]{Integer.valueOf(i2), (char) 176}, 2));
        setMax(i4 - i3);
        setMinThumbValue(i - i3);
        setMaxThumbValue(i2 - i3);
        this.k = a((i + 50) / 100.0f, Color.parseColor("#7BD2FF"), Color.parseColor("#FF0000"));
        this.l = a((i2 + 50) / 100.0f, Color.parseColor("#7BD2FF"), Color.parseColor("#FF0000"));
    }

    public final int getMax() {
        return this.z;
    }

    public final Point getMaxThumbOffset() {
        return this.x;
    }

    public final int getMaxThumbValue() {
        return this.B;
    }

    public final int getMinRange() {
        return this.y;
    }

    public final Point getMinThumbOffset() {
        return this.w;
    }

    public final int getMinThumbValue() {
        return this.A;
    }

    public final int getTouchRadius() {
        return this.t;
    }

    public final int getTrackColor() {
        return this.r;
    }

    public final boolean getTrackRoundedCaps() {
        return this.u;
    }

    public final int getTrackSelectedColor() {
        return this.s;
    }

    public final boolean getTrackSelectedRoundedCaps() {
        return this.v;
    }

    public final int getTrackSelectedThickness() {
        return this.q;
    }

    public final int getTrackThickness() {
        return this.p;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f;
        float f2;
        qg0.l(canvas, "canvas");
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        float height = getHeight() / 2.0f;
        Paint paint = this.m;
        String str = this.i;
        paint.getTextBounds(str, 0, str.length(), this.g);
        float fWidth = r10.width() / 3.0f;
        float fWidth2 = r10.width() + paddingLeft + fWidth;
        String str2 = this.j;
        paint.getTextBounds(str2, 0, str2.length(), this.h);
        float width = ((getWidth() - paddingRight) - r13.width()) - fWidth;
        float fAbs = Math.abs(width - fWidth2);
        float f3 = this.A;
        int i = this.z;
        float f4 = ((f3 / i) * fAbs) + fWidth2;
        float f5 = ((this.B / i) * fAbs) + fWidth2;
        float f6 = 2;
        canvas.drawText(this.i, (r10.width() / 2.0f) + paddingLeft, (getHeight() / 2.0f) - ((paint.ascent() + paint.descent()) / f6), paint);
        canvas.drawText(this.j, (r13.width() / 2.0f) + fWidth + width, (getHeight() / 2.0f) - ((paint.ascent() + paint.descent()) / f6), paint);
        Paint paint2 = this.n;
        paint2.setColor(this.r);
        float f7 = this.p;
        float f8 = f7 / f6;
        float f9 = height - f8;
        float f10 = height + f8;
        if (this.u) {
            canvas.drawRoundRect(fWidth2 - f8, f9, f8 + width, f10, f7, f7, paint2);
            f = fWidth2;
        } else {
            f = fWidth2;
            canvas.drawRect(f, f9, width, f10, paint2);
        }
        if (this.o == null) {
            Paint paint3 = new Paint(1);
            paint3.setStyle(Paint.Style.FILL);
            f2 = f6;
            paint3.setShader(new LinearGradient(f, 0.0f, width, 0.0f, this.k, this.l, Shader.TileMode.CLAMP));
            this.o = paint3;
        } else {
            f2 = f6;
        }
        float f11 = this.q;
        Paint paint4 = this.o;
        qg0.h(paint4);
        float f12 = f11 / f2;
        float f13 = height - f12;
        float f14 = height + f12;
        if (this.v) {
            canvas.drawRoundRect(f4 - f12, f13, f5 + f12, f14, f11, f11, paint4);
        } else {
            canvas.drawRect(f4, f13, f5, f14, paint4);
        }
    }

    public final void setMax(int i) {
        this.z = i;
        this.A = 0;
        this.B = i;
    }

    public final void setMaxThumbOffset(Point point) {
        qg0.l(point, "<set-?>");
        this.x = point;
    }

    public final void setMinRange(int i) {
        this.y = Math.max(i, 1);
    }

    public final void setMinThumbOffset(Point point) {
        qg0.l(point, "<set-?>");
        this.w = point;
    }

    public final void setTouchRadius(int i) {
        this.t = i;
    }

    public final void setTrackColor(int i) {
        this.r = i;
    }

    public final void setTrackRoundedCaps(boolean z) {
        this.u = z;
    }

    public final void setTrackSelectedColor(int i) {
        this.s = i;
    }

    public final void setTrackSelectedRoundedCaps(boolean z) {
        this.v = z;
    }

    public final void setTrackSelectedThickness(int i) {
        this.q = i;
    }

    public final void setTrackThickness(int i) {
        this.p = i;
    }
}
