package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import defpackage.k92;
import defpackage.n42;
import defpackage.or1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzeya implements zzevo {
    private final JSONObject zza;

    public zzeya(Context context) {
        this.zza = zzbux.zzc(context, or1.a());
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 46;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return ((Boolean) n42.d.c.zza(zzbbw.zzkX)).booleanValue() ? zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzexy
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
            }
        }) : zzgcj.zzh(new zzevn() { // from class: com.google.android.gms.internal.ads.zzexz
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                this.zza.zzc((JSONObject) obj);
            }
        });
    }

    public final /* synthetic */ void zzc(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zza);
        } catch (JSONException unused) {
            k92.a("Failed putting version constants.");
        }
    }
}
