package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class r81 {
    public ow1 a;
    public ArrayList b;
    public long c;
    public long d;
    public long e;
    public long f;

    public static void b(m91 m91Var) {
        int i = m91Var.p;
        if (!m91Var.k() && (i & 4) == 0) {
            m91Var.d();
        }
    }

    public abstract boolean a(m91 m91Var, m91 m91Var2, ib ibVar, ib ibVar2);

    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.m91 r10) {
        /*
            r9 = this;
            ow1 r0 = r9.a
            if (r0 == 0) goto La4
            r1 = 1
            r10.s(r1)
            m91 r2 = r10.n
            r3 = 0
            if (r2 == 0) goto L13
            m91 r2 = r10.o
            if (r2 != 0) goto L13
            r10.n = r3
        L13:
            r10.o = r3
            int r2 = r10.p
            r2 = r2 & 16
            if (r2 == 0) goto L1d
            goto La4
        L1d:
            java.lang.Object r0 = r0.h
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r0.p0()
            ei r2 = r0.l
            java.lang.Object r3 = r2.d
            di r3 = (defpackage.di) r3
            java.lang.Object r4 = r2.c
            mc1 r4 = (defpackage.mc1) r4
            int r5 = r2.b
            r6 = 0
            android.view.View r7 = r10.g
            if (r5 != r1) goto L45
            java.lang.Object r1 = r2.f
            android.view.View r1 = (android.view.View) r1
            if (r1 != r7) goto L3d
        L3b:
            r1 = 0
            goto L70
        L3d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeView(At) for a different view"
            r10.<init>(r0)
            throw r10
        L45:
            r8 = 2
            if (r5 == r8) goto L9c
            r2.b = r8     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r5 = r4.h     // Catch: java.lang.Throwable -> L5b
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5     // Catch: java.lang.Throwable -> L5b
            int r5 = r5.indexOfChild(r7)     // Catch: java.lang.Throwable -> L5b
            r8 = -1
            if (r5 != r8) goto L5d
            r2.r(r7)     // Catch: java.lang.Throwable -> L5b
        L58:
            r2.b = r6
            goto L70
        L5b:
            r10 = move-exception
            goto L99
        L5d:
            boolean r8 = r3.d(r5)     // Catch: java.lang.Throwable -> L5b
            if (r8 == 0) goto L6d
            r3.f(r5)     // Catch: java.lang.Throwable -> L5b
            r2.r(r7)     // Catch: java.lang.Throwable -> L5b
            r4.A(r5)     // Catch: java.lang.Throwable -> L5b
            goto L58
        L6d:
            r2.b = r6
            goto L3b
        L70:
            if (r1 == 0) goto L88
            m91 r2 = androidx.recyclerview.widget.RecyclerView.Q(r7)
            c91 r3 = r0.i
            r3.l(r2)
            r3.i(r2)
            boolean r2 = androidx.recyclerview.widget.RecyclerView.H0
            if (r2 == 0) goto L88
            java.util.Objects.toString(r7)
            r0.toString()
        L88:
            r2 = r1 ^ 1
            r0.q0(r2)
            if (r1 != 0) goto La4
            boolean r10 = r10.o()
            if (r10 == 0) goto La4
            r0.removeDetachedView(r7, r6)
            return
        L99:
            r2.b = r6
            throw r10
        L9c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot call removeViewIfHidden within removeViewIfHidden"
            r10.<init>(r0)
            throw r10
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r81.c(m91):void");
    }

    public abstract void d(m91 m91Var);

    public abstract void e();

    public abstract boolean f();
}
