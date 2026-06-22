package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.hs0;
import defpackage.k92;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzezf implements zzevn {
    private final String zza;

    public zzezf(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (TextUtils.isEmpty(this.zza)) {
                return;
            }
            hs0.x(jSONObject, "pii").put("adsid", this.zza);
        } catch (JSONException unused) {
            k92.j(5);
        }
    }
}
