package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class k10 implements Executor {
    public final /* synthetic */ int g;
    public final Handler h;

    public k10(int i, Handler handler) {
        this.g = i;
        switch (i) {
            case 1:
                handler.getClass();
                this.h = handler;
                break;
            default:
                this.h = handler;
                break;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.g) {
            case 0:
                this.h.post(runnable);
                return;
            default:
                runnable.getClass();
                Handler handler = this.h;
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
        }
    }
}
