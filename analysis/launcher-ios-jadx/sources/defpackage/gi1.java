package defpackage;

import android.os.SystemClock;
import android.util.Log;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class gi1 implements es, ds {
    public final qs g;
    public final ss h;
    public volatile int i;
    public volatile zr j;
    public volatile Object k;
    public volatile ku0 l;
    public volatile as m;

    public gi1(qs qsVar, ss ssVar) {
        this.g = qsVar;
        this.h = ssVar;
    }

    @Override // defpackage.ds
    public final void a(bj0 bj0Var, Exception exc, cs csVar, int i) {
        this.h.a(bj0Var, exc, csVar, this.l.c.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    @Override // defpackage.es
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.k
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L17
            java.lang.Object r0 = r7.k
            r7.k = r1
            boolean r0 = r7.d(r0)     // Catch: java.io.IOException -> L11
            if (r0 != 0) goto L17
            goto L23
        L11:
            java.lang.String r0 = "SourceGenerator"
            r3 = 3
            android.util.Log.isLoggable(r0, r3)
        L17:
            zr r0 = r7.j
            if (r0 == 0) goto L24
            zr r0 = r7.j
            boolean r0 = r0.b()
            if (r0 == 0) goto L24
        L23:
            return r2
        L24:
            r7.j = r1
            r7.l = r1
            r0 = 0
        L29:
            if (r0 != 0) goto L8a
            int r1 = r7.i
            qs r3 = r7.g
            java.util.ArrayList r3 = r3.b()
            int r3 = r3.size()
            if (r1 >= r3) goto L8a
            qs r1 = r7.g
            java.util.ArrayList r1 = r1.b()
            int r3 = r7.i
            int r4 = r3 + 1
            r7.i = r4
            java.lang.Object r1 = r1.get(r3)
            ku0 r1 = (defpackage.ku0) r1
            r7.l = r1
            ku0 r1 = r7.l
            if (r1 == 0) goto L29
            qs r1 = r7.g
            qv r1 = r1.p
            ku0 r3 = r7.l
            cs r3 = r3.c
            int r3 = r3.d()
            boolean r1 = r1.a(r3)
            if (r1 != 0) goto L73
            qs r1 = r7.g
            ku0 r3 = r7.l
            cs r3 = r3.c
            java.lang.Class r3 = r3.a()
            yo0 r1 = r1.c(r3)
            if (r1 == 0) goto L29
        L73:
            ku0 r0 = r7.l
            ku0 r1 = r7.l
            cs r1 = r1.c
            qs r3 = r7.g
            j31 r3 = r3.o
            q11 r4 = new q11
            r5 = 20
            r6 = 0
            r4.<init>(r7, r0, r5, r6)
            r1.c(r3, r4)
            r0 = 1
            goto L29
        L8a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gi1.b():boolean");
    }

    @Override // defpackage.ds
    public final void c(bj0 bj0Var, Object obj, cs csVar, int i, bj0 bj0Var2) {
        this.h.c(bj0Var, obj, csVar, this.l.c.d(), bj0Var);
    }

    @Override // defpackage.es
    public final void cancel() {
        ku0 ku0Var = this.l;
        if (ku0Var != null) {
            ku0Var.c.cancel();
        }
    }

    public final boolean d(Object obj) throws Throwable {
        Throwable th;
        int i = tp0.a;
        SystemClock.elapsedRealtimeNanos();
        boolean z = false;
        try {
            gs gsVarH = this.g.c.b().h(obj);
            Object objR = gsVarH.r();
            zz zzVarD = this.g.d(objR);
            wb2 wb2Var = new wb2(zzVarD, objR, this.g.i, 7);
            bj0 bj0Var = this.l.a;
            qs qsVar = this.g;
            as asVar = new as(bj0Var, qsVar.n);
            pv pvVarA = qsVar.h.a();
            pvVarA.i(asVar, wb2Var);
            if (Log.isLoggable("SourceGenerator", 2)) {
                asVar.toString();
                obj.toString();
                zzVarD.toString();
                SystemClock.elapsedRealtimeNanos();
            }
            if (pvVarA.e(asVar) != null) {
                this.m = asVar;
                this.j = new zr(Collections.singletonList(this.l.a), this.g, this);
                this.l.c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Objects.toString(this.m);
                obj.toString();
            }
            try {
                this.h.c(this.l.a, gsVarH.r(), this.l.c, this.l.c.d(), this.l.a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
                if (z) {
                    throw th;
                }
                this.l.c.b();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
