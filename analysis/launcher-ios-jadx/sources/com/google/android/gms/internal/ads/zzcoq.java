package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcoq implements zzhfc {
    private final zzhfu zza;

    public zzcoq(zzhfu zzhfuVar) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcsl) this.zza).zza().zzz);
        } catch (JSONException unused) {
            return null;
        }
    }
}
