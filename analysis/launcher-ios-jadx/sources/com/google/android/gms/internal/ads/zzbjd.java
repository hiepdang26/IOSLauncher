package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbjd implements zzbix {
    private final Context zza;
    private final Map zzb;

    public zzbjd(Context context, Map map) {
        this.zza = context;
        this.zzb = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    @Override // com.google.android.gms.internal.ads.zzbix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.Object r8, java.util.Map r9) {
        /*
            r7 = this;
            hd2 r8 = defpackage.hd2.B
            com.google.android.gms.internal.ads.zzbya r0 = r8.x
            android.content.Context r1 = r7.zza
            boolean r0 = r0.zzp(r1)
            if (r0 != 0) goto Ld
            return
        Ld:
            java.lang.String r0 = "eventName"
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "eventId"
            java.lang.Object r9 = r9.get(r1)
            java.lang.String r9 = (java.lang.String) r9
            int r1 = r0.hashCode()
            r2 = 94399(0x170bf, float:1.32281E-40)
            r3 = 2
            java.lang.String r4 = "_ac"
            r5 = 1
            java.lang.String r6 = "_ai"
            if (r1 == r2) goto L47
            r2 = 94401(0x170c1, float:1.32284E-40)
            if (r1 == r2) goto L3f
            r2 = 94407(0x170c7, float:1.32292E-40)
            if (r1 == r2) goto L37
            goto L51
        L37:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L51
            r0 = 1
            goto L52
        L3f:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L51
            r0 = 0
            goto L52
        L47:
            java.lang.String r1 = "_aa"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L51
            r0 = 2
            goto L52
        L51:
            r0 = -1
        L52:
            if (r0 == 0) goto L76
            if (r0 == r5) goto L66
            if (r0 == r3) goto L5e
            java.lang.String r8 = "logScionEvent gmsg contained unsupported eventName"
            defpackage.k92.e(r8)
            return
        L5e:
            android.content.Context r0 = r7.zza
            com.google.android.gms.internal.ads.zzbya r8 = r8.x
            r8.zzh(r0, r9)
            return
        L66:
            android.content.Context r0 = r7.zza
            java.util.Map r1 = r7.zzb
            com.google.android.gms.internal.ads.zzbya r8 = r8.x
            java.lang.Object r1 = r1.get(r6)
            java.util.Map r1 = (java.util.Map) r1
            r8.zzk(r0, r9, r1)
            return
        L76:
            android.content.Context r0 = r7.zza
            java.util.Map r1 = r7.zzb
            com.google.android.gms.internal.ads.zzbya r8 = r8.x
            java.lang.Object r1 = r1.get(r4)
            java.util.Map r1 = (java.util.Map) r1
            r8.zzj(r0, r9, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjd.zza(java.lang.Object, java.util.Map):void");
    }
}
