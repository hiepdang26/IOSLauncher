package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.rc2;
import defpackage.tb2;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        String strK = null;
        String strK2 = null;
        rc2 rc2Var = null;
        tb2 tb2Var = null;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strK = wd.k(i, parcel);
            } else if (c == 2) {
                strK2 = wd.k(i, parcel);
            } else if (c == 3) {
                rc2Var = (rc2) wd.i(parcel, i, rc2.CREATOR);
            } else if (c != 4) {
                wd.H(i, parcel);
            } else {
                tb2Var = (tb2) wd.i(parcel, i, tb2.CREATOR);
            }
        }
        wd.r(iK, parcel);
        return new zzbyq(strK, strK2, rc2Var, tb2Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbyq[i];
    }
}
