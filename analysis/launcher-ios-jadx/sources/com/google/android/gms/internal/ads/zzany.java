package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
final class zzany implements zzanx {
    private final zzacn zza;
    private final zzadp zzb;
    private final zzaoa zzc;
    private final zzaf zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzany(zzacn zzacnVar, zzadp zzadpVar, zzaoa zzaoaVar, String str, int i) throws zzbo {
        this.zza = zzacnVar;
        this.zzb = zzadpVar;
        this.zzc = zzaoaVar;
        int i2 = zzaoaVar.zzb * zzaoaVar.zze;
        int i3 = zzaoaVar.zzd;
        int i4 = i2 / 8;
        if (i3 != i4) {
            throw zzbo.zza("Expected block size: " + i4 + "; got: " + i3, null);
        }
        int i5 = zzaoaVar.zzc * i4;
        int i6 = i5 * 8;
        int iMax = Math.max(i4, i5 / 10);
        this.zze = iMax;
        zzad zzadVar = new zzad();
        zzadVar.zzX(str);
        zzadVar.zzx(i6);
        zzadVar.zzS(i6);
        zzadVar.zzP(iMax);
        zzadVar.zzy(zzaoaVar.zzb);
        zzadVar.zzY(zzaoaVar.zzc);
        zzadVar.zzR(i);
        this.zzd = zzadVar.zzad();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zza(int i, long j) {
        this.zza.zzO(new zzaod(this.zzc, 1, i, j));
        this.zzb.zzl(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final boolean zzc(zzacl zzaclVar, long j) {
        int i;
        int i2;
        long j2 = j;
        while (j2 > 0 && (i = this.zzg) < (i2 = this.zze)) {
            int iZzf = this.zzb.zzf(zzaclVar, (int) Math.min(i2 - i, j2), true);
            if (iZzf == -1) {
                j2 = 0;
            } else {
                this.zzg += iZzf;
                j2 -= (long) iZzf;
            }
        }
        zzaoa zzaoaVar = this.zzc;
        int i3 = this.zzg;
        int i4 = zzaoaVar.zzd;
        int i5 = i3 / i4;
        if (i5 > 0) {
            long jZzt = this.zzf + zzet.zzt(this.zzh, 1000000L, zzaoaVar.zzc, RoundingMode.FLOOR);
            int i6 = i5 * i4;
            int i7 = this.zzg - i6;
            this.zzb.zzs(jZzt, 1, i6, i7, null);
            this.zzh += (long) i5;
            this.zzg = i7;
        }
        return j2 <= 0;
    }
}
