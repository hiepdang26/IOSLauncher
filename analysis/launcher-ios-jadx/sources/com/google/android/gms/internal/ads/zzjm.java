package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
final class zzjm extends zzj implements zzih {
    public static final /* synthetic */ int zzd = 0;
    private boolean zzA;
    private int zzB;
    private zzlj zzC;
    private zzig zzD;
    private zzbt zzE;
    private zzbh zzF;
    private Object zzG;
    private Surface zzH;
    private int zzI;
    private zzel zzJ;
    private int zzK;
    private zzh zzL;
    private float zzM;
    private boolean zzN;
    private boolean zzO;
    private boolean zzP;
    private int zzQ;
    private zzbh zzR;
    private zzkx zzS;
    private int zzT;
    private long zzU;
    private final zzii zzV;
    private zzwa zzW;
    final zzyc zzb;
    final zzbt zzc;
    private final zzdm zze;
    private final Context zzf;
    private final zzbw zzg;
    private final zzle[] zzh;
    private final zzyb zzi;
    private final zzdt zzj;
    private final zzjx zzk;
    private final zzdz zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzca zzn;
    private final List zzo;
    private final boolean zzp;
    private final zzln zzq;
    private final Looper zzr;
    private final zzyj zzs;
    private final zzdj zzt;
    private final zzji zzu;
    private final zzjk zzv;
    private final zzhl zzw;
    private final long zzx;
    private int zzy;
    private int zzz;

    static {
        zzbd.zzb("media3.exoplayer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.google.android.gms.internal.ads.zzln, com.google.android.gms.internal.ads.zzyi, java.lang.Object] */
    public zzjm(zzif zzifVar, zzbw zzbwVar) {
        zzdm zzdmVar = new zzdm(zzdj.zza);
        this.zze = zzdmVar;
        try {
            zzea.zze("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.4.0-alpha02] [" + zzet.zze + "]");
            Context applicationContext = zzifVar.zza.getApplicationContext();
            this.zzf = applicationContext;
            ?? Apply = zzifVar.zzh.apply(zzifVar.zzb);
            this.zzq = Apply;
            this.zzQ = zzifVar.zzj;
            this.zzL = zzifVar.zzk;
            this.zzI = zzifVar.zzl;
            this.zzN = false;
            this.zzx = zzifVar.zzp;
            zzji zzjiVar = new zzji(this, null);
            this.zzu = zzjiVar;
            zzjk zzjkVar = new zzjk(null == true ? 1 : 0);
            this.zzv = zzjkVar;
            Handler handler = new Handler(zzifVar.zzi);
            zzle[] zzleVarArrZza = ((zzhy) zzifVar.zzc).zza.zza(handler, zzjiVar, zzjiVar, zzjiVar, zzjiVar);
            this.zzh = zzleVarArrZza;
            int length = zzleVarArrZza.length;
            zzyb zzybVar = (zzyb) zzifVar.zze.zza();
            this.zzi = zzybVar;
            zzif.zza(((zzhz) zzifVar.zzd).zza);
            zzyn zzynVarZzg = zzyn.zzg(((zzic) zzifVar.zzg).zza);
            this.zzs = zzynVarZzg;
            this.zzp = zzifVar.zzm;
            this.zzC = zzifVar.zzn;
            Looper looper = zzifVar.zzi;
            this.zzr = looper;
            zzdj zzdjVar = zzifVar.zzb;
            this.zzt = zzdjVar;
            this.zzg = zzbwVar;
            zzdz zzdzVar = new zzdz(looper, zzdjVar, new zzdx(this) { // from class: com.google.android.gms.internal.ads.zzjc
                @Override // com.google.android.gms.internal.ads.zzdx
                public final void zza(Object obj, zzab zzabVar) {
                }
            });
            this.zzl = zzdzVar;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzm = copyOnWriteArraySet;
            this.zzo = new ArrayList();
            this.zzW = new zzwa(0);
            this.zzD = zzig.zza;
            int length2 = zzleVarArrZza.length;
            zzyc zzycVar = new zzyc(new zzli[2], new zzxv[2], zzck.zza, null);
            this.zzb = zzycVar;
            this.zzn = new zzca();
            zzbr zzbrVar = new zzbr();
            zzbrVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzybVar.zzn();
            zzbrVar.zzd(29, true);
            zzbrVar.zzd(23, false);
            zzbrVar.zzd(25, false);
            zzbrVar.zzd(33, false);
            zzbrVar.zzd(26, false);
            zzbrVar.zzd(34, false);
            zzbt zzbtVarZze = zzbrVar.zze();
            this.zzc = zzbtVarZze;
            zzbr zzbrVar2 = new zzbr();
            zzbrVar2.zzb(zzbtVarZze);
            zzbrVar2.zza(4);
            zzbrVar2.zza(10);
            this.zzE = zzbrVar2.zze();
            this.zzj = zzdjVar.zzb(looper, null);
            zzii zziiVar = new zzii(this);
            this.zzV = zziiVar;
            this.zzS = zzkx.zzg(zzycVar);
            Apply.zzR(zzbwVar, looper);
            this.zzk = new zzjx(zzleVarArrZza, zzybVar, zzycVar, (zzkb) zzifVar.zzf.zza(), zzynVarZzg, 0, false, Apply, this.zzC, zzifVar.zzt, zzifVar.zzo, false, false, looper, zzdjVar, zziiVar, zzet.zza < 31 ? new zznz(zzifVar.zzs) : zzjd.zza(applicationContext, this, zzifVar.zzq, zzifVar.zzs), null, this.zzD);
            this.zzM = 1.0f;
            zzbh zzbhVar = zzbh.zza;
            this.zzF = zzbhVar;
            this.zzR = zzbhVar;
            this.zzT = -1;
            AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
            this.zzK = audioManager == null ? -1 : audioManager.generateAudioSessionId();
            int i = zzdc.zza;
            this.zzO = true;
            if (Apply == 0) {
                throw null;
            }
            zzdzVar.zzb(Apply);
            zzynVarZzg.zze(new Handler(looper), Apply);
            copyOnWriteArraySet.add(zzjiVar);
            new zzhh(zzifVar.zza, handler, zzjiVar);
            this.zzw = new zzhl(zzifVar.zza, handler, zzjiVar);
            zzet.zzG(null, null);
            new zzs(0).zza();
            zzcp zzcpVar = zzcp.zza;
            this.zzJ = zzel.zza;
            zzybVar.zzk(this.zzL);
            zzab(1, 10, Integer.valueOf(this.zzK));
            zzab(2, 10, Integer.valueOf(this.zzK));
            zzab(1, 3, this.zzL);
            zzab(2, 4, Integer.valueOf(this.zzI));
            zzab(2, 5, 0);
            zzab(1, 9, Boolean.valueOf(this.zzN));
            zzab(2, 7, zzjkVar);
            zzab(6, 8, zzjkVar);
            zzab(-1, 16, Integer.valueOf(this.zzQ));
            zzdmVar.zze();
        } catch (Throwable th) {
            this.zze.zze();
            throw th;
        }
    }

    public static /* bridge */ /* synthetic */ void zzK(zzjm zzjmVar, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzjmVar.zzad(surface);
        zzjmVar.zzH = surface;
    }

    private final int zzR(zzkx zzkxVar) {
        return zzkxVar.zza.zzo() ? this.zzT : zzkxVar.zza.zzn(zzkxVar.zzb.zza, this.zzn).zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzS(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    private final long zzT(zzkx zzkxVar) {
        if (!zzkxVar.zzb.zzb()) {
            return zzet.zzu(zzU(zzkxVar));
        }
        zzkxVar.zza.zzn(zzkxVar.zzb.zza, this.zzn);
        long j = zzkxVar.zzc;
        if (j == -9223372036854775807L) {
            long j2 = zzkxVar.zza.zze(zzR(zzkxVar), this.zza, 0L).zzl;
            return zzet.zzu(0L);
        }
        return zzet.zzu(0L) + zzet.zzu(j);
    }

    private final long zzU(zzkx zzkxVar) {
        if (zzkxVar.zza.zzo()) {
            return zzet.zzr(this.zzU);
        }
        long j = zzkxVar.zzr;
        if (zzkxVar.zzb.zzb()) {
            return j;
        }
        zzW(zzkxVar.zza, zzkxVar.zzb, j);
        return j;
    }

    private static long zzV(zzkx zzkxVar) {
        zzcb zzcbVar = new zzcb();
        zzca zzcaVar = new zzca();
        zzkxVar.zza.zzn(zzkxVar.zzb.zza, zzcaVar);
        long j = zzkxVar.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzkxVar.zza.zze(zzcaVar.zzc, zzcbVar, 0L).zzl;
        return 0L;
    }

    private final long zzW(zzcc zzccVar, zzui zzuiVar, long j) {
        zzccVar.zzn(zzuiVar.zza, this.zzn);
        return j;
    }

    private final Pair zzX(zzcc zzccVar, int i, long j) {
        if (zzccVar.zzo()) {
            this.zzT = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzU = j;
            return null;
        }
        if (i == -1 || i >= zzccVar.zzc()) {
            i = zzccVar.zzg(false);
            long j2 = zzccVar.zze(i, this.zza, 0L).zzl;
            j = zzet.zzu(0L);
        }
        return zzccVar.zzl(this.zza, this.zzn, i, zzet.zzr(j));
    }

    private final zzkx zzY(zzkx zzkxVar, zzcc zzccVar, Pair pair) {
        zzdi.zzd(zzccVar.zzo() || pair != null);
        zzcc zzccVar2 = zzkxVar.zza;
        long jZzT = zzT(zzkxVar);
        zzkx zzkxVarZzf = zzkxVar.zzf(zzccVar);
        if (zzccVar.zzo()) {
            zzui zzuiVarZzh = zzkx.zzh();
            long jZzr = zzet.zzr(this.zzU);
            zzkx zzkxVarZza = zzkxVarZzf.zzb(zzuiVarZzh, jZzr, jZzr, jZzr, 0L, zzwi.zza, this.zzb, zzfxr.zzm()).zza(zzuiVarZzh);
            zzkxVarZza.zzp = zzkxVarZza.zzr;
            return zzkxVarZza;
        }
        Object obj = zzkxVarZzf.zzb.zza;
        int i = zzet.zza;
        boolean zEquals = obj.equals(pair.first);
        zzui zzuiVar = !zEquals ? new zzui(pair.first, -1L) : zzkxVarZzf.zzb;
        long jLongValue = ((Long) pair.second).longValue();
        long jZzr2 = zzet.zzr(jZzT);
        if (!zzccVar2.zzo()) {
            zzccVar2.zzn(obj, this.zzn);
        }
        if (!zEquals || jLongValue < jZzr2) {
            zzui zzuiVar2 = zzuiVar;
            zzdi.zzf(!zzuiVar2.zzb());
            zzkx zzkxVarZza2 = zzkxVarZzf.zzb(zzuiVar2, jLongValue, jLongValue, jLongValue, 0L, !zEquals ? zzwi.zza : zzkxVarZzf.zzh, !zEquals ? this.zzb : zzkxVarZzf.zzi, !zEquals ? zzfxr.zzm() : zzkxVarZzf.zzj).zza(zzuiVar2);
            zzkxVarZza2.zzp = jLongValue;
            return zzkxVarZza2;
        }
        if (jLongValue != jZzr2) {
            zzui zzuiVar3 = zzuiVar;
            zzdi.zzf(!zzuiVar3.zzb());
            long jMax = Math.max(0L, zzkxVarZzf.zzq - (jLongValue - jZzr2));
            long j = zzkxVarZzf.zzp;
            if (zzkxVarZzf.zzk.equals(zzkxVarZzf.zzb)) {
                j = jLongValue + jMax;
            }
            zzkx zzkxVarZzb = zzkxVarZzf.zzb(zzuiVar3, jLongValue, jLongValue, jLongValue, jMax, zzkxVarZzf.zzh, zzkxVarZzf.zzi, zzkxVarZzf.zzj);
            zzkxVarZzb.zzp = j;
            return zzkxVarZzb;
        }
        int iZza = zzccVar.zza(zzkxVarZzf.zzk.zza);
        if (iZza != -1 && zzccVar.zzd(iZza, this.zzn, false).zzc == zzccVar.zzn(zzuiVar.zza, this.zzn).zzc) {
            return zzkxVarZzf;
        }
        zzccVar.zzn(zzuiVar.zza, this.zzn);
        long jZzh = zzuiVar.zzb() ? this.zzn.zzh(zzuiVar.zzb, zzuiVar.zzc) : this.zzn.zzd;
        zzui zzuiVar4 = zzuiVar;
        zzkx zzkxVarZza3 = zzkxVarZzf.zzb(zzuiVar4, zzkxVarZzf.zzr, zzkxVarZzf.zzr, zzkxVarZzf.zzd, jZzh - zzkxVarZzf.zzr, zzkxVarZzf.zzh, zzkxVarZzf.zzi, zzkxVarZzf.zzj).zza(zzuiVar4);
        zzkxVarZza3.zzp = jZzh;
        return zzkxVarZza3;
    }

    private final zzla zzZ(zzkz zzkzVar) {
        int iZzR = zzR(this.zzS);
        zzcc zzccVar = this.zzS.zza;
        int i = iZzR == -1 ? 0 : iZzR;
        zzdj zzdjVar = this.zzt;
        zzjx zzjxVar = this.zzk;
        return new zzla(zzjxVar, zzkzVar, zzccVar, i, zzdjVar, zzjxVar.zzc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(final int i, final int i2) {
        if (i == this.zzJ.zzb() && i2 == this.zzJ.zza()) {
            return;
        }
        this.zzJ = new zzel(i, i2);
        zzdz zzdzVar = this.zzl;
        zzdzVar.zzd(24, new zzdw() { // from class: com.google.android.gms.internal.ads.zziz
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i3 = zzjm.zzd;
                ((zzbu) obj).zzo(i, i2);
            }
        });
        zzdzVar.zzc();
        zzab(2, 14, new zzel(i, i2));
    }

    private final void zzab(int i, int i2, Object obj) {
        zzle[] zzleVarArr = this.zzh;
        int length = zzleVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzle zzleVar = zzleVarArr[i3];
            if (i == -1 || zzleVar.zzb() == i) {
                zzla zzlaVarZzZ = zzZ(zzleVar);
                zzlaVarZzZ.zzf(i2);
                zzlaVarZzZ.zze(obj);
                zzlaVarZzZ.zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzac() {
        zzab(1, 2, Float.valueOf(this.zzM * this.zzw.zza()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzad(Object obj) {
        ArrayList arrayList = new ArrayList();
        zzle[] zzleVarArr = this.zzh;
        int length = zzleVarArr.length;
        boolean z = false;
        for (int i = 0; i < 2; i++) {
            zzle zzleVar = zzleVarArr[i];
            if (zzleVar.zzb() == 2) {
                zzla zzlaVarZzZ = zzZ(zzleVar);
                zzlaVarZzZ.zzf(1);
                zzlaVarZzZ.zze(obj);
                zzlaVarZzZ.zzd();
                arrayList.add(zzlaVarZzZ);
            }
        }
        Object obj2 = this.zzG;
        if (obj2 != null && obj2 != obj) {
            try {
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj3 = arrayList.get(i2);
                    i2++;
                    ((zzla) obj3).zzi(this.zzx);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z = true;
            }
            Object obj4 = this.zzG;
            Surface surface = this.zzH;
            if (obj4 == surface) {
                surface.release();
                this.zzH = null;
            }
        }
        this.zzG = obj;
        if (z) {
            zzae(zzhw.zzd(new zzjy(3), 1003));
        }
    }

    private final void zzae(zzhw zzhwVar) {
        zzkx zzkxVar = this.zzS;
        zzkx zzkxVarZza = zzkxVar.zza(zzkxVar.zzb);
        zzkxVarZza.zzp = zzkxVarZza.zzr;
        zzkxVarZza.zzq = 0L;
        zzkx zzkxVarZze = zzkxVarZza.zze(1);
        if (zzhwVar != null) {
            zzkxVarZze = zzkxVarZze.zzd(zzhwVar);
        }
        this.zzy++;
        this.zzk.zzn();
        zzag(zzkxVarZze, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaf(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        zzkx zzkxVar = this.zzS;
        if (zzkxVar.zzl == z2 && zzkxVar.zzm == i3) {
            return;
        }
        this.zzy++;
        zzkx zzkxVarZzc = zzkxVar.zzc(z2, i3);
        this.zzk.zzm(z2, i3);
        zzag(zzkxVarZzc, 0, i2, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0482 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x048c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0496 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04da A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02a5  */
    /* JADX WARN: Type inference failed for: r12v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzag(final com.google.android.gms.internal.ads.zzkx r35, final int r36, final int r37, boolean r38, int r39, long r40, int r42, boolean r43) {
        /*
            Method dump skipped, instruction units count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjm.zzag(com.google.android.gms.internal.ads.zzkx, int, int, boolean, int, long, int, boolean):void");
    }

    private final void zzah() {
        int iZzf = zzf();
        if (iZzf == 2 || iZzf == 3) {
            zzai();
            boolean z = this.zzS.zzo;
            zzu();
            zzu();
        }
    }

    private final void zzai() {
        this.zze.zzb();
        if (Thread.currentThread() != this.zzr.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = this.zzr.getThread().getName();
            Locale locale = Locale.US;
            String str = "Player is accessed on the wrong thread.\nCurrent thread: '" + name + "'\nExpected thread: '" + name2 + "'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread";
            if (this.zzO) {
                throw new IllegalStateException(str);
            }
            zzea.zzg("ExoPlayerImpl", str, this.zzP ? null : new IllegalStateException());
            this.zzP = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void zzA(zzlq zzlqVar) {
        zzai();
        this.zzq.zzQ(zzlqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void zzB(zzuk zzukVar) {
        zzai();
        List listSingletonList = Collections.singletonList(zzukVar);
        zzai();
        zzai();
        zzR(this.zzS);
        zzk();
        this.zzy++;
        boolean z = false;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i = size - 1; i >= 0; i--) {
                this.zzo.remove(i);
            }
            this.zzW = this.zzW.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listSingletonList.size(); i2++) {
            zzku zzkuVar = new zzku((zzuk) listSingletonList.get(i2), this.zzp);
            arrayList.add(zzkuVar);
            this.zzo.add(i2, new zzjl(zzkuVar.zzb, zzkuVar.zza));
        }
        this.zzW = this.zzW.zzg(0, arrayList.size());
        zzlc zzlcVar = new zzlc(this.zzo, this.zzW);
        if (!zzlcVar.zzo() && zzlcVar.zzc() < 0) {
            throw new zzaj(zzlcVar, -1, -9223372036854775807L);
        }
        int iZzg = zzlcVar.zzg(false);
        zzkx zzkxVarZzY = zzY(this.zzS, zzlcVar, zzX(zzlcVar, iZzg, -9223372036854775807L));
        int i3 = zzkxVarZzY.zze;
        if (iZzg != -1 && i3 != 1) {
            i3 = 4;
            if (!zzlcVar.zzo() && iZzg < zzlcVar.zzc()) {
                i3 = 2;
            }
        }
        zzkx zzkxVarZze = zzkxVarZzY.zze(i3);
        this.zzk.zzp(arrayList, iZzg, zzet.zzr(-9223372036854775807L), this.zzW);
        if (!this.zzS.zzb.zza.equals(zzkxVarZze.zzb.zza) && !this.zzS.zza.zzo()) {
            z = true;
        }
        zzag(zzkxVarZze, 0, 1, z, 4, zzU(zzkxVarZze), -1, false);
    }

    public final zzhw zzE() {
        zzai();
        return this.zzS.zzf;
    }

    public final /* synthetic */ void zzN(zzjv zzjvVar) {
        int i = this.zzy - zzjvVar.zzb;
        this.zzy = i;
        boolean z = true;
        if (zzjvVar.zzc) {
            this.zzz = zzjvVar.zzd;
            this.zzA = true;
        }
        if (zzjvVar.zze) {
            this.zzB = zzjvVar.zzf;
        }
        if (i == 0) {
            zzcc zzccVar = zzjvVar.zza.zza;
            if (!this.zzS.zza.zzo() && zzccVar.zzo()) {
                this.zzT = -1;
                this.zzU = 0L;
            }
            if (!zzccVar.zzo()) {
                List listZzw = ((zzlc) zzccVar).zzw();
                zzdi.zzf(listZzw.size() == this.zzo.size());
                for (int i2 = 0; i2 < listZzw.size(); i2++) {
                    ((zzjl) this.zzo.get(i2)).zzc((zzcc) listZzw.get(i2));
                }
            }
            long j = -9223372036854775807L;
            if (this.zzA) {
                if (zzjvVar.zza.zzb.equals(this.zzS.zzb) && zzjvVar.zza.zzd == this.zzS.zzr) {
                    z = false;
                }
                if (z) {
                    if (zzccVar.zzo() || zzjvVar.zza.zzb.zzb()) {
                        j = zzjvVar.zza.zzd;
                    } else {
                        zzkx zzkxVar = zzjvVar.zza;
                        zzui zzuiVar = zzkxVar.zzb;
                        long j2 = zzkxVar.zzd;
                        zzW(zzccVar, zzuiVar, j2);
                        j = j2;
                    }
                }
            } else {
                z = false;
            }
            this.zzA = false;
            zzag(zzjvVar.zza, 1, this.zzB, z, this.zzz, j, -1, false);
        }
    }

    public final /* synthetic */ void zzO(final zzjv zzjvVar) {
        this.zzj.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzN(zzjvVar);
            }
        });
    }

    public final /* synthetic */ void zzP(zzbu zzbuVar) {
        zzbuVar.zza(this.zzE);
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final void zza(int i, long j, int i2, boolean z) {
        zzai();
        if (i == -1) {
            return;
        }
        zzdi.zzd(i >= 0);
        zzcc zzccVar = this.zzS.zza;
        if (zzccVar.zzo() || i < zzccVar.zzc()) {
            this.zzq.zzu();
            this.zzy++;
            if (zzw()) {
                zzea.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzjv zzjvVar = new zzjv(this.zzS);
                zzjvVar.zza(1);
                this.zzV.zza.zzO(zzjvVar);
                return;
            }
            zzkx zzkxVarZze = this.zzS;
            int i3 = zzkxVarZze.zze;
            if (i3 == 3 || (i3 == 4 && !zzccVar.zzo())) {
                zzkxVarZze = this.zzS.zze(2);
            }
            int iZzd = zzd();
            zzkx zzkxVarZzY = zzY(zzkxVarZze, zzccVar, zzX(zzccVar, i, j));
            this.zzk.zzk(zzccVar, i, zzet.zzr(j));
            zzag(zzkxVarZzY, 0, 1, true, 1, zzU(zzkxVarZzY), iZzd, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzb() {
        zzai();
        if (zzw()) {
            return this.zzS.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzc() {
        zzai();
        if (zzw()) {
            return this.zzS.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzd() {
        zzai();
        int iZzR = zzR(this.zzS);
        if (iZzR == -1) {
            return 0;
        }
        return iZzR;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zze() {
        zzai();
        if (this.zzS.zza.zzo()) {
            return 0;
        }
        zzkx zzkxVar = this.zzS;
        return zzkxVar.zza.zza(zzkxVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzf() {
        zzai();
        return this.zzS.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzg() {
        zzai();
        return this.zzS.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final int zzh() {
        zzai();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final long zzi() {
        zzai();
        if (zzw()) {
            zzkx zzkxVar = this.zzS;
            return zzkxVar.zzk.equals(zzkxVar.zzb) ? zzet.zzu(this.zzS.zzp) : zzl();
        }
        zzai();
        if (this.zzS.zza.zzo()) {
            return this.zzU;
        }
        zzkx zzkxVar2 = this.zzS;
        long j = 0;
        if (zzkxVar2.zzk.zzd != zzkxVar2.zzb.zzd) {
            return zzet.zzu(zzkxVar2.zza.zze(zzd(), this.zza, 0L).zzm);
        }
        long j2 = zzkxVar2.zzp;
        if (this.zzS.zzk.zzb()) {
            zzkx zzkxVar3 = this.zzS;
            zzkxVar3.zza.zzn(zzkxVar3.zzk.zza, this.zzn).zzi(this.zzS.zzk.zzb);
        } else {
            j = j2;
        }
        zzkx zzkxVar4 = this.zzS;
        zzW(zzkxVar4.zza, zzkxVar4.zzk, j);
        return zzet.zzu(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final long zzj() {
        zzai();
        return zzT(this.zzS);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final long zzk() {
        zzai();
        return zzet.zzu(zzU(this.zzS));
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final long zzl() {
        zzai();
        if (zzw()) {
            zzkx zzkxVar = this.zzS;
            zzui zzuiVar = zzkxVar.zzb;
            zzkxVar.zza.zzn(zzuiVar.zza, this.zzn);
            return zzet.zzu(this.zzn.zzh(zzuiVar.zzb, zzuiVar.zzc));
        }
        zzcc zzccVarZzn = zzn();
        if (zzccVarZzn.zzo()) {
            return -9223372036854775807L;
        }
        return zzet.zzu(zzccVarZzn.zze(zzd(), this.zza, 0L).zzm);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final long zzm() {
        zzai();
        return zzet.zzu(this.zzS.zzq);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final zzcc zzn() {
        zzai();
        return this.zzS.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final zzck zzo() {
        zzai();
        return this.zzS.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final void zzp() {
        zzai();
        zzhl zzhlVar = this.zzw;
        boolean zZzu = zzu();
        int iZzb = zzhlVar.zzb(zZzu, 2);
        zzaf(zZzu, iZzb, zzS(zZzu, iZzb));
        zzkx zzkxVar = this.zzS;
        if (zzkxVar.zze != 1) {
            return;
        }
        zzkx zzkxVarZzd = zzkxVar.zzd(null);
        zzkx zzkxVarZze = zzkxVarZzd.zze(true == zzkxVarZzd.zza.zzo() ? 4 : 2);
        this.zzy++;
        this.zzk.zzj();
        zzag(zzkxVarZze, 1, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final void zzq(boolean z) {
        zzai();
        int iZzb = this.zzw.zzb(z, zzf());
        zzaf(z, iZzb, zzS(z, iZzb));
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final void zzr(Surface surface) {
        zzai();
        zzad(surface);
        int i = surface == null ? 0 : -1;
        zzaa(i, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final void zzs(float f) {
        zzai();
        final float fMax = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzM == fMax) {
            return;
        }
        this.zzM = fMax;
        zzac();
        zzdz zzdzVar = this.zzl;
        zzdzVar.zzd(22, new zzdw() { // from class: com.google.android.gms.internal.ads.zziq
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i = zzjm.zzd;
                ((zzbu) obj).zzs(fMax);
            }
        });
        zzdzVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final void zzt() {
        zzai();
        this.zzw.zzb(zzu(), 1);
        zzae(null);
        int i = zzdc.zza;
        zzfxr zzfxrVarZzm = zzfxr.zzm();
        long j = this.zzS.zzr;
        zzfxr.zzk(zzfxrVarZzm);
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final boolean zzu() {
        zzai();
        return this.zzS.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final boolean zzv() {
        zzai();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbw
    public final boolean zzw() {
        zzai();
        return this.zzS.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final int zzx() {
        zzai();
        int length = this.zzh.length;
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void zzy(zzlq zzlqVar) {
        this.zzq.zzt(zzlqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzih
    public final void zzz() {
        zzea.zze("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.4.0-alpha02] [" + zzet.zze + "] [" + zzbd.zza() + "]");
        zzai();
        this.zzw.zzd();
        if (!this.zzk.zzo()) {
            zzdz zzdzVar = this.zzl;
            zzdzVar.zzd(10, new zzdw() { // from class: com.google.android.gms.internal.ads.zzja
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj) {
                    ((zzbu) obj).zzj(zzhw.zzd(new zzjy(1), 1003));
                }
            });
            zzdzVar.zzc();
        }
        this.zzl.zze();
        this.zzj.zze(null);
        this.zzs.zzf(this.zzq);
        zzkx zzkxVar = this.zzS;
        boolean z = zzkxVar.zzo;
        zzkx zzkxVarZze = zzkxVar.zze(1);
        this.zzS = zzkxVarZze;
        zzkx zzkxVarZza = zzkxVarZze.zza(zzkxVarZze.zzb);
        this.zzS = zzkxVarZza;
        zzkxVarZza.zzp = zzkxVarZza.zzr;
        this.zzS.zzq = 0L;
        this.zzq.zzP();
        this.zzi.zzj();
        Surface surface = this.zzH;
        if (surface != null) {
            surface.release();
            this.zzH = null;
        }
        int i = zzdc.zza;
    }
}
