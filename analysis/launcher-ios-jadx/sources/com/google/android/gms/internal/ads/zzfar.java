package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import defpackage.a52;
import defpackage.a72;
import defpackage.b62;
import defpackage.b92;
import defpackage.f52;
import defpackage.hd2;
import defpackage.he0;
import defpackage.hg0;
import defpackage.m82;
import defpackage.mc2;
import defpackage.or1;
import defpackage.pd2;
import defpackage.rc2;
import defpackage.ta2;
import defpackage.tb2;
import defpackage.u52;
import defpackage.u62;
import defpackage.u82;
import defpackage.v42;
import defpackage.x82;
import defpackage.y62;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzfar extends u52 implements mc2, zzazj {
    protected zzcpe zza;
    private final zzcgj zzb;
    private final Context zzc;
    private final String zze;
    private final zzfal zzf;
    private final zzfaj zzg;
    private final or1 zzh;
    private final zzdsk zzi;
    private zzcor zzk;
    private AtomicBoolean zzd = new AtomicBoolean();
    private long zzj = -1;

    public zzfar(zzcgj zzcgjVar, Context context, String str, zzfal zzfalVar, zzfaj zzfajVar, or1 or1Var, zzdsk zzdskVar) {
        this.zzb = zzcgjVar;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzfalVar;
        this.zzg = zzfajVar;
        this.zzh = or1Var;
        this.zzi = zzdskVar;
        zzfajVar.zzm(this);
    }

    private final synchronized void zzq(int i) {
        try {
            if (this.zzd.compareAndSet(false, true)) {
                this.zzg.zzj();
                zzcor zzcorVar = this.zzk;
                if (zzcorVar != null) {
                    hd2.B.f.zze(zzcorVar);
                }
                if (this.zza != null) {
                    long jElapsedRealtime = -1;
                    if (this.zzj != -1) {
                        hd2.B.j.getClass();
                        jElapsedRealtime = SystemClock.elapsedRealtime() - this.zzj;
                    }
                    this.zza.zze(jElapsedRealtime, i);
                }
                zzx();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.v52
    public final synchronized void zzA() {
    }

    @Override // defpackage.v52
    public final synchronized void zzB() {
        hg0.g("resume must be called on the main UI thread.");
    }

    @Override // defpackage.v52
    public final synchronized void zzF(rc2 rc2Var) {
        hg0.g("setAdSize must be called on the main UI thread.");
    }

    @Override // defpackage.v52
    public final void zzH(zzazs zzazsVar) {
        this.zzg.zzo(zzazsVar);
    }

    @Override // defpackage.v52
    public final void zzI(pd2 pd2Var) {
        this.zzf.zzl(pd2Var);
    }

    @Override // defpackage.v52
    public final void zzL(boolean z) {
    }

    @Override // defpackage.v52
    public final void zzM(zzbsw zzbswVar) {
    }

    @Override // defpackage.v52
    public final synchronized void zzN(boolean z) {
    }

    @Override // defpackage.v52
    public final synchronized void zzO(zzbcr zzbcrVar) {
    }

    @Override // defpackage.v52
    public final void zzQ(zzbsz zzbszVar, String str) {
    }

    @Override // defpackage.v52
    public final void zzR(String str) {
    }

    @Override // defpackage.v52
    public final void zzS(zzbvt zzbvtVar) {
    }

    @Override // defpackage.v52
    public final void zzT(String str) {
    }

    @Override // defpackage.v52
    public final synchronized void zzU(ta2 ta2Var) {
    }

    @Override // defpackage.v52
    public final synchronized void zzX() {
    }

    @Override // defpackage.v52
    public final synchronized boolean zzY() {
        return false;
    }

    @Override // defpackage.v52
    public final synchronized boolean zzZ() {
        return this.zzf.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzazj
    public final void zza() {
        zzq(3);
    }

    @Override // defpackage.v52
    public final boolean zzaa() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // defpackage.v52
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean zzab(defpackage.tb2 r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdq.zzd     // Catch: java.lang.Throwable -> L26
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L26
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L26
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L26
            r1 = 0
            if (r0 == 0) goto L24
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzkl     // Catch: java.lang.Throwable -> L26
            n42 r2 = defpackage.n42.d     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzbbu r2 = r2.c     // Catch: java.lang.Throwable -> L26
            java.lang.Object r0 = r2.zza(r0)     // Catch: java.lang.Throwable -> L26
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L26
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L24
            r0 = 1
            goto L28
        L24:
            r0 = 0
            goto L28
        L26:
            r6 = move-exception
            goto L8b
        L28:
            or1 r2 = r5.zzh     // Catch: java.lang.Throwable -> L26
            int r2 = r2.i     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzkm     // Catch: java.lang.Throwable -> L26
            n42 r4 = defpackage.n42.d     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzbbu r4 = r4.c     // Catch: java.lang.Throwable -> L26
            java.lang.Object r3 = r4.zza(r3)     // Catch: java.lang.Throwable -> L26
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L26
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L26
            if (r2 < r3) goto L40
            if (r0 != 0) goto L45
        L40:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            defpackage.hg0.g(r0)     // Catch: java.lang.Throwable -> L26
        L45:
            hd2 r0 = defpackage.hd2.B     // Catch: java.lang.Throwable -> L26
            cd2 r0 = r0.c     // Catch: java.lang.Throwable -> L26
            android.content.Context r0 = r5.zzc     // Catch: java.lang.Throwable -> L26
            boolean r0 = defpackage.cd2.f(r0)     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L68
            l62 r0 = r6.y     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L56
            goto L68
        L56:
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            defpackage.k92.e(r6)     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzfaj r6 = r5.zzg     // Catch: java.lang.Throwable -> L26
            r0 = 4
            r2 = 0
            j92 r0 = com.google.android.gms.internal.ads.zzfgi.zzd(r0, r2, r2)     // Catch: java.lang.Throwable -> L26
            r6.zzdB(r0)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r5)
            return r1
        L68:
            boolean r0 = r5.zzZ()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L70
            monitor-exit(r5)
            return r1
        L70:
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean     // Catch: java.lang.Throwable -> L26
            r0.<init>()     // Catch: java.lang.Throwable -> L26
            r5.zzd = r0     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzfap r0 = new com.google.android.gms.internal.ads.zzfap     // Catch: java.lang.Throwable -> L26
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzfal r1 = r5.zzf     // Catch: java.lang.Throwable -> L26
            java.lang.String r2 = r5.zze     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzfaq r3 = new com.google.android.gms.internal.ads.zzfaq     // Catch: java.lang.Throwable -> L26
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L26
            boolean r6 = r1.zzb(r6, r2, r0, r3)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r5)
            return r6
        L8b:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L26
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfar.zzab(tb2):boolean");
    }

    @Override // defpackage.v52
    public final synchronized void zzac(y62 y62Var) {
    }

    @Override // defpackage.v52
    public final Bundle zzd() {
        return new Bundle();
    }

    @Override // defpackage.mc2
    public final void zzdH() {
    }

    @Override // defpackage.mc2
    public final void zzdk() {
    }

    @Override // defpackage.mc2
    public final void zzdq() {
    }

    @Override // defpackage.mc2
    public final synchronized void zzdr() {
        if (this.zza != null) {
            hd2 hd2Var = hd2.B;
            hd2Var.j.getClass();
            this.zzj = SystemClock.elapsedRealtime();
            int iZza = this.zza.zza();
            if (iZza > 0) {
                zzcor zzcorVar = new zzcor(this.zzb.zzC(), hd2Var.j);
                this.zzk = zzcorVar;
                zzcorVar.zzd(iZza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzfao
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzp();
                    }
                });
            }
        }
    }

    @Override // defpackage.mc2
    public final synchronized void zzdt() {
        zzcpe zzcpeVar = this.zza;
        if (zzcpeVar != null) {
            hd2.B.j.getClass();
            zzcpeVar.zze(SystemClock.elapsedRealtime() - this.zzj, 1);
        }
    }

    @Override // defpackage.mc2
    public final void zzdu(int i) {
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            zzq(2);
            return;
        }
        if (i2 == 1) {
            zzq(4);
        } else if (i2 != 2) {
            zzq(6);
        } else {
            zzq(3);
        }
    }

    @Override // defpackage.v52
    public final synchronized rc2 zzg() {
        return null;
    }

    @Override // defpackage.v52
    public final a52 zzi() {
        return null;
    }

    @Override // defpackage.v52
    public final u62 zzj() {
        return null;
    }

    @Override // defpackage.v52
    public final synchronized u82 zzk() {
        return null;
    }

    @Override // defpackage.v52
    public final synchronized x82 zzl() {
        return null;
    }

    @Override // defpackage.v52
    public final he0 zzn() {
        return null;
    }

    public final /* synthetic */ void zzo() {
        zzq(5);
    }

    public final void zzp() {
        this.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfan
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzo();
            }
        });
    }

    @Override // defpackage.v52
    public final synchronized String zzr() {
        return this.zze;
    }

    @Override // defpackage.v52
    public final synchronized String zzs() {
        return null;
    }

    @Override // defpackage.v52
    public final synchronized String zzt() {
        return null;
    }

    @Override // defpackage.v52
    public final synchronized void zzx() {
        hg0.g("destroy must be called on the main UI thread.");
        zzcpe zzcpeVar = this.zza;
        if (zzcpeVar != null) {
            zzcpeVar.zzb();
        }
    }

    @Override // defpackage.v52
    public final synchronized void zzz() {
        hg0.g("pause must be called on the main UI thread.");
    }

    @Override // defpackage.v52
    public final void zzC(v42 v42Var) {
    }

    @Override // defpackage.v52
    public final void zzD(a52 a52Var) {
    }

    @Override // defpackage.v52
    public final void zzE(b62 b62Var) {
    }

    @Override // defpackage.v52
    public final void zzG(u62 u62Var) {
    }

    @Override // defpackage.v52
    public final void zzJ(a72 a72Var) {
    }

    @Override // defpackage.v52
    public final void zzK(b92 b92Var) {
    }

    @Override // defpackage.v52
    public final void zzP(m82 m82Var) {
    }

    @Override // defpackage.v52
    public final void zzW(he0 he0Var) {
    }

    @Override // defpackage.v52
    public final void zzy(tb2 tb2Var, f52 f52Var) {
    }
}
