package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class rp0 implements eb1, i20 {
    public static final wb2 k = os.t(20, new ka0(26));
    public final gj1 g = new gj1();
    public eb1 h;
    public boolean i;
    public boolean j;

    public final synchronized void a() {
        this.g.a();
        if (!this.i) {
            throw new IllegalStateException("Already unlocked");
        }
        this.i = false;
        if (this.j) {
            recycle();
        }
    }

    @Override // defpackage.i20
    public final gj1 b() {
        return this.g;
    }

    @Override // defpackage.eb1
    public final int c() {
        return this.h.c();
    }

    @Override // defpackage.eb1
    public final Class d() {
        return this.h.d();
    }

    @Override // defpackage.eb1
    public final Object get() {
        return this.h.get();
    }

    @Override // defpackage.eb1
    public final synchronized void recycle() {
        this.g.a();
        this.j = true;
        if (!this.i) {
            this.h.recycle();
            this.h = null;
            k.z(this);
        }
    }
}
