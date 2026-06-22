package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public abstract class w72 extends zzaxn implements h82 {
    public w72() {
        super("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        j92 j92Var = (j92) zzaxo.zza(parcel, j92.CREATOR);
        zzaxo.zzc(parcel);
        zze(j92Var);
        parcel2.writeNoException();
        return true;
    }
}
