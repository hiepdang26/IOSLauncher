package com.google.android.gms.internal.ads;

import defpackage.hd2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbof {
    public final List zza;
    public final String zzb;
    public final String zzc;

    public zzbof(JSONObject jSONObject) throws JSONException {
        jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zza = Collections.unmodifiableList(arrayList);
        jSONObject.optString("allocation_id", null);
        hd2 hd2Var = hd2.B;
        zzboh zzbohVar = hd2Var.u;
        zzboh.zza(jSONObject, "clickurl");
        zzboh zzbohVar2 = hd2Var.u;
        zzboh.zza(jSONObject, "imp_urls");
        zzboh zzbohVar3 = hd2Var.u;
        zzboh.zza(jSONObject, "downloaded_imp_urls");
        zzboh zzbohVar4 = hd2Var.u;
        zzboh.zza(jSONObject, "fill_urls");
        zzboh zzbohVar5 = hd2Var.u;
        zzboh.zza(jSONObject, "video_start_urls");
        zzboh zzbohVar6 = hd2Var.u;
        zzboh.zza(jSONObject, "video_complete_urls");
        zzboh zzbohVar7 = hd2Var.u;
        zzboh.zza(jSONObject, "video_reward_urls");
        jSONObject.optString("transaction_id");
        jSONObject.optString("valid_from_timestamp");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ad");
        if (jSONObjectOptJSONObject != null) {
            zzboh zzbohVar8 = hd2Var.u;
            zzboh.zza(jSONObjectOptJSONObject, "manual_impression_urls");
        }
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.toString();
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
        this.zzb = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.toString() : null;
        if (jSONObjectOptJSONObject2 != null) {
            jSONObjectOptJSONObject2.optString("class_name");
        }
        jSONObject.optString("html_template", null);
        jSONObject.optString("ad_base_url", null);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("assets");
        if (jSONObjectOptJSONObject3 != null) {
            jSONObjectOptJSONObject3.toString();
        }
        zzboh zzbohVar9 = hd2Var.u;
        zzboh.zza(jSONObject, "template_ids");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        if (jSONObjectOptJSONObject4 != null) {
            jSONObjectOptJSONObject4.toString();
        }
        this.zzc = jSONObject.optString("response_type", null);
        jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
