package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public final class v82 extends zzaxm implements x82 {
    public v82(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // defpackage.x82
    public final float zze() {
        throw null;
    }

    @Override // defpackage.x82
    public final float zzf() {
        throw null;
    }

    @Override // defpackage.x82
    public final float zzg() {
        throw null;
    }

    @Override // defpackage.x82
    public final a92 zzi() {
        a92 y82Var;
        Parcel parcelZzdb = zzdb(11, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            y82Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            y82Var = iInterfaceQueryLocalInterface instanceof a92 ? (a92) iInterfaceQueryLocalInterface : new y82(strongBinder);
        }
        parcelZzdb.recycle();
        return y82Var;
    }

    @Override // defpackage.x82
    public final void zzm(a92 a92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, a92Var);
        zzdc(8, parcelZza);
    }
}
