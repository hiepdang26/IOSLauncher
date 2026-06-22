package com.google.android.gms.internal.ads;

import defpackage.k92;
import defpackage.n42;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfu {
    private static final Pattern zza = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*\\s*<!DOCTYPE(\\s)+html(|(\\s)+[^>]*)>", 2);
    private static final Pattern zzb = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);

    public static String zza(zzfel zzfelVar) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzeC)).booleanValue() && zzfelVar.zzT && zzfelVar.zzV.zzb() && zzfelVar.zzb != 4) {
            zzeek zzeekVar = zzfelVar.zzV.zzc() == 1 ? zzeek.VIDEO : zzeek.HTML_DISPLAY;
            String str = zzfelVar.zzal;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("creativeType", zzeekVar.toString());
                jSONObject.put("contentUrl", str);
                return "<script>Object.defineProperty(window,'GOOG_OMID_JAVASCRIPT_SESSION_SERVICE_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
            } catch (JSONException unused) {
                k92.j(5);
            }
        }
        return null;
    }

    public static String zzb(String str, String... strArr) {
        String str2;
        StringBuilder sb = new StringBuilder();
        Matcher matcher = zza.matcher(str);
        if (matcher.find()) {
            int iEnd = matcher.end();
            sb.append(str.substring(0, iEnd));
            String str3 = strArr[0];
            if (str3 != null) {
                sb.append(str3);
            }
            sb.append(str.substring(iEnd));
        } else {
            if (!zzb.matcher(str).find() && (str2 = strArr[0]) != null) {
                sb.append(str2);
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
