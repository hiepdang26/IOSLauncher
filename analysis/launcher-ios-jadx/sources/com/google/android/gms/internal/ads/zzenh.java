package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import defpackage.tb2;
import defpackage.u62;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzenh implements zzena {
    private final zzffe zza;
    private final zzcgj zzb;
    private final Context zzc;
    private final zzemx zzd;
    private final zzfki zze;
    private zzcsj zzf;

    public zzenh(zzcgj zzcgjVar, Context context, zzemx zzemxVar, zzffe zzffeVar) {
        this.zzb = zzcgjVar;
        this.zzc = context;
        this.zzd = zzemxVar;
        this.zza = zzffeVar;
        this.zze = zzcgjVar.zzz();
        zzffeVar.zzv(zzemxVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        zzcsj zzcsjVar = this.zzf;
        return zzcsjVar != null && zzcsjVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zzb(tb2 tb2Var, String str, zzemy zzemyVar, zzemz zzemzVar) {
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        if (cd2.f(this.zzc) && tb2Var.y == null) {
            k92.e("Failed to load the ad because app ID is missing.");
            this.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzenc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzf();
                }
            });
            return false;
        }
        if (str == null) {
            k92.e("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzend
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzg();
                }
            });
            return false;
        }
        zzfgd.zza(this.zzc, tb2Var.l);
        if (((Boolean) n42.d.c.zza(zzbbw.zzia)).booleanValue() && tb2Var.l) {
            this.zzb.zzl().zzo(true);
        }
        int i = ((zzenb) zzemyVar).zza;
        hd2Var.j.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzdrt.PUBLIC_API_CALL.zza();
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        Bundle bundleZza = zzdrv.zza(new Pair(strZza, lValueOf), new Pair(zzdrt.DYNAMITE_ENTER.zza(), lValueOf));
        zzffe zzffeVar = this.zza;
        zzffeVar.zzH(tb2Var);
        zzffeVar.zzA(bundleZza);
        zzffeVar.zzC(i);
        Context context = this.zzc;
        zzffg zzffgVarZzJ = zzffeVar.zzJ();
        zzfju zzfjuVarZzb = zzfjt.zzb(context, zzfke.zzf(zzffgVarZzJ), 8, tb2Var);
        u62 u62Var = zzffgVarZzJ.zzn;
        if (u62Var != null) {
            this.zzd.zzd().zzm(u62Var);
        }
        zzdhk zzdhkVarZzh = this.zzb.zzh();
        zzcvy zzcvyVar = new zzcvy();
        zzcvyVar.zze(this.zzc);
        zzcvyVar.zzi(zzffgVarZzJ);
        zzdhkVarZzh.zzf(zzcvyVar.zzj());
        zzdci zzdciVar = new zzdci();
        zzdciVar.zzk(this.zzd.zzd(), this.zzb.zzB());
        zzdhkVarZzh.zze(zzdciVar.zzn());
        zzdhkVarZzh.zzd(this.zzd.zzc());
        zzfkf zzfkfVarZzf = null;
        zzdhkVarZzh.zzc(new zzcph(null));
        zzdhl zzdhlVarZzg = zzdhkVarZzh.zzg();
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzfkfVarZzf = zzdhlVarZzg.zzf();
            zzfkfVarZzf.zzi(8);
            zzfkfVarZzf.zzb(tb2Var.v);
            zzfkfVarZzf.zzf(tb2Var.s);
        }
        zzfkf zzfkfVar = zzfkfVarZzf;
        this.zzb.zzy().zzc(1);
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        ScheduledExecutorService scheduledExecutorServiceZzC = this.zzb.zzC();
        zzctc zzctcVarZza = zzdhlVarZzg.zza();
        zzcsj zzcsjVar = new zzcsj(zzgcuVar, scheduledExecutorServiceZzC, zzctcVarZza.zzi(zzctcVarZza.zzj()));
        this.zzf = zzcsjVar;
        zzcsjVar.zze(new zzeng(this, zzemzVar, zzfkfVar, zzfjuVarZzb, zzdhlVarZzg));
        return true;
    }

    public final /* synthetic */ void zzf() {
        this.zzd.zza().zzdB(zzfgi.zzd(4, null, null));
    }

    public final /* synthetic */ void zzg() {
        this.zzd.zza().zzdB(zzfgi.zzd(6, null, null));
    }
}
