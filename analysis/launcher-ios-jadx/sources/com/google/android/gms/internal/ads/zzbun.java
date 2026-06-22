package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbun extends zzaxn implements zzbuo {
    public zzbun() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbur zzbupVar = null;
        if (i == 1) {
            zzbuc zzbucVar = (zzbuc) zzaxo.zza(parcel, zzbuc.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbupVar = iInterfaceQueryLocalInterface instanceof zzbur ? (zzbur) iInterfaceQueryLocalInterface : new zzbup(strongBinder);
            }
            zzaxo.zzc(parcel);
            zzf(zzbucVar, zzbupVar);
        } else if (i == 2) {
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (iInterfaceQueryLocalInterface2 instanceof zzbur) {
                }
            }
            zzaxo.zzc(parcel);
        } else {
            if (i != 3) {
                return false;
            }
            zzbug zzbugVar = (zzbug) zzaxo.zza(parcel, zzbug.CREATOR);
            IBinder strongBinder3 = parcel.readStrongBinder();
            if (strongBinder3 != null) {
                IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbupVar = iInterfaceQueryLocalInterface3 instanceof zzbur ? (zzbur) iInterfaceQueryLocalInterface3 : new zzbup(strongBinder3);
            }
            zzaxo.zzc(parcel);
            zze(zzbugVar, zzbupVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
