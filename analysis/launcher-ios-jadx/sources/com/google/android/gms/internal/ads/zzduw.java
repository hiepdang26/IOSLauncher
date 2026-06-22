package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import defpackage.ed2;
import defpackage.j92;
import defpackage.k92;
import defpackage.n42;
import defpackage.x32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzduw implements zzcwt, zzczo, zzcyi {
    private final zzdvi zza;
    private final String zzb;
    private final String zzc;
    private zzcwj zzf;
    private j92 zzg;
    private JSONObject zzk;
    private JSONObject zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private int zzd = 0;
    private zzduv zze = zzduv.AD_REQUESTED;

    public zzduw(zzdvi zzdviVar, zzffg zzffgVar, String str) {
        this.zza = zzdviVar;
        this.zzc = str;
        this.zzb = zzffgVar.zzf;
    }

    private static JSONObject zzh(j92 j92Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", j92Var.i);
        jSONObject.put("errorCode", j92Var.g);
        jSONObject.put("errorDescription", j92Var.h);
        j92 j92Var2 = j92Var.j;
        jSONObject.put("underlyingError", j92Var2 == null ? null : zzh(j92Var2));
        return jSONObject;
    }

    private final JSONObject zzi(zzcwj zzcwjVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("winningAdapterClassName", zzcwjVar.zzg());
        jSONObject.put("responseSecsSinceEpoch", zzcwjVar.zzc());
        jSONObject.put("responseId", zzcwjVar.zzi());
        zzbbn zzbbnVar = zzbbw.zzir;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            String strZzd = zzcwjVar.zzd();
            if (!TextUtils.isEmpty(strZzd)) {
                k92.d("Bidding data: ".concat(String.valueOf(strZzd)));
                jSONObject.put("biddingData", new JSONObject(strZzd));
            }
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            jSONObject.put("adRequestUrl", this.zzh);
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            jSONObject.put("postBody", this.zzi);
        }
        if (!TextUtils.isEmpty(this.zzj)) {
            jSONObject.put("adResponseBody", this.zzj);
        }
        Object obj = this.zzk;
        if (obj != null) {
            jSONObject.put("adResponseHeaders", obj);
        }
        Object obj2 = this.zzl;
        if (obj2 != null) {
            jSONObject.put("transactionExtras", obj2);
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zziu)).booleanValue()) {
            jSONObject.put("hasExceededMemoryLimit", this.zzo);
        }
        JSONArray jSONArray = new JSONArray();
        for (ed2 ed2Var : zzcwjVar.zzj()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("adapterClassName", ed2Var.g);
            jSONObject2.put("latencyMillis", ed2Var.h);
            if (((Boolean) n42.d.c.zza(zzbbw.zzis)).booleanValue()) {
                jSONObject2.put("credentials", x32.f.a.g(ed2Var.j));
            }
            j92 j92Var = ed2Var.i;
            jSONObject2.put("error", j92Var == null ? null : zzh(j92Var));
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("adNetworks", jSONArray);
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcyi
    public final void zza(zzcru zzcruVar) {
        if (this.zza.zzq()) {
            this.zzf = zzcruVar.zzm();
            this.zze = zzduv.AD_LOADED;
            if (((Boolean) n42.d.c.zza(zzbbw.zziy)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObjectZzi;
        IBinder iBinder;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", this.zze);
        jSONObject.put("format", zzfel.zza(this.zzd));
        if (((Boolean) n42.d.c.zza(zzbbw.zziy)).booleanValue()) {
            jSONObject.put("isOutOfContext", this.zzm);
            if (this.zzm) {
                jSONObject.put("shown", this.zzn);
            }
        }
        zzcwj zzcwjVar = this.zzf;
        if (zzcwjVar != null) {
            jSONObjectZzi = zzi(zzcwjVar);
        } else {
            j92 j92Var = this.zzg;
            JSONObject jSONObjectZzi2 = null;
            if (j92Var != null && (iBinder = j92Var.k) != null) {
                zzcwj zzcwjVar2 = (zzcwj) iBinder;
                jSONObjectZzi2 = zzi(zzcwjVar2);
                if (zzcwjVar2.zzj().isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zzh(this.zzg));
                    jSONObjectZzi2.put("errors", jSONArray);
                }
            }
            jSONObjectZzi = jSONObjectZzi2;
        }
        jSONObject.put("responseInfo", jSONObjectZzi);
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(j92 j92Var) {
        if (this.zza.zzq()) {
            this.zze = zzduv.AD_LOAD_FAILED;
            this.zzg = j92Var;
            if (((Boolean) n42.d.c.zza(zzbbw.zziy)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
        if (((Boolean) n42.d.c.zza(zzbbw.zziy)).booleanValue() || !this.zza.zzq()) {
            return;
        }
        this.zza.zzf(this.zzb, this);
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdo(zzfex zzfexVar) {
        if (this.zza.zzq()) {
            if (!zzfexVar.zzb.zza.isEmpty()) {
                this.zzd = ((zzfel) zzfexVar.zzb.zza.get(0)).zzb;
            }
            if (!TextUtils.isEmpty(zzfexVar.zzb.zzb.zzl)) {
                this.zzh = zzfexVar.zzb.zzb.zzl;
            }
            if (!TextUtils.isEmpty(zzfexVar.zzb.zzb.zzm)) {
                this.zzi = zzfexVar.zzb.zzb.zzm;
            }
            if (zzfexVar.zzb.zzb.zzp.length() > 0) {
                this.zzl = zzfexVar.zzb.zzb.zzp;
            }
            if (((Boolean) n42.d.c.zza(zzbbw.zziu)).booleanValue()) {
                if (!this.zza.zzs()) {
                    this.zzo = true;
                    return;
                }
                if (!TextUtils.isEmpty(zzfexVar.zzb.zzb.zzn)) {
                    this.zzj = zzfexVar.zzb.zzb.zzn;
                }
                if (zzfexVar.zzb.zzb.zzo.length() > 0) {
                    this.zzk = zzfexVar.zzb.zzb.zzo;
                }
                zzdvi zzdviVar = this.zza;
                JSONObject jSONObject = this.zzk;
                int length = jSONObject != null ? jSONObject.toString().length() : 0;
                if (!TextUtils.isEmpty(this.zzj)) {
                    length += this.zzj.length();
                }
                zzdviVar.zzk(length);
            }
        }
    }

    public final void zze() {
        this.zzm = true;
    }

    public final void zzf() {
        this.zzn = true;
    }

    public final boolean zzg() {
        return this.zze != zzduv.AD_REQUESTED;
    }
}
