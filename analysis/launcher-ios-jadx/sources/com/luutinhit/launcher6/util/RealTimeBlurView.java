package com.luutinhit.launcher6.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import defpackage.g61;
import defpackage.g71;
import defpackage.x41;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class RealTimeBlurView extends View {
    public final Rect A;
    public final Paint g;
    public final Paint h;
    public final Paint i;
    public int j;
    public int k;
    public float l;
    public View m;
    public int n;
    public int o;
    public float p;
    public boolean q;
    public Bitmap r;
    public Bitmap s;
    public Bitmap t;
    public Canvas u;
    public float v;
    public Bitmap w;
    public Canvas x;
    public final Paint y;
    public final Rect z;

    public RealTimeBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.g = paint;
        Paint paint2 = new Paint(1);
        this.h = paint2;
        Paint paint3 = new Paint(1);
        this.i = paint3;
        new Paint(2);
        this.l = 0.8f;
        this.y = new Paint(2);
        this.z = new Rect();
        this.A = new Rect();
        Resources resources = getResources();
        int integer = resources.getInteger(g61.default_blur_radius);
        int integer2 = resources.getInteger(g61.default_downsample_factor);
        int color = resources.getColor(x41.default_overlay_color);
        try {
            PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
            paint.setXfermode(new PorterDuffXfermode(mode));
            paint2.setXfermode(new PorterDuffXfermode(mode));
            paint3.setXfermode(new PorterDuffXfermode(mode));
        } catch (Throwable unused) {
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.RealTimeBlurView);
        setBlurRadius(typedArrayObtainStyledAttributes.getInt(g71.RealTimeBlurView_blurRadius, integer));
        setDownSampleFactor(typedArrayObtainStyledAttributes.getInt(g71.RealTimeBlurView_downsampleFactor, integer2));
        setOverlayColor(typedArrayObtainStyledAttributes.getColor(g71.RealTimeBlurView_overlayColor, color));
        setTransparentPercent(typedArrayObtainStyledAttributes.getFloat(g71.RealTimeBlurView_transparentPercent, 0.8f));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a() {
        Bitmap bitmap = this.r;
        if (bitmap != null) {
            bitmap.recycle();
            this.r = null;
        }
        Bitmap bitmap2 = this.s;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.s = null;
        }
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r26) {
        /*
            Method dump skipped, instruction units count: 543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.util.RealTimeBlurView.onDraw(android.graphics.Canvas):void");
    }

    public void setBitmapBackground(Bitmap bitmap) {
        this.t = bitmap;
    }

    public void setBlurRadius(int i) {
        float f = i;
        if (this.p != f) {
            this.p = f;
        }
    }

    public void setBlurredView(View view) {
        Objects.toString(view);
        this.m = view;
    }

    public void setDownSampleFactor(int i) {
        if (i <= 0) {
            i = 1;
        }
        if (this.j != i) {
            this.j = i;
            this.q = true;
        }
    }

    public void setOverlayColor(int i) {
        this.k = i;
    }

    public void setTransparentPercent(float f) {
        this.l = f;
    }
}
