package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzanl {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzer zza = new zzer(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzek zzb = new zzek();

    public zzanl(int i) {
    }

    private final int zze(zzacl zzaclVar) {
        byte[] bArr = zzet.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzaclVar.zzj();
        return 0;
    }

    public final int zza(zzacl zzaclVar, zzadf zzadfVar, int i) {
        if (i <= 0) {
            zze(zzaclVar);
            return 0;
        }
        long j = -9223372036854775807L;
        if (this.zze) {
            if (this.zzg == -9223372036854775807L) {
                zze(zzaclVar);
                return 0;
            }
            if (this.zzd) {
                long j2 = this.zzf;
                if (j2 == -9223372036854775807L) {
                    zze(zzaclVar);
                    return 0;
                }
                zzer zzerVar = this.zza;
                this.zzh = zzerVar.zzc(this.zzg) - zzerVar.zzb(j2);
                zze(zzaclVar);
                return 0;
            }
            int iMin = (int) Math.min(112800L, zzaclVar.zzd());
            if (zzaclVar.zzf() != 0) {
                zzadfVar.zza = 0L;
                return 1;
            }
            this.zzb.zzH(iMin);
            zzaclVar.zzj();
            ((zzaby) zzaclVar).zzm(this.zzb.zzM(), 0, iMin, false);
            zzek zzekVar = this.zzb;
            int iZzd = zzekVar.zzd();
            int iZze = zzekVar.zze();
            while (true) {
                if (iZzd >= iZze) {
                    break;
                }
                if (zzekVar.zzM()[iZzd] == 71) {
                    long jZzb = zzanu.zzb(zzekVar, iZzd, i);
                    if (jZzb != -9223372036854775807L) {
                        j = jZzb;
                        break;
                    }
                }
                iZzd++;
            }
            this.zzf = j;
            this.zzd = true;
            return 0;
        }
        long jZzd = zzaclVar.zzd();
        int iMin2 = (int) Math.min(112800L, jZzd);
        long j3 = jZzd - ((long) iMin2);
        if (zzaclVar.zzf() != j3) {
            zzadfVar.zza = j3;
            return 1;
        }
        this.zzb.zzH(iMin2);
        zzaclVar.zzj();
        ((zzaby) zzaclVar).zzm(this.zzb.zzM(), 0, iMin2, false);
        zzek zzekVar2 = this.zzb;
        int iZzd2 = zzekVar2.zzd();
        int iZze2 = zzekVar2.zze();
        int i2 = iZze2 - 188;
        while (true) {
            if (i2 < iZzd2) {
                break;
            }
            byte[] bArrZzM = zzekVar2.zzM();
            int i3 = -4;
            int i4 = 0;
            while (true) {
                if (i3 > 4) {
                    break;
                }
                int i5 = (i3 * 188) + i2;
                if (i5 < iZzd2 || i5 >= iZze2 || bArrZzM[i5] != 71) {
                    i4 = 0;
                } else {
                    i4++;
                    if (i4 == 5) {
                        long jZzb2 = zzanu.zzb(zzekVar2, i2, i);
                        if (jZzb2 != -9223372036854775807L) {
                            j = jZzb2;
                            break;
                        }
                    }
                }
                i3++;
            }
            i2--;
        }
        this.zzg = j;
        this.zze = true;
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzer zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
