package com.google.android.gms.internal.ads;

import defpackage.b22;

/* JADX INFO: loaded from: classes.dex */
public final class zzctx implements b22 {
    private final zzcub zza;
    private final zzffg zzb;

    public zzctx(zzcub zzcubVar, zzffg zzffgVar) {
        this.zza = zzcubVar;
        this.zzb = zzffgVar;
    }

    @Override // defpackage.b22
    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
