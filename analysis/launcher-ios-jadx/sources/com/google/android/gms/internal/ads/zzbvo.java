package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvo extends zzaxm implements IInterface {
    public zzbvo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbvn zzbvnVar, String str, String str2) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbvnVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzdc(2, parcelZza);
    }
}
