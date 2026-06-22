package defpackage;

import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.constraintlayout.motion.widget.Key;

/* JADX INFO: loaded from: classes.dex */
public final class mb {
    public Rect a;
    public Rect b;
    public String c;
    public Paint d;
    public Rect e;
    public ObjectAnimator f;
    public boolean g;

    public final void a(boolean z) {
        if (this.g != z) {
            this.g = z;
            ObjectAnimator objectAnimator = this.f;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, Key.ALPHA, z ? 1.0f : 0.0f);
            this.f = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(z ? 200L : 150L);
            this.f.start();
        }
    }
}
