package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import defpackage.do0;
import defpackage.dy;
import defpackage.hd2;
import defpackage.n42;
import defpackage.or1;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbux extends zzbuv {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbne zzd;
    private final or1 zze;

    public zzbux(Context context, zzbne zzbneVar, or1 or1Var) {
        this.zzb = context.getApplicationContext();
        this.zze = or1Var;
        this.zzd = zzbneVar;
    }

    public static JSONObject zzc(Context context, or1 or1Var) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) zzbds.zzb.zze()).booleanValue()) {
                jSONObject.put("package_name", context.getPackageName());
            }
            jSONObject.put("js", or1Var.g);
            jSONObject.put("mf", zzbds.zzc.zze());
            jSONObject.put("cl", "661295874");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 12451000);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", dy.d(context, ModuleDescriptor.MODULE_ID, false));
            jSONObject.put("container_version", 12451000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzbuv
    public final do0 zza() {
        synchronized (this.zza) {
            try {
                if (this.zzc == null) {
                    this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
                }
            } finally {
            }
        }
        SharedPreferences sharedPreferences = this.zzc;
        long j = sharedPreferences != null ? sharedPreferences.getLong("js_last_update", 0L) : 0L;
        hd2.B.j.getClass();
        if (System.currentTimeMillis() - j < ((Long) zzbds.zzd.zze()).longValue()) {
            return zzgcj.zzh(null);
        }
        return zzgcj.zzm(this.zzd.zzb(zzc(this.zzb, this.zze)), new zzful() { // from class: com.google.android.gms.internal.ads.zzbuw
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                this.zza.zzb((JSONObject) obj);
                return null;
            }
        }, zzbzo.zzf);
    }

    public final Void zzb(JSONObject jSONObject) {
        zzbbn zzbbnVar = zzbbw.zza;
        n42 n42Var = n42.d;
        zzbbp zzbbpVar = n42Var.b;
        SharedPreferences sharedPreferencesZza = zzbbp.zza(this.zzb);
        if (sharedPreferencesZza == null) {
            return null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesZza.edit();
        int i = zzbdi.zza;
        n42Var.a.zze(editorEdit, 1, jSONObject);
        editorEdit.commit();
        SharedPreferences sharedPreferences = this.zzc;
        if (sharedPreferences == null) {
            return null;
        }
        SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
        hd2.B.j.getClass();
        editorEdit2.putLong("js_last_update", System.currentTimeMillis()).apply();
        return null;
    }
}
