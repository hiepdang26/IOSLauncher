package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class ig1 {
    public final kc1 a;
    public final AtomicBoolean b;
    public final fl1 c;

    public ig1(kc1 kc1Var) {
        qg0.l(kc1Var, "database");
        this.a = kc1Var;
        this.b = new AtomicBoolean(false);
        this.c = new fl1(new w60(this, 2));
    }

    public final z60 a() {
        this.a.a();
        return this.b.compareAndSet(false, true) ? (z60) this.c.a() : b();
    }

    public final z60 b() {
        String strC = c();
        kc1 kc1Var = this.a;
        kc1Var.getClass();
        kc1Var.a();
        kc1Var.b();
        return kc1Var.g().v().h(strC);
    }

    public abstract String c();

    public final void d(z60 z60Var) {
        qg0.l(z60Var, "statement");
        if (z60Var == ((z60) this.c.a())) {
            this.b.set(false);
        }
    }
}
