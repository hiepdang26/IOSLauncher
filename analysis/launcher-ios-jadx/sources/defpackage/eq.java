package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcgp;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzhfc;

/* JADX INFO: loaded from: classes.dex */
public final class eq implements zzhfc {
    public final zzcgp a;
    public final zzchc b;

    public eq(zzcgp zzcgpVar, zzchc zzchcVar) {
        this.a = zzcgpVar;
        this.b = zzchcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        return new dq((Context) this.a.zzb(), (or1) this.b.zzb());
    }
}
