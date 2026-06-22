package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaev implements zzack {
    private final zzek zza = new zzek(4);
    private final zzadk zzb = new zzadk(-1, -1, "image/heif");

    private final boolean zza(zzacl zzaclVar, int i) {
        this.zza.zzH(4);
        ((zzaby) zzaclVar).zzm(this.zza.zzM(), 0, 4, false);
        return this.zza.zzu() == ((long) i);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final int zzb(zzacl zzaclVar, zzadf zzadfVar) {
        return this.zzb.zzb(zzaclVar, zzadfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ zzack zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zze(zzacn zzacnVar) {
        this.zzb.zze(zzacnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final void zzi(long j, long j2) {
        this.zzb.zzi(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzack
    public final boolean zzj(zzacl zzaclVar) throws EOFException, InterruptedIOException {
        ((zzaby) zzaclVar).zzl(4, false);
        return zza(zzaclVar, 1718909296) && zza(zzaclVar, 1751476579);
    }
}
