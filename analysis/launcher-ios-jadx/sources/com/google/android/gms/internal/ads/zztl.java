package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zztl implements zzvx {
    public final zzvx zza;
    final /* synthetic */ zztm zzb;
    private boolean zzc;

    public zztl(zztm zztmVar, zzvx zzvxVar) {
        this.zzb = zztmVar;
        this.zza = zzvxVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    @Override // com.google.android.gms.internal.ads.zzvx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(com.google.android.gms.internal.ads.zzjz r13, com.google.android.gms.internal.ads.zzhd r14, int r15) {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zztm r0 = r12.zzb
            boolean r1 = r0.zzq()
            r2 = -3
            if (r1 == 0) goto La
            return r2
        La:
            boolean r1 = r12.zzc
            r3 = 4
            r4 = -4
            if (r1 == 0) goto L14
            r14.zzc(r3)
            return r4
        L14:
            long r0 = r0.zzb()
            com.google.android.gms.internal.ads.zzvx r5 = r12.zza
            int r15 = r5.zza(r13, r14, r15)
            r5 = -5
            r6 = -9223372036854775808
            if (r15 != r5) goto L4e
            com.google.android.gms.internal.ads.zzaf r14 = r13.zza
            r14.getClass()
            int r15 = r14.zzC
            r0 = 0
            if (r15 != 0) goto L32
            int r15 = r14.zzD
            if (r15 == 0) goto L4d
            r15 = 0
        L32:
            com.google.android.gms.internal.ads.zztm r1 = r12.zzb
            long r1 = r1.zzb
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 == 0) goto L3b
            goto L3d
        L3b:
            int r0 = r14.zzD
        L3d:
            com.google.android.gms.internal.ads.zzad r14 = r14.zzb()
            r14.zzF(r15)
            r14.zzG(r0)
            com.google.android.gms.internal.ads.zzaf r14 = r14.zzad()
            r13.zza = r14
        L4d:
            return r5
        L4e:
            com.google.android.gms.internal.ads.zztm r13 = r12.zzb
            long r8 = r13.zzb
            int r13 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r13 == 0) goto L72
            if (r15 != r4) goto L5e
            long r10 = r14.zze
            int r13 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r13 >= 0) goto L68
        L5e:
            if (r15 != r2) goto L72
            int r13 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r13 != 0) goto L72
            boolean r13 = r14.zzd
            if (r13 != 0) goto L72
        L68:
            r14.zzb()
            r14.zzc(r3)
            r13 = 1
            r12.zzc = r13
            return r4
        L72:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztl.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzhd, int):int");
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final int zzb(long j) {
        if (this.zzb.zzq()) {
            return -3;
        }
        return this.zza.zzb(j);
    }

    public final void zzc() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final void zzd() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzvx
    public final boolean zze() {
        return !this.zzb.zzq() && this.zza.zze();
    }
}
