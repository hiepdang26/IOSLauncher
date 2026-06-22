package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class bo implements gp {
    public final yo g;

    public bo(yo yoVar) {
        this.g = yoVar;
    }

    @Override // defpackage.gp
    public final yo c() {
        return this.g;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.g + ')';
    }
}
