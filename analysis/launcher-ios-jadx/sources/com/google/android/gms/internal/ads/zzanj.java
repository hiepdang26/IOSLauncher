package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzanj implements zzabt {
    private final zzer zza;
    private final zzek zzb = new zzek();
    private final int zzc;

    public zzanj(int i, zzer zzerVar, int i2) {
        this.zzc = i;
        this.zza = zzerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final zzabs zza(zzacl zzaclVar, long j) {
        int iZza;
        int iZza2;
        long jZzf = zzaclVar.zzf();
        int iMin = (int) Math.min(112800L, zzaclVar.zzd() - jZzf);
        this.zzb.zzH(iMin);
        ((zzaby) zzaclVar).zzm(this.zzb.zzM(), 0, iMin, false);
        zzek zzekVar = this.zzb;
        int iZze = zzekVar.zze();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzekVar.zzb() >= 188 && (iZza2 = (iZza = zzanu.zza(zzekVar.zzM(), zzekVar.zzd(), iZze)) + 188) <= iZze) {
            long jZzb = zzanu.zzb(zzekVar, iZza, this.zzc);
            if (jZzb != -9223372036854775807L) {
                long jZzb2 = this.zza.zzb(jZzb);
                if (jZzb2 > j) {
                    return j3 == -9223372036854775807L ? zzabs.zzd(jZzb2, jZzf) : zzabs.zze(jZzf + j4);
                }
                j4 = iZza;
                if (100000 + jZzb2 > j) {
                    return zzabs.zze(jZzf + j4);
                }
                j3 = jZzb2;
            }
            zzekVar.zzK(iZza2);
            j2 = iZza2;
        }
        return j3 != -9223372036854775807L ? zzabs.zzf(j3, jZzf + j2) : zzabs.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final void zzb() {
        byte[] bArr = zzet.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}
