package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzeiu implements zzgbq {
    private final zzfjl zza;
    private final zzcws zzb;
    private final zzflh zzc;
    private final zzfll zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcrx zzg;
    private final zzein zzh;
    private final zzeey zzi;
    private final Context zzj;
    private final zzfkf zzk;
    private final zzehx zzl;
    private final zzdsf zzm;

    public zzeiu(Context context, zzfjl zzfjlVar, zzein zzeinVar, zzcws zzcwsVar, zzflh zzflhVar, zzfll zzfllVar, zzcrx zzcrxVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzeey zzeeyVar, zzfkf zzfkfVar, zzehx zzehxVar, zzdsf zzdsfVar) {
        this.zzj = context;
        this.zza = zzfjlVar;
        this.zzh = zzeinVar;
        this.zzb = zzcwsVar;
        this.zzc = zzflhVar;
        this.zzd = zzfllVar;
        this.zzg = zzcrxVar;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzeeyVar;
        this.zzk = zzfkfVar;
        this.zzl = zzehxVar;
        this.zzm = zzdsfVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String zzc(com.google.android.gms.internal.ads.zzfex r6) {
        /*
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzeS
            n42 r1 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r2 = r1.c
            java.lang.Object r0 = r2.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r2 = "No fill."
            r3 = 1
            if (r3 == r0) goto L18
            java.lang.String r0 = "No ad config."
            goto L19
        L18:
            r0 = r2
        L19:
            com.google.android.gms.internal.ads.zzfew r3 = r6.zzb
            com.google.android.gms.internal.ads.zzfeo r3 = r3.zzb
            int r3 = r3.zzf
            if (r3 == 0) goto L4a
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 300(0x12c, float:4.2E-43)
            if (r3 < r4) goto L3a
            if (r3 >= r5) goto L3a
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzeR
            com.google.android.gms.internal.ads.zzbbu r1 = r1.c
            java.lang.Object r1 = r1.zza(r3)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L4a
            goto L4b
        L3a:
            if (r3 < r5) goto L43
            r0 = 400(0x190, float:5.6E-43)
            if (r3 >= r0) goto L43
            java.lang.String r2 = "No location header to follow redirect or too many redirects."
            goto L4b
        L43:
            java.lang.String r0 = "Received error HTTP response code: "
            java.lang.String r2 = defpackage.k31.k(r3, r0)
            goto L4b
        L4a:
            r2 = r0
        L4b:
            com.google.android.gms.internal.ads.zzfew r6 = r6.zzb
            com.google.android.gms.internal.ads.zzfeo r6 = r6.zzb
            com.google.android.gms.internal.ads.zzfen r6 = r6.zzj
            if (r6 == 0) goto L58
            java.lang.String r6 = r6.zza()
            return r6
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiu.zzc(com.google.android.gms.internal.ads.zzfex):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    @Override // com.google.android.gms.internal.ads.zzgbq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.do0 zza(java.lang.Object r9) {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiu.zza(java.lang.Object):do0");
    }

    public final /* synthetic */ do0 zzb(zzfel zzfelVar, zzfex zzfexVar, zzeet zzeetVar, Throwable th) {
        zzfju zzfjuVarZza = zzfjt.zza(this.zzj, 12);
        zzfjuVarZza.zzd(zzfelVar.zzE);
        zzfjuVarZza.zzi();
        do0 do0VarZzo = zzgcj.zzo(zzeetVar.zza(zzfexVar, zzfelVar), zzfelVar.zzR, TimeUnit.MILLISECONDS, this.zzf);
        this.zzh.zzf(zzfexVar, zzfelVar, do0VarZzo, this.zzc);
        zzfke.zza(do0VarZzo, this.zzk, zzfjuVarZza);
        return do0VarZzo;
    }
}
