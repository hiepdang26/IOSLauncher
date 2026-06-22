package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.b0;
import defpackage.k92;
import defpackage.os;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbah extends b0 {
    public static final Parcelable.Creator<zzbah> CREATOR = new zzbai();
    public final String zza;
    public final long zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final Bundle zzf;
    public final boolean zzg;
    public long zzh;
    public String zzi;
    public int zzj;

    public zzbah(String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z, long j2, String str5, int i) {
        this.zza = str;
        this.zzb = j;
        this.zzc = str2 == null ? "" : str2;
        this.zzd = str3 == null ? "" : str3;
        this.zze = str4 == null ? "" : str4;
        this.zzf = bundle == null ? new Bundle() : bundle;
        this.zzg = z;
        this.zzh = j2;
        this.zzi = str5;
        this.zzj = i;
    }

    public static zzbah zza(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                k92.h("Expected 2 path parts for namespace and id, found :" + pathSegments.size());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean zEquals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long j = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzbah(queryParameter, j, host, str, str2, bundle, zEquals, 0L, "", 0);
        } catch (NullPointerException | NumberFormatException unused) {
            k92.j(5);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iE = os.E(20293, parcel);
        os.z(parcel, 2, str);
        long j = this.zzb;
        os.G(parcel, 3, 8);
        parcel.writeLong(j);
        os.z(parcel, 4, this.zzc);
        os.z(parcel, 5, this.zzd);
        os.z(parcel, 6, this.zze);
        os.v(parcel, 7, this.zzf);
        boolean z = this.zzg;
        os.G(parcel, 8, 4);
        parcel.writeInt(z ? 1 : 0);
        long j2 = this.zzh;
        os.G(parcel, 9, 8);
        parcel.writeLong(j2);
        os.z(parcel, 10, this.zzi);
        int i2 = this.zzj;
        os.G(parcel, 11, 4);
        parcel.writeInt(i2);
        os.F(iE, parcel);
    }
}
