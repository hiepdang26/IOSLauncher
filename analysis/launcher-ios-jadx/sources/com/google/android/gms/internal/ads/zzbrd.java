package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import defpackage.hd2;
import defpackage.m21;

/* JADX INFO: loaded from: classes.dex */
final class zzbrd implements Runnable {
    final /* synthetic */ AdOverlayInfoParcel zza;
    final /* synthetic */ zzbre zzb;

    public zzbrd(zzbre zzbreVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        this.zzb = zzbreVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m21 m21Var = hd2.B.b;
        m21.f(this.zzb.zza, this.zza, true);
    }
}
