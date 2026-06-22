package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.rc2;
import defpackage.tb2;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzfco implements zzena {
    private final Context zza;
    private final Executor zzb;
    private final zzcgj zzc;
    private final zzemk zzd;
    private final zzfdo zze;
    private zzbcr zzf;
    private final zzfki zzg;
    private final zzffe zzh;
    private do0 zzi;

    public zzfco(Context context, Executor executor, zzcgj zzcgjVar, zzemk zzemkVar, zzfdo zzfdoVar, zzffe zzffeVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgjVar;
        this.zzd = zzemkVar;
        this.zzh = zzffeVar;
        this.zze = zzfdoVar;
        this.zzg = zzcgjVar.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        do0 do0Var = this.zzi;
        return (do0Var == null || do0Var.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zzb(tb2 tb2Var, String str, zzemy zzemyVar, zzemz zzemzVar) {
        zzdgp zzdgpVarZzf;
        zzfkf zzfkfVarZzf;
        if (str == null) {
            k92.e("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfci
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzh();
                }
            });
            return false;
        }
        if (zza()) {
            return false;
        }
        zzbbn zzbbnVar = zzbbw.zzia;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && tb2Var.l) {
            this.zzc.zzl().zzo(true);
        }
        rc2 rc2Var = ((zzfch) zzemyVar).zza;
        Pair pair = new Pair(zzdrt.PUBLIC_API_CALL.zza(), Long.valueOf(tb2Var.F));
        String strZza = zzdrt.DYNAMITE_ENTER.zza();
        hd2.B.j.getClass();
        Bundle bundleZza = zzdrv.zza(pair, new Pair(strZza, Long.valueOf(System.currentTimeMillis())));
        zzffe zzffeVar = this.zzh;
        zzffeVar.zzt(str);
        zzffeVar.zzs(rc2Var);
        zzffeVar.zzH(tb2Var);
        zzffeVar.zzA(bundleZza);
        Context context = this.zza;
        zzffg zzffgVarZzJ = zzffeVar.zzJ();
        zzfju zzfjuVarZzb = zzfjt.zzb(context, zzfke.zzf(zzffgVarZzJ), 4, tb2Var);
        if (((Boolean) n42Var.c.zza(zzbbw.zzhr)).booleanValue()) {
            zzdgo zzdgoVarZzg = this.zzc.zzg();
            zzcvy zzcvyVar = new zzcvy();
            zzcvyVar.zze(this.zza);
            zzcvyVar.zzi(zzffgVarZzJ);
            zzdgoVarZzg.zze(zzcvyVar.zzj());
            zzdci zzdciVar = new zzdci();
            zzdciVar.zzj(this.zzd, this.zzb);
            zzdciVar.zzk(this.zzd, this.zzb);
            zzdgoVarZzg.zzd(zzdciVar.zzn());
            zzdgoVarZzg.zzc(new zzekt(this.zzf));
            zzdgpVarZzf = zzdgoVarZzg.zzh();
        } else {
            zzdci zzdciVar2 = new zzdci();
            zzfdo zzfdoVar = this.zze;
            if (zzfdoVar != null) {
                zzdciVar2.zze(zzfdoVar, this.zzb);
                zzdciVar2.zzf(this.zze, this.zzb);
                zzdciVar2.zzb(this.zze, this.zzb);
            }
            zzdgo zzdgoVarZzg2 = this.zzc.zzg();
            zzcvy zzcvyVar2 = new zzcvy();
            zzcvyVar2.zze(this.zza);
            zzcvyVar2.zzi(zzffgVarZzJ);
            zzdgoVarZzg2.zze(zzcvyVar2.zzj());
            zzdciVar2.zzj(this.zzd, this.zzb);
            zzdciVar2.zze(this.zzd, this.zzb);
            zzdciVar2.zzf(this.zzd, this.zzb);
            zzdciVar2.zzb(this.zzd, this.zzb);
            zzdciVar2.zza(this.zzd, this.zzb);
            zzdciVar2.zzl(this.zzd, this.zzb);
            zzdciVar2.zzk(this.zzd, this.zzb);
            zzdciVar2.zzi(this.zzd, this.zzb);
            zzdciVar2.zzc(this.zzd, this.zzb);
            zzdgoVarZzg2.zzd(zzdciVar2.zzn());
            zzdgoVarZzg2.zzc(new zzekt(this.zzf));
            zzdgpVarZzf = zzdgoVarZzg2.zzh();
        }
        zzdgp zzdgpVar = zzdgpVarZzf;
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzfkfVarZzf = zzdgpVar.zzf();
            zzfkfVarZzf.zzi(4);
            zzfkfVarZzf.zzb(tb2Var.v);
            zzfkfVarZzf.zzf(tb2Var.s);
        } else {
            zzfkfVarZzf = null;
        }
        zzfkf zzfkfVar = zzfkfVarZzf;
        zzctc zzctcVarZza = zzdgpVar.zza();
        do0 do0VarZzi = zzctcVarZza.zzi(zzctcVarZza.zzj());
        this.zzi = do0VarZzi;
        zzgcj.zzr(do0VarZzi, new zzfcn(this, zzemzVar, zzfkfVar, zzfjuVarZzb, zzdgpVar), this.zzb);
        return true;
    }

    public final /* synthetic */ void zzh() {
        this.zzd.zzdB(zzfgi.zzd(6, null, null));
    }

    public final void zzi(zzbcr zzbcrVar) {
        this.zzf = zzbcrVar;
    }
}
