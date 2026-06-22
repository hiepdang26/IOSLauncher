package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgmg {
    private static final zzgmg zza = new zzgmg();
    private final Map zzb = new HashMap();

    public static zzgmg zzb() {
        return zza;
    }

    public final synchronized zzgen zza(String str) {
        if (!this.zzb.containsKey("AES128_GCM")) {
            throw new GeneralSecurityException("Name AES128_GCM does not exist");
        }
        return (zzgen) this.zzb.get("AES128_GCM");
    }

    public final synchronized void zzc(String str, zzgen zzgenVar) {
        try {
            if (!this.zzb.containsKey(str)) {
                this.zzb.put(str, zzgenVar);
                return;
            }
            if (((zzgen) this.zzb.get(str)).equals(zzgenVar)) {
                return;
            }
            throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + String.valueOf(this.zzb.get(str)) + "), cannot insert " + String.valueOf(zzgenVar));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzd(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzc((String) entry.getKey(), (zzgen) entry.getValue());
        }
    }
}
