package com.google.android.gms.internal.ads;

import android.os.Build;
import defpackage.b72;
import defpackage.do0;
import defpackage.n42;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzezi implements zzevo {
    private final zzgcu zza;

    public zzezi(zzgcu zzgcuVar) {
        this.zza = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 51;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzezh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                HashMap map = new HashMap();
                zzbbn zzbbnVar = zzbbw.zzD;
                n42 n42Var = n42.d;
                String str = (String) n42Var.c.zza(zzbbnVar);
                if (str != null && !str.isEmpty()) {
                    if (Build.VERSION.SDK_INT >= ((Integer) n42Var.c.zza(zzbbw.zzE)).intValue()) {
                        for (String str2 : str.split(",", -1)) {
                            map.put(str2, b72.a(str2));
                        }
                    }
                }
                return new zzezj(map);
            }
        });
    }
}
