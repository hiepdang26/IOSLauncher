package defpackage;

import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;

/* JADX INFO: loaded from: classes.dex */
public final class m01 implements Runnable {
    public boolean g;
    public final int h;
    public final /* synthetic */ OverScrollLayout i;

    public m01(OverScrollLayout overScrollLayout) {
        this.i = overScrollLayout;
        this.h = overScrollLayout.configuration.getScaledMinimumFlingVelocity();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.g) {
            return;
        }
        OverScrollLayout overScrollLayout = this.i;
        if (overScrollLayout.flingScroller.computeScrollOffset()) {
            boolean z = true;
            if (!overScrollLayout.canOverScrollVertical ? !(!overScrollLayout.k() || !overScrollLayout.l()) : !(!overScrollLayout.j() || !overScrollLayout.m())) {
                z = false;
            }
            float currVelocity = overScrollLayout.flingScroller.getCurrVelocity();
            int i = this.h;
            if (z) {
                if (currVelocity > i) {
                    OverScrollLayout.i(overScrollLayout, currVelocity);
                }
            } else if (currVelocity > i) {
                overScrollLayout.postDelayed(this, 10L);
            }
        }
    }
}
