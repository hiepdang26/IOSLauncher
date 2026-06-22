package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import defpackage.e41;
import defpackage.hd2;
import defpackage.hr;
import defpackage.k92;
import defpackage.kr;
import defpackage.lr;
import defpackage.m92;
import defpackage.n42;
import defpackage.nx0;
import defpackage.or;
import defpackage.s2;
import defpackage.td0;
import defpackage.vd0;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbcx {
    private final ScheduledExecutorService zza;
    private final m92 zzb;
    private Runnable zzc;
    private zzbcu zzd;
    private or zze;
    private String zzf;
    private long zzg = 0;
    private long zzh;
    private JSONArray zzi;
    private Context zzj;

    public zzbcx(ScheduledExecutorService scheduledExecutorService, m92 m92Var) {
        this.zza = scheduledExecutorService;
        this.zzb = m92Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        if (((java.lang.Boolean) defpackage.n42.d.c.zza(com.google.android.gms.internal.ads.zzbbw.zziT)).booleanValue() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj() {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzbcu r0 = r5.zzd
            if (r0 != 0) goto La
            java.lang.String r0 = "PACT callback is not present, please initialize the PawCustomTabsImpl."
            defpackage.k92.e(r0)
            return
        La:
            java.lang.Boolean r0 = r0.zza()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L15
            return
        L15:
            java.lang.String r0 = r5.zzf
            if (r0 == 0) goto L7c
            or r0 = r5.zze
            if (r0 == 0) goto L7c
            java.util.concurrent.ScheduledExecutorService r0 = r5.zza
            if (r0 == 0) goto L7c
            long r0 = r5.zzg
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L2a
            goto L3c
        L2a:
            hd2 r0 = defpackage.hd2.B
            us r0 = r0.j
            r0.getClass()
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = r5.zzg
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L3c
            goto L4e
        L3c:
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zziT
            n42 r1 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r1 = r1.c
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L7c
        L4e:
            or r0 = r5.zze
            java.lang.String r1 = r5.zzf
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r0.getClass()
            kr r2 = r0.c
            vd0 r0 = r0.b
            td0 r0 = (defpackage.td0) r0     // Catch: android.os.RemoteException -> L62
            r0.q(r2, r1)     // Catch: android.os.RemoteException -> L62
        L62:
            java.util.concurrent.ScheduledExecutorService r0 = r5.zza
            java.lang.Runnable r1 = r5.zzc
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zziU
            n42 r3 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r3 = r3.c
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r2, r4)
            return
        L7c:
            java.lang.String r0 = "PACT max retry connection duration timed out"
            defpackage.k92.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcx.zzj():void");
    }

    private final void zzk(JSONObject jSONObject) {
        try {
            if (this.zzi == null) {
                this.zzi = new JSONArray((String) n42.d.c.zza(zzbbw.zziW));
            }
            jSONObject.put("eids", this.zzi);
        } catch (JSONException unused) {
            k92.f();
        }
    }

    public final or zzb() {
        return this.zze;
    }

    public final JSONObject zzc(String str, String str2) throws JSONException {
        long jLongValue;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("error", str2);
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            jLongValue = ((Long) n42.d.c.zza(zzbbw.zziX)).longValue();
        } else {
            jLongValue = 0;
        }
        jSONObject.put("sdk_ttl_ms", jLongValue);
        zzk(jSONObject);
        return jSONObject;
    }

    public final JSONObject zzd(String str, String str2) throws JSONException {
        long jLongValue;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("signal", str2);
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            jLongValue = ((Long) n42.d.c.zza(zzbbw.zziX)).longValue();
        } else {
            jLongValue = 0;
        }
        jSONObject.put("sdk_ttl_ms", jLongValue);
        zzk(jSONObject);
        return jSONObject;
    }

    public final void zzf() {
        hd2.B.j.getClass();
        this.zzg = SystemClock.elapsedRealtime() + ((long) ((Integer) n42.d.c.zza(zzbbw.zziS)).intValue());
        if (this.zzc == null) {
            this.zzc = new Runnable() { // from class: com.google.android.gms.internal.ads.zzbcv
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj();
                }
            };
        }
        zzj();
    }

    public final void zzg(Context context, lr lrVar, String str, hr hrVar) {
        if (context == null) {
            throw new IllegalArgumentException("App Context parameter is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Origin parameter is empty or null");
        }
        if (lrVar == null) {
            throw new IllegalArgumentException("CustomTabsClient parameter is null");
        }
        this.zzj = context;
        this.zzf = str;
        zzbcu zzbcuVar = new zzbcu(this, hrVar);
        this.zzd = zzbcuVar;
        kr krVar = new kr(zzbcuVar);
        vd0 vd0Var = lrVar.a;
        or orVar = !((td0) vd0Var).f(krVar) ? null : new or(vd0Var, krVar, lrVar.b);
        this.zze = orVar;
        if (orVar == null) {
            k92.e("CustomTabsClient failed to create new session.");
        }
    }

    public final void zzh(String str) {
        try {
            or orVar = this.zze;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gsppack", true);
            jSONObject.put("fpt", new Date(this.zzh).toString());
            zzk(jSONObject);
            orVar.a(jSONObject.toString());
            zzbcw zzbcwVar = new zzbcw(this, str);
            if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
                this.zzb.b(this.zze, zzbcwVar);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("query_info_type", "requester_type_6");
            Context context = this.zzj;
            nx0 nx0Var = new nx0(2);
            nx0Var.q(bundle);
            e41.a(context, new s2(nx0Var), zzbcwVar);
        } catch (JSONException unused) {
            k92.f();
        }
    }

    public final void zzi(long j) {
        this.zzh = j;
    }
}
