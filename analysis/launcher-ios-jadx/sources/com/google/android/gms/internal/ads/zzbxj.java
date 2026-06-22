package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        String strK = null;
        String strK2 = null;
        ArrayList arrayListN = null;
        ArrayList arrayListN2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 2:
                    strK = wd.k(i, parcel);
                    break;
                case 3:
                    strK2 = wd.k(i, parcel);
                    break;
                case 4:
                    z = wd.z(i, parcel);
                    break;
                case 5:
                    z2 = wd.z(i, parcel);
                    break;
                case 6:
                    arrayListN = wd.n(i, parcel);
                    break;
                case 7:
                    z3 = wd.z(i, parcel);
                    break;
                case '\b':
                    z4 = wd.z(i, parcel);
                    break;
                case '\t':
                    arrayListN2 = wd.n(i, parcel);
                    break;
                default:
                    wd.H(i, parcel);
                    break;
            }
        }
        wd.r(iK, parcel);
        return new zzbxi(strK, strK2, z, z2, arrayListN, z3, z4, arrayListN2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbxi[i];
    }
}
