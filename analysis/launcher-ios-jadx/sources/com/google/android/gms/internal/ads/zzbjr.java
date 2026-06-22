package com.google.android.gms.internal.ads;

import defpackage.hg0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbjr implements zzbix {
    private final zzdvi zza;

    public zzbjr(zzdvi zzdviVar) {
        hg0.j(zzdviVar, "The Inspector Manager must not be null");
        this.zza = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        if (map == null || !map.containsKey("extras")) {
            return;
        }
        long j = Long.MAX_VALUE;
        if (map.containsKey("expires")) {
            try {
                j = Long.parseLong((String) map.get("expires"));
            } catch (NumberFormatException unused) {
            }
        }
        this.zza.zzi((String) map.get("extras"), j);
    }
}
