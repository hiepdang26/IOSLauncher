package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcaw implements Runnable {
    final /* synthetic */ zzcay zza;

    public zzcaw(zzcay zzcayVar) {
        this.zza = zzcayVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzK("surfaceDestroyed", new String[0]);
    }
}
