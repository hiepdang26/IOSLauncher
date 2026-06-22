package defpackage;

import android.app.Activity;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class od2 extends pm1 {
    public final Object a = new Object();
    public final hh1 b = new hh1(3);
    public boolean c;
    public volatile boolean d;
    public Object e;
    public Exception f;

    @Override // defpackage.pm1
    public final Exception a() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // defpackage.pm1
    public final Object b() {
        Object obj;
        synchronized (this.a) {
            try {
                if (!this.c) {
                    throw new IllegalStateException("Task is not yet complete");
                }
                if (this.d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new zc1(exc);
                }
                obj = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // defpackage.pm1
    public final boolean c() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // defpackage.pm1
    public final boolean d() {
        boolean z;
        synchronized (this.a) {
            try {
                z = false;
                if (this.c && !this.d && this.f == null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    public final od2 e(Activity activity, ty0 ty0Var) {
        b82 b82Var = new b82(sm1.a, ty0Var);
        this.b.f(b82Var);
        ld2.i(activity).j(b82Var);
        k();
        return this;
    }

    public final od2 f(Activity activity, cz0 cz0Var) {
        b82 b82Var = new b82(sm1.a, cz0Var);
        this.b.f(b82Var);
        ld2.i(activity).j(b82Var);
        k();
        return this;
    }

    public final void g(Exception exc) {
        hg0.j(exc, "Exception must not be null");
        synchronized (this.a) {
            j();
            this.c = true;
            this.f = exc;
        }
        this.b.g(this);
    }

    public final void h(Object obj) {
        synchronized (this.a) {
            j();
            this.c = true;
            this.e = obj;
        }
        this.b.g(this);
    }

    public final void i() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return;
                }
                this.c = true;
                this.d = true;
                this.b.g(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j() {
        if (this.c) {
            int i = qj.g;
            if (!c()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excA = a();
        }
    }

    public final void k() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    this.b.g(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
