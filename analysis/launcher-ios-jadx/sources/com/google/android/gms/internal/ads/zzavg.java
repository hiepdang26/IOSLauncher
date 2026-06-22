package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzavg extends zzasy {
    public Long zza;
    public Boolean zzb;
    public Boolean zzc;

    public zzavg() {
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, this.zza);
        map.put(1, this.zzb);
        map.put(2, this.zzc);
        return map;
    }

    public zzavg(String str) {
        HashMap mapZza = zzasy.zza(str);
        if (mapZza != null) {
            this.zza = (Long) mapZza.get(0);
            this.zzb = (Boolean) mapZza.get(1);
            this.zzc = (Boolean) mapZza.get(2);
        }
    }
}
