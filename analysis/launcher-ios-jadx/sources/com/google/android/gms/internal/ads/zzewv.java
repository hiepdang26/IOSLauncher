package com.google.android.gms.internal.ads;

import defpackage.k92;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzewv implements zzevn {
    private final String zza;

    public zzewv(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        try {
            ((JSONObject) obj).put("ms", this.zza);
        } catch (JSONException unused) {
            k92.b();
        }
    }
}
