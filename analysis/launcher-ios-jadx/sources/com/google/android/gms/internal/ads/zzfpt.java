package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpt extends zzaxm implements IInterface {
    public zzfpt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfpr zze(zzfpp zzfppVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzfppVar);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        zzfpr zzfprVar = (zzfpr) zzaxo.zza(parcelZzdb, zzfpr.CREATOR);
        parcelZzdb.recycle();
        return zzfprVar;
    }

    public final zzfqa zzf(zzfpy zzfpyVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzfpyVar);
        Parcel parcelZzdb = zzdb(3, parcelZza);
        zzfqa zzfqaVar = (zzfqa) zzaxo.zza(parcelZzdb, zzfqa.CREATOR);
        parcelZzdb.recycle();
        return zzfqaVar;
    }

    public final void zzg(zzfpm zzfpmVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzfpmVar);
        zzdc(2, parcelZza);
    }
}
