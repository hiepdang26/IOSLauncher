package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbsm extends zzaxn implements zzbsn {
    public zzbsm() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzbsn zzI(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        return iInterfaceQueryLocalInterface instanceof zzbsn ? (zzbsn) iInterfaceQueryLocalInterface : new zzbsl(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                Bundle bundle = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzl(bundle);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel2.writeNoException();
                return true;
            case 3:
                zzt();
                parcel2.writeNoException();
                return true;
            case 4:
                zzr();
                parcel2.writeNoException();
                return true;
            case 5:
                zzo();
                parcel2.writeNoException();
                return true;
            case 6:
                Bundle bundle2 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzs(bundle2);
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundle2);
                return true;
            case 7:
                zzu();
                parcel2.writeNoException();
                return true;
            case 8:
                zzm();
                parcel2.writeNoException();
                return true;
            case 9:
                zzx();
                parcel2.writeNoException();
                return true;
            case 10:
                zzi();
                parcel2.writeNoException();
                return true;
            case 11:
                boolean zZzH = zzH();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzH ? 1 : 0);
                return true;
            case 12:
                parcel.readInt();
                parcel.readInt();
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                return true;
            case 13:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzk(he0VarQ);
                parcel2.writeNoException();
                return true;
            case 14:
                zzv();
                parcel2.writeNoException();
                return true;
            case 15:
                int i4 = parcel.readInt();
                String[] strArrCreateStringArray = parcel.createStringArray();
                int[] iArrCreateIntArray = parcel.createIntArray();
                zzaxo.zzc(parcel);
                zzp(i4, strArrCreateStringArray, iArrCreateIntArray);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
