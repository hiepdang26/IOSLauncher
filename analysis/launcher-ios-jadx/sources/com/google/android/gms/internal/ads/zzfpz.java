package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpz implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        String strK = null;
        String strK2 = null;
        int iB = 0;
        int iB2 = 0;
        int iB3 = 0;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iB = wd.B(i, parcel);
            } else if (c == 2) {
                iB2 = wd.B(i, parcel);
            } else if (c == 3) {
                strK = wd.k(i, parcel);
            } else if (c == 4) {
                strK2 = wd.k(i, parcel);
            } else if (c != 5) {
                wd.H(i, parcel);
            } else {
                iB3 = wd.B(i, parcel);
            }
        }
        wd.r(iK, parcel);
        return new zzfpy(iB, iB2, iB3, strK, strK2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfpy[i];
    }
}
