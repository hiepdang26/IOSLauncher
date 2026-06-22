package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzqv extends zzso implements zzkg {
    private final Context zzb;
    private final zzpd zzc;
    private final zzpl zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private zzaf zzh;
    private zzaf zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;

    public zzqv(Context context, zzsa zzsaVar, zzsq zzsqVar, boolean z, Handler handler, zzpe zzpeVar, zzpl zzplVar) {
        super(1, zzsaVar, zzsqVar, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzplVar;
        this.zzn = -1000;
        this.zzc = new zzpd(handler, zzpeVar);
        zzplVar.zzp(new zzqu(this, null));
    }

    private final int zzaO(zzsf zzsfVar, zzaf zzafVar) {
        int i;
        if (!"OMX.google.raw.decoder".equals(zzsfVar.zza) || (i = zzet.zza) >= 24 || (i == 23 && zzet.zzN(this.zzb))) {
            return zzafVar.zzn;
        }
        return -1;
    }

    private static List zzaP(zzsq zzsqVar, zzaf zzafVar, boolean z, zzpl zzplVar) {
        zzsf zzsfVarZzb;
        return zzafVar.zzm == null ? zzfxr.zzm() : (!zzplVar.zzz(zzafVar) || (zzsfVarZzb = zztc.zzb()) == null) ? zztc.zzf(zzsqVar, zzafVar, false, false) : zzfxr.zzn(zzsfVarZzb);
    }

    private final void zzaQ() {
        long jZzb = this.zzd.zzb(zzW());
        if (jZzb != Long.MIN_VALUE) {
            if (!this.zzk) {
                jZzb = Math.max(this.zzj, jZzb);
            }
            this.zzj = jZzb;
            this.zzk = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void zzA() {
        this.zzd.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    public final void zzC() {
        this.zzm = false;
        try {
            super.zzC();
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzl();
            }
        } catch (Throwable th) {
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzl();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void zzD() {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void zzE() {
        zzaQ();
        this.zzd.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzle, com.google.android.gms.internal.ads.zzlh
    public final String zzU() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzle
    public final boolean zzW() {
        return super.zzW() && this.zzd.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzle
    public final boolean zzX() {
        return this.zzd.zzx() || super.zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final float zzZ(float f, zzaf zzafVar, zzaf[] zzafVarArr) {
        int iMax = -1;
        for (zzaf zzafVar2 : zzafVarArr) {
            int i = zzafVar2.zzA;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f;
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final long zza() {
        if (zzcV() == 2) {
            zzaQ();
        }
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final int zzaa(zzsq zzsqVar, zzaf zzafVar) {
        int i;
        boolean z;
        int i2 = 1;
        if (!zzbn.zzg(zzafVar.zzm)) {
            return 128;
        }
        int i3 = zzet.zza;
        int i4 = zzafVar.zzG;
        boolean zZzaN = zzso.zzaN(zzafVar);
        if (!zZzaN || (i4 != 0 && zztc.zzb() == null)) {
            i = 0;
        } else {
            zzoq zzoqVarZzd = this.zzd.zzd(zzafVar);
            if (zzoqVarZzd.zzb) {
                i = true != zzoqVarZzd.zzc ? 512 : 1536;
                if (zzoqVarZzd.zzd) {
                    i |= 2048;
                }
            } else {
                i = 0;
            }
            if (this.zzd.zzz(zzafVar)) {
                return i | 172;
            }
        }
        if ((!"audio/raw".equals(zzafVar.zzm) || this.zzd.zzz(zzafVar)) && this.zzd.zzz(zzet.zzz(2, zzafVar.zzz, zzafVar.zzA))) {
            List listZzaP = zzaP(zzsqVar, zzafVar, false, this.zzd);
            if (!listZzaP.isEmpty()) {
                if (zZzaN) {
                    zzsf zzsfVar = (zzsf) listZzaP.get(0);
                    boolean zZze = zzsfVar.zze(zzafVar);
                    if (zZze) {
                        z = true;
                    } else {
                        for (int i5 = 1; i5 < listZzaP.size(); i5++) {
                            zzsf zzsfVar2 = (zzsf) listZzaP.get(i5);
                            if (zzsfVar2.zze(zzafVar)) {
                                zzsfVar = zzsfVar2;
                                z = false;
                                zZze = true;
                                break;
                            }
                        }
                        z = true;
                    }
                    int i6 = true != zZze ? 3 : 4;
                    int i7 = 8;
                    if (zZze && zzsfVar.zzf(zzafVar)) {
                        i7 = 16;
                    }
                    return i6 | i7 | 32 | (true != zzsfVar.zzg ? 0 : 64) | (true != z ? 0 : 128) | i;
                }
                i2 = 2;
            }
        }
        return i2 | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final zzho zzab(zzsf zzsfVar, zzaf zzafVar, zzaf zzafVar2) {
        int i;
        int i2;
        zzho zzhoVarZzb = zzsfVar.zzb(zzafVar, zzafVar2);
        int i3 = zzhoVarZzb.zze;
        if (zzaL(zzafVar2)) {
            i3 |= 32768;
        }
        if (zzaO(zzsfVar, zzafVar2) > this.zze) {
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
        zzaf zzafVar = zzjzVar.zza;
        zzafVar.getClass();
        this.zzh = zzafVar;
        zzho zzhoVarZzac = super.zzac(zzjzVar);
        this.zzc.zzi(zzafVar, zzhoVarZzac);
        return zzhoVarZzac;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d1  */
    @Override // com.google.android.gms.internal.ads.zzso
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzrz zzaf(com.google.android.gms.internal.ads.zzsf r8, com.google.android.gms.internal.ads.zzaf r9, android.media.MediaCrypto r10, float r11) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqv.zzaf(com.google.android.gms.internal.ads.zzsf, com.google.android.gms.internal.ads.zzaf, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzrz");
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final List zzag(zzsq zzsqVar, zzaf zzafVar, boolean z) {
        return zztc.zzg(zzaP(zzsqVar, zzafVar, false, this.zzd), zzafVar);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzaj(zzhd zzhdVar) {
        zzaf zzafVar;
        if (zzet.zza < 29 || (zzafVar = zzhdVar.zza) == null || !Objects.equals(zzafVar.zzm, "audio/opus") || !zzaK()) {
            return;
        }
        ByteBuffer byteBuffer = zzhdVar.zzf;
        byteBuffer.getClass();
        zzaf zzafVar2 = zzhdVar.zza;
        zzafVar2.getClass();
        if (byteBuffer.remaining() == 8) {
            this.zzd.zzq(zzafVar2.zzC, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzak(Exception exc) {
        zzea.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzal(String str, zzrz zzrzVar, long j, long j2) {
        this.zzc.zze(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzam(String str) {
        this.zzc.zzf(str);
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzan(zzaf zzafVar, MediaFormat mediaFormat) throws zzhw {
        int i;
        zzaf zzafVar2 = this.zzi;
        int[] iArr = null;
        boolean z = true;
        if (zzafVar2 != null) {
            zzafVar = zzafVar2;
        } else if (zzay() != null) {
            mediaFormat.getClass();
            int iZzl = "audio/raw".equals(zzafVar.zzm) ? zzafVar.zzB : (zzet.zza < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? zzet.zzl(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding");
            zzad zzadVar = new zzad();
            zzadVar.zzX("audio/raw");
            zzadVar.zzR(iZzl);
            zzadVar.zzF(zzafVar.zzC);
            zzadVar.zzG(zzafVar.zzD);
            zzadVar.zzQ(zzafVar.zzk);
            zzadVar.zzK(zzafVar.zza);
            zzadVar.zzM(zzafVar.zzb);
            zzadVar.zzN(zzafVar.zzc);
            zzadVar.zzO(zzafVar.zzd);
            zzadVar.zzZ(zzafVar.zze);
            zzadVar.zzV(zzafVar.zzf);
            zzadVar.zzy(mediaFormat.getInteger("channel-count"));
            zzadVar.zzY(mediaFormat.getInteger("sample-rate"));
            zzaf zzafVarZzad = zzadVar.zzad();
            if (this.zzf && zzafVarZzad.zzz == 6 && (i = zzafVar.zzz) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < zzafVar.zzz; i2++) {
                    iArr[i2] = i2;
                }
            } else if (this.zzg) {
                int i3 = zzafVarZzad.zzz;
                if (i3 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i3 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i3 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i3 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i3 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
            }
            zzafVar = zzafVarZzad;
        }
        try {
            int i4 = zzet.zza;
            if (i4 >= 29) {
                if (zzaK()) {
                    zzm();
                }
                if (i4 < 29) {
                    z = false;
                }
                zzdi.zzf(z);
            }
            this.zzd.zze(zzafVar, 0, iArr);
        } catch (zzpg e) {
            throw zzi(e, e.zza, false, 5001);
        }
    }

    public final void zzao() {
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzap() {
        this.zzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzaq() throws zzhw {
        try {
            this.zzd.zzj();
        } catch (zzpk e) {
            throw zzi(e, e.zzc, e.zzb, true != zzaK() ? 5002 : 5003);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final boolean zzar(long j, long j2, zzsc zzscVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzaf zzafVar) throws zzhw {
        byteBuffer.getClass();
        if (this.zzi != null && (i2 & 2) != 0) {
            zzscVar.getClass();
            zzscVar.zzn(i, false);
            return true;
        }
        if (z) {
            if (zzscVar != null) {
                zzscVar.zzn(i, false);
            }
            ((zzso) this).zza.zzf += i3;
            this.zzd.zzg();
            return true;
        }
        try {
            if (!this.zzd.zzw(byteBuffer, j3, i3)) {
                return false;
            }
            if (zzscVar != null) {
                zzscVar.zzn(i, false);
            }
            ((zzso) this).zza.zze += i3;
            return true;
        } catch (zzph e) {
            zzaf zzafVar2 = this.zzh;
            if (zzaK()) {
                zzm();
            }
            throw zzi(e, zzafVar2, e.zzb, 5001);
        } catch (zzpk e2) {
            if (zzaK()) {
                zzm();
            }
            throw zzi(e2, zzafVar, e2.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final boolean zzas(zzaf zzafVar) {
        zzm();
        return this.zzd.zzz(zzafVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final zzbq zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final void zzg(zzbq zzbqVar) {
        this.zzd.zzr(zzbqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final boolean zzj() {
        boolean z = this.zzm;
        this.zzm = false;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzle
    public final zzkg zzk() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm, com.google.android.gms.internal.ads.zzkz
    public final void zzt(int i, Object obj) {
        if (i == 2) {
            zzpl zzplVar = this.zzd;
            obj.getClass();
            zzplVar.zzv(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            zzh zzhVar = (zzh) obj;
            zzpl zzplVar2 = this.zzd;
            zzhVar.getClass();
            zzplVar2.zzm(zzhVar);
            return;
        }
        if (i == 6) {
            zzi zziVar = (zzi) obj;
            zzpl zzplVar3 = this.zzd;
            zziVar.getClass();
            zzplVar3.zzo(zziVar);
            return;
        }
        if (i == 12) {
            if (zzet.zza >= 23) {
                zzqs.zza(this.zzd, obj);
                return;
            }
            return;
        }
        if (i == 16) {
            obj.getClass();
            this.zzn = ((Integer) obj).intValue();
            zzsc zzscVarZzay = zzay();
            if (zzscVarZzay != null && zzet.zza >= 35) {
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.zzn));
                zzscVarZzay.zzp(bundle);
                return;
            }
            return;
        }
        if (i == 9) {
            zzpl zzplVar4 = this.zzd;
            obj.getClass();
            zzplVar4.zzu(((Boolean) obj).booleanValue());
        } else {
            if (i != 10) {
                super.zzt(i, obj);
                return;
            }
            zzpl zzplVar5 = this.zzd;
            obj.getClass();
            zzplVar5.zzn(((Integer) obj).intValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    public final void zzw() {
        this.zzl = true;
        this.zzh = null;
        try {
            this.zzd.zzf();
            super.zzw();
        } catch (Throwable th) {
            super.zzw();
            throw th;
        } finally {
            this.zzc.zzg(((zzso) this).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    public final void zzx(boolean z, boolean z2) {
        super.zzx(z, z2);
        this.zzc.zzh(((zzso) this).zza);
        zzm();
        this.zzd.zzs(zzn());
        zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzso, com.google.android.gms.internal.ads.zzhm
    public final void zzz(long j, boolean z) {
        super.zzz(j, z);
        this.zzd.zzf();
        this.zzj = j;
        this.zzm = false;
        this.zzk = true;
    }
}
