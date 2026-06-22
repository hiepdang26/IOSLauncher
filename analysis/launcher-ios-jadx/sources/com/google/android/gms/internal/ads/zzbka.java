package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbka extends zzaxm implements zzbkc {
    public zzbka(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final zzbjz zze(he0 he0Var, zzbom zzbomVar, int i, zzbjw zzbjwVar) {
        zzbjz zzbjxVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        zzaxo.zzf(parcelZza, zzbjwVar);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbjxVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
            zzbjxVar = iInterfaceQueryLocalInterface instanceof zzbjz ? (zzbjz) iInterfaceQueryLocalInterface : new zzbjx(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbjxVar;
    }
}
