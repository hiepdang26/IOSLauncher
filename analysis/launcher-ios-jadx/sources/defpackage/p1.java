package defpackage;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class p1 implements ThreadFactory {
    public final /* synthetic */ int g;

    public /* synthetic */ p1(int i) {
        this.g = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.g) {
            case 0:
                return new Thread(new o1(runnable, 0), "glide-active-resources");
            case 1:
                return new o9(runnable);
            default:
                return new qa1(runnable);
        }
    }
}
