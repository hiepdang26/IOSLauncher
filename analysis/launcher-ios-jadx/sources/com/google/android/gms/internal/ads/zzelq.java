package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import defpackage.a52;
import defpackage.a72;
import defpackage.b62;
import defpackage.b92;
import defpackage.cd2;
import defpackage.f52;
import defpackage.gy0;
import defpackage.hd2;
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
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class zzelq extends u52 implements zzczc {
    private final Context zza;
    private final zzfax zzb;
    private final String zzc;
    private final zzemk zzd;
    private rc2 zze;
    private final zzffe zzf;
    private final or1 zzg;
    private final zzdsk zzh;
    private zzcpk zzi;

    public zzelq(Context context, rc2 rc2Var, String str, zzfax zzfaxVar, zzemk zzemkVar, or1 or1Var, zzdsk zzdskVar) {
        this.zza = context;
        this.zzb = zzfaxVar;
        this.zze = rc2Var;
        this.zzc = str;
        this.zzd = zzemkVar;
        this.zzf = zzfaxVar.zzg();
        this.zzg = or1Var;
        this.zzh = zzdskVar;
        zzfaxVar.zzp(this);
    }

    private final synchronized void zzf(rc2 rc2Var) {
        this.zzf.zzs(rc2Var);
        this.zzf.zzy(this.zze.t);
    }

    private final synchronized boolean zzh(tb2 tb2Var) {
        try {
            if (zzm()) {
                hg0.g("loadAd must be called on the main UI thread.");
            }
            cd2 cd2Var = hd2.B.c;
            if (!cd2.f(this.zza) || tb2Var.y != null) {
                zzfgd.zza(this.zza, tb2Var.l);
                return this.zzb.zzb(tb2Var, this.zzc, null, new zzelp(this));
            }
            k92.e("Failed to load the ad because app ID is missing.");
            zzemk zzemkVar = this.zzd;
            if (zzemkVar != null) {
                zzemkVar.zzdB(zzfgi.zzd(4, null, null));
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzm() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdq.zzf
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L24
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzkl
            n42 r3 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r3 = r3.c
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L24
            r0 = 1
            goto L25
        L24:
            r0 = 0
        L25:
            or1 r3 = r6.zzg
            int r3 = r3.i
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzkm
            n42 r5 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r5 = r5.c
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r3 < r4) goto L3f
            if (r0 != 0) goto L3e
            goto L3f
        L3e:
            return r2
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelq.zzm():boolean");
    }

    @Override // defpackage.v52
    public final synchronized void zzA() {
        hg0.g("recordManualImpression must be called on the main UI thread.");
        zzcpk zzcpkVar = this.zzi;
        if (zzcpkVar != null) {
            zzcpkVar.zzh();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0021, B:13:0x003d, B:15:0x0041, B:12:0x0038), top: B:22:0x0001 }] */
    @Override // defpackage.v52
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzB() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdq.zzh     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzkh     // Catch: java.lang.Throwable -> L36
            n42 r1 = defpackage.n42.d     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbbu r2 = r1.c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r2.zza(r0)     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            or1 r0 = r3.zzg     // Catch: java.lang.Throwable -> L36
            int r0 = r0.i     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzkn     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbbu r1 = r1.c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = r1.zza(r2)     // Catch: java.lang.Throwable -> L36
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L36
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L36
            if (r0 >= r1) goto L3d
            goto L38
        L36:
            r0 = move-exception
            goto L4d
        L38:
            java.lang.String r0 = "resume must be called on the main UI thread."
            defpackage.hg0.g(r0)     // Catch: java.lang.Throwable -> L36
        L3d:
            com.google.android.gms.internal.ads.zzcpk r0 = r3.zzi     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L4b
            com.google.android.gms.internal.ads.zzcxp r0 = r0.zzn()     // Catch: java.lang.Throwable -> L36
            r1 = 0
            r0.zzc(r1)     // Catch: java.lang.Throwable -> L36
            monitor-exit(r3)
            return
        L4b:
            monitor-exit(r3)
            return
        L4d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelq.zzB():void");
    }

    @Override // defpackage.v52
    public final void zzC(v42 v42Var) {
        if (zzm()) {
            hg0.g("setAdListener must be called on the main UI thread.");
        }
        this.zzb.zzo(v42Var);
    }

    @Override // defpackage.v52
    public final void zzD(a52 a52Var) {
        if (zzm()) {
            hg0.g("setAdListener must be called on the main UI thread.");
        }
        this.zzd.zzj(a52Var);
    }

    @Override // defpackage.v52
    public final void zzE(b62 b62Var) {
        hg0.g("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // defpackage.v52
    public final synchronized void zzF(rc2 rc2Var) {
        hg0.g("setAdSize must be called on the main UI thread.");
        this.zzf.zzs(rc2Var);
        this.zze = rc2Var;
        zzcpk zzcpkVar = this.zzi;
        if (zzcpkVar != null) {
            zzcpkVar.zzi(this.zzb.zzc(), rc2Var);
        }
    }

    @Override // defpackage.v52
    public final void zzG(u62 u62Var) {
        if (zzm()) {
            hg0.g("setAppEventListener must be called on the main UI thread.");
        }
        this.zzd.zzm(u62Var);
    }

    @Override // defpackage.v52
    public final void zzH(zzazs zzazsVar) {
    }

    @Override // defpackage.v52
    public final void zzL(boolean z) {
    }

    @Override // defpackage.v52
    public final void zzM(zzbsw zzbswVar) {
    }

    @Override // defpackage.v52
    public final synchronized void zzN(boolean z) {
        try {
            if (zzm()) {
                hg0.g("setManualImpressionsEnabled must be called from the main thread.");
            }
            this.zzf.zzB(z);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.v52
    public final synchronized void zzO(zzbcr zzbcrVar) {
        hg0.g("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzb.zzq(zzbcrVar);
    }

    @Override // defpackage.v52
    public final void zzP(m82 m82Var) {
        if (zzm()) {
            hg0.g("setPaidEventListener must be called on the main UI thread.");
        }
        try {
            if (!m82Var.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException unused) {
            k92.j(3);
        }
        this.zzd.zzl(m82Var);
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
        try {
            if (zzm()) {
                hg0.g("setVideoOptions must be called on the main UI thread.");
            }
            this.zzf.zzI(ta2Var);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.v52
    public final void zzX() {
    }

    @Override // defpackage.v52
    public final synchronized boolean zzY() {
        zzcpk zzcpkVar = this.zzi;
        if (zzcpkVar != null) {
            if (zzcpkVar.zzs()) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.v52
    public final synchronized boolean zzZ() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final synchronized void zza() {
        try {
            if (!this.zzb.zzt()) {
                this.zzb.zzm();
                return;
            }
            rc2 rc2VarZzh = this.zzf.zzh();
            zzcpk zzcpkVar = this.zzi;
            if (zzcpkVar != null && zzcpkVar.zzg() != null && this.zzf.zzT()) {
                rc2VarZzh = zzffm.zza(this.zza, Collections.singletonList(this.zzi.zzg()));
            }
            zzf(rc2VarZzh);
            this.zzf.zzx(true);
            try {
                zzh(this.zzf.zzf());
            } catch (RemoteException unused) {
                k92.h("Failed to refresh the banner ad.");
            }
            this.zzf.zzx(false);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.v52
    public final boolean zzaa() {
        return false;
    }

    @Override // defpackage.v52
    public final synchronized boolean zzab(tb2 tb2Var) {
        zzf(this.zze);
        return zzh(tb2Var);
    }

    @Override // defpackage.v52
    public final synchronized void zzac(y62 y62Var) {
        hg0.g("setCorrelationIdProvider must be called on the main UI thread");
        this.zzf.zzV(y62Var);
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final synchronized void zzb() {
        if (this.zzb.zzt()) {
            this.zzb.zzr();
        } else {
            this.zzb.zzn();
        }
    }

    @Override // defpackage.v52
    public final Bundle zzd() {
        hg0.g("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // defpackage.v52
    public final synchronized rc2 zzg() {
        hg0.g("getAdSize must be called on the main UI thread.");
        zzcpk zzcpkVar = this.zzi;
        if (zzcpkVar != null) {
            return zzffm.zza(this.zza, Collections.singletonList(zzcpkVar.zzf()));
        }
        return this.zzf.zzh();
    }

    @Override // defpackage.v52
    public final a52 zzi() {
        return this.zzd.zzg();
    }

    @Override // defpackage.v52
    public final u62 zzj() {
        return this.zzd.zzi();
    }

    @Override // defpackage.v52
    public final synchronized u82 zzk() {
        zzcpk zzcpkVar;
        if (((Boolean) n42.d.c.zza(zzbbw.zzgc)).booleanValue() && (zzcpkVar = this.zzi) != null) {
            return zzcpkVar.zzm();
        }
        return null;
    }

    @Override // defpackage.v52
    public final synchronized x82 zzl() {
        hg0.g("getVideoController must be called from the main thread.");
        zzcpk zzcpkVar = this.zzi;
        if (zzcpkVar == null) {
            return null;
        }
        return zzcpkVar.zze();
    }

    @Override // defpackage.v52
    public final he0 zzn() {
        if (zzm()) {
            hg0.g("getAdFrame must be called on the main UI thread.");
        }
        return new gy0(this.zzb.zzc());
    }

    @Override // defpackage.v52
    public final synchronized String zzr() {
        return this.zzc;
    }

    @Override // defpackage.v52
    public final synchronized String zzs() {
        zzcpk zzcpkVar = this.zzi;
        if (zzcpkVar == null || zzcpkVar.zzm() == null) {
            return null;
        }
        return zzcpkVar.zzm().zzg();
    }

    @Override // defpackage.v52
    public final synchronized String zzt() {
        zzcpk zzcpkVar = this.zzi;
        if (zzcpkVar == null || zzcpkVar.zzm() == null) {
            return null;
        }
        return zzcpkVar.zzm().zzg();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0021, B:13:0x003d, B:15:0x0041, B:12:0x0038), top: B:22:0x0001 }] */
    @Override // defpackage.v52
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzx() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdq.zze     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzki     // Catch: java.lang.Throwable -> L36
            n42 r1 = defpackage.n42.d     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbbu r2 = r1.c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r2.zza(r0)     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            or1 r0 = r3.zzg     // Catch: java.lang.Throwable -> L36
            int r0 = r0.i     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzkn     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbbu r1 = r1.c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = r1.zza(r2)     // Catch: java.lang.Throwable -> L36
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L36
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L36
            if (r0 >= r1) goto L3d
            goto L38
        L36:
            r0 = move-exception
            goto L48
        L38:
            java.lang.String r0 = "destroy must be called on the main UI thread."
            defpackage.hg0.g(r0)     // Catch: java.lang.Throwable -> L36
        L3d:
            com.google.android.gms.internal.ads.zzcpk r0 = r3.zzi     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L46
            r0.zzb()     // Catch: java.lang.Throwable -> L36
            monitor-exit(r3)
            return
        L46:
            monitor-exit(r3)
            return
        L48:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelq.zzx():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0021, B:13:0x003d, B:15:0x0041, B:12:0x0038), top: B:22:0x0001 }] */
    @Override // defpackage.v52
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzz() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdq.zzg     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzkj     // Catch: java.lang.Throwable -> L36
            n42 r1 = defpackage.n42.d     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbbu r2 = r1.c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r2.zza(r0)     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            or1 r0 = r3.zzg     // Catch: java.lang.Throwable -> L36
            int r0 = r0.i     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzkn     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbbu r1 = r1.c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = r1.zza(r2)     // Catch: java.lang.Throwable -> L36
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L36
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L36
            if (r0 >= r1) goto L3d
            goto L38
        L36:
            r0 = move-exception
            goto L4d
        L38:
            java.lang.String r0 = "pause must be called on the main UI thread."
            defpackage.hg0.g(r0)     // Catch: java.lang.Throwable -> L36
        L3d:
            com.google.android.gms.internal.ads.zzcpk r0 = r3.zzi     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L4b
            com.google.android.gms.internal.ads.zzcxp r0 = r0.zzn()     // Catch: java.lang.Throwable -> L36
            r1 = 0
            r0.zzb(r1)     // Catch: java.lang.Throwable -> L36
            monitor-exit(r3)
            return
        L4b:
            monitor-exit(r3)
            return
        L4d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelq.zzz():void");
    }

    @Override // defpackage.v52
    public final void zzI(pd2 pd2Var) {
    }

    @Override // defpackage.v52
    public final void zzJ(a72 a72Var) {
    }

    @Override // defpackage.v52
    public final void zzK(b92 b92Var) {
    }

    @Override // defpackage.v52
    public final void zzW(he0 he0Var) {
    }

    @Override // defpackage.v52
    public final void zzy(tb2 tb2Var, f52 f52Var) {
    }
}
