package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcam implements Runnable {
    final /* synthetic */ zzcao zza;

    public zzcam(zzcao zzcaoVar) {
        this.zza = zzcaoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcao zzcaoVar = this.zza;
        if (zzcaoVar.zzq != null) {
            if (!zzcaoVar.zzr) {
                zzcaoVar.zzq.zzg();
                this.zza.zzr = true;
            }
            this.zza.zzq.zze();
        }
    }
}
