package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zztm implements zzug, zzuf {
    public final zzug zza;
    long zzb;
    private zzuf zzc;
    private zztl[] zzd = new zztl[0];
    private long zze = 0;

    public zztm(zzug zzugVar, boolean z, long j, long j2) {
        this.zza = zzugVar;
        this.zzb = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zza(long j, zzlj zzljVar) {
        if (j == 0) {
            return 0L;
        }
        long jMax = Math.max(0L, Math.min(zzljVar.zzc, j));
        long j2 = zzljVar.zzd;
        long j3 = this.zzb;
        long jMax2 = Math.max(0L, Math.min(j2, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j));
        if (jMax != zzljVar.zzc || jMax2 != zzljVar.zzd) {
            zzljVar = new zzlj(jMax, jMax2);
        }
        return this.zza.zza(j, zzljVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzb < j) {
                return jZzb;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzc < j) {
                return jZzc;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzd() {
        if (zzq()) {
            long j = this.zze;
            this.zze = -9223372036854775807L;
            long jZzd = zzd();
            return jZzd != -9223372036854775807L ? jZzd : j;
        }
        long jZzd2 = this.zza.zzd();
        if (jZzd2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        zzdi.zzf(jZzd2 >= 0);
        long j2 = this.zzb;
        zzdi.zzf(j2 == Long.MIN_VALUE || jZzd2 <= j2);
        return jZzd2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    @Override // com.google.android.gms.internal.ads.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zze(long r8) {
        /*
            r7 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zze = r0
            com.google.android.gms.internal.ads.zztl[] r0 = r7.zzd
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.zzc()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.google.android.gms.internal.ads.zzug r0 = r7.zza
            long r0 = r0.zze(r8)
            r3 = 1
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 == 0) goto L35
            r8 = 0
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 < 0) goto L36
            long r8 = r7.zzb
            r4 = -9223372036854775808
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L35
            int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r4 > 0) goto L36
        L35:
            r2 = 1
        L36:
            com.google.android.gms.internal.ads.zzdi.zzf(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztm.zze(long):long");
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final /* bridge */ /* synthetic */ void zzf(zzvz zzvzVar) {
        zzuf zzufVar = this.zzc;
        zzufVar.getClass();
        zzufVar.zzf(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    @Override // com.google.android.gms.internal.ads.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzg(com.google.android.gms.internal.ads.zzxv[] r14, boolean[] r15, com.google.android.gms.internal.ads.zzvx[] r16, boolean[] r17, long r18) {
        /*
            r13 = this;
            r0 = r16
            int r1 = r0.length
            com.google.android.gms.internal.ads.zztl[] r2 = new com.google.android.gms.internal.ads.zztl[r1]
            r13.zzd = r2
            com.google.android.gms.internal.ads.zzvx[] r6 = new com.google.android.gms.internal.ads.zzvx[r1]
            r1 = 0
            r2 = 0
        Lb:
            int r3 = r0.length
            r10 = 0
            if (r2 >= r3) goto L20
            com.google.android.gms.internal.ads.zztl[] r3 = r13.zzd
            r4 = r0[r2]
            com.google.android.gms.internal.ads.zztl r4 = (com.google.android.gms.internal.ads.zztl) r4
            r3[r2] = r4
            if (r4 == 0) goto L1b
            com.google.android.gms.internal.ads.zzvx r10 = r4.zza
        L1b:
            r6[r2] = r10
            int r2 = r2 + 1
            goto Lb
        L20:
            com.google.android.gms.internal.ads.zzug r3 = r13.zza
            r4 = r14
            r5 = r15
            r7 = r17
            r8 = r18
            long r14 = r3.zzg(r4, r5, r6, r7, r8)
            boolean r2 = r13.zzq()
            r3 = 0
            if (r2 == 0) goto L3a
            int r2 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
            if (r2 != 0) goto L3a
            r7 = r3
            goto L3c
        L3a:
            r7 = r18
        L3c:
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r13.zze = r11
            r2 = 1
            int r5 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r5 == 0) goto L5a
            int r5 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r5 < 0) goto L59
            long r3 = r13.zzb
            r7 = -9223372036854775808
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 == 0) goto L5a
            int r5 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r5 > 0) goto L59
            goto L5a
        L59:
            r2 = 0
        L5a:
            com.google.android.gms.internal.ads.zzdi.zzf(r2)
        L5d:
            int r2 = r0.length
            if (r1 >= r2) goto L83
            r2 = r6[r1]
            if (r2 != 0) goto L69
            com.google.android.gms.internal.ads.zztl[] r2 = r13.zzd
            r2[r1] = r10
            goto L7a
        L69:
            com.google.android.gms.internal.ads.zztl[] r3 = r13.zzd
            r4 = r3[r1]
            if (r4 == 0) goto L73
            com.google.android.gms.internal.ads.zzvx r4 = r4.zza
            if (r4 == r2) goto L7a
        L73:
            com.google.android.gms.internal.ads.zztl r4 = new com.google.android.gms.internal.ads.zztl
            r4.<init>(r13, r2)
            r3[r1] = r4
        L7a:
            com.google.android.gms.internal.ads.zztl[] r2 = r13.zzd
            r2 = r2[r1]
            r0[r1] = r2
            int r1 = r1 + 1
            goto L5d
        L83:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztm.zzg(com.google.android.gms.internal.ads.zzxv[], boolean[], com.google.android.gms.internal.ads.zzvx[], boolean[], long):long");
    }

    @Override // com.google.android.gms.internal.ads.zzuf
    public final void zzh(zzug zzugVar) {
        zzuf zzufVar = this.zzc;
        zzufVar.getClass();
        zzufVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final zzwi zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzj(long j, boolean z) {
        this.zza.zzj(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzk() {
        this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzl(zzuf zzufVar, long j) {
        this.zzc = zzufVar;
        this.zza.zzl(this, j);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final void zzm(long j) {
        this.zza.zzm(j);
    }

    public final void zzn(long j, long j2) {
        this.zzb = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzo(zzkf zzkfVar) {
        return this.zza.zzo(zzkfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzp() {
        return this.zza.zzp();
    }

    public final boolean zzq() {
        return this.zze != -9223372036854775807L;
    }
}
