package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxd implements zzhfc {
    private final zzhfu zza;

    public zzdxd(zzhfu zzhfuVar) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        String packageName = ((zzcgp) this.zza).zza().getPackageName();
        zzhfk.zzb(packageName);
        return packageName;
    }
}
