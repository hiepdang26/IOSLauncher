package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.j92;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbor extends zzaxn implements zzbos {
    public zzbor() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbos zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return iInterfaceQueryLocalInterface instanceof zzbos ? (zzbos) iInterfaceQueryLocalInterface : new zzboq(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int i3 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzg(i3);
                break;
            case 4:
                zzn();
                break;
            case 5:
                zzp();
                break;
            case 6:
                zzo();
                break;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    boolean z = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata") instanceof zzbow;
                }
                zzaxo.zzc(parcel);
                break;
            case 8:
                zzm();
                break;
            case 9:
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzaxo.zzc(parcel);
                zzq(string, string2);
                break;
            case 10:
                zzbfw.zzb(parcel.readStrongBinder());
                parcel.readString();
                zzaxo.zzc(parcel);
                break;
            case 11:
                zzv();
                break;
            case 12:
                parcel.readString();
                zzaxo.zzc(parcel);
                break;
            case 13:
                zzy();
                break;
            case 14:
                zzbvz zzbvzVar = (zzbvz) zzaxo.zza(parcel, zzbvz.CREATOR);
                zzaxo.zzc(parcel);
                zzs(zzbvzVar);
                break;
            case 15:
                zzw();
                break;
            case 16:
                zzbwd zzbwdVarZzb = zzbwc.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzt(zzbwdVarZzb);
                break;
            case 17:
                int i4 = parcel.readInt();
                zzaxo.zzc(parcel);
                zzj(i4);
                break;
            case 18:
                zzu();
                break;
            case 19:
                zzaxo.zzc(parcel);
                break;
            case 20:
                zzx();
                break;
            case zzbbc.zzt.zzm /* 21 */:
                String string3 = parcel.readString();
                zzaxo.zzc(parcel);
                zzl(string3);
                break;
            case 22:
                int i5 = parcel.readInt();
                String string4 = parcel.readString();
                zzaxo.zzc(parcel);
                zzi(i5, string4);
                break;
            case 23:
                j92 j92Var = (j92) zzaxo.zza(parcel, j92.CREATOR);
                zzaxo.zzc(parcel);
                zzh(j92Var);
                break;
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                j92 j92Var2 = (j92) zzaxo.zza(parcel, j92.CREATOR);
                zzaxo.zzc(parcel);
                zzk(j92Var2);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
