package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import defpackage.do0;
import defpackage.hd2;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzest implements zzevo {
    private final Context zza;
    private final Intent zzb;

    public zzest(Context context, Intent intent) {
        this.zza = context;
        this.zzb = intent;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 60;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzlQ)).booleanValue()) {
            return zzgcj.zzh(new zzesu(null));
        }
        boolean z = false;
        try {
            if (this.zzb.resolveActivity(this.zza.getPackageManager()) != null) {
                z = true;
            }
        } catch (Exception e) {
            hd2.B.g.zzw(e, "HsdpMigrationSignal.isHsdpMigrationSupported");
        }
        return zzgcj.zzh(new zzesu(Boolean.valueOf(z)));
    }
}
