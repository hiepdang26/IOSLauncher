package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpq implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        String strK = null;
        String strK2 = null;
        int iB = 0;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iB = wd.B(i, parcel);
            } else if (c == 2) {
                strK = wd.k(i, parcel);
            } else if (c != 3) {
                wd.H(i, parcel);
            } else {
                strK2 = wd.k(i, parcel);
            }
        }
        wd.r(iK, parcel);
        return new zzfpp(iB, strK, strK2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfpp[i];
    }
}
