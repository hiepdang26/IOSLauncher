package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class tk implements eo {
    public static final tk g = new tk();

    @Override // defpackage.eo
    public final yo getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // defpackage.eo
    public final void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
