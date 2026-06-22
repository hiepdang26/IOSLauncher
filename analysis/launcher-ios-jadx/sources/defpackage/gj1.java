package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class gj1 {
    public volatile boolean a;

    public final void a() {
        if (this.a) {
            throw new IllegalStateException("Already released");
        }
    }
}
