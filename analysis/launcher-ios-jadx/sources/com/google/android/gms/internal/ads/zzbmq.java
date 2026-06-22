package com.google.android.gms.internal.ads;

import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
final class zzbmq implements zzbzv {
    final /* synthetic */ zzbmz zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzbna zzc;

    public zzbmq(zzbna zzbnaVar, zzbmz zzbmzVar, zzfju zzfjuVar) {
        this.zza = zzbmzVar;
        this.zzb = zzfjuVar;
        this.zzc = zzbnaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzv
    public final void zza() {
        k92.a("loadNewJavascriptEngine (failure): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            try {
                k92.a("loadNewJavascriptEngine (failure): Lock acquired");
                this.zzc.zzi = 1;
                k92.a("Failed loading new engine. Marking new engine destroyable.");
                this.zza.zzb();
                if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
                    zzbna zzbnaVar = this.zzc;
                    if (zzbnaVar.zze != null) {
                        zzfki zzfkiVar = zzbnaVar.zze;
                        zzfju zzfjuVar = this.zzb;
                        zzfjuVar.zzc("Failed loading new engine");
                        zzfjuVar.zzg(false);
                        zzfkiVar.zzb(zzfjuVar.zzm());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        k92.a("loadNewJavascriptEngine (failure): Lock released");
    }
}
