package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwo extends zzaxm implements IInterface {
    public zzbwo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbwd zzbwdVar, String str, String str2) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbwdVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzdc(2, parcelZza);
    }
}
