package com.google.android.gms.internal.ads;

import defpackage.n42;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmj implements zzclz {
    private final zzdvi zza;

    public zzcmj(zzdvi zzdviVar) {
        this.zza = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzclz
    public final void zza(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (((Boolean) n42.d.c.zza(zzbbw.zziq)).booleanValue()) {
                this.zza.zzn(jSONObject);
            }
        }
    }
}
