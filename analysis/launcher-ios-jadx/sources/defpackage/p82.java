package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public abstract class p82 extends zzaxn implements q82 {
    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        String string = parcel.readString();
        he0 he0VarQ = gy0.q(parcel.readStrongBinder());
        he0 he0VarQ2 = gy0.q(parcel.readStrongBinder());
        zzaxo.zzc(parcel);
        zze(string, he0VarQ, he0VarQ2);
        parcel2.writeNoException();
        return true;
    }
}
