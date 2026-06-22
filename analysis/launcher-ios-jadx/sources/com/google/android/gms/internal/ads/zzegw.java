package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import defpackage.do0;
import defpackage.n42;
import defpackage.or1;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzegw implements zzeet {
    private final Context zza;
    private final zzdpl zzb;
    private final zzdgp zzc;
    private final zzffg zzd;
    private final Executor zze;
    private final or1 zzf;
    private final zzbja zzg;
    private final boolean zzh = ((Boolean) n42.d.c.zza(zzbbw.zzhZ)).booleanValue();
    private final zzeds zzi;

    public zzegw(Context context, or1 or1Var, zzffg zzffgVar, Executor executor, zzdgp zzdgpVar, zzdpl zzdplVar, zzbja zzbjaVar, zzeds zzedsVar) {
        this.zza = context;
        this.zzd = zzffgVar;
        this.zzc = zzdgpVar;
        this.zze = executor;
        this.zzf = or1Var;
        this.zzb = zzdplVar;
        this.zzg = zzbjaVar;
        this.zzi = zzedsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final do0 zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        final zzdpp zzdppVar = new zzdpp();
        do0 do0VarZzn = zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzegt
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzc(zzfelVar, zzfexVar, zzdppVar, obj);
            }
        }, this.zze);
        do0VarZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegu
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
        final zzcej zzcejVarZza = this.zzb.zza(this.zzd.zze, zzfelVar, zzfexVar.zzb.zzb);
        zzcejVarZza.zzac(zzfelVar.zzW);
        zzdppVar.zza(this.zza, (View) zzcejVarZza);
        zzbzt zzbztVar = new zzbzt();
        final zzdfp zzdfpVarZze = this.zzc.zze(new zzcsk(zzfexVar, zzfelVar, null), new zzdfs(new zzegv(this.zza, this.zzf, zzbztVar, zzfelVar, zzcejVarZza, this.zzd, this.zzh, this.zzg, this.zzi), zzcejVarZza));
        zzbztVar.zzc(zzdfpVarZze);
        zzdfpVarZze.zzc().zzo(new zzcxk() { // from class: com.google.android.gms.internal.ads.zzegr
            @Override // com.google.android.gms.internal.ads.zzcxk
            public final void zzr() {
                zzcej zzcejVar = zzcejVarZza;
                if (zzcejVar.zzN() != null) {
                    zzcejVar.zzN().zzr();
                }
            }
        }, zzbzo.zzf);
        String strZzb = zzfelVar.zzs.zza;
        if (((Boolean) n42.d.c.zza(zzbbw.zzeC)).booleanValue() && zzdfpVarZze.zzl().zze(true)) {
            strZzb = zzcfu.zzb(strZzb, zzcfu.zza(zzfelVar));
        }
        zzdfpVarZze.zzi().zzi(zzcejVarZza, true, this.zzh ? this.zzg : null);
        zzdfpVarZze.zzi();
        return zzgcj.zzm(zzdpk.zzj(zzcejVarZza, zzfelVar.zzs.zzb, strZzb), new zzful(this) { // from class: com.google.android.gms.internal.ads.zzegs
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj2) {
                zzcej zzcejVar = zzcejVarZza;
                if (zzfelVar.zzM) {
                    zzcejVar.zzah();
                }
                zzdfp zzdfpVar = zzdfpVarZze;
                zzcejVar.zzab();
                zzcejVar.onPause();
                return zzdfpVar.zzg();
            }
        }, this.zze);
    }
}
