package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgg extends zzaxn implements zzbgh {
    public zzbgg() {
        super("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public static zzbgh zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
        return iInterfaceQueryLocalInterface instanceof zzbgh ? (zzbgh) iInterfaceQueryLocalInterface : new zzbgf(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbfx zzbfvVar;
        if (i != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzbfvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
            zzbfvVar = iInterfaceQueryLocalInterface instanceof zzbfx ? (zzbfx) iInterfaceQueryLocalInterface : new zzbfv(strongBinder);
        }
        String string = parcel.readString();
        zzaxo.zzc(parcel);
        zze(zzbfvVar, string);
        parcel2.writeNoException();
        return true;
    }
}
