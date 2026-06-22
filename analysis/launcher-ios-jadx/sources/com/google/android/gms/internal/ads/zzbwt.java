package com.google.android.gms.internal.ads;

import defpackage.dc1;
import defpackage.ec1;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwt extends zzbwm {
    private final ec1 zza;
    private final dc1 zzb;

    public zzbwt(ec1 ec1Var, dc1 dc1Var) {
        this.zza = ec1Var;
        this.zzb = dc1Var;
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zze(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzf(j92 j92Var) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(j92Var.b());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzg() {
        ec1 ec1Var = this.zza;
        if (ec1Var != null) {
            ec1Var.onAdLoaded(this.zzb);
        }
    }
}
