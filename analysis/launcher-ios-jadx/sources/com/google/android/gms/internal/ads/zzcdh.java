package com.google.android.gms.internal.ads;

import androidx.profileinstaller.ProfileVerifier;

/* JADX INFO: loaded from: classes.dex */
public final class zzcdh implements zzkb {
    private final zzyk zza = new zzyk(true, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = 5000000;
    private int zzf;
    private boolean zzg;

    public final void zza(boolean z) {
        this.zzf = 0;
        this.zzg = false;
        if (z) {
            this.zza.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final long zzb(zznz zznzVar) {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zzc(zznz zznzVar) {
        zza(false);
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zzd(zznz zznzVar) {
        zza(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zze(zznz zznzVar) {
        zza(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zzf(zznz zznzVar, zzcc zzccVar, zzui zzuiVar, zzle[] zzleVarArr, zzwi zzwiVar, zzxv[] zzxvVarArr) {
        int i = 0;
        this.zzf = 0;
        while (true) {
            int length = zzleVarArr.length;
            if (i >= 2) {
                this.zza.zzf(this.zzf);
                return;
            } else {
                if (zzxvVarArr[i] != null) {
                    this.zzf += zzleVarArr[i].zzb() != 1 ? 131072000 : 13107200;
                }
                i++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final boolean zzg(zznz zznzVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final boolean zzh(zzka zzkaVar) {
        long j = zzkaVar.zzb;
        boolean z = true;
        char c = j > this.zzc ? (char) 0 : j < this.zzb ? (char) 2 : (char) 1;
        int iZza = this.zza.zza();
        int i = this.zzf;
        if (c != 2 && (c != 1 || !this.zzg || iZza >= i)) {
            z = false;
        }
        this.zzg = z;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final boolean zzi(zzka zzkaVar) {
        long j = zzkaVar.zzd ? this.zze : this.zzd;
        return j <= 0 || zzkaVar.zzb >= j;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final zzyk zzj() {
        return this.zza;
    }

    public final synchronized void zzk(int i) {
        this.zzd = ((long) i) * 1000;
    }

    public final synchronized void zzl(int i) {
        this.zze = ((long) i) * 1000;
    }

    public final synchronized void zzm(int i) {
        this.zzc = ((long) i) * 1000;
    }

    public final synchronized void zzn(int i) {
        this.zzb = ((long) i) * 1000;
    }
}
