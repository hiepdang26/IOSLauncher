package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import defpackage.g32;
import defpackage.k92;
import defpackage.n42;
import defpackage.rc2;
import defpackage.uc2;
import defpackage.v32;
import defpackage.wg1;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzeuv implements zzevo {
    private final String zza;
    private final zzgcu zzb;
    private final ScheduledExecutorService zzc;
    private final Context zzd;
    private final zzffg zze;
    private final zzcgj zzf;

    public zzeuv(zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, String str, Context context, zzffg zzffgVar, zzcgj zzcgjVar) {
        this.zzb = zzgcuVar;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = context;
        this.zze = zzffgVar;
        this.zzf = zzcgjVar;
    }

    public static do0 zzc(zzeuv zzeuvVar) {
        uc2 uc2VarZzp = zzeuvVar.zzf.zzp();
        zzcvy zzcvyVar = new zzcvy();
        zzcvyVar.zze(zzeuvVar.zzd);
        zzffe zzffeVar = new zzffe();
        zzffeVar.zzt("adUnitId");
        zzffeVar.zzH(zzeuvVar.zze.zzd);
        zzffeVar.zzs(new rc2());
        zzffeVar.zzz(true);
        zzcvyVar.zzi(zzffeVar.zzJ());
        uc2VarZzp.zza(zzcvyVar.zzj());
        wg1 wg1Var = new wg1();
        wg1Var.h = zzeuvVar.zza;
        uc2VarZzp.zzb(new g32(wg1Var));
        new zzdci();
        return zzgcj.zze(zzgcj.zzm((zzgca) zzgcj.zzo(zzgca.zzu(uc2VarZzp.zzc().zzb()), ((Long) n42.d.c.zza(zzbbw.zzgt)).longValue(), TimeUnit.MILLISECONDS, zzeuvVar.zzc), new zzful() { // from class: com.google.android.gms.internal.ads.zzeus
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                v32 v32Var = (v32) obj;
                return v32Var != null ? new zzeuw(v32Var.a) : new zzeuw(null);
            }
        }, zzeuvVar.zzb), Exception.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzeut
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                k92.f();
                return new zzeuw(null);
            }
        }, zzeuvVar.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 33;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return (!((Boolean) n42.d.c.zza(zzbbw.zzgs)).booleanValue() || this.zze.zzr) ? zzgcj.zzh(new zzeuw(null)) : zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzeuu
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final do0 zza() {
                return zzeuv.zzc(this.zza);
            }
        }, this.zzb);
    }
}
