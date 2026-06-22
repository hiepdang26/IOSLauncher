package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzafa extends zzacw {
    private final long zza;

    public zzafa(zzacl zzaclVar, long j) {
        super(zzaclVar);
        zzdi.zzd(zzaclVar.zzf() >= j);
        this.zza = j;
    }

    @Override // com.google.android.gms.internal.ads.zzacw, com.google.android.gms.internal.ads.zzacl
    public final long zzd() {
        return super.zzd() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacw, com.google.android.gms.internal.ads.zzacl
    public final long zze() {
        return super.zze() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacw, com.google.android.gms.internal.ads.zzacl
    public final long zzf() {
        return super.zzf() - this.zza;
    }
}
