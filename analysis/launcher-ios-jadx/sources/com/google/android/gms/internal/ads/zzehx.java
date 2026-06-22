package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzehx {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcrx zzc;
    private final zzein zzd;
    private final zzflh zze;
    private final zzgdc zzf = zzgdc.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    private zzehy zzh;
    private zzfex zzi;

    public zzehx(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcrx zzcrxVar, zzein zzeinVar, zzflh zzflhVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcrxVar;
        this.zzd = zzeinVar;
        this.zze = zzflhVar;
    }

    private final synchronized do0 zzd(zzfel zzfelVar) {
        Iterator it = zzfelVar.zza.iterator();
        while (it.hasNext()) {
            zzeet zzeetVarZza = this.zzc.zza(zzfelVar.zzb, (String) it.next());
            if (zzeetVarZza != null && zzeetVarZza.zzb(this.zzi, zzfelVar)) {
                return zzgcj.zzo(zzeetVarZza.zza(this.zzi, zzfelVar), zzfelVar.zzR, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgcj.zzg(new zzdwl(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(zzfel zzfelVar) {
        do0 do0VarZzd = zzd(zzfelVar);
        this.zzd.zzf(this.zzi, zzfelVar, do0VarZzd, this.zze);
        zzgcj.zzr(do0VarZzd, new zzehw(this, zzfelVar), this.zza);
    }

    public final synchronized do0 zzb(zzfex zzfexVar) {
        try {
            if (!this.zzg.getAndSet(true)) {
                if (zzfexVar.zzb.zza.isEmpty()) {
                    this.zzf.zzd(new zzeir(3, zzeiu.zzc(zzfexVar)));
                } else {
                    this.zzi = zzfexVar;
                    this.zzh = new zzehy(zzfexVar, this.zzd, this.zzf);
                    this.zzd.zzk(zzfexVar.zzb.zza);
                    zzfel zzfelVarZza = this.zzh.zza();
                    while (zzfelVarZza != null) {
                        zze(zzfelVarZza);
                        zzfelVarZza = this.zzh.zza();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzf;
    }
}
