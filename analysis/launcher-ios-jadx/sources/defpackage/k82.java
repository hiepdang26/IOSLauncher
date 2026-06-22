package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public final class k82 extends zzaxm implements m82 {
    public k82(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    @Override // defpackage.m82
    public final void b(xc2 xc2Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, xc2Var);
        zzdc(1, parcelZza);
    }

    @Override // defpackage.m82
    public final boolean zzf() {
        Parcel parcelZzdb = zzdb(2, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
