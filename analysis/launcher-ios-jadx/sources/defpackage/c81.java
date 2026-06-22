package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class c81 extends cg {
    public final rf i;
    public volatile AtomicInteger j;
    public final /* synthetic */ d81 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c81(d81 d81Var, rf rfVar) {
        super("OkHttp %s", new Object[]{d81Var.i.a.k()});
        this.k = d81Var;
        this.j = new AtomicInteger(0);
        this.i = rfVar;
    }

    @Override // defpackage.cg
    public final void b() {
        rf rfVar = this.i;
        d81 d81Var = this.k;
        iy0 iy0Var = d81Var.g;
        d81Var.h.e.i();
        boolean z = false;
        try {
            try {
                try {
                    rfVar.onResponse(d81Var, d81Var.c());
                    iy0Var.g.f(this);
                } catch (IOException e) {
                    e = e;
                    z = true;
                    if (z) {
                        d21.a.m(4, "Callback failure for " + d81Var.d(), e);
                    } else {
                        rfVar.onFailure(d81Var, e);
                    }
                    iy0Var.g.f(this);
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    d81Var.h.a();
                    if (!z) {
                        IOException iOException = new IOException("canceled due to " + th);
                        iOException.addSuppressed(th);
                        rfVar.onFailure(d81Var, iOException);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                iy0Var.g.f(this);
                throw th2;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
