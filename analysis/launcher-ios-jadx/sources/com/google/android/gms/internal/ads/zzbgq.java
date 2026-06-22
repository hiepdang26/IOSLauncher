package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgq extends zzaxn implements zzbgr {
    public zzbgq() {
        super("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public static zzbgr zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
        return iInterfaceQueryLocalInterface instanceof zzbgr ? (zzbgr) iInterfaceQueryLocalInterface : new zzbgp(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbha zzbgyVar;
        if (i != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzbgyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
            zzbgyVar = iInterfaceQueryLocalInterface instanceof zzbha ? (zzbha) iInterfaceQueryLocalInterface : new zzbgy(strongBinder);
        }
        zzaxo.zzc(parcel);
        zze(zzbgyVar);
        parcel2.writeNoException();
        return true;
    }
}
