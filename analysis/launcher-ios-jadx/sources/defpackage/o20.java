package defpackage;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.luutinhit.launcher6.FastBitmapDrawable;

/* JADX INFO: loaded from: classes.dex */
public enum o20 {
    NORMAL(0.0f, 0.0f, new DecelerateInterpolator()),
    PRESSED(0.0f, 0.39215687f, FastBitmapDrawable.o),
    FAST_SCROLL_HIGHLIGHTED(0.0f, 0.0f, new DecelerateInterpolator()),
    FAST_SCROLL_UNHIGHLIGHTED(0.0f, 0.0f, new DecelerateInterpolator()),
    DISABLED(1.0f, 0.5f, new DecelerateInterpolator());

    public final float g;
    public final float h;
    public final TimeInterpolator i;

    o20(float f, float f2, TimeInterpolator timeInterpolator) {
        this.g = f;
        this.h = f2;
        this.i = timeInterpolator;
    }
}
