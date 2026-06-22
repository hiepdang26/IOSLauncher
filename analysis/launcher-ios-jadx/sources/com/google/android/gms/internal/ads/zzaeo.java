package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaeo implements zzack {
    private final byte[] zza;
    private final zzek zzb;
    private final zzacq zzc;
    private zzacn zzd;
    private zzadp zze;
    private int zzf;
    private zzbk zzg;
    private zzacv zzh;
    private int zzi;
    private int zzj;
    private zzaen zzk;
    private int zzl;
    private long zzm;

    public zzaeo() {
        throw null;
    }

    private final long zza(zzek zzekVar, boolean z) {
        boolean zZzc;
        this.zzh.getClass();
        int iZzd = zzekVar.zzd();
        while (iZzd <= zzekVar.zze() - 16) {
            zzekVar.zzK(iZzd);
            if (zzacr.zzc(zzekVar, this.zzh, this.zzj, this.zzc)) {
                zzekVar.zzK(iZzd);
                return this.zzc.zza;
            }
            iZzd++;
        }
        if (!z) {
            zzekVar.zzK(iZzd);
            return -1L;
        }
        while (iZzd <= zzekVar.zze() - this.zzi) {
            zzekVar.zzK(iZzd);
            try {
                zZzc = zzacr.zzc(zzekVar, this.zzh, this.zzj, this.zzc);
            } catch (IndexOutOfBoundsException unused) {
                zZzc = false;
            }
            if (zzekVar.zzd() <= zzekVar.zze() && zZzc) {
                zzekVar.zzK(iZzd);
                return this.zzc.zza;
            }
            iZzd++;
        }
        zzekVar.zzK(zzekVar.zze());
        return -1L;
    }

    private final void zzg() {
        long j = this.zzm * 1000000;
        zzacv zzacvVar = this.zzh;
        int i = zzet.zza;
        this.zze.zzs(j / ((long) zzacvVar.zze), 1, this.zzl, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) throws zzbo, EOFException, InterruptedIOException {
        boolean zZzp;
        zzadi zzadhVar;
        boolean z;
        int i = this.zzf;
        if (i == 0) {
            zzaclVar.zzj();
            long jZze = zzaclVar.zze();
            zzbk zzbkVarZza = zzacs.zza(zzaclVar, true);
            ((zzaby) zzaclVar).zzo((int) (zzaclVar.zze() - jZze), false);
            this.zzg = zzbkVarZza;
            this.zzf = 1;
            return 0;
        }
        if (i == 1) {
            ((zzaby) zzaclVar).zzm(this.zza, 0, 42, false);
            zzaclVar.zzj();
            this.zzf = 2;
            return 0;
        }
        if (i == 2) {
            zzek zzekVar = new zzek(4);
            ((zzaby) zzaclVar).zzn(zzekVar.zzM(), 0, 4, false);
            if (zzekVar.zzu() != 1716281667) {
                throw zzbo.zza("Failed to read FLAC stream marker.", null);
            }
            this.zzf = 3;
            return 0;
        }
        if (i == 3) {
            zzacv zzacvVarZze = this.zzh;
            do {
                zzaclVar.zzj();
                zzej zzejVar = new zzej(new byte[4], 4);
                zzaby zzabyVar = (zzaby) zzaclVar;
                zzabyVar.zzm(zzejVar.zza, 0, 4, false);
                zZzp = zzejVar.zzp();
                int iZzd = zzejVar.zzd(7);
                int iZzd2 = zzejVar.zzd(24) + 4;
                if (iZzd == 0) {
                    byte[] bArr = new byte[38];
                    zzabyVar.zzn(bArr, 0, 38, false);
                    zzacvVarZze = new zzacv(bArr, 4);
                } else {
                    if (zzacvVarZze == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iZzd == 3) {
                        zzek zzekVar2 = new zzek(iZzd2);
                        zzabyVar.zzn(zzekVar2.zzM(), 0, iZzd2, false);
                        zzacvVarZze = zzacvVarZze.zzf(zzacs.zzb(zzekVar2));
                    } else if (iZzd == 4) {
                        zzek zzekVar3 = new zzek(iZzd2);
                        zzabyVar.zzn(zzekVar3.zzM(), 0, iZzd2, false);
                        zzekVar3.zzL(4);
                        zzacvVarZze = zzacvVarZze.zzg(Arrays.asList(zzadv.zzc(zzekVar3, false, false).zza));
                    } else if (iZzd == 6) {
                        zzek zzekVar4 = new zzek(iZzd2);
                        zzabyVar.zzn(zzekVar4.zzM(), 0, iZzd2, false);
                        zzekVar4.zzL(4);
                        zzacvVarZze = zzacvVarZze.zze(zzfxr.zzn(zzafj.zzb(zzekVar4)));
                    } else {
                        zzabyVar.zzo(iZzd2, false);
                    }
                }
                int i2 = zzet.zza;
                this.zzh = zzacvVarZze;
            } while (!zZzp);
            zzacvVarZze.getClass();
            this.zzi = Math.max(zzacvVarZze.zzc, 6);
            this.zze.zzl(this.zzh.zzc(this.zza, this.zzg));
            this.zzf = 4;
            return 0;
        }
        if (i == 4) {
            zzaclVar.zzj();
            zzek zzekVar5 = new zzek(2);
            ((zzaby) zzaclVar).zzm(zzekVar5.zzM(), 0, 2, false);
            int iZzq = zzekVar5.zzq();
            if ((iZzq >> 2) != 16382) {
                zzaclVar.zzj();
                throw zzbo.zza("First frame does not start with sync code.", null);
            }
            zzaclVar.zzj();
            this.zzj = iZzq;
            zzacn zzacnVar = this.zzd;
            int i3 = zzet.zza;
            long jZzf = zzaclVar.zzf();
            long jZzd = zzaclVar.zzd();
            zzacv zzacvVar = this.zzh;
            zzacvVar.getClass();
            if (zzacvVar.zzk != null) {
                zzadhVar = new zzact(zzacvVar, jZzf);
            } else if (jZzd == -1 || zzacvVar.zzj <= 0) {
                zzadhVar = new zzadh(zzacvVar.zza(), 0L);
            } else {
                zzaen zzaenVar = new zzaen(zzacvVar, this.zzj, jZzf, jZzd);
                this.zzk = zzaenVar;
                zzadhVar = zzaenVar.zzb();
            }
            zzacnVar.zzO(zzadhVar);
            this.zzf = 5;
            return 0;
        }
        this.zze.getClass();
        zzacv zzacvVar2 = this.zzh;
        zzacvVar2.getClass();
        zzaen zzaenVar2 = this.zzk;
        if (zzaenVar2 != null && zzaenVar2.zze()) {
            return zzaenVar2.zza(zzaclVar, zzadfVar);
        }
        if (this.zzm == -1) {
            this.zzm = zzacr.zzb(zzaclVar, zzacvVar2);
            return 0;
        }
        zzek zzekVar6 = this.zzb;
        int iZze = zzekVar6.zze();
        if (iZze < 32768) {
            int iZza = zzaclVar.zza(zzekVar6.zzM(), iZze, 32768 - iZze);
            z = iZza == -1;
            if (!z) {
                this.zzb.zzJ(iZze + iZza);
            } else if (this.zzb.zzb() == 0) {
                zzg();
                return -1;
            }
        } else {
            z = false;
        }
        zzek zzekVar7 = this.zzb;
        int iZzd3 = zzekVar7.zzd();
        int i4 = this.zzl;
        int i5 = this.zzi;
        if (i4 < i5) {
            zzekVar7.zzL(Math.min(i5 - i4, zzekVar7.zzb()));
        }
        long jZza = zza(this.zzb, z);
        zzek zzekVar8 = this.zzb;
        int iZzd4 = zzekVar8.zzd() - iZzd3;
        zzekVar8.zzK(iZzd3);
        this.zze.zzq(this.zzb, iZzd4);
        this.zzl += iZzd4;
        if (jZza != -1) {
            zzg();
            this.zzl = 0;
            this.zzm = jZza;
        }
        zzek zzekVar9 = this.zzb;
        if (zzekVar9.zzb() >= 16) {
            return 0;
        }
        int iZzb = zzekVar9.zzb();
        System.arraycopy(zzekVar9.zzM(), zzekVar9.zzd(), zzekVar9.zzM(), 0, iZzb);
        this.zzb.zzK(0);
        this.zzb.zzJ(iZzb);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zzd = zzacnVar;
        this.zze = zzacnVar.zzw(0, 1);
        zzacnVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        if (j == 0) {
            this.zzf = 0;
        } else {
            zzaen zzaenVar = this.zzk;
            if (zzaenVar != null) {
                zzaenVar.zzd(j2);
            }
        }
        this.zzm = j2 != 0 ? -1L : 0L;
        this.zzl = 0;
        this.zzb.zzH(0);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws EOFException, InterruptedIOException {
        zzacs.zza(zzaclVar, false);
        zzek zzekVar = new zzek(4);
        ((zzaby) zzaclVar).zzm(zzekVar.zzM(), 0, 4, false);
        return zzekVar.zzu() == 1716281667;
    }

    public zzaeo(int i) {
        this.zza = new byte[42];
        this.zzb = new zzek(new byte[32768], 0);
        this.zzc = new zzacq();
        this.zzf = 0;
    }
}
