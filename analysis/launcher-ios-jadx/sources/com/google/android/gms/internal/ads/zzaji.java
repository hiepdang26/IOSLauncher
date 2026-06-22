package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaji {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzek zzg = new zzek(255);

    public final void zza() {
        this.zza = 0;
        this.zzb = 0L;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzacl zzaclVar, boolean z) throws zzbo {
        zza();
        this.zzg.zzH(27);
        if (zzaco.zzc(zzaclVar, this.zzg.zzM(), 0, 27, z) && this.zzg.zzu() == 1332176723) {
            if (this.zzg.zzm() != 0) {
                if (z) {
                    return false;
                }
                throw zzbo.zzc("unsupported bit stream revision");
            }
            this.zza = this.zzg.zzm();
            this.zzb = this.zzg.zzr();
            this.zzg.zzs();
            this.zzg.zzs();
            this.zzg.zzs();
            int iZzm = this.zzg.zzm();
            this.zzc = iZzm;
            this.zzd = iZzm + 27;
            this.zzg.zzH(iZzm);
            if (zzaco.zzc(zzaclVar, this.zzg.zzM(), 0, this.zzc, z)) {
                for (int i = 0; i < this.zzc; i++) {
                    this.zzf[i] = this.zzg.zzm();
                    this.zze += this.zzf[i];
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (r10 == (-1)) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        if (r9.zzf() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        if (r9.zzc(1) != (-1)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzacl r9, long r10) throws java.io.EOFException, java.io.InterruptedIOException {
        /*
            r8 = this;
            long r0 = r9.zzf()
            long r2 = r9.zze()
            r4 = 0
            r5 = 1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            com.google.android.gms.internal.ads.zzdi.zzd(r0)
            com.google.android.gms.internal.ads.zzek r0 = r8.zzg
            r1 = 4
            r0.zzH(r1)
        L1a:
            r2 = -1
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 == 0) goto L2c
            long r2 = r9.zzf()
            r6 = 4
            long r2 = r2 + r6
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 < 0) goto L2c
            goto L55
        L2c:
            com.google.android.gms.internal.ads.zzek r2 = r8.zzg
            byte[] r2 = r2.zzM()
            boolean r2 = com.google.android.gms.internal.ads.zzaco.zzc(r9, r2, r4, r1, r5)
            if (r2 == 0) goto L55
            com.google.android.gms.internal.ads.zzek r0 = r8.zzg
            r0.zzK(r4)
            com.google.android.gms.internal.ads.zzek r0 = r8.zzg
            long r2 = r0.zzu()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L51
            r0 = r9
            com.google.android.gms.internal.ads.zzaby r0 = (com.google.android.gms.internal.ads.zzaby) r0
            r0.zzo(r5, r4)
            goto L1a
        L51:
            r9.zzj()
            return r5
        L55:
            if (r0 == 0) goto L5f
            long r1 = r9.zzf()
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 >= 0) goto L66
        L5f:
            int r1 = r9.zzc(r5)
            r2 = -1
            if (r1 != r2) goto L55
        L66:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaji.zzc(com.google.android.gms.internal.ads.zzacl, long):boolean");
    }
}
