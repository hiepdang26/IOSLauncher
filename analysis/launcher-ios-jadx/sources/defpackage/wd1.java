package defpackage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class wd1 {
    public static final boolean a;
    public static final int b;
    public static final AtomicReference c = new AtomicReference();
    public static final ConcurrentHashMap d = new ConcurrentHashMap();

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[LOOP:0: B:19:0x0039->B:28:0x006b, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            defpackage.wd1.c = r0
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            defpackage.wd1.d = r0
            java.lang.String r0 = "rx2.purge-enabled"
            r1 = 1
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L1f
            if (r0 != 0) goto L18
            goto L1f
        L18:
            java.lang.String r2 = "true"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L1f
            goto L20
        L1f:
            r0 = 1
        L20:
            defpackage.wd1.a = r0
            java.lang.String r2 = "rx2.purge-period-seconds"
            if (r0 == 0) goto L32
            java.lang.String r0 = java.lang.System.getProperty(r2)     // Catch: java.lang.Throwable -> L32
            if (r0 != 0) goto L2d
            goto L32
        L2d:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L32
            goto L33
        L32:
            r0 = 1
        L33:
            defpackage.wd1.b = r0
            boolean r0 = defpackage.wd1.a
            if (r0 == 0) goto L6f
        L39:
            java.util.concurrent.atomic.AtomicReference r0 = defpackage.wd1.c
            java.lang.Object r2 = r0.get()
            java.util.concurrent.ScheduledExecutorService r2 = (java.util.concurrent.ScheduledExecutorService) r2
            if (r2 == 0) goto L44
            goto L6f
        L44:
            ad1 r3 = new ad1
            java.lang.String r4 = "RxSchedulerPurge"
            r3.<init>(r4)
            java.util.concurrent.ScheduledExecutorService r5 = java.util.concurrent.Executors.newScheduledThreadPool(r1, r3)
        L4f:
            boolean r3 = r0.compareAndSet(r2, r5)
            if (r3 == 0) goto L65
            n4 r6 = new n4
            r0 = 3
            r6.<init>(r0)
            int r0 = defpackage.wd1.b
            long r7 = (long) r0
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.SECONDS
            r9 = r7
            r5.scheduleAtFixedRate(r6, r7, r9, r11)
            goto L6f
        L65:
            java.lang.Object r3 = r0.get()
            if (r3 == r2) goto L4f
            r5.shutdownNow()
            goto L39
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wd1.<clinit>():void");
    }
}
