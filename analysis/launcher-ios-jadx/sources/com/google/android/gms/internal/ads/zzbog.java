package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.k92;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbog {
    public final List zza;

    public zzbog(JSONObject jSONObject) throws JSONException {
        if (k92.j(2)) {
            k92.a("Mediation Response JSON: ".concat(String.valueOf(jSONObject.toString(2))));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzbof zzbofVar = new zzbof(jSONArray.getJSONObject(i2));
                "banner".equalsIgnoreCase(zzbofVar.zzc);
                arrayList.add(zzbofVar);
                if (i < 0) {
                    Iterator it = zzbofVar.zza.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((String) it.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                i = i2;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        jSONArray.length();
        this.zza = Collections.unmodifiableList(arrayList);
        jSONObject.optString("qdata");
        jSONObject.optInt("fs_model_type", -1);
        jSONObject.optLong("timeout_ms", -1L);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optLong("ad_network_timeout_millis", -1L);
            hd2 hd2Var = hd2.B;
            zzboh zzbohVar = hd2Var.u;
            zzboh.zza(jSONObjectOptJSONObject, "click_urls");
            zzboh zzbohVar2 = hd2Var.u;
            zzboh.zza(jSONObjectOptJSONObject, "imp_urls");
            zzboh zzbohVar3 = hd2Var.u;
            zzboh.zza(jSONObjectOptJSONObject, "downloaded_imp_urls");
            zzboh zzbohVar4 = hd2Var.u;
            zzboh.zza(jSONObjectOptJSONObject, "nofill_urls");
            zzboh zzbohVar5 = hd2Var.u;
            zzboh.zza(jSONObjectOptJSONObject, "remote_ping_urls");
            jSONObjectOptJSONObject.optBoolean("render_in_browser", false);
            jSONObjectOptJSONObject.optLong("refresh", -1L);
            zzbvz.zza(jSONObjectOptJSONObject.optJSONArray("rewards"));
            jSONObjectOptJSONObject.optBoolean("use_displayed_impression", false);
            jSONObjectOptJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            jSONObjectOptJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            jSONObjectOptJSONObject.optBoolean("allow_custom_click_gesture", false);
        }
    }
}
