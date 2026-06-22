package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class zzhey implements zzhfc {
    private final Map zza;

    public zzhey(Map map) {
        this.zza = Collections.unmodifiableMap(map);
    }

    public final Map zza() {
        return this.zza;
    }
}
