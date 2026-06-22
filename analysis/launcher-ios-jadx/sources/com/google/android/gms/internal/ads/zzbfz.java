package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfz extends zzaxm implements zzbgb {
    public zzbfz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbgb
    public final void zze(zzbfs zzbfsVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbfsVar);
        zzdc(1, parcelZza);
    }
}
