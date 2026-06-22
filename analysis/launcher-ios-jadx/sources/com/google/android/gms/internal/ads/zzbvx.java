package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbvx extends zzaxn implements zzbvy {
    public zzbvx() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzbvy zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        return iInterfaceQueryLocalInterface instanceof zzbvy ? (zzbvy) iInterfaceQueryLocalInterface : new zzbvw(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzl(he0VarQ);
                break;
            case 2:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzk(he0VarQ2, i3);
                break;
            case 3:
                he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzi(he0VarQ3);
                break;
            case 4:
                he0 he0VarQ4 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzj(he0VarQ4);
                break;
            case 5:
                he0 he0VarQ5 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzo(he0VarQ5);
                break;
            case 6:
                he0 he0VarQ6 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzf(he0VarQ6);
                break;
            case 7:
                he0 he0VarQ7 = gy0.q(parcel.readStrongBinder());
                zzbvz zzbvzVar = (zzbvz) zzaxo.zza(parcel, zzbvz.CREATOR);
                zzaxo.zzc(parcel);
                zzm(he0VarQ7, zzbvzVar);
                break;
            case 8:
                he0 he0VarQ8 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zze(he0VarQ8);
                break;
            case 9:
                he0 he0VarQ9 = gy0.q(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzg(he0VarQ9, i4);
                break;
            case 10:
                he0 he0VarQ10 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzh(he0VarQ10);
                break;
            case 11:
                he0 he0VarQ11 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzn(he0VarQ11);
                break;
            case 12:
                zzaxo.zzc(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
