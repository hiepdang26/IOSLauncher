package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public final class o52 extends zzaxm implements r52 {
    @Override // defpackage.r52
    public final void zze(he0 he0Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(2, parcelZza);
    }

    @Override // defpackage.r52
    public final boolean zzf(he0 he0Var, String str, String str2) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // defpackage.r52
    public final boolean zzg(he0 he0Var, c22 c22Var) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, he0Var);
        zzaxo.zzd(parcelZza, c22Var);
        Parcel parcelZzdb = zzdb(3, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
