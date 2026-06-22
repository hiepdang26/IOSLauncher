package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.qg0;
import defpackage.za2;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmo implements zzcly {
    private final Context zza;
    private final za2 zzb = hd2.B.g.zzi();

    public zzcmo(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcly
    public final void zza(Map map) {
        String str;
        if (map.isEmpty() || (str = (String) map.get("gad_idless")) == null) {
            return;
        }
        za2 za2Var = this.zzb;
        boolean z = Boolean.parseBoolean(str);
        ((ib2) za2Var).g(z);
        if (z) {
            qg0.U(this.zza);
        }
    }
}
