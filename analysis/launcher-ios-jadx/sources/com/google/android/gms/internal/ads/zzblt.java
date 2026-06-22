package com.google.android.gms.internal.ads;

import defpackage.k92;
import defpackage.x32;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzblt {
    public static void zza(zzblu zzbluVar, String str, Map map) {
        try {
            zzbluVar.zze(str, x32.f.a.h(map));
        } catch (JSONException unused) {
            k92.h("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzblu zzbluVar, String str, JSONObject jSONObject) {
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        k92.d("Dispatching AFMA event: ".concat(sb.toString()));
        zzbluVar.zza(sb.toString());
    }

    public static void zzc(zzblu zzbluVar, String str, String str2) {
        zzbluVar.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzblu zzbluVar, String str, JSONObject jSONObject) {
        zzbluVar.zzb(str, jSONObject.toString());
    }
}
