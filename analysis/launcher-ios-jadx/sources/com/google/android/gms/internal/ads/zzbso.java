package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbso extends zzaxm implements zzbsq {
    public zzbso(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbsq
    public final IBinder zze(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        parcelZzdb.recycle();
        return strongBinder;
    }
}
