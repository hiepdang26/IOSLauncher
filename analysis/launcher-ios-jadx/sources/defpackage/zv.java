package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public abstract class zv extends om1 {
    public int i;

    public zv(int i) {
        super(0L, um1.g);
        this.i = i;
    }

    public abstract void b(Object obj, CancellationException cancellationException);

    public abstract eo c();

    public Throwable d(Object obj) {
        uk ukVar = obj instanceof uk ? (uk) obj : null;
        if (ukVar != null) {
            return ukVar.a;
        }
        return null;
    }

    public final void f(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            qg0.b(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        qg0.h(th);
        os.h(c().getContext(), new lp("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object g();

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r12 = this;
            zp1 r0 = defpackage.zp1.a
            cx r1 = r12.h
            eo r2 = r12.c()     // Catch: java.lang.Throwable -> L87
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            defpackage.qg0.i(r2, r3)     // Catch: java.lang.Throwable -> L87
            yv r2 = (defpackage.yv) r2     // Catch: java.lang.Throwable -> L87
            go r3 = r2.k     // Catch: java.lang.Throwable -> L87
            java.lang.Object r2 = r2.m     // Catch: java.lang.Throwable -> L87
            yo r4 = r3.getContext()     // Catch: java.lang.Throwable -> L87
            java.lang.Object r2 = defpackage.bf1.A(r4, r2)     // Catch: java.lang.Throwable -> L87
            wg1 r5 = defpackage.bf1.f     // Catch: java.lang.Throwable -> L87
            if (r2 == r5) goto L22
            defpackage.e42.u(r3, r4)     // Catch: java.lang.Throwable -> L87
        L22:
            yo r5 = r3.getContext()     // Catch: java.lang.Throwable -> L46
            java.lang.Object r6 = r12.g()     // Catch: java.lang.Throwable -> L46
            java.lang.Throwable r7 = r12.d(r6)     // Catch: java.lang.Throwable -> L46
            r8 = 0
            if (r7 != 0) goto L48
            int r9 = r12.i     // Catch: java.lang.Throwable -> L46
            r10 = 1
            if (r9 == r10) goto L3b
            r11 = 2
            if (r9 != r11) goto L3a
            goto L3b
        L3a:
            r10 = 0
        L3b:
            if (r10 == 0) goto L48
            iy r9 = defpackage.iy.i     // Catch: java.lang.Throwable -> L46
            wo r5 = r5.n(r9)     // Catch: java.lang.Throwable -> L46
            fi0 r5 = (defpackage.fi0) r5     // Catch: java.lang.Throwable -> L46
            goto L49
        L46:
            r3 = move-exception
            goto L89
        L48:
            r5 = r8
        L49:
            if (r5 == 0) goto L62
            boolean r9 = r5.a()     // Catch: java.lang.Throwable -> L46
            if (r9 != 0) goto L62
            xi0 r5 = (defpackage.xi0) r5     // Catch: java.lang.Throwable -> L46
            java.util.concurrent.CancellationException r5 = r5.w()     // Catch: java.lang.Throwable -> L46
            r12.b(r6, r5)     // Catch: java.lang.Throwable -> L46
            xb1 r5 = defpackage.np1.e(r5)     // Catch: java.lang.Throwable -> L46
            r3.resumeWith(r5)     // Catch: java.lang.Throwable -> L46
            goto L73
        L62:
            if (r7 == 0) goto L6c
            xb1 r5 = defpackage.np1.e(r7)     // Catch: java.lang.Throwable -> L46
            r3.resumeWith(r5)     // Catch: java.lang.Throwable -> L46
            goto L73
        L6c:
            java.lang.Object r5 = r12.e(r6)     // Catch: java.lang.Throwable -> L46
            r3.resumeWith(r5)     // Catch: java.lang.Throwable -> L46
        L73:
            defpackage.bf1.t(r4, r2)     // Catch: java.lang.Throwable -> L87
            r1.getClass()     // Catch: java.lang.Throwable -> L7a
            goto L7f
        L7a:
            r0 = move-exception
            xb1 r0 = defpackage.np1.e(r0)
        L7f:
            java.lang.Throwable r0 = defpackage.yb1.a(r0)
            r12.f(r8, r0)
            goto L9d
        L87:
            r2 = move-exception
            goto L8d
        L89:
            defpackage.bf1.t(r4, r2)     // Catch: java.lang.Throwable -> L87
            throw r3     // Catch: java.lang.Throwable -> L87
        L8d:
            r1.getClass()     // Catch: java.lang.Throwable -> L91
            goto L96
        L91:
            r0 = move-exception
            xb1 r0 = defpackage.np1.e(r0)
        L96:
            java.lang.Throwable r0 = defpackage.yb1.a(r0)
            r12.f(r2, r0)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zv.run():void");
    }

    public Object e(Object obj) {
        return obj;
    }
}
