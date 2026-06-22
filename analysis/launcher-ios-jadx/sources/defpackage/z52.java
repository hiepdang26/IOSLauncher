package defpackage;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class z52 {
    public long a;
    public long b = Long.MIN_VALUE;
    public final Object c = new Object();

    public z52(long j) {
        this.a = j;
    }

    public final boolean a() {
        synchronized (this.c) {
            try {
                hd2.B.j.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (this.b + this.a > jElapsedRealtime) {
                    return false;
                }
                this.b = jElapsedRealtime;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
