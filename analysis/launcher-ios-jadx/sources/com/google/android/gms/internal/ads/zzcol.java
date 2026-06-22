package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcol implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzcol(zzhfu zzhfuVar, zzhfu zzhfuVar2, zzhfu zzhfuVar3) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcof zzcofVar = (zzcof) this.zza.zzb();
        zzgcu zzgcuVar = zzbzo.zza;
        zzhfk.zzb(zzgcuVar);
        Set setSingleton = ((JSONObject) this.zzb.zzb()) == null ? Collections.EMPTY_SET : Collections.singleton(new zzdei(zzcofVar, zzgcuVar));
        zzhfk.zzb(setSingleton);
        return setSingleton;
    }
}
