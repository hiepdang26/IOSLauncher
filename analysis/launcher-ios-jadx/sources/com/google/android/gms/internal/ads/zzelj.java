package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.os.SystemClock;
import defpackage.hd2;
import defpackage.j92;
import defpackage.n42;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzelj extends zzbqn {
    private final String zza;
    private final zzbql zzb;
    private final zzbzt zzc;
    private final JSONObject zzd;
    private final long zze;
    private boolean zzf;

    public zzelj(String str, zzbql zzbqlVar, zzbzt zzbztVar, long j) {
        JSONObject jSONObject = new JSONObject();
        this.zzd = jSONObject;
        this.zzf = false;
        this.zzc = zzbztVar;
        this.zza = str;
        this.zzb = zzbqlVar;
        this.zze = j;
        try {
            jSONObject.put("adapter_version", zzbqlVar.zzf().toString());
            jSONObject.put("sdk_version", zzbqlVar.zzg().toString());
            jSONObject.put("name", str);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    public static synchronized void zzb(String str, zzbzt zzbztVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("signal_error", "Adapter failed to instantiate");
                if (((Boolean) n42.d.c.zza(zzbbw.zzbq)).booleanValue()) {
                    jSONObject.put("signal_error_code", 1);
                }
                zzbztVar.zzc(jSONObject);
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzh(String str, int i) {
        try {
            if (this.zzf) {
                return;
            }
            try {
                this.zzd.put("signal_error", str);
                zzbbn zzbbnVar = zzbbw.zzbr;
                n42 n42Var = n42.d;
                if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                    JSONObject jSONObject = this.zzd;
                    hd2.B.j.getClass();
                    jSONObject.put("latency", SystemClock.elapsedRealtime() - this.zze);
                }
                if (((Boolean) n42Var.c.zza(zzbbw.zzbq)).booleanValue()) {
                    this.zzd.put("signal_error_code", i);
                }
            } catch (JSONException unused) {
            }
            this.zzc.zzc(this.zzd);
            this.zzf = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzc() {
        zzh("Signal collection timeout.", 3);
    }

    public final synchronized void zzd() {
        if (this.zzf) {
            return;
        }
        try {
            if (((Boolean) n42.d.c.zza(zzbbw.zzbq)).booleanValue()) {
                this.zzd.put("signal_error_code", 0);
            }
        } catch (JSONException unused) {
        }
        this.zzc.zzc(this.zzd);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbqo
    public final synchronized void zze(String str) {
        if (this.zzf) {
            return;
        }
        if (str == null) {
            zzf("Adapter returned null signals");
            return;
        }
        try {
            this.zzd.put("signals", str);
            zzbbn zzbbnVar = zzbbw.zzbr;
            n42 n42Var = n42.d;
            if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                JSONObject jSONObject = this.zzd;
                hd2.B.j.getClass();
                jSONObject.put("latency", SystemClock.elapsedRealtime() - this.zze);
            }
            if (((Boolean) n42Var.c.zza(zzbbw.zzbq)).booleanValue()) {
                this.zzd.put("signal_error_code", 0);
            }
        } catch (JSONException unused) {
        }
        this.zzc.zzc(this.zzd);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbqo
    public final synchronized void zzf(String str) {
        zzh(str, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzbqo
    public final synchronized void zzg(j92 j92Var) {
        zzh(j92Var.h, 2);
    }
}
