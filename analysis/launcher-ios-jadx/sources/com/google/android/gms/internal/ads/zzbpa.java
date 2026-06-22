package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.gy0;
import defpackage.he0;
import defpackage.x82;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbpa extends zzaxn implements zzbpb {
    public zzbpa() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public static zzbpb zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        return iInterfaceQueryLocalInterface instanceof zzbpb ? (zzbpb) iInterfaceQueryLocalInterface : new zzboz(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                String strZzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(strZzs);
                return true;
            case 3:
                List listZzv = zzv();
                parcel2.writeNoException();
                parcel2.writeList(listZzv);
                return true;
            case 4:
                String strZzq = zzq();
                parcel2.writeNoException();
                parcel2.writeString(strZzq);
                return true;
            case 5:
                zzbfd zzbfdVarZzl = zzl();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfdVarZzl);
                return true;
            case 6:
                String strZzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(strZzr);
                return true;
            case 7:
                String strZzp = zzp();
                parcel2.writeNoException();
                parcel2.writeString(strZzp);
                return true;
            case 8:
                double dZze = zze();
                parcel2.writeNoException();
                parcel2.writeDouble(dZze);
                return true;
            case 9:
                String strZzu = zzu();
                parcel2.writeNoException();
                parcel2.writeString(strZzu);
                return true;
            case 10:
                String strZzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(strZzt);
                return true;
            case 11:
                x82 x82VarZzj = zzj();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, x82VarZzj);
                return true;
            case 12:
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 13:
                he0 he0VarZzm = zzm();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzm);
                return true;
            case 14:
                he0 he0VarZzn = zzn();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzn);
                return true;
            case 15:
                he0 he0VarZzo = zzo();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzo);
                return true;
            case 16:
                Bundle bundleZzi = zzi();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzi);
                return true;
            case 17:
                boolean zZzB = zzB();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzB ? 1 : 0);
                return true;
            case 18:
                boolean zZzA = zzA();
                parcel2.writeNoException();
                int i4 = zzaxo.zza;
                parcel2.writeInt(zZzA ? 1 : 0);
                return true;
            case 19:
                zzx();
                parcel2.writeNoException();
                return true;
            case 20:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzw(he0VarQ);
                parcel2.writeNoException();
                return true;
            case zzbbc.zzt.zzm /* 21 */:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
                he0 he0VarQ4 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzy(he0VarQ2, he0VarQ3, he0VarQ4);
                parcel2.writeNoException();
                return true;
            case 22:
                he0 he0VarQ5 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzz(he0VarQ5);
                parcel2.writeNoException();
                return true;
            case 23:
                float fZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzf);
                return true;
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                float fZzh = zzh();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzh);
                return true;
            case 25:
                float fZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzg);
                return true;
            default:
                return false;
        }
    }
}
