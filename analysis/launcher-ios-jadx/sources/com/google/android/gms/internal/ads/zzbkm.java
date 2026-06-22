package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbkm extends zzaxn implements zzbkn {
    public zzbkm() {
        super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzaxo.zza(parcel, ParcelFileDescriptor.CREATOR);
        zzaxo.zzc(parcel);
        zzb(parcelFileDescriptor);
        return true;
    }
}
