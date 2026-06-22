package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class w12 implements ThreadFactory {
    public final AtomicInteger g = new AtomicInteger(1);
    public final /* synthetic */ String h;

    public w12(String str) {
        this.h = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AdWorker(" + this.h + ") #" + this.g.getAndIncrement());
    }
}
