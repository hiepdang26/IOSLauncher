package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzcrw implements zzcrx {
    private final Map zza;

    public zzcrw(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcrx
    public final zzeet zza(int i, String str) {
        return (zzeet) this.zza.get(str);
    }
}
