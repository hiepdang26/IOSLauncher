package defpackage;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public final class md implements Interpolator {
    public final /* synthetic */ int a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        switch (this.a) {
            case 0:
                return (float) (1.0d - Math.pow(1.0f - f, 4.0d));
            case 1:
                return f * f * f * f * f;
            case 2:
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            case 3:
                float f3 = f - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            case 4:
                float f4 = f - 1.0f;
                return (f4 * f4 * f4 * f4 * f4) + 1.0f;
            case 5:
                float f5 = f - 1.0f;
                return (f5 * f5 * f5 * f5 * f5) + 1.0f;
            case 6:
                float f6 = f - 1.0f;
                return (f6 * f6 * f6 * f6 * f6) + 1.0f;
            default:
                float f7 = f - 1.0f;
                return (f7 * f7 * f7 * f7 * f7) + 1.0f;
        }
    }
}
