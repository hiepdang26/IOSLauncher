package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzcqy implements Runnable {
    public final /* synthetic */ AtomicReference zza;

    public /* synthetic */ zzcqy(AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcra.zzj(this.zza);
    }
}
