package com.google.android.gms.internal.ads;

import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
final class zzbmp implements zzbzx {
    final /* synthetic */ zzbmz zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzbna zzc;

    public zzbmp(zzbna zzbnaVar, zzbmz zzbmzVar, zzfju zzfjuVar) {
        this.zza = zzbmzVar;
        this.zzb = zzfjuVar;
        this.zzc = zzbnaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        k92.a("loadNewJavascriptEngine (success): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            try {
                k92.a("loadNewJavascriptEngine (success): Lock acquired");
                this.zzc.zzi = 0;
                zzbna zzbnaVar = this.zzc;
                if (zzbnaVar.zzh != null && this.zza != zzbnaVar.zzh) {
                    k92.a("New JS engine is loaded, marking previous one as destroyable.");
                    this.zzc.zzh.zzb();
                }
                this.zzc.zzh = this.zza;
                if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
                    zzbna zzbnaVar2 = this.zzc;
                    if (zzbnaVar2.zze != null) {
                        zzfki zzfkiVar = zzbnaVar2.zze;
                        zzfju zzfjuVar = this.zzb;
                        zzfjuVar.zzg(true);
                        zzfkiVar.zzb(zzfjuVar.zzm());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        k92.a("loadNewJavascriptEngine (success): Lock released");
    }
}
