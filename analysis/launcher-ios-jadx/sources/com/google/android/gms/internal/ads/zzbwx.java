package com.google.android.gms.internal.ads;

import defpackage.cc1;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwx extends zzbwc {
    private final String zza;
    private final int zzb;

    public zzbwx(cc1 cc1Var) {
        this(cc1Var != null ? cc1Var.getType() : "", cc1Var != null ? cc1Var.getAmount() : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final int zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final String zzf() {
        return this.zza;
    }

    public zzbwx(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }
}
