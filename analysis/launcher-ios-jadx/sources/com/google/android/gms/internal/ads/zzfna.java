package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public final class zzfna extends zzfmz {
    public zzfna(String str, WebView webView) {
        super(str);
        if (!webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        zzm(webView);
    }
}
