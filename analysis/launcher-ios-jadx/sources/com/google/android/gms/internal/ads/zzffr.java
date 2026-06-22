package com.google.android.gms.internal.ads;

import defpackage.hd2;

/* JADX INFO: loaded from: classes.dex */
final class zzffr implements zzgcf {
    final /* synthetic */ zzffs zza;
    final /* synthetic */ int zzb;

    public zzffr(zzffs zzffsVar, int i) {
        this.zzb = i;
        this.zza = zzffsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        hd2.B.g.zzw(th, "BufferingUrlPinger.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i = this.zzb;
        this.zza.zzb((String) obj, i);
    }
}
