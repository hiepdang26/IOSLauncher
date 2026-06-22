package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.ta2;
import defpackage.wd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbet implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        ta2 ta2Var = null;
        int iB = 0;
        boolean z = false;
        int iB2 = 0;
        boolean z2 = false;
        int iB3 = 0;
        boolean z3 = false;
        int iB4 = 0;
        int iB5 = 0;
        boolean z4 = false;
        int iB6 = 0;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iB = wd.B(i, parcel);
                    break;
                case 2:
                    z = wd.z(i, parcel);
                    break;
                case 3:
                    iB2 = wd.B(i, parcel);
                    break;
                case 4:
                    z2 = wd.z(i, parcel);
                    break;
                case 5:
                    iB3 = wd.B(i, parcel);
                    break;
                case 6:
                    ta2Var = (ta2) wd.i(parcel, i, ta2.CREATOR);
                    break;
                case 7:
                    z3 = wd.z(i, parcel);
                    break;
                case '\b':
                    iB4 = wd.B(i, parcel);
                    break;
                case '\t':
                    iB5 = wd.B(i, parcel);
                    break;
                case '\n':
                    z4 = wd.z(i, parcel);
                    break;
                case 11:
                    iB6 = wd.B(i, parcel);
                    break;
                default:
                    wd.H(i, parcel);
                    break;
            }
        }
        wd.r(iK, parcel);
        return new zzbes(iB, z, iB2, z2, iB3, ta2Var, z3, iB4, iB5, z4, iB6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbes[i];
    }
}
