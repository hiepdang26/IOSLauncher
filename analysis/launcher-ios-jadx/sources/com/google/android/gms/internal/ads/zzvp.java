package com.google.android.gms.internal.ads;

import androidx.profileinstaller.ProfileVerifier;

/* JADX INFO: loaded from: classes.dex */
final class zzvp implements zzye {
    public long zza;
    public long zzb;
    public zzyd zzc;
    public zzvp zzd;

    public zzvp(long j, int i) {
        zze(j, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
    }

    public final int zza(long j) {
        long j2 = j - this.zza;
        int i = this.zzc.zzb;
        return (int) j2;
    }

    public final zzvp zzb() {
        this.zzc = null;
        zzvp zzvpVar = this.zzd;
        this.zzd = null;
        return zzvpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzye
    public final zzyd zzc() {
        zzyd zzydVar = this.zzc;
        zzydVar.getClass();
        return zzydVar;
    }

    @Override // com.google.android.gms.internal.ads.zzye
    public final zzye zzd() {
        zzvp zzvpVar = this.zzd;
        if (zzvpVar == null || zzvpVar.zzc == null) {
            return null;
        }
        return zzvpVar;
    }

    public final void zze(long j, int i) {
        zzdi.zzf(this.zzc == null);
        this.zza = j;
        this.zzb = j + 65536;
    }
}
