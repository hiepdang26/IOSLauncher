package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public final class zzazu extends zzaxm implements zzazw {
    public zzazu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zzb() {
        zzdc(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zzc() {
        zzdc(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zzd(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zze() {
        zzdc(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zzf() {
        zzdc(1, zza());
    }
}
