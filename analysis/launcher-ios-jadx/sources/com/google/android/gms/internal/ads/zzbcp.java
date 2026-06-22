package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbcp extends zzaxm implements zzbcr {
    public zzbcp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbcr
    public final void zze(zzbco zzbcoVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbcoVar);
        zzdc(1, parcelZza);
    }
}
