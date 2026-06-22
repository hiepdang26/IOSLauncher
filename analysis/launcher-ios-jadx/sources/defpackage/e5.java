package defpackage;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class e5 extends wd {
    public final ObjectAnimator B;
    public final boolean C;

    public e5(AnimationDrawable animationDrawable, boolean z, boolean z2) {
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i = z ? numberOfFrames - 1 : 0;
        int i2 = z ? 0 : numberOfFrames - 1;
        f5 f5Var = new f5();
        int numberOfFrames2 = animationDrawable.getNumberOfFrames();
        f5Var.b = numberOfFrames2;
        int[] iArr = f5Var.a;
        if (iArr == null || iArr.length < numberOfFrames2) {
            f5Var.a = new int[numberOfFrames2];
        }
        int[] iArr2 = f5Var.a;
        int i3 = 0;
        for (int i4 = 0; i4 < numberOfFrames2; i4++) {
            int duration = animationDrawable.getDuration(z ? (numberOfFrames2 - i4) - 1 : i4);
            iArr2[i4] = duration;
            i3 += duration;
        }
        f5Var.c = i3;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
        qk.a(objectAnimatorOfInt, true);
        objectAnimatorOfInt.setDuration(f5Var.c);
        objectAnimatorOfInt.setInterpolator(f5Var);
        this.C = z2;
        this.B = objectAnimatorOfInt;
    }

    @Override // defpackage.wd
    public final void E() {
        this.B.reverse();
    }

    @Override // defpackage.wd
    public final void I() {
        this.B.start();
    }

    @Override // defpackage.wd
    public final void J() {
        this.B.cancel();
    }

    @Override // defpackage.wd
    public final boolean d() {
        return this.C;
    }
}
