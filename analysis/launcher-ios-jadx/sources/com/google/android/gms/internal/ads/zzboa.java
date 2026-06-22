package com.google.android.gms.internal.ads;

import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzboa implements zzgbq {
    private final String zza = "google.afma.activeView.handleUpdate";
    private final do0 zzb;

    public zzboa(do0 do0Var, String str, zzbnh zzbnhVar, zzbng zzbngVar) {
        this.zzb = do0Var;
    }

    @Override // com.google.android.gms.internal.ads.zzgbq
    public final do0 zza(Object obj) {
        return zzb(obj);
    }

    public final do0 zzb(final Object obj) {
        return zzgcj.zzn(this.zzb, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzbny
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj2) {
                return this.zza.zzc(obj, (zzbnb) obj2);
            }
        }, zzbzo.zzf);
    }

    public final do0 zzc(Object obj, zzbnb zzbnbVar) throws JSONException {
        zzbzt zzbztVar = new zzbzt();
        cd2 cd2Var = hd2.B.c;
        String string = UUID.randomUUID().toString();
        zzbiw.zzo.zzc(string, new zzbnz(this, zzbztVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", string);
        jSONObject.put("args", (JSONObject) obj);
        zzbnbVar.zzl(this.zza, jSONObject);
        return zzbztVar;
    }
}
