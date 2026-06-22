package defpackage;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zb1 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ zb1(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        long jC = 0;
        je0 je0Var = null;
        String strK = null;
        IBinder iBinderA = null;
        String strK2 = null;
        Status status = null;
        ArrayList arrayListP = null;
        String strK3 = null;
        String strK4 = null;
        String strK5 = null;
        PendingIntent pendingIntent = null;
        String strK6 = null;
        Account account = null;
        vl vlVar = null;
        ArrayList arrayListN = null;
        Intent intent = null;
        ArrayList arrayListP2 = null;
        int iB = 0;
        boolean z = false;
        int iB2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int iB3 = 0;
        int iB4 = 0;
        int iB5 = 0;
        int iB6 = 0;
        int iB7 = 0;
        int iB8 = 0;
        int iB9 = 0;
        switch (this.a) {
            case 0:
                bc1 bc1Var = new bc1();
                IBinder strongBinder = parcel.readStrongBinder();
                int i = ac1.h;
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(je0.e);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof je0)) {
                        ie0 ie0Var = new ie0();
                        ie0Var.g = strongBinder;
                        je0Var = ie0Var;
                    } else {
                        je0Var = (je0) iInterfaceQueryLocalInterface;
                    }
                }
                bc1Var.g = je0Var;
                return bc1Var;
            case 1:
                return new ye1(parcel);
            case 2:
                si1 si1Var = new si1();
                si1Var.g = parcel.readInt();
                si1Var.h = parcel.readInt();
                si1Var.j = parcel.readInt() == 1;
                int i2 = parcel.readInt();
                if (i2 > 0) {
                    int[] iArr = new int[i2];
                    si1Var.i = iArr;
                    parcel.readIntArray(iArr);
                }
                return si1Var;
            case 3:
                ti1 ti1Var = new ti1();
                ti1Var.g = parcel.readInt();
                ti1Var.h = parcel.readInt();
                int i3 = parcel.readInt();
                ti1Var.i = i3;
                if (i3 > 0) {
                    int[] iArr2 = new int[i3];
                    ti1Var.j = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i4 = parcel.readInt();
                ti1Var.k = i4;
                if (i4 > 0) {
                    int[] iArr3 = new int[i4];
                    ti1Var.l = iArr3;
                    parcel.readIntArray(iArr3);
                }
                ti1Var.n = parcel.readInt() == 1;
                ti1Var.o = parcel.readInt() == 1;
                ti1Var.p = parcel.readInt() == 1;
                ti1Var.m = parcel.readArrayList(si1.class.getClassLoader());
                return ti1Var;
            case 4:
                el1 el1Var = new el1(parcel);
                el1Var.g = 1 == parcel.readInt();
                return el1Var;
            case 5:
                return new mp1(parcel);
            case 6:
                int iK = wd.K(parcel);
                while (parcel.dataPosition() < iK) {
                    int i5 = parcel.readInt();
                    char c = (char) i5;
                    if (c == 1) {
                        iB = wd.B(i5, parcel);
                    } else if (c != 2) {
                        wd.H(i5, parcel);
                    } else {
                        arrayListP2 = wd.p(parcel, i5, eu0.CREATOR);
                    }
                }
                wd.r(iK, parcel);
                return new vm1(iB, arrayListP2);
            case 7:
                int iK2 = wd.K(parcel);
                int iB10 = 0;
                while (parcel.dataPosition() < iK2) {
                    int i6 = parcel.readInt();
                    char c2 = (char) i6;
                    if (c2 == 1) {
                        iB9 = wd.B(i6, parcel);
                    } else if (c2 == 2) {
                        iB10 = wd.B(i6, parcel);
                    } else if (c2 != 3) {
                        wd.H(i6, parcel);
                    } else {
                        intent = (Intent) wd.i(parcel, i6, Intent.CREATOR);
                    }
                }
                wd.r(iK2, parcel);
                return new r02(iB9, iB10, intent);
            case 8:
                int iK3 = wd.K(parcel);
                long jC2 = 0;
                String strK7 = null;
                String strK8 = null;
                String strK9 = null;
                String strK10 = null;
                Uri uri = null;
                String strK11 = null;
                String strK12 = null;
                ArrayList arrayListP3 = null;
                String strK13 = null;
                String strK14 = null;
                int iB11 = 0;
                while (parcel.dataPosition() < iK3) {
                    int i7 = parcel.readInt();
                    switch ((char) i7) {
                        case 1:
                            iB11 = wd.B(i7, parcel);
                            break;
                        case 2:
                            strK7 = wd.k(i7, parcel);
                            break;
                        case 3:
                            strK8 = wd.k(i7, parcel);
                            break;
                        case 4:
                            strK9 = wd.k(i7, parcel);
                            break;
                        case 5:
                            strK10 = wd.k(i7, parcel);
                            break;
                        case 6:
                            uri = (Uri) wd.i(parcel, i7, Uri.CREATOR);
                            break;
                        case 7:
                            strK11 = wd.k(i7, parcel);
                            break;
                        case '\b':
                            jC2 = wd.C(i7, parcel);
                            break;
                        case '\t':
                            strK12 = wd.k(i7, parcel);
                            break;
                        case '\n':
                            arrayListP3 = wd.p(parcel, i7, Scope.CREATOR);
                            break;
                        case 11:
                            strK13 = wd.k(i7, parcel);
                            break;
                        case '\f':
                            strK14 = wd.k(i7, parcel);
                            break;
                        default:
                            wd.H(i7, parcel);
                            break;
                    }
                }
                wd.r(iK3, parcel);
                return new GoogleSignInAccount(iB11, strK7, strK8, strK9, strK10, uri, strK11, jC2, strK12, arrayListP3, strK13, strK14);
            case 9:
                int iK4 = wd.K(parcel);
                String strK15 = null;
                while (parcel.dataPosition() < iK4) {
                    int i8 = parcel.readInt();
                    char c3 = (char) i8;
                    if (c3 == 1) {
                        arrayListN = wd.n(i8, parcel);
                    } else if (c3 != 2) {
                        wd.H(i8, parcel);
                    } else {
                        strK15 = wd.k(i8, parcel);
                    }
                }
                wd.r(iK4, parcel);
                return new k12(strK15, arrayListN);
            case 10:
                int iK5 = wd.K(parcel);
                v12 v12Var = null;
                while (parcel.dataPosition() < iK5) {
                    int i9 = parcel.readInt();
                    char c4 = (char) i9;
                    if (c4 == 1) {
                        iB8 = wd.B(i9, parcel);
                    } else if (c4 == 2) {
                        vlVar = (vl) wd.i(parcel, i9, vl.CREATOR);
                    } else if (c4 != 3) {
                        wd.H(i9, parcel);
                    } else {
                        v12Var = (v12) wd.i(parcel, i9, v12.CREATOR);
                    }
                }
                wd.r(iK5, parcel);
                return new o12(iB8, vlVar, v12Var);
            case 11:
                int iK6 = wd.K(parcel);
                long jC3 = 0;
                long jC4 = 0;
                String strK16 = null;
                String strK17 = null;
                int iB12 = 0;
                int iB13 = 0;
                int iB14 = 0;
                int iB15 = 0;
                int iB16 = -1;
                while (parcel.dataPosition() < iK6) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 1:
                            iB12 = wd.B(i10, parcel);
                            break;
                        case 2:
                            iB13 = wd.B(i10, parcel);
                            break;
                        case 3:
                            iB14 = wd.B(i10, parcel);
                            break;
                        case 4:
                            jC3 = wd.C(i10, parcel);
                            break;
                        case 5:
                            jC4 = wd.C(i10, parcel);
                            break;
                        case 6:
                            strK16 = wd.k(i10, parcel);
                            break;
                        case 7:
                            strK17 = wd.k(i10, parcel);
                            break;
                        case '\b':
                            iB15 = wd.B(i10, parcel);
                            break;
                        case '\t':
                            iB16 = wd.B(i10, parcel);
                            break;
                        default:
                            wd.H(i10, parcel);
                            break;
                    }
                }
                wd.r(iK6, parcel);
                return new eu0(iB12, iB13, iB14, jC3, jC4, strK16, strK17, iB15, iB16);
            case 12:
                int iK7 = wd.K(parcel);
                GoogleSignInAccount googleSignInAccount = null;
                int iB17 = 0;
                while (parcel.dataPosition() < iK7) {
                    int i11 = parcel.readInt();
                    char c5 = (char) i11;
                    if (c5 == 1) {
                        iB7 = wd.B(i11, parcel);
                    } else if (c5 == 2) {
                        account = (Account) wd.i(parcel, i11, Account.CREATOR);
                    } else if (c5 == 3) {
                        iB17 = wd.B(i11, parcel);
                    } else if (c5 != 4) {
                        wd.H(i11, parcel);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) wd.i(parcel, i11, GoogleSignInAccount.CREATOR);
                    }
                }
                wd.r(iK7, parcel);
                return new u12(iB7, account, iB17, googleSignInAccount);
            case 13:
                int iK8 = wd.K(parcel);
                IBinder iBinderA2 = null;
                vl vlVar2 = null;
                int iB18 = 0;
                boolean z4 = false;
                boolean z5 = false;
                while (parcel.dataPosition() < iK8) {
                    int i12 = parcel.readInt();
                    char c6 = (char) i12;
                    if (c6 == 1) {
                        iB18 = wd.B(i12, parcel);
                    } else if (c6 == 2) {
                        iBinderA2 = wd.A(i12, parcel);
                    } else if (c6 == 3) {
                        vlVar2 = (vl) wd.i(parcel, i12, vl.CREATOR);
                    } else if (c6 == 4) {
                        z4 = wd.z(i12, parcel);
                    } else if (c6 != 5) {
                        wd.H(i12, parcel);
                    } else {
                        z5 = wd.z(i12, parcel);
                    }
                }
                wd.r(iK8, parcel);
                return new v12(iB18, iBinderA2, vlVar2, z4, z5);
            case 14:
                int iK9 = wd.K(parcel);
                while (parcel.dataPosition() < iK9) {
                    int i13 = parcel.readInt();
                    char c7 = (char) i13;
                    if (c7 == 1) {
                        iB6 = wd.B(i13, parcel);
                    } else if (c7 != 2) {
                        wd.H(i13, parcel);
                    } else {
                        strK6 = wd.k(i13, parcel);
                    }
                }
                wd.r(iK9, parcel);
                return new Scope(iB6, strK6);
            case 15:
                int iK10 = wd.K(parcel);
                int iB19 = 0;
                int iB20 = 0;
                int iB21 = 0;
                boolean z6 = false;
                boolean z7 = false;
                while (parcel.dataPosition() < iK10) {
                    int i14 = parcel.readInt();
                    char c8 = (char) i14;
                    if (c8 == 1) {
                        iB19 = wd.B(i14, parcel);
                    } else if (c8 == 2) {
                        z6 = wd.z(i14, parcel);
                    } else if (c8 == 3) {
                        z7 = wd.z(i14, parcel);
                    } else if (c8 == 4) {
                        iB20 = wd.B(i14, parcel);
                    } else if (c8 != 5) {
                        wd.H(i14, parcel);
                    } else {
                        iB21 = wd.B(i14, parcel);
                    }
                }
                wd.r(iK10, parcel);
                return new nc1(iB19, iB20, iB21, z6, z7);
            case 16:
                int iK11 = wd.K(parcel);
                String strK18 = null;
                int iB22 = 0;
                while (parcel.dataPosition() < iK11) {
                    int i15 = parcel.readInt();
                    char c9 = (char) i15;
                    if (c9 == 1) {
                        iB5 = wd.B(i15, parcel);
                    } else if (c9 == 2) {
                        iB22 = wd.B(i15, parcel);
                    } else if (c9 == 3) {
                        pendingIntent = (PendingIntent) wd.i(parcel, i15, PendingIntent.CREATOR);
                    } else if (c9 != 4) {
                        wd.H(i15, parcel);
                    } else {
                        strK18 = wd.k(i15, parcel);
                    }
                }
                wd.r(iK11, parcel);
                return new vl(iB5, iB22, pendingIntent, strK18);
            case 17:
                int iK12 = wd.K(parcel);
                PendingIntent pendingIntent2 = null;
                vl vlVar3 = null;
                while (parcel.dataPosition() < iK12) {
                    int i16 = parcel.readInt();
                    char c10 = (char) i16;
                    if (c10 == 1) {
                        iB4 = wd.B(i16, parcel);
                    } else if (c10 == 2) {
                        strK5 = wd.k(i16, parcel);
                    } else if (c10 == 3) {
                        pendingIntent2 = (PendingIntent) wd.i(parcel, i16, PendingIntent.CREATOR);
                    } else if (c10 != 4) {
                        wd.H(i16, parcel);
                    } else {
                        vlVar3 = (vl) wd.i(parcel, i16, vl.CREATOR);
                    }
                }
                wd.r(iK12, parcel);
                return new Status(iB4, strK5, pendingIntent2, vlVar3);
            case 18:
                int iK13 = wd.K(parcel);
                String strK19 = null;
                String strK20 = null;
                while (parcel.dataPosition() < iK13) {
                    int i17 = parcel.readInt();
                    char c11 = (char) i17;
                    if (c11 == 1) {
                        strK4 = wd.k(i17, parcel);
                    } else if (c11 == 2) {
                        strK19 = wd.k(i17, parcel);
                    } else if (c11 != 3) {
                        wd.H(i17, parcel);
                    } else {
                        strK20 = wd.k(i17, parcel);
                    }
                }
                wd.r(iK13, parcel);
                return new c22(strK4, strK19, strK20);
            case 19:
                int iK14 = wd.K(parcel);
                String strK21 = null;
                String strK22 = null;
                String strK23 = null;
                String strK24 = null;
                String strK25 = null;
                String strK26 = null;
                String strK27 = null;
                Intent intent2 = null;
                IBinder iBinderA3 = null;
                boolean z8 = false;
                while (parcel.dataPosition() < iK14) {
                    int i18 = parcel.readInt();
                    switch ((char) i18) {
                        case 2:
                            strK21 = wd.k(i18, parcel);
                            break;
                        case 3:
                            strK22 = wd.k(i18, parcel);
                            break;
                        case 4:
                            strK23 = wd.k(i18, parcel);
                            break;
                        case 5:
                            strK24 = wd.k(i18, parcel);
                            break;
                        case 6:
                            strK25 = wd.k(i18, parcel);
                            break;
                        case 7:
                            strK26 = wd.k(i18, parcel);
                            break;
                        case '\b':
                            strK27 = wd.k(i18, parcel);
                            break;
                        case '\t':
                            intent2 = (Intent) wd.i(parcel, i18, Intent.CREATOR);
                            break;
                        case '\n':
                            iBinderA3 = wd.A(i18, parcel);
                            break;
                        case 11:
                            z8 = wd.z(i18, parcel);
                            break;
                        default:
                            wd.H(i18, parcel);
                            break;
                    }
                }
                wd.r(iK14, parcel);
                return new m62(strK21, strK22, strK23, strK24, strK25, strK26, strK27, intent2, iBinderA3, z8);
            case 20:
                int iK15 = wd.K(parcel);
                while (parcel.dataPosition() < iK15) {
                    int i19 = parcel.readInt();
                    char c12 = (char) i19;
                    if (c12 == 1) {
                        strK3 = wd.k(i19, parcel);
                    } else if (c12 != 2) {
                        wd.H(i19, parcel);
                    } else {
                        iB3 = wd.B(i19, parcel);
                    }
                }
                wd.r(iK15, parcel);
                return new o42(strK3, iB3);
            case zzbbc.zzt.zzm /* 21 */:
                int iK16 = wd.K(parcel);
                int iB23 = 102;
                long jC5 = 3600000;
                int iB24 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                long jC6 = Long.MAX_VALUE;
                float f = 0.0f;
                long jC7 = 600000;
                boolean z9 = false;
                while (parcel.dataPosition() < iK16) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            iB23 = wd.B(i20, parcel);
                            break;
                        case 2:
                            jC5 = wd.C(i20, parcel);
                            break;
                        case 3:
                            jC7 = wd.C(i20, parcel);
                            break;
                        case 4:
                            z3 = wd.z(i20, parcel);
                            break;
                        case 5:
                            jC6 = wd.C(i20, parcel);
                            break;
                        case 6:
                            iB24 = wd.B(i20, parcel);
                            break;
                        case 7:
                            wd.N(parcel, i20, 4);
                            f = parcel.readFloat();
                            break;
                        case '\b':
                            jC = wd.C(i20, parcel);
                            break;
                        case '\t':
                            z9 = wd.z(i20, parcel);
                            break;
                        default:
                            wd.H(i20, parcel);
                            break;
                    }
                }
                wd.r(iK16, parcel);
                LocationRequest locationRequest = new LocationRequest();
                locationRequest.g = iB23;
                locationRequest.h = jC5;
                locationRequest.i = jC7;
                locationRequest.j = z3;
                locationRequest.k = jC6;
                locationRequest.l = iB24;
                locationRequest.m = f;
                locationRequest.n = jC;
                locationRequest.o = z9;
                return locationRequest;
            case 22:
                int iK17 = wd.K(parcel);
                String strK28 = "";
                String strK29 = "";
                String strK30 = strK29;
                while (parcel.dataPosition() < iK17) {
                    int i21 = parcel.readInt();
                    char c13 = (char) i21;
                    if (c13 == 1) {
                        strK29 = wd.k(i21, parcel);
                    } else if (c13 == 2) {
                        strK30 = wd.k(i21, parcel);
                    } else if (c13 != 5) {
                        wd.H(i21, parcel);
                    } else {
                        strK28 = wd.k(i21, parcel);
                    }
                }
                wd.r(iK17, parcel);
                return new d52(strK28, strK29, strK30);
            case 23:
                int iK18 = wd.K(parcel);
                d52 d52Var = null;
                boolean z10 = false;
                while (parcel.dataPosition() < iK18) {
                    int i22 = parcel.readInt();
                    char c14 = (char) i22;
                    if (c14 == 1) {
                        arrayListP = wd.p(parcel, i22, LocationRequest.CREATOR);
                    } else if (c14 == 2) {
                        z2 = wd.z(i22, parcel);
                    } else if (c14 == 3) {
                        z10 = wd.z(i22, parcel);
                    } else if (c14 != 5) {
                        wd.H(i22, parcel);
                    } else {
                        d52Var = (d52) wd.i(parcel, i22, d52.CREATOR);
                    }
                }
                wd.r(iK18, parcel);
                return new hp0(arrayListP, z2, z10, d52Var);
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                int iK19 = wd.K(parcel);
                kp0 kp0Var = null;
                while (parcel.dataPosition() < iK19) {
                    int i23 = parcel.readInt();
                    char c15 = (char) i23;
                    if (c15 == 1) {
                        status = (Status) wd.i(parcel, i23, Status.CREATOR);
                    } else if (c15 != 2) {
                        wd.H(i23, parcel);
                    } else {
                        kp0Var = (kp0) wd.i(parcel, i23, kp0.CREATOR);
                    }
                }
                wd.r(iK19, parcel);
                return new jp0(status, kp0Var);
            case 25:
                int iK20 = wd.K(parcel);
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                boolean z14 = false;
                boolean z15 = false;
                boolean z16 = false;
                while (parcel.dataPosition() < iK20) {
                    int i24 = parcel.readInt();
                    switch ((char) i24) {
                        case 1:
                            z11 = wd.z(i24, parcel);
                            break;
                        case 2:
                            z12 = wd.z(i24, parcel);
                            break;
                        case 3:
                            z13 = wd.z(i24, parcel);
                            break;
                        case 4:
                            z14 = wd.z(i24, parcel);
                            break;
                        case 5:
                            z15 = wd.z(i24, parcel);
                            break;
                        case 6:
                            z16 = wd.z(i24, parcel);
                            break;
                        default:
                            wd.H(i24, parcel);
                            break;
                    }
                }
                wd.r(iK20, parcel);
                return new kp0(z11, z12, z13, z14, z15, z16);
            case 26:
                int iK21 = wd.K(parcel);
                long jC8 = -1;
                while (parcel.dataPosition() < iK21) {
                    int i25 = parcel.readInt();
                    char c16 = (char) i25;
                    if (c16 == 1) {
                        strK2 = wd.k(i25, parcel);
                    } else if (c16 == 2) {
                        iB2 = wd.B(i25, parcel);
                    } else if (c16 != 3) {
                        wd.H(i25, parcel);
                    } else {
                        jC8 = wd.C(i25, parcel);
                    }
                }
                wd.r(iK21, parcel);
                return new v20(strK2, iB2, jC8);
            case 27:
                int iK22 = wd.K(parcel);
                while (parcel.dataPosition() < iK22) {
                    int i26 = parcel.readInt();
                    char c17 = (char) i26;
                    if (c17 == 1) {
                        z = wd.z(i26, parcel);
                    } else if (c17 != 2) {
                        wd.H(i26, parcel);
                    } else {
                        iBinderA = wd.A(i26, parcel);
                    }
                }
                wd.r(iK22, parcel);
                return new p2(z, iBinderA);
            case 28:
                int iK23 = wd.K(parcel);
                long jC9 = 0;
                long jC10 = 0;
                String strK31 = null;
                String strK32 = null;
                String strK33 = null;
                Bundle bundleG = null;
                String strK34 = null;
                boolean z17 = false;
                while (parcel.dataPosition() < iK23) {
                    int i27 = parcel.readInt();
                    switch ((char) i27) {
                        case 1:
                            jC9 = wd.C(i27, parcel);
                            break;
                        case 2:
                            jC10 = wd.C(i27, parcel);
                            break;
                        case 3:
                            z17 = wd.z(i27, parcel);
                            break;
                        case 4:
                            strK31 = wd.k(i27, parcel);
                            break;
                        case 5:
                            strK32 = wd.k(i27, parcel);
                            break;
                        case 6:
                            strK33 = wd.k(i27, parcel);
                            break;
                        case 7:
                            bundleG = wd.g(i27, parcel);
                            break;
                        case '\b':
                            strK34 = wd.k(i27, parcel);
                            break;
                        default:
                            wd.H(i27, parcel);
                            break;
                    }
                }
                wd.r(iK23, parcel);
                return new f72(jC9, jC10, z17, strK31, strK32, strK33, bundleG, strK34);
            default:
                int iK24 = wd.K(parcel);
                String strK35 = null;
                while (parcel.dataPosition() < iK24) {
                    int i28 = parcel.readInt();
                    char c18 = (char) i28;
                    if (c18 == 1) {
                        strK = wd.k(i28, parcel);
                    } else if (c18 != 2) {
                        wd.H(i28, parcel);
                    } else {
                        strK35 = wd.k(i28, parcel);
                    }
                }
                wd.r(iK24, parcel);
                return new l62(strK, strK35);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new bc1[i];
            case 1:
                return new ye1[i];
            case 2:
                return new si1[i];
            case 3:
                return new ti1[i];
            case 4:
                return new el1[i];
            case 5:
                return new mp1[i];
            case 6:
                return new vm1[i];
            case 7:
                return new r02[i];
            case 8:
                return new GoogleSignInAccount[i];
            case 9:
                return new k12[i];
            case 10:
                return new o12[i];
            case 11:
                return new eu0[i];
            case 12:
                return new u12[i];
            case 13:
                return new v12[i];
            case 14:
                return new Scope[i];
            case 15:
                return new nc1[i];
            case 16:
                return new vl[i];
            case 17:
                return new Status[i];
            case 18:
                return new c22[i];
            case 19:
                return new m62[i];
            case 20:
                return new o42[i];
            case zzbbc.zzt.zzm /* 21 */:
                return new LocationRequest[i];
            case 22:
                return new d52[i];
            case 23:
                return new hp0[i];
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                return new jp0[i];
            case 25:
                return new kp0[i];
            case 26:
                return new v20[i];
            case 27:
                return new p2[i];
            case 28:
                return new f72[i];
            default:
                return new l62[i];
        }
    }
}
