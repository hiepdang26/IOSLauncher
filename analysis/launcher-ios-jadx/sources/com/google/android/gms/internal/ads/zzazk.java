package com.google.android.gms.internal.ads;

import defpackage.b7;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzazk extends zzazr {
    private final b7 zza;
    private final String zzb;

    public zzazk(b7 b7Var, String str) {
        this.zza = b7Var;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzb(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzc(j92 j92Var) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(j92Var.b());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzd(zzazp zzazpVar) {
        if (this.zza != null) {
            this.zza.onAdLoaded(new zzazl(zzazpVar, this.zzb));
        }
    }
}
