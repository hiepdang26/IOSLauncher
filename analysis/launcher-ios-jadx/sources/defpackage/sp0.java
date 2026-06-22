package defpackage;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class sp0 implements TimeInterpolator {
    public final float a = 1.0f / ((0 * 1.0f) + (((float) (-Math.pow(100, -1.0f))) + 1.0f));

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if (Float.compare(f, 1.0f) == 0) {
            return 1.0f;
        }
        return ((0 * f) + ((float) (-Math.pow(100, -f))) + 1.0f) * this.a;
    }
}
