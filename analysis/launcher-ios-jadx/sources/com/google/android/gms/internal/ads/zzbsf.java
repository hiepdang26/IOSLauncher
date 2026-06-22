package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.c22;
import defpackage.gy0;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbsf extends zzaxn implements zzbsg {
    public zzbsf() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbsg zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        return iInterfaceQueryLocalInterface instanceof zzbsg ? (zzbsg) iInterfaceQueryLocalInterface : new zzbse(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                Intent intent = (Intent) zzaxo.zza(parcel, Intent.CREATOR);
                zzaxo.zzc(parcel);
                zze(intent);
                break;
            case 2:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzaxo.zzc(parcel);
                zzi(he0VarQ, string, string2);
                break;
            case 3:
                zzh();
                break;
            case 4:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzg(he0VarQ2);
                break;
            case 5:
                String[] strArrCreateStringArray = parcel.createStringArray();
                int[] iArrCreateIntArray = parcel.createIntArray();
                he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzf(strArrCreateStringArray, iArrCreateIntArray, he0VarQ3);
                break;
            case 6:
                he0 he0VarQ4 = gy0.q(parcel.readStrongBinder());
                c22 c22Var = (c22) zzaxo.zza(parcel, c22.CREATOR);
                zzaxo.zzc(parcel);
                zzj(he0VarQ4, c22Var);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
