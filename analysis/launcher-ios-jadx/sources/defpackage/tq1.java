package defpackage;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tq1 implements ThreadFactory {
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;

    public /* synthetic */ tq1(String str, boolean z) {
        this.g = str;
        this.h = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.g);
        thread.setDaemon(this.h);
        return thread;
    }
}
