package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import defpackage.o42;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbuq extends zzaxn implements zzbur {
    public zzbuq() {
        super("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzaxo.zza(parcel, ParcelFileDescriptor.CREATOR);
            zzaxo.zzc(parcel);
            zzf(parcelFileDescriptor);
        } else {
            if (i != 2) {
                return false;
            }
            o42 o42Var = (o42) zzaxo.zza(parcel, o42.CREATOR);
            zzaxo.zzc(parcel);
            zze(o42Var);
        }
        parcel2.writeNoException();
        return true;
    }
}
