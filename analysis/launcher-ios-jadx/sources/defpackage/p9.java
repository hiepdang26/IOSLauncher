package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class p9 extends yn1 {
    public static final long h;
    public static final long i;
    public static p9 j;
    public boolean e;
    public p9 f;
    public long g;

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        h = millis;
        i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static p9 h() throws InterruptedException {
        p9 p9Var = j.f;
        if (p9Var == null) {
            long jNanoTime = System.nanoTime();
            p9.class.wait(h);
            if (j.f != null || System.nanoTime() - jNanoTime < i) {
                return null;
            }
            return j;
        }
        long jNanoTime2 = p9Var.g - System.nanoTime();
        if (jNanoTime2 > 0) {
            long j2 = jNanoTime2 / 1000000;
            p9.class.wait(j2, (int) (jNanoTime2 - (1000000 * j2)));
            return null;
        }
        j.f = p9Var.f;
        p9Var.f = null;
        return p9Var;
    }

    public final void i() {
        p9 p9Var;
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long j2 = this.c;
        boolean z = this.a;
        if (j2 != 0 || z) {
            this.e = true;
            synchronized (p9.class) {
                try {
                    if (j == null) {
                        j = new p9();
                        o9 o9Var = new o9("Okio Watchdog");
                        o9Var.setDaemon(true);
                        o9Var.start();
                    }
                    long jNanoTime = System.nanoTime();
                    if (j2 != 0 && z) {
                        this.g = Math.min(j2, c() - jNanoTime) + jNanoTime;
                    } else if (j2 != 0) {
                        this.g = j2 + jNanoTime;
                    } else {
                        if (!z) {
                            throw new AssertionError();
                        }
                        this.g = c();
                    }
                    long j3 = this.g - jNanoTime;
                    p9 p9Var2 = j;
                    while (true) {
                        p9Var = p9Var2.f;
                        if (p9Var == null || j3 < p9Var.g - jNanoTime) {
                            break;
                        } else {
                            p9Var2 = p9Var;
                        }
                    }
                    this.f = p9Var;
                    p9Var2.f = this;
                    if (p9Var2 == j) {
                        p9.class.notify();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void j(boolean z) throws IOException {
        if (k() && z) {
            throw l(null);
        }
    }

    public final boolean k() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        synchronized (p9.class) {
            p9 p9Var = j;
            while (p9Var != null) {
                p9 p9Var2 = p9Var.f;
                if (p9Var2 == this) {
                    p9Var.f = this.f;
                    this.f = null;
                    return false;
                }
                p9Var = p9Var2;
            }
            return true;
        }
    }

    public IOException l(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void m() {
    }
}
