package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbem extends zzaxm implements IInterface {
    public zzbem(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzbtx zzbtxVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbtxVar);
        zzdc(1, parcelZza);
    }
}
