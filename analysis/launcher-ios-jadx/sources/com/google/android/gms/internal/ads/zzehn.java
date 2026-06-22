package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.n42;
import defpackage.os;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzehn implements zzehh {
    private final zzdhl zza;
    private final zzgcu zzb;
    private final zzdlr zzc;
    private final zzfgf zzd;
    private final zzdog zze;

    public zzehn(zzdhl zzdhlVar, zzgcu zzgcuVar, zzdlr zzdlrVar, zzfgf zzfgfVar, zzdog zzdogVar) {
        this.zza = zzdhlVar;
        this.zzb = zzgcuVar;
        this.zzc = zzdlrVar;
        this.zzd = zzfgfVar;
        this.zze = zzdogVar;
    }

    private final do0 zzg(final zzfex zzfexVar, final zzfel zzfelVar, final JSONObject jSONObject) {
        zzdlr zzdlrVar = this.zzc;
        final do0 do0VarZza = this.zzd.zza();
        final do0 do0VarZza2 = zzdlrVar.zza(zzfexVar, zzfelVar, jSONObject);
        return zzgcj.zzc(do0VarZza, do0VarZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzehi
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc(do0VarZza2, do0VarZza, zzfexVar, zzfelVar, jSONObject);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final do0 zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        return zzgcj.zzn(zzgcj.zzn(this.zzd.zza(), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzehk
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zze(zzfelVar, (zzdoa) obj);
            }
        }, this.zzb), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzehl
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzf(zzfexVar, zzfelVar, (JSONArray) obj);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        zzfeq zzfeqVar = zzfelVar.zzs;
        return (zzfeqVar == null || zzfeqVar.zzc == null) ? false : true;
    }

    public final /* synthetic */ zzdiw zzc(do0 do0Var, do0 do0Var2, zzfex zzfexVar, zzfel zzfelVar, JSONObject jSONObject) throws Throwable {
        zzdjb zzdjbVar = (zzdjb) do0Var.get();
        zzdoa zzdoaVar = (zzdoa) do0Var2.get();
        zzdjc zzdjcVarZzd = this.zza.zzd(new zzcsk(zzfexVar, zzfelVar, null), new zzdjn(zzdjbVar), new zzdia(jSONObject, zzdoaVar));
        zzdjcVarZzd.zzh().zzb();
        zzdjcVarZzd.zzi().zza(zzdoaVar);
        zzdjcVarZzd.zzg().zza(zzdjbVar.zzs());
        zzdjcVarZzd.zzl().zza(this.zze, zzdjbVar.zzq());
        return zzdjcVarZzd.zza();
    }

    public final /* synthetic */ do0 zzd(zzdoa zzdoaVar, JSONObject jSONObject) throws zzbnd {
        this.zzd.zzb(zzgcj.zzh(zzdoaVar));
        if (jSONObject.optBoolean("success")) {
            return zzgcj.zzh(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzbnd("process json failed");
    }

    public final do0 zze(zzfel zzfelVar, final zzdoa zzdoaVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) n42.d.c.zza(zzbbw.zzhN)).booleanValue() && os.k()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfelVar.zzs.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgcj.zzn(zzdoaVar.zzg("google.afma.nativeAds.preProcessJson", jSONObject2), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzehj
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzd(zzdoaVar, (JSONObject) obj);
            }
        }, this.zzb);
    }

    public final /* synthetic */ do0 zzf(zzfex zzfexVar, zzfel zzfelVar, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return zzgcj.zzg(new zzdwl(3));
        }
        if (zzfexVar.zza.zza.zzk <= 1) {
            return zzgcj.zzm(zzg(zzfexVar, zzfelVar, jSONArray.getJSONObject(0)), new zzful() { // from class: com.google.android.gms.internal.ads.zzehm
                @Override // com.google.android.gms.internal.ads.zzful
                public final Object apply(Object obj) {
                    return Collections.singletonList(zzgcj.zzh((zzdiw) obj));
                }
            }, this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zzc(Math.min(length, zzfexVar.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzfexVar.zza.zza.zzk);
        for (int i = 0; i < zzfexVar.zza.zza.zzk; i++) {
            if (i < length) {
                arrayList.add(zzg(zzfexVar, zzfelVar, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzgcj.zzg(new zzdwl(3)));
            }
        }
        return zzgcj.zzh(arrayList);
    }
}
