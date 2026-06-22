package defpackage;

import android.animation.TimeInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class yg0 implements TimeInterpolator {
    public n20 a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return 1.0f - this.a.getInterpolation(1.0f - f);
    }
}
