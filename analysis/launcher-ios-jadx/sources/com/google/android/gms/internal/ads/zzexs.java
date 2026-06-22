package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.hs0;
import defpackage.k92;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzexs implements zzevn {
    private final String zza;

    public zzexs(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        try {
            JSONObject jSONObjectX = hs0.x((JSONObject) obj, "pii");
            if (TextUtils.isEmpty(this.zza)) {
                return;
            }
            jSONObjectX.put("attok", this.zza);
        } catch (JSONException unused) {
            k92.b();
        }
    }
}
