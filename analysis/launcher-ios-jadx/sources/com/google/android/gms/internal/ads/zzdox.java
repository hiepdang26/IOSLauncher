package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: loaded from: classes.dex */
public final class zzdox implements zzhfc {
    private final zzhfu zza;

    public zzdox(zzhfu zzhfuVar) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbbc.zza.EnumC0000zza enumC0000zza = ((zzcwh) this.zza).zza().zzo.zza == 3 ? zzbbc.zza.EnumC0000zza.REWARDED_INTERSTITIAL : zzbbc.zza.EnumC0000zza.REWARD_BASED_VIDEO_AD;
        zzhfk.zzb(enumC0000zza);
        return enumC0000zza;
    }
}
