package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.k92;
import defpackage.n42;
import defpackage.za2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzelg {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private final Map zze = new HashMap();
    private final Executor zzf;
    private JSONObject zzg;

    public zzelg(Executor executor) {
        this.zzf = executor;
    }

    private final synchronized zzfxu zzh(String str) {
        HashMap map;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(((ib2) hd2.B.g.zzi()).x().zzc())) {
                zzbbn zzbbnVar = zzbbw.zzcP;
                n42 n42Var = n42.d;
                boolean zMatches = Pattern.matches((String) n42Var.c.zza(zzbbnVar), str);
                boolean zMatches2 = Pattern.matches((String) n42Var.c.zza(zzbbw.zzcQ), str);
                if (zMatches) {
                    map = new HashMap(this.zze);
                } else if (zMatches2) {
                    map = new HashMap(this.zzd);
                }
                return zzfxu.zzc(map);
            }
            return zzfxu.zzd();
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized List zzi(JSONObject jSONObject, String str) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            if (jSONObject != null) {
                Bundle bundleZzo = zzo(jSONObject.optJSONObject("data"));
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rtb_adapters");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i, "");
                        if (!TextUtils.isEmpty(strOptString)) {
                            arrayList2.add(strOptString);
                        }
                    }
                    int size = arrayList2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str2 = (String) arrayList2.get(i2);
                        zzg(str2);
                        if (((zzeli) this.zza.get(str2)) != null) {
                            arrayList.add(new zzeli(str2, str, bundleZzo));
                        }
                    }
                }
            }
        } finally {
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzj() {
        this.zzb.clear();
        this.zza.clear();
        this.zze.clear();
        this.zzd.clear();
        zzm();
        zzn();
        zzk();
    }

    private final synchronized void zzk() {
        JSONObject jSONObjectZzf;
        try {
            if (!((Boolean) zzbdy.zzb.zze()).booleanValue()) {
                if (((Boolean) n42.d.c.zza(zzbbw.zzbC)).booleanValue() && (jSONObjectZzf = ((ib2) hd2.B.g.zzi()).x().zzf()) != null) {
                    try {
                        JSONArray jSONArray = jSONObjectZzf.getJSONArray("adapter_settings");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String strOptString = jSONObject.optString("adapter_class_name");
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("permission_set");
                            if (!TextUtils.isEmpty(strOptString)) {
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                                    boolean zOptBoolean = jSONObject2.optBoolean("enable_rendering", false);
                                    boolean zOptBoolean2 = jSONObject2.optBoolean("collect_secure_signals", false);
                                    boolean zOptBoolean3 = jSONObject2.optBoolean("collect_secure_signals_on_full_app", false);
                                    String strOptString2 = jSONObject2.optString("platform");
                                    zzelk zzelkVar = new zzelk(strOptString, zOptBoolean2, zOptBoolean, zOptBoolean3, new Bundle());
                                    if (strOptString2.equals("ADMOB")) {
                                        this.zzd.put(strOptString, zzelkVar);
                                    } else if (strOptString2.equals("AD_MANAGER")) {
                                        this.zze.put(strOptString, zzelkVar);
                                    }
                                }
                            }
                        }
                    } catch (JSONException unused) {
                        k92.b();
                    }
                }
            }
        } finally {
        }
    }

    private final synchronized void zzl(String str, String str2, List list) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            Map map = (Map) this.zzc.get(str);
            if (map == null) {
                map = new HashMap();
            }
            this.zzc.put(str, map);
            List arrayList = (List) map.get(str2);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.addAll(list);
            map.put(str2, arrayList);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzm() {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObjectZzf = ((ib2) hd2.B.g.zzi()).x().zzf();
            if (jSONObjectZzf != null) {
                try {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectZzf.optJSONArray("ad_unit_id_settings");
                    this.zzg = jSONObjectZzf.optJSONObject("ad_unit_patterns");
                    if (jSONArrayOptJSONArray2 != null) {
                        for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                            JSONObject jSONObject = jSONArrayOptJSONArray2.getJSONObject(i);
                            String lowerCase = ((Boolean) n42.d.c.zza(zzbbw.zzjW)).booleanValue() ? jSONObject.optString("ad_unit_id", "").toLowerCase(Locale.ROOT) : jSONObject.optString("ad_unit_id", "");
                            String strOptString = jSONObject.optString("format", "");
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mediation_config");
                            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ad_networks")) != null) {
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                    arrayList.addAll(zzi(jSONArrayOptJSONArray.getJSONObject(i2), strOptString));
                                }
                            }
                            zzl(strOptString, lowerCase, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                    k92.b();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzn() {
        JSONObject jSONObjectZzf;
        if (!((Boolean) zzbdy.zzf.zze()).booleanValue()) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzbB)).booleanValue() && (jSONObjectZzf = ((ib2) hd2.B.g.zzi()).x().zzf()) != null) {
                try {
                    JSONArray jSONArray = jSONObjectZzf.getJSONArray("signal_adapters");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        Bundle bundleZzo = zzo(jSONObject.optJSONObject("data"));
                        String strOptString = jSONObject.optString("adapter_class_name");
                        boolean zOptBoolean = jSONObject.optBoolean("render", false);
                        boolean zOptBoolean2 = jSONObject.optBoolean("collect_signals", false);
                        if (!TextUtils.isEmpty(strOptString)) {
                            this.zzb.put(strOptString, new zzelk(strOptString, zOptBoolean2, zOptBoolean, true, bundleZzo));
                        }
                    }
                } catch (JSONException unused) {
                    k92.b();
                }
            }
        }
    }

    private static final Bundle zzo(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle.putString(next, jSONObject.optString(next, ""));
            }
        }
        return bundle;
    }

    public final synchronized Map zza(String str, String str2) {
        HashMap map;
        try {
            Map mapZzb = zzb(str, str2);
            zzfxu zzfxuVarZzh = zzh(str2);
            map = new HashMap();
            for (Map.Entry entry : ((zzfxu) mapZzb).entrySet()) {
                String str3 = (String) entry.getKey();
                if (zzfxuVarZzh.containsKey(str3)) {
                    zzelk zzelkVar = (zzelk) zzfxuVarZzh.get(str3);
                    List list = (List) entry.getValue();
                    map.put(str3, new zzelk(str3, zzelkVar.zzb, zzelkVar.zzc, zzelkVar.zzd, (list == null || list.isEmpty()) ? new Bundle() : (Bundle) list.get(0)));
                }
            }
            zzfzx zzfzxVarZze = zzfxuVarZzh.entrySet().iterator();
            while (zzfzxVarZze.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zzfzxVarZze.next();
                String str4 = (String) entry2.getKey();
                if (!map.containsKey(str4) && ((zzelk) entry2.getValue()).zzd) {
                    map.put(str4, (zzelk) entry2.getValue());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return map;
    }

    public final synchronized Map zzb(String str, String str2) {
        Map map;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(((ib2) hd2.B.g.zzi()).x().zzc()) && (map = (Map) this.zzc.get(str)) != null) {
                List<zzeli> list = (List) map.get(str2);
                if (list == null) {
                    String strZza = zzdqi.zza(this.zzg, str2, str);
                    if (((Boolean) n42.d.c.zza(zzbbw.zzjW)).booleanValue()) {
                        strZza = strZza.toLowerCase(Locale.ROOT);
                    }
                    list = (List) map.get(strZza);
                }
                if (list != null) {
                    HashMap map2 = new HashMap();
                    for (zzeli zzeliVar : list) {
                        String str3 = zzeliVar.zza;
                        if (!map2.containsKey(str3)) {
                            map2.put(str3, new ArrayList());
                        }
                        ((List) map2.get(str3)).add(zzeliVar.zzb);
                    }
                    return zzfxu.zzc(map2);
                }
            }
            return zzfxu.zzd();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Map zzc() {
        if (TextUtils.isEmpty(((ib2) hd2.B.g.zzi()).x().zzc())) {
            return zzfxu.zzd();
        }
        return zzfxu.zzc(this.zzb);
    }

    public final void zze() {
        za2 za2VarZzi = hd2.B.g.zzi();
        ((ib2) za2VarZzi).c.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzelf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf();
            }
        });
        this.zzf.execute(new zzele(this));
    }

    public final /* synthetic */ void zzf() {
        this.zzf.execute(new zzele(this));
    }

    public final synchronized void zzg(String str) {
        if (!TextUtils.isEmpty(str) && !this.zza.containsKey(str)) {
            this.zza.put(str, new zzeli(str, "", new Bundle()));
        }
    }
}
