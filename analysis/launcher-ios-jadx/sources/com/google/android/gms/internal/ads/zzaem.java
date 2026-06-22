package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
final class zzaem implements zzabt {
    private final zzacv zza;
    private final int zzb;
    private final zzacq zzc = new zzacq();

    public /* synthetic */ zzaem(zzacv zzacvVar, int i, zzael zzaelVar) {
        this.zza = zzacvVar;
        this.zzb = i;
    }

    private final long zzc(zzacl zzaclVar) throws EOFException, InterruptedIOException {
        while (zzaclVar.zze() < zzaclVar.zzd() - 6) {
            zzacv zzacvVar = this.zza;
            int i = this.zzb;
            zzacq zzacqVar = this.zzc;
            long jZze = zzaclVar.zze();
            byte[] bArr = new byte[2];
            zzaby zzabyVar = (zzaby) zzaclVar;
            zzabyVar.zzm(bArr, 0, 2, false);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                zzaclVar.zzj();
                zzabyVar.zzl((int) (jZze - zzaclVar.zzf()), false);
            } else {
                zzek zzekVar = new zzek(16);
                System.arraycopy(bArr, 0, zzekVar.zzM(), 0, 2);
                zzekVar.zzJ(zzaco.zza(zzaclVar, zzekVar.zzM(), 2, 14));
                zzaclVar.zzj();
                zzabyVar.zzl((int) (jZze - zzaclVar.zzf()), false);
                if (zzacr.zzc(zzekVar, zzacvVar, i, zzacqVar)) {
                    break;
                }
            }
            zzabyVar.zzl(1, false);
        }
        if (zzaclVar.zze() < zzaclVar.zzd() - 6) {
            return this.zzc.zza;
        }
        ((zzaby) zzaclVar).zzl((int) (zzaclVar.zzd() - zzaclVar.zze()), false);
        return this.zza.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final zzabs zza(zzacl zzaclVar, long j) throws EOFException, InterruptedIOException {
        int i = this.zza.zzc;
        long jZzf = zzaclVar.zzf();
        long jZzc = zzc(zzaclVar);
        long jZze = zzaclVar.zze();
        ((zzaby) zzaclVar).zzl(Math.max(6, i), false);
        long jZzc2 = zzc(zzaclVar);
        return (jZzc > j || jZzc2 <= j) ? jZzc2 <= j ? zzabs.zzf(jZzc2, zzaclVar.zze()) : zzabs.zzd(jZzc, jZzf) : zzabs.zze(jZze);
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final /* synthetic */ void zzb() {
    }
}
