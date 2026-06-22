package com.google.android.gms.internal.ads;

import defpackage.gc1;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwz extends zzbwm {
    private final gc1 zza;
    private final zzbxa zzb;

    public zzbwz(gc1 gc1Var, zzbxa zzbxaVar) {
        this.zza = gc1Var;
        this.zzb = zzbxaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zze(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzf(j92 j92Var) {
        gc1 gc1Var = this.zza;
        if (gc1Var != null) {
            gc1Var.onAdFailedToLoad(j92Var.b());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzg() {
        zzbxa zzbxaVar;
        gc1 gc1Var = this.zza;
        if (gc1Var == null || (zzbxaVar = this.zzb) == null) {
            return;
        }
        gc1Var.onAdLoaded(zzbxaVar);
    }
}
