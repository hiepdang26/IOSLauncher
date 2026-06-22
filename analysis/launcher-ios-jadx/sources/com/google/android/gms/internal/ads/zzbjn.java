package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbjn implements zzbix {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("id");
        String str2 = (String) map.get("fail");
        String str3 = (String) map.get("fail_reason");
        String str4 = (String) map.get("fail_stack");
        String str5 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        String strConcat = TextUtils.isEmpty(str4) ? "" : "\n".concat(String.valueOf(str4));
        synchronized (this.zza) {
            try {
                zzbjm zzbjmVar = (zzbjm) this.zzb.remove(str);
                if (zzbjmVar == null) {
                    k92.h("Received result for unexpected method invocation: " + str);
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    zzbjmVar.zza(str3 + strConcat);
                    return;
                }
                if (str5 == null) {
                    zzbjmVar.zzb(null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (k92.b()) {
                        k92.a("Result GMSG: " + jSONObject.toString(2));
                    }
                    zzbjmVar.zzb(jSONObject);
                } catch (JSONException e) {
                    zzbjmVar.zza(e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final do0 zzb(zzbme zzbmeVar, String str, JSONObject jSONObject) {
        zzbzt zzbztVar = new zzbzt();
        cd2 cd2Var = hd2.B.c;
        String string = UUID.randomUUID().toString();
        zzc(string, new zzbjl(this, zzbztVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", string);
            jSONObject2.put("args", jSONObject);
            zzbmeVar.zzl(str, jSONObject2);
            return zzbztVar;
        } catch (Exception e) {
            zzbztVar.zzd(e);
            return zzbztVar;
        }
    }

    public final void zzc(String str, zzbjm zzbjmVar) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbjmVar);
        }
    }
}
