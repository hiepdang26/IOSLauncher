package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzbom;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h72 extends zzaxm implements l72 {
    public h72(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // defpackage.l72
    public final float zze() {
        Parcel parcelZzdb = zzdb(7, zza());
        float f = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f;
    }

    @Override // defpackage.l72
    public final List zzg() {
        Parcel parcelZzdb = zzdb(13, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzdb.createTypedArrayList(zzbkv.CREATOR);
        parcelZzdb.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // defpackage.l72
    public final void zzk() {
        zzdc(1, zza());
    }

    @Override // defpackage.l72
    public final void zzl(String str, he0 he0Var) {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        zzaxo.zzf(parcelZza, he0Var);
        zzdc(6, parcelZza);
    }

    @Override // defpackage.l72
    public final void zzo(zzbom zzbomVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbomVar);
        zzdc(11, parcelZza);
    }

    @Override // defpackage.l72
    public final void zzs(zzblc zzblcVar) {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzblcVar);
        zzdc(12, parcelZza);
    }

    @Override // defpackage.l72
    public final void zzt(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(18, parcelZza);
    }

    @Override // defpackage.l72
    public final void zzu(ra2 ra2Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, ra2Var);
        zzdc(14, parcelZza);
    }

    @Override // defpackage.l72
    public final boolean zzv() {
        Parcel parcelZzdb = zzdb(8, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
