package defpackage;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ul0 {
    public static final float A;
    public static final float B;
    public static final float x = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final float[] y = new float[101];
    public static final float[] z = new float[101];
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public long j;
    public int k;
    public float l;
    public float m;
    public float n;
    public boolean o;
    public TimeInterpolator p;
    public final boolean q;
    public float r;
    public float s;
    public int t;
    public final float u;
    public final float v;
    public final float w;

    static {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10 = 0.0f;
        float f11 = 0.0f;
        int i = 0;
        while (true) {
            float f12 = 1.0f;
            if (i >= 100) {
                float[] fArr = y;
                z[100] = 1.0f;
                fArr[100] = 1.0f;
                A = 8.0f;
                B = 1.0f;
                B = 1.0f / b(1.0f);
                return;
            }
            float f13 = i / 100.0f;
            float f14 = 1.0f;
            while (true) {
                f = ((f14 - f10) / 2.0f) + f10;
                f2 = f12 - f;
                f3 = f * 3.0f * f2;
                f4 = f * f * f;
                float f15 = (((f * 0.35000002f) + (f2 * 0.175f)) * f3) + f4;
                f5 = f13;
                if (Math.abs(f15 - f13) < 1.0E-5d) {
                    break;
                }
                if (f15 > f5) {
                    f14 = f;
                } else {
                    f10 = f;
                }
                f13 = f5;
                f12 = 1.0f;
            }
            y[i] = (((f2 * 0.5f) + f) * f3) + f4;
            float f16 = 1.0f;
            while (true) {
                f6 = ((f16 - f11) / 2.0f) + f11;
                f7 = 1.0f - f6;
                f8 = f6 * 3.0f * f7;
                f9 = f6 * f6 * f6;
                float f17 = (((f7 * 0.5f) + f6) * f8) + f9;
                if (Math.abs(f17 - f5) < 1.0E-5d) {
                    break;
                } else if (f17 > f5) {
                    f16 = f6;
                } else {
                    f11 = f6;
                }
            }
            z[i] = (((f6 * 0.35000002f) + (f7 * 0.175f)) * f8) + f9;
            i++;
        }
    }

    public ul0(Context context) {
        boolean z2 = context.getApplicationInfo().targetSdkVersion >= 11;
        this.u = ViewConfiguration.getScrollFriction();
        this.o = true;
        this.p = null;
        float f = context.getResources().getDisplayMetrics().density * 160.0f;
        this.v = f * 386.0878f * ViewConfiguration.getScrollFriction();
        this.q = z2;
        this.w = f * 386.0878f * 0.84f;
    }

    public static float b(float f) {
        float f2 = f * A;
        return (f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : uo.s(1.0f, (float) Math.exp(1.0f - f2), 0.63212055f, 0.36787945f)) * B;
    }

    public final void a(int i, int i2, int i3) {
        this.a = 0;
        this.o = false;
        this.k = i3;
        this.j = AnimationUtils.currentAnimationTimeMillis();
        this.b = i;
        this.c = 0;
        this.d = i + i2;
        this.e = 0;
        this.m = i2;
        this.n = 0;
        this.l = 1.0f / this.k;
    }
}
