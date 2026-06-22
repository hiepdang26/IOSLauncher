package defpackage;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class d81 implements of {
    public final iy0 g;
    public hp1 h;
    public final ia1 i;
    public boolean j;

    public d81(iy0 iy0Var, ia1 ia1Var) {
        this.g = iy0Var;
        this.i = ia1Var;
    }

    public final void a(rf rfVar) {
        synchronized (this) {
            if (this.j) {
                throw new IllegalStateException("Already Executed");
            }
            this.j = true;
        }
        hp1 hp1Var = this.h;
        hp1Var.getClass();
        hp1Var.f = d21.a.k();
        hp1Var.d.getClass();
        this.g.g.b(new c81(this, rfVar));
    }

    public final tb1 b() {
        synchronized (this) {
            if (this.j) {
                throw new IllegalStateException("Already Executed");
            }
            this.j = true;
        }
        this.h.e.i();
        hp1 hp1Var = this.h;
        hp1Var.getClass();
        hp1Var.f = d21.a.k();
        hp1Var.d.getClass();
        try {
            this.g.g.c(this);
            return c();
        } finally {
            ol1 ol1Var = this.g.g;
            ol1Var.g((ArrayDeque) ol1Var.j, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.tb1 c() {
        /*
            r10 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            iy0 r0 = r10.g
            java.util.List r2 = r0.j
            r1.addAll(r2)
            xd r2 = new xd
            r3 = 1
            r2.<init>(r0, r3)
            r1.add(r2)
            xd r2 = new xd
            ka0 r3 = r0.n
            r4 = 0
            r2.<init>(r3, r4)
            r1.add(r2)
            if r2 = new if
            r3 = 0
            r2.<init>(r3)
            r1.add(r2)
            if r2 = new if
            r3 = 2
            r2.<init>(r3)
            r1.add(r2)
            java.util.List r2 = r0.k
            r1.addAll(r2)
            if r2 = new if
            r3 = 1
            r2.<init>(r3)
            r1.add(r2)
            r2 = r0
            g81 r0 = new g81
            r3 = r2
            hp1 r2 = r10.h
            r4 = r3
            r3 = 0
            r5 = r4
            r4 = 0
            r6 = r5
            ia1 r5 = r10.i
            int r7 = r6.A
            int r8 = r6.B
            int r9 = r6.C
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = 0
            r2 = 0
            tb1 r0 = r0.a(r5)     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L78
            hp1 r3 = r6.h     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L78
            boolean r3 = r3.d()     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L78
            if (r3 != 0) goto L6b
            hp1 r2 = r6.h
            r2.f(r1)
            return r0
        L6b:
            defpackage.wq1.c(r0)     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L78
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L78
            java.lang.String r3 = "Canceled"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L78
            throw r0     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L78
        L76:
            r0 = move-exception
            goto L81
        L78:
            r0 = move-exception
            r2 = 1
            hp1 r3 = r6.h     // Catch: java.lang.Throwable -> L76
            java.io.IOException r0 = r3.f(r0)     // Catch: java.lang.Throwable -> L76
            throw r0     // Catch: java.lang.Throwable -> L76
        L81:
            if (r2 != 0) goto L88
            hp1 r2 = r6.h
            r2.f(r1)
        L88:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d81.c():tb1");
    }

    public final Object clone() {
        iy0 iy0Var = this.g;
        d81 d81Var = new d81(iy0Var, this.i);
        d81Var.h = new hp1(iy0Var, d81Var);
        return d81Var;
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.h.d() ? "canceled " : "");
        sb.append("call");
        sb.append(" to ");
        sb.append(this.i.a.k());
        return sb.toString();
    }
}
