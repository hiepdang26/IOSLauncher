package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.x52;

/* JADX INFO: loaded from: classes.dex */
final class zzbil implements zzgcf {
    final /* synthetic */ zzcej zza;

    public zzbil(zzcej zzcejVar) {
        this.zza = zzcejVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        hd2.B.g.zzw(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcej zzcejVar = this.zza;
        new x52(zzcejVar.getContext(), zzcejVar.zzn().g, (String) obj).zzb();
    }
}
