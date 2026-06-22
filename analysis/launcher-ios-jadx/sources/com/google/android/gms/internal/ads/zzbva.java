package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbva implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            if (((char) i) != 2) {
                wd.H(i, parcel);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) wd.i(parcel, i, ParcelFileDescriptor.CREATOR);
            }
        }
        wd.r(iK, parcel);
        return new zzbuz(parcelFileDescriptor);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbuz[i];
    }
}
