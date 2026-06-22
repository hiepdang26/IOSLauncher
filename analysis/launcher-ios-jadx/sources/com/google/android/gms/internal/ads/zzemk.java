package com.google.android.gms.internal.ads;

import android.util.Pair;
import defpackage.a52;
import defpackage.a72;
import defpackage.b22;
import defpackage.f52;
import defpackage.j92;
import defpackage.k92;
import defpackage.m82;
import defpackage.n42;
import defpackage.u6;
import defpackage.u62;
import defpackage.xc2;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzemk implements u6, zzczo, zzcye, zzcwt, zzcxk, b22, zzcwq, zzczb, zzcxg, zzdeq {
    final zzdsk zza;
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicBoolean zzh = new AtomicBoolean(true);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    private final AtomicBoolean zzj = new AtomicBoolean(false);
    final BlockingQueue zzb = new ArrayBlockingQueue(((Integer) n42.d.c.zza(zzbbw.zzhX)).intValue());

    public zzemk(zzdsk zzdskVar) {
        this.zza = zzdskVar;
    }

    private final void zzo() {
        if (this.zzi.get() && this.zzj.get()) {
            for (final Pair pair : this.zzb) {
                zzfbq.zza(this.zzd, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzelv
                    @Override // com.google.android.gms.internal.ads.zzfbp
                    public final void zza(Object obj) {
                        Pair pair2 = pair;
                        ((u62) obj).zzc((String) pair2.first, (String) pair2.second);
                    }
                });
            }
            this.zzb.clear();
            this.zzh.set(false);
        }
    }

    @Override // defpackage.b22
    public final void onAdClicked() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzjR)).booleanValue()) {
            return;
        }
        zzfbq.zza(this.zzc, new zzemi());
    }

    @Override // defpackage.u6
    public final synchronized void onAppEvent(final String str, final String str2) {
        if (!this.zzh.get()) {
            zzfbq.zza(this.zzd, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzemc
                @Override // com.google.android.gms.internal.ads.zzfbp
                public final void zza(Object obj) {
                    ((u62) obj).zzc(str, str2);
                }
            });
            return;
        }
        if (!this.zzb.offer(new Pair(str, str2))) {
            k92.d("The queue for app events is full, dropping the new event.");
            zzdsk zzdskVar = this.zza;
            if (zzdskVar != null) {
                zzdsj zzdsjVarZza = zzdskVar.zza();
                zzdsjVarZza.zzb("action", "dae_action");
                zzdsjVarZza.zzb("dae_name", str);
                zzdsjVarZza.zzb("dae_data", str2);
                zzdsjVarZza.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zza() {
        zzfbq.zza(this.zzc, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzels
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a52) obj).zzd();
            }
        });
        zzfbq.zza(this.zzg, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzelt
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a72) obj).zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzb() {
        zzfbq.zza(this.zzc, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzemd
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a52) obj).zzh();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzc() {
        zzfbq.zza(this.zzc, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzemf
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a52) obj).zzj();
            }
        });
        zzfbq.zza(this.zzg, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzemg
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a72) obj).zzf();
            }
        });
        zzfbq.zza(this.zzg, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzemh
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a72) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(final j92 j92Var) {
        zzfbq.zza(this.zzc, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzelw
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a52) obj).zzf(j92Var);
            }
        });
        zzfbq.zza(this.zzc, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzelx
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a52) obj).zze(j92Var.g);
            }
        });
        zzfbq.zza(this.zzf, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzely
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((f52) obj).zzb(j92Var);
            }
        });
        this.zzh.set(false);
        this.zzb.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdG() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzjR)).booleanValue()) {
            zzfbq.zza(this.zzc, new zzemi());
        }
        zzfbq.zza(this.zzg, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzelu
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a72) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdf() {
        zzfbq.zza(this.zzc, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzeme
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a52) obj).zzk();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdo(zzfex zzfexVar) {
        this.zzh.set(true);
        this.zzj.set(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzds(zzbvn zzbvnVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzf() {
    }

    public final synchronized a52 zzg() {
        return (a52) this.zzc.get();
    }

    @Override // com.google.android.gms.internal.ads.zzczb
    public final void zzh(final xc2 xc2Var) {
        zzfbq.zza(this.zze, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzemj
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((m82) obj).b(xc2Var);
            }
        });
    }

    public final synchronized u62 zzi() {
        return (u62) this.zzd.get();
    }

    public final void zzj(a52 a52Var) {
        this.zzc.set(a52Var);
    }

    public final void zzk(f52 f52Var) {
        this.zzf.set(f52Var);
    }

    public final void zzl(m82 m82Var) {
        this.zze.set(m82Var);
    }

    public final void zzm(u62 u62Var) {
        this.zzd.set(u62Var);
        this.zzi.set(true);
        zzo();
    }

    public final void zzn(a72 a72Var) {
        this.zzg.set(a72Var);
    }

    @Override // com.google.android.gms.internal.ads.zzcxg
    public final void zzq(final j92 j92Var) {
        zzfbq.zza(this.zzg, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzemb
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a72) obj).zzd(j92Var);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        zzfbq.zza(this.zzc, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzelr
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a52) obj).zzg();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final synchronized void zzs() {
        zzfbq.zza(this.zzc, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzelz
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((a52) obj).zzi();
            }
        });
        zzfbq.zza(this.zzf, new zzfbp() { // from class: com.google.android.gms.internal.ads.zzema
            @Override // com.google.android.gms.internal.ads.zzfbp
            public final void zza(Object obj) {
                ((f52) obj).zzc();
            }
        });
        this.zzj.set(true);
        zzo();
    }
}
