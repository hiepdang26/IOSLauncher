package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import defpackage.gy0;
import defpackage.he0;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcge extends zzaxn implements zzcgf {
    public zzcge() {
        super("com.google.android.gms.ads.measurement.IAppMeasurementProxy");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                Bundle bundle = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzp(bundle);
                parcel2.writeNoException();
                return true;
            case 2:
                Bundle bundle2 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                Bundle bundleZzd = zzd(bundle2);
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzd);
                return true;
            case 3:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle3 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzo(string, string2, bundle3);
                parcel2.writeNoException();
                return true;
            case 4:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzt(string3, string4, he0VarQ);
                parcel2.writeNoException();
                return true;
            case 5:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                boolean zZzg = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                Map mapZzk = zzk(string5, string6, zZzg);
                parcel2.writeNoException();
                parcel2.writeMap(mapZzk);
                return true;
            case 6:
                String string7 = parcel.readString();
                zzaxo.zzc(parcel);
                int iZzb = zzb(string7);
                parcel2.writeNoException();
                parcel2.writeInt(iZzb);
                return true;
            case 7:
                Bundle bundle4 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzq(bundle4);
                parcel2.writeNoException();
                return true;
            case 8:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                Bundle bundle5 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzm(string8, string9, bundle5);
                parcel2.writeNoException();
                return true;
            case 9:
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                zzaxo.zzc(parcel);
                List listZzj = zzj(string10, string11);
                parcel2.writeNoException();
                parcel2.writeList(listZzj);
                return true;
            case 10:
                String strZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeString(strZzf);
                return true;
            case 11:
                String strZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(strZzi);
                return true;
            case 12:
                long jZzc = zzc();
                parcel2.writeNoException();
                parcel2.writeLong(jZzc);
                return true;
            case 13:
                String string12 = parcel.readString();
                zzaxo.zzc(parcel);
                zzl(string12);
                parcel2.writeNoException();
                return true;
            case 14:
                String string13 = parcel.readString();
                zzaxo.zzc(parcel);
                zzn(string13);
                parcel2.writeNoException();
                return true;
            case 15:
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                zzaxo.zzc(parcel);
                zzs(he0VarQ2, string14, string15);
                parcel2.writeNoException();
                return true;
            case 16:
                String strZzh = zzh();
                parcel2.writeNoException();
                parcel2.writeString(strZzh);
                return true;
            case 17:
                String strZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeString(strZzg);
                return true;
            case 18:
                String strZze = zze();
                parcel2.writeNoException();
                parcel2.writeString(strZze);
                return true;
            case 19:
                Bundle bundle6 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzr(bundle6);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
