package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import defpackage.k92;
import defpackage.uy0;
import defpackage.ya0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbkf extends zzbjs {
    public static final /* synthetic */ int zza = 0;
    private WebViewClient zzb;
    private final ya0 zzc;
    private final WebView zzd;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.ads.zzbke] */
    public zzbkf(Context context, final WebView webView) {
        context.getClass();
        webView.getClass();
        zzfuu.zzf(webView.getSettings().getJavaScriptEnabled(), "JavaScript must be enabled on the WebView.");
        this.zzd = webView;
        this.zzc = new ya0(context, new uy0() { // from class: com.google.android.gms.internal.ads.zzbke
            @Override // defpackage.uy0
            public final void onH5AdsEvent(String str) {
                int i = zzbkf.zza;
                webView.evaluateJavascript(str, null);
            }
        });
    }

    private final boolean zzc(WebView webView) {
        if (this.zzd.equals(webView)) {
            return true;
        }
        k92.e("H5AdsWebViewClient must be attached to the same WebVew which was passed in the constructor.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbjs
    public final WebViewClient getDelegate() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbjs, android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        if (zzc(webView) && !this.zzc.a.zzb(str)) {
            super.onLoadResource(webView, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjs, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (!zzc(this.zzd)) {
            return false;
        }
        if (this.zzc.a.zzb(webResourceRequest.getUrl().toString())) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public final void zza() {
        this.zzc.a.zza();
    }

    public final void zzb(WebViewClient webViewClient) {
        zzfuu.zzf(webViewClient != this, "Delegate cannot be itself.");
        this.zzb = webViewClient;
    }

    @Override // com.google.android.gms.internal.ads.zzbjs, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!zzc(webView)) {
            return false;
        }
        if (this.zzc.a.zzb(str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
