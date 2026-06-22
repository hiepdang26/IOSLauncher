package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.kf1;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwu extends b0 {
    public static final Parcelable.Creator<zzbwu> CREATOR = new zzbwv();
    public final String zza;
    public final String zzb;

    public zzbwu(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, str);
        os.z(parcel, 2, this.zzb);
        os.F(iE, parcel);
    }

    public zzbwu(kf1 kf1Var) {
        throw null;
    }
}
