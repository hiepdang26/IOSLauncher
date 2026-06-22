package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzfps implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        byte[] bArrH = null;
        int iB = 0;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iB = wd.B(i, parcel);
            } else if (c != 2) {
                wd.H(i, parcel);
            } else {
                bArrH = wd.h(i, parcel);
            }
        }
        wd.r(iK, parcel);
        return new zzfpr(iB, bArrH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfpr[i];
    }
}
