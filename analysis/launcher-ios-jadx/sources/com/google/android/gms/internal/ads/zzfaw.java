package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfaw implements zzgcf {
    final /* synthetic */ zzfkf zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzcql zzc;
    final /* synthetic */ zzfax zzd;

    public zzfaw(zzfax zzfaxVar, zzfkf zzfkfVar, zzfju zzfjuVar, zzcql zzcqlVar) {
        this.zza = zzfkfVar;
        this.zzb = zzfjuVar;
        this.zzc = zzcqlVar;
        this.zzd = zzfaxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzfkf zzfkfVar;
        this.zzd.zzn = this.zzc.zzd().zza(th);
        synchronized (this.zzd) {
            try {
                this.zzc.zzf().zzdB(this.zzd.zzn);
                zzfgd.zzb(this.zzd.zzn.g, th, "BannerAdLoader.onFailure");
                zzfax zzfaxVar = this.zzd;
                if (zzfaxVar.zzm) {
                    zzfaxVar.zzu();
                    zzfax zzfaxVar2 = this.zzd;
                    zzfaxVar2.zzh.zzd(zzfaxVar2.zzj.zzc());
                }
                if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkfVar = this.zza) == null) {
                    zzfax zzfaxVar3 = this.zzd;
                    zzfki zzfkiVar = zzfaxVar3.zzi;
                    zzfju zzfjuVar = this.zzb;
                    zzfjuVar.zza(zzfaxVar3.zzn);
                    zzfjuVar.zzh(th);
                    zzfjuVar.zzg(false);
                    zzfkiVar.zzb(zzfjuVar.zzm());
                } else {
                    zzfkfVar.zzc(this.zzd.zzn);
                    zzfju zzfjuVar2 = this.zzb;
                    zzfjuVar2.zzh(th);
                    zzfjuVar2.zzg(false);
                    zzfkfVar.zza(zzfjuVar2);
                    zzfkfVar.zzh();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkf zzfkfVar;
        zzcpk zzcpkVar = (zzcpk) obj;
        synchronized (this.zzd) {
            try {
                zzfax zzfaxVar = this.zzd;
                if (zzfaxVar.zzm) {
                    zzfaxVar.zzr();
                }
                if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkfVar = this.zza) == null) {
                    zzfki zzfkiVar = this.zzd.zzi;
                    zzfju zzfjuVar = this.zzb;
                    zzfjuVar.zzb(zzcpkVar.zzq().zzb);
                    zzfjuVar.zzd(zzcpkVar.zzm().zzg());
                    zzfjuVar.zzg(true);
                    zzfkiVar.zzb(zzfjuVar.zzm());
                } else {
                    zzfkfVar.zzg(zzcpkVar.zzq().zzb);
                    zzfkfVar.zze(zzcpkVar.zzm().zzg());
                    zzfju zzfjuVar2 = this.zzb;
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
