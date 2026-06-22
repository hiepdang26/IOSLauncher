package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgc extends zzaxm implements zzbge {
    public zzbgc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbge
    public final void zze(zzbfu zzbfuVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbfuVar);
        zzdc(1, parcelZza);
    }
}
