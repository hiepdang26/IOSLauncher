package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcak implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcao zzc;

    public zzcak(zzcao zzcaoVar, int i, int i2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzcaoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcao zzcaoVar = this.zzc;
        if (zzcaoVar.zzq != null) {
            zzcaoVar.zzq.zzj(this.zza, this.zzb);
        }
    }
}
