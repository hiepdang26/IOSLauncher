package com.google.android.gms.internal.ads;

import defpackage.do0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdmj {
    private final Executor zza;
    private final zzdme zzb;

    public zzdmj(Executor executor, zzdme zzdmeVar) {
        this.zza = executor;
        this.zzb = zzdmeVar;
    }

    public final do0 zza(JSONObject jSONObject, String str) {
        do0 do0VarZzh;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("custom_assets");
        if (jSONArrayOptJSONArray == null) {
            return zzgcj.zzh(Collections.EMPTY_LIST);
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                do0VarZzh = zzgcj.zzh(null);
            } else {
                final String strOptString = jSONObjectOptJSONObject.optString("name");
                if (strOptString == null) {
                    do0VarZzh = zzgcj.zzh(null);
                } else {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    do0VarZzh = "string".equals(strOptString2) ? zzgcj.zzh(new zzdmi(strOptString, jSONObjectOptJSONObject.optString("string_value"))) : "image".equals(strOptString2) ? zzgcj.zzm(this.zzb.zze(jSONObjectOptJSONObject, "image_value"), new zzful() { // from class: com.google.android.gms.internal.ads.zzdmg
                        @Override // com.google.android.gms.internal.ads.zzful
                        public final Object apply(Object obj) {
                            return new zzdmi(strOptString, (zzbeq) obj);
                        }
                    }, this.zza) : zzgcj.zzh(null);
                }
            }
            arrayList.add(do0VarZzh);
        }
        return zzgcj.zzm(zzgcj.zzd(arrayList), new zzful() { // from class: com.google.android.gms.internal.ads.zzdmh
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzdmi zzdmiVar : (List) obj) {
                    if (zzdmiVar != null) {
                        arrayList2.add(zzdmiVar);
                    }
                }
                return arrayList2;
            }
        }, this.zza);
    }
}
