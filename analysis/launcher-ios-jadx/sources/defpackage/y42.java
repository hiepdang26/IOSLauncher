package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public abstract class y42 extends zzaxn implements a52 {
    public y42() {
        super("com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzd();
                break;
            case 2:
                int i3 = parcel.readInt();
                zzaxo.zzc(parcel);
                zze(i3);
                break;
            case 3:
                break;
            case 4:
                zzi();
                break;
            case 5:
                zzj();
                break;
            case 6:
                zzc();
                break;
            case 7:
                zzg();
                break;
            case 8:
                j92 j92Var = (j92) zzaxo.zza(parcel, j92.CREATOR);
                zzaxo.zzc(parcel);
                zzf(j92Var);
                break;
            case 9:
                zzk();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
