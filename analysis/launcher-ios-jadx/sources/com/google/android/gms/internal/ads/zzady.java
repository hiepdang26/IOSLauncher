package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzady implements zzadi {
    final /* synthetic */ zzaeb zza;
    private final long zzb;

    public zzady(zzaeb zzaebVar, long j) {
        this.zza = zzaebVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        zzadg zzadgVarZza = this.zza.zzi[0].zza(j);
        int i = 1;
        while (true) {
            zzaeb zzaebVar = this.zza;
            if (i >= zzaebVar.zzi.length) {
                return zzadgVarZza;
            }
            zzadg zzadgVarZza2 = zzaebVar.zzi[i].zza(j);
            if (zzadgVarZza2.zza.zzc < zzadgVarZza.zza.zzc) {
                zzadgVarZza = zzadgVarZza2;
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadi
    public final boolean zzh() {
        return true;
    }
}
