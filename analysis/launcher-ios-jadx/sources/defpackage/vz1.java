package defpackage;

import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class vz1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Workspace h;

    public /* synthetic */ vz1(Workspace workspace, int i) {
        this.g = i;
        this.h = workspace;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Runnable[] runnableArr;
        switch (this.g) {
            case 0:
                this.h.S0.exitSpringLoadedDragModeDelayed(true, t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
                return;
            default:
                rl0 model = this.h.S0.getModel();
                model.getClass();
                ArrayList arrayList = rl0.y;
                if (arrayList.isEmpty()) {
                    return;
                }
                synchronized (arrayList) {
                    runnableArr = (Runnable[]) arrayList.toArray(new Runnable[0]);
                    arrayList.clear();
                    break;
                }
                for (Runnable runnable : runnableArr) {
                    model.j.K(runnable);
                }
                return;
        }
    }
}
