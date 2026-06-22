package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzauv extends zzasy {
    public long zza;
    public long zzb;

    public zzauv() {
        this.zza = -1L;
        this.zzb = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, Long.valueOf(this.zza));
        map.put(1, Long.valueOf(this.zzb));
        return map;
    }

    public zzauv(String str) {
        this.zza = -1L;
        this.zzb = -1L;
        HashMap mapZza = zzasy.zza(str);
        if (mapZza != null) {
            this.zza = ((Long) mapZza.get(0)).longValue();
            this.zzb = ((Long) mapZza.get(1)).longValue();
        }
    }
}
