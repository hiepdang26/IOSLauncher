package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.hd2;
import defpackage.n42;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzetw implements zzevo {
    private final zzevo zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzetw(zzevo zzevoVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzevoVar;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        do0 do0VarZzb = this.zza.zzb();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) n42.d.c.zza(zzbbw.zzbX)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j = this.zzb;
        if (j > 0) {
            do0VarZzb = zzgcj.zzo(do0VarZzb, j, timeUnit, this.zzc);
        }
        return zzgcj.zzf(do0VarZzb, Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzetv
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzc((Throwable) obj);
            }
        }, zzbzo.zzf);
    }

    public final do0 zzc(Throwable th) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzbW)).booleanValue()) {
            zzevo zzevoVar = this.zza;
            hd2.B.g.zzw(th, "OptionalSignalTimeout:" + zzevoVar.zza());
        }
        return zzgcj.zzh(null);
    }
}
