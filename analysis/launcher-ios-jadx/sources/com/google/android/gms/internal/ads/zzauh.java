package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import defpackage.n42;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class zzauh implements zzauk {
    private static zzauh zzb;
    private final Context zzc;
    private final zzfpw zzd;
    private final zzfqd zze;
    private final zzfqf zzf;
    private final zzavj zzg;
    private final zzfoh zzh;
    private final Executor zzi;
    private final zzfqc zzj;
    private final zzavy zzl;
    private final zzavq zzm;
    private final zzavh zzn;
    private volatile boolean zzp;
    private volatile boolean zzq;
    private final int zzr;
    volatile long zza = 0;
    private final Object zzo = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    public zzauh(Context context, zzfoh zzfohVar, zzfpw zzfpwVar, zzfqd zzfqdVar, zzfqf zzfqfVar, zzavj zzavjVar, Executor executor, zzfoc zzfocVar, int i, zzavy zzavyVar, zzavq zzavqVar, zzavh zzavhVar) {
        this.zzq = false;
        this.zzc = context;
        this.zzh = zzfohVar;
        this.zzd = zzfpwVar;
        this.zze = zzfqdVar;
        this.zzf = zzfqfVar;
        this.zzg = zzavjVar;
        this.zzi = executor;
        this.zzr = i;
        this.zzl = zzavyVar;
        this.zzm = zzavqVar;
        this.zzn = zzavhVar;
        this.zzq = false;
        this.zzj = new zzauf(this, zzfocVar);
    }

    public static synchronized zzauh zza(String str, Context context, boolean z, boolean z2) {
        return zzb(str, context, Executors.newCachedThreadPool(), z, z2);
    }

    @Deprecated
    public static synchronized zzauh zzb(String str, Context context, Executor executor, boolean z, boolean z2) {
        try {
            if (zzb == null) {
                zzfoi zzfoiVarZza = zzfoj.zza();
                zzfoiVarZza.zza(str);
                zzfoiVarZza.zzc(z);
                zzfoj zzfojVarZzd = zzfoiVarZza.zzd();
                zzfoh zzfohVarZza = zzfoh.zza(context, executor, z2);
                zzbbn zzbbnVar = zzbbw.zzcY;
                n42 n42Var = n42.d;
                zzaus zzausVarZzc = ((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() ? zzaus.zzc(context) : null;
                zzavy zzavyVarZzd = ((Boolean) n42Var.c.zza(zzbbw.zzcZ)).booleanValue() ? zzavy.zzd(context, executor) : null;
                zzavq zzavqVar = ((Boolean) n42Var.c.zza(zzbbw.zzcs)).booleanValue() ? new zzavq() : null;
                zzavh zzavhVar = ((Boolean) n42Var.c.zza(zzbbw.zzct)).booleanValue() ? new zzavh() : null;
                zzfpa zzfpaVarZze = zzfpa.zze(context, executor, zzfohVarZza, zzfojVarZzd);
                zzavi zzaviVar = new zzavi(context);
                zzavq zzavqVar2 = zzavqVar;
                zzavj zzavjVar = new zzavj(zzfojVarZzd, zzfpaVarZze, new zzavw(context, zzaviVar), zzaviVar, zzausVarZzc, zzavyVarZzd, zzavqVar2, zzavhVar);
                int iZzb = zzfpj.zzb(context, zzfohVarZza);
                zzfoc zzfocVar = new zzfoc();
                zzauh zzauhVar = new zzauh(context, zzfohVarZza, new zzfpw(context, iZzb), new zzfqd(context, iZzb, new zzaue(zzfohVarZza), ((Boolean) n42Var.c.zza(zzbbw.zzcc)).booleanValue()), new zzfqf(context, zzavjVar, zzfohVarZza, zzfocVar), zzavjVar, executor, zzfocVar, iZzb, zzavyVarZzd, zzavqVar2, zzavhVar);
                zzb = zzauhVar;
                zzauhVar.zzm();
                zzb.zzp();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzb;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00fc A[Catch: all -> 0x009d, zzgyn -> 0x00a0, TryCatch #0 {zzgyn -> 0x00a0, blocks: (B:6:0x0021, B:8:0x0032, B:12:0x0038, B:13:0x0044, B:15:0x0052, B:17:0x0060, B:20:0x006d, B:32:0x00a3, B:36:0x00bc, B:42:0x00d5, B:43:0x00e2, B:45:0x00e8, B:47:0x00f0, B:48:0x00f2, B:39:0x00c6, B:40:0x00cd, B:23:0x0074, B:25:0x008a, B:49:0x00fc, B:50:0x0109, B:51:0x0116), top: B:58:0x0021, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void zzj(com.google.android.gms.internal.ads.zzauh r12) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauh.zzj(com.google.android.gms.internal.ads.zzauh):void");
    }

    private final void zzs() {
        zzavy zzavyVar = this.zzl;
        if (zzavyVar != null) {
            zzavyVar.zzh();
        }
    }

    private final zzfpv zzt(int i) {
        if (zzfpj.zza(this.zzr)) {
            return ((Boolean) n42.d.c.zza(zzbbw.zzca)).booleanValue() ? this.zze.zzc(1) : this.zzd.zzc(1);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzf(Context context, String str, View view, Activity activity) {
        zzs();
        if (((Boolean) n42.d.c.zza(zzbbw.zzcs)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfok zzfokVarZza = this.zzf.zza();
        if (zzfokVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzfokVarZza.zza(context, null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - jCurrentTimeMillis, strZza, null);
        return strZza;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzg(Context context) {
        zzs();
        if (((Boolean) n42.d.c.zza(zzbbw.zzcs)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfok zzfokVarZza = this.zzf.zza();
        if (zzfokVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzc = zzfokVarZza.zzc(context, null);
        this.zzh.zzf(5001, System.currentTimeMillis() - jCurrentTimeMillis, strZzc, null);
        return strZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzh(Context context, View view, Activity activity) {
        zzs();
        if (((Boolean) n42.d.c.zza(zzbbw.zzcs)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfok zzfokVarZza = this.zzf.zza();
        if (zzfokVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzb = zzfokVarZza.zzb(context, null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - jCurrentTimeMillis, strZzb, null);
        return strZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzk(MotionEvent motionEvent) {
        zzfok zzfokVarZza = this.zzf.zza();
        if (zzfokVarZza != null) {
            try {
                zzfokVarZza.zzd(null, motionEvent);
            } catch (zzfqe e) {
                this.zzh.zzc(e.zza(), -1L, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzl(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) n42.d.c.zza(zzbbw.zzkY)).booleanValue() || (displayMetrics = this.zzc.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f = i;
        float f2 = displayMetrics.density;
        float f3 = i2;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, f * f2, f3 * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain);
        motionEventObtain.recycle();
        float f4 = displayMetrics.density;
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 2, f * f4, f3 * f4, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain2);
        motionEventObtain2.recycle();
        float f5 = displayMetrics.density;
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, i3, 1, f * f5, f3 * f5, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    public final synchronized void zzm() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfpv zzfpvVarZzt = zzt(1);
        if (zzfpvVarZzt == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - jCurrentTimeMillis);
        } else if (this.zzf.zzc(zzfpvVarZzt)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzavh zzavhVar = this.zzn;
        if (zzavhVar != null) {
            zzavhVar.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzo(View view) {
        this.zzg.zzd(view);
    }

    public final void zzp() {
        if (this.zzp) {
            return;
        }
        synchronized (this.zzo) {
            try {
                if (!this.zzp) {
                    if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                        return;
                    }
                    zzfpv zzfpvVarZzb = this.zzf.zzb();
                    if ((zzfpvVarZzb == null || zzfpvVarZzb.zzd(3600L)) && zzfpj.zza(this.zzr)) {
                        this.zzi.execute(new zzaug(this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }
}
