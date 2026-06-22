package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import defpackage.do0;
import defpackage.n42;
import defpackage.o32;
import defpackage.rc2;
import defpackage.ta2;
import defpackage.x82;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzefu implements zzeet {
    private final zzcql zza;
    private final Context zzb;
    private final zzdpl zzc;
    private final zzffg zzd;
    private final Executor zze;
    private final zzful zzf;

    public zzefu(zzcql zzcqlVar, Context context, Executor executor, zzdpl zzdplVar, zzffg zzffgVar, zzful zzfulVar) {
        this.zzb = context;
        this.zza = zzcqlVar;
        this.zze = executor;
        this.zzc = zzdplVar;
        this.zzd = zzffgVar;
        this.zzf = zzfulVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final do0 zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        return zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzeft
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzc(zzfexVar, zzfelVar, obj);
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        zzfeq zzfeqVar = zzfelVar.zzs;
        return (zzfeqVar == null || zzfeqVar.zza == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final do0 zzc(zzfex zzfexVar, zzfel zzfelVar, Object obj) {
        View zzdpoVar;
        rc2 rc2VarZza = zzffm.zza(this.zzb, zzfelVar.zzu);
        final zzcej zzcejVarZza = this.zzc.zza(rc2VarZza, zzfelVar, zzfexVar.zzb.zzb);
        zzcejVarZza.zzac(zzfelVar.zzW);
        zzbbn zzbbnVar = zzbbw.zzgZ;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && zzfelVar.zzag) {
            zzdpoVar = zzcrg.zza(this.zzb, (View) zzcejVarZza, zzfelVar);
        } else {
            zzdpoVar = new zzdpo(this.zzb, (View) zzcejVarZza, (o32) this.zzf.apply(zzfelVar));
        }
        final zzcpl zzcplVarZza = this.zza.zza(new zzcsk(zzfexVar, zzfelVar, null), new zzcpr(zzdpoVar, zzcejVarZza, new zzcrs() { // from class: com.google.android.gms.internal.ads.zzefo
            @Override // com.google.android.gms.internal.ads.zzcrs
            public final x82 zza() {
                return zzcejVarZza.zzq();
            }
        }, zzffm.zzb(rc2VarZza)));
        zzcplVarZza.zzh().zzi(zzcejVarZza, false, null);
        zzcxi zzcxiVarZzc = zzcplVarZza.zzc();
        zzcxk zzcxkVar = new zzcxk() { // from class: com.google.android.gms.internal.ads.zzefp
            @Override // com.google.android.gms.internal.ads.zzcxk
            public final void zzr() {
                zzcej zzcejVar = zzcejVarZza;
                if (zzcejVar.zzN() != null) {
                    zzcejVar.zzN().zzr();
                }
            }
        };
        zzgcu zzgcuVar = zzbzo.zzf;
        zzcxiVarZzc.zzo(zzcxkVar, zzgcuVar);
        String strZzb = zzfelVar.zzs.zza;
        if (((Boolean) n42Var.c.zza(zzbbw.zzeC)).booleanValue() && zzcplVarZza.zzi().zze(true)) {
            strZzb = zzcfu.zzb(strZzb, zzcfu.zza(zzfelVar));
        }
        zzcplVarZza.zzh();
        do0 do0VarZzj = zzdpk.zzj(zzcejVarZza, zzfelVar.zzs.zzb, strZzb);
        if (zzfelVar.zzM) {
            do0VarZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefq
                @Override // java.lang.Runnable
                public final void run() {
                    zzcejVarZza.zzah();
                }
            }, this.zze);
        }
        do0VarZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefr
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd(zzcejVarZza);
            }
        }, this.zze);
        return zzgcj.zzm(do0VarZzj, new zzful() { // from class: com.google.android.gms.internal.ads.zzefs
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj2) {
                return zzcplVarZza.zza();
            }
        }, zzgcuVar);
    }

    public final void zzd(zzcej zzcejVar) {
        zzcejVar.zzab();
        zzcfl zzcflVarZzq = zzcejVar.zzq();
        ta2 ta2Var = this.zzd.zza;
        if (ta2Var != null && zzcflVarZzq != null) {
            zzcflVarZzq.zzs(ta2Var);
        }
        if (!((Boolean) n42.d.c.zza(zzbbw.zzaZ)).booleanValue() || zzcejVar.isAttachedToWindow()) {
            return;
        }
        zzcejVar.onPause();
        zzcejVar.zzav(true);
    }
}
