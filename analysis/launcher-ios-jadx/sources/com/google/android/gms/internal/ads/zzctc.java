package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.hd2;
import defpackage.j92;
import defpackage.n42;
import defpackage.tb2;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzctc {
    private final zzdxu zza;
    private final zzffg zzb;
    private final zzfjl zzc;
    private final zzclw zzd;
    private final zzeiu zze;
    private final zzdby zzf;
    private zzfex zzg;
    private final zzdzc zzh;
    private final zzcvu zzi;
    private final Executor zzj;
    private final zzdym zzk;
    private final zzeey zzl;
    private final zzdzs zzm;
    private final zzdzz zzn;

    public zzctc(zzdxu zzdxuVar, zzffg zzffgVar, zzfjl zzfjlVar, zzclw zzclwVar, zzeiu zzeiuVar, zzdby zzdbyVar, zzfex zzfexVar, zzdzc zzdzcVar, zzcvu zzcvuVar, Executor executor, zzdym zzdymVar, zzeey zzeeyVar, zzdzs zzdzsVar, zzdzz zzdzzVar) {
        this.zza = zzdxuVar;
        this.zzb = zzffgVar;
        this.zzc = zzfjlVar;
        this.zzd = zzclwVar;
        this.zze = zzeiuVar;
        this.zzf = zzdbyVar;
        this.zzg = zzfexVar;
        this.zzh = zzdzcVar;
        this.zzi = zzcvuVar;
        this.zzj = executor;
        this.zzk = zzdymVar;
        this.zzl = zzeeyVar;
        this.zzm = zzdzsVar;
        this.zzn = zzdzzVar;
    }

    public final j92 zza(Throwable th) {
        return zzfgi.zzb(th, this.zzl);
    }

    public final zzdby zzc() {
        return this.zzf;
    }

    public final /* synthetic */ zzfex zzd(zzfex zzfexVar) {
        this.zzd.zza(zzfexVar);
        return zzfexVar;
    }

    public final do0 zze(final zzfhb zzfhbVar) {
        zzfiq zzfiqVarZza = this.zzc.zzb(zzfjf.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsy
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzf(zzfhbVar, (zzbvb) obj);
            }
        }).zza();
        zzgcj.zzr(zzfiqVarZza, new zzcta(this), this.zzj);
        return zzfiqVarZza;
    }

    public final /* synthetic */ do0 zzf(zzfhb zzfhbVar, zzbvb zzbvbVar) {
        zzbvbVar.zzi = zzfhbVar;
        return this.zzh.zza(zzbvbVar);
    }

    public final /* synthetic */ do0 zzg(do0 do0Var, do0 do0Var2, do0 do0Var3) {
        return this.zzn.zzc((zzbvb) do0Var.get(), (JSONObject) do0Var2.get(), (zzbvd) do0Var3.get());
    }

    public final do0 zzh(zzbvb zzbvbVar) {
        zzfiq zzfiqVarZza = this.zzc.zzb(zzfjf.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbvbVar)).zza();
        zzgcj.zzr(zzfiqVarZza, new zzctb(this), this.zzj);
        return zzfiqVarZza;
    }

    public final do0 zzi(do0 do0Var) {
        zzfjc zzfjcVarZzf = this.zzc.zzb(zzfjf.RENDERER, do0Var).zze(new zzfio() { // from class: com.google.android.gms.internal.ads.zzcst
            @Override // com.google.android.gms.internal.ads.zzfio
            public final Object zza(Object obj) {
                zzfex zzfexVar = (zzfex) obj;
                this.zza.zzd(zzfexVar);
                return zzfexVar;
            }
        }).zzf(this.zze);
        if (!((Boolean) n42.d.c.zza(zzbbw.zzeT)).booleanValue()) {
            zzfjcVarZzf = zzfjcVarZzf.zzi(((Integer) r1.c.zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS);
        }
        return zzfjcVarZzf.zza();
    }

    public final do0 zzj() {
        tb2 tb2Var = this.zzb.zzd;
        if (tb2Var.D == null && tb2Var.y == null) {
            return zzk(this.zzi.zzc());
        }
        zzfjl zzfjlVar = this.zzc;
        zzdxu zzdxuVar = this.zza;
        return zzfiv.zzc(zzdxuVar.zza(), zzfjf.PRELOADED_LOADER, zzfjlVar).zza();
    }

    public final do0 zzk(final do0 do0Var) {
        zzfex zzfexVar = this.zzg;
        if (zzfexVar != null) {
            return zzfiv.zzc(zzgcj.zzh(zzfexVar), zzfjf.SERVER_TRANSACTION, this.zzc).zza();
        }
        hd2.B.i.zzj();
        if (!((Boolean) n42.d.c.zza(zzbbw.zzkF)).booleanValue() || ((Boolean) zzbdy.zzc.zze()).booleanValue()) {
            zzfjc zzfjcVarZzb = this.zzc.zzb(zzfjf.SERVER_TRANSACTION, do0Var);
            final zzdym zzdymVar = this.zzk;
            Objects.requireNonNull(zzdymVar);
            return zzfjcVarZzb.zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsz
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final do0 zza(Object obj) {
                    return zzdymVar.zzb((zzbvb) obj);
                }
            }).zza();
        }
        final zzdzs zzdzsVar = this.zzm;
        Objects.requireNonNull(zzdzsVar);
        final do0 do0VarZzn = zzgcj.zzn(do0Var, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsu
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzdzsVar.zza((zzbvb) obj);
            }
        }, this.zzj);
        zzfjc zzfjcVarZzb2 = this.zzc.zzb(zzfjf.BUILD_URL, do0VarZzn);
        final zzdzc zzdzcVar = this.zzh;
        Objects.requireNonNull(zzdzcVar);
        final zzfiq zzfiqVarZza = zzfjcVarZzb2.zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsv
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return zzdzcVar.zzb((JSONObject) obj);
            }
        }).zza();
        return this.zzc.zza(zzfjf.SERVER_TRANSACTION, do0Var, do0VarZzn, zzfiqVarZza).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcsw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzg(do0Var, do0VarZzn, zzfiqVarZza);
            }
        }).zzf(new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcsx
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return (do0) obj;
            }
        }).zza();
    }

    public final void zzl(zzfex zzfexVar) {
        this.zzg = zzfexVar;
    }
}
