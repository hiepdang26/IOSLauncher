package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzalf implements zzajv {
    private final zzaky zza;
    private final long[] zzb;
    private final Map zzc;
    private final Map zzd;
    private final Map zze;

    public zzalf(zzaky zzakyVar, Map map, Map map2, Map map3) {
        this.zza = zzakyVar;
        this.zzd = map2;
        this.zze = map3;
        this.zzc = Collections.unmodifiableMap(map);
        this.zzb = zzakyVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final long zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final List zzc(long j) {
        return this.zza.zze(j, this.zzc, this.zzd, this.zze);
    }
}
