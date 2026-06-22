package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbsh extends zzaxm implements zzbsj {
    public zzbsh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbsj
    public final zzbsg zze(he0 he0Var, zzbom zzbomVar, int i) {
        zzbsg zzbseVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbseVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
            zzbseVar = iInterfaceQueryLocalInterface instanceof zzbsg ? (zzbsg) iInterfaceQueryLocalInterface : new zzbse(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbseVar;
    }
}
