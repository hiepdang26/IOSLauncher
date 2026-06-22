package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;

/* JADX INFO: loaded from: classes.dex */
public final class zzbug extends b0 {
    public static final Parcelable.Creator<zzbug> CREATOR = new zzbuh();
    public final String zza;
    public final int zzb;
    public final Bundle zzc;
    public final byte[] zzd;
    public final boolean zze;
    public final String zzf;
    public final String zzg;

    public zzbug(String str, int i, Bundle bundle, byte[] bArr, boolean z, String str2, String str3) {
        this.zza = str;
        this.zzb = i;
        this.zzc = bundle;
        this.zzd = bArr;
        this.zze = z;
        this.zzf = str2;
        this.zzg = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, str);
        int i2 = this.zzb;
        os.G(parcel, 2, 4);
        parcel.writeInt(i2);
        os.v(parcel, 3, this.zzc);
        os.w(parcel, 4, this.zzd);
        boolean z = this.zze;
        os.G(parcel, 5, 4);
        parcel.writeInt(z ? 1 : 0);
        os.z(parcel, 6, this.zzf);
        os.z(parcel, 7, this.zzg);
        os.F(iE, parcel);
    }
}
