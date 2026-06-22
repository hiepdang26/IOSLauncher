package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbaf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        long jC = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) wd.i(parcel, i, ParcelFileDescriptor.CREATOR);
            } else if (c == 3) {
                z = wd.z(i, parcel);
            } else if (c == 4) {
                z2 = wd.z(i, parcel);
            } else if (c == 5) {
                jC = wd.C(i, parcel);
            } else if (c != 6) {
                wd.H(i, parcel);
            } else {
                z3 = wd.z(i, parcel);
            }
        }
        wd.r(iK, parcel);
        return new zzbae(parcelFileDescriptor, z, z2, jC, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbae[i];
    }
}
