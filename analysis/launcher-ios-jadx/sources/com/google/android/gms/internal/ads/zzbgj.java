package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgj extends zzaxn implements zzbgk {
    public zzbgj() {
        super("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public static zzbgk zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
        return iInterfaceQueryLocalInterface instanceof zzbgk ? (zzbgk) iInterfaceQueryLocalInterface : new zzbgi(iBinder);
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
        zzaxo.zzc(parcel);
        zze(zzbfvVar);
        parcel2.writeNoException();
        return true;
    }
}
