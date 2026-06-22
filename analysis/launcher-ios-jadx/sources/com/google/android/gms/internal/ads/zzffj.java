package com.google.android.gms.internal.ads;

import defpackage.n42;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzffj {
    private final JSONObject zza;

    public zzffj(JSONObject jSONObject) {
        this.zza = jSONObject;
    }

    public final String zza() {
        if (zzc() - 1 != 1) {
            return "javascript";
        }
        return null;
    }

    public final boolean zzb() {
        return this.zza.optBoolean((String) n42.d.c.zza(zzbbw.zzeD), true);
    }

    public final int zzc() {
        int iOptInt = this.zza.optInt("media_type", -1);
        if (iOptInt != 0) {
            return iOptInt != 1 ? 3 : 1;
        }
        return 2;
    }
}
