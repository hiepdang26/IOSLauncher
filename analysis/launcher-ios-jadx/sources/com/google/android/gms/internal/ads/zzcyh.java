package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcyh implements zzhfc {
    private final zzhfu zza;

    public zzcyh(zzhfu zzhfuVar) {
        this.zza = zzhfuVar;
    }

    public static zzcyg zzc(Set set) {
        return new zzcyg(set);
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcyg zzb() {
        return new zzcyg(((zzhfq) this.zza).zzb());
    }
}
