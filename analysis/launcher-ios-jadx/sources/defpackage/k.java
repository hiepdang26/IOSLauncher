package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static final k d = new k(null, null);
    public final Runnable a;
    public final Executor b;
    public k c;

    public k(Runnable runnable, Executor executor) {
        this.a = runnable;
        this.b = executor;
    }
}
