package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import defpackage.cd2;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfp {
    private final zzcfq zza;
    private final zzcfo zzb;

    public zzcfp(zzcfq zzcfqVar, zzcfo zzcfoVar) {
        this.zzb = zzcfoVar;
        this.zza = zzcfqVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzcfq, com.google.android.gms.internal.ads.zzcfw] */
    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            k92.a("Click string is empty, not proceeding.");
            return "";
        }
        ?? r0 = this.zza;
        zzauo zzauoVarZzI = r0.zzI();
        if (zzauoVarZzI == null) {
            k92.a("Signal utils is empty, ignoring.");
            return "";
        }
        zzauk zzaukVarZzc = zzauoVarZzI.zzc();
        if (zzaukVarZzc == null) {
            k92.a("Signals object is empty, ignoring.");
            return "";
        }
        if (r0.getContext() == null) {
            k92.a("Context is null, ignoring.");
            return "";
        }
        zzcfq zzcfqVar = this.zza;
        return zzaukVarZzc.zzf(zzcfqVar.getContext(), str, (View) zzcfqVar, zzcfqVar.zzi());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzcfq, com.google.android.gms.internal.ads.zzcfw] */
    @JavascriptInterface
    public String getViewSignals() {
        ?? r0 = this.zza;
        zzauo zzauoVarZzI = r0.zzI();
        if (zzauoVarZzI == null) {
            k92.a("Signal utils is empty, ignoring.");
            return "";
        }
        zzauk zzaukVarZzc = zzauoVarZzI.zzc();
        if (zzaukVarZzc == null) {
            k92.a("Signals object is empty, ignoring.");
            return "";
        }
        if (r0.getContext() == null) {
            k92.a("Context is null, ignoring.");
            return "";
        }
        zzcfq zzcfqVar = this.zza;
        return zzaukVarZzc.zzh(zzcfqVar.getContext(), (View) zzcfqVar, zzcfqVar.zzi());
    }

    @JavascriptInterface
    public void notify(final String str) {
        if (TextUtils.isEmpty(str)) {
            k92.h("URL is empty, ignoring message");
        } else {
            cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfn
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(str);
                }
            });
        }
    }

    public final /* synthetic */ void zza(String str) {
        Uri uri = Uri.parse(str);
        zzcer zzcerVarZzaO = ((zzcfi) this.zzb.zza).zzaO();
        if (zzcerVarZzaO == null) {
            k92.e("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzcerVarZzaO.zzj(uri);
        }
    }
}
