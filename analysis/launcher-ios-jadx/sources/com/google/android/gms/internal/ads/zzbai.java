package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbai implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        String strK = null;
        String strK2 = null;
        String strK3 = null;
        String strK4 = null;
        Bundle bundleG = null;
        String strK5 = null;
        long jC = 0;
        long jC2 = 0;
        boolean z = false;
        int iB = 0;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 2:
                    strK = wd.k(i, parcel);
                    break;
                case 3:
                    jC = wd.C(i, parcel);
                    break;
                case 4:
                    strK2 = wd.k(i, parcel);
                    break;
                case 5:
                    strK3 = wd.k(i, parcel);
                    break;
                case 6:
                    strK4 = wd.k(i, parcel);
                    break;
                case 7:
                    bundleG = wd.g(i, parcel);
                    break;
                case '\b':
                    z = wd.z(i, parcel);
                    break;
                case '\t':
                    jC2 = wd.C(i, parcel);
                    break;
                case '\n':
                    strK5 = wd.k(i, parcel);
                    break;
                case 11:
                    iB = wd.B(i, parcel);
                    break;
                default:
                    wd.H(i, parcel);
                    break;
            }
        }
        wd.r(iK, parcel);
        return new zzbah(strK, jC, strK2, strK3, strK4, bundleG, z, jC2, strK5, iB);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbah[i];
    }
}
