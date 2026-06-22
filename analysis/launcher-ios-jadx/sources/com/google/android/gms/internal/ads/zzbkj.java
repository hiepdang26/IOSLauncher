package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbkj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        String strK = null;
        String[] strArrM = null;
        String[] strArrM2 = null;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strK = wd.k(i, parcel);
            } else if (c == 2) {
                strArrM = wd.m(i, parcel);
            } else if (c != 3) {
                wd.H(i, parcel);
            } else {
                strArrM2 = wd.m(i, parcel);
            }
        }
        wd.r(iK, parcel);
        return new zzbki(strK, strArrM, strArrM2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbki[i];
    }
}
