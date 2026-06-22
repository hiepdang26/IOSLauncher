package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbuh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        String strK = null;
        Bundle bundleG = null;
        byte[] bArrH = null;
        String strK2 = null;
        String strK3 = null;
        int iB = 0;
        boolean z = false;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    strK = wd.k(i, parcel);
                    break;
                case 2:
                    iB = wd.B(i, parcel);
                    break;
                case 3:
                    bundleG = wd.g(i, parcel);
                    break;
                case 4:
                    bArrH = wd.h(i, parcel);
                    break;
                case 5:
                    z = wd.z(i, parcel);
                    break;
                case 6:
                    strK2 = wd.k(i, parcel);
                    break;
                case 7:
                    strK3 = wd.k(i, parcel);
                    break;
                default:
                    wd.H(i, parcel);
                    break;
            }
        }
        wd.r(iK, parcel);
        return new zzbug(strK, iB, bundleG, bArrH, z, strK2, strK3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbug[i];
    }
}
