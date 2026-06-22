package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import defpackage.hs0;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfeq {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    public zzfeq(JsonReader jsonReader) throws JSONException, IOException {
        JSONObject jSONObjectY = hs0.y(jsonReader);
        this.zzd = jSONObjectY;
        this.zza = jSONObjectY.optString("ad_html", null);
        this.zzb = jSONObjectY.optString("ad_base_url", null);
        this.zzc = jSONObjectY.optJSONObject("ad_json");
    }
}
