package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzjx implements Handler.Callback, zzuf, zzya, zzkv, zzhu, zzky {
    private static final long zza = zzet.zzu(10000);
    private boolean zzA;
    private boolean zzB;
    private boolean zzD;
    private boolean zzG;
    private int zzH;
    private zzjw zzI;
    private long zzJ;
    private long zzK;
    private int zzL;
    private boolean zzM;
    private zzhw zzN;
    private zzig zzP;
    private final zzii zzQ;
    private final zzhq zzR;
    private final zzle[] zzb;
    private final Set zzc;
    private final zzlh[] zzd;
    private final zzyb zze;
    private final zzyc zzf;
    private final zzkb zzg;
    private final zzyj zzh;
    private final zzdt zzi;
    private final HandlerThread zzj;
    private final Looper zzk;
    private final zzcb zzl;
    private final zzca zzm;
    private final long zzn;
    private final zzhv zzo;
    private final ArrayList zzp;
    private final zzdj zzq;
    private final zzkk zzr;
    private final zzkw zzs;
    private final long zzt;
    private final zznz zzu;
    private zzlj zzv;
    private zzkx zzw;
    private zzjv zzx;
    private boolean zzy;
    private int zzE = 0;
    private boolean zzF = false;
    private boolean zzz = false;
    private long zzO = -9223372036854775807L;
    private long zzC = -9223372036854775807L;

    public zzjx(zzle[] zzleVarArr, zzyb zzybVar, zzyc zzycVar, zzkb zzkbVar, zzyj zzyjVar, int i, boolean z, zzln zzlnVar, zzlj zzljVar, zzhq zzhqVar, long j, boolean z2, boolean z3, Looper looper, zzdj zzdjVar, zzii zziiVar, zznz zznzVar, Looper looper2, zzig zzigVar) {
        this.zzQ = zziiVar;
        this.zzb = zzleVarArr;
        this.zze = zzybVar;
        this.zzf = zzycVar;
        this.zzg = zzkbVar;
        this.zzh = zzyjVar;
        this.zzv = zzljVar;
        this.zzR = zzhqVar;
        this.zzt = j;
        this.zzq = zzdjVar;
        this.zzu = zznzVar;
        this.zzP = zzigVar;
        this.zzn = zzkbVar.zzb(zznzVar);
        zzkbVar.zzg(zznzVar);
        zzcc zzccVar = zzcc.zza;
        zzkx zzkxVarZzg = zzkx.zzg(zzycVar);
        this.zzw = zzkxVarZzg;
        this.zzx = new zzjv(zzkxVarZzg);
        int length = zzleVarArr.length;
        this.zzd = new zzlh[2];
        zzlg zzlgVarZze = zzybVar.zze();
        for (int i2 = 0; i2 < 2; i2++) {
            zzleVarArr[i2].zzu(i2, zznzVar, zzdjVar);
            this.zzd[i2] = zzleVarArr[i2].zzl();
            this.zzd[i2].zzL(zzlgVarZze);
        }
        this.zzo = new zzhv(this, zzdjVar);
        this.zzp = new ArrayList();
        this.zzc = Collections.newSetFromMap(new IdentityHashMap());
        this.zzl = new zzcb();
        this.zzm = new zzca();
        zzybVar.zzr(this, zzyjVar);
        this.zzM = true;
        zzdt zzdtVarZzb = zzdjVar.zzb(looper, null);
        this.zzr = new zzkk(zzlnVar, zzdtVarZzb, new zzjp(this), zzigVar);
        this.zzs = new zzkw(this, zzlnVar, zzdtVarZzb, zznzVar);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.zzj = handlerThread;
        handlerThread.start();
        Looper looper3 = handlerThread.getLooper();
        this.zzk = looper3;
        this.zzi = zzdjVar.zzb(looper3, this);
    }

    private final void zzA() throws zzhw {
        int length = this.zzb.length;
        zzB(new boolean[2], this.zzr.zzf().zzf());
    }

    private final void zzB(boolean[] zArr, long j) throws zzhw {
        zzkh zzkhVarZzf = this.zzr.zzf();
        zzyc zzycVarZzi = zzkhVarZzf.zzi();
        int i = 0;
        while (true) {
            int length = this.zzb.length;
            if (i >= 2) {
                break;
            }
            if (!zzycVarZzi.zzb(i) && this.zzc.remove(this.zzb[i])) {
                this.zzb[i].zzI();
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            int length2 = this.zzb.length;
            if (i2 >= 2) {
                zzkhVarZzf.zzg = true;
                return;
            }
            if (zzycVarZzi.zzb(i2)) {
                boolean z = zArr[i2];
                zzle zzleVar = this.zzb[i2];
                if (!zzae(zzleVar)) {
                    zzkk zzkkVar = this.zzr;
                    zzkh zzkhVarZzf2 = zzkkVar.zzf();
                    boolean z2 = zzkhVarZzf2 == zzkkVar.zze();
                    zzyc zzycVarZzi2 = zzkhVarZzf2.zzi();
                    zzli zzliVar = zzycVarZzi2.zzb[i2];
                    zzaf[] zzafVarArrZzaj = zzaj(zzycVarZzi2.zzc[i2]);
                    boolean z3 = zzah() && this.zzw.zze == 3;
                    boolean z4 = !z && z3;
                    this.zzH++;
                    this.zzc.add(zzleVar);
                    zzleVar.zzr(zzliVar, zzafVarArrZzaj, zzkhVarZzf2.zzc[i2], this.zzJ, z4, z2, j, zzkhVarZzf2.zze(), zzkhVarZzf2.zzf.zza);
                    zzleVar.zzt(11, new zzjq(this));
                    this.zzo.zze(zzleVar);
                    if (z3 && z2) {
                        zzleVar.zzO();
                    }
                }
            }
            i2++;
        }
    }

    private final void zzC(IOException iOException, int i) {
        zzkk zzkkVar = this.zzr;
        zzhw zzhwVarZzc = zzhw.zzc(iOException, i);
        zzkh zzkhVarZze = zzkkVar.zze();
        if (zzkhVarZze != null) {
            zzhwVarZzc = zzhwVarZzc.zza(zzkhVarZze.zzf.zza);
        }
        zzea.zzd("ExoPlayerImplInternal", "Playback error", zzhwVarZzc);
        zzV(false, false);
        this.zzw = this.zzw.zzd(zzhwVarZzc);
    }

    private final void zzD(boolean z) {
        zzkh zzkhVarZzd = this.zzr.zzd();
        zzui zzuiVar = zzkhVarZzd == null ? this.zzw.zzb : zzkhVarZzd.zzf.zza;
        boolean zEquals = this.zzw.zzk.equals(zzuiVar);
        if (!zEquals) {
            this.zzw = this.zzw.zza(zzuiVar);
        }
        zzkx zzkxVar = this.zzw;
        zzkxVar.zzp = zzkhVarZzd == null ? zzkxVar.zzr : zzkhVarZzd.zzc();
        this.zzw.zzq = zzs();
        if ((!zEquals || z) && zzkhVarZzd != null && zzkhVarZzd.zzd) {
            zzY(zzkhVarZzd.zzf.zza, zzkhVarZzd.zzh(), zzkhVarZzd.zzi());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:199:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x040f  */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18, types: [com.google.android.gms.internal.ads.zzjw] */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1 */
    /* JADX WARN: Type inference failed for: r25v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzE(com.google.android.gms.internal.ads.zzcc r30, boolean r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.zzE(com.google.android.gms.internal.ads.zzcc, boolean):void");
    }

    private final void zzF(zzbq zzbqVar, boolean z) {
        zzG(zzbqVar, zzbqVar.zzb, true, z);
    }

    private final void zzG(zzbq zzbqVar, float f, boolean z, boolean z2) {
        zzbq zzbqVar2;
        int i;
        if (z) {
            if (z2) {
                this.zzx.zza(1);
            }
            zzkx zzkxVar = this.zzw;
            zzkx zzkxVar2 = new zzkx(zzkxVar.zza, zzkxVar.zzb, zzkxVar.zzc, zzkxVar.zzd, zzkxVar.zze, zzkxVar.zzf, zzkxVar.zzg, zzkxVar.zzh, zzkxVar.zzi, zzkxVar.zzj, zzkxVar.zzk, zzkxVar.zzl, zzkxVar.zzm, zzbqVar, zzkxVar.zzp, zzkxVar.zzq, zzkxVar.zzr, zzkxVar.zzs, false);
            zzbqVar2 = zzbqVar;
            this.zzw = zzkxVar2;
        } else {
            zzbqVar2 = zzbqVar;
        }
        float f2 = zzbqVar2.zzb;
        zzkh zzkhVarZze = this.zzr.zze();
        while (true) {
            i = 0;
            if (zzkhVarZze == null) {
                break;
            }
            zzxv[] zzxvVarArr = zzkhVarZze.zzi().zzc;
            int length = zzxvVarArr.length;
            while (i < length) {
                zzxv zzxvVar = zzxvVarArr[i];
                i++;
            }
            zzkhVarZze = zzkhVarZze.zzg();
        }
        zzle[] zzleVarArr = this.zzb;
        int length2 = zzleVarArr.length;
        while (i < 2) {
            zzle zzleVar = zzleVarArr[i];
            if (zzleVar != null) {
                zzleVar.zzM(f, zzbqVar2.zzb);
            }
            i++;
        }
    }

    private final void zzH() {
        long jZze;
        long jZze2;
        boolean zZzh = false;
        if (zzad()) {
            zzkh zzkhVarZzd = this.zzr.zzd();
            long jZzt = zzt(zzkhVarZzd.zzd());
            if (zzkhVarZzd == this.zzr.zze()) {
                jZze = this.zzJ;
                jZze2 = zzkhVarZzd.zze();
            } else {
                jZze = this.zzJ - zzkhVarZzd.zze();
                jZze2 = zzkhVarZzd.zzf.zzb;
            }
            zzka zzkaVar = new zzka(this.zzu, this.zzw.zza, zzkhVarZzd.zzf.zza, jZze - jZze2, jZzt, this.zzo.zzc().zzb, this.zzw.zzl, this.zzB, zzai(this.zzw.zza, zzkhVarZzd.zzf.zza) ? this.zzR.zzb() : -9223372036854775807L);
            boolean zZzh2 = this.zzg.zzh(zzkaVar);
            zzkh zzkhVarZze = this.zzr.zze();
            if (zZzh2 || !zzkhVarZze.zzd || jZzt >= 500000 || this.zzn <= 0) {
                zZzh = zZzh2;
            } else {
                zzkhVarZze.zza.zzj(this.zzw.zzr, false);
                zZzh = this.zzg.zzh(zzkaVar);
            }
        }
        this.zzD = zZzh;
        if (zZzh) {
            this.zzr.zzd().zzk(this.zzJ, this.zzo.zzc().zzb, this.zzC);
        }
        zzX();
    }

    private final void zzI() {
        this.zzx.zzc(this.zzw);
        if (this.zzx.zzg) {
            zzii zziiVar = this.zzQ;
            zziiVar.zza.zzO(this.zzx);
            this.zzx = new zzjv(this.zzw);
        }
    }

    private final void zzJ() throws zzhw {
        int i;
        int i2;
        float f = this.zzo.zzc().zzb;
        zzkk zzkkVar = this.zzr;
        zzkh zzkhVarZze = zzkkVar.zze();
        zzkh zzkhVarZzf = zzkkVar.zzf();
        zzyc zzycVar = null;
        boolean z = true;
        while (zzkhVarZze != null && zzkhVarZze.zzd) {
            zzyc zzycVarZzj = zzkhVarZze.zzj(f, this.zzw.zza);
            zzyc zzycVar2 = zzkhVarZze == this.zzr.zze() ? zzycVarZzj : zzycVar;
            zzyc zzycVarZzi = zzkhVarZze.zzi();
            boolean z2 = false;
            if (zzycVarZzi != null) {
                if (zzycVarZzi.zzc.length == zzycVarZzj.zzc.length) {
                    for (int i3 = 0; i3 < zzycVarZzj.zzc.length; i3++) {
                        if (zzycVarZzj.zza(zzycVarZzi, i3)) {
                        }
                    }
                    if (zzkhVarZze != zzkhVarZzf) {
                        z2 = true;
                    }
                    z &= z2;
                    zzkhVarZze = zzkhVarZze.zzg();
                    zzycVar = zzycVar2;
                }
            }
            if (z) {
                zzkk zzkkVar2 = this.zzr;
                zzkh zzkhVarZze2 = zzkkVar2.zze();
                boolean zZzq = zzkkVar2.zzq(zzkhVarZze2);
                int length = this.zzb.length;
                boolean[] zArr = new boolean[2];
                zzycVar2.getClass();
                long jZzb = zzkhVarZze2.zzb(zzycVar2, this.zzw.zzr, zZzq, zArr);
                zzkx zzkxVar = this.zzw;
                boolean z3 = (zzkxVar.zze == 4 || jZzb == zzkxVar.zzr) ? false : true;
                zzkx zzkxVar2 = this.zzw;
                i = 4;
                i2 = 2;
                this.zzw = zzy(zzkxVar2.zzb, jZzb, zzkxVar2.zzc, zzkxVar2.zzd, z3, 5);
                if (z3) {
                    zzN(jZzb);
                }
                int length2 = this.zzb.length;
                boolean[] zArr2 = new boolean[2];
                int i4 = 0;
                while (true) {
                    zzle[] zzleVarArr = this.zzb;
                    int length3 = zzleVarArr.length;
                    if (i4 >= 2) {
                        break;
                    }
                    zzle zzleVar = zzleVarArr[i4];
                    boolean zZzae = zzae(zzleVar);
                    zArr2[i4] = zZzae;
                    zzvx zzvxVar = zzkhVarZze2.zzc[i4];
                    if (zZzae) {
                        if (zzvxVar != zzleVar.zzo()) {
                            zzz(zzleVar);
                        } else if (zArr[i4]) {
                            zzleVar.zzJ(this.zzJ);
                        }
                    }
                    i4++;
                }
                zzB(zArr2, this.zzJ);
            } else {
                i = 4;
                i2 = 2;
                this.zzr.zzq(zzkhVarZze);
                if (zzkhVarZze.zzd) {
                    zzkhVarZze.zza(zzycVarZzj, Math.max(zzkhVarZze.zzf.zzb, this.zzJ - zzkhVarZze.zze()), false);
                }
            }
            zzD(true);
            if (this.zzw.zze != i) {
                zzH();
                zzZ();
                this.zzi.zzi(i2);
                return;
            }
            return;
        }
    }

    private final void zzK() throws zzhw {
        zzJ();
        zzQ(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4 A[PHI: r2 r6 r8
  0x00a4: PHI (r2v2 com.google.android.gms.internal.ads.zzui) = (r2v1 com.google.android.gms.internal.ads.zzui), (r2v12 com.google.android.gms.internal.ads.zzui) binds: [B:30:0x007a, B:32:0x009f] A[DONT_GENERATE, DONT_INLINE]
  0x00a4: PHI (r6v3 long) = (r6v2 long), (r6v9 long) binds: [B:30:0x007a, B:32:0x009f] A[DONT_GENERATE, DONT_INLINE]
  0x00a4: PHI (r8v3 long) = (r8v2 long), (r8v7 long) binds: [B:30:0x007a, B:32:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed A[PHI: r0
  0x00ed: PHI (r0v11 com.google.android.gms.internal.ads.zzcc) = 
  (r0v10 com.google.android.gms.internal.ads.zzcc)
  (r0v10 com.google.android.gms.internal.ads.zzcc)
  (r0v21 com.google.android.gms.internal.ads.zzcc)
  (r0v21 com.google.android.gms.internal.ads.zzcc)
 binds: [B:36:0x00b2, B:38:0x00b6, B:40:0x00c7, B:42:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzL(boolean r33, boolean r34, boolean r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.zzL(boolean, boolean, boolean, boolean):void");
    }

    private final void zzM() {
        zzkh zzkhVarZze = this.zzr.zze();
        boolean z = false;
        if (zzkhVarZze != null && zzkhVarZze.zzf.zzh && this.zzz) {
            z = true;
        }
        this.zzA = z;
    }

    private final void zzN(long j) {
        zzkh zzkhVarZze = this.zzr.zze();
        long jZze = j + (zzkhVarZze == null ? 1000000000000L : zzkhVarZze.zze());
        this.zzJ = jZze;
        this.zzo.zzf(jZze);
        zzle[] zzleVarArr = this.zzb;
        int length = zzleVarArr.length;
        for (int i = 0; i < 2; i++) {
            zzle zzleVar = zzleVarArr[i];
            if (zzae(zzleVar)) {
                zzleVar.zzJ(this.zzJ);
            }
        }
        for (zzkh zzkhVarZze2 = this.zzr.zze(); zzkhVarZze2 != null; zzkhVarZze2 = zzkhVarZze2.zzg()) {
            for (zzxv zzxvVar : zzkhVarZze2.zzi().zzc) {
            }
        }
    }

    private final void zzO(zzcc zzccVar, zzcc zzccVar2) {
        if (zzccVar.zzo() && zzccVar2.zzo()) {
            return;
        }
        int size = this.zzp.size() - 1;
        if (size < 0) {
            Collections.sort(this.zzp);
        } else {
            Object obj = ((zzju) this.zzp.get(size)).zzb;
            int i = zzet.zza;
            throw null;
        }
    }

    private final void zzP(long j) {
        this.zzi.zzj(2, j + ((this.zzw.zze != 3 || zzah()) ? zza : 1000L));
    }

    private final void zzQ(boolean z) throws zzhw {
        zzui zzuiVar = this.zzr.zze().zzf.zza;
        long jZzv = zzv(zzuiVar, this.zzw.zzr, true, false);
        if (jZzv != this.zzw.zzr) {
            zzkx zzkxVar = this.zzw;
            this.zzw = zzy(zzuiVar, jZzv, zzkxVar.zzc, zzkxVar.zzd, z, 5);
        }
    }

    private final void zzR(zzbq zzbqVar) {
        this.zzi.zzf(16);
        this.zzo.zzg(zzbqVar);
    }

    private final void zzS(boolean z, int i, boolean z2, int i2) {
        this.zzx.zza(z2 ? 1 : 0);
        this.zzx.zzb(i2);
        this.zzw = this.zzw.zzc(z, i);
        zzab(false, false);
        for (zzkh zzkhVarZze = this.zzr.zze(); zzkhVarZze != null; zzkhVarZze = zzkhVarZze.zzg()) {
            for (zzxv zzxvVar : zzkhVarZze.zzi().zzc) {
            }
        }
        if (!zzah()) {
            zzW();
            zzZ();
            return;
        }
        int i3 = this.zzw.zze;
        if (i3 == 3) {
            this.zzo.zzh();
            zzU();
            this.zzi.zzi(2);
        } else if (i3 == 2) {
            this.zzi.zzi(2);
        }
    }

    private final void zzT(int i) {
        zzkx zzkxVar = this.zzw;
        if (zzkxVar.zze != i) {
            if (i != 2) {
                this.zzO = -9223372036854775807L;
            }
            this.zzw = zzkxVar.zze(i);
        }
    }

    private final void zzU() {
        zzkh zzkhVarZze = this.zzr.zze();
        if (zzkhVarZze == null) {
            return;
        }
        zzyc zzycVarZzi = zzkhVarZze.zzi();
        int i = 0;
        while (true) {
            int length = this.zzb.length;
            if (i >= 2) {
                return;
            }
            if (zzycVarZzi.zzb(i) && this.zzb[i].zzcV() == 1) {
                this.zzb[i].zzO();
            }
            i++;
        }
    }

    private final void zzV(boolean z, boolean z2) {
        zzL(z || !this.zzG, false, true, false);
        this.zzx.zza(z2 ? 1 : 0);
        this.zzg.zze(this.zzu);
        zzT(1);
    }

    private final void zzW() {
        this.zzo.zzi();
        zzle[] zzleVarArr = this.zzb;
        int length = zzleVarArr.length;
        for (int i = 0; i < 2; i++) {
            zzle zzleVar = zzleVarArr[i];
            if (zzae(zzleVar)) {
                zzal(zzleVar);
            }
        }
    }

    private final void zzX() {
        zzkh zzkhVarZzd = this.zzr.zzd();
        boolean z = this.zzD || (zzkhVarZzd != null && zzkhVarZzd.zza.zzp());
        zzkx zzkxVar = this.zzw;
        if (z != zzkxVar.zzg) {
            this.zzw = new zzkx(zzkxVar.zza, zzkxVar.zzb, zzkxVar.zzc, zzkxVar.zzd, zzkxVar.zze, zzkxVar.zzf, z, zzkxVar.zzh, zzkxVar.zzi, zzkxVar.zzj, zzkxVar.zzk, zzkxVar.zzl, zzkxVar.zzm, zzkxVar.zzn, zzkxVar.zzp, zzkxVar.zzq, zzkxVar.zzr, zzkxVar.zzs, false);
        }
    }

    private final void zzY(zzui zzuiVar, zzwi zzwiVar, zzyc zzycVar) {
        zzcc zzccVar = this.zzw.zza;
        zzxv[] zzxvVarArr = zzycVar.zzc;
        this.zzg.zzf(this.zzu, zzccVar, zzuiVar, this.zzb, zzwiVar, zzxvVarArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b0, code lost:
    
        r9 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzZ() {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.zzZ():void");
    }

    private final void zzaa(zzcc zzccVar, zzui zzuiVar, zzcc zzccVar2, zzui zzuiVar2, long j, boolean z) {
        if (!zzai(zzccVar, zzuiVar)) {
            zzbq zzbqVar = zzuiVar.zzb() ? zzbq.zza : this.zzw.zzn;
            if (this.zzo.zzc().equals(zzbqVar)) {
                return;
            }
            zzR(zzbqVar);
            zzG(this.zzw.zzn, zzbqVar.zzb, false, false);
            return;
        }
        zzccVar.zze(zzccVar.zzn(zzuiVar.zza, this.zzm).zzc, this.zzl, 0L);
        zzhq zzhqVar = this.zzR;
        zzav zzavVar = this.zzl.zzj;
        int i = zzet.zza;
        zzhqVar.zzd(zzavVar);
        if (j != -9223372036854775807L) {
            this.zzR.zze(zzr(zzccVar, zzuiVar.zza, j));
            return;
        }
        if (!zzet.zzG(!zzccVar2.zzo() ? zzccVar2.zze(zzccVar2.zzn(zzuiVar2.zza, this.zzm).zzc, this.zzl, 0L).zzb : null, this.zzl.zzb) || z) {
            this.zzR.zze(-9223372036854775807L);
        }
    }

    private final void zzab(boolean z, boolean z2) {
        this.zzB = z;
        long jElapsedRealtime = -9223372036854775807L;
        if (z && !z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.zzC = jElapsedRealtime;
    }

    private final synchronized void zzac(zzfvk zzfvkVar, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
        boolean z = false;
        while (!((zzjn) zzfvkVar).zza.zzy && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jElapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final boolean zzad() {
        zzkh zzkhVarZzd = this.zzr.zzd();
        return (zzkhVarZzd == null || zzkhVarZzd.zzd() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean zzae(zzle zzleVar) {
        return zzleVar.zzcV() != 0;
    }

    private final boolean zzaf() {
        zzkh zzkhVarZze = this.zzr.zze();
        long j = zzkhVarZze.zzf.zze;
        if (zzkhVarZze.zzd) {
            return j == -9223372036854775807L || this.zzw.zzr < j || !zzah();
        }
        return false;
    }

    private static boolean zzag(zzkx zzkxVar, zzca zzcaVar) {
        zzui zzuiVar = zzkxVar.zzb;
        zzcc zzccVar = zzkxVar.zza;
        return zzccVar.zzo() || zzccVar.zzn(zzuiVar.zza, zzcaVar).zzf;
    }

    private final boolean zzah() {
        zzkx zzkxVar = this.zzw;
        return zzkxVar.zzl && zzkxVar.zzm == 0;
    }

    private final boolean zzai(zzcc zzccVar, zzui zzuiVar) {
        if (!zzuiVar.zzb() && !zzccVar.zzo()) {
            zzccVar.zze(zzccVar.zzn(zzuiVar.zza, this.zzm).zzc, this.zzl, 0L);
            if (this.zzl.zzb()) {
                zzcb zzcbVar = this.zzl;
                if (zzcbVar.zzi && zzcbVar.zzf != -9223372036854775807L) {
                    return true;
                }
            }
        }
        return false;
    }

    private static zzaf[] zzaj(zzxv zzxvVar) {
        int iZzc = zzxvVar != null ? zzxvVar.zzc() : 0;
        zzaf[] zzafVarArr = new zzaf[iZzc];
        for (int i = 0; i < iZzc; i++) {
            zzafVarArr[i] = zzxvVar.zzd(i);
        }
        return zzafVarArr;
    }

    private static final void zzak(zzla zzlaVar) {
        zzlaVar.zzj();
        try {
            zzlaVar.zzc().zzt(zzlaVar.zza(), zzlaVar.zzg());
        } finally {
            zzlaVar.zzh(true);
        }
    }

    private static final void zzal(zzle zzleVar) {
        if (zzleVar.zzcV() == 2) {
            zzleVar.zzP();
        }
    }

    private static final void zzam(zzle zzleVar, long j) {
        zzleVar.zzK();
        if (zzleVar instanceof zzwm) {
            throw null;
        }
    }

    public static int zzb(zzcb zzcbVar, zzca zzcaVar, int i, boolean z, Object obj, zzcc zzccVar, zzcc zzccVar2) {
        zzcb zzcbVar2 = zzcbVar;
        zzcc zzccVar3 = zzccVar;
        Object obj2 = zzccVar3.zze(zzccVar3.zzn(obj, zzcaVar).zzc, zzcbVar, 0L).zzb;
        for (int i2 = 0; i2 < zzccVar2.zzc(); i2++) {
            if (zzccVar2.zze(i2, zzcbVar, 0L).zzb.equals(obj2)) {
                return i2;
            }
        }
        int iZza = zzccVar3.zza(obj);
        int iZzb = zzccVar3.zzb();
        int i3 = 0;
        int iZza2 = -1;
        while (true) {
            if (i3 >= iZzb || iZza2 != -1) {
                break;
            }
            zzcc zzccVar4 = zzccVar3;
            int iZzi = zzccVar4.zzi(iZza, zzcaVar, zzcbVar2, i, z);
            if (iZzi == -1) {
                iZza2 = -1;
                break;
            }
            iZza2 = zzccVar2.zza(zzccVar4.zzf(iZzi));
            i3++;
            zzccVar3 = zzccVar4;
            iZza = iZzi;
            zzcbVar2 = zzcbVar;
        }
        if (iZza2 == -1) {
            return -1;
        }
        return zzccVar2.zzd(iZza2, zzcaVar, false).zzc;
    }

    public static /* synthetic */ zzkh zzd(zzjx zzjxVar, zzki zzkiVar, long j) {
        zzkb zzkbVar = zzjxVar.zzg;
        zzyb zzybVar = zzjxVar.zze;
        zzyk zzykVarZzj = zzkbVar.zzj();
        zzyc zzycVar = zzjxVar.zzf;
        return new zzkh(zzjxVar.zzd, j, zzybVar, zzykVarZzj, zzjxVar.zzs, zzkiVar, zzycVar);
    }

    public static final /* synthetic */ void zzq(zzla zzlaVar) {
        try {
            zzak(zzlaVar);
        } catch (zzhw e) {
            zzea.zzd("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private final long zzr(zzcc zzccVar, Object obj, long j) {
        zzccVar.zze(zzccVar.zzn(obj, this.zzm).zzc, this.zzl, 0L);
        zzcb zzcbVar = this.zzl;
        if (zzcbVar.zzf != -9223372036854775807L && zzcbVar.zzb()) {
            zzcb zzcbVar2 = this.zzl;
            if (zzcbVar2.zzi) {
                long j2 = zzcbVar2.zzg;
                return zzet.zzr((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - this.zzl.zzf) - j;
            }
        }
        return -9223372036854775807L;
    }

    private final long zzs() {
        return zzt(this.zzw.zzp);
    }

    private final long zzt(long j) {
        zzkh zzkhVarZzd = this.zzr.zzd();
        if (zzkhVarZzd == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzJ - zzkhVarZzd.zze()));
    }

    private final long zzu(zzui zzuiVar, long j, boolean z) {
        zzkk zzkkVar = this.zzr;
        return zzv(zzuiVar, j, zzkkVar.zze() != zzkkVar.zzf(), z);
    }

    private final long zzv(zzui zzuiVar, long j, boolean z, boolean z2) throws zzhw {
        zzW();
        zzab(false, true);
        if (z2 || this.zzw.zze == 3) {
            zzT(2);
        }
        zzkh zzkhVarZze = this.zzr.zze();
        zzkh zzkhVarZzg = zzkhVarZze;
        while (zzkhVarZzg != null && !zzuiVar.equals(zzkhVarZzg.zzf.zza)) {
            zzkhVarZzg = zzkhVarZzg.zzg();
        }
        if (z || zzkhVarZze != zzkhVarZzg || (zzkhVarZzg != null && zzkhVarZzg.zze() + j < 0)) {
            zzle[] zzleVarArr = this.zzb;
            int length = zzleVarArr.length;
            for (int i = 0; i < 2; i++) {
                zzz(zzleVarArr[i]);
            }
            if (zzkhVarZzg != null) {
                while (this.zzr.zze() != zzkhVarZzg) {
                    this.zzr.zza();
                }
                this.zzr.zzq(zzkhVarZzg);
                zzkhVarZzg.zzp(1000000000000L);
                zzA();
            }
        }
        if (zzkhVarZzg != null) {
            this.zzr.zzq(zzkhVarZzg);
            if (!zzkhVarZzg.zzd) {
                zzkhVarZzg.zzf = zzkhVarZzg.zzf.zzb(j);
            } else if (zzkhVarZzg.zze) {
                j = zzkhVarZzg.zza.zze(j);
                zzkhVarZzg.zza.zzj(j - this.zzn, false);
            }
            zzN(j);
            zzH();
        } else {
            this.zzr.zzj();
            zzN(j);
        }
        zzD(false);
        this.zzi.zzi(2);
        return j;
    }

    private final Pair zzw(zzcc zzccVar) {
        long j = 0;
        if (zzccVar.zzo()) {
            return Pair.create(zzkx.zzh(), 0L);
        }
        Pair pairZzl = zzccVar.zzl(this.zzl, this.zzm, zzccVar.zzg(this.zzF), -9223372036854775807L);
        zzui zzuiVarZzi = this.zzr.zzi(zzccVar, pairZzl.first, 0L);
        long jLongValue = ((Long) pairZzl.second).longValue();
        if (zzuiVarZzi.zzb()) {
            zzccVar.zzn(zzuiVarZzi.zza, this.zzm);
            if (zzuiVarZzi.zzc == this.zzm.zze(zzuiVarZzi.zzb)) {
                this.zzm.zzj();
            }
        } else {
            j = jLongValue;
        }
        return Pair.create(zzuiVarZzi, Long.valueOf(j));
    }

    private static Pair zzx(zzcc zzccVar, zzjw zzjwVar, boolean z, int i, boolean z2, zzcb zzcbVar, zzca zzcaVar) {
        Pair pairZzl;
        zzcc zzccVar2;
        zzcc zzccVar3 = zzjwVar.zza;
        if (zzccVar.zzo()) {
            return null;
        }
        boolean zZzo = zzccVar3.zzo();
        zzcc zzccVar4 = zzccVar3;
        if (true == zZzo) {
            zzccVar4 = zzccVar;
        }
        try {
            pairZzl = zzccVar4.zzl(zzcbVar, zzcaVar, zzjwVar.zzb, zzjwVar.zzc);
            zzccVar2 = zzccVar4;
        } catch (IndexOutOfBoundsException unused) {
        }
        if (zzccVar.equals(zzccVar2)) {
            return pairZzl;
        }
        if (zzccVar.zza(pairZzl.first) != -1) {
            return (zzccVar2.zzn(pairZzl.first, zzcaVar).zzf && zzccVar2.zze(zzcaVar.zzc, zzcbVar, 0L).zzn == zzccVar2.zza(pairZzl.first)) ? zzccVar.zzl(zzcbVar, zzcaVar, zzccVar.zzn(pairZzl.first, zzcaVar).zzc, zzjwVar.zzc) : pairZzl;
        }
        int iZzb = zzb(zzcbVar, zzcaVar, i, z2, pairZzl.first, zzccVar2, zzccVar);
        if (iZzb != -1) {
            return zzccVar.zzl(zzcbVar, zzcaVar, iZzb, -9223372036854775807L);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.internal.ads.zzkx zzy(com.google.android.gms.internal.ads.zzui r17, long r18, long r20, long r22, boolean r24, int r25) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.zzy(com.google.android.gms.internal.ads.zzui, long, long, long, boolean, int):com.google.android.gms.internal.ads.zzkx");
    }

    private final void zzz(zzle zzleVar) {
        if (zzae(zzleVar)) {
            this.zzo.zzd(zzleVar);
            zzal(zzleVar);
            zzleVar.zzq();
            this.zzH--;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0664 A[Catch: RuntimeException -> 0x0023, IOException -> 0x0026, zzti -> 0x0029, zzft -> 0x002c, zzbo -> 0x002f, zzrb -> 0x0032, zzhw -> 0x0035, TryCatch #13 {zzbo -> 0x002f, zzft -> 0x002c, zzhw -> 0x0035, zzrb -> 0x0032, zzti -> 0x0029, IOException -> 0x0026, RuntimeException -> 0x0023, blocks: (B:3:0x0006, B:4:0x000d, B:6:0x0011, B:22:0x0038, B:23:0x004f, B:24:0x0053, B:25:0x0057, B:29:0x005e, B:31:0x0067, B:33:0x0075, B:34:0x007c, B:35:0x0086, B:36:0x0099, B:37:0x00b1, B:38:0x00c7, B:40:0x00d6, B:41:0x00da, B:42:0x00eb, B:44:0x00fa, B:45:0x0116, B:46:0x0129, B:47:0x0132, B:49:0x0144, B:50:0x0150, B:51:0x0160, B:53:0x016c, B:56:0x0177, B:57:0x017e, B:58:0x018b, B:62:0x0192, B:64:0x019a, B:66:0x019e, B:68:0x01a4, B:70:0x01ac, B:72:0x01b4, B:73:0x01b7, B:75:0x01bc, B:81:0x01c8, B:82:0x01c9, B:86:0x01d0, B:88:0x01de, B:89:0x01e1, B:90:0x01e6, B:92:0x01f6, B:93:0x01f9, B:94:0x01fe, B:95:0x0203, B:97:0x020f, B:98:0x021b, B:100:0x0227, B:102:0x0253, B:103:0x0273, B:112:0x029e, B:114:0x02a2, B:115:0x02a5, B:121:0x02af, B:132:0x02c2, B:133:0x02c7, B:134:0x02cf, B:138:0x0307, B:211:0x0437, B:190:0x03ff, B:189:0x03fb, B:218:0x0444, B:219:0x044f, B:146:0x035a, B:148:0x0371, B:234:0x0473, B:236:0x048e, B:239:0x049f, B:241:0x04ae, B:243:0x04ba, B:245:0x04cf, B:246:0x04d4, B:247:0x04d7, B:249:0x04db, B:251:0x04e8, B:323:0x063e, B:325:0x0646, B:327:0x064e, B:330:0x0653, B:331:0x065f, B:333:0x0664, B:335:0x066c, B:338:0x067c, B:340:0x0682, B:341:0x06a0, B:343:0x06a8, B:345:0x06ad, B:347:0x06b2, B:349:0x06b6, B:389:0x076f, B:390:0x0773, B:394:0x077e, B:396:0x0786, B:397:0x078b, B:399:0x0797, B:400:0x07b0, B:402:0x07b5, B:404:0x07bd, B:406:0x07c6, B:410:0x07cf, B:415:0x07de, B:421:0x07eb, B:423:0x07f1, B:432:0x0803, B:433:0x0806, B:435:0x0810, B:437:0x0816, B:441:0x081e, B:443:0x0826, B:445:0x082a, B:446:0x0834, B:448:0x083a, B:501:0x0942, B:504:0x0949, B:506:0x094e, B:508:0x0956, B:510:0x0964, B:511:0x096b, B:512:0x096e, B:514:0x0974, B:516:0x097d, B:518:0x0983, B:520:0x0989, B:527:0x09aa, B:529:0x09b0, B:533:0x09b9, B:542:0x09cf, B:539:0x09c8, B:541:0x09cc, B:521:0x0990, B:524:0x099e, B:525:0x09a5, B:526:0x09a6, B:449:0x0842, B:451:0x0848, B:453:0x084c, B:480:0x08e4, B:482:0x08f1, B:458:0x0858, B:460:0x085c, B:462:0x0870, B:464:0x087b, B:466:0x0887, B:470:0x0890, B:472:0x089a, B:478:0x08a5, B:483:0x08fd, B:485:0x0903, B:487:0x0907, B:491:0x0910, B:493:0x091e, B:495:0x0926, B:497:0x0930, B:498:0x0935, B:499:0x093a, B:500:0x093f, B:434:0x0809, B:352:0x06c3, B:354:0x06c7, B:356:0x06cf, B:358:0x06d5, B:360:0x06df, B:363:0x06e5, B:364:0x06e8, B:366:0x06f0, B:368:0x0702, B:370:0x070a, B:372:0x0712, B:376:0x071b, B:378:0x0741, B:379:0x0744, B:380:0x074f, B:382:0x0754, B:384:0x075a, B:385:0x0761, B:388:0x076e, B:255:0x04f7, B:257:0x04fd, B:260:0x0508, B:263:0x0513, B:265:0x0518, B:268:0x0526, B:270:0x052c, B:271:0x0534, B:272:0x0537, B:274:0x053f, B:276:0x054d, B:278:0x058a, B:280:0x0594, B:282:0x059e, B:284:0x05a6, B:285:0x05a9, B:286:0x05ac, B:288:0x05b2, B:290:0x05c0, B:292:0x05c5, B:294:0x05cf, B:296:0x05d9, B:298:0x05ea, B:300:0x05f0, B:301:0x05fb, B:302:0x05fe, B:304:0x0604, B:307:0x0609, B:309:0x060e, B:311:0x0616, B:313:0x061c, B:315:0x0622, B:319:0x0630, B:321:0x0638, B:322:0x063b, B:250:0x04e5, B:543:0x09d4, B:547:0x09db, B:548:0x09e3, B:552:0x0a03, B:122:0x02b0, B:124:0x02b4, B:125:0x02b7, B:128:0x02be, B:131:0x02c1), top: B:623:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x06b0 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v80, types: [com.google.android.gms.internal.ads.zzgu, com.google.android.gms.internal.ads.zzyj] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:350:0x06ba
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            Method dump skipped, instruction units count: 2900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.handleMessage(android.os.Message):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzhu
    public final void zza(zzbq zzbqVar) {
        this.zzi.zzc(16, zzbqVar).zza();
    }

    public final Looper zzc() {
        return this.zzk;
    }

    public final /* synthetic */ Boolean zze() {
        return Boolean.valueOf(this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final /* bridge */ /* synthetic */ void zzf(zzvz zzvzVar) {
        this.zzi.zzc(9, (zzug) zzvzVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void zzg() {
        this.zzi.zzf(2);
        this.zzi.zzi(22);
    }

    @Override // com.google.android.gms.internal.ads.zzuf
    public final void zzh(zzug zzugVar) {
        this.zzi.zzc(8, zzugVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final void zzi() {
        this.zzi.zzi(10);
    }

    public final void zzj() {
        this.zzi.zzb(0).zza();
    }

    public final void zzk(zzcc zzccVar, int i, long j) {
        this.zzi.zzc(3, new zzjw(zzccVar, i, j)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final synchronized void zzl(zzla zzlaVar) {
        if (!this.zzy && this.zzk.getThread().isAlive()) {
            this.zzi.zzc(14, zzlaVar).zza();
            return;
        }
        zzea.zzf("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        zzlaVar.zzh(false);
    }

    public final void zzm(boolean z, int i) {
        this.zzi.zzd(1, z ? 1 : 0, i).zza();
    }

    public final void zzn() {
        this.zzi.zzb(6).zza();
    }

    public final synchronized boolean zzo() {
        if (!this.zzy && this.zzk.getThread().isAlive()) {
            this.zzi.zzi(7);
            zzac(new zzjn(this), this.zzt);
            return this.zzy;
        }
        return true;
    }

    public final void zzp(List list, int i, long j, zzwa zzwaVar) {
        this.zzi.zzc(17, new zzjs(list, zzwaVar, i, j, null)).zza();
    }
}
