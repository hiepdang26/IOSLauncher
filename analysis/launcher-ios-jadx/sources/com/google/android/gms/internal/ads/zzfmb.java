package com.google.android.gms.internal.ads;

import android.view.View;
import android.webkit.WebView;
import defpackage.np1;
import defpackage.ow1;
import defpackage.tw1;
import defpackage.vd;
import defpackage.ww1;
import defpackage.xw1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public final class zzfmb {
    private final zzfmd zza;
    private final WebView zzb;
    private final HashMap zzc = new HashMap();
    private final zzfmp zzd = new zzfmp();

    private zzfmb(zzfmd zzfmdVar, WebView webView, boolean z) {
        zzfnj.zza();
        this.zza = zzfmdVar;
        this.zzb = webView;
        if (!np1.z("WEB_MESSAGE_LISTENER")) {
            throw new UnsupportedOperationException("The JavaScriptSessionService cannot be supported in this WebView version.");
        }
        zzg();
        zzfma zzfmaVar = new zzfma(this);
        HashSet hashSet = new HashSet(Arrays.asList("*"));
        int i = tw1.a;
        if (!ww1.c.b()) {
            throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
        }
        WebViewProviderBoundaryInterface webViewProviderBoundaryInterfaceCreateWebView = xw1.a.createWebView(webView);
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        ow1 ow1Var = new ow1(0);
        ow1Var.h = zzfmaVar;
        webViewProviderBoundaryInterfaceCreateWebView.addWebMessageListener("omidJsSessionService", strArr, new vd(ow1Var));
    }

    public static zzfmb zza(zzfmd zzfmdVar, WebView webView, boolean z) {
        return new zzfmb(zzfmdVar, webView, true);
    }

    public static /* bridge */ /* synthetic */ void zzb(zzfmb zzfmbVar, String str) {
        zzflq zzflqVar = (zzflq) zzfmbVar.zzc.get(str);
        if (zzflqVar != null) {
            zzflqVar.zzc();
            zzfmbVar.zzc.remove(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* bridge */ /* synthetic */ void zzd(zzfmb zzfmbVar, String str) {
        zzflv zzflvVar = zzflv.DEFINED_BY_JAVASCRIPT;
        zzfly zzflyVar = zzfly.DEFINED_BY_JAVASCRIPT;
        zzfmc zzfmcVar = zzfmc.JAVASCRIPT;
        zzflu zzfluVar = new zzflu(zzflr.zza(zzflvVar, zzflyVar, zzfmcVar, zzfmcVar, false), zzfls.zzb(zzfmbVar.zza, zzfmbVar.zzb, null, null), str);
        zzfmbVar.zzc.put(str, zzfluVar);
        zzfluVar.zzd(zzfmbVar.zzb);
        for (zzfmo zzfmoVar : zzfmbVar.zzd.zza()) {
            zzfluVar.zzb((View) zzfmoVar.zzb().get(), zzfmoVar.zza(), zzfmoVar.zzc());
        }
        zzfluVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        WebView webView = this.zzb;
        int i = tw1.a;
        if (!ww1.c.b()) {
            throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
        }
        xw1.a.createWebView(webView).removeWebMessageListener("omidJsSessionService");
    }

    public final void zze(View view, zzflx zzflxVar, String str) {
        Iterator it = this.zzc.values().iterator();
        while (it.hasNext()) {
            ((zzflq) it.next()).zzb(view, zzflxVar, "Ad overlay");
        }
        this.zzd.zzb(view, zzflxVar, "Ad overlay");
    }

    public final void zzf(zzcey zzceyVar) {
        Iterator it = this.zzc.values().iterator();
        while (it.hasNext()) {
            ((zzflq) it.next()).zzc();
        }
        Timer timer = new Timer();
        timer.schedule(new zzflz(this, zzceyVar, timer), 1000L);
    }
}
