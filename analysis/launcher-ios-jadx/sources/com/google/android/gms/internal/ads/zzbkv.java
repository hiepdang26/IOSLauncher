package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzbkv extends b0 {
    public static final Parcelable.Creator<zzbkv> CREATOR = new zzbkw();
    public final String zza;
    public final boolean zzb;
    public final int zzc;
    public final String zzd;

    public zzbkv(String str, boolean z, int i, String str2) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
        this.zzd = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, str);
        boolean z = this.zzb;
        os.G(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        int i2 = this.zzc;
        os.G(parcel, 3, 4);
        parcel.writeInt(i2);
        os.z(parcel, 4, this.zzd);
        os.F(iE, parcel);
    }
}
