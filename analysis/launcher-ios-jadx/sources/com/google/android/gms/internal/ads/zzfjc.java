package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjc {
    final /* synthetic */ zzfjd zza;
    private final Object zzb;
    private final String zzc;
    private final do0 zzd;
    private final List zze;
    private final do0 zzf;

    private zzfjc(zzfjd zzfjdVar, Object obj, String str, do0 do0Var, List list, do0 do0Var2) {
        this.zza = zzfjdVar;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = do0Var;
        this.zze = list;
        this.zzf = do0Var2;
    }

    public final zzfiq zza() {
        Object obj = this.zzb;
        String strZzf = this.zzc;
        if (strZzf == null) {
            strZzf = this.zza.zzf(obj);
        }
        final zzfiq zzfiqVar = new zzfiq(obj, strZzf, this.zzf);
        this.zza.zzd.zza(zzfiqVar);
        do0 do0Var = this.zzd;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfiz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.zzd.zzc(zzfiqVar);
            }
        };
        zzgcu zzgcuVar = zzbzo.zzf;
        do0Var.addListener(runnable, zzgcuVar);
        zzgcj.zzr(zzfiqVar, new zzfja(this, zzfiqVar), zzgcuVar);
        return zzfiqVar;
    }

    public final zzfjc zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfjc zzc(Class cls, zzgbq zzgbqVar) {
        return new zzfjc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgcj.zzf(this.zzf, cls, zzgbqVar, this.zza.zzb));
    }

    public final zzfjc zzd(final do0 do0Var) {
        return zzg(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzfiy
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return do0Var;
            }
        }, zzbzo.zzf);
    }

    public final zzfjc zze(final zzfio zzfioVar) {
        return zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzfix
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzgcj.zzh(zzfioVar.zza(obj));
            }
        });
    }

    public final zzfjc zzf(zzgbq zzgbqVar) {
        return zzg(zzgbqVar, this.zza.zzb);
    }

    public final zzfjc zzg(zzgbq zzgbqVar, Executor executor) {
        return new zzfjc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgcj.zzn(this.zzf, zzgbqVar, executor));
    }

    public final zzfjc zzh(String str) {
        return new zzfjc(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfjc zzi(long j, TimeUnit timeUnit) {
        return new zzfjc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgcj.zzo(this.zzf, j, timeUnit, this.zza.zzc));
    }
}
