package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class j00 implements eb1 {
    public final boolean g;
    public final boolean h;
    public final eb1 i;
    public final d00 j;
    public final i00 k;
    public int l;
    public boolean m;

    public j00(eb1 eb1Var, boolean z, boolean z2, i00 i00Var, d00 d00Var) {
        n90.h(eb1Var, "Argument must not be null");
        this.i = eb1Var;
        this.g = z;
        this.h = z2;
        this.k = i00Var;
        n90.h(d00Var, "Argument must not be null");
        this.j = d00Var;
    }

    public final synchronized void a() {
        if (this.m) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.l++;
    }

    public final void b() {
        boolean z;
        synchronized (this) {
            int i = this.l;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.l = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.j.e(this.k, this);
        }
    }

    @Override // defpackage.eb1
    public final int c() {
        return this.i.c();
    }

    @Override // defpackage.eb1
    public final Class d() {
        return this.i.d();
    }

    @Override // defpackage.eb1
    public final Object get() {
        return this.i.get();
    }

    @Override // defpackage.eb1
    public final synchronized void recycle() {
        if (this.l > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.m) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.m = true;
        if (this.h) {
            this.i.recycle();
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.g + ", listener=" + this.j + ", key=" + this.k + ", acquired=" + this.l + ", isRecycled=" + this.m + ", resource=" + this.i + '}';
    }
}
