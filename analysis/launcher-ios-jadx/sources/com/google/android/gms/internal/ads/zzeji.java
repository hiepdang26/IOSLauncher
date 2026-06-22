package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzeji implements zzeev {
    private final Map zza = new HashMap();
    private final zzdqb zzb;

    public zzeji(zzdqb zzdqbVar) {
        this.zzb = zzdqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeev
    public final zzeew zza(String str, JSONObject jSONObject) {
        zzeew zzeewVar;
        synchronized (this) {
            try {
                zzeewVar = (zzeew) this.zza.get(str);
                if (zzeewVar == null) {
                    zzeewVar = new zzeew(this.zzb.zzc(str, jSONObject), new zzegq(), str);
                    this.zza.put(str, zzeewVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzeewVar;
    }
}
