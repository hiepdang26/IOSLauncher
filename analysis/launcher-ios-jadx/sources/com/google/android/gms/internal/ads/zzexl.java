package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.f7;
import defpackage.n42;
import defpackage.od2;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzexl implements zzevo {
    private final zzbze zza;
    private final ScheduledExecutorService zzb;
    private final zzgcu zzc;

    public zzexl(String str, zzazy zzazyVar, zzbze zzbzeVar, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcuVar) {
        this.zza = zzbzeVar;
        this.zzb = scheduledExecutorService;
        this.zzc = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 43;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        zzbbn zzbbnVar = zzbbw.zzcw;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            if (((Boolean) n42Var.c.zza(zzbbw.zzcB)).booleanValue()) {
                od2 od2Var = new od2();
                od2Var.h(null);
                do0 do0VarZzn = zzgcj.zzn(zzfsf.zza(od2Var, null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzexj
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final do0 zza(Object obj) {
                        f7 f7Var = (f7) obj;
                        return f7Var == null ? zzgcj.zzh(new zzexm(null, -1)) : zzgcj.zzh(new zzexm(f7Var.a, f7Var.b));
                    }
                }, this.zzc);
                if (((Boolean) zzbdf.zza.zze()).booleanValue()) {
                    do0VarZzn = zzgcj.zzo(do0VarZzn, ((Long) zzbdf.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
                }
                return zzgcj.zze(do0VarZzn, Exception.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzexk
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj) {
                        return this.zza.zzc((Exception) obj);
                    }
                }, this.zzc);
            }
        }
        return zzgcj.zzh(new zzexm(null, -1));
    }

    public final /* synthetic */ zzexm zzc(Exception exc) {
        this.zza.zzw(exc, "AppSetIdInfoGmscoreSignal");
        return new zzexm(null, -1);
    }
}
