package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbtm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        IBinder iBinderA = null;
        IBinder iBinderA2 = null;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iBinderA = wd.A(i, parcel);
            } else if (c != 2) {
                wd.H(i, parcel);
            } else {
                iBinderA2 = wd.A(i, parcel);
            }
        }
        wd.r(iK, parcel);
        return new zzbtl(iBinderA, iBinderA2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbtl[i];
    }
}
