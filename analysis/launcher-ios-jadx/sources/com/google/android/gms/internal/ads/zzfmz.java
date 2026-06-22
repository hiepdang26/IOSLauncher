package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzfmz {
    private final String zza;
    private zzfob zzb;
    private long zzc;
    private int zzd;

    public zzfmz(String str) {
        zzb();
        this.zza = str;
        this.zzb = new zzfob(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebView zza() {
        return (WebView) this.zzb.get();
    }

    public final void zzb() {
        this.zzc = System.nanoTime();
        this.zzd = 1;
    }

    public void zzc() {
        this.zzb.clear();
    }

    public final void zzd(String str, long j) {
        if (j < this.zzc || this.zzd == 3) {
            return;
        }
        this.zzd = 3;
        zzfms.zza().zzg(zza(), this.zza, str);
    }

    public final void zze() {
        zzfms.zza().zzc(zza(), this.zza);
    }

    public final void zzf(zzflr zzflrVar) {
        zzfms.zza().zzd(zza(), this.zza, zzflrVar.zzb());
    }

    public final void zzg(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zzfnf.zze(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        zzfms.zza().zzf(zza(), jSONObject);
    }

    public final void zzh(String str, long j) {
        if (j >= this.zzc) {
            this.zzd = 2;
            zzfms.zza().zzg(zza(), this.zza, str);
        }
    }

    public void zzi(zzflu zzfluVar, zzfls zzflsVar) {
        zzj(zzfluVar, zzflsVar, null);
    }

    public final void zzj(zzflu zzfluVar, zzfls zzflsVar, JSONObject jSONObject) {
        String strZzh = zzfluVar.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfnf.zze(jSONObject2, "environment", "app");
        zzfnf.zze(jSONObject2, "adSessionType", zzflsVar.zzd());
        JSONObject jSONObject3 = new JSONObject();
        zzfnf.zze(jSONObject3, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        zzfnf.zze(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzfnf.zze(jSONObject3, "os", "Android");
        zzfnf.zze(jSONObject2, "deviceInfo", jSONObject3);
        zzfnf.zze(jSONObject2, "deviceCategory", zzfne.zza().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzfnf.zze(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfnf.zze(jSONObject4, "partnerName", zzflsVar.zze().zzb());
        zzfnf.zze(jSONObject4, "partnerVersion", zzflsVar.zze().zzc());
        zzfnf.zze(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzfnf.zze(jSONObject5, "libraryVersion", "1.4.10-google_20240110");
        zzfnf.zze(jSONObject5, "appId", zzfmq.zzb().zza().getApplicationContext().getPackageName());
        zzfnf.zze(jSONObject2, "app", jSONObject5);
        if (zzflsVar.zzf() != null) {
            zzfnf.zze(jSONObject2, "contentUrl", zzflsVar.zzf());
        }
        if (zzflsVar.zzg() != null) {
            zzfnf.zze(jSONObject2, "customReferenceData", zzflsVar.zzg());
        }
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzflsVar.zzh().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzfms.zza().zzi(zza(), strZzh, jSONObject2, jSONObject6, jSONObject);
    }

    public final void zzk(boolean z) {
        if (this.zzb.get() != 0) {
            zzfms.zza().zzh(zza(), this.zza, true != z ? "backgrounded" : "foregrounded");
        }
    }

    public final void zzl(float f) {
        zzfms.zza().zze(zza(), this.zza, f);
    }

    public final void zzm(WebView webView) {
        this.zzb = new zzfob(webView);
    }

    public void zzn() {
    }
}
