package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class yn1 {
    public static final xn1 d = new xn1();
    public boolean a;
    public long b;
    public long c;

    public yn1 a() {
        this.a = false;
        return this;
    }

    public yn1 b() {
        this.c = 0L;
        return this;
    }

    public long c() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public yn1 d(long j) {
        this.a = true;
        this.b = j;
        return this;
    }

    public boolean e() {
        return this.a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public yn1 g(long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (j < 0) {
            throw new IllegalArgumentException(uo.f("timeout < 0: ", j));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.c = timeUnit.toNanos(j);
        return this;
    }
}
