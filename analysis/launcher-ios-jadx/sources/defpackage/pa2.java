package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;

/* JADX INFO: loaded from: classes.dex */
public final class pa2 extends zzaxn implements j82 {
    public final ly0 g;

    public pa2(ly0 ly0Var) {
        super("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
        this.g = ly0Var;
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zze();
        parcel2.writeNoException();
        return true;
    }

    @Override // defpackage.j82
    public final void zze() {
        ly0 ly0Var = this.g;
        if (ly0Var != null) {
            ly0Var.onAdMetadataChanged();
        }
    }
}
