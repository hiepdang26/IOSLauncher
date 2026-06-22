package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.b92;
import defpackage.or1;
import defpackage.rc2;
import defpackage.tb2;
import defpackage.wd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzbua implements Parcelable.Creator {
    public static final zzbtz zza(Parcel parcel) {
        int iK = wd.K(parcel);
        long jC = 0;
        long jC2 = 0;
        int iB = 0;
        Bundle bundleG = null;
        tb2 tb2Var = null;
        rc2 rc2Var = null;
        String strK = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String strK2 = null;
        String strK3 = null;
        String strK4 = null;
        or1 or1Var = null;
        Bundle bundleG2 = null;
        int iB2 = 0;
        ArrayList arrayListN = null;
        Bundle bundleG3 = null;
        boolean z = false;
        int iB3 = 0;
        int iB4 = 0;
        float f = 0.0f;
        String strK5 = null;
        String strK6 = null;
        ArrayList arrayListN2 = null;
        String strK7 = null;
        zzbes zzbesVar = null;
        ArrayList arrayListN3 = null;
        String strK8 = null;
        float f2 = 0.0f;
        boolean z2 = false;
        int iB5 = 0;
        int iB6 = 0;
        boolean z3 = false;
        String strK9 = null;
        String strK10 = null;
        boolean z4 = false;
        int iB7 = 0;
        Bundle bundleG4 = null;
        String strK11 = null;
        b92 b92Var = null;
        boolean z5 = false;
        Bundle bundleG5 = null;
        String strK12 = null;
        String strK13 = null;
        String strK14 = null;
        boolean z6 = false;
        ArrayList arrayList = null;
        String strK15 = null;
        ArrayList arrayListN4 = null;
        int iB8 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        ArrayList arrayListN5 = null;
        String strK16 = null;
        zzblh zzblhVar = null;
        String strK17 = null;
        Bundle bundleG6 = null;
        while (parcel.dataPosition() < iK) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iB = wd.B(i, parcel);
                    break;
                case 2:
                    bundleG = wd.g(i, parcel);
                    break;
                case 3:
                    tb2Var = (tb2) wd.i(parcel, i, tb2.CREATOR);
                    break;
                case 4:
                    rc2Var = (rc2) wd.i(parcel, i, rc2.CREATOR);
                    break;
                case 5:
                    strK = wd.k(i, parcel);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) wd.i(parcel, i, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) wd.i(parcel, i, PackageInfo.CREATOR);
                    break;
                case '\b':
                    strK2 = wd.k(i, parcel);
                    break;
                case '\t':
                    strK3 = wd.k(i, parcel);
                    break;
                case '\n':
                    strK4 = wd.k(i, parcel);
                    break;
                case 11:
                    or1Var = (or1) wd.i(parcel, i, or1.CREATOR);
                    break;
                case '\f':
                    bundleG2 = wd.g(i, parcel);
                    break;
                case '\r':
                    iB2 = wd.B(i, parcel);
                    break;
                case 14:
                    arrayListN = wd.n(i, parcel);
                    break;
                case 15:
                    bundleG3 = wd.g(i, parcel);
                    break;
                case 16:
                    z = wd.z(i, parcel);
                    break;
                case 17:
                case 22:
                case 23:
                case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                case ' ':
                case '&':
                case '>':
                default:
                    wd.H(i, parcel);
                    break;
                case 18:
                    iB3 = wd.B(i, parcel);
                    break;
                case 19:
                    iB4 = wd.B(i, parcel);
                    break;
                case 20:
                    wd.N(parcel, i, 4);
                    f = parcel.readFloat();
                    break;
                case zzbbc.zzt.zzm /* 21 */:
                    strK5 = wd.k(i, parcel);
                    break;
                case 25:
                    jC = wd.C(i, parcel);
                    break;
                case 26:
                    strK6 = wd.k(i, parcel);
                    break;
                case 27:
                    arrayListN2 = wd.n(i, parcel);
                    break;
                case 28:
                    strK7 = wd.k(i, parcel);
                    break;
                case 29:
                    zzbesVar = (zzbes) wd.i(parcel, i, zzbes.CREATOR);
                    break;
                case 30:
                    arrayListN3 = wd.n(i, parcel);
                    break;
                case 31:
                    jC2 = wd.C(i, parcel);
                    break;
                case '!':
                    strK8 = wd.k(i, parcel);
                    break;
                case '\"':
                    wd.N(parcel, i, 4);
                    f2 = parcel.readFloat();
                    break;
                case '#':
                    iB5 = wd.B(i, parcel);
                    break;
                case '$':
                    iB6 = wd.B(i, parcel);
                    break;
                case '%':
                    z3 = wd.z(i, parcel);
                    break;
                case '\'':
                    strK9 = wd.k(i, parcel);
                    break;
                case '(':
                    z2 = wd.z(i, parcel);
                    break;
                case ')':
                    strK10 = wd.k(i, parcel);
                    break;
                case '*':
                    z4 = wd.z(i, parcel);
                    break;
                case '+':
                    iB7 = wd.B(i, parcel);
                    break;
                case ',':
                    bundleG4 = wd.g(i, parcel);
                    break;
                case '-':
                    strK11 = wd.k(i, parcel);
                    break;
                case '.':
                    b92Var = (b92) wd.i(parcel, i, b92.CREATOR);
                    break;
                case '/':
                    z5 = wd.z(i, parcel);
                    break;
                case '0':
                    bundleG5 = wd.g(i, parcel);
                    break;
                case '1':
                    strK12 = wd.k(i, parcel);
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH /* 50 */:
                    strK13 = wd.k(i, parcel);
                    break;
                case '3':
                    strK14 = wd.k(i, parcel);
                    break;
                case '4':
                    z6 = wd.z(i, parcel);
                    break;
                case '5':
                    int iD = wd.D(i, parcel);
                    int iDataPosition = parcel.dataPosition();
                    if (iD == 0) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        int i2 = parcel.readInt();
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList2.add(Integer.valueOf(parcel.readInt()));
                        }
                        parcel.setDataPosition(iDataPosition + iD);
                        arrayList = arrayList2;
                    }
                    break;
                case '6':
                    strK15 = wd.k(i, parcel);
                    break;
                case '7':
                    arrayListN4 = wd.n(i, parcel);
                    break;
                case '8':
                    iB8 = wd.B(i, parcel);
                    break;
                case '9':
                    z7 = wd.z(i, parcel);
                    break;
                case ':':
                    z8 = wd.z(i, parcel);
                    break;
                case ';':
                    z9 = wd.z(i, parcel);
                    break;
                case '<':
                    arrayListN5 = wd.n(i, parcel);
                    break;
                case '=':
                    strK16 = wd.k(i, parcel);
                    break;
                case '?':
                    zzblhVar = (zzblh) wd.i(parcel, i, zzblh.CREATOR);
                    break;
                case '@':
                    strK17 = wd.k(i, parcel);
                    break;
                case 'A':
                    bundleG6 = wd.g(i, parcel);
                    break;
            }
        }
        wd.r(iK, parcel);
        return new zzbtz(iB, bundleG, tb2Var, rc2Var, strK, applicationInfo, packageInfo, strK2, strK3, strK4, or1Var, bundleG2, iB2, arrayListN, bundleG3, z, iB3, iB4, f, strK5, jC, strK6, arrayListN2, strK7, zzbesVar, arrayListN3, jC2, strK8, f2, z2, iB5, iB6, z3, strK9, strK10, z4, iB7, bundleG4, strK11, b92Var, z5, bundleG5, strK12, strK13, strK14, z6, arrayList, strK15, arrayListN4, iB8, z7, z8, z9, arrayListN5, strK16, zzblhVar, strK17, bundleG6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zza(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbtz[i];
    }
}
