package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzhfg extends zzhey {
    static {
        zzhfd.zza(Collections.EMPTY_MAP);
    }

    public /* synthetic */ zzhfg(Map map, zzhfe zzhfeVar) {
        super(map);
    }

    public static zzhff zzc(int i) {
        return new zzhff(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final Map zzb() {
        LinkedHashMap linkedHashMapZzb = zzhez.zzb(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            linkedHashMapZzb.put(entry.getKey(), ((zzhfl) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(linkedHashMapZzb);
    }
}
