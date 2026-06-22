package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzclw {
    private final Map zza;
    private final Map zzb;

    public zzclw(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfex zzfexVar) {
        for (zzfev zzfevVar : zzfexVar.zzb.zzc) {
            if (this.zza.containsKey(zzfevVar.zza)) {
                ((zzclz) this.zza.get(zzfevVar.zza)).zza(zzfevVar.zzb);
            } else if (this.zzb.containsKey(zzfevVar.zza)) {
                zzcly zzclyVar = (zzcly) this.zzb.get(zzfevVar.zza);
                JSONObject jSONObject = zzfevVar.zzb;
                HashMap map = new HashMap();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String strOptString = jSONObject.optString(next);
                    if (strOptString != null) {
                        map.put(next, strOptString);
                    }
                }
                zzclyVar.zza(map);
            }
        }
    }
}
