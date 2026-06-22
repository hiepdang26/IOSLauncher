package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.ib2;
import defpackage.n42;
import defpackage.za2;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdqg {
    private final Map zza = new ConcurrentHashMap();
    private JSONObject zzb;
    private final Executor zzc;
    private boolean zzd;
    private JSONObject zze;

    public zzdqg(Executor executor) {
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized void zzf() {
        JSONObject jSONObjectZzf;
        Map map;
        try {
            this.zzd = true;
            zzbyy zzbyyVarX = ((ib2) hd2.B.g.zzi()).x();
            if (zzbyyVarX != null && (jSONObjectZzf = zzbyyVarX.zzf()) != null) {
                this.zzb = ((Boolean) n42.d.c.zza(zzbbw.zzdF)).booleanValue() ? jSONObjectZzf.optJSONObject("common_settings") : null;
                this.zze = jSONObjectZzf.optJSONObject("ad_unit_patterns");
                JSONArray jSONArrayOptJSONArray = jSONObjectZzf.optJSONArray("ad_unit_id_settings");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("ad_unit_id");
                            String strOptString2 = jSONObjectOptJSONObject.optString("format");
                            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("request_signals");
                            if (strOptString != null && jSONObjectOptJSONObject2 != null && strOptString2 != null) {
                                if (this.zza.containsKey(strOptString2)) {
                                    map = (Map) this.zza.get(strOptString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    this.zza.put(strOptString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(strOptString, jSONObjectOptJSONObject2);
                            }
                        }
                    }
                }
            }
        } finally {
        }
    }

    public final JSONObject zza() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzdF)).booleanValue()) {
            return this.zzb;
        }
        return null;
    }

    public final JSONObject zzb(String str, String str2) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzdE)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzd) {
            zzf();
        }
        Map map = (Map) this.zza.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String strZza = zzdqi.zza(this.zze, str, str2);
        if (strZza != null) {
            return (JSONObject) map.get(strZza);
        }
        return null;
    }

    public final void zzc() {
        za2 za2VarZzi = hd2.B.g.zzi();
        ((ib2) za2VarZzi).c.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqd
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze();
            }
        });
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqe
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf();
            }
        });
    }

    public final /* synthetic */ void zze() {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
    }
}
