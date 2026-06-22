package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgku {
    final Map zza = new HashMap();
    final Map zzb = new HashMap();

    private zzgku() {
    }

    public final zzgku zza(Enum r2, Object obj) {
        this.zza.put(r2, obj);
        this.zzb.put(obj, r2);
        return this;
    }

    public final zzgkw zzb() {
        return new zzgkw(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb), null);
    }

    public /* synthetic */ zzgku(zzgkt zzgktVar) {
    }
}
