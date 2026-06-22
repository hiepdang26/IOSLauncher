package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
final class zzfnc implements Runnable {
    final /* synthetic */ zzfnd zza;
    private final WebView zzb;

    public zzfnc(zzfnd zzfndVar) {
        this.zza = zzfndVar;
        this.zzb = zzfndVar.zza;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.destroy();
    }
}
