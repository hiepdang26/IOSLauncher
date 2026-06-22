package com.google.android.gms.internal.ads;

import defpackage.pv0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbsc extends zzbgq {
    private final pv0 zza;

    public zzbsc(pv0 pv0Var) {
        this.zza = pv0Var;
    }

    @Override // com.google.android.gms.internal.ads.zzbgr
    public final void zze(zzbha zzbhaVar) {
        this.zza.onNativeAdLoaded(new zzbrv(zzbhaVar));
    }
}
