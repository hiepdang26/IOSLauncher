package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class tl implements ThreadFactory {
    public final AtomicInteger g = new AtomicInteger(0);
    public final /* synthetic */ boolean h;

    public tl(boolean z) {
        this.h = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        qg0.l(runnable, "runnable");
        StringBuilder sbM = uo.m(this.h ? "WM.task-" : "androidx.work-");
        sbM.append(this.g.incrementAndGet());
        return new Thread(runnable, sbM.toString());
    }
}
