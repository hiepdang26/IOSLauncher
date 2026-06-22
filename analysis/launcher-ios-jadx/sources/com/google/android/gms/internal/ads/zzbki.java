package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzbki extends b0 {
    public static final Parcelable.Creator<zzbki> CREATOR = new zzbkj();
    public final String zza;
    public final String[] zzb;
    public final String[] zzc;

    public zzbki(String str, String[] strArr, String[] strArr2) {
        this.zza = str;
        this.zzb = strArr;
        this.zzc = strArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, str);
        os.A(parcel, 2, this.zzb);
        os.A(parcel, 3, this.zzc);
        os.F(iE, parcel);
    }
}
