package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import defpackage.do0;
import defpackage.h82;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.k92;
import defpackage.ka2;
import defpackage.n42;
import defpackage.or1;
import defpackage.x32;
import defpackage.za2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdvi implements zzdwj, zzdut {
    private final zzdvt zza;
    private final zzdwk zzb;
    private final zzduu zzc;
    private final zzdvd zzd;
    private final zzdus zze;
    private final zzdwf zzf;
    private final zzdvp zzg;
    private final zzdvp zzh;
    private final String zzi;
    private final Context zzj;
    private final String zzk;
    private JSONObject zzp;
    private boolean zzs;
    private int zzt;
    private boolean zzu;
    private final Map zzl = new HashMap();
    private final Map zzm = new HashMap();
    private final Map zzn = new HashMap();
    private String zzo = "{}";
    private long zzq = Long.MAX_VALUE;
    private zzdve zzr = zzdve.NONE;
    private zzdvh zzv = zzdvh.UNKNOWN;
    private long zzw = 0;
    private String zzx = "";

    public zzdvi(zzdvt zzdvtVar, zzdwk zzdwkVar, zzduu zzduuVar, Context context, or1 or1Var, zzdvd zzdvdVar, zzdwf zzdwfVar, zzdvp zzdvpVar, zzdvp zzdvpVar2, String str) {
        this.zza = zzdvtVar;
        this.zzb = zzdwkVar;
        this.zzc = zzduuVar;
        this.zze = new zzdus(context);
        this.zzi = or1Var.g;
        this.zzk = str;
        this.zzd = zzdvdVar;
        this.zzf = zzdwfVar;
        this.zzg = zzdvpVar;
        this.zzh = zzdvpVar2;
        this.zzj = context;
        hd2.B.m.g = this;
    }

    private final synchronized void zzA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzx(jSONObject.optBoolean("isTestMode", false), false);
            zzw((zzdve) Enum.valueOf(zzdve.class, jSONObject.optString("gesture", "NONE")), false);
            this.zzo = jSONObject.optString("networkExtras", "{}");
            this.zzq = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
        } catch (JSONException unused) {
        }
    }

    private final synchronized JSONObject zzt() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            for (Map.Entry entry : this.zzl.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                for (zzduw zzduwVar : (List) entry.getValue()) {
                    if (zzduwVar.zzg()) {
                        jSONArray.put(zzduwVar.zzd());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put((String) entry.getKey(), jSONArray);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    private final void zzu() {
        String str;
        this.zzu = true;
        this.zzd.zzc();
        this.zza.zzh(this);
        this.zzb.zzd(this);
        this.zzc.zzd(this);
        this.zzf.zzf(this);
        zzbbn zzbbnVar = zzbbw.zziD;
        n42 n42Var = n42.d;
        if (!TextUtils.isEmpty((CharSequence) n42Var.c.zza(zzbbnVar))) {
            this.zzg.zzb(PreferenceManager.getDefaultSharedPreferences(this.zzj), Arrays.asList(((String) n42Var.c.zza(zzbbnVar)).split(",")));
        }
        zzbbn zzbbnVar2 = zzbbw.zziE;
        if (!TextUtils.isEmpty((CharSequence) n42Var.c.zza(zzbbnVar2))) {
            this.zzh.zzb(this.zzj.getSharedPreferences("admob", 0), Arrays.asList(((String) n42Var.c.zza(zzbbnVar2)).split(",")));
        }
        hd2 hd2Var = hd2.B;
        zzA(((ib2) hd2Var.g.zzi()).B());
        ib2 ib2Var = (ib2) hd2Var.g.zzi();
        ib2Var.r();
        synchronized (ib2Var.a) {
            str = ib2Var.A;
        }
        this.zzx = str;
    }

    private final void zzv() {
        za2 za2VarZzi = hd2.B.g.zzi();
        String strZzd = zzd();
        ib2 ib2Var = (ib2) za2VarZzi;
        ib2Var.getClass();
        if (((Boolean) n42.d.c.zza(zzbbw.zzia)).booleanValue()) {
            ib2Var.r();
            synchronized (ib2Var.a) {
                try {
                    if (ib2Var.x.equals(strZzd)) {
                        return;
                    }
                    ib2Var.x = strZzd;
                    SharedPreferences.Editor editor = ib2Var.g;
                    if (editor != null) {
                        editor.putString("inspector_info", strZzd);
                        ib2Var.g.apply();
                    }
                    ib2Var.s();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final synchronized void zzw(zzdve zzdveVar, boolean z) {
        try {
            if (this.zzr != zzdveVar) {
                if (zzq()) {
                    zzy();
                }
                this.zzr = zzdveVar;
                if (zzq()) {
                    zzz();
                }
                if (z) {
                    zzv();
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0001, B:6:0x0006, B:8:0x000a, B:10:0x001c, B:15:0x0029, B:20:0x0038, B:16:0x002d, B:18:0x0033), top: B:27:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final synchronized void zzx(boolean r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzs     // Catch: java.lang.Throwable -> L27
            if (r0 != r2) goto L6
            goto L3d
        L6:
            r1.zzs = r2     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L2d
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzip     // Catch: java.lang.Throwable -> L27
            n42 r0 = defpackage.n42.d     // Catch: java.lang.Throwable -> L27
            com.google.android.gms.internal.ads.zzbbu r0 = r0.c     // Catch: java.lang.Throwable -> L27
            java.lang.Object r2 = r0.zza(r2)     // Catch: java.lang.Throwable -> L27
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L27
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L29
            hd2 r2 = defpackage.hd2.B     // Catch: java.lang.Throwable -> L27
            t92 r2 = r2.m     // Catch: java.lang.Throwable -> L27
            boolean r2 = r2.j()     // Catch: java.lang.Throwable -> L27
            if (r2 != 0) goto L2d
            goto L29
        L27:
            r2 = move-exception
            goto L3f
        L29:
            r1.zzz()     // Catch: java.lang.Throwable -> L27
            goto L36
        L2d:
            boolean r2 = r1.zzq()     // Catch: java.lang.Throwable -> L27
            if (r2 != 0) goto L36
            r1.zzy()     // Catch: java.lang.Throwable -> L27
        L36:
            if (r3 == 0) goto L3d
            r1.zzv()     // Catch: java.lang.Throwable -> L27
            monitor-exit(r1)
            return
        L3d:
            monitor-exit(r1)
            return
        L3f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L27
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvi.zzx(boolean, boolean):void");
    }

    private final synchronized void zzy() {
        int iOrdinal = this.zzr.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzb();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzb();
        }
    }

    private final synchronized void zzz() {
        int iOrdinal = this.zzr.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzc();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzc();
        }
    }

    public final zzdve zza() {
        return this.zzr;
    }

    public final synchronized do0 zzb(String str) {
        zzbzt zzbztVar;
        try {
            zzbztVar = new zzbzt();
            if (this.zzm.containsKey(str)) {
                zzbztVar.zzc((zzduw) this.zzm.get(str));
            } else {
                if (!this.zzn.containsKey(str)) {
                    this.zzn.put(str, new ArrayList());
                }
                ((List) this.zzn.get(str)).add(zzbztVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzbztVar;
    }

    public final synchronized String zzc() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzia)).booleanValue() && zzq()) {
            long j = this.zzq;
            hd2.B.j.getClass();
            if (j < System.currentTimeMillis() / 1000) {
                this.zzo = "{}";
                this.zzq = Long.MAX_VALUE;
                return "";
            }
            if (!this.zzo.equals("{}")) {
                return this.zzo;
            }
        }
        return "";
    }

    public final synchronized String zzd() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("isTestMode", this.zzs);
            jSONObject.put("gesture", this.zzr);
            long j = this.zzq;
            hd2.B.j.getClass();
            if (j > System.currentTimeMillis() / 1000) {
                jSONObject.put("networkExtras", this.zzo);
                jSONObject.put("networkExtrasExpirationSecs", this.zzq);
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final synchronized JSONObject zze() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("platform", "ANDROID");
                if (!TextUtils.isEmpty(this.zzk)) {
                    jSONObject.put("sdkVersion", "afma-sdk-a-v" + this.zzk);
                }
                jSONObject.put("internalSdkVersion", this.zzi);
                jSONObject.put("osVersion", Build.VERSION.RELEASE);
                jSONObject.put("adapters", this.zzd.zza());
                zzbbn zzbbnVar = zzbbw.zziA;
                n42 n42Var = n42.d;
                if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
                    String strZzn = hd2.B.g.zzn();
                    if (!TextUtils.isEmpty(strZzn)) {
                        jSONObject.put("plugin", strZzn);
                    }
                }
                long j = this.zzq;
                hd2 hd2Var = hd2.B;
                hd2Var.j.getClass();
                if (j < System.currentTimeMillis() / 1000) {
                    this.zzo = "{}";
                }
                jSONObject.put("networkExtras", this.zzo);
                jSONObject.put("adSlots", zzt());
                jSONObject.put("appInfo", this.zze.zza());
                String strZzc = ((ib2) hd2Var.g.zzi()).x().zzc();
                if (!TextUtils.isEmpty(strZzc)) {
                    jSONObject.put("cld", new JSONObject(strZzc));
                }
                if (((Boolean) n42Var.c.zza(zzbbw.zziq)).booleanValue() && (jSONObject2 = this.zzp) != null) {
                    k92.d("Server data: " + jSONObject2.toString());
                    jSONObject.put("serverData", this.zzp);
                }
                if (((Boolean) n42Var.c.zza(zzbbw.zzip)).booleanValue()) {
                    jSONObject.put("openAction", this.zzv);
                    jSONObject.put("gesture", this.zzr);
                }
                jSONObject.put("isGamRegisteredTestDevice", hd2Var.m.j());
                ka2 ka2Var = x32.f.a;
                jSONObject.put("isSimulator", ka2.l());
                if (((Boolean) n42Var.c.zza(zzbbw.zziC)).booleanValue()) {
                    jSONObject.put("uiStorage", new JSONObject(this.zzx));
                }
                if (!TextUtils.isEmpty((CharSequence) n42Var.c.zza(zzbbw.zziE))) {
                    jSONObject.put("gmaDisk", this.zzh.zza());
                }
                if (!TextUtils.isEmpty((CharSequence) n42Var.c.zza(zzbbw.zziD))) {
                    jSONObject.put("userDisk", this.zzg.zza());
                }
            } catch (JSONException e) {
                hd2.B.g.zzv(e, "Inspector.toJson");
                k92.j(5);
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    public final synchronized void zzf(String str, zzduw zzduwVar) {
        zzbbn zzbbnVar = zzbbw.zzia;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && zzq()) {
            if (this.zzt >= ((Integer) n42Var.c.zza(zzbbw.zzic)).intValue()) {
                k92.h("Maximum number of ad requests stored reached. Dropping the current request.");
                return;
            }
            if (!this.zzl.containsKey(str)) {
                this.zzl.put(str, new ArrayList());
            }
            this.zzt++;
            ((List) this.zzl.get(str)).add(zzduwVar);
            if (((Boolean) n42Var.c.zza(zzbbw.zziy)).booleanValue()) {
                String strZzc = zzduwVar.zzc();
                this.zzm.put(strZzc, zzduwVar);
                if (this.zzn.containsKey(strZzc)) {
                    List list = (List) this.zzn.get(strZzc);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((zzbzt) it.next()).zzc(zzduwVar);
                    }
                    list.clear();
                }
            }
        }
    }

    public final void zzg() {
        zzbbn zzbbnVar = zzbbw.zzia;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            if (((Boolean) n42Var.c.zza(zzbbw.zzip)).booleanValue() && ((ib2) hd2.B.g.zzi()).p()) {
                zzu();
                return;
            }
            String strB = ((ib2) hd2.B.g.zzi()).B();
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            try {
                if (new JSONObject(strB).optBoolean("isTestMode", false)) {
                    zzu();
                }
            } catch (JSONException unused) {
            }
        }
    }

    public final synchronized void zzh(h82 h82Var, zzdvh zzdvhVar) {
        if (!zzq()) {
            try {
                h82Var.zze(zzfgi.zzd(18, null, null));
                return;
            } catch (RemoteException unused) {
                k92.h("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
                return;
            }
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzia)).booleanValue()) {
            this.zzv = zzdvhVar;
            this.zza.zzj(h82Var, new zzbjr(this), new zzbjk(this.zzf), new zzbiy(this));
            return;
        } else {
            try {
                h82Var.zze(zzfgi.zzd(1, null, null));
                return;
            } catch (RemoteException unused2) {
                k92.h("Ad inspector had an internal error.");
                return;
            }
        }
    }

    public final synchronized void zzi(String str, long j) {
        this.zzo = str;
        this.zzq = j;
        zzv();
    }

    public final synchronized void zzj(String str) {
        this.zzx = str;
        ((ib2) hd2.B.g.zzi()).f(this.zzx);
    }

    public final synchronized void zzk(long j) {
        this.zzw += j;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzl(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.zzu
            if (r0 != 0) goto La
            if (r2 == 0) goto L15
            r1.zzu()
            goto Lc
        La:
            if (r2 == 0) goto L15
        Lc:
            boolean r2 = r1.zzs
            if (r2 == 0) goto L11
            goto L15
        L11:
            r1.zzz()
            return
        L15:
            boolean r2 = r1.zzq()
            if (r2 != 0) goto L1e
            r1.zzy()
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvi.zzl(boolean):void");
    }

    public final void zzm(zzdve zzdveVar) {
        zzw(zzdveVar, true);
    }

    public final synchronized void zzn(JSONObject jSONObject) {
        this.zzp = jSONObject;
    }

    public final void zzo(boolean z) {
        if (!this.zzu && z) {
            zzu();
        }
        zzx(z, true);
    }

    public final boolean zzp() {
        return this.zzp != null;
    }

    public final synchronized boolean zzq() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzip)).booleanValue()) {
            return this.zzs || hd2.B.m.j();
        }
        return this.zzs;
    }

    public final synchronized boolean zzr() {
        return this.zzs;
    }

    public final boolean zzs() {
        return this.zzw < ((Long) n42.d.c.zza(zzbbw.zziv)).longValue();
    }
}
