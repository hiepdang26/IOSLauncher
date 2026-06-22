package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import defpackage.do0;
import defpackage.n42;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzeyn implements zzevo {
    final ScheduledExecutorService zza;

    public zzeyn(zzbsr zzbsrVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 49;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return zzgcj.zzm(zzgcj.zzo(zzgcj.zzh(new Bundle()), ((Long) n42.d.c.zza(zzbbw.zzdK)).longValue(), TimeUnit.MILLISECONDS, this.zza), new zzful() { // from class: com.google.android.gms.internal.ads.zzeym
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return new zzeyo((Bundle) obj);
            }
        }, zzbzo.zza);
    }
}
