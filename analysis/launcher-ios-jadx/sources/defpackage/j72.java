package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzblb;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzbol;
import com.google.android.gms.internal.ads.zzbom;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class j72 extends zzaxn implements l72 {
    public j72() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        h82 v72Var;
        switch (i) {
            case 1:
                zzk();
                parcel2.writeNoException();
                return true;
            case 2:
                float f = parcel.readFloat();
                zzaxo.zzc(parcel);
                zzq(f);
                parcel2.writeNoException();
                return true;
            case 3:
                String string = parcel.readString();
                zzaxo.zzc(parcel);
                zzr(string);
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zZzg = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzp(zZzg);
                parcel2.writeNoException();
                return true;
            case 5:
                he0 he0VarQ = gy0.q(parcel.readStrongBinder());
                String string2 = parcel.readString();
                zzaxo.zzc(parcel);
                zzn(he0VarQ, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                String string3 = parcel.readString();
                he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzl(string3, he0VarQ2);
                parcel2.writeNoException();
                return true;
            case 7:
                float fZze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(fZze);
                return true;
            case 8:
                boolean zZzv = zzv();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzv ? 1 : 0);
                return true;
            case 9:
                String strZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeString(strZzf);
                return true;
            case 10:
                String string4 = parcel.readString();
                zzaxo.zzc(parcel);
                zzh(string4);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbom zzbomVarZzf = zzbol.zzf(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzo(zzbomVarZzf);
                parcel2.writeNoException();
                return true;
            case 12:
                zzblc zzblcVarZzc = zzblb.zzc(parcel.readStrongBinder());
                zzaxo.zzc(parcel);
                zzs(zzblcVarZzc);
                parcel2.writeNoException();
                return true;
            case 13:
                List listZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzg);
                return true;
            case 14:
                ra2 ra2Var = (ra2) zzaxo.zza(parcel, ra2.CREATOR);
                zzaxo.zzc(parcel);
                zzu(ra2Var);
                parcel2.writeNoException();
                return true;
            case 15:
                zzi();
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    v72Var = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
                    v72Var = iInterfaceQueryLocalInterface instanceof h82 ? (h82) iInterfaceQueryLocalInterface : new v72(strongBinder, "com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
                }
                zzaxo.zzc(parcel);
                zzm(v72Var);
                parcel2.writeNoException();
                return true;
            case 17:
                boolean zZzg2 = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzj(zZzg2);
                parcel2.writeNoException();
                return true;
            case 18:
                String string5 = parcel.readString();
                zzaxo.zzc(parcel);
                zzt(string5);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
