package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import androidx.constraintlayout.motion.widget.MotionScene;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaaa extends zzso implements zzaag {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private zzcp zzA;
    private zzcp zzB;
    private boolean zzC;
    private int zzD;
    private int zzE;
    private zzaae zzF;
    private final Context zze;
    private final zzabc zzf;
    private final zzaax zzg;
    private final boolean zzh;
    private final zzaah zzi;
    private final zzaaf zzj;
    private boolean zzk;
    private boolean zzl;
    private zzzz zzm;
    private boolean zzn;
    private boolean zzo;
    private Surface zzp;
    private zzaad zzq;
    private boolean zzr;
    private int zzs;
    private long zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private int zzy;
    private long zzz;

    public zzaaa(Context context, zzsa zzsaVar, zzsq zzsqVar, long j, boolean z, Handler handler, zzaay zzaayVar, int i, float f) {
        super(2, zzsaVar, zzsqVar, false, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        this.zzg = new zzaax(handler, zzaayVar);
        zzzt zzztVarZzc = new zzzg(applicationContext, new zzaah(applicationContext, this, 0L)).zzc();
        this.zzf = zzztVarZzc.zzi();
        zzaah zzaahVarZzh = zzztVarZzc.zzh();
        zzdi.zzb(zzaahVarZzh);
        this.zzi = zzaahVarZzh;
        this.zzj = new zzaaf();
        this.zzh = "NVIDIA".equals(zzet.zzc);
        this.zzs = 1;
        this.zzA = zzcp.zza;
        this.zzE = 0;
        this.zzB = null;
        this.zzD = -1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean zzaS(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 2926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaa.zzaS(java.lang.String):boolean");
    }

    private static List zzaT(Context context, zzsq zzsqVar, zzaf zzafVar, boolean z, boolean z2) {
        String str = zzafVar.zzm;
        if (str == null) {
            return zzfxr.zzm();
        }
        if (zzet.zza >= 26 && "video/dolby-vision".equals(str) && !zzzy.zza(context)) {
            List listZzd = zztc.zzd(zzsqVar, zzafVar, z, z2);
            if (!listZzd.isEmpty()) {
                return listZzd;
            }
        }
        return zztc.zzf(zzsqVar, zzafVar, z, z2);
    }

    private final void zzaU() {
        zzcp zzcpVar = this.zzB;
        if (zzcpVar != null) {
            this.zzg.zzt(zzcpVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaV() {
        this.zzg.zzq(this.zzp);
        this.zzr = true;
    }

    private final void zzaW() {
        Surface surface = this.zzp;
        zzaad zzaadVar = this.zzq;
        if (surface == zzaadVar) {
            this.zzp = null;
        }
        if (zzaadVar != null) {
            zzaadVar.release();
            this.zzq = null;
        }
    }

    private final boolean zzaX(zzsf zzsfVar) {
        if (zzet.zza < 23 || zzaS(zzsfVar.zza)) {
            return false;
        }
        return !zzsfVar.zzf || zzaad.zzb(this.zze);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zzad(com.google.android.gms.internal.ads.zzsf r10, com.google.android.gms.internal.ads.zzaf r11) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaa.zzad(com.google.android.gms.internal.ads.zzsf, com.google.android.gms.internal.ads.zzaf):int");
    }

    public static int zzae(zzsf zzsfVar, zzaf zzafVar) {
        if (zzafVar.zzn == -1) {
            return zzad(zzsfVar, zzafVar);
        }
        int size = zzafVar.zzo.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += ((byte[]) zzafVar.zzo.get(i)).length;
        }
        return zzafVar.zzn + length;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void zzA() {
        ((zzzr) this.zzf).zza.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    public final void zzC() {
        try {
            super.zzC();
            this.zzl = false;
            if (this.zzq != null) {
                zzaW();
            }
        } catch (Throwable th) {
            this.zzl = false;
            if (this.zzq != null) {
                zzaW();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void zzD() {
        this.zzu = 0;
        zzh();
        this.zzt = SystemClock.elapsedRealtime();
        this.zzx = 0L;
        this.zzy = 0;
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zzg();
        } else {
            this.zzi.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void zzE() {
        if (this.zzu > 0) {
            zzh();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzu, jElapsedRealtime - this.zzt);
            this.zzu = 0;
            this.zzt = jElapsedRealtime;
        }
        int i = this.zzy;
        if (i != 0) {
            this.zzg.zzr(this.zzx, i);
            this.zzx = 0L;
            this.zzy = 0;
        }
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zzh();
        } else {
            this.zzi.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzle
    public final void zzM(float f, float f2) {
        super.zzM(f, f2);
        this.zzi.zzm(f);
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zze.zzd(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzle, com.google.android.gms.internal.ads.zzlh
    public final String zzU() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzle
    public final void zzV(long j, long j2) throws zzhw {
        super.zzV(j, j2);
        if (this.zzk) {
            try {
                this.zzf.zzg(j, j2);
            } catch (zzabb e) {
                throw zzi(e, e.zza, false, 7001);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzle
    public final boolean zzW() {
        return super.zzW() && !this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzle
    public final boolean zzX() {
        zzaad zzaadVar;
        boolean z = false;
        if (super.zzX() && !this.zzk) {
            z = true;
        }
        if (!z || (((zzaadVar = this.zzq) == null || this.zzp != zzaadVar) && zzay() != null)) {
            return this.zzi.zzn(z);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final float zzZ(float f, zzaf zzafVar, zzaf[] zzafVarArr) {
        float fMax = -1.0f;
        for (zzaf zzafVar2 : zzafVarArr) {
            float f2 = zzafVar2.zzt;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzaC(long j) {
        super.zzaC(j);
        this.zzw--;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzaD(zzhd zzhdVar) {
        this.zzw++;
        int i = zzet.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzaE(zzaf zzafVar) throws zzhw {
        if (this.zzk) {
            try {
                zzabc zzabcVar = this.zzf;
                zzzt.zzd(((zzzr) zzabcVar).zza, zzafVar, zzh());
                this.zzf.zzh(new zzzx(this), zzgda.zzb());
            } catch (zzabb e) {
                throw zzi(e, zzafVar, false, 7000);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzaG() {
        super.zzaG();
        this.zzw = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final boolean zzaM(zzsf zzsfVar) {
        return this.zzp != null || zzaX(zzsfVar);
    }

    public final void zzaO(zzsc zzscVar, int i, long j) {
        Trace.beginSection("skipVideoBuffer");
        zzscVar.zzn(i, false);
        Trace.endSection();
        ((zzso) this).zza.zzf++;
    }

    public final void zzaP(int i, int i2) {
        zzhn zzhnVar = ((zzso) this).zza;
        zzhnVar.zzh += i;
        int i3 = i + i2;
        zzhnVar.zzg += i3;
        this.zzu += i3;
        int i4 = this.zzv + i3;
        this.zzv = i4;
        zzhnVar.zzi = Math.max(i4, zzhnVar.zzi);
    }

    public final void zzaQ(long j) {
        zzhn zzhnVar = ((zzso) this).zza;
        zzhnVar.zzk += j;
        zzhnVar.zzl++;
        this.zzx += j;
        this.zzy++;
    }

    public final boolean zzaR(long j, boolean z) {
        int iZzd = zzd(j);
        if (iZzd == 0) {
            return false;
        }
        if (z) {
            zzhn zzhnVar = ((zzso) this).zza;
            zzhnVar.zzd += iZzd;
            zzhnVar.zzf += this.zzw;
        } else {
            ((zzso) this).zza.zzj++;
            zzaP(iZzd, this.zzw);
        }
        zzaI();
        if (this.zzk) {
            this.zzf.zze();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final int zzaa(zzsq zzsqVar, zzaf zzafVar) {
        boolean z;
        if (!zzbn.zzi(zzafVar.zzm)) {
            return 128;
        }
        int i = 1;
        int i2 = 0;
        boolean z2 = zzafVar.zzp != null;
        List listZzaT = zzaT(this.zze, zzsqVar, zzafVar, z2, false);
        if (z2 && listZzaT.isEmpty()) {
            listZzaT = zzaT(this.zze, zzsqVar, zzafVar, false, false);
        }
        if (!listZzaT.isEmpty()) {
            if (zzso.zzaN(zzafVar)) {
                zzsf zzsfVar = (zzsf) listZzaT.get(0);
                boolean zZze = zzsfVar.zze(zzafVar);
                if (zZze) {
                    z = true;
                } else {
                    for (int i3 = 1; i3 < listZzaT.size(); i3++) {
                        zzsf zzsfVar2 = (zzsf) listZzaT.get(i3);
                        if (zzsfVar2.zze(zzafVar)) {
                            zzsfVar = zzsfVar2;
                            z = false;
                            zZze = true;
                            break;
                        }
                    }
                    z = true;
                }
                int i4 = true != zZze ? 3 : 4;
                int i5 = true != zzsfVar.zzf(zzafVar) ? 8 : 16;
                int i6 = true != zzsfVar.zzg ? 0 : 64;
                int i7 = true != z ? 0 : 128;
                if (zzet.zza >= 26 && "video/dolby-vision".equals(zzafVar.zzm) && !zzzy.zza(this.zze)) {
                    i7 = MotionScene.Transition.TransitionOnClick.JUMP_TO_END;
                }
                if (zZze) {
                    List listZzaT2 = zzaT(this.zze, zzsqVar, zzafVar, z2, true);
                    if (!listZzaT2.isEmpty()) {
                        zzsf zzsfVar3 = (zzsf) zztc.zzg(listZzaT2, zzafVar).get(0);
                        if (zzsfVar3.zze(zzafVar) && zzsfVar3.zzf(zzafVar)) {
                            i2 = 32;
                        }
                    }
                }
                return i4 | i5 | i2 | i6 | i7;
            }
            i = 2;
        }
        return i | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzho zzab(zzsf zzsfVar, zzaf zzafVar, zzaf zzafVar2) {
        int i;
        int i2;
        zzho zzhoVarZzb = zzsfVar.zzb(zzafVar, zzafVar2);
        int i3 = zzhoVarZzb.zze;
        zzzz zzzzVar = this.zzm;
        zzzzVar.getClass();
        if (zzafVar2.zzr > zzzzVar.zza || zzafVar2.zzs > zzzzVar.zzb) {
            i3 |= MotionScene.Transition.TransitionOnClick.JUMP_TO_END;
        }
        if (zzae(zzsfVar, zzafVar2) > zzzzVar.zzc) {
            i3 |= 64;
        }
        String str = zzsfVar.zza;
        if (i3 != 0) {
            i2 = i3;
            i = 0;
        } else {
            i = zzhoVarZzb.zzd;
            i2 = 0;
        }
        return new zzho(str, zzafVar, zzafVar2, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzho zzac(zzjz zzjzVar) {
        zzho zzhoVarZzac = super.zzac(zzjzVar);
        zzaf zzafVar = zzjzVar.zza;
        zzafVar.getClass();
        this.zzg.zzf(zzafVar, zzhoVarZzac);
        return zzhoVarZzac;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzrz zzaf(zzsf zzsfVar, zzaf zzafVar, MediaCrypto mediaCrypto, float f) {
        Point pointZza;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        boolean z2;
        Pair pairZza;
        int iZzad;
        zzaad zzaadVar = this.zzq;
        if (zzaadVar != null) {
            if (zzaadVar.zza != zzsfVar.zzf) {
                zzaW();
            }
        }
        String str = zzsfVar.zzc;
        zzaf[] zzafVarArrZzT = zzT();
        int iMax = zzafVar.zzr;
        int iMax2 = zzafVar.zzs;
        int iZzae = zzae(zzsfVar, zzafVar);
        int length = zzafVarArrZzT.length;
        if (length != 1) {
            boolean z3 = false;
            for (int i5 = 0; i5 < length; i5++) {
                zzaf zzafVarZzad = zzafVarArrZzT[i5];
                if (zzafVar.zzy != null && zzafVarZzad.zzy == null) {
                    zzad zzadVarZzb = zzafVarZzad.zzb();
                    zzadVarZzb.zzA(zzafVar.zzy);
                    zzafVarZzad = zzadVarZzb.zzad();
                }
                if (zzsfVar.zzb(zzafVar, zzafVarZzad).zzd != 0) {
                    int i6 = zzafVarZzad.zzr;
                    z3 |= i6 == -1 || zzafVarZzad.zzs == -1;
                    int iMax3 = Math.max(iMax, i6);
                    int iMax4 = Math.max(iMax2, zzafVarZzad.zzs);
                    iZzae = Math.max(iZzae, zzae(zzsfVar, zzafVarZzad));
                    iMax2 = iMax4;
                    iMax = iMax3;
                }
            }
            if (z3) {
                zzea.zzf("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
                int i7 = zzafVar.zzs;
                int i8 = zzafVar.zzr;
                boolean z4 = i7 > i8;
                int i9 = z4 ? i7 : i8;
                if (true == z4) {
                    i7 = i8;
                }
                int[] iArr = zzb;
                int i10 = 0;
                while (i10 < 9) {
                    float f2 = i7;
                    int[] iArr2 = iArr;
                    float f3 = i9;
                    int i11 = iArr2[i10];
                    int i12 = i10;
                    float f4 = i11;
                    if (i11 <= i9 || (i = (int) ((f2 / f3) * f4)) <= i7) {
                        break;
                    }
                    int i13 = zzet.zza;
                    if (true != z4) {
                        i2 = i7;
                        i3 = i11;
                    } else {
                        i2 = i7;
                        i3 = i;
                    }
                    if (true != z4) {
                        i11 = i;
                    }
                    pointZza = zzsfVar.zza(i3, i11);
                    float f5 = zzafVar.zzt;
                    if (pointZza != null) {
                        z = z4;
                        if (zzsfVar.zzg(pointZza.x, pointZza.y, f5)) {
                            break;
                        }
                    } else {
                        z = z4;
                    }
                    i10 = i12 + 1;
                    iArr = iArr2;
                    i7 = i2;
                    z4 = z;
                }
                pointZza = null;
                if (pointZza != null) {
                    iMax = Math.max(iMax, pointZza.x);
                    iMax2 = Math.max(iMax2, pointZza.y);
                    zzad zzadVarZzb2 = zzafVar.zzb();
                    zzadVarZzb2.zzac(iMax);
                    zzadVarZzb2.zzI(iMax2);
                    iZzae = Math.max(iZzae, zzad(zzsfVar, zzadVarZzb2.zzad()));
                    zzea.zzf("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
                }
            }
        } else if (iZzae != -1 && (iZzad = zzad(zzsfVar, zzafVar)) != -1) {
            iZzae = Math.min((int) (iZzae * 1.5f), iZzad);
        }
        zzzz zzzzVar = new zzzz(iMax, iMax2, iZzae);
        this.zzm = zzzzVar;
        boolean z5 = this.zzh;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", zzafVar.zzr);
        mediaFormat.setInteger("height", zzafVar.zzs);
        zzed.zzb(mediaFormat, zzafVar.zzo);
        float f6 = zzafVar.zzt;
        if (f6 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f6);
        }
        zzed.zza(mediaFormat, "rotation-degrees", zzafVar.zzu);
        zzo zzoVar = zzafVar.zzy;
        if (zzoVar != null) {
            zzed.zza(mediaFormat, "color-transfer", zzoVar.zzd);
            zzed.zza(mediaFormat, "color-standard", zzoVar.zzb);
            zzed.zza(mediaFormat, "color-range", zzoVar.zzc);
            byte[] bArr = zzoVar.zze;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzafVar.zzm) && (pairZza = zztc.zza(zzafVar)) != null) {
            zzed.zza(mediaFormat, "profile", ((Integer) pairZza.first).intValue());
        }
        mediaFormat.setInteger("max-width", zzzzVar.zza);
        mediaFormat.setInteger("max-height", zzzzVar.zzb);
        zzed.zza(mediaFormat, "max-input-size", zzzzVar.zzc);
        int i14 = zzet.zza;
        if (i14 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z5) {
            mediaFormat.setInteger("no-post-process", 1);
            i4 = 0;
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            i4 = 0;
        }
        if (i14 >= 35) {
            mediaFormat.setInteger("importance", Math.max(i4, -this.zzD));
        }
        if (this.zzp == null) {
            if (!zzaX(zzsfVar)) {
                throw new IllegalStateException();
            }
            if (this.zzq == null) {
                this.zzq = zzaad.zza(this.zze, zzsfVar.zzf);
            }
            this.zzp = this.zzq;
        }
        if (!this.zzk || this.zzf.zzk()) {
            z2 = false;
        } else {
            z2 = false;
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        if (!this.zzk) {
            return zzrz.zzb(zzsfVar, mediaFormat, zzafVar, this.zzp, null);
        }
        zzdi.zzf(z2);
        zzdi.zzb(null);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final List zzag(zzsq zzsqVar, zzaf zzafVar, boolean z) {
        return zztc.zzg(zzaT(this.zze, zzsqVar, zzafVar, false, false), zzafVar);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzaj(zzhd zzhdVar) {
        if (this.zzo) {
            ByteBuffer byteBuffer = zzhdVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzsc zzscVarZzay = zzay();
                        zzscVarZzay.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzscVarZzay.zzp(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzak(Exception exc) {
        zzea.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzal(String str, zzrz zzrzVar, long j, long j2) {
        this.zzg.zza(str, j, j2);
        this.zzn = zzaS(str);
        zzsf zzsfVarZzaA = zzaA();
        zzsfVarZzaA.getClass();
        boolean z = false;
        if (zzet.zza >= 29 && "video/x-vnd.on2.vp9".equals(zzsfVarZzaA.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzh = zzsfVarZzaA.zzh();
            int length = codecProfileLevelArrZzh.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (codecProfileLevelArrZzh[i].profile == 16384) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.zzo = z;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzam(String str) {
        this.zzg.zzb(str);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzan(zzaf zzafVar, MediaFormat mediaFormat) {
        zzsc zzscVarZzay = zzay();
        if (zzscVarZzay != null) {
            zzscVarZzay.zzq(this.zzs);
        }
        mediaFormat.getClass();
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer2 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        float f = zzafVar.zzv;
        int i = zzet.zza;
        int i2 = zzafVar.zzu;
        if (i2 == 90 || i2 == 270) {
            f = 1.0f / f;
            int i3 = integer2;
            integer2 = integer;
            integer = i3;
        }
        this.zzA = new zzcp(integer, integer2, 0, f);
        if (!this.zzk) {
            this.zzi.zzk(zzafVar.zzt);
            return;
        }
        zzabc zzabcVar = this.zzf;
        zzad zzadVarZzb = zzafVar.zzb();
        zzadVarZzb.zzac(integer);
        zzadVarZzb.zzI(integer2);
        zzadVarZzb.zzW(0);
        zzadVarZzb.zzT(f);
        zzabcVar.zzf(1, zzadVarZzb.zzad());
    }

    public final void zzao(zzsc zzscVar, int i, long j, long j2) {
        Trace.beginSection("releaseOutputBuffer");
        zzscVar.zzm(i, j2);
        Trace.endSection();
        ((zzso) this).zza.zze++;
        this.zzv = 0;
        if (this.zzk) {
            return;
        }
        zzcp zzcpVar = this.zzA;
        if (!zzcpVar.equals(zzcp.zza) && !zzcpVar.equals(this.zzB)) {
            this.zzB = zzcpVar;
            this.zzg.zzt(zzcpVar);
        }
        if (!this.zzi.zzo() || this.zzp == null) {
            return;
        }
        zzaV();
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzap() {
        if (this.zzk) {
            this.zzf.zzi(zzau());
        } else {
            this.zzi.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final boolean zzar(long j, long j2, zzsc zzscVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzaf zzafVar) throws zzhw {
        long j4;
        zzscVar.getClass();
        long jZzau = j3 - zzau();
        int iZza = this.zzi.zza(j3, j, j2, zzav(), z2, this.zzj);
        if (iZza != 4) {
            if (z && !z2) {
                zzaO(zzscVar, i, jZzau);
                return true;
            }
            if (this.zzp != this.zzq || this.zzk) {
                if (this.zzk) {
                    try {
                        this.zzf.zzg(j, j2);
                        long jZzd = this.zzf.zzd(jZzau, z2);
                        if (jZzd != -9223372036854775807L) {
                            int i4 = zzet.zza;
                            zzao(zzscVar, i, jZzau, jZzd);
                            return true;
                        }
                    } catch (zzabb e) {
                        throw zzi(e, e.zza, false, 7001);
                    }
                } else {
                    if (iZza == 0) {
                        zzh();
                        long jNanoTime = System.nanoTime();
                        int i5 = zzet.zza;
                        zzao(zzscVar, i, jZzau, jNanoTime);
                        zzaQ(this.zzj.zzc());
                        return true;
                    }
                    if (iZza == 1) {
                        zzaaf zzaafVar = this.zzj;
                        long jZzd2 = zzaafVar.zzd();
                        long jZzc = zzaafVar.zzc();
                        int i6 = zzet.zza;
                        if (jZzd2 == this.zzz) {
                            zzaO(zzscVar, i, jZzau);
                            j4 = jZzd2;
                        } else {
                            zzao(zzscVar, i, jZzau, jZzd2);
                            j4 = jZzd2;
                        }
                        zzaQ(jZzc);
                        this.zzz = j4;
                        return true;
                    }
                    if (iZza == 2) {
                        Trace.beginSection("dropVideoBuffer");
                        zzscVar.zzn(i, false);
                        Trace.endSection();
                        zzaP(0, 1);
                        zzaQ(this.zzj.zzc());
                        return true;
                    }
                    if (iZza == 3) {
                        zzaO(zzscVar, i, jZzau);
                        zzaQ(this.zzj.zzc());
                        return true;
                    }
                    if (iZza != 5) {
                        throw new IllegalStateException(String.valueOf(iZza));
                    }
                }
            } else if (this.zzj.zzc() < 30000) {
                zzaO(zzscVar, i, jZzau);
                zzaQ(this.zzj.zzc());
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final int zzat(zzhd zzhdVar) {
        int i = zzet.zza;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzse zzaz(Throwable th, zzsf zzsfVar) {
        return new zzzw(th, zzsfVar, this.zzp);
    }

    @Override // com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzle
    public final void zzs() {
        this.zzi.zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzsc] */
    /* JADX WARN: Type inference failed for: r6v12, types: [com.google.android.gms.internal.ads.zzaah] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11, types: [com.google.android.gms.internal.ads.zzaad] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
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
    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzkz
    public final void zzt(int i, Object obj) {
        if (i != 1) {
            if (i == 7) {
                obj.getClass();
                zzaae zzaaeVar = (zzaae) obj;
                this.zzF = zzaaeVar;
                ((zzzr) this.zzf).zza.zzj = zzaaeVar;
                return;
            }
            if (i == 10) {
                obj.getClass();
                int iIntValue = ((Integer) obj).intValue();
                if (this.zzE != iIntValue) {
                    this.zzE = iIntValue;
                    return;
                }
                return;
            }
            if (i == 16) {
                obj.getClass();
                this.zzD = ((Integer) obj).intValue();
                zzsc zzscVarZzay = zzay();
                if (zzscVarZzay == null || zzet.zza < 35) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.zzD));
                zzscVarZzay.zzp(bundle);
                return;
            }
            if (i == 4) {
                obj.getClass();
                int iIntValue2 = ((Integer) obj).intValue();
                this.zzs = iIntValue2;
                zzsc zzscVarZzay2 = zzay();
                if (zzscVarZzay2 != null) {
                    zzscVarZzay2.zzq(iIntValue2);
                    return;
                }
                return;
            }
            if (i == 5) {
                zzaah zzaahVar = this.zzi;
                obj.getClass();
                zzaahVar.zzj(((Integer) obj).intValue());
                return;
            }
            if (i == 13) {
                obj.getClass();
                this.zzf.zzj((List) obj);
                this.zzC = true;
                return;
            } else {
                if (i != 14) {
                    super.zzt(i, obj);
                    return;
                }
                obj.getClass();
                zzel zzelVar = (zzel) obj;
                if (zzelVar.zzb() == 0 || zzelVar.zza() == 0) {
                    return;
                }
                zzabc zzabcVar = this.zzf;
                Surface surface = this.zzp;
                zzdi.zzb(surface);
                ((zzzr) zzabcVar).zza.zzu(surface, zzelVar);
                return;
            }
        }
        ?? Zza = obj instanceof Surface ? (Surface) obj : 0;
        if (Zza == 0) {
            zzaad zzaadVar = this.zzq;
            if (zzaadVar != null) {
                Zza = zzaadVar;
            } else {
                zzsf zzsfVarZzaA = zzaA();
                if (zzsfVarZzaA != null && zzaX(zzsfVarZzaA)) {
                    Zza = zzaad.zza(this.zze, zzsfVarZzaA.zzf);
                    this.zzq = Zza;
                }
            }
        }
        if (this.zzp == Zza) {
            if (Zza == 0 || Zza == this.zzq) {
                return;
            }
            zzaU();
            Surface surface2 = this.zzp;
            if (surface2 == null || !this.zzr) {
                return;
            }
            this.zzg.zzq(surface2);
            return;
        }
        this.zzp = Zza;
        if (!this.zzk) {
            this.zzi.zzl(Zza);
        }
        this.zzr = false;
        int iZzcV = zzcV();
        ?? Zzay = zzay();
        ?? r7 = Zza;
        if (Zzay != 0) {
            r7 = Zza;
            if (!this.zzk) {
                ?? r72 = Zza;
                if (zzet.zza < 23) {
                    zzaF();
                    zzaB();
                    r7 = r72;
                } else {
                    if (Zza != 0) {
                        r72 = Zza;
                        if (!this.zzn) {
                            Zzay.zzo(Zza);
                            r7 = Zza;
                        }
                    } else {
                        r72 = 0;
                    }
                    zzaF();
                    zzaB();
                    r7 = r72;
                }
            }
        }
        if (r7 == 0 || r7 == this.zzq) {
            this.zzB = null;
            if (this.zzk) {
                ((zzzr) this.zzf).zza.zzr();
                return;
            }
            return;
        }
        zzaU();
        if (iZzcV == 2) {
            this.zzi.zzc(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    public final void zzw() {
        this.zzB = null;
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zzd();
        } else {
            this.zzi.zzd();
        }
        this.zzr = false;
        try {
            super.zzw();
        } finally {
            this.zzg.zzc(((zzso) this).zza);
            this.zzg.zzt(zzcp.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    public final void zzx(boolean z, boolean z2) {
        super.zzx(z, z2);
        zzm();
        this.zzg.zze(((zzso) this).zza);
        if (!this.zzl) {
            this.zzk = this.zzC;
            this.zzl = true;
        }
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zze(z2);
        } else {
            this.zzi.zze(z2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void zzy() {
        zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    public final void zzz(long j, boolean z) {
        this.zzf.zze();
        this.zzf.zzi(zzau());
        super.zzz(j, z);
        this.zzi.zzi();
        if (z) {
            this.zzi.zzc(false);
        }
        this.zzv = 0;
    }
}
