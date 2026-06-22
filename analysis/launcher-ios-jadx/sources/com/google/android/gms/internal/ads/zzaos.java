package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaos implements Runnable {
    final /* synthetic */ zzaph zza;
    final /* synthetic */ zzaot zzb;

    public zzaos(zzaot zzaotVar, zzaph zzaphVar) {
        this.zza = zzaphVar;
        this.zzb = zzaotVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
