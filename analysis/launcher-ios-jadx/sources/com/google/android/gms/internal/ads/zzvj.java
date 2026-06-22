package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzbbc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzvj implements zzug, zzacn, zzyp, zzyu, zzvv {
    private static final Map zzb;
    private static final zzaf zzc;
    private zzadi zzA;
    private long zzB;
    private boolean zzC;
    private boolean zzE;
    private boolean zzF;
    private int zzG;
    private boolean zzH;
    private long zzI;
    private boolean zzK;
    private int zzL;
    private boolean zzM;
    private boolean zzN;
    private final zzyk zzO;
    private final Uri zzd;
    private final zzfs zze;
    private final zzri zzf;
    private final zzur zzg;
    private final zzrd zzh;
    private final zzvf zzi;
    private final long zzj;
    private final long zzk;
    private final zzuy zzm;
    private zzuf zzr;
    private zzafn zzs;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private zzvi zzz;
    private final zzyx zzl = new zzyx("ProgressiveMediaPeriod");
    private final zzdm zzn = new zzdm(zzdj.zza);
    private final Runnable zzo = new Runnable() { // from class: com.google.android.gms.internal.ads.zzva
        @Override // java.lang.Runnable
        public final void run() {
            this.zza.zzU();
        }
    };
    private final Runnable zzp = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvb
        @Override // java.lang.Runnable
        public final void run() {
            this.zza.zzE();
        }
    };
    private final Handler zzq = zzet.zzx(null);
    private zzvh[] zzu = new zzvh[0];
    private zzvw[] zzt = new zzvw[0];
    private long zzJ = -9223372036854775807L;
    private int zzD = 1;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        zzb = Collections.unmodifiableMap(map);
        zzad zzadVar = new zzad();
        zzadVar.zzK("icy");
        zzadVar.zzX("application/x-icy");
        zzc = zzadVar.zzad();
    }

    public zzvj(Uri uri, zzfs zzfsVar, zzuy zzuyVar, zzri zzriVar, zzrd zzrdVar, zzyo zzyoVar, zzur zzurVar, zzvf zzvfVar, zzyk zzykVar, String str, int i, long j) {
        this.zzd = uri;
        this.zze = zzfsVar;
        this.zzf = zzriVar;
        this.zzh = zzrdVar;
        this.zzg = zzurVar;
        this.zzi = zzvfVar;
        this.zzO = zzykVar;
        this.zzj = i;
        this.zzm = zzuyVar;
        this.zzk = j;
    }

    public static /* bridge */ /* synthetic */ void zzC(final zzvj zzvjVar) {
        zzvjVar.zzq.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzuz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzF();
            }
        });
    }

    private final int zzQ() {
        int iZzd = 0;
        for (zzvw zzvwVar : this.zzt) {
            iZzd += zzvwVar.zzd();
        }
        return iZzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long zzR(boolean r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = -9223372036854775808
        L3:
            com.google.android.gms.internal.ads.zzvw[] r3 = r5.zzt
            int r4 = r3.length
            if (r0 >= r4) goto L22
            if (r6 != 0) goto L15
            com.google.android.gms.internal.ads.zzvi r4 = r5.zzz
            r4.getClass()
            boolean[] r4 = r4.zzc
            boolean r4 = r4[r0]
            if (r4 == 0) goto L1f
        L15:
            r3 = r3[r0]
            long r3 = r3.zzh()
            long r1 = java.lang.Math.max(r1, r3)
        L1f:
            int r0 = r0 + 1
            goto L3
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.zzR(boolean):long");
    }

    private final zzadp zzS(zzvh zzvhVar) {
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            if (zzvhVar.equals(this.zzu[i])) {
                return this.zzt[i];
            }
        }
        zzvw zzvwVar = new zzvw(this.zzO, this.zzf, this.zzh);
        zzvwVar.zzu(this);
        int i2 = length + 1;
        zzvh[] zzvhVarArr = (zzvh[]) Arrays.copyOf(this.zzu, i2);
        zzvhVarArr[length] = zzvhVar;
        int i3 = zzet.zza;
        this.zzu = zzvhVarArr;
        zzvw[] zzvwVarArr = (zzvw[]) Arrays.copyOf(this.zzt, i2);
        zzvwVarArr[length] = zzvwVar;
        this.zzt = zzvwVarArr;
        return zzvwVar;
    }

    private final void zzT() {
        zzdi.zzf(this.zzw);
        this.zzz.getClass();
        this.zzA.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzU() {
        int i;
        if (this.zzN || this.zzw || !this.zzv || this.zzA == null) {
            return;
        }
        for (zzvw zzvwVar : this.zzt) {
            if (zzvwVar.zzi() == null) {
                return;
            }
        }
        this.zzn.zzc();
        int length = this.zzt.length;
        zzcd[] zzcdVarArr = new zzcd[length];
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzaf zzafVarZzi = this.zzt[i2].zzi();
            zzafVarZzi.getClass();
            String str = zzafVarZzi.zzm;
            boolean zZzg = zzbn.zzg(str);
            boolean z = zZzg || zzbn.zzi(str);
            zArr[i2] = z;
            this.zzx = z | this.zzx;
            this.zzy = this.zzk != -9223372036854775807L && length == 1 && zzbn.zzh(str);
            zzafn zzafnVar = this.zzs;
            if (zzafnVar != null) {
                if (zZzg || this.zzu[i2].zzb) {
                    zzbk zzbkVar = zzafVarZzi.zzk;
                    zzbk zzbkVar2 = zzbkVar == null ? new zzbk(-9223372036854775807L, zzafnVar) : zzbkVar.zzc(zzafnVar);
                    zzad zzadVarZzb = zzafVarZzi.zzb();
                    zzadVarZzb.zzQ(zzbkVar2);
                    zzafVarZzi = zzadVarZzb.zzad();
                }
                if (zZzg && zzafVarZzi.zzg == -1 && zzafVarZzi.zzh == -1 && (i = zzafnVar.zza) != -1) {
                    zzad zzadVarZzb2 = zzafVarZzi.zzb();
                    zzadVarZzb2.zzx(i);
                    zzafVarZzi = zzadVarZzb2.zzad();
                }
            }
            zzcdVarArr[i2] = new zzcd(Integer.toString(i2), zzafVarZzi.zzc(this.zzf.zza(zzafVarZzi)));
        }
        this.zzz = new zzvi(new zzwi(zzcdVarArr), zArr);
        if (this.zzy && this.zzB == -9223372036854775807L) {
            this.zzB = this.zzk;
            this.zzA = new zzvd(this, this.zzA);
        }
        this.zzi.zza(this.zzB, this.zzA.zzh(), this.zzC);
        this.zzw = true;
        zzuf zzufVar = this.zzr;
        zzufVar.getClass();
        zzufVar.zzh(this);
    }

    private final void zzV(int i) {
        zzT();
        zzvi zzviVar = this.zzz;
        boolean[] zArr = zzviVar.zzd;
        if (zArr[i]) {
            return;
        }
        zzaf zzafVarZzb = zzviVar.zza.zzb(i).zzb(0);
        this.zzg.zzc(new zzue(1, zzbn.zzb(zzafVarZzb.zzm), zzafVarZzb, 0, null, zzet.zzu(this.zzI), -9223372036854775807L));
        zArr[i] = true;
    }

    private final void zzW(int i) {
        zzT();
        boolean[] zArr = this.zzz.zzb;
        if (this.zzK && zArr[i] && !this.zzt[i].zzx(false)) {
            this.zzJ = 0L;
            this.zzK = false;
            this.zzF = true;
            this.zzI = 0L;
            this.zzL = 0;
            for (zzvw zzvwVar : this.zzt) {
                zzvwVar.zzp(false);
            }
            zzuf zzufVar = this.zzr;
            zzufVar.getClass();
            zzufVar.zzf(this);
        }
    }

    private final void zzX() {
        zzve zzveVar = new zzve(this, this.zzd, this.zze, this.zzm, this, this.zzn);
        if (this.zzw) {
            zzdi.zzf(zzY());
            long j = this.zzB;
            if (j != -9223372036854775807L && this.zzJ > j) {
                this.zzM = true;
                this.zzJ = -9223372036854775807L;
                return;
            }
            zzadi zzadiVar = this.zzA;
            zzadiVar.getClass();
            zzve.zzf(zzveVar, zzadiVar.zzg(this.zzJ).zza.zzc, this.zzJ);
            for (zzvw zzvwVar : this.zzt) {
                zzvwVar.zzt(this.zzJ);
            }
            this.zzJ = -9223372036854775807L;
        }
        this.zzL = zzQ();
        long jZza = this.zzl.zza(zzveVar, this, zzyo.zza(this.zzD));
        this.zzg.zzg(new zztz(zzveVar.zzb, zzveVar.zzl, jZza), new zzue(1, -1, null, 0, null, zzet.zzu(zzveVar.zzk), zzet.zzu(this.zzB)));
    }

    private final boolean zzY() {
        return this.zzJ != -9223372036854775807L;
    }

    private final boolean zzZ() {
        return this.zzF || zzY();
    }

    public static /* bridge */ /* synthetic */ long zzr(zzvj zzvjVar, boolean z) {
        return zzvjVar.zzR(true);
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final void zzD() {
        this.zzv = true;
        this.zzq.post(this.zzo);
    }

    public final /* synthetic */ void zzE() {
        if (this.zzN) {
            return;
        }
        zzuf zzufVar = this.zzr;
        zzufVar.getClass();
        zzufVar.zzf(this);
    }

    public final /* synthetic */ void zzF() {
        this.zzH = true;
    }

    public final /* synthetic */ void zzG(zzadi zzadiVar) {
        this.zzA = this.zzs == null ? zzadiVar : new zzadh(-9223372036854775807L, 0L);
        this.zzB = zzadiVar.zza();
        boolean z = false;
        if (!this.zzH && zzadiVar.zza() == -9223372036854775807L) {
            z = true;
        }
        this.zzC = z;
        this.zzD = true == z ? 7 : 1;
        if (this.zzw) {
            this.zzi.zza(this.zzB, zzadiVar.zzh(), this.zzC);
        } else {
            zzU();
        }
    }

    public final void zzH() throws IOException {
        this.zzl.zzi(zzyo.zza(this.zzD));
    }

    public final void zzI(int i) {
        this.zzt[i].zzm();
        zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ void zzJ(zzyt zzytVar, long j, long j2, boolean z) {
        zzve zzveVar = (zzve) zzytVar;
        zzgt zzgtVar = zzveVar.zzd;
        zztz zztzVar = new zztz(zzveVar.zzb, zzveVar.zzl, zzgtVar.zzh(), zzgtVar.zzi(), j, j2, zzgtVar.zzg());
        long unused = zzveVar.zzb;
        this.zzg.zzd(zztzVar, new zzue(1, -1, null, 0, null, zzet.zzu(zzveVar.zzk), zzet.zzu(this.zzB)));
        if (z) {
            return;
        }
        for (zzvw zzvwVar : this.zzt) {
            zzvwVar.zzp(false);
        }
        if (this.zzG > 0) {
            zzuf zzufVar = this.zzr;
            zzufVar.getClass();
            zzufVar.zzf(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ void zzK(zzyt zzytVar, long j, long j2) {
        zzadi zzadiVar;
        if (this.zzB == -9223372036854775807L && (zzadiVar = this.zzA) != null) {
            boolean zZzh = zzadiVar.zzh();
            long jZzR = zzR(true);
            long j3 = jZzR == Long.MIN_VALUE ? 0L : jZzR + 10000;
            this.zzB = j3;
            this.zzi.zza(j3, zZzh, this.zzC);
        }
        zzve zzveVar = (zzve) zzytVar;
        zzgt zzgtVar = zzveVar.zzd;
        zztz zztzVar = new zztz(zzveVar.zzb, zzveVar.zzl, zzgtVar.zzh(), zzgtVar.zzi(), j, j2, zzgtVar.zzg());
        long unused = zzveVar.zzb;
        this.zzg.zze(zztzVar, new zzue(1, -1, null, 0, null, zzet.zzu(zzveVar.zzk), zzet.zzu(this.zzB)));
        this.zzM = true;
        zzuf zzufVar = this.zzr;
        zzufVar.getClass();
        zzufVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.ads.zzyu
    public final void zzL() {
        for (zzvw zzvwVar : this.zzt) {
            zzvwVar.zzo();
        }
        this.zzm.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzvv
    public final void zzM(zzaf zzafVar) {
        this.zzq.post(this.zzo);
    }

    public final void zzN() {
        if (this.zzw) {
            for (zzvw zzvwVar : this.zzt) {
                zzvwVar.zzn();
            }
        }
        this.zzl.zzj(this);
        this.zzq.removeCallbacksAndMessages(null);
        this.zzr = null;
        this.zzN = true;
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final void zzO(final zzadi zzadiVar) {
        this.zzq.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvc
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzG(zzadiVar);
            }
        });
    }

    public final boolean zzP(int i) {
        return !zzZ() && this.zzt[i].zzx(this.zzM);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0084 A[RETURN] */
    @Override // com.google.android.gms.internal.ads.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zza(long r23, com.google.android.gms.internal.ads.zzlj r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r3 = r25
            r0.zzT()
            com.google.android.gms.internal.ads.zzadi r4 = r0.zzA
            boolean r4 = r4.zzh()
            r5 = 0
            if (r4 != 0) goto L14
            return r5
        L14:
            com.google.android.gms.internal.ads.zzadi r4 = r0.zzA
            com.google.android.gms.internal.ads.zzadg r4 = r4.zzg(r1)
            com.google.android.gms.internal.ads.zzadj r7 = r4.zza
            com.google.android.gms.internal.ads.zzadj r4 = r4.zzb
            long r8 = r3.zzc
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 != 0) goto L2c
            long r8 = r3.zzd
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 != 0) goto L2b
            return r1
        L2b:
            r8 = r5
        L2c:
            long r10 = r7.zzb
            int r7 = com.google.android.gms.internal.ads.zzet.zza
            long r12 = r1 - r8
            long r8 = r8 ^ r1
            long r14 = r1 ^ r12
            r16 = r5
            long r5 = r3.zzd
            long r18 = r1 + r5
            long r20 = r1 ^ r18
            long r5 = r5 ^ r18
            long r8 = r8 & r14
            int r3 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r3 >= 0) goto L46
            r12 = -9223372036854775808
        L46:
            long r5 = r20 & r5
            int r3 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r3 >= 0) goto L51
            r18 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L51:
            r3 = 1
            r5 = 0
            int r6 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r6 > 0) goto L5d
            int r6 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r6 > 0) goto L5d
            r6 = 1
            goto L5e
        L5d:
            r6 = 0
        L5e:
            long r7 = r4.zzb
            int r4 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r4 > 0) goto L69
            int r4 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r4 > 0) goto L69
            goto L6a
        L69:
            r3 = 0
        L6a:
            if (r6 == 0) goto L7f
            if (r3 == 0) goto L7f
            long r3 = r10 - r1
            long r1 = r7 - r1
            long r3 = java.lang.Math.abs(r3)
            long r1 = java.lang.Math.abs(r1)
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L84
            goto L81
        L7f:
            if (r6 == 0) goto L82
        L81:
            return r10
        L82:
            if (r3 == 0) goto L85
        L84:
            return r7
        L85:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.zza(long, com.google.android.gms.internal.ads.zzlj):long");
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzb() {
        long jZzR;
        zzT();
        if (this.zzM || this.zzG == 0) {
            return Long.MIN_VALUE;
        }
        if (zzY()) {
            return this.zzJ;
        }
        if (this.zzx) {
            int length = this.zzt.length;
            jZzR = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                zzvi zzviVar = this.zzz;
                if (zzviVar.zzb[i] && zzviVar.zzc[i] && !this.zzt[i].zzw()) {
                    jZzR = Math.min(jZzR, this.zzt[i].zzh());
                }
            }
        } else {
            jZzR = Long.MAX_VALUE;
        }
        if (jZzR == Long.MAX_VALUE) {
            jZzR = zzR(false);
        }
        return jZzR == Long.MIN_VALUE ? this.zzI : jZzR;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzc() {
        return zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzd() {
        if (!this.zzF) {
            return -9223372036854775807L;
        }
        if (!this.zzM && zzQ() <= this.zzL) {
            return -9223372036854775807L;
        }
        this.zzF = false;
        return this.zzI;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006f  */
    @Override // com.google.android.gms.internal.ads.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zze(long r7) {
        /*
            r6 = this;
            r6.zzT()
            com.google.android.gms.internal.ads.zzvi r0 = r6.zzz
            boolean[] r0 = r0.zzb
            com.google.android.gms.internal.ads.zzadi r1 = r6.zzA
            boolean r1 = r1.zzh()
            r2 = 1
            if (r2 == r1) goto L12
            r7 = 0
        L12:
            r1 = 0
            r6.zzF = r1
            r6.zzI = r7
            boolean r2 = r6.zzY()
            if (r2 == 0) goto L20
            r6.zzJ = r7
            return r7
        L20:
            int r2 = r6.zzD
            r3 = 7
            if (r2 == r3) goto L4e
            com.google.android.gms.internal.ads.zzvw[] r2 = r6.zzt
            int r2 = r2.length
            r3 = 0
        L29:
            if (r3 >= r2) goto L80
            com.google.android.gms.internal.ads.zzvw[] r4 = r6.zzt
            r4 = r4[r3]
            boolean r5 = r6.zzy
            if (r5 == 0) goto L3c
            int r5 = r4.zza()
            boolean r4 = r4.zzy(r5)
            goto L40
        L3c:
            boolean r4 = r4.zzz(r7, r1)
        L40:
            if (r4 != 0) goto L4b
            boolean r4 = r0[r3]
            if (r4 != 0) goto L4e
            boolean r4 = r6.zzx
            if (r4 != 0) goto L4b
            goto L4e
        L4b:
            int r3 = r3 + 1
            goto L29
        L4e:
            r6.zzK = r1
            r6.zzJ = r7
            r6.zzM = r1
            com.google.android.gms.internal.ads.zzyx r0 = r6.zzl
            boolean r2 = r0.zzl()
            if (r2 == 0) goto L6f
            com.google.android.gms.internal.ads.zzvw[] r0 = r6.zzt
            int r2 = r0.length
        L5f:
            if (r1 >= r2) goto L69
            r3 = r0[r1]
            r3.zzk()
            int r1 = r1 + 1
            goto L5f
        L69:
            com.google.android.gms.internal.ads.zzyx r0 = r6.zzl
            r0.zzg()
            return r7
        L6f:
            r0.zzh()
            com.google.android.gms.internal.ads.zzvw[] r0 = r6.zzt
            int r2 = r0.length
            r3 = 0
        L76:
            if (r3 >= r2) goto L80
            r4 = r0[r3]
            r4.zzp(r1)
            int r3 = r3 + 1
            goto L76
        L80:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.zze(long):long");
    }

    public final int zzf(int i, zzjz zzjzVar, zzhd zzhdVar, int i2) {
        if (zzZ()) {
            return -3;
        }
        zzV(i);
        int iZze = this.zzt[i].zze(zzjzVar, zzhdVar, i2, this.zzM);
        if (iZze == -3) {
            zzW(i);
        }
        return iZze;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042 A[PHI: r12
  0x0042: PHI (r12v1 long) = (r12v0 long), (r12v5 long), (r12v0 long) binds: [B:14:0x0038, B:23:0x004b, B:17:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzg(com.google.android.gms.internal.ads.zzxv[] r8, boolean[] r9, com.google.android.gms.internal.ads.zzvx[] r10, boolean[] r11, long r12) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvj.zzg(com.google.android.gms.internal.ads.zzxv[], boolean[], com.google.android.gms.internal.ads.zzvx[], boolean[], long):long");
    }

    public final int zzh(int i, long j) {
        if (zzZ()) {
            return 0;
        }
        zzV(i);
        zzvw zzvwVar = this.zzt[i];
        int iZzc = zzvwVar.zzc(j, this.zzM);
        zzvwVar.zzv(iZzc);
        if (iZzc != 0) {
            return iZzc;
        }
        zzW(i);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final zzwi zzi() {
        zzT();
        return this.zzz.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzj(long j, boolean z) {
        if (this.zzy) {
            return;
        }
        zzT();
        if (zzY()) {
            return;
        }
        boolean[] zArr = this.zzz.zzc;
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            this.zzt[i].zzj(j, false, zArr[i]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzk() throws IOException {
        zzH();
        if (this.zzM && !this.zzw) {
            throw zzbo.zza("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzl(zzuf zzufVar, long j) {
        this.zzr = zzufVar;
        this.zzn.zze();
        zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final void zzm(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzo(zzkf zzkfVar) {
        if (this.zzM) {
            return false;
        }
        zzyx zzyxVar = this.zzl;
        if (zzyxVar.zzk() || this.zzK) {
            return false;
        }
        if (this.zzw && this.zzG == 0) {
            return false;
        }
        boolean zZze = this.zzn.zze();
        if (zzyxVar.zzl()) {
            return zZze;
        }
        zzX();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzp() {
        return this.zzl.zzl() && this.zzn.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final /* bridge */ /* synthetic */ zzyr zzu(zzyt zzytVar, long j, long j2, IOException iOException, int i) {
        long jMin;
        zzyr zzyrVarZzb;
        zzadi zzadiVar;
        zzve zzveVar = (zzve) zzytVar;
        zzgt zzgtVar = zzveVar.zzd;
        zztz zztzVar = new zztz(zzveVar.zzb, zzveVar.zzl, zzgtVar.zzh(), zzgtVar.zzi(), j, j2, zzgtVar.zzg());
        long unused = zzveVar.zzk;
        int i2 = zzet.zza;
        if ((iOException instanceof zzbo) || (iOException instanceof FileNotFoundException) || (iOException instanceof zzgk) || (iOException instanceof zzyw)) {
            jMin = -9223372036854775807L;
            break;
        }
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof zzft) && ((zzft) cause).zza == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i - 1) * zzbbc.zzq.zzf, 5000);
        if (jMin == -9223372036854775807L) {
            zzyrVarZzb = zzyx.zzb;
        } else {
            int iZzQ = zzQ();
            boolean z = iZzQ > this.zzL;
            if (this.zzH || !((zzadiVar = this.zzA) == null || zzadiVar.zza() == -9223372036854775807L)) {
                this.zzL = iZzQ;
            } else {
                boolean z2 = this.zzw;
                if (!z2 || zzZ()) {
                    this.zzF = z2;
                    this.zzI = 0L;
                    this.zzL = 0;
                    for (zzvw zzvwVar : this.zzt) {
                        zzvwVar.zzp(false);
                    }
                    zzve.zzf(zzveVar, 0L, 0L);
                } else {
                    this.zzK = true;
                    zzyrVarZzb = zzyx.zza;
                }
            }
            zzyrVarZzb = zzyx.zzb(z, jMin);
        }
        boolean zZzc = zzyrVarZzb.zzc();
        this.zzg.zzf(zztzVar, new zzue(1, -1, null, 0, null, zzet.zzu(zzveVar.zzk), zzet.zzu(this.zzB)), iOException, true ^ zZzc);
        if (!zZzc) {
            long unused2 = zzveVar.zzb;
        }
        return zzyrVarZzb;
    }

    public final zzadp zzv() {
        return zzS(new zzvh(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final zzadp zzw(int i, int i2) {
        return zzS(new zzvh(i, false));
    }
}
