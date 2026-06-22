package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpy {
    private final Map zza = new HashMap();

    public final synchronized zzdpx zza(String str) {
        return (zzdpx) this.zza.get(str);
    }

    public final String zzb(String str) {
        zzbra zzbraVar;
        zzdpx zzdpxVarZza = zza(str);
        return (zzdpxVarZza == null || (zzbraVar = zzdpxVarZza.zzb) == null) ? "" : zzbraVar.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x001e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzc(java.lang.String r6, com.google.android.gms.internal.ads.zzfge r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.Map r0 = r5.zza     // Catch: java.lang.Throwable -> L17
            boolean r0 = r0.containsKey(r6)     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto Lb
            monitor-exit(r5)
            return
        Lb:
            com.google.android.gms.internal.ads.zzdpx r0 = new com.google.android.gms.internal.ads.zzdpx     // Catch: java.lang.Throwable -> L17
            r1 = 0
            if (r7 != 0) goto L12
        L10:
            r2 = r1
            goto L1b
        L12:
            com.google.android.gms.internal.ads.zzbra r2 = r7.zze()     // Catch: java.lang.Throwable -> L17 com.google.android.gms.internal.ads.zzffn -> L19
            goto L1b
        L17:
            r6 = move-exception
            goto L48
        L19:
            goto L10
        L1b:
            if (r7 != 0) goto L1e
            goto L22
        L1e:
            com.google.android.gms.internal.ads.zzbra r1 = r7.zzf()     // Catch: java.lang.Throwable -> L17 com.google.android.gms.internal.ads.zzffn -> L22
        L22:
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzix     // Catch: java.lang.Throwable -> L17
            n42 r4 = defpackage.n42.d     // Catch: java.lang.Throwable -> L17
            com.google.android.gms.internal.ads.zzbbu r4 = r4.c     // Catch: java.lang.Throwable -> L17
            java.lang.Object r3 = r4.zza(r3)     // Catch: java.lang.Throwable -> L17
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Throwable -> L17
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Throwable -> L17
            r4 = 1
            if (r3 != 0) goto L36
            goto L3e
        L36:
            r3 = 0
            if (r7 != 0) goto L3b
        L39:
            r4 = 0
            goto L3e
        L3b:
            r7.zzC()     // Catch: java.lang.Throwable -> L17 com.google.android.gms.internal.ads.zzffn -> L39
        L3e:
            r0.<init>(r6, r2, r1, r4)     // Catch: java.lang.Throwable -> L17
            java.util.Map r7 = r5.zza     // Catch: java.lang.Throwable -> L17
            r7.put(r6, r0)     // Catch: java.lang.Throwable -> L17
            monitor-exit(r5)
            return
        L48:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L17
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpy.zzc(java.lang.String, com.google.android.gms.internal.ads.zzfge):void");
    }

    public final synchronized void zzd(String str, zzbql zzbqlVar) {
        if (this.zza.containsKey(str)) {
            return;
        }
        try {
            this.zza.put(str, new zzdpx(str, zzbqlVar.zzf(), zzbqlVar.zzg(), true));
        } catch (Throwable unused) {
        }
    }
}
