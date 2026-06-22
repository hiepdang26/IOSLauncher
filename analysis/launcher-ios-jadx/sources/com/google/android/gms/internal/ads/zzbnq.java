package com.google.android.gms.internal.ads;

import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
final class zzbnq implements zzbzv {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzbmu zzb;

    public zzbnq(zzbns zzbnsVar, zzbzt zzbztVar, zzbmu zzbmuVar) {
        this.zza = zzbztVar;
        this.zzb = zzbmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzv
    public final void zza() {
        k92.a("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbnd("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
