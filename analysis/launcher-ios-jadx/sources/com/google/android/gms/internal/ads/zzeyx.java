package com.google.android.gms.internal.ads;

import defpackage.do0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzeyx implements zzevo {
    @Override // com.google.android.gms.internal.ads.zzevo
    public final /* synthetic */ int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzeyy
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                try {
                    ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451000);
                } catch (JSONException unused) {
                }
            }
        });
    }
}
