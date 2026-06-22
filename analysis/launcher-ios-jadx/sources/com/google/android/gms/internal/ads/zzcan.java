package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcan implements Runnable {
    final /* synthetic */ zzcao zza;

    public zzcan(zzcao zzcaoVar) {
        this.zza = zzcaoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcao zzcaoVar = this.zza;
        if (zzcaoVar.zzq != null) {
            zzcaoVar.zzq.zzd();
        }
    }
}
