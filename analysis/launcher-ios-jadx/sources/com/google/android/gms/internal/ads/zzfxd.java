package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class zzfxd extends zzfxg {
    public zzfxd() {
        super(null);
    }

    public static final zzfxg zzf(int i) {
        return i < 0 ? zzfxg.zzb : i > 0 ? zzfxg.zzc : zzfxg.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final zzfxg zzb(int i, int i2) {
        return zzf(i < i2 ? -1 : i > i2 ? 1 : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final zzfxg zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final zzfxg zzd(boolean z, boolean z2) {
        return zzf(zzgal.zza(z, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final zzfxg zze(boolean z, boolean z2) {
        return zzf(zzgal.zza(z2, z));
    }
}
