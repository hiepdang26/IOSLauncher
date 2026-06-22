package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;

/* JADX INFO: loaded from: classes.dex */
public final class i42 extends zzaxn implements v42 {
    public final b22 g;

    public i42(b22 b22Var) {
        super("com.google.android.gms.ads.internal.client.IAdClickListener");
        this.g = b22Var;
    }

    @Override // defpackage.v42
    public final void zzb() {
        this.g.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zzb();
        parcel2.writeNoException();
        return true;
    }
}
