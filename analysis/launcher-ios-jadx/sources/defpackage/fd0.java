package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class fd0 implements ih1, AutoCloseable {
    public final fe g = new fe();
    public boolean h;
    public boolean i;
    public final /* synthetic */ id0 j;

    public fd0(id0 id0Var) {
        this.j = id0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r13) {
        /*
            r12 = this;
            id0 r1 = r12.j
            monitor-enter(r1)
            id0 r0 = r12.j     // Catch: java.lang.Throwable -> L77
            hd0 r0 = r0.j     // Catch: java.lang.Throwable -> L77
            r0.i()     // Catch: java.lang.Throwable -> L77
        La:
            id0 r0 = r12.j     // Catch: java.lang.Throwable -> L24
            long r2 = r0.b     // Catch: java.lang.Throwable -> L24
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L27
            boolean r2 = r12.i     // Catch: java.lang.Throwable -> L24
            if (r2 != 0) goto L27
            boolean r2 = r12.h     // Catch: java.lang.Throwable -> L24
            if (r2 != 0) goto L27
            int r2 = r0.k     // Catch: java.lang.Throwable -> L24
            if (r2 != 0) goto L27
            r0.k()     // Catch: java.lang.Throwable -> L24
            goto La
        L24:
            r0 = move-exception
            r13 = r0
            goto L7a
        L27:
            hd0 r0 = r0.j     // Catch: java.lang.Throwable -> L77
            r0.n()     // Catch: java.lang.Throwable -> L77
            id0 r0 = r12.j     // Catch: java.lang.Throwable -> L77
            r0.b()     // Catch: java.lang.Throwable -> L77
            id0 r0 = r12.j     // Catch: java.lang.Throwable -> L77
            long r2 = r0.b     // Catch: java.lang.Throwable -> L77
            fe r0 = r12.g     // Catch: java.lang.Throwable -> L77
            long r4 = r0.h     // Catch: java.lang.Throwable -> L77
            long r10 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L77
            id0 r0 = r12.j     // Catch: java.lang.Throwable -> L77
            long r2 = r0.b     // Catch: java.lang.Throwable -> L77
            long r2 = r2 - r10
            r0.b = r2     // Catch: java.lang.Throwable -> L77
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L77
            hd0 r0 = r0.j
            r0.i()
            if (r13 == 0) goto L5a
            fe r13 = r12.g     // Catch: java.lang.Throwable -> L57
            long r0 = r13.h     // Catch: java.lang.Throwable -> L57
            int r13 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r13 != 0) goto L5a
            r13 = 1
            r8 = 1
            goto L5c
        L57:
            r0 = move-exception
            r13 = r0
            goto L6f
        L5a:
            r13 = 0
            r8 = 0
        L5c:
            id0 r13 = r12.j     // Catch: java.lang.Throwable -> L57
            bd0 r6 = r13.d     // Catch: java.lang.Throwable -> L57
            int r7 = r13.c     // Catch: java.lang.Throwable -> L57
            fe r9 = r12.g     // Catch: java.lang.Throwable -> L57
            r6.A(r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L57
            id0 r13 = r12.j
            hd0 r13 = r13.j
            r13.n()
            return
        L6f:
            id0 r0 = r12.j
            hd0 r0 = r0.j
            r0.n()
            throw r13
        L77:
            r0 = move-exception
            r13 = r0
            goto L82
        L7a:
            id0 r0 = r12.j     // Catch: java.lang.Throwable -> L77
            hd0 r0 = r0.j     // Catch: java.lang.Throwable -> L77
            r0.n()     // Catch: java.lang.Throwable -> L77
            throw r13     // Catch: java.lang.Throwable -> L77
        L82:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L77
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fd0.a(boolean):void");
    }

    @Override // defpackage.ih1
    public final void c(fe feVar, long j) {
        fe feVar2 = this.g;
        feVar2.c(feVar, j);
        while (feVar2.h >= 16384) {
            a(false);
        }
    }

    @Override // defpackage.ih1, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        synchronized (this.j) {
            try {
                if (this.h) {
                    return;
                }
                id0 id0Var = this.j;
                if (!id0Var.h.i) {
                    if (this.g.h > 0) {
                        while (this.g.h > 0) {
                            a(true);
                        }
                    } else {
                        id0Var.d.A(id0Var.c, true, null, 0L);
                    }
                }
                synchronized (this.j) {
                    this.h = true;
                }
                this.j.d.flush();
                this.j.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ih1, java.io.Flushable
    public final void flush() {
        synchronized (this.j) {
            this.j.b();
        }
        while (this.g.h > 0) {
            a(false);
            this.j.d.flush();
        }
    }

    @Override // defpackage.ih1
    public final yn1 timeout() {
        return this.j.j;
    }
}
