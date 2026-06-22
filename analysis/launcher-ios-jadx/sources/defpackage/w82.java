package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public abstract class w82 extends zzaxn implements x82 {
    public w82() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static x82 zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return iInterfaceQueryLocalInterface instanceof x82 ? (x82) iInterfaceQueryLocalInterface : new v82(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        a92 y82Var;
        switch (i) {
            case 1:
                zzl();
                parcel2.writeNoException();
                return true;
            case 2:
                zzk();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzg = zzaxo.zzg(parcel);
                zzaxo.zzc(parcel);
                zzj(zZzg);
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zZzq = zzq();
                parcel2.writeNoException();
                int i3 = zzaxo.zza;
                parcel2.writeInt(zZzq ? 1 : 0);
                return true;
            case 5:
                int iZzh = zzh();
                parcel2.writeNoException();
                parcel2.writeInt(iZzh);
                return true;
            case 6:
                float fZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzg);
                return true;
            case 7:
                float fZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzf);
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    y82Var = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    y82Var = iInterfaceQueryLocalInterface instanceof a92 ? (a92) iInterfaceQueryLocalInterface : new y82(strongBinder);
                }
                zzaxo.zzc(parcel);
                zzm(y82Var);
                parcel2.writeNoException();
                return true;
            case 9:
                float fZze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(fZze);
                return true;
            case 10:
                boolean zZzp = zzp();
                parcel2.writeNoException();
                int i4 = zzaxo.zza;
                parcel2.writeInt(zZzp ? 1 : 0);
                return true;
            case 11:
                a92 a92VarZzi = zzi();
                parcel2.writeNoException();
                zzaxo.zzf(parcel2, a92VarZzi);
                return true;
            case 12:
                boolean zZzo = zzo();
                parcel2.writeNoException();
                int i5 = zzaxo.zza;
                parcel2.writeInt(zZzo ? 1 : 0);
                return true;
            case 13:
                zzn();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
