package com.google.android.gms.internal.ads;

import android.view.View;
import defpackage.hd2;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzdiv implements zzgcf {
    final /* synthetic */ View zza;
    final /* synthetic */ zzdiw zzb;

    public zzdiv(zzdiw zzdiwVar, View view) {
        this.zza = view;
        this.zzb = zzdiwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzeI)).booleanValue()) {
            hd2.B.g.zzv(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzac(this.zza, (zzeeo) obj);
    }
}
