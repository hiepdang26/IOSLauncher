package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import defpackage.o42;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbut extends zzaxn implements zzbuu {
    public zzbut() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzaxo.zza(parcel, ParcelFileDescriptor.CREATOR);
            zzaxo.zzc(parcel);
            zzf(parcelFileDescriptor);
        } else if (i == 2) {
            o42 o42Var = (o42) zzaxo.zza(parcel, o42.CREATOR);
            zzaxo.zzc(parcel);
            zze(o42Var);
        } else {
            if (i != 3) {
                return false;
            }
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) zzaxo.zza(parcel, ParcelFileDescriptor.CREATOR);
            zzbvb zzbvbVar = (zzbvb) zzaxo.zza(parcel, zzbvb.CREATOR);
            zzaxo.zzc(parcel);
            zzg(parcelFileDescriptor2, zzbvbVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
