package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.os;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbuc extends b0 {
    public static final Parcelable.Creator<zzbuc> CREATOR = new zzbud();
    public final ApplicationInfo zza;
    public final String zzb;
    public final PackageInfo zzc;
    public final String zzd;
    public final int zze;
    public final String zzf;
    public final List zzg;
    public final boolean zzh;
    public final boolean zzi;

    public zzbuc(ApplicationInfo applicationInfo, String str, PackageInfo packageInfo, String str2, int i, String str3, List list, boolean z, boolean z2) {
        this.zzb = str;
        this.zza = applicationInfo;
        this.zzc = packageInfo;
        this.zzd = str2;
        this.zze = i;
        this.zzf = str3;
        this.zzg = list;
        this.zzh = z;
        this.zzi = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ApplicationInfo applicationInfo = this.zza;
        int iE = os.E(20293, parcel);
        os.y(parcel, 1, applicationInfo, i);
        os.z(parcel, 2, this.zzb);
        os.y(parcel, 3, this.zzc, i);
        os.z(parcel, 4, this.zzd);
        int i2 = this.zze;
        os.G(parcel, 5, 4);
        parcel.writeInt(i2);
        os.z(parcel, 6, this.zzf);
        os.B(parcel, 7, this.zzg);
        boolean z = this.zzh;
        os.G(parcel, 8, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzi;
        os.G(parcel, 9, 4);
        parcel.writeInt(z2 ? 1 : 0);
        os.F(iE, parcel);
    }
}
