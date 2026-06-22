package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbic implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZza;
        zzcej zzcejVar = (zzcej) obj;
        zzber zzberVarZzK = zzcejVar.zzK();
        if (zzberVarZzK == null || (jSONObjectZza = zzberVarZzK.zza()) == null) {
            zzcejVar.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcejVar.zze("nativeAdViewSignalsReady", jSONObjectZza);
        }
    }
}
