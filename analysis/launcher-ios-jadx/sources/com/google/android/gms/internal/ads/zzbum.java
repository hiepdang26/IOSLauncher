package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbum extends zzaxm implements zzbuo {
    public zzbum(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsService");
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zze(zzbug zzbugVar, zzbur zzburVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbugVar);
        zzaxo.zzf(parcelZza, zzburVar);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zzf(zzbuc zzbucVar, zzbur zzburVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbucVar);
        zzaxo.zzf(parcelZza, zzburVar);
        zzdc(1, parcelZza);
    }
}
