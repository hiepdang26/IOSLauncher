package com.google.android.gms.internal.ads;

import androidx.profileinstaller.ProfileVerifier;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzvq {
    private final zzek zza = new zzek(32);
    private zzvp zzb;
    private zzvp zzc;
    private zzvp zzd;
    private long zze;
    private final zzyk zzf;

    public zzvq(zzyk zzykVar) {
        this.zzf = zzykVar;
        zzvp zzvpVar = new zzvp(0L, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
        this.zzb = zzvpVar;
        this.zzc = zzvpVar;
        this.zzd = zzvpVar;
    }

    private final int zzi(int i) {
        zzvp zzvpVar = this.zzd;
        if (zzvpVar.zzc == null) {
            zzyd zzydVarZzb = this.zzf.zzb();
            zzvp zzvpVar2 = new zzvp(this.zzd.zzb, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
            zzvpVar.zzc = zzydVarZzb;
            zzvpVar.zzd = zzvpVar2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzvp zzj(zzvp zzvpVar, long j) {
        while (j >= zzvpVar.zzb) {
            zzvpVar = zzvpVar.zzd;
        }
        return zzvpVar;
    }

    private static zzvp zzk(zzvp zzvpVar, long j, ByteBuffer byteBuffer, int i) {
        zzvp zzvpVarZzj = zzj(zzvpVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (zzvpVarZzj.zzb - j));
            byteBuffer.put(zzvpVarZzj.zzc.zza, zzvpVarZzj.zza(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == zzvpVarZzj.zzb) {
                zzvpVarZzj = zzvpVarZzj.zzd;
            }
        }
        return zzvpVarZzj;
    }

    private static zzvp zzl(zzvp zzvpVar, long j, byte[] bArr, int i) {
        zzvp zzvpVarZzj = zzj(zzvpVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (zzvpVarZzj.zzb - j));
            System.arraycopy(zzvpVarZzj.zzc.zza, zzvpVarZzj.zza(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == zzvpVarZzj.zzb) {
                zzvpVarZzj = zzvpVarZzj.zzd;
            }
        }
        return zzvpVarZzj;
    }

    private static zzvp zzm(zzvp zzvpVar, zzhd zzhdVar, zzvs zzvsVar, zzek zzekVar) {
        zzvp zzvpVarZzl;
        int iZzq;
        if (zzhdVar.zzk()) {
            long j = zzvsVar.zzb;
            zzekVar.zzH(1);
            zzvp zzvpVarZzl2 = zzl(zzvpVar, j, zzekVar.zzM(), 1);
            long j2 = j + 1;
            byte b = zzekVar.zzM()[0];
            int i = b & 128;
            int i2 = b & 127;
            zzha zzhaVar = zzhdVar.zzb;
            byte[] bArr = zzhaVar.zza;
            if (bArr == null) {
                zzhaVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = i != 0;
            zzvpVarZzl = zzl(zzvpVarZzl2, j2, zzhaVar.zza, i2);
            long j3 = j2 + ((long) i2);
            if (z) {
                zzekVar.zzH(2);
                zzvpVarZzl = zzl(zzvpVarZzl, j3, zzekVar.zzM(), 2);
                j3 += 2;
                iZzq = zzekVar.zzq();
            } else {
                iZzq = 1;
            }
            int[] iArr = zzhaVar.zzd;
            if (iArr == null || iArr.length < iZzq) {
                iArr = new int[iZzq];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzhaVar.zze;
            if (iArr3 == null || iArr3.length < iZzq) {
                iArr3 = new int[iZzq];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i3 = iZzq * 6;
                zzekVar.zzH(i3);
                zzvpVarZzl = zzl(zzvpVarZzl, j3, zzekVar.zzM(), i3);
                j3 += (long) i3;
                zzekVar.zzK(0);
                for (int i4 = 0; i4 < iZzq; i4++) {
                    iArr2[i4] = zzekVar.zzq();
                    iArr4[i4] = zzekVar.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzvsVar.zza - ((int) (j3 - zzvsVar.zzb));
            }
            zzado zzadoVar = zzvsVar.zzc;
            int i5 = zzet.zza;
            zzhaVar.zzc(iZzq, iArr2, iArr4, zzadoVar.zzb, zzhaVar.zza, zzadoVar.zza, zzadoVar.zzc, zzadoVar.zzd);
            long j4 = zzvsVar.zzb;
            int i6 = (int) (j3 - j4);
            zzvsVar.zzb = j4 + ((long) i6);
            zzvsVar.zza -= i6;
        } else {
            zzvpVarZzl = zzvpVar;
        }
        if (!zzhdVar.zze()) {
            zzhdVar.zzi(zzvsVar.zza);
            return zzk(zzvpVarZzl, zzvsVar.zzb, zzhdVar.zzc, zzvsVar.zza);
        }
        zzekVar.zzH(4);
        zzvp zzvpVarZzl3 = zzl(zzvpVarZzl, zzvsVar.zzb, zzekVar.zzM(), 4);
        int iZzp = zzekVar.zzp();
        zzvsVar.zzb += 4;
        zzvsVar.zza -= 4;
        zzhdVar.zzi(iZzp);
        zzvp zzvpVarZzk = zzk(zzvpVarZzl3, zzvsVar.zzb, zzhdVar.zzc, iZzp);
        zzvsVar.zzb += (long) iZzp;
        int i7 = zzvsVar.zza - iZzp;
        zzvsVar.zza = i7;
        ByteBuffer byteBuffer = zzhdVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i7) {
            zzhdVar.zzf = ByteBuffer.allocate(i7);
        } else {
            zzhdVar.zzf.clear();
        }
        return zzk(zzvpVarZzk, zzvsVar.zzb, zzhdVar.zzf, zzvsVar.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zzvp zzvpVar = this.zzd;
        if (j == zzvpVar.zzb) {
            this.zzd = zzvpVar.zzd;
        }
    }

    public final int zza(zzp zzpVar, int i, boolean z) throws EOFException {
        int iZzi = zzi(i);
        zzvp zzvpVar = this.zzd;
        int iZza = zzpVar.zza(zzvpVar.zzc.zza, zzvpVar.zza(this.zze), iZzi);
        if (iZza != -1) {
            zzn(iZza);
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzvp zzvpVar;
        if (j != -1) {
            while (true) {
                zzvpVar = this.zzb;
                if (j < zzvpVar.zzb) {
                    break;
                }
                this.zzf.zzc(zzvpVar.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzvpVar.zza) {
                this.zzc = zzvpVar;
            }
        }
    }

    public final void zzd(zzhd zzhdVar, zzvs zzvsVar) {
        zzm(this.zzc, zzhdVar, zzvsVar, this.zza);
    }

    public final void zze(zzhd zzhdVar, zzvs zzvsVar) {
        this.zzc = zzm(this.zzc, zzhdVar, zzvsVar, this.zza);
    }

    public final void zzf() {
        zzvp zzvpVar = this.zzb;
        if (zzvpVar.zzc != null) {
            this.zzf.zzd(zzvpVar);
            zzvpVar.zzb();
        }
        this.zzb.zze(0L, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
        zzvp zzvpVar2 = this.zzb;
        this.zzc = zzvpVar2;
        this.zzd = zzvpVar2;
        this.zze = 0L;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzek zzekVar, int i) {
        while (i > 0) {
            int iZzi = zzi(i);
            zzvp zzvpVar = this.zzd;
            zzekVar.zzG(zzvpVar.zzc.zza, zzvpVar.zza(this.zze), iZzi);
            i -= iZzi;
            zzn(iZzi);
        }
    }
}
