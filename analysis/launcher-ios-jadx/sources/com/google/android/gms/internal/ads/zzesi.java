package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzesi implements zzevo {
    private final Context zza;
    private final zzgcu zzb;

    public zzesi(zzgcu zzgcuVar, Context context) {
        this.zzb = zzgcuVar;
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 57;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final zzesj zzc() {
        cd2 cd2Var = hd2.B.c;
        Object systemService = this.zza.getSystemService("display");
        return new zzesj(systemService instanceof DisplayManager ? Integer.valueOf(((DisplayManager) systemService).getDisplays().length) : null);
    }
}
