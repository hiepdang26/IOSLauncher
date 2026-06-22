package com.google.android.gms.internal.ads;

import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
final class zzbms implements zzbzx {
    final /* synthetic */ zzbmu zza;

    public zzbms(zzbmu zzbmuVar) {
        this.zza = zzbmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        k92.a("Releasing engine reference.");
        this.zza.zzb.zzd();
    }
}
