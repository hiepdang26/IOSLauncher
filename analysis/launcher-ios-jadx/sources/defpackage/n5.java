package defpackage;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class n5 {
    public static final LinearInterpolator a = new LinearInterpolator();
    public static final p20 b = new p20(p20.d);
    public static final p20 c = new p20(p20.c);
    public static final p20 d = new p20(p20.e);

    static {
        new DecelerateInterpolator();
    }

    public static float a(float f, float f2, float f3) {
        return uo.s(f2, f, f3, f);
    }

    public static float b(float f, float f2, float f3, float f4, float f5) {
        return f5 < f3 ? f : f5 > f4 ? f2 : a(f, f2, (f5 - f3) / (f4 - f3));
    }

    public static int c(float f, int i, int i2) {
        return Math.round(f * (i2 - i)) + i;
    }
}
