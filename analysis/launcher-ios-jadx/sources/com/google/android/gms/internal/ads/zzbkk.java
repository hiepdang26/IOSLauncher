package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzbkk extends b0 {
    public static final Parcelable.Creator<zzbkk> CREATOR = new zzbkl();
    public final boolean zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;
    public final String[] zze;
    public final String[] zzf;
    public final boolean zzg;
    public final long zzh;

    public zzbkk(boolean z, String str, int i, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j) {
        this.zza = z;
        this.zzb = str;
        this.zzc = i;
        this.zzd = bArr;
        this.zze = strArr;
        this.zzf = strArr2;
        this.zzg = z2;
        this.zzh = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z = this.zza;
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(z ? 1 : 0);
        os.z(parcel, 2, this.zzb);
        int i2 = this.zzc;
        os.G(parcel, 3, 4);
        parcel.writeInt(i2);
        os.w(parcel, 4, this.zzd);
        os.A(parcel, 5, this.zze);
        os.A(parcel, 6, this.zzf);
        boolean z2 = this.zzg;
        os.G(parcel, 7, 4);
        parcel.writeInt(z2 ? 1 : 0);
        long j = this.zzh;
        os.G(parcel, 8, 8);
        parcel.writeLong(j);
        os.F(iE, parcel);
    }
}
