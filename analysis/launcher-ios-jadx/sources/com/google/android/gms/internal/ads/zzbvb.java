package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.or1;
import defpackage.os;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvb extends b0 {
    public static final Parcelable.Creator<zzbvb> CREATOR = new zzbvc();
    public final Bundle zza;
    public final or1 zzb;
    public final ApplicationInfo zzc;
    public final String zzd;
    public final List zze;
    public final PackageInfo zzf;
    public final String zzg;
    public final String zzh;
    public zzfhb zzi;
    public String zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final Bundle zzm;

    public zzbvb(Bundle bundle, or1 or1Var, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, String str2, String str3, zzfhb zzfhbVar, String str4, boolean z, boolean z2, Bundle bundle2) {
        this.zza = bundle;
        this.zzb = or1Var;
        this.zzd = str;
        this.zzc = applicationInfo;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = str2;
        this.zzh = str3;
        this.zzi = zzfhbVar;
        this.zzj = str4;
        this.zzk = z;
        this.zzl = z2;
        this.zzm = bundle2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = this.zza;
        int iE = os.E(20293, parcel);
        os.v(parcel, 1, bundle);
        os.y(parcel, 2, this.zzb, i);
        os.y(parcel, 3, this.zzc, i);
        os.z(parcel, 4, this.zzd);
        os.B(parcel, 5, this.zze);
        os.y(parcel, 6, this.zzf, i);
        os.z(parcel, 7, this.zzg);
        os.z(parcel, 9, this.zzh);
        os.y(parcel, 10, this.zzi, i);
        os.z(parcel, 11, this.zzj);
        boolean z = this.zzk;
        os.G(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzl;
        os.G(parcel, 13, 4);
        parcel.writeInt(z2 ? 1 : 0);
        os.v(parcel, 14, this.zzm);
        os.F(iE, parcel);
    }
}
