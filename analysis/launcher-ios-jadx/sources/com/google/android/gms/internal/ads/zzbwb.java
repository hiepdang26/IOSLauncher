package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwb extends zzaxm implements zzbwd {
    public zzbwb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final int zze() {
        Parcel parcelZzdb = zzdb(2, zza());
        int i = parcelZzdb.readInt();
        parcelZzdb.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final String zzf() {
        Parcel parcelZzdb = zzdb(1, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }
}
