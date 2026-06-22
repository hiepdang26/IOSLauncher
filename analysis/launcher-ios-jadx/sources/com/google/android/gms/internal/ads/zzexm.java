package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.hs0;
import defpackage.k92;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzexm implements zzevn {
    final String zza;
    final int zzb;

    public zzexm(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (TextUtils.isEmpty(this.zza) || this.zzb == -1) {
            return;
        }
        try {
            JSONObject jSONObjectX = hs0.x(jSONObject, "pii");
            jSONObjectX.put("pvid", this.zza);
            jSONObjectX.put("pvid_s", this.zzb);
        } catch (JSONException unused) {
            k92.b();
        }
    }
}
