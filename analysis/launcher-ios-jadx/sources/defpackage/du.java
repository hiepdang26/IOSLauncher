package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class du implements ThreadFactory {
    public final /* synthetic */ int g;
    public final Object h;

    public du(int i) {
        this.g = i;
        switch (i) {
            case 1:
                this.h = Executors.defaultThreadFactory();
                break;
            default:
                this.h = new AtomicInteger(0);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.g) {
            case 0:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + ((AtomicInteger) this.h).getAndIncrement());
                return thread;
            default:
                Thread threadNewThread = ((ThreadFactory) this.h).newThread(runnable);
                threadNewThread.setName("ScionFrontendApi");
                return threadNewThread;
        }
    }
}
