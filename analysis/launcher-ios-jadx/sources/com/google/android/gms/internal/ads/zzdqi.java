package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.n42;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdqi {
    public static String zza(JSONObject jSONObject, String str, String str2) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(str2)) != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("including");
                    JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("excluding");
                    if (zzb(jSONArrayOptJSONArray2, str) && !zzb(jSONArrayOptJSONArray3, str)) {
                        return jSONObjectOptJSONObject.optString("effective_ad_unit_id", "");
                    }
                }
            }
        }
        return "";
    }

    private static boolean zzb(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i);
                try {
                } catch (PatternSyntaxException e) {
                    hd2.B.g.zzw(e, "RtbAdapterMap.hasAtleastOneRegexMatch");
                }
                if ((((Boolean) n42.d.c.zza(zzbbw.zzjX)).booleanValue() ? Pattern.compile(strOptString, 2) : Pattern.compile(strOptString)).matcher(str).lookingAt()) {
                    return true;
                }
            }
        }
        return false;
    }
}
