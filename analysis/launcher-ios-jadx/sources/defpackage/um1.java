package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class um1 {
    public static final String a;
    public static final long b;
    public static final int c;
    public static final int d;
    public static final long e;
    public static final jl1 f;
    public static final cx g;
    public static final cx h;

    static {
        String property;
        int i = ul1.a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        a = property;
        b = e42.s("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i2 = ul1.a;
        if (i2 < 2) {
            i2 = 2;
        }
        c = e42.t(i2, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        d = e42.t(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        e = TimeUnit.SECONDS.toNanos(e42.s("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f = jl1.j;
        g = new cx(0);
        h = new cx(1);
    }
}
