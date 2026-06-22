package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: loaded from: classes.dex */
final class zzhv implements zzkg {
    private final zzlm zza;
    private final zzhu zzb;
    private zzle zzc;
    private zzkg zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzhv(zzhu zzhuVar, zzdj zzdjVar) {
        this.zzb = zzhuVar;
        this.zza = new zzlm(zzdjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final long zza() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzb(boolean r6) {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzle r0 = r5.zzc
            if (r0 == 0) goto L71
            boolean r0 = r0.zzW()
            if (r0 != 0) goto L71
            if (r6 == 0) goto L15
            com.google.android.gms.internal.ads.zzle r0 = r5.zzc
            int r0 = r0.zzcV()
            r1 = 2
            if (r0 != r1) goto L71
        L15:
            com.google.android.gms.internal.ads.zzle r0 = r5.zzc
            boolean r0 = r0.zzX()
            if (r0 != 0) goto L28
            if (r6 != 0) goto L71
            com.google.android.gms.internal.ads.zzle r6 = r5.zzc
            boolean r6 = r6.zzQ()
            if (r6 == 0) goto L28
            goto L71
        L28:
            com.google.android.gms.internal.ads.zzkg r6 = r5.zzd
            r6.getClass()
            long r0 = r6.zza()
            boolean r2 = r5.zze
            if (r2 == 0) goto L51
            com.google.android.gms.internal.ads.zzlm r2 = r5.zza
            long r2 = r2.zza()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L45
            com.google.android.gms.internal.ads.zzlm r6 = r5.zza
            r6.zze()
            goto L7d
        L45:
            r2 = 0
            r5.zze = r2
            boolean r2 = r5.zzf
            if (r2 == 0) goto L51
            com.google.android.gms.internal.ads.zzlm r2 = r5.zza
            r2.zzd()
        L51:
            com.google.android.gms.internal.ads.zzlm r2 = r5.zza
            r2.zzb(r0)
            com.google.android.gms.internal.ads.zzbq r6 = r6.zzc()
            com.google.android.gms.internal.ads.zzlm r0 = r5.zza
            com.google.android.gms.internal.ads.zzbq r0 = r0.zzc()
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L7d
            com.google.android.gms.internal.ads.zzlm r0 = r5.zza
            r0.zzg(r6)
            com.google.android.gms.internal.ads.zzhu r0 = r5.zzb
            r0.zza(r6)
            goto L7d
        L71:
            r6 = 1
            r5.zze = r6
            boolean r6 = r5.zzf
            if (r6 == 0) goto L7d
            com.google.android.gms.internal.ads.zzlm r6 = r5.zza
            r6.zzd()
        L7d:
            boolean r6 = r5.zze
            if (r6 == 0) goto L88
            com.google.android.gms.internal.ads.zzlm r6 = r5.zza
            long r0 = r6.zza()
            return r0
        L88:
            com.google.android.gms.internal.ads.zzkg r6 = r5.zzd
            r6.getClass()
            long r0 = r6.zza()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhv.zzb(boolean):long");
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final zzbq zzc() {
        zzkg zzkgVar = this.zzd;
        return zzkgVar != null ? zzkgVar.zzc() : this.zza.zzc();
    }

    public final void zzd(zzle zzleVar) {
        if (zzleVar == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzle zzleVar) throws zzhw {
        zzkg zzkgVar;
        zzkg zzkgVarZzk = zzleVar.zzk();
        if (zzkgVarZzk == null || zzkgVarZzk == (zzkgVar = this.zzd)) {
            return;
        }
        if (zzkgVar != null) {
            throw zzhw.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), zzbbc.zzq.zzf);
        }
        this.zzd = zzkgVarZzk;
        this.zzc = zzleVar;
        zzkgVarZzk.zzg(this.zza.zzc());
    }

    public final void zzf(long j) {
        this.zza.zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final void zzg(zzbq zzbqVar) {
        zzkg zzkgVar = this.zzd;
        if (zzkgVar != null) {
            zzkgVar.zzg(zzbqVar);
            zzbqVar = this.zzd.zzc();
        }
        this.zza.zzg(zzbqVar);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final boolean zzj() {
        if (this.zze) {
            return false;
        }
        zzkg zzkgVar = this.zzd;
        zzkgVar.getClass();
        return zzkgVar.zzj();
    }
}
