package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpy extends b0 {
    public static final Parcelable.Creator<zzfpy> CREATOR = new zzfpz();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final String zzd;
    public final int zze;

    public zzfpy(int i, int i2, int i3, String str, String str2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        this.zzd = str2;
        this.zze = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = this.zzb;
        os.G(parcel, 2, 4);
        parcel.writeInt(i3);
        os.z(parcel, 3, this.zzc);
        os.z(parcel, 4, this.zzd);
        int i4 = this.zze;
        os.G(parcel, 5, 4);
        parcel.writeInt(i4);
        os.F(iE, parcel);
    }

    public zzfpy(int i, int i2, String str, String str2) {
        this(1, 1, i2 - 1, str, str2);
    }
}
