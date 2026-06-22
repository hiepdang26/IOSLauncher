package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzapf implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaph zzc;

    public zzapf(zzaph zzaphVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzaphVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        zzaph zzaphVar = this.zzc;
        zzaphVar.zza.zzb(zzaphVar.toString());
    }
}
