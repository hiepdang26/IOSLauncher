package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import defpackage.he0;
import defpackage.x82;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbft extends zzaxn implements zzbfu {
    public zzbft() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                he0 he0VarZzg = zzg();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzg);
                return true;
            case 3:
                String strZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeString(strZzk);
                return true;
            case 4:
                List listZzm = zzm();
                parcel2.writeNoException();
                parcel2.writeList(listZzm);
                return true;
            case 5:
                String strZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(strZzi);
                return true;
            case 6:
                zzbfd zzbfdVarZze = zze();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfdVarZze);
                return true;
            case 7:
                String strZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 8:
                String strZzh = zzh();
                parcel2.writeNoException();
                parcel2.writeString(strZzh);
                return true;
            case 9:
                Bundle bundleZzb = zzb();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzb);
                return true;
            case 10:
                zzn();
                parcel2.writeNoException();
                return true;
            case 11:
                x82 x82VarZzc = zzc();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, x82VarZzc);
                return true;
            case 12:
                Bundle bundle = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzo(bundle);
                parcel2.writeNoException();
                return true;
            case 13:
                Bundle bundle2 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                boolean zZzq = zzq(bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zZzq ? 1 : 0);
                return true;
            case 14:
                Bundle bundle3 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzp(bundle3);
                parcel2.writeNoException();
                return true;
            case 15:
                zzbew zzbewVarZzd = zzd();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbewVarZzd);
                return true;
            case 16:
                he0 he0VarZzf = zzf();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzf);
                return true;
            case 17:
                String strZzl = zzl();
                parcel2.writeNoException();
                parcel2.writeString(strZzl);
                return true;
            default:
                return false;
        }
    }
}
