package defpackage;

import android.graphics.Paint;
import android.graphics.Path;

/* JADX INFO: loaded from: classes.dex */
public final class uf1 {
    public static final int[] i = new int[3];
    public static final float[] j = {0.0f, 0.5f, 1.0f};
    public static final int[] k = new int[4];
    public static final float[] l = {0.0f, 0.0f, 0.5f, 1.0f};
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public int d;
    public int e;
    public int f;
    public final Path g = new Path();
    public final Paint h;

    public uf1() {
        Paint paint = new Paint();
        this.h = paint;
        this.a = new Paint();
        this.d = ik.h(-16777216, 68);
        this.e = ik.h(-16777216, 20);
        this.f = ik.h(-16777216, 0);
        this.a.setColor(this.d);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.c = new Paint(paint2);
    }
}
