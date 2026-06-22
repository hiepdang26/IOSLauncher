package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;
import defpackage.x82;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbfw extends zzaxn implements zzbfx {
    public zzbfw() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzbfx zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        return iInterfaceQueryLocalInterface instanceof zzbfx ? (zzbfx) iInterfaceQueryLocalInterface : new zzbfv(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                String string = parcel.readString();
                zzaxo.zzc(parcel);
                String strZzj = zzj(string);
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 2:
                String string2 = parcel.readString();
                zzaxo.zzc(parcel);
                zzbfd zzbfdVarZzg = zzg(string2);
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfdVarZzg);
                return true;
            case 3:
                List<String> listZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeStringList(listZzk);
                return true;
            case 4:
                String strZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(strZzi);
                return true;
            case 5:
                String string3 = parcel.readString();
                zzaxo.zzc(parcel);
                zzn(string3);
                parcel2.writeNoException();
                return true;
            case 6:
                zzo();
                parcel2.writeNoException();
                return true;
            case 7:
                x82 x82VarZze = zze();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, x82VarZze);
                return true;
            case 8:
                zzl();
                parcel2.writeNoException();
                return true;
            case 9:
                he0 he0VarZzh = zzh();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzh);
                return true;
            case 10:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                boolean zZzs = zzs(he0VarQ);
                parcel2.writeNoException();
                parcel2.writeInt(zZzs ? 1 : 0);
                return true;
            case 11:
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, null);
                return true;
            case 12:
                boolean zZzq = zzq();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzq ? 1 : 0);
                return true;
            case 13:
                boolean zZzt = zzt();
                parcel2.writeNoException();
                int i4 = zzaxo.zza;
                parcel2.writeInt(zZzt ? 1 : 0);
                return true;
            case 14:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzp(he0VarQ2);
                parcel2.writeNoException();
                return true;
            case 15:
                zzm();
                parcel2.writeNoException();
                return true;
            case 16:
                zzbfa zzbfaVarZzf = zzf();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfaVarZzf);
                return true;
            case 17:
                he0 he0VarQ3 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                boolean zZzr = zzr(he0VarQ3);
                parcel2.writeNoException();
                parcel2.writeInt(zZzr ? 1 : 0);
                return true;
            default:
                return false;
        }
    }
}
