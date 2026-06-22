package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwc implements zzhfc {
    private final zzcwa zza;
    private final zzhfu zzb;

    public zzcwc(zzcwa zzcwaVar, zzhfu zzhfuVar) {
        this.zza = zzcwaVar;
        this.zzb = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = this.zza.zza(((zzcgp) this.zzb).zza());
        zzhfk.zzb(contextZza);
        return contextZza;
    }
}
