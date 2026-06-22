package com.google.android.gms.internal.ads;

import defpackage.n42;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzdvc {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private final int zzf;
    private final boolean zzg;

    public zzdvc(String str, String str2, String str3, int i, String str4, int i2, boolean z) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = i;
        this.zze = str4;
        this.zzf = i2;
        this.zzg = z;
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adapterClassName", this.zza);
        jSONObject.put("version", this.zzc);
        zzbbn zzbbnVar = zzbbw.zziw;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            jSONObject.put("sdkVersion", this.zzb);
        }
        jSONObject.put("status", this.zzd);
        jSONObject.put("description", this.zze);
        jSONObject.put("initializationLatencyMillis", this.zzf);
        if (((Boolean) n42Var.c.zza(zzbbw.zzix)).booleanValue()) {
            jSONObject.put("supportsInitialization", this.zzg);
        }
        return jSONObject;
    }
}
