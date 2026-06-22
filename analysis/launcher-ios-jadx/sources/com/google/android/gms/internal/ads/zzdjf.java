package com.google.android.gms.internal.ads;

import defpackage.hs0;
import defpackage.n42;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjf extends zzdjg {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final JSONObject zzh;

    public zzdjf(zzfel zzfelVar, JSONObject jSONObject) {
        super(zzfelVar);
        String[] strArr = {"tracking_urls_and_actions", "active_view"};
        JSONObject jSONObjectC = hs0.C(jSONObject, strArr);
        this.zzb = jSONObjectC == null ? null : jSONObjectC.optJSONObject(strArr[1]);
        String[] strArr2 = {"allow_pub_owned_ad_view"};
        JSONObject jSONObjectC2 = hs0.C(jSONObject, strArr2);
        this.zzc = jSONObjectC2 == null ? false : jSONObjectC2.optBoolean(strArr2[0], false);
        String[] strArr3 = {"attribution", "allow_pub_rendering"};
        JSONObject jSONObjectC3 = hs0.C(jSONObject, strArr3);
        this.zzd = jSONObjectC3 == null ? false : jSONObjectC3.optBoolean(strArr3[1], false);
        String[] strArr4 = {"enable_omid"};
        JSONObject jSONObjectC4 = hs0.C(jSONObject, strArr4);
        this.zze = jSONObjectC4 == null ? false : jSONObjectC4.optBoolean(strArr4[0], false);
        String[] strArr5 = {"watermark_overlay_png_base64"};
        JSONObject jSONObjectC5 = hs0.C(jSONObject, strArr5);
        this.zzg = jSONObjectC5 != null ? jSONObjectC5.optString(strArr5[0], "") : "";
        this.zzf = jSONObject.optJSONObject("overlay") != null;
        if (((Boolean) n42.d.c.zza(zzbbw.zzeF)).booleanValue()) {
            this.zzh = jSONObject.optJSONObject("omid_settings");
        } else {
            this.zzh = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final zzffj zza() {
        JSONObject jSONObject = this.zzh;
        return jSONObject != null ? new zzffj(jSONObject) : this.zza.zzV;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final String zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final JSONObject zzc() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzz);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final boolean zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final boolean zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final boolean zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final boolean zzg() {
        return this.zzf;
    }
}
