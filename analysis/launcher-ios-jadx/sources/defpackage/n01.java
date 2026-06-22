package defpackage;

import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;

/* JADX INFO: loaded from: classes.dex */
public final class n01 implements Runnable {
    public float g;
    public float h;
    public long i;
    public final /* synthetic */ OverScrollLayout j;

    public n01(OverScrollLayout overScrollLayout) {
        this.j = overScrollLayout;
    }

    public final void a(float f, float f2) {
        this.g = f;
        this.h = f2;
        this.i = System.currentTimeMillis();
        run();
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.i;
        OverScrollLayout overScrollLayout = this.j;
        if (jCurrentTimeMillis < 100) {
            overScrollLayout.mSmoothScrollBy((int) (this.g * 100.0f), (int) (this.h * 100.0f));
            overScrollLayout.postDelayed(this, 100L);
        } else if (jCurrentTimeMillis > 100) {
            overScrollLayout.mSmoothScrollTo(0, 0);
        }
    }
}
