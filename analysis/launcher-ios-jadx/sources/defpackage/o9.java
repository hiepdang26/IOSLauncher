package defpackage;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class o9 extends Thread {
    public final /* synthetic */ int g = 1;

    public /* synthetic */ o9(Runnable runnable) {
        super(runnable);
    }

    private final void a() {
        Process.setThreadPriority(19);
        synchronized (this) {
            while (true) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002d, code lost:
    
        r1.m();
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r3 = this;
            int r0 = r3.g
            switch(r0) {
                case 0: goto L16;
                case 1: goto Ld;
                case 2: goto L5;
                case 3: goto L9;
                default: goto L5;
            }
        L5:
            super.run()
            return
        L9:
            r3.a()
            return
        Ld:
            r0 = 9
            android.os.Process.setThreadPriority(r0)
            super.run()
            return
        L16:
            java.lang.Class<p9> r0 = defpackage.p9.class
            monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L16
            p9 r1 = defpackage.p9.h()     // Catch: java.lang.Throwable -> L21
            if (r1 != 0) goto L23
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
            goto L16
        L21:
            r1 = move-exception
            goto L31
        L23:
            p9 r2 = defpackage.p9.j     // Catch: java.lang.Throwable -> L21
            if (r1 != r2) goto L2c
            r1 = 0
            defpackage.p9.j = r1     // Catch: java.lang.Throwable -> L21
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
            return
        L2c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
            r1.m()     // Catch: java.lang.InterruptedException -> L16
            goto L16
        L31:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
            throw r1     // Catch: java.lang.InterruptedException -> L16
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o9.run():void");
    }

    public /* synthetic */ o9(Runnable runnable, String str) {
        super(runnable, str);
    }

    public /* synthetic */ o9(String str) {
        super(str);
    }

    public /* synthetic */ o9(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
