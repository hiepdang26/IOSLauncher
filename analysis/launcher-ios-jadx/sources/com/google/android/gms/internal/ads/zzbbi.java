package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbbi extends zzbbn {
    public zzbbi(int i, String str, Integer num, Integer num2) {
        super(1, str, num, num2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(zzn(), ((Integer) zzm()).intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzn())) ? Integer.valueOf(bundle.getInt("com.google.android.gms.ads.flag.".concat(zzn()))) : (Integer) zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(zzn(), ((Integer) zzm()).intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putInt(zzn(), ((Integer) obj).intValue());
    }
}
