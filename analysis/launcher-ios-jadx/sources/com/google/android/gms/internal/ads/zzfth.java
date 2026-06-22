package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzfth extends zzfsk {
    final /* synthetic */ zzfti zza;
    private final zzftn zzb;

    public zzfth(zzfti zzftiVar, zzftn zzftnVar) {
        this.zza = zzftiVar;
        this.zzb = zzftnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsl
    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzftl zzftlVarZzc = zzftm.zzc();
        zzftlVarZzc.zzb(i);
        if (string != null) {
            zzftlVarZzc.zza(string);
        }
        this.zzb.zza(zzftlVarZzc.zzc());
        if (i == 8157) {
            this.zza.zza();
        }
    }
}
