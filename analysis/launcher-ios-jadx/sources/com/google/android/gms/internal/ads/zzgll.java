package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzgll {
    private HashMap zza = new HashMap();

    public final zzgln zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzgln zzglnVar = new zzgln(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzglnVar;
    }
}
