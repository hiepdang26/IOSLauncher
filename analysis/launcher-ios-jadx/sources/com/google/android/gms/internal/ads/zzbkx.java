package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbkx extends zzaxm implements zzbkz {
    public zzbkx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbkz
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbkz
    public final void zzf() {
        zzdc(2, zza());
    }
}
