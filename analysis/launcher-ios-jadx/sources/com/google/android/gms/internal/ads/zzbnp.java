package com.google.android.gms.internal.ads;

import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
final class zzbnp implements zzbzx {
    final /* synthetic */ zzbmu zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzbzt zzc;
    final /* synthetic */ zzbns zzd;

    public zzbnp(zzbns zzbnsVar, zzbmu zzbmuVar, Object obj, zzbzt zzbztVar) {
        this.zza = zzbmuVar;
        this.zzb = obj;
        this.zzc = zzbztVar;
        this.zzd = zzbnsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        k92.a("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzbzt zzbztVar = this.zzc;
        zzbns.zzd(this.zzd, this.zza, (zzbnb) obj, obj2, zzbztVar);
    }
}
