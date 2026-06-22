package defpackage;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.TopicsManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class lo1 {
    public final TopicsManager a;

    public lo1(TopicsManager topicsManager) {
        qg0.l(topicsManager, "mTopicsManager");
        this.a = topicsManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object c(defpackage.lo1 r6, defpackage.j80 r7, defpackage.eo r8) {
        /*
            boolean r0 = r8 instanceof defpackage.ko1
            if (r0 == 0) goto L13
            r0 = r8
            ko1 r0 = (defpackage.ko1) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            ko1 r0 = new ko1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.h
            hp r1 = defpackage.hp.g
            int r2 = r0.j
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            lo1 r6 = r0.g
            defpackage.np1.I(r8)
            goto L5f
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            defpackage.np1.I(r8)
            android.adservices.topics.GetTopicsRequest r7 = r6.a(r7)
            r0.g = r6
            r0.j = r3
            gg r8 = new gg
            eo r0 = defpackage.e42.d(r0)
            r8.<init>(r3, r0)
            r8.o()
            android.adservices.topics.TopicsManager r0 = r6.a
            t8 r2 = new t8
            r3 = 1
            r2.<init>(r3)
            io r3 = new io
            r3.<init>(r8)
            defpackage.o7.s(r0, r7, r2, r3)
            java.lang.Object r8 = r8.n()
            if (r8 != r1) goto L5f
            return r1
        L5f:
            android.adservices.topics.GetTopicsResponse r7 = defpackage.o7.i(r8)
            r6.getClass()
            java.lang.String r6 = "response"
            defpackage.qg0.l(r7, r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r7 = defpackage.o7.n(r7)
            java.util.Iterator r7 = r7.iterator()
        L78:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L9b
            java.lang.Object r8 = r7.next()
            android.adservices.topics.Topic r8 = defpackage.o7.j(r8)
            go1 r0 = new go1
            long r1 = defpackage.o7.c(r8)
            long r3 = defpackage.o7.t(r8)
            int r5 = defpackage.o7.b(r8)
            r0.<init>(r1, r3, r5)
            r6.add(r0)
            goto L78
        L9b:
            k80 r7 = new k80
            r7.<init>(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lo1.c(lo1, j80, eo):java.lang.Object");
    }

    public GetTopicsRequest a(j80 j80Var) {
        qg0.l(j80Var, "request");
        GetTopicsRequest getTopicsRequestBuild = o7.e().setAdsSdkName("com.google.android.gms.ads").build();
        qg0.k(getTopicsRequestBuild, "Builder()\n            .s…ame)\n            .build()");
        return getTopicsRequestBuild;
    }

    public Object b(j80 j80Var, eo eoVar) {
        return c(this, j80Var, eoVar);
    }
}
