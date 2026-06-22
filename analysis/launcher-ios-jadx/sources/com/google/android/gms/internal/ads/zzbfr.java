package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import defpackage.he0;
import defpackage.x82;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbfr extends zzaxn implements zzbfs {
    public zzbfr() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                he0 he0VarZzh = zzh();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzh);
                return true;
            case 3:
                String strZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeString(strZzk);
                return true;
            case 4:
                List listZzo = zzo();
                parcel2.writeNoException();
                parcel2.writeList(listZzo);
                return true;
            case 5:
                String strZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(strZzi);
                return true;
            case 6:
                zzbfd zzbfdVarZzf = zzf();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfdVarZzf);
                return true;
            case 7:
                String strZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 8:
                double dZzb = zzb();
                parcel2.writeNoException();
                parcel2.writeDouble(dZzb);
                return true;
            case 9:
                String strZzn = zzn();
                parcel2.writeNoException();
                parcel2.writeString(strZzn);
                return true;
            case 10:
                String strZzm = zzm();
                parcel2.writeNoException();
                parcel2.writeString(strZzm);
                return true;
            case 11:
                Bundle bundleZzc = zzc();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzc);
                return true;
            case 12:
                zzp();
                parcel2.writeNoException();
                return true;
            case 13:
                x82 x82VarZzd = zzd();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, x82VarZzd);
                return true;
            case 14:
                Bundle bundle = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzq(bundle);
                parcel2.writeNoException();
                return true;
            case 15:
                Bundle bundle2 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                boolean zZzs = zzs(bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zZzs ? 1 : 0);
                return true;
            case 16:
                Bundle bundle3 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzr(bundle3);
                parcel2.writeNoException();
                return true;
            case 17:
                zzbew zzbewVarZze = zze();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbewVarZze);
                return true;
            case 18:
                he0 he0VarZzg = zzg();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzg);
                return true;
            case 19:
                String strZzl = zzl();
                parcel2.writeNoException();
                parcel2.writeString(strZzl);
                return true;
            default:
                return false;
        }
    }
}
