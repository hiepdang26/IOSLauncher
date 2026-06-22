package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.wd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbud implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        ApplicationInfo applicationInfo = null;
        String strK = null;
        PackageInfo packageInfo = null;
        String strK2 = null;
        String strK3 = null;
        ArrayList arrayListN = null;
        int iB = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    applicationInfo = (ApplicationInfo) wd.i(parcel, i, ApplicationInfo.CREATOR);
                    break;
                case 2:
                    strK = wd.k(i, parcel);
                    break;
                case 3:
                    packageInfo = (PackageInfo) wd.i(parcel, i, PackageInfo.CREATOR);
                    break;
                case 4:
                    strK2 = wd.k(i, parcel);
                    break;
                case 5:
                    iB = wd.B(i, parcel);
                    break;
                case 6:
                    strK3 = wd.k(i, parcel);
                    break;
                case 7:
                    arrayListN = wd.n(i, parcel);
                    break;
                case '\b':
                    z = wd.z(i, parcel);
                    break;
                case '\t':
                    z2 = wd.z(i, parcel);
                    break;
                default:
                    wd.H(i, parcel);
                    break;
            }
        }
        wd.r(iK, parcel);
        return new zzbuc(applicationInfo, strK, packageInfo, strK2, iB, strK3, arrayListN, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbuc[i];
    }
}
