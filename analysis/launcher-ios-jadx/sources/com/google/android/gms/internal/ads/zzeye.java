package com.google.android.gms.internal.ads;

import defpackage.hs0;
import defpackage.k92;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzeye implements zzevn {
    private final String zza;
    private final String zzb;

    public zzeye(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            JSONObject jSONObjectX = hs0.x((JSONObject) obj, "pii");
            jSONObjectX.put("doritos", this.zza);
            jSONObjectX.put("doritos_v2", this.zzb);
        } catch (JSONException unused) {
            k92.a("Failed putting doritos string.");
        }
    }
}
