package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
final class zzanw implements zzanx {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzacn zzc;
    private final zzadp zzd;
    private final zzaoa zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzek zzh;
    private final int zzi;
    private final zzaf zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzanw(zzacn zzacnVar, zzadp zzadpVar, zzaoa zzaoaVar) throws zzbo {
        this.zzc = zzacnVar;
        this.zzd = zzadpVar;
        this.zze = zzaoaVar;
        int iMax = Math.max(1, zzaoaVar.zzc / 10);
        this.zzi = iMax;
        zzek zzekVar = new zzek(zzaoaVar.zzf);
        zzekVar.zzk();
        int iZzk = zzekVar.zzk();
        this.zzf = iZzk;
        int i = zzaoaVar.zzb;
        int i2 = zzaoaVar.zzd;
        int i3 = (((i2 - (i * 4)) * 8) / (zzaoaVar.zze * i)) + 1;
        if (iZzk != i3) {
            throw zzbo.zza("Expected frames per block: " + i3 + "; got: " + iZzk, null);
        }
        int i4 = zzet.zza;
        int i5 = ((iMax + iZzk) - 1) / iZzk;
        this.zzg = new byte[i2 * i5];
        this.zzh = new zzek((iZzk + iZzk) * i * i5);
        int i6 = ((zzaoaVar.zzc * zzaoaVar.zzd) * 8) / iZzk;
        zzad zzadVar = new zzad();
        zzadVar.zzX("audio/raw");
        zzadVar.zzx(i6);
        zzadVar.zzS(i6);
        zzadVar.zzP((iMax + iMax) * i);
        zzadVar.zzy(zzaoaVar.zzb);
        zzadVar.zzY(zzaoaVar.zzc);
        zzadVar.zzR(2);
        this.zzj = zzadVar.zzad();
    }

    private final int zzd(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zze(int i) {
        return (i + i) * this.zze.zzb;
    }

    private final void zzf(int i) {
        long jZzt = this.zzl + zzet.zzt(this.zzn, 1000000L, this.zze.zzc, RoundingMode.FLOOR);
        int iZze = zze(i);
        this.zzd.zzs(jZzt, 1, iZze, this.zzm - iZze, null);
        this.zzn += (long) i;
        this.zzm -= iZze;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zza(int i, long j) {
        this.zzc.zzO(new zzaod(this.zze, this.zzf, i, j));
        this.zzd.zzl(this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzb(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003d -> B:4:0x0022). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzanx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzacl r21, long r22) {
        /*
            Method dump skipped, instruction units count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanw.zzc(com.google.android.gms.internal.ads.zzacl, long):boolean");
    }
}
