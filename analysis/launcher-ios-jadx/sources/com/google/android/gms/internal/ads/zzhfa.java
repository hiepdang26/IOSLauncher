package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhfa implements zzhfc {
    private zzhfl zza;

    public static void zza(zzhfl zzhflVar, zzhfl zzhflVar2) {
        zzhfa zzhfaVar = (zzhfa) zzhflVar;
        if (zzhfaVar.zza != null) {
            throw new IllegalStateException();
        }
        zzhfaVar.zza = zzhflVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        zzhfl zzhflVar = this.zza;
        if (zzhflVar != null) {
            return zzhflVar.zzb();
        }
        throw new IllegalStateException();
    }
}
