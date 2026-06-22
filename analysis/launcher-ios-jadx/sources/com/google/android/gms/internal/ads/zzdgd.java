package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdgd implements zzhfc {
    private final zzdfs zza;
    private final zzhfu zzb;

    public zzdgd(zzdfs zzdfsVar, zzhfu zzhfuVar) {
        this.zza = zzdfsVar;
        this.zzb = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzf = this.zza.zzf((zzcvn) this.zzb.zzb());
        zzhfk.zzb(setZzf);
        return setZzf;
    }
}
