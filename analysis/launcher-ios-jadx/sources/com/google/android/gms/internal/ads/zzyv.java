package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzyv implements Runnable {
    private final zzyu zza;

    public zzyv(zzyu zzyuVar) {
        this.zza = zzyuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzL();
    }
}
