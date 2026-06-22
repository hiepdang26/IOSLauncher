package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdic implements zzhfc {
    private final zzdia zza;

    public zzdic(zzdia zzdiaVar) {
        this.zza = zzdiaVar;
    }

    public final JSONObject zza() {
        JSONObject jSONObjectZzb = this.zza.zzb();
        zzhfk.zzb(jSONObjectZzb);
        return jSONObjectZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* synthetic */ Object zzb() {
        JSONObject jSONObjectZzb = this.zza.zzb();
        zzhfk.zzb(jSONObjectZzb);
        return jSONObjectZzb;
    }
}
