package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class nf1 extends p {
    public final boolean i(Object obj) {
        if (obj == null) {
            obj = p.m;
        }
        if (!p.l.d(this, null, obj)) {
            return false;
        }
        p.b(this);
        return true;
    }

    public final boolean j(Throwable th) {
        if (!p.l.d(this, null, new j(th))) {
            return false;
        }
        p.b(this);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(defpackage.do0 r6) {
        /*
            r5 = this;
            r6.getClass()
            java.lang.Object r0 = r5.g
            r1 = 0
            if (r0 != 0) goto L44
            boolean r0 = r6.isDone()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L20
            java.lang.Object r6 = defpackage.p.e(r6)
            hg0 r0 = defpackage.p.l
            boolean r6 = r0.d(r5, r3, r6)
            if (r6 == 0) goto L4f
            defpackage.p.b(r5)
            return r2
        L20:
            m r0 = new m
            r0.<init>(r5, r6)
            hg0 r4 = defpackage.p.l
            boolean r3 = r4.d(r5, r3, r0)
            if (r3 == 0) goto L42
            hv r1 = defpackage.hv.g     // Catch: java.lang.Throwable -> L33
            r6.addListener(r0, r1)     // Catch: java.lang.Throwable -> L33
            return r2
        L33:
            r6 = move-exception
            j r1 = new j     // Catch: java.lang.Throwable -> L3a
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            goto L3c
        L3a:
            j r1 = defpackage.j.b
        L3c:
            hg0 r6 = defpackage.p.l
            r6.d(r5, r0, r1)
            return r2
        L42:
            java.lang.Object r0 = r5.g
        L44:
            boolean r2 = r0 instanceof defpackage.h
            if (r2 == 0) goto L4f
            h r0 = (defpackage.h) r0
            boolean r0 = r0.a
            r6.cancel(r0)
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf1.k(do0):boolean");
    }
}
