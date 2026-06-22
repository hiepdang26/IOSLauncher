package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class w {
    public static final w d = new w(null, null);
    public final Runnable a;
    public final Executor b;
    public w c;

    public w(Runnable runnable, Executor executor) {
        this.a = runnable;
        this.b = executor;
    }
}
