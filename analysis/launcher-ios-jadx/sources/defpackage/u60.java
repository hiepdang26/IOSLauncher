package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class u60 extends RuntimeException {
    public final int g;
    public final Throwable h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u60(int i, Throwable th) {
        super(th);
        uo.p(i, "callbackName");
        this.g = i;
        this.h = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.h;
    }
}
