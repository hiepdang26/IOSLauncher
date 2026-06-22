package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyn extends zzaxm implements zzbyp {
    public zzbyn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbyp
    public final zzbym zze(he0 he0Var, zzbom zzbomVar, int i) {
        zzbym zzbykVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(2, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbykVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            zzbykVar = iInterfaceQueryLocalInterface instanceof zzbym ? (zzbym) iInterfaceQueryLocalInterface : new zzbyk(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbykVar;
    }
}
