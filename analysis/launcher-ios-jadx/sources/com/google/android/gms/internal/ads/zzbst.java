package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbst {
    public final boolean zza;
    public final String zzb;
    public final boolean zzc;

    public zzbst(boolean z, String str, boolean z2) {
        this.zza = z;
        this.zzb = str;
        this.zzc = z2;
    }

    public static zzbst zza(JSONObject jSONObject) {
        return new zzbst(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""), jSONObject.optBoolean("skip_offline_notification_flow", false));
    }
}
