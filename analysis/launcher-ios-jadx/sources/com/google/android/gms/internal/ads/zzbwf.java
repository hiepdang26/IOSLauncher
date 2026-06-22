package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;
import defpackage.i82;
import defpackage.j82;
import defpackage.m82;
import defpackage.qa2;
import defpackage.tb2;
import defpackage.u82;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbwf extends zzaxn implements zzbwg {
    public zzbwf() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzbwg zzq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return iInterfaceQueryLocalInterface instanceof zzbwg ? (zzbwg) iInterfaceQueryLocalInterface : new zzbwe(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbwn zzbwlVar = null;
        zzbwn zzbwlVar2 = null;
        j82 i82Var = null;
        zzbwo zzbwoVar = null;
        zzbwj zzbwhVar = null;
        switch (i) {
            case 1:
                tb2 tb2Var = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbwlVar = iInterfaceQueryLocalInterface instanceof zzbwn ? (zzbwn) iInterfaceQueryLocalInterface : new zzbwl(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzf(tb2Var, zzbwlVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    zzbwhVar = iInterfaceQueryLocalInterface2 instanceof zzbwj ? (zzbwj) iInterfaceQueryLocalInterface2 : new zzbwh(strongBinder2);
                }
                zzaxo.zzc(parcel);
                zzk(zzbwhVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzo = zzo();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzo ? 1 : 0);
                return true;
            case 4:
                String strZze = zze();
                parcel2.writeNoException();
                parcel2.writeString(strZze);
                return true;
            case 5:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzm(he0VarQ);
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    zzbwoVar = iInterfaceQueryLocalInterface3 instanceof zzbwo ? (zzbwo) iInterfaceQueryLocalInterface3 : new zzbwo(strongBinder3);
                }
                zzaxo.zzc(parcel);
                zzp(zzbwoVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbwu zzbwuVar = (zzbwu) zzaxo.zza(parcel, zzbwu.CREATOR);
                zzaxo.zzc(parcel);
                zzl(zzbwuVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
                    i82Var = iInterfaceQueryLocalInterface4 instanceof j82 ? (j82) iInterfaceQueryLocalInterface4 : new i82(strongBinder4, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
                }
                zzaxo.zzc(parcel);
                zzi(i82Var);
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle bundleZzb = zzb();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzb);
                return true;
            case 10:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                boolean zZzg = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzn(he0VarQ2, zZzg);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbwd zzbwdVarZzd = zzd();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbwdVarZzd);
                return true;
            case 12:
                u82 u82VarZzc = zzc();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, u82VarZzc);
                return true;
            case 13:
                m82 m82VarF = qa2.f(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzj(m82VarF);
                parcel2.writeNoException();
                return true;
            case 14:
                tb2 tb2Var2 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbwlVar2 = iInterfaceQueryLocalInterface5 instanceof zzbwn ? (zzbwn) iInterfaceQueryLocalInterface5 : new zzbwl(strongBinder5);
                }
                zzaxo.zzc(parcel);
                zzg(tb2Var2, zzbwlVar2);
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zZzg2 = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzh(zZzg2);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
