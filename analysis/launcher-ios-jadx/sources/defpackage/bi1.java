package defpackage;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
public final class bi1 {
    public static Paint h;
    public static float i;
    public final float a;
    public final float b = (float) (Math.random() / ((double) 100));
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;

    public bi1(int i2, int i3, float f) {
        this.a = f;
        if (i == 0.0f) {
            i = 0.01f;
        }
        if (f < 0.2f) {
            this.a = 0.2f;
        } else if (f > 1.0f) {
            this.a = 1.0f;
        }
        if (h == null) {
            Paint paint = new Paint();
            h = paint;
            paint.setAntiAlias(true);
            Paint paint2 = h;
            qg0.h(paint2);
            paint2.setColor(-1);
            Paint paint3 = h;
            qg0.h(paint3);
            paint3.setStyle(Paint.Style.FILL_AND_STROKE);
            Paint paint4 = h;
            qg0.h(paint4);
            paint4.setAlpha((int) (this.a * 255));
        }
        a(i2, i3);
    }

    public final void a(int i2, int i3) {
        float fMin = Math.min(i3, i2);
        this.e = ((float) Math.random()) * fMin * i;
        this.f = ((fMin * ((float) Math.random())) * i) / 3;
        this.g = (float) (Math.random() * 2.0d * 3.141592653589793d);
        this.c = i3 * ((float) Math.random());
        this.d = (i2 * ((float) Math.random())) - (this.e * 2);
    }
}
