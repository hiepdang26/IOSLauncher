package com.google.android.gms.internal.ads;

import defpackage.j92;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzezq implements zzgcf {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzfju zzc;
    final /* synthetic */ zzezs zzd;
    final /* synthetic */ zzezt zze;

    public zzezq(zzezt zzeztVar, zzemz zzemzVar, zzfkf zzfkfVar, zzfju zzfjuVar, zzezs zzezsVar) {
        this.zza = zzemzVar;
        this.zzb = zzfkfVar;
        this.zzc = zzfjuVar;
        this.zzd = zzezsVar;
        this.zze = zzeztVar;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.google.android.gms.internal.ads.zzcvx, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzfkf zzfkfVar;
        zzcou zzcouVar = (zzcou) this.zze.zze.zzd();
        final j92 j92VarZzb = zzcouVar == null ? zzfgi.zzb(th, null) : zzcouVar.zzb().zza(th);
        synchronized (this.zze) {
            try {
                this.zze.zzj = null;
                if (zzcouVar != null) {
                    zzcouVar.zzc().zzdB(j92VarZzb);
                    if (((Boolean) n42.d.c.zza(zzbbw.zzhq)).booleanValue()) {
                        this.zze.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzezp
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zze.zzd.zzdB(j92VarZzb);
                            }
                        });
                    }
                } else {
                    this.zze.zzd.zzdB(j92VarZzb);
                    this.zze.zzm(this.zzd).zzh().zzb().zzc().zzh();
                }
                zzfgd.zzb(j92VarZzb.g, th, "AppOpenAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkfVar = this.zzb) == null) {
                    zzfki zzfkiVar = this.zze.zzh;
                    zzfju zzfjuVar = this.zzc;
                    zzfjuVar.zza(j92VarZzb);
                    zzfjuVar.zzh(th);
                    zzfjuVar.zzg(false);
                    zzfkiVar.zzb(zzfjuVar.zzm());
                } else {
                    zzfkfVar.zzc(j92VarZzb);
                    zzfju zzfjuVar2 = this.zzc;
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
    public final void zzb(Object obj) {
        zzfkf zzfkfVar;
        zzcru zzcruVar = (zzcru) obj;
        synchronized (this.zze) {
            try {
                this.zze.zzj = null;
                if (((Boolean) n42.d.c.zza(zzbbw.zzhq)).booleanValue()) {
                    zzcruVar.zzo().zzb(this.zze.zzd);
                }
                this.zza.zzb(zzcruVar);
                if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkfVar = this.zzb) == null) {
                    zzfki zzfkiVar = this.zze.zzh;
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
