package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.n42;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzegn implements zzeet {
    private final zzcql zza;
    private final zzefu zzb;
    private final zzgcu zzc;
    private final zzcws zzd;
    private final ScheduledExecutorService zze;
    private final zzdsf zzf;

    public zzegn(zzcql zzcqlVar, zzefu zzefuVar, zzcws zzcwsVar, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcuVar, zzdsf zzdsfVar) {
        this.zza = zzcqlVar;
        this.zzb = zzefuVar;
        this.zzd = zzcwsVar;
        this.zze = scheduledExecutorService;
        this.zzc = zzgcuVar;
        this.zzf = zzdsfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final do0 zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        return this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzegl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc(zzfexVar, zzfelVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        zzbgu zzbguVarZza = zzfexVar.zza.zza.zza();
        boolean zZzb = this.zzb.zzb(zzfexVar, zzfelVar);
        if (((Boolean) n42.d.c.zza(zzbbw.zzkZ)).booleanValue()) {
            this.zzf.zzb().put("has_dbl", zzbguVarZza != null ? "1" : "0");
            this.zzf.zzb().put("crdb", true == zZzb ? "1" : "0");
        }
        return zzbguVarZza != null && zZzb;
    }

    public final /* synthetic */ zzcpk zzc(final zzfex zzfexVar, final zzfel zzfelVar) {
        return this.zza.zzb(new zzcsk(zzfexVar, zzfelVar, null), new zzcrc(zzfexVar.zza.zza.zza(), new Runnable() { // from class: com.google.android.gms.internal.ads.zzegk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf(zzfexVar, zzfelVar);
            }
        })).zza();
    }

    public final /* synthetic */ void zzf(zzfex zzfexVar, zzfel zzfelVar) {
        zzgcj.zzr(zzgcj.zzo(this.zzb.zza(zzfexVar, zzfelVar), zzfelVar.zzR, TimeUnit.SECONDS, this.zze), new zzegm(this), this.zzc);
    }
}
