package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzfhc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        String strK = null;
        int iB = 0;
        int iB2 = 0;
        int iB3 = 0;
        int iB4 = 0;
        int iB5 = 0;
        int iB6 = 0;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iB = wd.B(i, parcel);
                    break;
                case 2:
                    iB2 = wd.B(i, parcel);
                    break;
                case 3:
                    iB3 = wd.B(i, parcel);
                    break;
                case 4:
                    iB4 = wd.B(i, parcel);
                    break;
                case 5:
                    strK = wd.k(i, parcel);
                    break;
                case 6:
                    iB5 = wd.B(i, parcel);
                    break;
                case 7:
                    iB6 = wd.B(i, parcel);
                    break;
                default:
                    wd.H(i, parcel);
                    break;
            }
        }
        wd.r(iK, parcel);
        return new zzfhb(iB, iB2, iB3, iB4, strK, iB5, iB6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfhb[i];
    }
}
