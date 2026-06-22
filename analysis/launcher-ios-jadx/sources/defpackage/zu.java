package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class zu extends RuntimeException {
    public final transient yo g;

    public zu(yo yoVar) {
        this.g = yoVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.g.toString();
    }
}
