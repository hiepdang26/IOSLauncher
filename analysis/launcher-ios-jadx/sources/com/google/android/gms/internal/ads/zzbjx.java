package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbjx extends zzaxm implements zzbjz {
    public zzbjx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
    }

    @Override // com.google.android.gms.internal.ads.zzbjz
    public final void zze() {
        zzdc(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbjz
    public final void zzf(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(1, parcelZza);
    }
}
