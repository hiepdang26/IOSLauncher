package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbid implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzb;
        zzcej zzcejVar = (zzcej) obj;
        zzber zzberVarZzK = zzcejVar.zzK();
        if (zzberVarZzK == null || (jSONObjectZzb = zzberVarZzK.zzb()) == null) {
            zzcejVar.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcejVar.zze("nativeClickMetaReady", jSONObjectZzb);
        }
    }
}
