package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbuj extends zzaxn implements zzbuk {
    public zzbuj() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbuu zzbusVar = null;
        if (i == 1) {
            zzaxo.zzc(parcel);
            parcel2.writeNoException();
            zzaxo.zze(parcel2, null);
        } else if (i == 2) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                if (iInterfaceQueryLocalInterface instanceof zzbul) {
                }
            }
            zzaxo.zzc(parcel);
            parcel2.writeNoException();
        } else if (i == 4) {
            zzbvb zzbvbVar = (zzbvb) zzaxo.zza(parcel, zzbvb.CREATOR);
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbusVar = iInterfaceQueryLocalInterface2 instanceof zzbuu ? (zzbuu) iInterfaceQueryLocalInterface2 : new zzbus(strongBinder2);
            }
            zzaxo.zzc(parcel);
            zzg(zzbvbVar, zzbusVar);
            parcel2.writeNoException();
        } else if (i == 5) {
            zzbvb zzbvbVar2 = (zzbvb) zzaxo.zza(parcel, zzbvb.CREATOR);
            IBinder strongBinder3 = parcel.readStrongBinder();
            if (strongBinder3 != null) {
                IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbusVar = iInterfaceQueryLocalInterface3 instanceof zzbuu ? (zzbuu) iInterfaceQueryLocalInterface3 : new zzbus(strongBinder3);
            }
            zzaxo.zzc(parcel);
            zzf(zzbvbVar2, zzbusVar);
            parcel2.writeNoException();
        } else if (i == 6) {
            zzbvb zzbvbVar3 = (zzbvb) zzaxo.zza(parcel, zzbvb.CREATOR);
            IBinder strongBinder4 = parcel.readStrongBinder();
            if (strongBinder4 != null) {
                IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbusVar = iInterfaceQueryLocalInterface4 instanceof zzbuu ? (zzbuu) iInterfaceQueryLocalInterface4 : new zzbus(strongBinder4);
            }
            zzaxo.zzc(parcel);
            zze(zzbvbVar3, zzbusVar);
            parcel2.writeNoException();
        } else {
            if (i != 7) {
                return false;
            }
            String string = parcel.readString();
            IBinder strongBinder5 = parcel.readStrongBinder();
            if (strongBinder5 != null) {
                IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbusVar = iInterfaceQueryLocalInterface5 instanceof zzbuu ? (zzbuu) iInterfaceQueryLocalInterface5 : new zzbus(strongBinder5);
            }
            zzaxo.zzc(parcel);
            zzh(string, zzbusVar);
            parcel2.writeNoException();
        }
        return true;
    }
}
