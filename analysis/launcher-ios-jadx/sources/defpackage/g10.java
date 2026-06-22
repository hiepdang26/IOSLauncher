package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class g10 {
    public final hp1 a;
    public final c3 b;
    public final f81 c;
    public final iy d;
    public t3 e;
    public final vc1 f;
    public e81 g;
    public boolean h;
    public tc1 i;

    public g10(hp1 hp1Var, f81 f81Var, c3 c3Var, d81 d81Var, iy iyVar) {
        this.a = hp1Var;
        this.c = f81Var;
        this.b = c3Var;
        this.d = iyVar;
        this.f = new vc1(c3Var, f81Var.e, d81Var, iyVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.e81 a(boolean r17, int r18, int r19, int r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g10.a(boolean, int, int, int):e81");
    }

    public final e81 b(int i, int i2, int i3, boolean z, boolean z2) throws Throwable {
        while (true) {
            e81 e81VarA = a(z, i, i2, i3);
            synchronized (this.c) {
                try {
                    if (e81VarA.m == 0) {
                        if (!(e81VarA.h != null)) {
                            return e81VarA;
                        }
                    }
                    if (e81VarA.g(z2)) {
                        return e81VarA;
                    }
                    e81VarA.i();
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0032 A[Catch: all -> 0x000a, TryCatch #0 {all -> 0x000a, blocks: (B:4:0x0003, B:6:0x0008, B:10:0x000c, B:12:0x0012, B:13:0x001a, B:15:0x001c, B:17:0x0021, B:32:0x004e, B:22:0x0032, B:25:0x003f), top: B:36:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r6 = this;
            f81 r0 = r6.c
            monitor-enter(r0)
            tc1 r1 = r6.i     // Catch: java.lang.Throwable -> La
            r2 = 1
            if (r1 == 0) goto Lc
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La
            return r2
        La:
            r1 = move-exception
            goto L50
        Lc:
            boolean r1 = r6.d()     // Catch: java.lang.Throwable -> La
            if (r1 == 0) goto L1c
            hp1 r1 = r6.a     // Catch: java.lang.Throwable -> La
            e81 r1 = r1.i     // Catch: java.lang.Throwable -> La
            tc1 r1 = r1.c     // Catch: java.lang.Throwable -> La
            r6.i = r1     // Catch: java.lang.Throwable -> La
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La
            return r2
        L1c:
            t3 r1 = r6.e     // Catch: java.lang.Throwable -> La
            r3 = 0
            if (r1 == 0) goto L32
            int r4 = r1.g     // Catch: java.lang.Throwable -> La
            java.lang.Object r1 = r1.h     // Catch: java.lang.Throwable -> La
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Throwable -> La
            int r1 = r1.size()     // Catch: java.lang.Throwable -> La
            if (r4 >= r1) goto L2f
            r1 = 1
            goto L30
        L2f:
            r1 = 0
        L30:
            if (r1 != 0) goto L4e
        L32:
            vc1 r1 = r6.f     // Catch: java.lang.Throwable -> La
            int r4 = r1.e     // Catch: java.lang.Throwable -> La
            java.util.List r5 = r1.d     // Catch: java.lang.Throwable -> La
            int r5 = r5.size()     // Catch: java.lang.Throwable -> La
            if (r4 >= r5) goto L3f
            goto L47
        L3f:
            java.util.ArrayList r1 = r1.g     // Catch: java.lang.Throwable -> La
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> La
            if (r1 != 0) goto L49
        L47:
            r1 = 1
            goto L4a
        L49:
            r1 = 0
        L4a:
            if (r1 == 0) goto L4d
            goto L4e
        L4d:
            r2 = 0
        L4e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La
            return r2
        L50:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g10.c():boolean");
    }

    public final boolean d() {
        e81 e81Var = this.a.i;
        return e81Var != null && e81Var.l == 0 && wq1.o(e81Var.c.a.a, this.b.a);
    }

    public final void e() {
        synchronized (this.c) {
            this.h = true;
        }
    }
}
