package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaug implements Runnable {
    final /* synthetic */ zzauh zza;

    public zzaug(zzauh zzauhVar) {
        this.zza = zzauhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzo) {
            if (this.zza.zzp) {
                return;
            }
            this.zza.zzp = true;
            try {
                zzauh.zzj(this.zza);
            } catch (Exception e) {
                this.zza.zzh.zzc(2023, -1L, e);
            }
            synchronized (this.zza.zzo) {
                this.zza.zzp = false;
            }
        }
    }
}
