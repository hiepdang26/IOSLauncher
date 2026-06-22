package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbol;
import com.google.android.gms.internal.ads.zzbom;

/* JADX INFO: loaded from: classes.dex */
public final class c72 extends zzaxm implements g72 {
    @Override // defpackage.g72
    public final zzbom getAdapterCreator() {
        Parcel parcelZzdb = zzdb(2, zza());
        zzbom zzbomVarZzf = zzbol.zzf(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbomVarZzf;
    }

    @Override // defpackage.g72
    public final w92 getLiteSdkVersion() {
        Parcel parcelZzdb = zzdb(1, zza());
        w92 w92Var = (w92) zzaxo.zza(parcelZzdb, w92.CREATOR);
        parcelZzdb.recycle();
        return w92Var;
    }
}
