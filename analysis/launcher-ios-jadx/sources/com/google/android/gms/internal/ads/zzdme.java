package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.a22;
import defpackage.do0;
import defpackage.h42;
import defpackage.hd2;
import defpackage.hs0;
import defpackage.k92;
import defpackage.n42;
import defpackage.or1;
import defpackage.rc2;
import defpackage.u2;
import defpackage.v92;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdme {
    private final Context zza;
    private final zzdln zzb;
    private final zzauo zzc;
    private final or1 zzd;
    private final a22 zze;
    private final zzbav zzf;
    private final Executor zzg;
    private final zzbes zzh;
    private final zzdmw zzi;
    private final zzdpl zzj;
    private final ScheduledExecutorService zzk;
    private final zzdog zzl;
    private final zzdsk zzm;
    private final zzfll zzn;
    private final zzedh zzo;
    private final zzeds zzp;
    private final zzffk zzq;

    public zzdme(Context context, zzdln zzdlnVar, zzauo zzauoVar, or1 or1Var, a22 a22Var, zzbav zzbavVar, Executor executor, zzffg zzffgVar, zzdmw zzdmwVar, zzdpl zzdplVar, ScheduledExecutorService scheduledExecutorService, zzdsk zzdskVar, zzfll zzfllVar, zzedh zzedhVar, zzdog zzdogVar, zzeds zzedsVar, zzffk zzffkVar) {
        this.zza = context;
        this.zzb = zzdlnVar;
        this.zzc = zzauoVar;
        this.zzd = or1Var;
        this.zze = a22Var;
        this.zzf = zzbavVar;
        this.zzg = executor;
        this.zzh = zzffgVar.zzi;
        this.zzi = zzdmwVar;
        this.zzj = zzdplVar;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdskVar;
        this.zzn = zzfllVar;
        this.zzo = zzedhVar;
        this.zzl = zzdogVar;
        this.zzp = zzedsVar;
        this.zzq = zzffkVar;
    }

    public static final v92 zzi(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(jSONObjectOptJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject == null) {
            return zzfxr.zzm();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reasons");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzfxr.zzm();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            v92 v92VarZzr = zzr(jSONArrayOptJSONArray.optJSONObject(i));
            if (v92VarZzr != null) {
                arrayList.add(v92VarZzr);
            }
        }
        return zzfxr.zzk(arrayList);
    }

    private final rc2 zzk(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return rc2.b();
            }
            i = 0;
        }
        return new rc2(this.zza, new u2(i, i2));
    }

    private static do0 zzl(do0 do0Var, Object obj) {
        final Object obj2 = null;
        return zzgcj.zzf(do0Var, Exception.class, new zzgbq(obj2) { // from class: com.google.android.gms.internal.ads.zzdmc
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj3) {
                k92.b();
                return zzgcj.zzh(null);
            }
        }, zzbzo.zzf);
    }

    private static do0 zzm(boolean z, final do0 do0Var, Object obj) {
        return z ? zzgcj.zzn(do0Var, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdmd
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj2) {
                return obj2 != null ? do0Var : zzgcj.zzg(new zzeir(1, "Retrieve required value in native ad response failed."));
            }
        }, zzbzo.zzf) : zzl(do0Var, null);
    }

    private final do0 zzn(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzgcj.zzh(null);
        }
        final String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString)) {
            return zzgcj.zzh(null);
        }
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        final int iOptInt = jSONObject.optInt("width", -1);
        final int iOptInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzgcj.zzh(new zzbeq(null, Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzgcj.zzm(this.zzb.zzb(strOptString, dOptDouble, zOptBoolean), new zzful() { // from class: com.google.android.gms.internal.ads.zzdlu
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return new zzbeq(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2);
            }
        }, this.zzg), null);
    }

    private final do0 zzo(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgcj.zzh(Collections.EMPTY_LIST);
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i), z));
        }
        return zzgcj.zzm(zzgcj.zzd(arrayList), new zzful() { // from class: com.google.android.gms.internal.ads.zzdlz
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzbeq zzbeqVar : (List) obj) {
                    if (zzbeqVar != null) {
                        arrayList2.add(zzbeqVar);
                    }
                }
                return arrayList2;
            }
        }, this.zzg);
    }

    private final do0 zzp(JSONObject jSONObject, zzfel zzfelVar, zzfeo zzfeoVar) {
        final do0 do0VarZzb = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzfelVar, zzfeoVar, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzgcj.zzn(do0VarZzb, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdlv
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) throws zzeir {
                zzcej zzcejVar = (zzcej) obj;
                if (zzcejVar == null || zzcejVar.zzq() == null) {
                    throw new zzeir(1, "Retrieve video view in html5 ad response failed.");
                }
                return do0VarZzb;
            }
        }, zzbzo.zzf);
    }

    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static final v92 zzr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new v92(strOptString, strOptString2);
    }

    public final /* synthetic */ zzben zza(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String strOptString = jSONObject.optString("text");
        Integer numZzq = zzq(jSONObject, "bg_color");
        Integer numZzq2 = zzq(jSONObject, "text_color");
        int iOptInt = jSONObject.optInt("text_size", -1);
        boolean zOptBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int iOptInt2 = jSONObject.optInt("animation_ms", zzbbc.zzq.zzf);
        return new zzben(strOptString, list, numZzq, numZzq2, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, jSONObject.optInt("presentation_ms", 4000) + iOptInt2, this.zzh.zze, zOptBoolean);
    }

    public final /* synthetic */ do0 zzb(rc2 rc2Var, zzfel zzfelVar, zzfeo zzfeoVar, String str, String str2, Object obj) {
        zzcej zzcejVarZza = this.zzj.zza(rc2Var, zzfelVar, zzfeoVar);
        final zzbzs zzbzsVarZza = zzbzs.zza((Object) zzcejVarZza);
        zzdod zzdodVarZzb = this.zzl.zzb();
        zzcejVarZza.zzN().zzR(zzdodVarZzb, zzdodVarZzb, zzdodVarZzb, zzdodVarZzb, zzdodVarZzb, false, null, new h42(this.zza, null), null, null, this.zzo, this.zzn, this.zzm, null, zzdodVarZzb, null, null, null, null);
        zzcejVarZza.zzag("/getNativeAdViewSignals", zzbiw.zzs);
        zzcejVarZza.zzag("/getNativeClickMeta", zzbiw.zzt);
        zzcejVarZza.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdly
            @Override // com.google.android.gms.internal.ads.zzcfz
            public final void zza(boolean z, int i, String str3, String str4) {
                zzbzs zzbzsVar = zzbzsVarZza;
                if (z) {
                    zzbzsVar.zzb();
                    return;
                }
                zzbzsVar.zzd(new zzeir(1, "Image Web View failed to load. Error code: " + i + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zzcejVarZza.zzae(str, str2, null);
        return zzbzsVarZza;
    }

    public final do0 zzc(String str, Object obj) throws zzcev {
        zzcew zzcewVar = hd2.B.d;
        zzcej zzcejVarZza = zzcew.zza(this.zza, zzcgd.zza(), "native-omid", false, false, this.zzc, null, this.zzd, null, null, this.zze, this.zzf, null, null, this.zzp, this.zzq);
        final zzbzs zzbzsVarZza = zzbzs.zza((Object) zzcejVarZza);
        zzcejVarZza.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdma
            @Override // com.google.android.gms.internal.ads.zzcfz
            public final void zza(boolean z, int i, String str2, String str3) {
                zzbzsVarZza.zzb();
            }
        });
        if (((Boolean) n42.d.c.zza(zzbbw.zzeE)).booleanValue()) {
            zzcejVarZza.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
            return zzbzsVarZza;
        }
        zzcejVarZza.loadData(str, "text/html", "UTF-8");
        return zzbzsVarZza;
    }

    public final do0 zzd(JSONObject jSONObject, String str) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObjectOptJSONObject == null) {
            return zzgcj.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("images");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
        if (jSONArrayOptJSONArray == null && jSONObjectOptJSONObject2 != null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONArrayOptJSONArray.put(jSONObjectOptJSONObject2);
        }
        return zzm(jSONObjectOptJSONObject.optBoolean("require"), zzgcj.zzm(zzo(jSONArrayOptJSONArray, false, true), new zzful() { // from class: com.google.android.gms.internal.ads.zzdmb
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return this.zza.zza(jSONObjectOptJSONObject, (List) obj);
            }
        }, this.zzg), null);
    }

    public final do0 zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final do0 zzf(JSONObject jSONObject, String str) {
        zzbes zzbesVar = this.zzh;
        return zzo(jSONObject.optJSONArray("images"), zzbesVar.zzb, zzbesVar.zzd);
    }

    public final do0 zzg(JSONObject jSONObject, String str, final zzfel zzfelVar, final zzfeo zzfeoVar) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzjf)).booleanValue()) {
            return zzgcj.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzgcj.zzh(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return zzgcj.zzh(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("base_url");
        final String strOptString2 = jSONObjectOptJSONObject.optString("html");
        final rc2 rc2VarZzk = zzk(jSONObjectOptJSONObject.optInt("width", 0), jSONObjectOptJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(strOptString2)) {
            return zzgcj.zzh(null);
        }
        final do0 do0VarZzn = zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdlw
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzb(rc2VarZzk, zzfelVar, zzfeoVar, strOptString, strOptString2, obj);
            }
        }, zzbzo.zze);
        return zzgcj.zzn(do0VarZzn, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdlx
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) throws zzeir {
                if (((zzcej) obj) != null) {
                    return do0VarZzn;
                }
                throw new zzeir(1, "Retrieve Web View from image ad response failed.");
            }
        }, zzbzo.zzf);
    }

    public final do0 zzh(JSONObject jSONObject, zzfel zzfelVar, zzfeo zzfeoVar) {
        do0 do0VarZza;
        String[] strArr = {"html_containers", "instream"};
        JSONObject jSONObjectC = hs0.C(jSONObject, strArr);
        JSONObject jSONObjectOptJSONObject = jSONObjectC == null ? null : jSONObjectC.optJSONObject(strArr[1]);
        if (jSONObjectOptJSONObject != null) {
            return zzp(jSONObjectOptJSONObject, zzfelVar, zzfeoVar);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject2 == null) {
            return zzgcj.zzh(null);
        }
        String strOptString = jSONObjectOptJSONObject2.optString("vast_xml");
        zzbbn zzbbnVar = zzbbw.zzje;
        boolean z = ((Boolean) n42.d.c.zza(zzbbnVar)).booleanValue() && jSONObjectOptJSONObject2.has("html");
        if (!TextUtils.isEmpty(strOptString)) {
            if (!z) {
                do0VarZza = this.zzi.zza(jSONObjectOptJSONObject2);
            }
            return zzl(zzgcj.zzo(do0VarZza, ((Integer) r4.c.zza(zzbbw.zzdt)).intValue(), TimeUnit.SECONDS, this.zzk), null);
        }
        if (!z) {
            k92.h("Required field 'vast_xml' or 'html' is missing");
            return zzgcj.zzh(null);
        }
        do0VarZza = zzp(jSONObjectOptJSONObject2, zzfelVar, zzfeoVar);
        return zzl(zzgcj.zzo(do0VarZza, ((Integer) r4.c.zza(zzbbw.zzdt)).intValue(), TimeUnit.SECONDS, this.zzk), null);
    }
}
