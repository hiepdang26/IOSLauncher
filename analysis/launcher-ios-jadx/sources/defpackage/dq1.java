package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class dq1 extends UnsupportedOperationException {
    public final v20 g;

    public dq1(v20 v20Var) {
        this.g = v20Var;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.g));
    }
}
