package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
final class zzfmr implements Runnable {
    final /* synthetic */ WebView zza;
    final /* synthetic */ String zzb;

    public zzfmr(zzfms zzfmsVar, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfms.zzj(this.zza, this.zzb);
    }
}
