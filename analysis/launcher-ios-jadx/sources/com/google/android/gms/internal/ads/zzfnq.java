package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfnq implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        if (zzfnt.zzc != null) {
            zzfnt.zzc.post(zzfnt.zzd);
            zzfnt.zzc.postDelayed(zzfnt.zze, 200L);
        }
    }
}
