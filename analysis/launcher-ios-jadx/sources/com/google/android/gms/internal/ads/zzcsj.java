package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcsj {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final do0 zzc;
    private volatile boolean zzd = true;

    public zzcsj(Executor executor, ScheduledExecutorService scheduledExecutorService, do0 do0Var) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = do0Var;
    }

    public static /* bridge */ /* synthetic */ void zzb(final zzcsj zzcsjVar, List list, final zzgcf zzgcfVar) {
        if (list == null || list.isEmpty()) {
            zzcsjVar.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcse
                @Override // java.lang.Runnable
                public final void run() {
                    zzgcfVar.zza(new zzdwl(3));
                }
            });
            return;
        }
        do0 do0VarZzh = zzgcj.zzh(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final do0 do0Var = (do0) it.next();
            do0VarZzh = zzgcj.zzn(zzgcj.zzf(do0VarZzh, Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsf
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final do0 zza(Object obj) {
                    zzgcfVar.zza((Throwable) obj);
                    return zzgcj.zzh(null);
                }
            }, zzcsjVar.zza), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsg
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final do0 zza(Object obj) {
                    return this.zza.zza(zzgcfVar, do0Var, (zzcru) obj);
                }
            }, zzcsjVar.zza);
        }
        zzgcj.zzr(do0VarZzh, new zzcsi(zzcsjVar, zzgcfVar), zzcsjVar.zza);
    }

    public final /* synthetic */ do0 zza(zzgcf zzgcfVar, do0 do0Var, zzcru zzcruVar) {
        if (zzcruVar != null) {
            zzgcfVar.zzb(zzcruVar);
        }
        return zzgcj.zzo(do0Var, ((Long) zzbef.zza.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzgcf zzgcfVar) {
        zzgcj.zzr(this.zzc, new zzcsh(this, zzgcfVar), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
