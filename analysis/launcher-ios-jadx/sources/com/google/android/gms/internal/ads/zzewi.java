package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import defpackage.hd2;
import defpackage.n42;
import defpackage.or1;
import defpackage.za2;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class zzewi implements zzevo {
    private final za2 zza;
    private final Context zzb;
    private final zzgcu zzc;
    private final ScheduledExecutorService zzd;
    private final zzeer zze;
    private final zzffg zzf;
    private final or1 zzg;

    public zzewi(za2 za2Var, Context context, zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, zzeer zzeerVar, zzffg zzffgVar, or1 or1Var) {
        this.zza = za2Var;
        this.zzb = context;
        this.zzc = zzgcuVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzeerVar;
        this.zzf = zzffgVar;
        this.zzg = or1Var;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 56;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c2, code lost:
    
        if (java.util.Arrays.asList(r0.split(",")).contains(r9.zzb.getPackageName()) == false) goto L48;
     */
    @Override // com.google.android.gms.internal.ads.zzevo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.do0 zzb() {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewi.zzb():do0");
    }

    public final /* synthetic */ do0 zzc(final Throwable th) {
        this.zzc.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzewf
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) n42.d.c.zza(zzbbw.zzjA)).booleanValue();
                Throwable th2 = th;
                if (zBooleanValue) {
                    hd2.B.g.zzx(th2, "TopicsSignalUnsampled.fetchTopicsSignal");
                } else {
                    hd2.B.g.zzv(th2, "TopicsSignal.fetchTopicsSignal");
                }
            }
        });
        return zzgcj.zzh(th instanceof SecurityException ? new zzewk("", 2, null) : th instanceof IllegalStateException ? new zzewk("", 3, null) : th instanceof IllegalArgumentException ? new zzewk("", 4, null) : th instanceof TimeoutException ? new zzewk("", 5, null) : new zzewk("", 0, null));
    }
}
