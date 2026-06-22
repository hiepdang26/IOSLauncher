package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzbvg implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbvi zzb;

    public zzbvg(zzbvi zzbviVar, Context context) {
        this.zza = context;
        this.zzb = zzbviVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object call() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbvi r0 = r6.zzb
            java.util.WeakHashMap r0 = com.google.android.gms.internal.ads.zzbvi.zza(r0)
            android.content.Context r1 = r6.zza
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.ads.zzbvh r0 = (com.google.android.gms.internal.ads.zzbvh) r0
            if (r0 == 0) goto L3d
            com.google.android.gms.internal.ads.zzbdc r1 = com.google.android.gms.internal.ads.zzbdh.zza
            java.lang.Object r1 = r1.zze()
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r3 = r0.zza
            long r3 = r3 + r1
            hd2 r1 = defpackage.hd2.B
            us r1 = r1.j
            r1.getClass()
            long r1 = java.lang.System.currentTimeMillis()
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto L2f
            goto L3d
        L2f:
            android.content.Context r1 = r6.zza
            com.google.android.gms.internal.ads.zzbvf r0 = r0.zzb
            com.google.android.gms.internal.ads.zzbve r2 = new com.google.android.gms.internal.ads.zzbve
            r2.<init>(r1, r0)
            com.google.android.gms.internal.ads.zzbvf r0 = r2.zza()
            goto L48
        L3d:
            android.content.Context r0 = r6.zza
            com.google.android.gms.internal.ads.zzbve r1 = new com.google.android.gms.internal.ads.zzbve
            r1.<init>(r0)
            com.google.android.gms.internal.ads.zzbvf r0 = r1.zza()
        L48:
            com.google.android.gms.internal.ads.zzbvi r1 = r6.zzb
            android.content.Context r2 = r6.zza
            java.util.WeakHashMap r3 = com.google.android.gms.internal.ads.zzbvi.zza(r1)
            com.google.android.gms.internal.ads.zzbvh r4 = new com.google.android.gms.internal.ads.zzbvh
            r4.<init>(r1, r0)
            r3.put(r2, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvg.call():java.lang.Object");
    }
}
