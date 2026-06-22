package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.webkit.WebView;
import defpackage.ai0;
import defpackage.nw1;
import defpackage.sw1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzfma implements sw1 {
    final /* synthetic */ zzfmb zza;

    public zzfma(zzfmb zzfmbVar) {
        this.zza = zzfmbVar;
    }

    @Override // defpackage.sw1
    public final void onPostMessage(WebView webView, nw1 nw1Var, Uri uri, boolean z, ai0 ai0Var) {
        int i = nw1Var.b;
        if (i != 0) {
            StringBuilder sb = new StringBuilder("Wrong data accessor type detected. ");
            sb.append(i != 0 ? i != 1 ? "Unknown" : "ArrayBuffer" : "String");
            sb.append(" expected, but got ");
            sb.append("String");
            throw new IllegalStateException(sb.toString());
        }
        try {
            JSONObject jSONObject = new JSONObject(nw1Var.a);
            String string = jSONObject.getString("method");
            String string2 = jSONObject.getJSONObject("data").getString("adSessionId");
            if (string.equals("startSession")) {
                zzfmb.zzd(this.zza, string2);
            } else if (string.equals("finishSession")) {
                zzfmb.zzb(this.zza, string2);
            } else {
                zzfln.zza.getClass();
            }
        } catch (JSONException e) {
            zzfng.zza("Error parsing JS message in JavaScriptSessionService.", e);
        }
    }
}
