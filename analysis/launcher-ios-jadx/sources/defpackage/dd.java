package defpackage;

import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class dd implements Runnable {
    public final /* synthetic */ int g = 0;
    public final /* synthetic */ int h;
    public final /* synthetic */ t i;

    public dd(int i, t tVar) {
        this.h = i;
        this.i = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                double d = ik.d(this.h);
                t tVar = this.i;
                if (d <= 0.8d) {
                    tVar.updateIconTextColor(-1);
                } else {
                    tVar.updateIconTextColor(-12303292);
                }
                break;
            default:
                this.i.exitSpringLoadedDragModeDelayed(this.h != 0, t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
                break;
        }
    }

    public dd(t tVar, int i) {
        this.i = tVar;
        this.h = i;
    }
}
