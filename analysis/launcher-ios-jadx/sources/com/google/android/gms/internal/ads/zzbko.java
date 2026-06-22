package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbko extends zzaxm implements IInterface {
    public zzbko(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzbki zzbkiVar, zzbkn zzbknVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbkiVar);
        zzaxo.zzf(parcelZza, zzbknVar);
        zzdd(2, parcelZza);
    }
}
