package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzexv implements zzevo {
    final zzgcu zza;

    public zzexv(zzbak zzbakVar, zzgcu zzgcuVar, Context context) {
        this.zza = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 45;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzexu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzexw(new JSONObject());
            }
        });
    }
}
