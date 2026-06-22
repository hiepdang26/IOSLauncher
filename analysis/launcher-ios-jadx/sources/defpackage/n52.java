package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbgh;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbgr;

/* JADX INFO: loaded from: classes.dex */
public final class n52 extends zzaxm implements q52 {
    public n52(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // defpackage.q52
    public final k52 zze() {
        k52 h52Var;
        Parcel parcelZzdb = zzdb(1, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            h52Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            h52Var = iInterfaceQueryLocalInterface instanceof k52 ? (k52) iInterfaceQueryLocalInterface : new h52(strongBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
        }
        parcelZzdb.recycle();
        return h52Var;
    }

    @Override // defpackage.q52
    public final void zzh(String str, zzbgk zzbgkVar, zzbgh zzbghVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbgkVar);
        zzaxo.zzf(parcelZza, zzbghVar);
        zzdc(5, parcelZza);
    }

    @Override // defpackage.q52
    public final void zzk(zzbgr zzbgrVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbgrVar);
        zzdc(10, parcelZza);
    }

    @Override // defpackage.q52
    public final void zzl(a52 a52Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, a52Var);
        zzdc(2, parcelZza);
    }

    @Override // defpackage.q52
    public final void zzo(zzbes zzbesVar) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbesVar);
        zzdc(6, parcelZza);
    }
}
