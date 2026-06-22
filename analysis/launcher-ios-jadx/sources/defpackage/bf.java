package defpackage;

import androidx.constraintlayout.motion.widget.MotionScene;

/* JADX INFO: loaded from: classes.dex */
public final class bf {
    public final int a;
    public final int b;
    public final Object c;

    public bf(byte[] bArr, int i, int i2) {
        this.c = bArr;
        this.a = i;
        this.b = i2;
    }

    public bf() {
        this.c = new bf[MotionScene.Transition.TransitionOnClick.JUMP_TO_END];
        this.a = 0;
        this.b = 0;
    }

    public bf(int i, int i2) {
        this.c = null;
        this.a = i;
        int i3 = i2 & 7;
        this.b = i3 == 0 ? 8 : i3;
    }
}
