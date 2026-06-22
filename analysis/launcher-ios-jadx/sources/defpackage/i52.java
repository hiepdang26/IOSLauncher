package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public abstract class i52 extends zzaxn implements k52 {
    public i52() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            tb2 tb2Var = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
            zzaxo.zzc(parcel);
            zzg(tb2Var);
            parcel2.writeNoException();
            return true;
        }
        if (i == 2) {
            String strZze = zze();
            parcel2.writeNoException();
            parcel2.writeString(strZze);
            return true;
        }
        if (i == 3) {
            boolean zZzi = zzi();
            parcel2.writeNoException();
            int i3 = zzaxo.zza;
            parcel2.writeInt(zZzi ? 1 : 0);
            return true;
        }
        if (i == 4) {
            String strZzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(strZzf);
            return true;
        }
        if (i != 5) {
            return false;
        }
        tb2 tb2Var2 = (tb2) zzaxo.zza(parcel, tb2.CREATOR);
        int i4 = parcel.readInt();
        zzaxo.zzc(parcel);
        zzh(tb2Var2, i4);
        parcel2.writeNoException();
        return true;
    }
}
