package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.m42;

/* JADX INFO: loaded from: classes.dex */
final class zzdxy implements zzgcf {
    final /* synthetic */ Context zza;

    public zzdxy(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        if (((Boolean) zzbdk.zzh.zze()).booleanValue() && (th instanceof m42)) {
            zzbbg.zze(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        if (((Boolean) zzbdk.zzj.zze()).booleanValue()) {
            zzbbg.zze(this.zza);
        }
    }
}
