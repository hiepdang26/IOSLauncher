package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdj;
import com.google.android.gms.internal.ads.zzbyy;
import com.google.android.gms.internal.ads.zzbzo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ib2 implements za2 {
    public boolean b;
    public do0 d;
    public SharedPreferences f;
    public SharedPreferences.Editor g;
    public String i;
    public String j;
    public final Object a = new Object();
    public final ArrayList c = new ArrayList();
    public zzayv e = null;
    public boolean h = true;
    public boolean k = true;
    public String l = "-1";
    public int m = -1;
    public zzbyy n = new zzbyy("", 0);
    public long o = 0;
    public long p = 0;
    public int q = -1;
    public int r = 0;
    public Set s = Collections.EMPTY_SET;
    public JSONObject t = new JSONObject();
    public boolean u = true;
    public boolean v = true;
    public String w = null;
    public String x = "";
    public boolean y = false;
    public String z = "";
    public String A = "{}";
    public int B = -1;
    public int C = -1;
    public long D = 0;

    public final String A() {
        String str;
        r();
        synchronized (this.a) {
            str = this.w;
        }
        return str;
    }

    public final String B() {
        String str;
        r();
        synchronized (this.a) {
            str = this.x;
        }
        return str;
    }

    public final JSONObject C() {
        JSONObject jSONObject;
        r();
        synchronized (this.a) {
            jSONObject = this.t;
        }
        return jSONObject;
    }

    public final void D(Context context) {
        synchronized (this.a) {
            try {
                if (this.f != null) {
                    return;
                }
                this.d = zzbzo.zza.zza(new gb2(this, context, 2));
                this.b = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void E() {
        r();
        synchronized (this.a) {
            try {
                this.t = new JSONObject();
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.remove("native_advanced_settings");
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void F(int i) {
        r();
        synchronized (this.a) {
            try {
                if (this.r == i) {
                    return;
                }
                this.r = i;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putInt("version_code", i);
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void G(String str) {
        r();
        synchronized (this.a) {
            try {
                if (str.equals(this.j)) {
                    return;
                }
                this.j = str;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putString("content_vertical_hashes", str);
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(String str) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzip)).booleanValue()) {
            r();
            synchronized (this.a) {
                try {
                    if (this.z.equals(str)) {
                        return;
                    }
                    this.z = str;
                    SharedPreferences.Editor editor = this.g;
                    if (editor != null) {
                        editor.putString("linked_ad_unit", str);
                        this.g.apply();
                    }
                    s();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void b(boolean z) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzip)).booleanValue()) {
            r();
            synchronized (this.a) {
                try {
                    if (this.y == z) {
                        return;
                    }
                    this.y = z;
                    SharedPreferences.Editor editor = this.g;
                    if (editor != null) {
                        editor.putBoolean("linked_device", z);
                        this.g.apply();
                    }
                    s();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void c(String str) {
        r();
        synchronized (this.a) {
            try {
                if (TextUtils.equals(this.w, str)) {
                    return;
                }
                this.w = str;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(long j) {
        r();
        synchronized (this.a) {
            try {
                if (this.p == j) {
                    return;
                }
                this.p = j;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j);
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(int i) {
        r();
        synchronized (this.a) {
            try {
                this.m = i;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    if (i == -1) {
                        editor.remove("gad_has_consent_for_cookies");
                    } else {
                        editor.putInt("gad_has_consent_for_cookies", i);
                    }
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(String str) {
        if (((Boolean) n42.d.c.zza(zzbbw.zziC)).booleanValue()) {
            r();
            synchronized (this.a) {
                try {
                    if (this.A.equals(str)) {
                        return;
                    }
                    this.A = str;
                    SharedPreferences.Editor editor = this.g;
                    if (editor != null) {
                        editor.putString("inspector_ui_storage", str);
                        this.g.apply();
                    }
                    s();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void g(boolean z) {
        r();
        synchronized (this.a) {
            try {
                if (z == this.k) {
                    return;
                }
                this.k = z;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z);
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(boolean z) {
        r();
        synchronized (this.a) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() + ((Long) n42.d.c.zza(zzbbw.zzjC)).longValue();
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putBoolean("is_topics_ad_personalization_allowed", z);
                    this.g.putLong("topics_consent_expiry_time_ms", jCurrentTimeMillis);
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        r3 = new org.json.JSONObject();
        r3.put("template_id", r9);
        r3.put("uses_media_view", r10);
        defpackage.hd2.B.j.getClass();
        r3.put("timestamp_ms", java.lang.System.currentTimeMillis());
        r1.put(r2, r3);
        r7.t.put(r8, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        defpackage.k92.j(5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r7 = this;
            r7.r()
            java.lang.Object r0 = r7.a
            monitor-enter(r0)
            org.json.JSONObject r1 = r7.t     // Catch: java.lang.Throwable -> L14
            org.json.JSONArray r1 = r1.optJSONArray(r8)     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L17
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L17
        L14:
            r8 = move-exception
            goto L8d
        L17:
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L14
            r3 = 0
            r4 = 0
        L1d:
            int r5 = r1.length()     // Catch: java.lang.Throwable -> L14
            if (r4 >= r5) goto L48
            org.json.JSONObject r5 = r1.optJSONObject(r4)     // Catch: java.lang.Throwable -> L14
            if (r5 != 0) goto L2b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L2b:
            java.lang.String r6 = "template_id"
            java.lang.String r6 = r5.optString(r6)     // Catch: java.lang.Throwable -> L14
            boolean r6 = r9.equals(r6)     // Catch: java.lang.Throwable -> L14
            if (r6 == 0) goto L45
            if (r10 == 0) goto L43
            java.lang.String r2 = "uses_media_view"
            boolean r2 = r5.optBoolean(r2, r3)     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L43
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L43:
            r2 = r4
            goto L48
        L45:
            int r4 = r4 + 1
            goto L1d
        L48:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            r3.<init>()     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            java.lang.String r4 = "template_id"
            r3.put(r4, r9)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            java.lang.String r9 = "uses_media_view"
            r3.put(r9, r10)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            java.lang.String r9 = "timestamp_ms"
            hd2 r10 = defpackage.hd2.B     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            us r10 = r10.j     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            r10.getClass()     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            r3.put(r9, r4)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            r1.put(r2, r3)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            org.json.JSONObject r9 = r7.t     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            r9.put(r8, r1)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L70
            goto L74
        L70:
            r8 = 5
            defpackage.k92.j(r8)     // Catch: java.lang.Throwable -> L14
        L74:
            android.content.SharedPreferences$Editor r8 = r7.g     // Catch: java.lang.Throwable -> L14
            if (r8 == 0) goto L88
            java.lang.String r9 = "native_advanced_settings"
            org.json.JSONObject r10 = r7.t     // Catch: java.lang.Throwable -> L14
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L14
            r8.putString(r9, r10)     // Catch: java.lang.Throwable -> L14
            android.content.SharedPreferences$Editor r8 = r7.g     // Catch: java.lang.Throwable -> L14
            r8.apply()     // Catch: java.lang.Throwable -> L14
        L88:
            r7.s()     // Catch: java.lang.Throwable -> L14
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L8d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ib2.i(java.lang.String, java.lang.String, boolean):void");
    }

    public final void j(int i) {
        r();
        synchronized (this.a) {
            try {
                if (this.q == i) {
                    return;
                }
                this.q = i;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i);
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(int i) {
        r();
        synchronized (this.a) {
            try {
                if (this.C == i) {
                    return;
                }
                this.C = i;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i);
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(long j) {
        r();
        synchronized (this.a) {
            try {
                if (this.D == j) {
                    return;
                }
                this.D = j;
                SharedPreferences.Editor editor = this.g;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j);
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(String str) {
        r();
        synchronized (this.a) {
            try {
                this.l = str;
                if (this.g != null) {
                    if (str.equals("-1")) {
                        this.g.remove("IABTCF_TCString");
                    } else {
                        this.g.putString("IABTCF_TCString", str);
                    }
                    this.g.apply();
                }
                s();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean n() {
        boolean z;
        r();
        synchronized (this.a) {
            z = this.u;
        }
        return z;
    }

    public final boolean o() {
        boolean z;
        r();
        synchronized (this.a) {
            z = this.v;
        }
        return z;
    }

    public final boolean p() {
        boolean z;
        r();
        synchronized (this.a) {
            z = this.y;
        }
        return z;
    }

    public final boolean q() {
        boolean z;
        if (!((Boolean) n42.d.c.zza(zzbbw.zzao)).booleanValue()) {
            return false;
        }
        r();
        synchronized (this.a) {
            z = this.k;
        }
        return z;
    }

    public final void r() {
        do0 do0Var = this.d;
        if (do0Var == null || do0Var.isDone()) {
            return;
        }
        try {
            this.d.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            k92.j(5);
        } catch (CancellationException | ExecutionException | TimeoutException unused2) {
            k92.f();
        }
    }

    public final void s() {
        zzbzo.zza.execute(new da2(this, 3));
    }

    public final int t() {
        int i;
        r();
        synchronized (this.a) {
            i = this.q;
        }
        return i;
    }

    public final long u() {
        long j;
        r();
        synchronized (this.a) {
            j = this.o;
        }
        return j;
    }

    public final long v() {
        long j;
        r();
        synchronized (this.a) {
            j = this.p;
        }
        return j;
    }

    public final zzayv w() {
        if (!this.b || ((n() && o()) || !((Boolean) zzbdj.zzb.zze()).booleanValue())) {
            return null;
        }
        synchronized (this.a) {
            try {
                if (Looper.getMainLooper() == null) {
                    return null;
                }
                if (this.e == null) {
                    this.e = new zzayv();
                }
                this.e.zze();
                k92.g("start fetching content...");
                return this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzbyy x() {
        zzbyy zzbyyVar;
        r();
        synchronized (this.a) {
            try {
                if (((Boolean) n42.d.c.zza(zzbbw.zzkN)).booleanValue() && this.n.zzj()) {
                    ArrayList arrayList = this.c;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((Runnable) obj).run();
                    }
                }
                zzbyyVar = this.n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbyyVar;
    }

    public final String y() {
        String str;
        r();
        synchronized (this.a) {
            str = this.i;
        }
        return str;
    }

    public final String z() {
        String str;
        r();
        synchronized (this.a) {
            str = this.j;
        }
        return str;
    }
}
