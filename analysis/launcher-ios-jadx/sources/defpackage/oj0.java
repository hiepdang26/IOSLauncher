package defpackage;

import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class oj0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ t h;

    public /* synthetic */ oj0(t tVar, int i) {
        this.g = i;
        this.h = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.exitSpringLoadedDragModeDelayed(true, t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
                break;
            case 1:
                this.h.mOverviewPanel.requestFocusFromTouch();
                break;
            case 2:
                this.h.finishBindingItems();
                break;
            case 3:
                this.h.setRequestedOrientation(-1);
                break;
            case 4:
                this.h.mVibrator.vibrate(50L);
                break;
            case 5:
                this.h.setOrientation();
                break;
            default:
                this.h.exitSpringLoadedDragModeDelayed(false, 0, null);
                break;
        }
    }
}
