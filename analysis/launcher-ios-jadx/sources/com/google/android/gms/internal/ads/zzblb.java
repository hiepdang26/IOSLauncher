package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzblb extends zzaxn implements zzblc {
    public zzblb() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzblc zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        return iInterfaceQueryLocalInterface instanceof zzblc ? (zzblc) iInterfaceQueryLocalInterface : new zzbla(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzbkv.CREATOR);
        zzaxo.zzc(parcel);
        zzb(arrayListCreateTypedArrayList);
        parcel2.writeNoException();
        return true;
    }
}
