package com.google.android.gms.internal.ads;

import defpackage.cd2;
import defpackage.hd2;
import defpackage.or1;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdih implements zzhfc {
    private final zzhfu zza;

    public zzdih(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        or1 or1VarZza = ((zzchc) this.zza).zza();
        cd2 cd2Var = hd2.B.c;
        return new zzaxs(UUID.randomUUID().toString(), or1VarZza, "native", new JSONObject(), false, true);
    }
}
