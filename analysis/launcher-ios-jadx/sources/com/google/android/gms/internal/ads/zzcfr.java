package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.l52;
import defpackage.n42;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class zzcfr extends zzcer {
    public zzcfr(zzcej zzcejVar, zzbav zzbavVar, boolean z, zzeds zzedsVar) {
        super(zzcejVar, zzbavVar, z, new zzbrp(zzcejVar, zzcejVar.zzE(), new zzbbe(zzcejVar.getContext())), null, zzedsVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebResourceResponse zzS(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcej)) {
            k92.h("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcej zzcejVar = (zzcej) webView;
        zzbxl zzbxlVar = this.zza;
        if (zzbxlVar != null) {
            zzbxlVar.zzd(str, map, 1);
        }
        zzfqt.zza();
        int i = zzfqy.zza;
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            return zzc(str, map);
        }
        if (zzcejVar.zzN() != null) {
            zzcejVar.zzN().zzF();
        }
        if (zzcejVar.zzO().zzi()) {
            str2 = (String) n42.d.c.zza(zzbbw.zzH);
        } else if (zzcejVar.zzaF()) {
            str2 = (String) n42.d.c.zza(zzbbw.zzG);
        } else {
            str2 = (String) n42.d.c.zza(zzbbw.zzF);
        }
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        Context context = zzcejVar.getContext();
        String str3 = zzcejVar.zzn().g;
        try {
            HashMap map2 = new HashMap();
            map2.put("User-Agent", hd2Var.c.w(context, str3));
            map2.put("Cache-Control", "max-stale=3600");
            new l52(context);
            String str4 = (String) l52.a(0, str2, map2, null).get(60L, TimeUnit.SECONDS);
            if (str4 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str4.getBytes("UTF-8")));
            }
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException unused) {
            k92.j(5);
        }
        return null;
    }
}
