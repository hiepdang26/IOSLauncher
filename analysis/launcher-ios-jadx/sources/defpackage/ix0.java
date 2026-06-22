package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class ix0 {
    public static final /* synthetic */ int a = 0;

    static {
        qg0.k(ka0.r("NetworkStateTracker"), "tagWithPrefix(\"NetworkStateTracker\")");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final defpackage.fx0 a(android.net.ConnectivityManager r6) {
        /*
            java.lang.String r0 = "<this>"
            defpackage.qg0.l(r6, r0)
            android.net.NetworkInfo r0 = r6.getActiveNetworkInfo()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L15
            boolean r3 = r0.isConnected()
            if (r3 == 0) goto L15
            r3 = 1
            goto L16
        L15:
            r3 = 0
        L16:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 >= r5) goto L1e
        L1c:
            r4 = 0
            goto L37
        L1e:
            android.net.Network r4 = defpackage.ax0.a(r6)     // Catch: java.lang.SecurityException -> L2f
            android.net.NetworkCapabilities r4 = defpackage.zw0.a(r6, r4)     // Catch: java.lang.SecurityException -> L2f
            if (r4 == 0) goto L1c
            r5 = 16
            boolean r4 = defpackage.zw0.b(r4, r5)     // Catch: java.lang.SecurityException -> L2f
            goto L37
        L2f:
            ka0 r4 = defpackage.ka0.j()
            r4.getClass()
            goto L1c
        L37:
            boolean r6 = r6.isActiveNetworkMetered()
            if (r0 == 0) goto L44
            boolean r0 = r0.isRoaming()
            if (r0 != 0) goto L44
            goto L45
        L44:
            r1 = 0
        L45:
            fx0 r0 = new fx0
            r0.<init>(r3, r4, r6, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ix0.a(android.net.ConnectivityManager):fx0");
    }
}
