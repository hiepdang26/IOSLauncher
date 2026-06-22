package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import defpackage.e7;
import defpackage.f7;
import defpackage.n42;
import defpackage.pm1;
import defpackage.tu;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzeph implements zzevo {
    final zzbze zza;
    e7 zzb;
    private final ScheduledExecutorService zzc;
    private final zzgcu zzd;
    private final Context zze;

    public zzeph(Context context, zzbze zzbzeVar, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcuVar) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzcA)).booleanValue()) {
            this.zzb = new tu(context);
        }
        this.zze = context;
        this.zza = zzbzeVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 11;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        zzbbn zzbbnVar = zzbbw.zzcw;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            zzbbn zzbbnVar2 = zzbbw.zzcB;
            zzbbu zzbbuVar = n42Var.c;
            if (!((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue()) {
                if (!((Boolean) zzbbuVar.zza(zzbbw.zzcx)).booleanValue()) {
                    return zzgcj.zzm(zzfsf.zza(this.zzb.a(), null), new zzful() { // from class: com.google.android.gms.internal.ads.zzepe
                        @Override // com.google.android.gms.internal.ads.zzful
                        public final Object apply(Object obj) {
                            f7 f7Var = (f7) obj;
                            return new zzepi(f7Var.a, f7Var.b);
                        }
                    }, zzbzo.zzf);
                }
                pm1 pm1VarZza = ((Boolean) zzbbuVar.zza(zzbbw.zzcA)).booleanValue() ? zzfgl.zza(this.zze) : this.zzb.a();
                if (pm1VarZza == null) {
                    return zzgcj.zzh(new zzepi(null, -1));
                }
                do0 do0VarZzn = zzgcj.zzn(zzfsf.zza(pm1VarZza, null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzepf
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final do0 zza(Object obj) {
                        f7 f7Var = (f7) obj;
                        return f7Var == null ? zzgcj.zzh(new zzepi(null, -1)) : zzgcj.zzh(new zzepi(f7Var.a, f7Var.b));
                    }
                }, zzbzo.zzf);
                if (((Boolean) zzbbuVar.zza(zzbbw.zzcy)).booleanValue()) {
                    do0VarZzn = zzgcj.zzo(do0VarZzn, ((Long) zzbbuVar.zza(zzbbw.zzcz)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgcj.zze(do0VarZzn, Exception.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzepg
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj) {
                        this.zza.zza.zzw((Exception) obj, "AppSetIdInfoSignal");
                        return new zzepi(null, -1);
                    }
                }, this.zzd);
            }
        }
        return zzgcj.zzh(new zzepi(null, -1));
    }
}
