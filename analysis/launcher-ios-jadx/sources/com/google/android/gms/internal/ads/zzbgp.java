package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgp extends zzaxm implements zzbgr {
    public zzbgp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbgr
    public final void zze(zzbha zzbhaVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbhaVar);
        zzdc(1, parcelZza);
    }
}
