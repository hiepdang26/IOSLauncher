package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.do0;
import defpackage.hd2;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzetb implements zzevo {
    private final zzgcu zza;

    public zzetb(zzgcu zzgcuVar) {
        this.zza = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 24;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeta
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Bundle bundle = new Bundle();
                Runtime runtime = Runtime.getRuntime();
                bundle.putLong("runtime_free", runtime.freeMemory());
                bundle.putLong("runtime_max", runtime.maxMemory());
                bundle.putLong("runtime_total", runtime.totalMemory());
                bundle.putInt("web_view_count", hd2.B.g.zzb());
                return new zzetc(bundle);
            }
        });
    }
}
