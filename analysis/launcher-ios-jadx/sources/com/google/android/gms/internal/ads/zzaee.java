package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzaee {
    protected final zzadp zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long[] zzk;
    private int[] zzl;

    public zzaee(int i, int i2, long j, int i3, zzadp zzadpVar) {
        i2 = i2 != 1 ? 2 : i2;
        this.zzd = j;
        this.zze = i3;
        this.zza = zzadpVar;
        this.zzb = zzi(i, i2 == 2 ? 1667497984 : 1651965952);
        this.zzc = i2 == 2 ? zzi(i, 1650720768) : -1;
        this.zzk = new long[512];
        this.zzl = new int[512];
    }

    private static int zzi(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    private final long zzj(int i) {
        return (this.zzd * ((long) i)) / ((long) this.zze);
    }

    private final zzadj zzk(int i) {
        return new zzadj(((long) this.zzl[i]) * zzj(1), this.zzk[i]);
    }

    public final zzadg zza(long j) {
        int iZzj = (int) (j / zzj(1));
        int iZzb = zzet.zzb(this.zzl, iZzj, true, true);
        if (this.zzl[iZzb] == iZzj) {
            zzadj zzadjVarZzk = zzk(iZzb);
            return new zzadg(zzadjVarZzk, zzadjVarZzk);
        }
        zzadj zzadjVarZzk2 = zzk(iZzb);
        int i = iZzb + 1;
        return i < this.zzk.length ? new zzadg(zzadjVarZzk2, zzk(i)) : new zzadg(zzadjVarZzk2, zzadjVarZzk2);
    }

    public final void zzb(long j) {
        if (this.zzj == this.zzl.length) {
            long[] jArr = this.zzk;
            this.zzk = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.zzl;
            this.zzl = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.zzk;
        int i = this.zzj;
        jArr2[i] = j;
        this.zzl[i] = this.zzi;
        this.zzj = i + 1;
    }

    public final void zzc() {
        this.zzk = Arrays.copyOf(this.zzk, this.zzj);
        this.zzl = Arrays.copyOf(this.zzl, this.zzj);
    }

    public final void zzd() {
        this.zzi++;
    }

    public final void zze(int i) {
        this.zzf = i;
        this.zzg = i;
    }

    public final void zzf(long j) {
        if (this.zzj == 0) {
            this.zzh = 0;
        } else {
            this.zzh = this.zzl[zzet.zzc(this.zzk, j, true, true)];
        }
    }

    public final boolean zzg(int i) {
        return this.zzb == i || this.zzc == i;
    }

    public final boolean zzh(zzacl zzaclVar) {
        int i = this.zzg;
        int iZzf = i - this.zza.zzf(zzaclVar, i, false);
        this.zzg = iZzf;
        boolean z = iZzf == 0;
        if (z) {
            if (this.zzf > 0) {
                this.zza.zzs(zzj(this.zzh), Arrays.binarySearch(this.zzl, this.zzh) >= 0 ? 1 : 0, this.zzf, 0, null);
            }
            this.zzh++;
        }
        return z;
    }
}
