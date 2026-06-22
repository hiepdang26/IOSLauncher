package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzbcj {
    private final Map zza = new HashMap();
    private final zzbcl zzb;

    public zzbcj(zzbcl zzbclVar) {
        this.zzb = zzbclVar;
    }

    public final zzbcl zza() {
        return this.zzb;
    }

    public final void zzb(String str, zzbci zzbciVar) {
        this.zza.put(str, zzbciVar);
    }

    public final void zzc(String str, String str2, long j) {
        zzbci zzbciVar = (zzbci) this.zza.get(str2);
        String[] strArr = {str};
        if (zzbciVar != null) {
            this.zzb.zze(zzbciVar, j, strArr);
        }
        this.zza.put(str, new zzbci(j, null, null));
    }
}
