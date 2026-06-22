package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcal implements Runnable {
    final /* synthetic */ zzcao zza;

    public zzcal(zzcao zzcaoVar) {
        this.zza = zzcaoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcao zzcaoVar = this.zza;
        if (zzcaoVar.zzq != null) {
            zzcaoVar.zzq.zzd();
            this.zza.zzq.zzi();
        }
    }
}
