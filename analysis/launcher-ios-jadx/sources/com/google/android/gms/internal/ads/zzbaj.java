package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbaj extends zzaxm implements IInterface {
    public zzbaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbah zzbahVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbahVar);
        Parcel parcelZzdb = zzdb(3, parcelZza);
        long j = parcelZzdb.readLong();
        parcelZzdb.recycle();
        return j;
    }

    public final zzbae zzf(zzbah zzbahVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbahVar);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        zzbae zzbaeVar = (zzbae) zzaxo.zza(parcelZzdb, zzbae.CREATOR);
        parcelZzdb.recycle();
        return zzbaeVar;
    }

    public final zzbae zzg(zzbah zzbahVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbahVar);
        Parcel parcelZzdb = zzdb(2, parcelZza);
        zzbae zzbaeVar = (zzbae) zzaxo.zza(parcelZzdb, zzbae.CREATOR);
        parcelZzdb.recycle();
        return zzbaeVar;
    }
}
