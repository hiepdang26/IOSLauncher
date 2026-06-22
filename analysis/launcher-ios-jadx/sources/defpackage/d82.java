package defpackage;

import android.accounts.Account;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d82 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ d82(int i) {
        this.a = i;
    }

    public static void a(i80 i80Var, Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(i80Var.g);
        os.G(parcel, 2, 4);
        parcel.writeInt(i80Var.h);
        os.G(parcel, 3, 4);
        parcel.writeInt(i80Var.i);
        os.z(parcel, 4, i80Var.j);
        os.x(parcel, 5, i80Var.k);
        os.C(parcel, 6, i80Var.l, i);
        os.v(parcel, 7, i80Var.m);
        os.y(parcel, 8, i80Var.n, i);
        os.C(parcel, 10, i80Var.o, i);
        os.C(parcel, 11, i80Var.p, i);
        os.G(parcel, 12, 4);
        parcel.writeInt(i80Var.q ? 1 : 0);
        os.G(parcel, 13, 4);
        parcel.writeInt(i80Var.r);
        boolean z = i80Var.s;
        os.G(parcel, 14, 4);
        parcel.writeInt(z ? 1 : 0);
        os.z(parcel, 15, i80Var.t);
        os.F(iE, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                int iK = wd.K(parcel);
                String strK = null;
                int iB = 0;
                while (parcel.dataPosition() < iK) {
                    int i = parcel.readInt();
                    char c = (char) i;
                    if (c == 1) {
                        strK = wd.k(i, parcel);
                    } else if (c != 2) {
                        wd.H(i, parcel);
                    } else {
                        iB = wd.B(i, parcel);
                    }
                }
                wd.r(iK, parcel);
                return new f62(strK, iB);
            case 1:
                int iK2 = wd.K(parcel);
                int iB2 = 0;
                while (parcel.dataPosition() < iK2) {
                    int i2 = parcel.readInt();
                    if (((char) i2) != 2) {
                        wd.H(i2, parcel);
                    } else {
                        iB2 = wd.B(i2, parcel);
                    }
                }
                wd.r(iK2, parcel);
                return new b92(iB2);
            case 2:
                int iK3 = wd.K(parcel);
                String strK2 = null;
                int iB3 = 0;
                int iB4 = 0;
                while (parcel.dataPosition() < iK3) {
                    int i3 = parcel.readInt();
                    char c2 = (char) i3;
                    if (c2 == 1) {
                        iB3 = wd.B(i3, parcel);
                    } else if (c2 == 2) {
                        iB4 = wd.B(i3, parcel);
                    } else if (c2 != 3) {
                        wd.H(i3, parcel);
                    } else {
                        strK2 = wd.k(i3, parcel);
                    }
                }
                wd.r(iK3, parcel);
                return new w92(iB3, iB4, strK2);
            case 3:
                int iK4 = wd.K(parcel);
                String strK3 = null;
                String strK4 = null;
                j92 j92Var = null;
                IBinder iBinderA = null;
                int iB5 = 0;
                while (parcel.dataPosition() < iK4) {
                    int i4 = parcel.readInt();
                    char c3 = (char) i4;
                    if (c3 == 1) {
                        iB5 = wd.B(i4, parcel);
                    } else if (c3 == 2) {
                        strK3 = wd.k(i4, parcel);
                    } else if (c3 == 3) {
                        strK4 = wd.k(i4, parcel);
                    } else if (c3 == 4) {
                        j92Var = (j92) wd.i(parcel, i4, j92.CREATOR);
                    } else if (c3 != 5) {
                        wd.H(i4, parcel);
                    } else {
                        iBinderA = wd.A(i4, parcel);
                    }
                }
                wd.r(iK4, parcel);
                return new j92(iB5, strK3, strK4, j92Var, iBinderA);
            case 4:
                int iK5 = wd.K(parcel);
                int iB6 = 0;
                int iB7 = 0;
                while (parcel.dataPosition() < iK5) {
                    int i5 = parcel.readInt();
                    char c4 = (char) i5;
                    if (c4 == 1) {
                        iB6 = wd.B(i5, parcel);
                    } else if (c4 != 2) {
                        wd.H(i5, parcel);
                    } else {
                        iB7 = wd.B(i5, parcel);
                    }
                }
                wd.r(iK5, parcel);
                return new ra2(iB6, iB7);
            case 5:
                int iK6 = wd.K(parcel);
                String strK5 = null;
                while (parcel.dataPosition() < iK6) {
                    int i6 = parcel.readInt();
                    if (((char) i6) != 15) {
                        wd.H(i6, parcel);
                    } else {
                        strK5 = wd.k(i6, parcel);
                    }
                }
                wd.r(iK6, parcel);
                return new sa2(strK5);
            case 6:
                int iK7 = wd.K(parcel);
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                while (parcel.dataPosition() < iK7) {
                    int i7 = parcel.readInt();
                    char c5 = (char) i7;
                    if (c5 == 2) {
                        z = wd.z(i7, parcel);
                    } else if (c5 == 3) {
                        z2 = wd.z(i7, parcel);
                    } else if (c5 != 4) {
                        wd.H(i7, parcel);
                    } else {
                        z3 = wd.z(i7, parcel);
                    }
                }
                wd.r(iK7, parcel);
                return new ta2(z, z2, z3);
            case 7:
                int iK8 = wd.K(parcel);
                IBinder iBinderA2 = null;
                IBinder iBinderA3 = null;
                boolean z4 = false;
                while (parcel.dataPosition() < iK8) {
                    int i8 = parcel.readInt();
                    char c6 = (char) i8;
                    if (c6 == 1) {
                        z4 = wd.z(i8, parcel);
                    } else if (c6 == 2) {
                        iBinderA2 = wd.A(i8, parcel);
                    } else if (c6 != 3) {
                        wd.H(i8, parcel);
                    } else {
                        iBinderA3 = wd.A(i8, parcel);
                    }
                }
                wd.r(iK8, parcel);
                return new a41(z4, iBinderA2, iBinderA3);
            case 8:
                int iK9 = wd.K(parcel);
                Bundle bundleG = null;
                v20[] v20VarArr = null;
                am amVar = null;
                int iB8 = 0;
                while (parcel.dataPosition() < iK9) {
                    int i9 = parcel.readInt();
                    char c7 = (char) i9;
                    if (c7 == 1) {
                        bundleG = wd.g(i9, parcel);
                    } else if (c7 == 2) {
                        v20VarArr = (v20[]) wd.o(parcel, i9, v20.CREATOR);
                    } else if (c7 == 3) {
                        iB8 = wd.B(i9, parcel);
                    } else if (c7 != 4) {
                        wd.H(i9, parcel);
                    } else {
                        amVar = (am) wd.i(parcel, i9, am.CREATOR);
                    }
                }
                wd.r(iK9, parcel);
                qb2 qb2Var = new qb2();
                qb2Var.g = bundleG;
                qb2Var.h = v20VarArr;
                qb2Var.i = iB8;
                qb2Var.j = amVar;
                return qb2Var;
            case 9:
                int iK10 = wd.K(parcel);
                String strK6 = null;
                boolean z5 = false;
                boolean z6 = false;
                boolean z7 = false;
                float f = 0.0f;
                int iB9 = 0;
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = false;
                while (parcel.dataPosition() < iK10) {
                    int i10 = parcel.readInt();
                    switch ((char) i10) {
                        case 2:
                            z5 = wd.z(i10, parcel);
                            break;
                        case 3:
                            z6 = wd.z(i10, parcel);
                            break;
                        case 4:
                            strK6 = wd.k(i10, parcel);
                            break;
                        case 5:
                            z7 = wd.z(i10, parcel);
                            break;
                        case 6:
                            wd.N(parcel, i10, 4);
                            f = parcel.readFloat();
                            break;
                        case 7:
                            iB9 = wd.B(i10, parcel);
                            break;
                        case '\b':
                            z8 = wd.z(i10, parcel);
                            break;
                        case '\t':
                            z9 = wd.z(i10, parcel);
                            break;
                        case '\n':
                            z10 = wd.z(i10, parcel);
                            break;
                        default:
                            wd.H(i10, parcel);
                            break;
                    }
                }
                wd.r(iK10, parcel);
                return new sb2(z5, z6, strK6, z7, f, iB9, z8, z9, z10);
            case 10:
                int iK11 = wd.K(parcel);
                nc1 nc1Var = null;
                int[] iArrCreateIntArray = null;
                int[] iArrCreateIntArray2 = null;
                boolean z11 = false;
                boolean z12 = false;
                int iB10 = 0;
                while (parcel.dataPosition() < iK11) {
                    int i11 = parcel.readInt();
                    switch ((char) i11) {
                        case 1:
                            nc1Var = (nc1) wd.i(parcel, i11, nc1.CREATOR);
                            break;
                        case 2:
                            z11 = wd.z(i11, parcel);
                            break;
                        case 3:
                            z12 = wd.z(i11, parcel);
                            break;
                        case 4:
                            int iD = wd.D(i11, parcel);
                            int iDataPosition = parcel.dataPosition();
                            if (iD != 0) {
                                iArrCreateIntArray = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition + iD);
                            } else {
                                iArrCreateIntArray = null;
                            }
                            break;
                        case 5:
                            iB10 = wd.B(i11, parcel);
                            break;
                        case 6:
                            int iD2 = wd.D(i11, parcel);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iD2 != 0) {
                                iArrCreateIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition2 + iD2);
                            } else {
                                iArrCreateIntArray2 = null;
                            }
                            break;
                        default:
                            wd.H(i11, parcel);
                            break;
                    }
                }
                wd.r(iK11, parcel);
                return new am(nc1Var, z11, z12, iArrCreateIntArray, iB10, iArrCreateIntArray2);
            case 11:
                int iK12 = wd.K(parcel);
                long jC = 0;
                long jC2 = 0;
                Bundle bundleG2 = null;
                ArrayList arrayListN = null;
                String strK7 = null;
                sa2 sa2Var = null;
                Location location = null;
                String strK8 = null;
                Bundle bundleG3 = null;
                Bundle bundleG4 = null;
                ArrayList arrayListN2 = null;
                String strK9 = null;
                String strK10 = null;
                l62 l62Var = null;
                String strK11 = null;
                ArrayList arrayListN3 = null;
                String strK12 = null;
                int iB11 = 0;
                int iB12 = 0;
                boolean z13 = false;
                int iB13 = 0;
                boolean z14 = false;
                boolean z15 = false;
                int iB14 = 0;
                int iB15 = 0;
                int iB16 = 0;
                while (parcel.dataPosition() < iK12) {
                    int i12 = parcel.readInt();
                    switch ((char) i12) {
                        case 1:
                            iB11 = wd.B(i12, parcel);
                            break;
                        case 2:
                            jC = wd.C(i12, parcel);
                            break;
                        case 3:
                            bundleG2 = wd.g(i12, parcel);
                            break;
                        case 4:
                            iB12 = wd.B(i12, parcel);
                            break;
                        case 5:
                            arrayListN = wd.n(i12, parcel);
                            break;
                        case 6:
                            z13 = wd.z(i12, parcel);
                            break;
                        case 7:
                            iB13 = wd.B(i12, parcel);
                            break;
                        case '\b':
                            z14 = wd.z(i12, parcel);
                            break;
                        case '\t':
                            strK7 = wd.k(i12, parcel);
                            break;
                        case '\n':
                            sa2Var = (sa2) wd.i(parcel, i12, sa2.CREATOR);
                            break;
                        case 11:
                            location = (Location) wd.i(parcel, i12, Location.CREATOR);
                            break;
                        case '\f':
                            strK8 = wd.k(i12, parcel);
                            break;
                        case '\r':
                            bundleG3 = wd.g(i12, parcel);
                            break;
                        case 14:
                            bundleG4 = wd.g(i12, parcel);
                            break;
                        case 15:
                            arrayListN2 = wd.n(i12, parcel);
                            break;
                        case 16:
                            strK9 = wd.k(i12, parcel);
                            break;
                        case 17:
                            strK10 = wd.k(i12, parcel);
                            break;
                        case 18:
                            z15 = wd.z(i12, parcel);
                            break;
                        case 19:
                            l62Var = (l62) wd.i(parcel, i12, l62.CREATOR);
                            break;
                        case 20:
                            iB14 = wd.B(i12, parcel);
                            break;
                        case zzbbc.zzt.zzm /* 21 */:
                            strK11 = wd.k(i12, parcel);
                            break;
                        case 22:
                            arrayListN3 = wd.n(i12, parcel);
                            break;
                        case 23:
                            iB15 = wd.B(i12, parcel);
                            break;
                        case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                            strK12 = wd.k(i12, parcel);
                            break;
                        case 25:
                            iB16 = wd.B(i12, parcel);
                            break;
                        case 26:
                            jC2 = wd.C(i12, parcel);
                            break;
                        default:
                            wd.H(i12, parcel);
                            break;
                    }
                }
                wd.r(iK12, parcel);
                return new tb2(iB11, jC, bundleG2, iB12, arrayListN, z13, iB13, z14, strK7, sa2Var, location, strK8, bundleG3, bundleG4, arrayListN2, strK9, strK10, z15, l62Var, iB14, strK11, arrayListN3, iB15, strK12, iB16, jC2);
            case 12:
                int iK13 = wd.K(parcel);
                Scope[] scopeArr = i80.u;
                Bundle bundle = new Bundle();
                v20[] v20VarArr2 = i80.v;
                v20[] v20VarArr3 = v20VarArr2;
                String strK13 = null;
                IBinder iBinderA4 = null;
                Account account = null;
                String strK14 = null;
                int iB17 = 0;
                int iB18 = 0;
                int iB19 = 0;
                boolean z16 = false;
                int iB20 = 0;
                boolean z17 = false;
                while (parcel.dataPosition() < iK13) {
                    int i13 = parcel.readInt();
                    switch ((char) i13) {
                        case 1:
                            iB17 = wd.B(i13, parcel);
                            break;
                        case 2:
                            iB18 = wd.B(i13, parcel);
                            break;
                        case 3:
                            iB19 = wd.B(i13, parcel);
                            break;
                        case 4:
                            strK13 = wd.k(i13, parcel);
                            break;
                        case 5:
                            iBinderA4 = wd.A(i13, parcel);
                            break;
                        case 6:
                            scopeArr = (Scope[]) wd.o(parcel, i13, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = wd.g(i13, parcel);
                            break;
                        case '\b':
                            account = (Account) wd.i(parcel, i13, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            wd.H(i13, parcel);
                            break;
                        case '\n':
                            v20VarArr2 = (v20[]) wd.o(parcel, i13, v20.CREATOR);
                            break;
                        case 11:
                            v20VarArr3 = (v20[]) wd.o(parcel, i13, v20.CREATOR);
                            break;
                        case '\f':
                            z16 = wd.z(i13, parcel);
                            break;
                        case '\r':
                            iB20 = wd.B(i13, parcel);
                            break;
                        case 14:
                            z17 = wd.z(i13, parcel);
                            break;
                        case 15:
                            strK14 = wd.k(i13, parcel);
                            break;
                    }
                }
                wd.r(iK13, parcel);
                return new i80(iB17, iB18, iB19, strK13, iBinderA4, scopeArr, bundle, account, v20VarArr2, v20VarArr3, z16, iB20, z17, strK14);
            case 13:
                int iK14 = wd.K(parcel);
                m62 m62Var = null;
                IBinder iBinderA5 = null;
                IBinder iBinderA6 = null;
                IBinder iBinderA7 = null;
                IBinder iBinderA8 = null;
                String strK15 = null;
                String strK16 = null;
                IBinder iBinderA9 = null;
                String strK17 = null;
                or1 or1Var = null;
                String strK18 = null;
                sb2 sb2Var = null;
                IBinder iBinderA10 = null;
                String strK19 = null;
                String strK20 = null;
                String strK21 = null;
                IBinder iBinderA11 = null;
                IBinder iBinderA12 = null;
                IBinder iBinderA13 = null;
                boolean z18 = false;
                int iB21 = 0;
                int iB22 = 0;
                boolean z19 = false;
                while (parcel.dataPosition() < iK14) {
                    int i14 = parcel.readInt();
                    switch ((char) i14) {
                        case 2:
                            m62Var = (m62) wd.i(parcel, i14, m62.CREATOR);
                            break;
                        case 3:
                            iBinderA5 = wd.A(i14, parcel);
                            break;
                        case 4:
                            iBinderA6 = wd.A(i14, parcel);
                            break;
                        case 5:
                            iBinderA7 = wd.A(i14, parcel);
                            break;
                        case 6:
                            iBinderA8 = wd.A(i14, parcel);
                            break;
                        case 7:
                            strK15 = wd.k(i14, parcel);
                            break;
                        case '\b':
                            z18 = wd.z(i14, parcel);
                            break;
                        case '\t':
                            strK16 = wd.k(i14, parcel);
                            break;
                        case '\n':
                            iBinderA9 = wd.A(i14, parcel);
                            break;
                        case 11:
                            iB21 = wd.B(i14, parcel);
                            break;
                        case '\f':
                            iB22 = wd.B(i14, parcel);
                            break;
                        case '\r':
                            strK17 = wd.k(i14, parcel);
                            break;
                        case 14:
                            or1Var = (or1) wd.i(parcel, i14, or1.CREATOR);
                            break;
                        case 15:
                        case 20:
                        case zzbbc.zzt.zzm /* 21 */:
                        case 22:
                        case 23:
                        default:
                            wd.H(i14, parcel);
                            break;
                        case 16:
                            strK18 = wd.k(i14, parcel);
                            break;
                        case 17:
                            sb2Var = (sb2) wd.i(parcel, i14, sb2.CREATOR);
                            break;
                        case 18:
                            iBinderA10 = wd.A(i14, parcel);
                            break;
                        case 19:
                            strK19 = wd.k(i14, parcel);
                            break;
                        case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                            strK20 = wd.k(i14, parcel);
                            break;
                        case 25:
                            strK21 = wd.k(i14, parcel);
                            break;
                        case 26:
                            iBinderA11 = wd.A(i14, parcel);
                            break;
                        case 27:
                            iBinderA12 = wd.A(i14, parcel);
                            break;
                        case 28:
                            iBinderA13 = wd.A(i14, parcel);
                            break;
                        case 29:
                            z19 = wd.z(i14, parcel);
                            break;
                    }
                }
                wd.r(iK14, parcel);
                return new AdOverlayInfoParcel(m62Var, iBinderA5, iBinderA6, iBinderA7, iBinderA8, strK15, z18, strK16, iBinderA9, iB21, iB22, strK17, or1Var, strK18, sb2Var, iBinderA10, strK19, strK20, strK21, iBinderA11, iBinderA12, iBinderA13, z19);
            case 14:
                int iK15 = wd.K(parcel);
                String strK22 = null;
                rc2[] rc2VarArr = null;
                int iB23 = 0;
                int iB24 = 0;
                boolean z20 = false;
                int iB25 = 0;
                int iB26 = 0;
                boolean z21 = false;
                boolean z22 = false;
                boolean z23 = false;
                boolean z24 = false;
                boolean z25 = false;
                boolean z26 = false;
                boolean z27 = false;
                boolean z28 = false;
                while (parcel.dataPosition() < iK15) {
                    int i15 = parcel.readInt();
                    switch ((char) i15) {
                        case 2:
                            strK22 = wd.k(i15, parcel);
                            break;
                        case 3:
                            iB23 = wd.B(i15, parcel);
                            break;
                        case 4:
                            iB24 = wd.B(i15, parcel);
                            break;
                        case 5:
                            z20 = wd.z(i15, parcel);
                            break;
                        case 6:
                            iB25 = wd.B(i15, parcel);
                            break;
                        case 7:
                            iB26 = wd.B(i15, parcel);
                            break;
                        case '\b':
                            rc2VarArr = (rc2[]) wd.o(parcel, i15, rc2.CREATOR);
                            break;
                        case '\t':
                            z21 = wd.z(i15, parcel);
                            break;
                        case '\n':
                            z22 = wd.z(i15, parcel);
                            break;
                        case 11:
                            z23 = wd.z(i15, parcel);
                            break;
                        case '\f':
                            z24 = wd.z(i15, parcel);
                            break;
                        case '\r':
                            z25 = wd.z(i15, parcel);
                            break;
                        case 14:
                            z26 = wd.z(i15, parcel);
                            break;
                        case 15:
                            z27 = wd.z(i15, parcel);
                            break;
                        case 16:
                            z28 = wd.z(i15, parcel);
                            break;
                        default:
                            wd.H(i15, parcel);
                            break;
                    }
                }
                wd.r(iK15, parcel);
                return new rc2(strK22, iB23, iB24, z20, iB25, iB26, rc2VarArr, z21, z22, z23, z24, z25, z26, z27, z28);
            case 15:
                int iK16 = wd.K(parcel);
                String strK23 = null;
                int iB27 = 0;
                int iB28 = 0;
                boolean z29 = false;
                boolean z30 = false;
                while (parcel.dataPosition() < iK16) {
                    int i16 = parcel.readInt();
                    char c8 = (char) i16;
                    if (c8 == 2) {
                        strK23 = wd.k(i16, parcel);
                    } else if (c8 == 3) {
                        iB27 = wd.B(i16, parcel);
                    } else if (c8 == 4) {
                        iB28 = wd.B(i16, parcel);
                    } else if (c8 == 5) {
                        z29 = wd.z(i16, parcel);
                    } else if (c8 != 6) {
                        wd.H(i16, parcel);
                    } else {
                        z30 = wd.z(i16, parcel);
                    }
                }
                wd.r(iK16, parcel);
                return new or1(strK23, iB27, iB28, z29, z30);
            case 16:
                int iK17 = wd.K(parcel);
                long jC3 = 0;
                String strK24 = null;
                int iB29 = 0;
                int iB30 = 0;
                while (parcel.dataPosition() < iK17) {
                    int i17 = parcel.readInt();
                    char c9 = (char) i17;
                    if (c9 == 1) {
                        iB29 = wd.B(i17, parcel);
                    } else if (c9 == 2) {
                        iB30 = wd.B(i17, parcel);
                    } else if (c9 == 3) {
                        strK24 = wd.k(i17, parcel);
                    } else if (c9 != 4) {
                        wd.H(i17, parcel);
                    } else {
                        jC3 = wd.C(i17, parcel);
                    }
                }
                wd.r(iK17, parcel);
                return new xc2(iB29, iB30, jC3, strK24);
            case 17:
                int iK18 = wd.K(parcel);
                String strK25 = null;
                j92 j92Var2 = null;
                Bundle bundleG5 = null;
                String strK26 = null;
                String strK27 = null;
                String strK28 = null;
                String strK29 = null;
                long jC4 = 0;
                while (parcel.dataPosition() < iK18) {
                    int i18 = parcel.readInt();
                    switch ((char) i18) {
                        case 1:
                            strK25 = wd.k(i18, parcel);
                            break;
                        case 2:
                            jC4 = wd.C(i18, parcel);
                            break;
                        case 3:
                            j92Var2 = (j92) wd.i(parcel, i18, j92.CREATOR);
                            break;
                        case 4:
                            bundleG5 = wd.g(i18, parcel);
                            break;
                        case 5:
                            strK26 = wd.k(i18, parcel);
                            break;
                        case 6:
                            strK27 = wd.k(i18, parcel);
                            break;
                        case 7:
                            strK28 = wd.k(i18, parcel);
                            break;
                        case '\b':
                            strK29 = wd.k(i18, parcel);
                            break;
                        default:
                            wd.H(i18, parcel);
                            break;
                    }
                }
                wd.r(iK18, parcel);
                return new ed2(strK25, jC4, j92Var2, bundleG5, strK26, strK27, strK28, strK29);
            default:
                int iK19 = wd.K(parcel);
                int iB31 = 0;
                while (parcel.dataPosition() < iK19) {
                    int i19 = parcel.readInt();
                    if (((char) i19) != 2) {
                        wd.H(i19, parcel);
                    } else {
                        iB31 = wd.B(i19, parcel);
                    }
                }
                wd.r(iK19, parcel);
                return new pd2(iB31);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new f62[i];
            case 1:
                return new b92[i];
            case 2:
                return new w92[i];
            case 3:
                return new j92[i];
            case 4:
                return new ra2[i];
            case 5:
                return new sa2[i];
            case 6:
                return new ta2[i];
            case 7:
                return new a41[i];
            case 8:
                return new qb2[i];
            case 9:
                return new sb2[i];
            case 10:
                return new am[i];
            case 11:
                return new tb2[i];
            case 12:
                return new i80[i];
            case 13:
                return new AdOverlayInfoParcel[i];
            case 14:
                return new rc2[i];
            case 15:
                return new or1[i];
            case 16:
                return new xc2[i];
            case 17:
                return new ed2[i];
            default:
                return new pd2[i];
        }
    }
}
