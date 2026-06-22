package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import defpackage.b62;
import defpackage.gy0;
import defpackage.he0;
import defpackage.hg0;
import defpackage.n42;
import defpackage.u82;

/* JADX INFO: loaded from: classes.dex */
public final class zzfei extends zzbvp {
    private final zzfdy zza;
    private final zzfdo zzb;
    private final zzfey zzc;
    private zzdop zzd;
    private boolean zze = false;

    public zzfei(zzfdy zzfdyVar, zzfdo zzfdoVar, zzfey zzfeyVar) {
        this.zza = zzfdyVar;
        this.zzb = zzfdoVar;
        this.zzc = zzfeyVar;
    }

    private final synchronized boolean zzy() {
        zzdop zzdopVar = this.zzd;
        if (zzdopVar != null) {
            if (!zzdopVar.zze()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final Bundle zzb() {
        hg0.g("getAdMetadata can only be called from the UI thread.");
        zzdop zzdopVar = this.zzd;
        return zzdopVar != null ? zzdopVar.zza() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final synchronized u82 zzc() {
        zzdop zzdopVar;
        if (((Boolean) n42.d.c.zza(zzbbw.zzgc)).booleanValue() && (zzdopVar = this.zzd) != null) {
            return zzdopVar.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final synchronized String zzd() {
        zzdop zzdopVar = this.zzd;
        if (zzdopVar == null || zzdopVar.zzm() == null) {
            return null;
        }
        return zzdopVar.zzm().zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final void zze() {
        zzf(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final synchronized void zzf(he0 he0Var) {
        hg0.g("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzb.zzg(null);
        if (this.zzd != null) {
            if (he0Var != null) {
                context = (Context) gy0.r(he0Var);
            }
            this.zzd.zzn().zza(context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (((java.lang.Boolean) defpackage.n42.d.c.zza(com.google.android.gms.internal.ads.zzbbw.zzeP)).booleanValue() == false) goto L18;
     */
    @Override // com.google.android.gms.internal.ads.zzbvq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzg(com.google.android.gms.internal.ads.zzbvu r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            defpackage.hg0.g(r0)     // Catch: java.lang.Throwable -> L20
            java.lang.String r0 = r5.zzb     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzeN     // Catch: java.lang.Throwable -> L20
            n42 r2 = defpackage.n42.d     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzbbu r2 = r2.c     // Catch: java.lang.Throwable -> L20
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L2c
            if (r0 != 0) goto L19
            goto L2c
        L19:
            boolean r0 = java.util.regex.Pattern.matches(r1, r0)     // Catch: java.lang.Throwable -> L20 java.lang.RuntimeException -> L22
            if (r0 == 0) goto L2c
            goto L44
        L20:
            r5 = move-exception
            goto L64
        L22:
            r0 = move-exception
            java.lang.String r1 = "NonagonUtil.isPatternMatched"
            hd2 r2 = defpackage.hd2.B     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzbze r2 = r2.g     // Catch: java.lang.Throwable -> L20
            r2.zzw(r0, r1)     // Catch: java.lang.Throwable -> L20
        L2c:
            boolean r0 = r4.zzy()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L46
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzeP     // Catch: java.lang.Throwable -> L20
            n42 r1 = defpackage.n42.d     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzbbu r1 = r1.c     // Catch: java.lang.Throwable -> L20
            java.lang.Object r0 = r1.zza(r0)     // Catch: java.lang.Throwable -> L20
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L20
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L20
            if (r0 != 0) goto L46
        L44:
            monitor-exit(r4)
            return
        L46:
            com.google.android.gms.internal.ads.zzfdq r0 = new com.google.android.gms.internal.ads.zzfdq     // Catch: java.lang.Throwable -> L20
            r1 = 0
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L20
            r4.zzd = r1     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzfdy r1 = r4.zza     // Catch: java.lang.Throwable -> L20
            r2 = 1
            r1.zzj(r2)     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzfdy r1 = r4.zza     // Catch: java.lang.Throwable -> L20
            tb2 r2 = r5.zza     // Catch: java.lang.Throwable -> L20
            java.lang.String r5 = r5.zzb     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzfeg r3 = new com.google.android.gms.internal.ads.zzfeg     // Catch: java.lang.Throwable -> L20
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L20
            r1.zzb(r2, r5, r0, r3)     // Catch: java.lang.Throwable -> L20
            monitor-exit(r4)
            return
        L64:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L20
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfei.zzg(com.google.android.gms.internal.ads.zzbvu):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final void zzh() {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final synchronized void zzi(he0 he0Var) {
        hg0.g("pause must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzn().zzb(he0Var == null ? null : (Context) gy0.r(he0Var));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final void zzj() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final synchronized void zzk(he0 he0Var) {
        hg0.g("resume must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzn().zzc(he0Var == null ? null : (Context) gy0.r(he0Var));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final void zzl(b62 b62Var) {
        hg0.g("setAdMetadataListener can only be called from the UI thread.");
        if (b62Var == null) {
            this.zzb.zzg(null);
        } else {
            this.zzb.zzg(new zzfeh(this, b62Var));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final synchronized void zzm(String str) {
        hg0.g("#008 Must be called on the main UI thread.: setCustomData");
        this.zzc.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final synchronized void zzn(boolean z) {
        hg0.g("setImmersiveMode must be called on the main UI thread.");
        this.zze = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final void zzo(zzbvt zzbvtVar) {
        hg0.g("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzm(zzbvtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final synchronized void zzp(String str) {
        hg0.g("setUserId must be called on the main UI thread.");
        this.zzc.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final synchronized void zzq() {
        zzr(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final synchronized void zzr(he0 he0Var) {
        try {
            hg0.g("showAd must be called on the main UI thread.");
            if (this.zzd != null) {
                Activity activity = null;
                if (he0Var != null) {
                    Object objR = gy0.r(he0Var);
                    if (objR instanceof Activity) {
                        activity = (Activity) objR;
                    }
                }
                this.zzd.zzh(this.zze, activity);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final boolean zzs() {
        hg0.g("isLoaded must be called on the main UI thread.");
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final boolean zzt() {
        zzdop zzdopVar = this.zzd;
        return zzdopVar != null && zzdopVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbvq
    public final void zzu(zzbvo zzbvoVar) {
        hg0.g("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzn(zzbvoVar);
    }
}
