package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class dz1 implements Executor {
    public final /* synthetic */ int g;
    public final Object h;

    public /* synthetic */ dz1(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.g) {
            case 0:
                ((Handler) ((qm0) this.h).c).post(runnable);
                break;
            case 1:
                ((t12) this.h).post(runnable);
                break;
            default:
                ((t12) this.h).post(runnable);
                break;
        }
    }

    public dz1() {
        this.g = 2;
        t12 t12Var = new t12(Looper.getMainLooper());
        Looper.getMainLooper();
        this.h = t12Var;
    }
}
