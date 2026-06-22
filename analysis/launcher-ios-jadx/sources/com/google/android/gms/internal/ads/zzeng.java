package com.google.android.gms.internal.ads;

import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
final class zzeng implements zzgcf {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzfju zzc;
    final /* synthetic */ zzdhl zzd;
    final /* synthetic */ zzenh zze;

    public zzeng(zzenh zzenhVar, zzemz zzemzVar, zzfkf zzfkfVar, zzfju zzfjuVar, zzdhl zzdhlVar) {
        this.zza = zzemzVar;
        this.zzb = zzfkfVar;
        this.zzc = zzfjuVar;
        this.zzd = zzdhlVar;
        this.zze = zzenhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzfkf zzfkfVar;
        final j92 j92VarZza = this.zzd.zza().zza(th);
        this.zzd.zzb().zzdB(j92VarZza);
        this.zze.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzenf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze.zzd.zza().zzdB(j92VarZza);
            }
        });
        zzfgd.zzb(j92VarZza.g, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (((Boolean) zzbdl.zzc.zze()).booleanValue() && (zzfkfVar = this.zzb) != null) {
            zzfkfVar.zzc(j92VarZza);
            zzfju zzfjuVar = this.zzc;
            zzfjuVar.zzh(th);
            zzfjuVar.zzg(false);
            zzfkfVar.zza(zzfjuVar);
            zzfkfVar.zzh();
            return;
        }
        zzenh zzenhVar = this.zze;
        zzfju zzfjuVar2 = this.zzc;
        zzfki zzfkiVar = zzenhVar.zze;
        zzfjuVar2.zza(j92VarZza);
        zzfjuVar2.zzh(th);
        zzfjuVar2.zzg(false);
        zzfkiVar.zzb(zzfjuVar2.zzm());
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkf zzfkfVar;
        zzcru zzcruVar = (zzcru) obj;
        synchronized (this.zze) {
            try {
                zzcruVar.zzo().zza(this.zze.zzd.zzd());
                this.zza.zzb(zzcruVar);
                this.zze.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzene
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzb().zzs();
                    }
                });
                if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkfVar = this.zzb) == null) {
                    zzfki zzfkiVar = this.zze.zze;
                    zzfju zzfjuVar = this.zzc;
                    zzfjuVar.zzb(zzcruVar.zzq().zzb);
                    zzfjuVar.zzd(zzcruVar.zzm().zzg());
                    zzfjuVar.zzg(true);
                    zzfkiVar.zzb(zzfjuVar.zzm());
                } else {
                    zzfkfVar.zzg(zzcruVar.zzq().zzb);
                    zzfkfVar.zze(zzcruVar.zzm().zzg());
                    zzfju zzfjuVar2 = this.zzc;
                    zzfjuVar2.zzg(true);
                    zzfkfVar.zza(zzfjuVar2);
                    zzfkfVar.zzh();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
