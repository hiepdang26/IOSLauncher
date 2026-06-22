package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzboi;

/* JADX INFO: loaded from: classes.dex */
public final class r82 extends zzaxm {
    public final q82 f(gy0 gy0Var, zzboi zzboiVar) {
        q82 o82Var;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, gy0Var);
        zzaxo.zzf(parcelZza, zzboiVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            o82Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            o82Var = iInterfaceQueryLocalInterface instanceof q82 ? (q82) iInterfaceQueryLocalInterface : new o82(strongBinder);
        }
        parcelZzdb.recycle();
        return o82Var;
    }
}
