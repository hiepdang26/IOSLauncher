package defpackage;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class n20 implements TimeInterpolator {
    public final /* synthetic */ int a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        switch (this.a) {
            case 0:
                if (f < 0.05f) {
                    return f / 0.05f;
                }
                if (f < 0.3f) {
                    return 1.0f;
                }
                return (1.0f - f) / 0.7f;
            default:
                return (1.0f - (0.35f / (f + 0.35f))) / 0.7407408f;
        }
    }
}
