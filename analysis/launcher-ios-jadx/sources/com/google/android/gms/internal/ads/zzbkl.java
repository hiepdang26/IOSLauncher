package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbkl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        long jC = 0;
        String strK = null;
        byte[] bArrH = null;
        String[] strArrM = null;
        String[] strArrM2 = null;
        boolean z = false;
        int iB = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    z = wd.z(i, parcel);
                    break;
                case 2:
                    strK = wd.k(i, parcel);
                    break;
                case 3:
                    iB = wd.B(i, parcel);
                    break;
                case 4:
                    bArrH = wd.h(i, parcel);
                    break;
                case 5:
                    strArrM = wd.m(i, parcel);
                    break;
                case 6:
                    strArrM2 = wd.m(i, parcel);
                    break;
                case 7:
                    z2 = wd.z(i, parcel);
                    break;
                case '\b':
                    jC = wd.C(i, parcel);
                    break;
                default:
                    wd.H(i, parcel);
                    break;
            }
        }
        wd.r(iK, parcel);
        return new zzbkk(z, strK, iB, bArrH, strArrM, strArrM2, z2, jC);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbkk[i];
    }
}
