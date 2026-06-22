package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import defpackage.do0;
import defpackage.n42;
import defpackage.or1;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzefe implements zzeet {
    private final zzcoy zza;
    private final Context zzb;
    private final zzdpl zzc;
    private final zzffg zzd;
    private final Executor zze;
    private final or1 zzf;
    private final zzbja zzg;
    private final boolean zzh = ((Boolean) n42.d.c.zza(zzbbw.zzhZ)).booleanValue();
    private final zzeds zzi;

    public zzefe(zzcoy zzcoyVar, Context context, Executor executor, zzdpl zzdplVar, zzffg zzffgVar, or1 or1Var, zzbja zzbjaVar, zzeds zzedsVar) {
        this.zzb = context;
        this.zza = zzcoyVar;
        this.zze = executor;
        this.zzc = zzdplVar;
        this.zzd = zzffgVar;
        this.zzf = or1Var;
        this.zzg = zzbjaVar;
        this.zzi = zzedsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final do0 zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        final zzdpp zzdppVar = new zzdpp();
        do0 do0VarZzn = zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzefa
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzc(zzfelVar, zzfexVar, zzdppVar, obj);
            }
        }, this.zze);
        do0VarZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefb
            @Override // java.lang.Runnable
            public final void run() {
                zzdppVar.zzb();
            }
        }, this.zze);
        return do0VarZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        zzfeq zzfeqVar = zzfelVar.zzs;
        return (zzfeqVar == null || zzfeqVar.zza == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final do0 zzc(final zzfel zzfelVar, zzfex zzfexVar, zzdpp zzdppVar, Object obj) {
        final zzcej zzcejVarZza = this.zzc.zza(this.zzd.zze, zzfelVar, zzfexVar.zzb.zzb);
        zzcejVarZza.zzac(zzfelVar.zzW);
        zzdppVar.zza(this.zzb, (View) zzcejVarZza);
        zzbzt zzbztVar = new zzbzt();
        final zzcov zzcovVarZza = this.zza.zza(new zzcsk(zzfexVar, zzfelVar, null), new zzdfs(new zzefg(this.zzf, zzbztVar, zzfelVar, zzcejVarZza, this.zzd, this.zzh, this.zzg, this.zzi), zzcejVarZza), new zzcow(zzfelVar.zzaa));
        zzcovVarZza.zzh().zzi(zzcejVarZza, false, this.zzh ? this.zzg : null);
        zzbztVar.zzc(zzcovVarZza);
        zzcovVarZza.zzc().zzo(new zzcxk() { // from class: com.google.android.gms.internal.ads.zzefc
            @Override // com.google.android.gms.internal.ads.zzcxk
            public final void zzr() {
                zzcej zzcejVar = zzcejVarZza;
                if (zzcejVar.zzN() != null) {
                    zzcejVar.zzN().zzr();
                }
            }
        }, zzbzo.zzf);
        String strZzb = zzfelVar.zzs.zza;
        if (((Boolean) n42.d.c.zza(zzbbw.zzeC)).booleanValue() && zzcovVarZza.zzi().zze(true)) {
            strZzb = zzcfu.zzb(strZzb, zzcfu.zza(zzfelVar));
        }
        zzcovVarZza.zzh();
        return zzgcj.zzm(zzdpk.zzj(zzcejVarZza, zzfelVar.zzs.zzb, strZzb), new zzful(this) { // from class: com.google.android.gms.internal.ads.zzefd
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj2) {
                zzcej zzcejVar = zzcejVarZza;
                if (zzfelVar.zzM) {
                    zzcejVar.zzah();
                }
                zzcov zzcovVar = zzcovVarZza;
                zzcejVar.zzab();
                zzcejVar.onPause();
                return zzcovVar.zza();
            }
        }, this.zze);
    }
}
