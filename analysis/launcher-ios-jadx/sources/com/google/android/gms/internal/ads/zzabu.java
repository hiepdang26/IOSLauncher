package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
public class zzabu {
    protected final zzabo zza;
    protected final zzabt zzb;
    protected zzabq zzc;
    private final int zzd;

    public zzabu(zzabr zzabrVar, zzabt zzabtVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzabtVar;
        this.zzd = i;
        this.zza = new zzabo(zzabrVar, j, 0L, j3, j4, j5, j6);
    }

    public static final int zzf(zzacl zzaclVar, long j, zzadf zzadfVar) {
        if (j == zzaclVar.zzf()) {
            return 0;
        }
        zzadfVar.zza = j;
        return 1;
    }

    public static final boolean zzg(zzacl zzaclVar, long j) throws EOFException, InterruptedIOException {
        long jZzf = j - zzaclVar.zzf();
        if (jZzf < 0 || jZzf > 262144) {
            return false;
        }
        ((zzaby) zzaclVar).zzo((int) jZzf, false);
        return true;
    }

    public final int zza(zzacl zzaclVar, zzadf zzadfVar) throws EOFException, InterruptedIOException {
        while (true) {
            zzabq zzabqVar = this.zzc;
            zzdi.zzb(zzabqVar);
            long j = zzabqVar.zzf;
            long j2 = zzabqVar.zzg - j;
            int i = this.zzd;
            long j3 = zzabqVar.zzh;
            if (j2 <= i) {
                zzc(false, j);
                return zzf(zzaclVar, j, zzadfVar);
            }
            if (!zzg(zzaclVar, j3)) {
                return zzf(zzaclVar, j3, zzadfVar);
            }
            zzaclVar.zzj();
            zzabs zzabsVarZza = this.zzb.zza(zzaclVar, zzabqVar.zzb);
            int i2 = zzabsVarZza.zzb;
            if (i2 == -3) {
                zzc(false, j3);
                return zzf(zzaclVar, j3, zzadfVar);
            }
            if (i2 == -2) {
                zzabq.zzh(zzabqVar, zzabsVarZza.zzc, zzabsVarZza.zzd);
            } else {
                if (i2 != -1) {
                    zzg(zzaclVar, zzabsVarZza.zzd);
                    zzc(true, zzabsVarZza.zzd);
                    return zzf(zzaclVar, zzabsVarZza.zzd, zzadfVar);
                }
                zzabq.zzg(zzabqVar, zzabsVarZza.zzc, zzabsVarZza.zzd);
            }
        }
    }

    public final zzadi zzb() {
        return this.zza;
    }

    public final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        zzabq zzabqVar = this.zzc;
        if (zzabqVar == null || zzabqVar.zza != j) {
            zzabo zzaboVar = this.zza;
            this.zzc = new zzabq(j, zzaboVar.zzf(j), 0L, zzaboVar.zzc, zzaboVar.zzd, zzaboVar.zze, zzaboVar.zzf);
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
