package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.tb2;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvv implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        tb2 tb2Var = null;
        String strK = null;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                tb2Var = (tb2) wd.i(parcel, i, tb2.CREATOR);
            } else if (c != 3) {
                wd.H(i, parcel);
            } else {
                strK = wd.k(i, parcel);
            }
        }
        wd.r(iK, parcel);
        return new zzbvu(tb2Var, strK);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbvu[i];
    }
}
