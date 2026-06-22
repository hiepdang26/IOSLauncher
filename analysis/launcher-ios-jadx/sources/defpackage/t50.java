package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class t50 extends yn1 {
    public yn1 e;

    public t50(yn1 yn1Var) {
        if (yn1Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.e = yn1Var;
    }

    @Override // defpackage.yn1
    public final yn1 a() {
        return this.e.a();
    }

    @Override // defpackage.yn1
    public final yn1 b() {
        return this.e.b();
    }

    @Override // defpackage.yn1
    public final long c() {
        return this.e.c();
    }

    @Override // defpackage.yn1
    public final yn1 d(long j) {
        return this.e.d(j);
    }

    @Override // defpackage.yn1
    public final boolean e() {
        return this.e.e();
    }

    @Override // defpackage.yn1
    public final void f() throws InterruptedIOException {
        this.e.f();
    }

    @Override // defpackage.yn1
    public final yn1 g(long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return this.e.g(j);
    }
}
