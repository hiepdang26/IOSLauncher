package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcfh implements Runnable {
    final /* synthetic */ zzcfi zza;

    public zzcfh(zzcfi zzcfiVar) {
        this.zza = zzcfiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
