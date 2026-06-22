package defpackage;

import androidx.lifecycle.b;

/* JADX INFO: loaded from: classes.dex */
public final class c01 {
    public static final b01 c = new b01();
    public static final a01 d = new a01();
    public final b a = new b();
    public final nf1 b = new nf1();

    public c01() {
        a(d);
    }

    public final void a(np1 np1Var) {
        boolean z;
        b bVar = this.a;
        synchronized (bVar.a) {
            z = bVar.f == b.k;
            bVar.f = np1Var;
        }
        if (z) {
            u8.u().v(bVar.j);
        }
        if (np1Var instanceof b01) {
            this.b.i((b01) np1Var);
        } else if (np1Var instanceof zz0) {
            this.b.j(((zz0) np1Var).f);
        }
    }
}
