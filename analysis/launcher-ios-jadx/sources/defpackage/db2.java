package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzblr;

/* JADX INFO: loaded from: classes.dex */
public final class db2 extends zzaxn implements f52 {
    public final k2 g;
    public final zzblr h;

    public db2(k2 k2Var, zzblr zzblrVar) {
        super("com.google.android.gms.ads.internal.client.IAdLoadCallback");
        this.g = k2Var;
        this.h = zzblrVar;
    }

    @Override // defpackage.f52
    public final void zzb(j92 j92Var) {
        k2 k2Var = this.g;
        if (k2Var != null) {
            k2Var.onAdFailedToLoad(j92Var.b());
        }
    }

    @Override // defpackage.f52
    public final void zzc() {
        zzblr zzblrVar;
        k2 k2Var = this.g;
        if (k2Var == null || (zzblrVar = this.h) == null) {
            return;
        }
        k2Var.onAdLoaded(zzblrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzc();
        } else {
            if (i != 2) {
                return false;
            }
            j92 j92Var = (j92) zzaxo.zza(parcel, j92.CREATOR);
            zzaxo.zzc(parcel);
            zzb(j92Var);
        }
        parcel2.writeNoException();
        return true;
    }
}
