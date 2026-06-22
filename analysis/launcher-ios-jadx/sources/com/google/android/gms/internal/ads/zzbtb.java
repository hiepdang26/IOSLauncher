package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbtb extends zzaxn implements zzbtc {
    public zzbtb() {
        super("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    public static zzbtc zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
        return iInterfaceQueryLocalInterface instanceof zzbtc ? (zzbtc) iInterfaceQueryLocalInterface : new zzbta(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
            zzaxo.zzc(parcel);
            zzf(arrayListCreateTypedArrayList);
        } else {
            if (i != 2) {
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
