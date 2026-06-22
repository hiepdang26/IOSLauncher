package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.b0;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzblh extends b0 {
    public static final Parcelable.Creator<zzblh> CREATOR = new zzbli();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final int zzd;

    public zzblh(int i, int i2, String str, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        this.zzd = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzb;
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(i2);
        os.z(parcel, 2, this.zzc);
        int i3 = this.zzd;
        os.G(parcel, 3, 4);
        parcel.writeInt(i3);
        int i4 = this.zza;
        os.G(parcel, zzbbc.zzq.zzf, 4);
        parcel.writeInt(i4);
        os.F(iE, parcel);
    }
}
