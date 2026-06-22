package defpackage;

import androidx.lifecycle.a;

/* JADX INFO: loaded from: classes.dex */
public final class o60 implements hb0, od1, dt1 {
    public final ct1 g;
    public a h = null;
    public hh1 i = null;

    public o60(ct1 ct1Var) {
        this.g = ct1Var;
    }

    @Override // defpackage.od1
    public final nd1 a() {
        c();
        return (nd1) this.i.b;
    }

    public final void b(um0 um0Var) {
        this.h.d(um0Var);
    }

    public final void c() {
        if (this.h == null) {
            this.h = new a(this);
            this.i = new hh1(this);
        }
    }

    @Override // defpackage.hb0
    public final fb h() {
        return mp.h;
    }

    @Override // defpackage.dt1
    public final ct1 j() {
        c();
        return this.g;
    }

    @Override // defpackage.en0
    public final a l() {
        c();
        return this.h;
    }
}
