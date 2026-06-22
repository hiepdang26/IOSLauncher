package defpackage;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class tv implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final synchronized Thread newThread(Runnable runnable) {
        Thread thread;
        thread = new Thread(runnable, "glide-disk-lru-cache-thread");
        thread.setPriority(1);
        return thread;
    }
}
