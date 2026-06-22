package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.e3;
import defpackage.hs0;
import defpackage.k92;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzewp implements zzevn {
    private final e3 zza;
    private final String zzb;
    private final zzfry zzc;

    public zzewp(e3 e3Var, String str, zzfry zzfryVar) {
        this.zza = e3Var;
        this.zzb = str;
        this.zzc = zzfryVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        try {
            JSONObject jSONObjectX = hs0.x((JSONObject) obj, "pii");
            e3 e3Var = this.zza;
            if (e3Var == null || TextUtils.isEmpty(e3Var.a)) {
                String str = this.zzb;
                if (str != null) {
                    jSONObjectX.put("pdid", str);
                    jSONObjectX.put("pdidtype", "ssaid");
                    return;
                }
                return;
            }
            jSONObjectX.put("rdid", this.zza.a);
            jSONObjectX.put("is_lat", this.zza.b);
            jSONObjectX.put("idtype", "adid");
            zzfry zzfryVar = this.zzc;
            if (zzfryVar.zzc()) {
                jSONObjectX.put("paidv1_id_android_3p", zzfryVar.zzb());
                jSONObjectX.put("paidv1_creation_time_android_3p", this.zzc.zza());
            }
        } catch (JSONException unused) {
            k92.b();
        }
    }
}
