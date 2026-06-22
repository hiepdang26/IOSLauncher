package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.text.TextUtils;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k31;
import defpackage.n42;
import defpackage.s61;
import defpackage.uo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdlr {
    private final zzgcu zza;
    private final zzdme zzb;
    private final zzdmj zzc;

    public zzdlr(zzgcu zzgcuVar, zzdme zzdmeVar, zzdmj zzdmjVar) {
        this.zza = zzgcuVar;
        this.zzb = zzdmeVar;
        this.zzc = zzdmjVar;
    }

    public final do0 zza(final zzfex zzfexVar, final zzfel zzfelVar, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        do0 do0VarZzn;
        final do0 do0VarZzb = this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdlp
            @Override // java.util.concurrent.Callable
            public final Object call() throws zzeir {
                zzdjb zzdjbVar = new zzdjb();
                JSONObject jSONObject2 = jSONObject;
                zzdjbVar.zzaa(jSONObject2.optInt("template_id", -1));
                zzdjbVar.zzK(jSONObject2.optString("custom_template_id"));
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("omid_settings");
                String strOptString = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("omid_partner_name") : null;
                zzfex zzfexVar2 = zzfexVar;
                zzdjbVar.zzV(strOptString);
                zzffg zzffgVar = zzfexVar2.zza.zza;
                if (!zzffgVar.zzg.contains(Integer.toString(zzdjbVar.zzc()))) {
                    throw new zzeir(1, k31.k(zzdjbVar.zzc(), "Invalid template ID: "));
                }
                if (zzdjbVar.zzc() == 3) {
                    if (zzdjbVar.zzA() == null) {
                        throw new zzeir(1, "No custom template id for custom template ad response.");
                    }
                    if (!zzffgVar.zzh.contains(zzdjbVar.zzA())) {
                        throw new zzeir(1, "Unexpected custom template id in the response.");
                    }
                }
                zzfel zzfelVar2 = zzfelVar;
                zzdjbVar.zzY(jSONObject2.optDouble("rating", -1.0d));
                String strOptString2 = jSONObject2.optString("headline", null);
                if (zzfelVar2.zzM) {
                    hd2 hd2Var = hd2.B;
                    cd2 cd2Var = hd2Var.c;
                    Resources resourcesZze = hd2Var.g.zze();
                    strOptString2 = uo.i(resourcesZze != null ? resourcesZze.getString(s61.s7) : "Test Ad", " : ", strOptString2);
                }
                zzdjbVar.zzZ("headline", strOptString2);
                zzdjbVar.zzZ("body", jSONObject2.optString("body", null));
                zzdjbVar.zzZ("call_to_action", jSONObject2.optString("call_to_action", null));
                zzdjbVar.zzZ("store", jSONObject2.optString("store", null));
                zzdjbVar.zzZ("price", jSONObject2.optString("price", null));
                zzdjbVar.zzZ("advertiser", jSONObject2.optString("advertiser", null));
                return zzdjbVar;
            }
        });
        final do0 do0VarZzf = this.zzb.zzf(jSONObject, "images");
        zzfeo zzfeoVar = zzfexVar.zzb.zzb;
        zzdme zzdmeVar = this.zzb;
        final do0 do0VarZzg = zzdmeVar.zzg(jSONObject, "images", zzfelVar, zzfeoVar);
        final do0 do0VarZze = zzdmeVar.zze(jSONObject, "secondary_image");
        final do0 do0VarZze2 = zzdmeVar.zze(jSONObject, "app_icon");
        final do0 do0VarZzd = zzdmeVar.zzd(jSONObject, "attribution");
        final do0 do0VarZzh = this.zzb.zzh(jSONObject, zzfelVar, zzfexVar.zzb.zzb);
        final do0 do0VarZza = this.zzc.zza(jSONObject, "custom_assets");
        if (jSONObject.optBoolean("enable_omid") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings")) != null) {
            final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
            if (TextUtils.isEmpty(strOptString)) {
                do0VarZzn = zzgcj.zzh(null);
            } else {
                final zzdme zzdmeVar2 = this.zzb;
                do0VarZzn = zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdlt
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final do0 zza(Object obj) {
                        return zzdmeVar2.zzc(strOptString, obj);
                    }
                }, zzbzo.zze);
            }
        } else {
            do0VarZzn = zzgcj.zzh(null);
        }
        final do0 do0Var = do0VarZzn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(do0VarZzb);
        arrayList.add(do0VarZzf);
        arrayList.add(do0VarZzg);
        arrayList.add(do0VarZze);
        arrayList.add(do0VarZze2);
        arrayList.add(do0VarZzd);
        arrayList.add(do0VarZzh);
        arrayList.add(do0VarZza);
        if (!((Boolean) n42.d.c.zza(zzbbw.zzeH)).booleanValue()) {
            arrayList.add(do0Var);
        }
        return zzgcj.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdlq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdjb zzdjbVar = (zzdjb) do0VarZzb.get();
                zzdjbVar.zzP((List) do0VarZzf.get());
                zzdjbVar.zzM((zzbfd) do0VarZze2.get());
                zzdjbVar.zzQ((zzbfd) do0VarZze.get());
                zzdjbVar.zzJ((zzbew) do0VarZzd.get());
                JSONObject jSONObject2 = jSONObject;
                zzdjbVar.zzS(zzdme.zzj(jSONObject2));
                zzdjbVar.zzL(zzdme.zzi(jSONObject2));
                zzcej zzcejVar = (zzcej) do0VarZzh.get();
                if (zzcejVar != null) {
                    zzdjbVar.zzad(zzcejVar);
                    zzdjbVar.zzac(zzcejVar.zzF());
                    zzdjbVar.zzab(zzcejVar.zzq());
                }
                zzcej zzcejVar2 = (zzcej) do0VarZzg.get();
                if (zzcejVar2 != null) {
                    zzdjbVar.zzO(zzcejVar2);
                    zzdjbVar.zzae(zzcejVar2.zzF());
                }
                do0 do0Var2 = do0Var;
                if (((Boolean) n42.d.c.zza(zzbbw.zzeH)).booleanValue()) {
                    zzdjbVar.zzU(do0Var2);
                    zzdjbVar.zzX(new zzbzt());
                } else {
                    zzcej zzcejVar3 = (zzcej) do0Var2.get();
                    if (zzcejVar3 != null) {
                        zzdjbVar.zzT(zzcejVar3);
                    }
                }
                for (zzdmi zzdmiVar : (List) do0VarZza.get()) {
                    if (zzdmiVar.zza != 1) {
                        zzdjbVar.zzN(zzdmiVar.zzb, zzdmiVar.zzd);
                    } else {
                        zzdjbVar.zzZ(zzdmiVar.zzb, zzdmiVar.zzc);
                    }
                }
                return zzdjbVar;
            }
        }, this.zza);
    }
}
