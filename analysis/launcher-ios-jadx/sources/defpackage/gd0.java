package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class gd0 implements fi1, AutoCloseable {
    public final fe g = new fe();
    public final fe h = new fe();
    public final long i;
    public boolean j;
    public boolean k;
    public final /* synthetic */ id0 l;

    public gd0(id0 id0Var, long j) {
        this.l = id0Var;
        this.i = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j;
        synchronized (this.l) {
            this.j = true;
            fe feVar = this.h;
            j = feVar.h;
            feVar.a();
            this.l.notifyAll();
        }
        if (j > 0) {
            this.l.d.z(j);
        }
        this.l.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    @Override // defpackage.fi1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long read(defpackage.fe r12, long r13) throws java.lang.Throwable {
        /*
            r11 = this;
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 < 0) goto La8
        L6:
            id0 r2 = r11.l
            monitor-enter(r2)
            id0 r3 = r11.l     // Catch: java.lang.Throwable -> L7b
            hd0 r3 = r3.i     // Catch: java.lang.Throwable -> L7b
            r3.i()     // Catch: java.lang.Throwable -> L7b
            id0 r3 = r11.l     // Catch: java.lang.Throwable -> L25
            int r4 = r3.k     // Catch: java.lang.Throwable -> L25
            if (r4 == 0) goto L28
            java.io.IOException r3 = r3.l     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L1b
            goto L29
        L1b:
            vj1 r3 = new vj1     // Catch: java.lang.Throwable -> L25
            id0 r4 = r11.l     // Catch: java.lang.Throwable -> L25
            int r4 = r4.k     // Catch: java.lang.Throwable -> L25
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L25
            goto L29
        L25:
            r12 = move-exception
            goto L9e
        L28:
            r3 = 0
        L29:
            boolean r4 = r11.j     // Catch: java.lang.Throwable -> L25
            if (r4 != 0) goto L96
            fe r4 = r11.h     // Catch: java.lang.Throwable -> L25
            long r5 = r4.h     // Catch: java.lang.Throwable -> L25
            r7 = -1
            int r9 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r9 <= 0) goto L67
            long r13 = java.lang.Math.min(r13, r5)     // Catch: java.lang.Throwable -> L25
            long r12 = r4.read(r12, r13)     // Catch: java.lang.Throwable -> L25
            id0 r14 = r11.l     // Catch: java.lang.Throwable -> L25
            long r4 = r14.a     // Catch: java.lang.Throwable -> L25
            long r4 = r4 + r12
            r14.a = r4     // Catch: java.lang.Throwable -> L25
            if (r3 != 0) goto L7e
            bd0 r14 = r14.d     // Catch: java.lang.Throwable -> L25
            t3 r14 = r14.w     // Catch: java.lang.Throwable -> L25
            int r14 = r14.e()     // Catch: java.lang.Throwable -> L25
            int r14 = r14 / 2
            long r9 = (long) r14     // Catch: java.lang.Throwable -> L25
            int r14 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r14 < 0) goto L7e
            id0 r14 = r11.l     // Catch: java.lang.Throwable -> L25
            bd0 r4 = r14.d     // Catch: java.lang.Throwable -> L25
            int r5 = r14.c     // Catch: java.lang.Throwable -> L25
            long r9 = r14.a     // Catch: java.lang.Throwable -> L25
            r4.C(r5, r9)     // Catch: java.lang.Throwable -> L25
            id0 r14 = r11.l     // Catch: java.lang.Throwable -> L25
            r14.a = r0     // Catch: java.lang.Throwable -> L25
            goto L7e
        L67:
            boolean r4 = r11.k     // Catch: java.lang.Throwable -> L25
            if (r4 != 0) goto L7d
            if (r3 != 0) goto L7d
            id0 r3 = r11.l     // Catch: java.lang.Throwable -> L25
            r3.k()     // Catch: java.lang.Throwable -> L25
            id0 r3 = r11.l     // Catch: java.lang.Throwable -> L7b
            hd0 r3 = r3.i     // Catch: java.lang.Throwable -> L7b
            r3.n()     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7b
            goto L6
        L7b:
            r12 = move-exception
            goto La6
        L7d:
            r12 = r7
        L7e:
            id0 r14 = r11.l     // Catch: java.lang.Throwable -> L7b
            hd0 r14 = r14.i     // Catch: java.lang.Throwable -> L7b
            r14.n()     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7b
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 == 0) goto L92
            id0 r14 = r11.l
            bd0 r14 = r14.d
            r14.z(r12)
            return r12
        L92:
            if (r3 != 0) goto L95
            return r7
        L95:
            throw r3
        L96:
            java.io.IOException r12 = new java.io.IOException     // Catch: java.lang.Throwable -> L25
            java.lang.String r13 = "stream closed"
            r12.<init>(r13)     // Catch: java.lang.Throwable -> L25
            throw r12     // Catch: java.lang.Throwable -> L25
        L9e:
            id0 r13 = r11.l     // Catch: java.lang.Throwable -> L7b
            hd0 r13 = r13.i     // Catch: java.lang.Throwable -> L7b
            r13.n()     // Catch: java.lang.Throwable -> L7b
            throw r12     // Catch: java.lang.Throwable -> L7b
        La6:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7b
            throw r12
        La8:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "byteCount < 0: "
            java.lang.String r13 = defpackage.uo.f(r0, r13)
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gd0.read(fe, long):long");
    }

    @Override // defpackage.fi1
    public final yn1 timeout() {
        return this.l.i;
    }
}
