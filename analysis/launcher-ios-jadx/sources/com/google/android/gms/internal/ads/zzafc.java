package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzafc implements zzacn {
    private final long zzb;
    private final zzacn zzc;

    public zzafc(long j, zzacn zzacnVar) {
        this.zzb = j;
        this.zzc = zzacnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final void zzD() {
        this.zzc.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final void zzO(zzadi zzadiVar) {
        this.zzc.zzO(new zzafb(this, zzadiVar, zzadiVar));
    }

    @Override // com.google.android.gms.internal.ads.zzacn
    public final zzadp zzw(int i, int i2) {
        return this.zzc.zzw(i, i2);
    }
}
