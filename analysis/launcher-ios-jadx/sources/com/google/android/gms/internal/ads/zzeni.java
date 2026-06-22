package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import defpackage.n42;
import defpackage.np1;

/* JADX INFO: loaded from: classes.dex */
public final class zzeni implements zzevo {
    private final Context zza;

    public zzeni(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzcD)).booleanValue()) {
            return zzgcj.zzh(new zzenj(np1.d(this.zza, "com.google.android.gms.permission.AD_ID") == 0));
        }
        return zzgcj.zzh(null);
    }
}
