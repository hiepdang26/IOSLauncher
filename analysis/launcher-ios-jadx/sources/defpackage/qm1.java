package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class qm1 {
    public final od2 a = new od2();

    public final void a(Object obj) {
        this.a.h(obj);
    }

    public final void b(Exception exc) {
        od2 od2Var = this.a;
        od2Var.getClass();
        hg0.j(exc, "Exception must not be null");
        synchronized (od2Var.a) {
            try {
                if (od2Var.c) {
                    return;
                }
                od2Var.c = true;
                od2Var.f = exc;
                od2Var.b.g(od2Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
