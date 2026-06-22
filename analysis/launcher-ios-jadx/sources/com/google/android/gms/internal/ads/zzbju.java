package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbju extends zzaxm implements zzbjw {
    public zzbju(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbjw
    public final void zzb(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(1, parcelZza);
    }
}
