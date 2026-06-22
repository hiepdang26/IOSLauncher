package defpackage;

import android.graphics.Color;
import android.graphics.Paint;
import androidx.constraintlayout.motion.widget.MotionScene;

/* JADX INFO: loaded from: classes.dex */
public final class yi1 {
    public static Paint j;
    public static Paint k;
    public static float l;
    public float a;
    public float b;
    public int c;
    public boolean d;
    public float e;
    public float f;
    public int g;
    public int h;
    public int i;

    public final void a(int i, int i2) {
        float fMin = Math.min(i2, i);
        float fRandom = ((float) Math.random()) * fMin * l;
        if (fRandom < 0.001f) {
            fRandom = 0.001f;
        }
        this.e = fRandom;
        this.f = fMin / 5000;
        this.a = i2 * ((float) Math.random());
        this.b = b21.f(this.e, i);
        s sVar = w71.g;
        s sVar2 = w71.g;
        int iArgb = Color.argb(255, sVar2.a().nextInt(MotionScene.Transition.TransitionOnClick.JUMP_TO_END), sVar2.a().nextInt(MotionScene.Transition.TransitionOnClick.JUMP_TO_END), sVar2.a().nextInt(MotionScene.Transition.TransitionOnClick.JUMP_TO_END));
        ThreadLocal threadLocal = ik.a;
        int iArgb2 = Color.argb((int) ((Color.alpha(-1) * 0.68f) + (Color.alpha(iArgb) * 0.32f)), (int) ((Color.red(-1) * 0.68f) + (Color.red(iArgb) * 0.32f)), (int) ((Color.green(-1) * 0.68f) + (Color.green(iArgb) * 0.32f)), (int) ((Color.blue(-1) * 0.68f) + (Color.blue(iArgb) * 0.32f)));
        this.g = iArgb2;
        this.h = ik.h(iArgb2, 26);
        this.i = (int) (Math.random() * ((double) 10));
    }
}
