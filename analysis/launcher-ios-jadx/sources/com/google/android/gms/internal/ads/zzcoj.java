package com.google.android.gms.internal.ads;

import defpackage.cd2;
import defpackage.hd2;
import defpackage.or1;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcoj implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzcoj(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
        this.zzc = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        or1 or1VarZza = ((zzchc) this.zza).zza();
        JSONObject jSONObject = (JSONObject) this.zzb.zzb();
        String str = (String) this.zzc.zzb();
        boolean zEquals = "native".equals(str);
        cd2 cd2Var = hd2.B.c;
        return new zzaxs(UUID.randomUUID().toString(), or1VarZza, str, jSONObject, false, zEquals);
    }
}
