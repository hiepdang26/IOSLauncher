package com.google.android.gms.internal.ads;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfs extends zzcfr {
    public zzcfs(zzcej zzcejVar, zzbav zzbavVar, boolean z, zzeds zzedsVar) {
        super(zzcejVar, zzbavVar, z, zzedsVar);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzS(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
