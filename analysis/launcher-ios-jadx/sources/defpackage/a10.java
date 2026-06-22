package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class a10 {
    static {
        new z00("No further exceptions");
    }

    public static RuntimeException a(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }
}
