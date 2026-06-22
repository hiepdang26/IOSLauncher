package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbga;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbgh;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbgn;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzblp;
import com.google.android.gms.internal.ads.zzblq;

/* JADX INFO: loaded from: classes.dex */
public abstract class p52 extends zzaxn implements q52 {
    public p52() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        a52 x42Var = null;
        y62 y62Var = null;
        switch (i) {
            case 1:
                k52 k52VarZze = zze();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, k52VarZze);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    x42Var = iInterfaceQueryLocalInterface instanceof a52 ? (a52) iInterfaceQueryLocalInterface : new x42(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzl(x42Var);
                parcel2.writeNoException();
                return true;
            case 3:
                zzbgb zzbgbVarZzb = zzbga.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzf(zzbgbVarZzb);
                parcel2.writeNoException();
                return true;
            case 4:
                zzbge zzbgeVarZzb = zzbgd.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzg(zzbgeVarZzb);
                parcel2.writeNoException();
                return true;
            case 5:
                String string = parcel.readString();
                zzbgk zzbgkVarZzb = zzbgj.zzb(parcel.readStrongBinder());
                zzbgh zzbghVarZzb = zzbgg.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzh(string, zzbgkVarZzb, zzbghVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbes zzbesVar = (zzbes) zzaxo.zza(parcel, zzbes.CREATOR);
                zzaxo.zzc(parcel);
                zzo(zzbesVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    y62Var = iInterfaceQueryLocalInterface2 instanceof y62 ? (y62) iInterfaceQueryLocalInterface2 : new y62(strongBinder2);
                }
                zzaxo.zzc(parcel);
                zzq(y62Var);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbgo zzbgoVarZzb = zzbgn.zzb(parcel.readStrongBinder());
                rc2 rc2Var = (rc2) zzaxo.zza(parcel, rc2.CREATOR);
                zzaxo.zzc(parcel);
                zzj(zzbgoVarZzb, rc2Var);
                parcel2.writeNoException();
                return true;
            case 9:
                a41 a41Var = (a41) zzaxo.zza(parcel, a41.CREATOR);
                zzaxo.zzc(parcel);
                zzp(a41Var);
                parcel2.writeNoException();
                return true;
            case 10:
                zzbgr zzbgrVarZzb = zzbgq.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzk(zzbgrVarZzb);
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zzblh zzblhVar = (zzblh) zzaxo.zza(parcel, zzblh.CREATOR);
                zzaxo.zzc(parcel);
                zzn(zzblhVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzblq zzblqVarZzb = zzblp.zzb(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzi(zzblqVarZzb);
                parcel2.writeNoException();
                return true;
            case 15:
                p2 p2Var = (p2) zzaxo.zza(parcel, p2.CREATOR);
                zzaxo.zzc(parcel);
                zzm(p2Var);
                parcel2.writeNoException();
                return true;
        }
    }
}
