package defpackage;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class hv implements Executor {
    public static final hv g;
    public static final /* synthetic */ hv[] h;

    static {
        hv hvVar = new hv("INSTANCE", 0);
        g = hvVar;
        h = new hv[]{hvVar};
    }

    public static hv valueOf(String str) {
        return (hv) Enum.valueOf(hv.class, str);
    }

    public static hv[] values() {
        return (hv[]) h.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "DirectExecutor";
    }
}
