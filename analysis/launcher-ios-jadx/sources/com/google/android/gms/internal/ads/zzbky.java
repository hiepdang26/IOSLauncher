package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbky extends zzaxn implements zzbkz {
    public zzbky() {
        super("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    public static zzbkz zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
        return iInterfaceQueryLocalInterface instanceof zzbkz ? (zzbkz) iInterfaceQueryLocalInterface : new zzbkx(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzf();
        } else {
            if (i != 3) {
                return false;
            }
            String string = parcel.readString();
            zzaxo.zzc(parcel);
            zze(string);
        }
        parcel2.writeNoException();
        return true;
    }
}
