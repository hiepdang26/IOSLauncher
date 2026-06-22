package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.a52;
import defpackage.a72;
import defpackage.b62;
import defpackage.b92;
import defpackage.f52;
import defpackage.gy0;
import defpackage.he0;
import defpackage.hg0;
import defpackage.k92;
import defpackage.m82;
import defpackage.n42;
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

/* JADX INFO: loaded from: classes.dex */
public final class zzems extends u52 {
    private final rc2 zza;
    private final Context zzb;
    private final zzfco zzc;
    private final String zzd;
    private final or1 zze;
    private final zzemk zzf;
    private final zzfdo zzg;
    private final zzauo zzh;
    private final zzdsk zzi;
    private zzdfo zzj;
    private boolean zzk = ((Boolean) n42.d.c.zza(zzbbw.zzav)).booleanValue();

    public zzems(Context context, rc2 rc2Var, String str, zzfco zzfcoVar, zzemk zzemkVar, zzfdo zzfdoVar, or1 or1Var, zzauo zzauoVar, zzdsk zzdskVar) {
        this.zza = rc2Var;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzfcoVar;
        this.zzf = zzemkVar;
        this.zzg = zzfdoVar;
        this.zze = or1Var;
        this.zzh = zzauoVar;
        this.zzi = zzdskVar;
    }

    private final synchronized boolean zze() {
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar != null) {
            if (!zzdfoVar.zza()) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.v52
    public final void zzA() {
    }

    @Override // defpackage.v52
    public final synchronized void zzB() {
        hg0.g("resume must be called on the main UI thread.");
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar != null) {
            zzdfoVar.zzn().zzc(null);
        }
    }

    @Override // defpackage.v52
    public final void zzD(a52 a52Var) {
        hg0.g("setAdListener must be called on the main UI thread.");
        this.zzf.zzj(a52Var);
    }

    @Override // defpackage.v52
    public final void zzE(b62 b62Var) {
        hg0.g("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // defpackage.v52
    public final void zzG(u62 u62Var) {
        hg0.g("setAppEventListener must be called on the main UI thread.");
        this.zzf.zzm(u62Var);
    }

    @Override // defpackage.v52
    public final void zzH(zzazs zzazsVar) {
    }

    @Override // defpackage.v52
    public final void zzJ(a72 a72Var) {
        this.zzf.zzn(a72Var);
    }

    @Override // defpackage.v52
    public final synchronized void zzL(boolean z) {
        hg0.g("setImmersiveMode must be called on the main UI thread.");
        this.zzk = z;
    }

    @Override // defpackage.v52
    public final void zzM(zzbsw zzbswVar) {
    }

    @Override // defpackage.v52
    public final void zzN(boolean z) {
    }

    @Override // defpackage.v52
    public final synchronized void zzO(zzbcr zzbcrVar) {
        hg0.g("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzi(zzbcrVar);
    }

    @Override // defpackage.v52
    public final void zzP(m82 m82Var) {
        hg0.g("setPaidEventListener must be called on the main UI thread.");
        try {
            if (!m82Var.zzf()) {
                this.zzi.zze();
            }
        } catch (RemoteException unused) {
            k92.j(3);
        }
        this.zzf.zzl(m82Var);
    }

    @Override // defpackage.v52
    public final void zzQ(zzbsz zzbszVar, String str) {
    }

    @Override // defpackage.v52
    public final void zzR(String str) {
    }

    @Override // defpackage.v52
    public final void zzS(zzbvt zzbvtVar) {
        this.zzg.zzm(zzbvtVar);
    }

    @Override // defpackage.v52
    public final void zzT(String str) {
    }

    @Override // defpackage.v52
    public final synchronized void zzW(he0 he0Var) {
        if (this.zzj == null) {
            k92.h("Interstitial can not be shown before loaded.");
            this.zzf.zzq(zzfgi.zzd(9, null, null));
            return;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzct)).booleanValue()) {
            this.zzh.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzj.zzc(this.zzk, (Activity) gy0.r(he0Var));
    }

    @Override // defpackage.v52
    public final synchronized void zzX() {
        hg0.g("showInterstitial must be called on the main UI thread.");
        if (this.zzj == null) {
            k92.h("Interstitial can not be shown before loaded.");
            this.zzf.zzq(zzfgi.zzd(9, null, null));
        } else {
            if (((Boolean) n42.d.c.zza(zzbbw.zzct)).booleanValue()) {
                this.zzh.zzc().zzn(new Throwable().getStackTrace());
            }
            this.zzj.zzc(this.zzk, null);
        }
    }

    @Override // defpackage.v52
    public final synchronized boolean zzY() {
        return false;
    }

    @Override // defpackage.v52
    public final synchronized boolean zzZ() {
        return this.zzc.zza();
    }

    @Override // defpackage.v52
    public final synchronized boolean zzaa() {
        hg0.g("isLoaded must be called on the main UI thread.");
        return zze();
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
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdq.zzi     // Catch: java.lang.Throwable -> L26
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
            goto L8f
        L28:
            or1 r2 = r5.zze     // Catch: java.lang.Throwable -> L26
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
            android.content.Context r0 = r5.zzb     // Catch: java.lang.Throwable -> L26
            boolean r0 = defpackage.cd2.f(r0)     // Catch: java.lang.Throwable -> L26
            r2 = 0
            if (r0 == 0) goto L68
            l62 r0 = r6.y     // Catch: java.lang.Throwable -> L26
            if (r0 != 0) goto L68
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            defpackage.k92.e(r6)     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzemk r6 = r5.zzf     // Catch: java.lang.Throwable -> L26
            if (r6 == 0) goto L8d
            r0 = 4
            j92 r0 = com.google.android.gms.internal.ads.zzfgi.zzd(r0, r2, r2)     // Catch: java.lang.Throwable -> L26
            r6.zzdB(r0)     // Catch: java.lang.Throwable -> L26
            goto L8d
        L68:
            boolean r0 = r5.zze()     // Catch: java.lang.Throwable -> L26
            if (r0 != 0) goto L8d
            android.content.Context r0 = r5.zzb     // Catch: java.lang.Throwable -> L26
            boolean r1 = r6.l     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzfgd.zza(r0, r1)     // Catch: java.lang.Throwable -> L26
            r5.zzj = r2     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzfco r0 = r5.zzc     // Catch: java.lang.Throwable -> L26
            java.lang.String r1 = r5.zzd     // Catch: java.lang.Throwable -> L26
            rc2 r2 = r5.zza     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzfch r3 = new com.google.android.gms.internal.ads.zzfch     // Catch: java.lang.Throwable -> L26
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L26
            com.google.android.gms.internal.ads.zzemr r2 = new com.google.android.gms.internal.ads.zzemr     // Catch: java.lang.Throwable -> L26
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L26
            boolean r6 = r0.zzb(r6, r1, r3, r2)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r5)
            return r6
        L8d:
            monitor-exit(r5)
            return r1
        L8f:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L26
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zzab(tb2):boolean");
    }

    @Override // defpackage.v52
    public final Bundle zzd() {
        hg0.g("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // defpackage.v52
    public final rc2 zzg() {
        return null;
    }

    @Override // defpackage.v52
    public final a52 zzi() {
        return this.zzf.zzg();
    }

    @Override // defpackage.v52
    public final u62 zzj() {
        return this.zzf.zzi();
    }

    @Override // defpackage.v52
    public final synchronized u82 zzk() {
        zzdfo zzdfoVar;
        if (((Boolean) n42.d.c.zza(zzbbw.zzgc)).booleanValue() && (zzdfoVar = this.zzj) != null) {
            return zzdfoVar.zzm();
        }
        return null;
    }

    @Override // defpackage.v52
    public final x82 zzl() {
        return null;
    }

    @Override // defpackage.v52
    public final he0 zzn() {
        return null;
    }

    @Override // defpackage.v52
    public final synchronized String zzr() {
        return this.zzd;
    }

    @Override // defpackage.v52
    public final synchronized String zzs() {
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar == null || zzdfoVar.zzm() == null) {
            return null;
        }
        return zzdfoVar.zzm().zzg();
    }

    @Override // defpackage.v52
    public final synchronized String zzt() {
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar == null || zzdfoVar.zzm() == null) {
            return null;
        }
        return zzdfoVar.zzm().zzg();
    }

    @Override // defpackage.v52
    public final synchronized void zzx() {
        hg0.g("destroy must be called on the main UI thread.");
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar != null) {
            zzdfoVar.zzn().zza(null);
        }
    }

    @Override // defpackage.v52
    public final void zzy(tb2 tb2Var, f52 f52Var) {
        this.zzf.zzk(f52Var);
        zzab(tb2Var);
    }

    @Override // defpackage.v52
    public final synchronized void zzz() {
        hg0.g("pause must be called on the main UI thread.");
        zzdfo zzdfoVar = this.zzj;
        if (zzdfoVar != null) {
            zzdfoVar.zzn().zzb(null);
        }
    }

    @Override // defpackage.v52
    public final void zzC(v42 v42Var) {
    }

    @Override // defpackage.v52
    public final void zzF(rc2 rc2Var) {
    }

    @Override // defpackage.v52
    public final void zzI(pd2 pd2Var) {
    }

    @Override // defpackage.v52
    public final void zzK(b92 b92Var) {
    }

    @Override // defpackage.v52
    public final void zzU(ta2 ta2Var) {
    }

    @Override // defpackage.v52
    public final void zzac(y62 y62Var) {
    }
}
