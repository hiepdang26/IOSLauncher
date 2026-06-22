package defpackage;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
public final class bq {
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public final RectF a = new RectF();
    public final RectF b = new RectF();
    public float k = 1.0f;
    public float l = 1.0f;

    public static boolean b(float f, float f2, float f3, float f4, float f5) {
        return Math.abs(f - f3) <= f5 && Math.abs(f2 - f4) <= f5;
    }

    public final RectF a() {
        RectF rectF = this.b;
        rectF.set(this.a);
        return rectF;
    }
}
