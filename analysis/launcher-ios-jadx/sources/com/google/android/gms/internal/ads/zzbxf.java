package com.google.android.gms.internal.ads;

import defpackage.do0;

/* JADX INFO: loaded from: classes.dex */
final class zzbxf implements zzgcf {
    final /* synthetic */ do0 zza;

    public zzbxf(zzbxg zzbxgVar, do0 do0Var) {
        this.zza = do0Var;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        zzbxg.zzc.remove(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbxg.zzc.remove(this.zza);
    }
}
