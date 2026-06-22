package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxe {
    private final Map zza = new HashMap();

    public final AtomicReference zza(String str) {
        synchronized (this) {
            try {
                if (!this.zza.containsKey(str)) {
                    this.zza.put(str, new AtomicReference());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return (AtomicReference) this.zza.get(str);
    }
}
