package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.hd2;
import defpackage.j92;
import defpackage.k92;
import defpackage.n42;
import defpackage.np1;
import defpackage.v32;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdrr implements zzczo, zzcye, zzcwt, zzdfc {
    private final zzdsf zza;
    private final zzdsp zzb;

    public zzdrr(zzdsf zzdsfVar, zzdsp zzdspVar) {
        this.zza = zzdsfVar;
        this.zzb = zzdspVar;
    }

    private final void zzc(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            long j = bundle.getLong(str);
            if (j >= 0) {
                this.zza.zzc(str, String.valueOf(j));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzd(Bundle bundle, zzfxr zzfxrVar) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzbS)).booleanValue() || bundle == null) {
            return;
        }
        String strZza = zzdrt.PUBLIC_API_CALLBACK.zza();
        hd2.B.j.getClass();
        bundle.putLong(strZza, System.currentTimeMillis());
        this.zza.zzc("ls", true != bundle.getBoolean("ls") ? "0" : "1");
        int size = zzfxrVar.size();
        for (int i = 0; i < size; i++) {
            zzdru zzdruVar = (zzdru) zzfxrVar.get(i);
            long j = bundle.getLong(zzdruVar.zza().zza(), -1L);
            long j2 = bundle.getLong(zzdruVar.zzb().zza(), -1L);
            if (j > 0 && j2 > 0) {
                this.zza.zzc(zzdruVar.zzc(), String.valueOf(j2 - j));
            }
        }
        zzc(bundle.getBundle("client_sig_latency_key"));
        zzc(bundle.getBundle("gms_sig_latency_key"));
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(j92 j92Var) {
        this.zza.zzb().put("action", "ftl");
        this.zza.zzc("ftl", String.valueOf(j92Var.g));
        this.zza.zzc("ed", j92Var.i);
        this.zzb.zzf(this.zza.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
        this.zza.zze(zzbvbVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdo(zzfex zzfexVar) {
        this.zza.zzd(zzfexVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdfc
    public final void zze(v32 v32Var) {
        String str;
        zzbbn zzbbnVar = zzbbw.zzgo;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            if (v32Var == null) {
                this.zza.zzb().put("action", "sgs");
                this.zza.zzb().put("request_id", "-1");
                this.zzb.zzf(this.zza.zzb());
                return;
            }
            zzbvb zzbvbVar = v32Var.c;
            if (zzbvbVar != null) {
                zzd(zzbvbVar.zzm, zzdru.zza);
            }
            try {
                JSONObject jSONObject = new JSONObject(v32Var.b);
                this.zza.zzb().put("action", "sgs");
                Map mapZzb = this.zza.zzb();
                if (((Boolean) n42Var.c.zza(zzbbw.zziM)).booleanValue()) {
                    try {
                        str = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? "1" : "0";
                    } catch (JSONException unused) {
                        k92.f();
                        str = "na";
                    }
                } else {
                    str = "na";
                }
                mapZzb.put("tpc", str);
                if (zzbvbVar != null) {
                    this.zza.zze(zzbvbVar.zza);
                }
                this.zzb.zzf(this.zza.zzb());
            } catch (JSONException unused2) {
                this.zza.zzb().put("action", "sgf");
                this.zza.zzb().put("sgf_reason", "request_invalid");
                this.zzb.zzf(this.zza.zzb());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfc
    public final void zzf(String str) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzgo)).booleanValue()) {
            this.zza.zzb().put("action", "sgf");
            this.zza.zzc("sgf_reason", str);
            this.zzb.zzf(this.zza.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        this.zza.zzb().put("action", "loaded");
        zzd(this.zza.zza(), zzdru.zzb);
        if (((Boolean) n42.d.c.zza(zzbbw.zzlG)).booleanValue()) {
            this.zza.zzb().put("mafe", true != np1.z("MUTE_AUDIO") ? "0" : "1");
        }
        this.zzb.zzf(this.zza.zzb());
    }
}
