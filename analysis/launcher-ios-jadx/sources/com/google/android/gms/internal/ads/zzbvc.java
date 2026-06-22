package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.or1;
import defpackage.wd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iK = wd.K(parcel);
        Bundle bundleG = null;
        or1 or1Var = null;
        ApplicationInfo applicationInfo = null;
        String strK = null;
        ArrayList arrayListN = null;
        PackageInfo packageInfo = null;
        String strK2 = null;
        String strK3 = null;
        zzfhb zzfhbVar = null;
        String strK4 = null;
        Bundle bundleG2 = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    bundleG = wd.g(i, parcel);
                    break;
                case 2:
                    or1Var = (or1) wd.i(parcel, i, or1.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) wd.i(parcel, i, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    strK = wd.k(i, parcel);
                    break;
                case 5:
                    arrayListN = wd.n(i, parcel);
                    break;
                case 6:
                    packageInfo = (PackageInfo) wd.i(parcel, i, PackageInfo.CREATOR);
                    break;
                case 7:
                    strK2 = wd.k(i, parcel);
                    break;
                case '\b':
                default:
                    wd.H(i, parcel);
                    break;
                case '\t':
                    strK3 = wd.k(i, parcel);
                    break;
                case '\n':
                    zzfhbVar = (zzfhb) wd.i(parcel, i, zzfhb.CREATOR);
                    break;
                case 11:
                    strK4 = wd.k(i, parcel);
                    break;
                case '\f':
                    z = wd.z(i, parcel);
                    break;
                case '\r':
                    z2 = wd.z(i, parcel);
                    break;
                case 14:
                    bundleG2 = wd.g(i, parcel);
                    break;
            }
        }
        wd.r(iK, parcel);
        return new zzbvb(bundleG, or1Var, applicationInfo, strK, arrayListN, packageInfo, strK2, strK3, zzfhbVar, strK4, z, z2, bundleG2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbvb[i];
    }
}
