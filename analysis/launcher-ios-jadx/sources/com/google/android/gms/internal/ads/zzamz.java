package com.google.android.gms.internal.ads;

import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
public final class zzamz implements zzant {
    private final zzamf zza;
    private final zzej zzb = new zzej(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzer zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzamz(zzamf zzamfVar) {
        this.zza = zzamfVar;
    }

    private final void zze(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zzf(zzek zzekVar, byte[] bArr, int i) {
        int iMin = Math.min(zzekVar.zzb(), i - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzekVar.zzL(iMin);
        } else {
            zzekVar.zzG(bArr, this.zzd, iMin);
        }
        int i2 = this.zzd + iMin;
        this.zzd = i2;
        return i2 == i;
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zza(zzek zzekVar, int i) {
        int i2;
        long jZzb;
        long j;
        zzdi.zzb(this.zze);
        int i3 = -1;
        int i4 = 2;
        if ((i & 1) != 0) {
            int i5 = this.zzc;
            if (i5 != 0 && i5 != 1) {
                if (i5 != 2) {
                    int i6 = this.zzj;
                    if (i6 != -1) {
                        zzea.zzf("PesReader", "Unexpected start indicator: expected " + i6 + " more bytes");
                    }
                    this.zza.zzc(zzekVar.zze() == 0);
                } else {
                    zzea.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i7 = i;
        while (zzekVar.zzb() > 0) {
            int i8 = this.zzc;
            if (i8 == 0) {
                zzekVar.zzL(zzekVar.zzb());
            } else if (i8 != 1) {
                if (i8 != i4) {
                    int iZzb = zzekVar.zzb();
                    int i9 = this.zzj;
                    int i10 = i9 == i3 ? 0 : iZzb - i9;
                    if (i10 > 0) {
                        iZzb -= i10;
                        zzekVar.zzJ(zzekVar.zzd() + iZzb);
                    }
                    this.zza.zza(zzekVar);
                    int i11 = this.zzj;
                    if (i11 != i3) {
                        int i12 = i11 - iZzb;
                        this.zzj = i12;
                        if (i12 == 0) {
                            this.zza.zzc(false);
                            zze(1);
                        }
                    }
                } else {
                    if (zzf(zzekVar, this.zzb.zza, Math.min(10, this.zzi)) && zzf(zzekVar, null, this.zzi)) {
                        this.zzb.zzl(0);
                        if (this.zzf) {
                            this.zzb.zzn(4);
                            long jZzd = this.zzb.zzd(3);
                            this.zzb.zzn(1);
                            int iZzd = this.zzb.zzd(15) << 15;
                            this.zzb.zzn(1);
                            long jZzd2 = this.zzb.zzd(15);
                            this.zzb.zzn(1);
                            if (this.zzh || !this.zzg) {
                                j = jZzd;
                            } else {
                                this.zzb.zzn(4);
                                j = jZzd;
                                long jZzd3 = ((long) this.zzb.zzd(3)) << 30;
                                this.zzb.zzn(1);
                                int iZzd2 = this.zzb.zzd(15) << 15;
                                this.zzb.zzn(1);
                                long jZzd4 = this.zzb.zzd(15);
                                this.zzb.zzn(1);
                                this.zze.zzb(jZzd3 | ((long) iZzd2) | jZzd4);
                                this.zzh = true;
                            }
                            jZzb = this.zze.zzb((j << 30) | ((long) iZzd) | jZzd2);
                        } else {
                            jZzb = -9223372036854775807L;
                        }
                        i7 |= true != this.zzk ? 0 : 4;
                        this.zza.zzd(jZzb, i7);
                        zze(3);
                    }
                }
            } else if (zzf(zzekVar, this.zzb.zza, 9)) {
                this.zzb.zzl(0);
                int iZzd3 = this.zzb.zzd(24);
                if (iZzd3 != 1) {
                    k31.n(iZzd3, "Unexpected start code prefix: ", "PesReader");
                    this.zzj = -1;
                    i2 = 0;
                } else {
                    this.zzb.zzn(8);
                    zzej zzejVar = this.zzb;
                    int iZzd4 = zzejVar.zzd(16);
                    zzejVar.zzn(5);
                    this.zzk = this.zzb.zzp();
                    this.zzb.zzn(2);
                    this.zzf = this.zzb.zzp();
                    this.zzg = this.zzb.zzp();
                    this.zzb.zzn(6);
                    int iZzd5 = this.zzb.zzd(8);
                    this.zzi = iZzd5;
                    if (iZzd4 == 0) {
                        this.zzj = -1;
                    } else {
                        int i13 = (iZzd4 - 3) - iZzd5;
                        this.zzj = i13;
                        if (i13 < 0) {
                            k31.n(i13, "Found negative packet payload size: ", "PesReader");
                            this.zzj = -1;
                        }
                    }
                    i2 = 2;
                }
                zze(i2);
            }
            i3 = -1;
            i4 = 2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzb(zzer zzerVar, zzacn zzacnVar, zzans zzansVar) {
        this.zze = zzerVar;
        this.zza.zzb(zzacnVar, zzansVar);
    }

    @Override // com.google.android.gms.internal.ads.zzant
    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }

    public final boolean zzd(boolean z) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
