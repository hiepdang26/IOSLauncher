package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzua implements zzug, zzuf {
    public final zzui zza;
    private final long zzb;
    private zzuk zzc;
    private zzug zzd;
    private zzuf zze;
    private long zzf = -9223372036854775807L;
    private final zzyk zzg;

    public zzua(zzui zzuiVar, zzyk zzykVar, long j) {
        this.zza = zzuiVar;
        this.zzg = zzykVar;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zza(long j, zzlj zzljVar) {
        zzug zzugVar = this.zzd;
        int i = zzet.zza;
        return zzugVar.zza(j, zzljVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzb() {
        zzug zzugVar = this.zzd;
        int i = zzet.zza;
        return zzugVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final long zzc() {
        zzug zzugVar = this.zzd;
        int i = zzet.zza;
        return zzugVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzd() {
        zzug zzugVar = this.zzd;
        int i = zzet.zza;
        return zzugVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zze(long j) {
        zzug zzugVar = this.zzd;
        int i = zzet.zza;
        return zzugVar.zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final /* bridge */ /* synthetic */ void zzf(zzvz zzvzVar) {
        zzuf zzufVar = this.zze;
        int i = zzet.zza;
        zzufVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final long zzg(zzxv[] zzxvVarArr, boolean[] zArr, zzvx[] zzvxVarArr, boolean[] zArr2, long j) {
        long j2 = this.zzf;
        long j3 = (j2 == -9223372036854775807L || j != this.zzb) ? j : j2;
        this.zzf = -9223372036854775807L;
        zzug zzugVar = this.zzd;
        int i = zzet.zza;
        return zzugVar.zzg(zzxvVarArr, zArr, zzvxVarArr, zArr2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzuf
    public final void zzh(zzug zzugVar) {
        zzuf zzufVar = this.zze;
        int i = zzet.zza;
        zzufVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final zzwi zzi() {
        zzug zzugVar = this.zzd;
        int i = zzet.zza;
        return zzugVar.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzj(long j, boolean z) {
        zzug zzugVar = this.zzd;
        int i = zzet.zza;
        zzugVar.zzj(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzk() {
        zzug zzugVar = this.zzd;
        if (zzugVar != null) {
            zzugVar.zzk();
            return;
        }
        zzuk zzukVar = this.zzc;
        if (zzukVar != null) {
            zzukVar.zzz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zzl(zzuf zzufVar, long j) {
        this.zze = zzufVar;
        zzug zzugVar = this.zzd;
        if (zzugVar != null) {
            zzugVar.zzl(this, zzv(this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final void zzm(long j) {
        zzug zzugVar = this.zzd;
        int i = zzet.zza;
        zzugVar.zzm(j);
    }

    public final long zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzo(zzkf zzkfVar) {
        zzug zzugVar = this.zzd;
        return zzugVar != null && zzugVar.zzo(zzkfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvz
    public final boolean zzp() {
        zzug zzugVar = this.zzd;
        return zzugVar != null && zzugVar.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzui zzuiVar) {
        long jZzv = zzv(this.zzb);
        zzuk zzukVar = this.zzc;
        zzukVar.getClass();
        zzug zzugVarZzI = zzukVar.zzI(zzuiVar, this.zzg, jZzv);
        this.zzd = zzugVarZzI;
        if (this.zze != null) {
            zzugVarZzI.zzl(this, jZzv);
        }
    }

    public final void zzs(long j) {
        this.zzf = j;
    }

    public final void zzt() {
        zzug zzugVar = this.zzd;
        if (zzugVar != null) {
            zzuk zzukVar = this.zzc;
            zzukVar.getClass();
            zzukVar.zzG(zzugVar);
        }
    }

    public final void zzu(zzuk zzukVar) {
        zzdi.zzf(this.zzc == null);
        this.zzc = zzukVar;
    }
}
