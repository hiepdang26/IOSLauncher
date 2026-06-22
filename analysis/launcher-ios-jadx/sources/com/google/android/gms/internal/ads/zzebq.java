package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.do0;
import defpackage.k92;
import defpackage.n42;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzebq {
    private final zzbuv zza;

    public zzebq(zzbuv zzbuvVar) {
        this.zza = zzbuvVar;
    }

    public static void zza(Map map, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pii");
        if (jSONObjectOptJSONObject == null) {
            k92.a("DSID signal does not exist.");
            return;
        }
        if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos", ""))) {
            map.put("x-afma-drt-cookie", jSONObjectOptJSONObject.optString("doritos", ""));
        }
        if (TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos_v2", ""))) {
            return;
        }
        map.put("x-afma-drt-v2-cookie", jSONObjectOptJSONObject.optString("doritos_v2", ""));
    }

    public final void zzb() {
        do0 do0VarZza = this.zza.zza();
        if (((Boolean) n42.d.c.zza(zzbbw.zzgT)).booleanValue()) {
            zzbzr.zzb(do0VarZza, "persistFlags");
        } else {
            zzbzr.zza(do0VarZza, "persistFlags");
        }
    }
}
