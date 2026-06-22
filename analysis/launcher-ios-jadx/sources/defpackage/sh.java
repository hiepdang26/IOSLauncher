package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class sh extends th {
    public final Throwable a;

    public sh(Throwable th) {
        this.a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof sh) {
            return qg0.d(this.a, ((sh) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // defpackage.th
    public final String toString() {
        return "Closed(" + this.a + ')';
    }
}
