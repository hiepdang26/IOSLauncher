package com.google.android.gms.internal.ads;

import defpackage.k92;
import defpackage.n42;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzdto {
    private Long zza;
    private final String zzb;
    private String zzc;
    private Integer zzd;
    private String zze;
    private Integer zzf;

    public /* synthetic */ zzdto(String str, zzdtn zzdtnVar) {
        this.zzb = str;
    }

    public static String zza(zzdto zzdtoVar) {
        String str = (String) n42.d.c.zza(zzbbw.zzjd);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdtoVar.zza);
            jSONObject.put("eventCategory", zzdtoVar.zzb);
            jSONObject.putOpt("event", zzdtoVar.zzc);
            jSONObject.putOpt("errorCode", zzdtoVar.zzd);
            jSONObject.putOpt("rewardType", zzdtoVar.zze);
            jSONObject.putOpt("rewardAmount", zzdtoVar.zzf);
        } catch (JSONException unused) {
            k92.h("Could not convert parameters to JSON.");
        }
        return str + "(\"h5adsEvent\"," + jSONObject.toString() + ");";
    }
}
