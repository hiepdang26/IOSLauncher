package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzafb extends zzacx {
    final /* synthetic */ zzadi zza;
    final /* synthetic */ zzafc zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzafb(zzafc zzafcVar, zzadi zzadiVar, zzadi zzadiVar2) {
        super(zzadiVar);
        this.zza = zzadiVar2;
        this.zzb = zzafcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacx, com.google.android.gms.internal.ads.zzadi
    public final zzadg zzg(long j) {
        zzadg zzadgVarZzg = this.zza.zzg(j);
        zzadj zzadjVar = zzadgVarZzg.zza;
        zzadj zzadjVar2 = new zzadj(zzadjVar.zzb, this.zzb.zzb + zzadjVar.zzc);
        zzadj zzadjVar3 = zzadgVarZzg.zzb;
        return new zzadg(zzadjVar2, new zzadj(zzadjVar3.zzb, this.zzb.zzb + zzadjVar3.zzc));
    }
}
