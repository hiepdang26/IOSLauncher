package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;
import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfb extends zzaxm implements zzbfd {
    public zzbfb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final double zzb() {
        Parcel parcelZzdb = zzdb(3, zza());
        double d = parcelZzdb.readDouble();
        parcelZzdb.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final int zzc() {
        Parcel parcelZzdb = zzdb(5, zza());
        int i = parcelZzdb.readInt();
        parcelZzdb.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final int zzd() {
        Parcel parcelZzdb = zzdb(4, zza());
        int i = parcelZzdb.readInt();
        parcelZzdb.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final Uri zze() {
        Parcel parcelZzdb = zzdb(2, zza());
        Uri uri = (Uri) zzaxo.zza(parcelZzdb, Uri.CREATOR);
        parcelZzdb.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final he0 zzf() {
        return k31.i(zzdb(1, zza()));
    }
}
