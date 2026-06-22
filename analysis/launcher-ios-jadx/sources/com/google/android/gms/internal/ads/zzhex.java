package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class zzhex {
    final LinkedHashMap zza;

    public zzhex(int i) {
        this.zza = zzhez.zzb(i);
    }

    public final zzhex zza(Object obj, zzhfl zzhflVar) {
        zzhfk.zza(obj, "key");
        zzhfk.zza(zzhflVar, "provider");
        this.zza.put(obj, zzhflVar);
        return this;
    }
}
