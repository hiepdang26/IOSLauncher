package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzqd {
    private final zzct[] zza;
    private final zzqx zzb;
    private final zzcw zzc;

    public zzqd(zzct... zzctVarArr) {
        zzqx zzqxVar = new zzqx();
        zzcw zzcwVar = new zzcw();
        zzct[] zzctVarArr2 = {zzqxVar, zzcwVar};
        this.zza = zzctVarArr2;
        System.arraycopy(zzctVarArr, 0, zzctVarArr2, 0, 0);
        this.zzb = zzqxVar;
        this.zzc = zzcwVar;
    }

    public final long zza(long j) {
        return this.zzc.zzg() ? this.zzc.zzi(j) : j;
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzbq zzc(zzbq zzbqVar) {
        this.zzc.zzk(zzbqVar.zzb);
        this.zzc.zzj(zzbqVar.zzc);
        return zzbqVar;
    }

    public final boolean zzd(boolean z) {
        this.zzb.zzp(z);
        return z;
    }

    public final zzct[] zze() {
        return this.zza;
    }
}
