package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbwi extends zzaxn implements zzbwj {
    public zzbwi() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbwd zzbwbVar;
        switch (i) {
            case 1:
                zzj();
                break;
            case 2:
                zzg();
                break;
            case 3:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzbwbVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                    zzbwbVar = iInterfaceQueryLocalInterface instanceof zzbwd ? (zzbwd) iInterfaceQueryLocalInterface : new zzbwb(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzk(zzbwbVar);
                break;
            case 4:
                int i3 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzh(i3);
                break;
            case 5:
                j92 j92Var = (j92) zzaxo.zza(parcel, j92.CREATOR);
                zzaxo.zzc(parcel);
                zzi(j92Var);
                break;
            case 6:
                zzf();
                break;
            case 7:
                zze();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
