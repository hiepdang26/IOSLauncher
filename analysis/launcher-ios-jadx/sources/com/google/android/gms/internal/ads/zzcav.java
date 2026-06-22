package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcav implements Runnable {
    final /* synthetic */ zzcay zza;

    public zzcav(zzcay zzcayVar) {
        this.zza = zzcayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzK("surfaceCreated", new String[0]);
    }
}
