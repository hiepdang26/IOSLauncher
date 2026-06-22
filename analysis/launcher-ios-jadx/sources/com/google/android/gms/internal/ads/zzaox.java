package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaox implements Runnable {
    private final zzaph zza;
    private final zzapn zzb;
    private final Runnable zzc;

    public zzaox(zzaph zzaphVar, zzapn zzapnVar, Runnable runnable) {
        this.zza = zzaphVar;
        this.zzb = zzapnVar;
        this.zzc = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzw();
        zzapn zzapnVar = this.zzb;
        if (zzapnVar.zzc()) {
            this.zza.zzo(zzapnVar.zza);
        } else {
            this.zza.zzn(zzapnVar.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzm("intermediate-response");
        } else {
            this.zza.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
