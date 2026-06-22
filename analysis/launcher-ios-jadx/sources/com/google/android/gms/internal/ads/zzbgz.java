package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.profileinstaller.ProfileVersion;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.he0;
import defpackage.m82;
import defpackage.o72;
import defpackage.p72;
import defpackage.qa2;
import defpackage.s72;
import defpackage.u82;
import defpackage.v92;
import defpackage.x82;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbgz extends zzaxn implements zzbha {
    public zzbgz() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbgx zzbgvVar = null;
        p72 o72Var = null;
        switch (i) {
            case 2:
                String strZzq = zzq();
                parcel2.writeNoException();
                parcel2.writeString(strZzq);
                return true;
            case 3:
                List listZzu = zzu();
                parcel2.writeNoException();
                parcel2.writeList(listZzu);
                return true;
            case 4:
                String strZzo = zzo();
                parcel2.writeNoException();
                parcel2.writeString(strZzo);
                return true;
            case 5:
                zzbfd zzbfdVarZzk = zzk();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfdVarZzk);
                return true;
            case 6:
                String strZzp = zzp();
                parcel2.writeNoException();
                parcel2.writeString(strZzp);
                return true;
            case 7:
                String strZzn = zzn();
                parcel2.writeNoException();
                parcel2.writeString(strZzn);
                return true;
            case 8:
                double dZze = zze();
                parcel2.writeNoException();
                parcel2.writeDouble(dZze);
                return true;
            case 9:
                String strZzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(strZzt);
                return true;
            case 10:
                String strZzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(strZzs);
                return true;
            case 11:
                x82 x82VarZzh = zzh();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, x82VarZzh);
                return true;
            case 12:
                String strZzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(strZzr);
                return true;
            case 13:
                zzx();
                parcel2.writeNoException();
                return true;
            case 14:
                zzbew zzbewVarZzi = zzi();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbewVarZzi);
                return true;
            case 15:
                Bundle bundle = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzz(bundle);
                parcel2.writeNoException();
                return true;
            case 16:
                Bundle bundle2 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                boolean zZzI = zzI(bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zZzI ? 1 : 0);
                return true;
            case 17:
                Bundle bundle3 = (Bundle) zzaxo.zza(parcel, Bundle.CREATOR);
                zzaxo.zzc(parcel);
                zzB(bundle3);
                parcel2.writeNoException();
                return true;
            case 18:
                he0 he0VarZzm = zzm();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzm);
                return true;
            case 19:
                he0 he0VarZzl = zzl();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, he0VarZzl);
                return true;
            case 20:
                Bundle bundleZzf = zzf();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZzf);
                return true;
            case zzbbc.zzt.zzm /* 21 */:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    zzbgvVar = iInterfaceQueryLocalInterface instanceof zzbgx ? (zzbgx) iInterfaceQueryLocalInterface : new zzbgv(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzF(zzbgvVar);
                parcel2.writeNoException();
                return true;
            case 22:
                zzw();
                parcel2.writeNoException();
                return true;
            case 23:
                List listZzv = zzv();
                parcel2.writeNoException();
                parcel2.writeList(listZzv);
                return true;
            case ProfileVersion.MIN_SUPPORTED_SDK /* 24 */:
                boolean zZzH = zzH();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzH ? 1 : 0);
                return true;
            case 25:
                s72 s72VarF = v92.f(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzy(s72VarF);
                parcel2.writeNoException();
                return true;
            case 26:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
                    o72Var = iInterfaceQueryLocalInterface2 instanceof p72 ? (p72) iInterfaceQueryLocalInterface2 : new o72(strongBinder2, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
                }
                zzaxo.zzc(parcel);
                zzD(o72Var);
                parcel2.writeNoException();
                return true;
            case 27:
                zzC();
                parcel2.writeNoException();
                return true;
            case 28:
                zzA();
                parcel2.writeNoException();
                return true;
            case 29:
                zzbfa zzbfaVarZzj = zzj();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, zzbfaVarZzj);
                return true;
            case 30:
                boolean zZzG = zzG();
                parcel2.writeNoException();
                int i4 = zzaxo.zza;
                parcel2.writeInt(zZzG ? 1 : 0);
                return true;
            case 31:
                u82 u82VarZzg = zzg();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, u82VarZzg);
                return true;
            case 32:
                m82 m82VarF = qa2.f(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzE(m82VarF);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
