package com.luutinhit.launcher6.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.util.DeleteCircleView;

/* JADX INFO: loaded from: classes.dex */
public class DeleteCircleView extends View {
    public static Paint n;
    public static Paint o;
    public static Paint p;
    public final int[] g;
    public final float[] h;
    public float i;
    public float j;
    public float k;
    public final boolean l;
    public final int m;

    public DeleteCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = new int[]{0, -1, 0, -1, 0};
        this.h = new float[]{0.0f, 0.125f, 0.5f, 0.625f, 1.0f};
        t tVar = (t) context;
        this.m = tVar.mDeviceProfile.z;
        setClipToOutline(false);
        setScaleX(0.0f);
        setScaleY(0.0f);
        if (n != null) {
            this.l = tVar.isUseLiquidGlass;
            return;
        }
        this.l = tVar.isUseLiquidGlass;
        Paint paint = new Paint(1);
        n = paint;
        paint.setStyle(Paint.Style.FILL);
        n.setColor(this.l ? -2134061876 : -288568116);
        Paint paint2 = new Paint(1);
        o = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        o.setStrokeCap(Paint.Cap.ROUND);
        o.setColor(this.l ? -285212673 : -301989888);
        Paint paint3 = new Paint(1);
        p = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    public final void c(int i, boolean z) {
        if (!z) {
            setVisibility(i);
            return;
        }
        if (getVisibility() != i) {
            if (i == 0) {
                setEnabled(true);
                final int i2 = 0;
                animate().withLayer().scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f)).withStartAction(new Runnable(this) { // from class: ou
                    public final /* synthetic */ DeleteCircleView h;

                    {
                        this.h = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                super/*android.view.View*/.setVisibility(0);
                                break;
                            default:
                                super/*android.view.View*/.setVisibility(8);
                                break;
                        }
                    }
                }).setStartDelay(20L).start();
            } else if (i == 4 || i == 8) {
                final int i3 = 1;
                animate().withLayer().scaleX(0.0f).scaleY(0.0f).setDuration(300L).setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f)).withEndAction(new Runnable(this) { // from class: ou
                    public final /* synthetic */ DeleteCircleView h;

                    {
                        this.h = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i3) {
                            case 0:
                                super/*android.view.View*/.setVisibility(0);
                                break;
                            default:
                                super/*android.view.View*/.setVisibility(8);
                                break;
                        }
                    }
                }).setStartDelay(20L).start();
            }
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.i, this.j, this.k, n);
        if (this.l) {
            canvas.drawCircle(this.i, this.j, this.k - (p.getStrokeWidth() / 2.0f), p);
        }
        float f = this.k * 0.4f;
        float f2 = this.i;
        float f3 = this.j;
        canvas.drawLine(f2 - f, f3, f2 + f, f3, o);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3 = this.m;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = ((int) (((double) i) * 0.9d)) / 2.0f;
        this.j = ((int) (((double) i2) * 0.9d)) / 2.0f;
        float fMin = Math.min(r3, r4) / 2.0f;
        this.k = fMin;
        p.setStrokeWidth(fMin / 10.0f);
        o.setStrokeWidth(this.k / 5.0f);
        p.setShader(new SweepGradient(this.i, this.j, this.g, this.h));
    }
}
