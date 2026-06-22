package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;
import defpackage.ta2;
import defpackage.tv0;
import defpackage.vv0;
import defpackage.wv0;
import defpackage.zr1;

/* JADX INFO: loaded from: classes.dex */
public final class zzbes extends b0 {
    public static final Parcelable.Creator<zzbes> CREATOR = new zzbet();
    public final int zza;
    public final boolean zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final ta2 zzf;
    public final boolean zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final int zzk;

    public zzbes(int i, boolean z, int i2, boolean z2, int i3, ta2 ta2Var, boolean z3, int i4, int i5, boolean z4, int i6) {
        this.zza = i;
        this.zzb = z;
        this.zzc = i2;
        this.zzd = z2;
        this.zze = i3;
        this.zzf = ta2Var;
        this.zzg = z3;
        this.zzh = i4;
        this.zzj = z4;
        this.zzi = i5;
        this.zzk = i6;
    }

    public static vv0 zza(zzbes zzbesVar) {
        tv0 tv0Var = new tv0();
        tv0Var.a = false;
        tv0Var.b = 0;
        tv0Var.c = false;
        int i = 1;
        tv0Var.e = 1;
        tv0Var.f = false;
        tv0Var.g = false;
        tv0Var.h = 0;
        tv0Var.i = 1;
        if (zzbesVar == null) {
            return new vv0(tv0Var);
        }
        int i2 = zzbesVar.zza;
        if (i2 == 2) {
            tv0Var.e = zzbesVar.zze;
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    tv0Var.f = zzbesVar.zzg;
                    tv0Var.b = zzbesVar.zzh;
                    int i3 = zzbesVar.zzi;
                    tv0Var.g = zzbesVar.zzj;
                    tv0Var.h = i3;
                    int i4 = zzbesVar.zzk;
                    if (i4 != 0) {
                        if (i4 == 2) {
                            i = 3;
                        } else if (i4 == 1) {
                            i = 2;
                        }
                    }
                    tv0Var.i = i;
                }
            }
            ta2 ta2Var = zzbesVar.zzf;
            if (ta2Var != null) {
                tv0Var.d = new zr1(ta2Var);
            }
            tv0Var.e = zzbesVar.zze;
        }
        tv0Var.a = zzbesVar.zzb;
        tv0Var.c = zzbesVar.zzd;
        return new vv0(tv0Var);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(i2);
        boolean z = this.zzb;
        os.G(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        int i3 = this.zzc;
        os.G(parcel, 3, 4);
        parcel.writeInt(i3);
        boolean z2 = this.zzd;
        os.G(parcel, 4, 4);
        parcel.writeInt(z2 ? 1 : 0);
        int i4 = this.zze;
        os.G(parcel, 5, 4);
        parcel.writeInt(i4);
        os.y(parcel, 6, this.zzf, i);
        boolean z3 = this.zzg;
        os.G(parcel, 7, 4);
        parcel.writeInt(z3 ? 1 : 0);
        int i5 = this.zzh;
        os.G(parcel, 8, 4);
        parcel.writeInt(i5);
        int i6 = this.zzi;
        os.G(parcel, 9, 4);
        parcel.writeInt(i6);
        boolean z4 = this.zzj;
        os.G(parcel, 10, 4);
        parcel.writeInt(z4 ? 1 : 0);
        int i7 = this.zzk;
        os.G(parcel, 11, 4);
        parcel.writeInt(i7);
        os.F(iE, parcel);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    public zzbes(wv0 wv0Var) {
        boolean z = wv0Var.a;
        zr1 zr1Var = wv0Var.f;
        this(4, z, wv0Var.b, wv0Var.d, wv0Var.e, zr1Var != null ? new ta2(zr1Var) : null, wv0Var.g, wv0Var.c, 0, false, 0);
    }
}
