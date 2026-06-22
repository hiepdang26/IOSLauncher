package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwa implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        int iB = 0;
        String strK = null;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strK = wd.k(i, parcel);
            } else if (c != 3) {
                wd.H(i, parcel);
            } else {
                iB = wd.B(i, parcel);
            }
        }
        wd.r(iK, parcel);
        return new zzbvz(strK, iB);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbvz[i];
    }
}
