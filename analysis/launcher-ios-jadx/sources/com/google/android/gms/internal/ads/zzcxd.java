package com.google.android.gms.internal.ads;

import defpackage.j92;
import defpackage.k92;
import defpackage.n42;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxd extends zzdch implements zzcwu {
    private final ScheduledExecutorService zzb;
    private ScheduledFuture zzc;
    private boolean zzd;

    public zzcxd(zzcxc zzcxcVar, Set set, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.zzd = false;
        this.zzb = scheduledExecutorService;
        zzo(zzcxcVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zza(final j92 j92Var) {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcwv
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzcwu) obj).zza(j92Var);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzb() {
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcww
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzcwu) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzc(final zzdgw zzdgwVar) {
        if (this.zzd) {
            return;
        }
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        zzq(new zzdcg() { // from class: com.google.android.gms.internal.ads.zzcwy
            @Override // com.google.android.gms.internal.ads.zzdcg
            public final void zza(Object obj) {
                ((zzcwu) obj).zzc(zzdgwVar);
            }
        });
    }

    public final /* synthetic */ void zzd() {
        synchronized (this) {
            k92.e("Timeout waiting for show call succeed to be called.");
            zzc(new zzdgw("Timeout for show call succeed."));
            this.zzd = true;
        }
    }

    public final synchronized void zze() {
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public final void zzf() {
        this.zzc = this.zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcwx
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        }, ((Integer) n42.d.c.zza(zzbbw.zzjO)).intValue(), TimeUnit.MILLISECONDS);
    }
}
