package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbui extends zzaxm implements zzbuk {
    public zzbui(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zze(zzbvb zzbvbVar, zzbuu zzbuuVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbvbVar);
        zzaxo.zzf(parcelZza, zzbuuVar);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzf(zzbvb zzbvbVar, zzbuu zzbuuVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbvbVar);
        zzaxo.zzf(parcelZza, zzbuuVar);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzg(zzbvb zzbvbVar, zzbuu zzbuuVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbvbVar);
        zzaxo.zzf(parcelZza, zzbuuVar);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzh(String str, zzbuu zzbuuVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbuuVar);
        zzdc(7, parcelZza);
    }
}
