package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcax implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcay zzb;

    public zzcax(zzcay zzcayVar, boolean z) {
        this.zza = z;
        this.zzb = zzcayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
