package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzud extends zzwk {
    private final boolean zzb;
    private final zzcb zzc;
    private final zzca zzd;
    private zzub zze;
    private zzua zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzud(zzuk zzukVar, boolean z) {
        boolean z2;
        super(zzukVar);
        if (z) {
            zzukVar.zzv();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzcb();
        this.zzd = new zzca();
        zzukVar.zzM();
        this.zze = zzub.zzq(zzukVar.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zze == null || !obj.equals(zzub.zzc)) ? obj : this.zze.zze;
    }

    private final boolean zzL(long j) {
        zzua zzuaVar = this.zzf;
        int iZza = this.zze.zza(zzuaVar.zza.zza);
        if (iZza == -1) {
            return false;
        }
        zzub zzubVar = this.zze;
        zzca zzcaVar = this.zzd;
        zzubVar.zzd(iZza, zzcaVar, false);
        long j2 = zzcaVar.zzd;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        zzuaVar.zzs(j);
        return true;
    }

    public final zzcc zzC() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final zzui zzD(zzui zzuiVar) {
        Object obj = this.zze.zze;
        Object obj2 = zzuiVar.zza;
        if (obj != null && this.zze.zze.equals(obj2)) {
            obj2 = zzub.zzc;
        }
        return zzuiVar.zza(obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    @Override // com.google.android.gms.internal.ads.zzwk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzE(com.google.android.gms.internal.ads.zzcc r15) {
        /*
            r14 = this;
            boolean r0 = r14.zzh
            r1 = 0
            if (r0 == 0) goto L1a
            com.google.android.gms.internal.ads.zzub r0 = r14.zze
            com.google.android.gms.internal.ads.zzub r15 = r0.zzp(r15)
            r14.zze = r15
            com.google.android.gms.internal.ads.zzua r15 = r14.zzf
            if (r15 == 0) goto L9e
            long r2 = r15.zzn()
            r14.zzL(r2)
            goto L9e
        L1a:
            boolean r0 = r15.zzo()
            if (r0 == 0) goto L36
            boolean r0 = r14.zzi
            if (r0 == 0) goto L2b
            com.google.android.gms.internal.ads.zzub r0 = r14.zze
            com.google.android.gms.internal.ads.zzub r15 = r0.zzp(r15)
            goto L33
        L2b:
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzcb.zza
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzub.zzc
            com.google.android.gms.internal.ads.zzub r15 = com.google.android.gms.internal.ads.zzub.zzr(r15, r0, r2)
        L33:
            r14.zze = r15
            goto L9e
        L36:
            com.google.android.gms.internal.ads.zzcb r0 = r14.zzc
            r2 = 0
            r3 = 0
            r15.zze(r2, r0, r3)
            com.google.android.gms.internal.ads.zzcb r0 = r14.zzc
            java.lang.Object r0 = r0.zzb
            com.google.android.gms.internal.ads.zzua r5 = r14.zzf
            if (r5 == 0) goto L62
            long r6 = r5.zzq()
            com.google.android.gms.internal.ads.zzub r8 = r14.zze
            com.google.android.gms.internal.ads.zzca r9 = r14.zzd
            com.google.android.gms.internal.ads.zzui r5 = r5.zza
            java.lang.Object r5 = r5.zza
            r8.zzn(r5, r9)
            com.google.android.gms.internal.ads.zzub r5 = r14.zze
            com.google.android.gms.internal.ads.zzcb r8 = r14.zzc
            r5.zze(r2, r8, r3)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto L62
            r12 = r6
            goto L63
        L62:
            r12 = r3
        L63:
            com.google.android.gms.internal.ads.zzcb r9 = r14.zzc
            com.google.android.gms.internal.ads.zzca r10 = r14.zzd
            r11 = 0
            r8 = r15
            android.util.Pair r15 = r8.zzl(r9, r10, r11, r12)
            java.lang.Object r2 = r15.first
            java.lang.Object r15 = r15.second
            java.lang.Long r15 = (java.lang.Long) r15
            long r3 = r15.longValue()
            boolean r15 = r14.zzi
            if (r15 == 0) goto L82
            com.google.android.gms.internal.ads.zzub r15 = r14.zze
            com.google.android.gms.internal.ads.zzub r15 = r15.zzp(r8)
            goto L86
        L82:
            com.google.android.gms.internal.ads.zzub r15 = com.google.android.gms.internal.ads.zzub.zzr(r8, r0, r2)
        L86:
            r14.zze = r15
            com.google.android.gms.internal.ads.zzua r15 = r14.zzf
            if (r15 == 0) goto L9e
            boolean r0 = r14.zzL(r3)
            if (r0 == 0) goto L9e
            com.google.android.gms.internal.ads.zzui r15 = r15.zza
            java.lang.Object r0 = r15.zza
            java.lang.Object r0 = r14.zzK(r0)
            com.google.android.gms.internal.ads.zzui r1 = r15.zza(r0)
        L9e:
            r15 = 1
            r14.zzi = r15
            r14.zzh = r15
            com.google.android.gms.internal.ads.zzub r15 = r14.zze
            r14.zzo(r15)
            if (r1 == 0) goto Lb2
            com.google.android.gms.internal.ads.zzua r15 = r14.zzf
            r15.getClass()
            r15.zzr(r1)
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzud.zzE(com.google.android.gms.internal.ads.zzcc):void");
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzF() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzB(null, ((zzwk) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzwk, com.google.android.gms.internal.ads.zzuk
    public final void zzG(zzug zzugVar) {
        ((zzua) zzugVar).zzt();
        if (zzugVar == this.zzf) {
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwk, com.google.android.gms.internal.ads.zzuk
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final zzua zzI(zzui zzuiVar, zzyk zzykVar, long j) {
        zzua zzuaVar = new zzua(zzuiVar, zzykVar, j);
        zzuaVar.zzu(((zzwk) this).zza);
        if (this.zzh) {
            zzuaVar.zzr(zzuiVar.zza(zzK(zzuiVar.zza)));
            return zzuaVar;
        }
        this.zzf = zzuaVar;
        if (!this.zzg) {
            this.zzg = true;
            zzB(null, ((zzwk) this).zza);
        }
        return zzuaVar;
    }

    @Override // com.google.android.gms.internal.ads.zztq, com.google.android.gms.internal.ads.zzth
    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzth, com.google.android.gms.internal.ads.zzuk
    public final void zzt(zzbc zzbcVar) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzwg(this.zze.zzb, zzbcVar));
        } else {
            this.zze = zzub.zzq(zzbcVar);
        }
        ((zzwk) this).zza.zzt(zzbcVar);
    }

    @Override // com.google.android.gms.internal.ads.zztq, com.google.android.gms.internal.ads.zzuk
    public final void zzz() {
    }
}
