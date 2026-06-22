package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import defpackage.n42;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzexr implements zzevo {
    private final zzbze zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;

    public zzexr(zzbyv zzbyvVar, int i, Context context, zzbze zzbzeVar, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zza = zzbzeVar;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 44;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return zzgcj.zze((zzgca) zzgcj.zzo(zzgcj.zzm(zzgca.zzu(zzgcj.zzk(new zzgbp(this) { // from class: com.google.android.gms.internal.ads.zzexo
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final do0 zza() {
                return zzgcj.zzh(null);
            }
        }, this.zzc)), new zzful() { // from class: com.google.android.gms.internal.ads.zzexp
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                String str = (String) obj;
                if (str == null) {
                    return null;
                }
                return new zzexs(str);
            }
        }, this.zzc), ((Long) n42.d.c.zza(zzbbw.zzaM)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Exception.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzexq
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                this.zza.zzc((Exception) obj);
                return null;
            }
        }, zzgda.zzb());
    }

    public final /* synthetic */ zzexs zzc(Exception exc) {
        this.zza.zzw(exc, "AttestationTokenSignal");
        return null;
    }
}
