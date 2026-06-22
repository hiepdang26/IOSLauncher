package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.do0;
import defpackage.n42;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class zzeoc implements zzevo {
    private final do0 zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;

    public zzeoc(do0 do0Var, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = do0Var;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 6;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        do0 do0VarZzn = zzgcj.zzn(this.zza, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzeny
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                final String str = (String) obj;
                return zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzenx
                    @Override // com.google.android.gms.internal.ads.zzevn
                    public final void zzj(Object obj2) {
                        ((Bundle) obj2).putString("ms", str);
                    }
                });
            }
        }, this.zzb);
        if (((Integer) n42.d.c.zza(zzbbw.zzlz)).intValue() > 0) {
            do0VarZzn = zzgcj.zzo(do0VarZzn, ((Integer) r2.c.zza(r1)).intValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgcj.zzf(do0VarZzn, Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzenz
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return ((Throwable) obj) instanceof TimeoutException ? zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzeoa
                    @Override // com.google.android.gms.internal.ads.zzevn
                    public final void zzj(Object obj2) {
                        ((Bundle) obj2).putString("ms", Integer.toString(17));
                    }
                }) : zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzeob
                    @Override // com.google.android.gms.internal.ads.zzevn
                    public final void zzj(Object obj2) {
                        ((Bundle) obj2).putString("ms", null);
                    }
                });
            }
        }, this.zzb);
    }
}
