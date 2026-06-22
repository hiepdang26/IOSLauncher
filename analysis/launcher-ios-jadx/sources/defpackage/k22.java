package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class k22 {
    public boolean a;
    public float b;

    public final synchronized float a() {
        if (!e()) {
            return 1.0f;
        }
        return this.b;
    }

    public final synchronized void b(boolean z) {
        this.a = z;
    }

    public final synchronized void c(float f) {
        this.b = f;
    }

    public final synchronized boolean d() {
        return this.a;
    }

    public final synchronized boolean e() {
        return this.b >= 0.0f;
    }
}
