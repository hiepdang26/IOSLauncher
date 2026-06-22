package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpp extends b0 {
    public static final Parcelable.Creator<zzfpp> CREATOR = new zzfpq();
    public final int zza;
    public final String zzb;
    public final String zzc;

    public zzfpp(int i, String str, String str2) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(i2);
        os.z(parcel, 2, this.zzb);
        os.z(parcel, 3, this.zzc);
        os.F(iE, parcel);
    }

    public zzfpp(String str, String str2) {
        this(1, str, str2);
    }
}
