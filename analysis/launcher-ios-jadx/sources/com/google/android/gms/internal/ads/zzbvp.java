package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.b62;
import defpackage.gy0;
import defpackage.he0;
import defpackage.u82;
import defpackage.y52;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbvp extends zzaxn implements zzbvq {
    public zzbvp() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzbvu zzbvuVar = (zzbvu) zzaxo.zza(parcel, zzbvu.CREATOR);
            zzaxo.zzc(parcel);
            zzg(zzbvuVar);
            parcel2.writeNoException();
            return true;
        }
        if (i == 2) {
            zzq();
            parcel2.writeNoException();
            return true;
        }
        zzbvt zzbvrVar = null;
        zzbvo zzbvoVar = null;
        b62 y52Var = null;
        if (i == 3) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                zzbvrVar = iInterfaceQueryLocalInterface instanceof zzbvt ? (zzbvt) iInterfaceQueryLocalInterface : new zzbvr(strongBinder);
            }
            zzaxo.zzc(parcel);
            zzo(zzbvrVar);
            parcel2.writeNoException();
            return true;
        }
        if (i == 34) {
            boolean zZzg = zzaxo.zzg(parcel);
            zzaxo.zzc(parcel);
            zzn(zZzg);
            parcel2.writeNoException();
            return true;
        }
        switch (i) {
            case 5:
                boolean zZzs = zzs();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzs ? 1 : 0);
                break;
            case 6:
                zzh();
                parcel2.writeNoException();
                break;
            case 7:
                zzj();
                parcel2.writeNoException();
                break;
            case 8:
                zze();
                parcel2.writeNoException();
                break;
            case 9:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzi(he0VarQ);
                parcel2.writeNoException();
                break;
            case 10:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzk(he0VarQ2);
                parcel2.writeNoException();
                break;
            case 11:
                he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzf(he0VarQ3);
                parcel2.writeNoException();
                break;
            case 12:
                String strZzd = zzd();
                parcel2.writeNoException();
                parcel2.writeString(strZzd);
                break;
            case 13:
                String string = parcel.readString();
                zzaxo.zzc(parcel);
                zzp(string);
                parcel2.writeNoException();
                break;
            case 14:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    y52Var = iInterfaceQueryLocalInterface2 instanceof b62 ? (b62) iInterfaceQueryLocalInterface2 : new y52(strongBinder2);
                }
                zzaxo.zzc(parcel);
                zzl(y52Var);
                parcel2.writeNoException();
                break;
            case 15:
                Bundle bundleZzb = zzb();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzb);
                break;
            case 16:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                    zzbvoVar = iInterfaceQueryLocalInterface3 instanceof zzbvo ? (zzbvo) iInterfaceQueryLocalInterface3 : new zzbvo(strongBinder3);
                }
                zzaxo.zzc(parcel);
                zzu(zzbvoVar);
                parcel2.writeNoException();
                break;
            case 17:
                parcel.readString();
                zzaxo.zzc(parcel);
                parcel2.writeNoException();
                break;
            case 18:
                he0 he0VarQ4 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzr(he0VarQ4);
                parcel2.writeNoException();
                break;
            case 19:
                String string2 = parcel.readString();
                zzaxo.zzc(parcel);
                zzm(string2);
                parcel2.writeNoException();
                break;
            case 20:
                boolean zZzt = zzt();
                parcel2.writeNoException();
                int i4 = zzaxo.zza;
                parcel2.writeInt(zZzt ? 1 : 0);
                break;
            case zzbbc.zzt.zzm /* 21 */:
                u82 u82VarZzc = zzc();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, u82VarZzc);
                break;
        }
        return true;
    }
}
