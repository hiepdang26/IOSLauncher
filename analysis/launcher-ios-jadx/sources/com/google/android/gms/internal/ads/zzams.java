package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzams implements zzamf {
    private String zze;
    private zzadp zzf;
    private boolean zzi;
    private int zzk;
    private int zzl;
    private int zzn;
    private int zzo;
    private int zzs;
    private boolean zzu;
    private int zzd = 0;
    private final zzek zza = new zzek(new byte[15], 2);
    private final zzej zzb = new zzej();
    private final zzek zzc = new zzek();
    private final zzamt zzp = new zzamt();
    private int zzq = -2147483647;
    private int zzr = -1;
    private long zzt = -1;
    private boolean zzj = true;
    private boolean zzm = true;
    private double zzg = -9.223372036854776E18d;
    private double zzh = -9.223372036854776E18d;

    private static final void zzf(zzek zzekVar, zzek zzekVar2, boolean z) {
        int iZzd = zzekVar.zzd();
        int iMin = Math.min(zzekVar.zzb(), zzekVar2.zzb());
        zzekVar.zzG(zzekVar2.zzM(), zzekVar2.zzd(), iMin);
        zzekVar2.zzL(iMin);
        if (z) {
            zzekVar.zzK(iZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zza(zzek zzekVar) throws zzbo {
        int i;
        int iZzd;
        zzdi.zzb(this.zzf);
        while (zzekVar.zzb() > 0) {
            int i2 = this.zzd;
            if (i2 == 0) {
                int i3 = this.zzk;
                if ((i3 & 2) != 0) {
                    if ((i3 & 4) == 0) {
                        while (zzekVar.zzb() > 0) {
                            int i4 = this.zzl << 8;
                            this.zzl = i4;
                            int iZzm = i4 | zzekVar.zzm();
                            this.zzl = iZzm;
                            if ((iZzm & 16777215) == 12583333) {
                                zzekVar.zzK(zzekVar.zzd() - 3);
                                this.zzl = 0;
                            }
                        }
                    }
                    this.zzd = 1;
                    break;
                }
                zzekVar.zzK(zzekVar.zze());
            } else if (i2 != 1) {
                int i5 = this.zzp.zza;
                if (i5 == 1 || i5 == 17) {
                    zzf(zzekVar, this.zzc, true);
                }
                int iMin = Math.min(zzekVar.zzb(), this.zzp.zzc - this.zzn);
                this.zzf.zzq(zzekVar, iMin);
                int i6 = this.zzn + iMin;
                this.zzn = i6;
                zzamt zzamtVar = this.zzp;
                if (i6 == zzamtVar.zzc) {
                    int i7 = zzamtVar.zza;
                    if (i7 == 1) {
                        byte[] bArrZzM = this.zzc.zzM();
                        zzamv zzamvVarZza = zzamw.zza(new zzej(bArrZzM, bArrZzM.length));
                        this.zzq = zzamvVarZza.zzb;
                        this.zzr = zzamvVarZza.zzc;
                        long j = this.zzt;
                        long j2 = this.zzp.zzb;
                        if (j != j2) {
                            this.zzt = j2;
                            int i8 = zzamvVarZza.zza;
                            String strConcat = i8 != -1 ? "mhm1".concat(String.format(".%02X", Integer.valueOf(i8))) : "mhm1";
                            byte[] bArr = zzamvVarZza.zzd;
                            zzfxr zzfxrVarZzo = null;
                            if (bArr != null && bArr.length > 0) {
                                zzfxrVarZzo = zzfxr.zzo(zzet.zzf, bArr);
                            }
                            zzad zzadVar = new zzad();
                            zzadVar.zzK(this.zze);
                            zzadVar.zzX("audio/mhm1");
                            zzadVar.zzY(this.zzq);
                            zzadVar.zzz(strConcat);
                            zzadVar.zzL(zzfxrVarZzo);
                            this.zzf.zzl(zzadVar.zzad());
                        }
                        this.zzu = true;
                    } else if (i7 == 17) {
                        byte[] bArrZzM2 = this.zzc.zzM();
                        zzej zzejVar = new zzej(bArrZzM2, bArrZzM2.length);
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(2);
                            iZzd = zzejVar.zzd(13);
                        } else {
                            iZzd = 0;
                        }
                        this.zzs = iZzd;
                    } else if (i7 == 2) {
                        if (this.zzu) {
                            this.zzj = false;
                            i = 1;
                        } else {
                            i = 0;
                        }
                        int i9 = this.zzr - this.zzs;
                        double d = this.zzq;
                        long jRound = Math.round(this.zzg);
                        if (this.zzi) {
                            this.zzi = false;
                            this.zzg = this.zzh;
                        } else {
                            this.zzg += (((double) i9) * 1000000.0d) / d;
                        }
                        this.zzf.zzs(jRound, i, this.zzo, 0, null);
                        this.zzu = false;
                        this.zzs = 0;
                        this.zzo = 0;
                    }
                    this.zzd = 1;
                }
            } else {
                zzf(zzekVar, this.zza, false);
                zzek zzekVar2 = this.zza;
                if (zzekVar2.zzb() == 0) {
                    zzej zzejVar2 = this.zzb;
                    int iZze = zzekVar2.zze();
                    zzejVar2.zzk(zzekVar2.zzM(), iZze);
                    if (zzamw.zzb(this.zzb, this.zzp)) {
                        this.zzn = 0;
                        this.zzo = this.zzp.zzc + iZze + this.zzo;
                        this.zza.zzK(0);
                        zzadp zzadpVar = this.zzf;
                        zzek zzekVar3 = this.zza;
                        zzadpVar.zzq(zzekVar3, zzekVar3.zze());
                        this.zza.zzH(2);
                        this.zzc.zzH(this.zzp.zzc);
                        this.zzm = true;
                        this.zzd = 2;
                    } else {
                        zzek zzekVar4 = this.zza;
                        if (zzekVar4.zze() < 15) {
                            zzekVar4.zzJ(zzekVar4.zze() + 1);
                        }
                    }
                }
                this.zzm = false;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzb(zzacn zzacnVar, zzans zzansVar) {
        zzansVar.zzc();
        this.zze = zzansVar.zzb();
        this.zzf = zzacnVar.zzw(zzansVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zzd(long j, int i) {
        this.zzk = i;
        if (!this.zzj && (this.zzo != 0 || !this.zzm)) {
            this.zzi = true;
        }
        if (j != -9223372036854775807L) {
            double d = j;
            if (this.zzi) {
                this.zzh = d;
            } else {
                this.zzg = d;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamf
    public final void zze() {
        this.zzd = 0;
        this.zzl = 0;
        this.zza.zzH(2);
        this.zzn = 0;
        this.zzo = 0;
        this.zzq = -2147483647;
        this.zzr = -1;
        this.zzs = 0;
        this.zzt = -1L;
        this.zzu = false;
        this.zzi = false;
        this.zzm = true;
        this.zzj = true;
        this.zzg = -9.223372036854776E18d;
        this.zzh = -9.223372036854776E18d;
    }
}
