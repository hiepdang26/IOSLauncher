package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbom;

/* JADX INFO: loaded from: classes.dex */
public final class w52 extends zzaxm {
    public w52(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder f(gy0 gy0Var, rc2 rc2Var, String str, zzbom zzbomVar, int i) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, gy0Var);
        zzaxo.zzd(parcelZza, rc2Var);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        parcelZza.writeInt(i);
        Parcel parcelZzdb = zzdb(2, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        parcelZzdb.recycle();
        return strongBinder;
    }
}
