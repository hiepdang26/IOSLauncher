package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zp0 extends AbstractExecutorService {
    public final /* synthetic */ int g;
    public final Handler h;

    public zp0() {
        this.g = 1;
        this.h = new Handler(Looper.getMainLooper());
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.g) {
            case 0:
                Handler handler = this.h;
                if (handler.getLooper() != Looper.myLooper()) {
                    handler.post(runnable);
                } else {
                    runnable.run();
                }
                break;
            default:
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    this.h.post(runnable);
                } else {
                    runnable.run();
                }
                break;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        switch (this.g) {
        }
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        switch (this.g) {
        }
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public zp0(Looper looper) {
        this.g = 0;
        this.h = new Handler(looper);
    }
}
