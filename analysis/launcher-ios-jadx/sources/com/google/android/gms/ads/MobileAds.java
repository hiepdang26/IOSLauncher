package com.google.android.gms.ads;

import android.os.RemoteException;
import defpackage.k92;
import defpackage.l72;
import defpackage.t92;

/* JADX INFO: loaded from: classes.dex */
public class MobileAds {
    /* JADX WARN: Removed duplicated region for block: B:32:0x0097 A[Catch: all -> 0x005d, TryCatch #2 {, blocks: (B:21:0x0033, B:27:0x0063, B:29:0x0074, B:31:0x0086, B:38:0x00cb, B:32:0x0097, B:34:0x00a5, B:36:0x00b7, B:37:0x00c3, B:26:0x0060), top: B:47:0x0033, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3 A[Catch: all -> 0x005d, TryCatch #2 {, blocks: (B:21:0x0033, B:27:0x0063, B:29:0x0074, B:31:0x0086, B:38:0x00cb, B:32:0x0097, B:34:0x00a5, B:36:0x00b7, B:37:0x00c3, B:26:0x0060), top: B:47:0x0033, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(final android.content.Context r4, defpackage.pf1 r5) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.MobileAds.a(android.content.Context, pf1):void");
    }

    private static void setPlugin(String str) {
        t92 t92VarF = t92.f();
        synchronized (t92VarF.d) {
            l72 l72Var = (l72) t92VarF.f;
            if (!(l72Var != null)) {
                throw new IllegalStateException("MobileAds.initialize() must be called prior to setting the plugin.");
            }
            try {
                l72Var.zzt(str);
            } catch (RemoteException unused) {
                k92.f();
            }
        }
    }
}
