package defpackage;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzbld;
import com.google.android.gms.internal.ads.zzble;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzdvi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class t92 {
    public static t92 h;
    public final Object a;
    public boolean b;
    public boolean c;
    public Object d;
    public Serializable e;
    public Object f;
    public Object g;

    public t92(int i) {
        switch (i) {
            case 1:
                this.a = new Object();
                this.d = "";
                this.e = "";
                this.b = false;
                this.c = false;
                this.f = "";
                break;
            default:
                this.a = new Object();
                this.b = false;
                this.c = false;
                this.d = new Object();
                this.g = new oa1(new ArrayList());
                this.e = new ArrayList();
                break;
        }
    }

    public static t92 f() {
        t92 t92Var;
        synchronized (t92.class) {
            try {
                if (h == null) {
                    h = new t92(0);
                }
                t92Var = h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return t92Var;
    }

    public static void h(String str, Context context, boolean z, boolean z2) {
        if (context instanceof Activity) {
            cd2.l.post(new zz1(str, context, z, z2));
        } else {
            k92.g("Can not create dialog without Activity Context");
        }
    }

    public static final String m(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put("User-Agent", hd2.B.c.w(context, str2));
        new l52(context);
        g52 g52VarA = l52.a(0, str, map, null);
        try {
            return (String) g52VarA.get(((Integer) n42.d.c.zza(zzbbw.zzel)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            "Interrupted while retrieving a response from: ".concat(String.valueOf(str));
            k92.f();
            g52VarA.cancel(true);
            return null;
        } catch (TimeoutException unused2) {
            "Timeout while retrieving a response from: ".concat(String.valueOf(str));
            k92.f();
            g52VarA.cancel(true);
            return null;
        } catch (Exception unused3) {
            "Error retrieving a response from: ".concat(String.valueOf(str));
            k92.f();
            return null;
        }
    }

    public static zzble o(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbkv zzbkvVar = (zzbkv) it.next();
            map.put(zzbkvVar.zza, new zzbld(zzbkvVar.zzb ? a3.h : a3.g, zzbkvVar.zzd, zzbkvVar.zzc));
        }
        return new zzble(map);
    }

    public void a(Context context) {
        if (((l72) this.f) == null) {
            this.f = (l72) new i32(x32.f.b, context).d(context, false);
        }
    }

    public void b(Context context) {
        zzdvi zzdviVar;
        if (!((Boolean) n42.d.c.zza(zzbbw.zzip)).booleanValue() || (zzdviVar = (zzdvi) this.g) == null) {
            return;
        }
        zzdviVar.zzh(new p32(this, context), zzdvh.DEBUG_MENU);
    }

    public void c(Context context, String str, String str2) {
        cd2 cd2Var = hd2.B.c;
        cd2.q(n(context, (String) n42.d.c.zza(zzbbw.zzeh), str, str2), context);
    }

    public pf0 d() {
        zzble zzbleVarO;
        synchronized (this.d) {
            try {
                l72 l72Var = (l72) this.f;
                if (!(l72Var != null)) {
                    throw new IllegalStateException("MobileAds.initialize() must be called prior to getting initialization status.");
                }
                try {
                    zzbleVarO = o(l72Var.zzg());
                } catch (RemoteException unused) {
                    k92.e("Unable to get Initialization status.");
                    return new ta1(13);
                }
            } finally {
            }
        }
        return zzbleVarO;
    }

    public void e(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = n(context, (String) n42.d.c.zza(zzbbw.zzek), str3, str).buildUpon();
        builderBuildUpon.appendQueryParameter("debugData", str2);
        cd2 cd2Var = hd2.B.c;
        cd2.j(context, str, builderBuildUpon.build().toString());
    }

    public void g(boolean z) {
        synchronized (this.a) {
            try {
                this.c = z;
                if (((Boolean) n42.d.c.zza(zzbbw.zzip)).booleanValue()) {
                    ((ib2) hd2.B.g.zzi()).b(z);
                    zzdvi zzdviVar = (zzdvi) this.g;
                    if (zzdviVar != null) {
                        zzdviVar.zzl(z);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean i(Context context, String str, String str2) {
        zzbbn zzbbnVar = zzbbw.zzej;
        n42 n42Var = n42.d;
        String strM = m(context, n(context, (String) n42Var.c.zza(zzbbnVar), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strM)) {
            k92.d("Not linked for debug signals.");
            return false;
        }
        try {
            boolean zEquals = "1".equals(new JSONObject(strM.trim()).optString("debug_mode"));
            g(zEquals);
            if (((Boolean) n42Var.c.zza(zzbbw.zzip)).booleanValue()) {
                za2 za2VarZzi = hd2.B.g.zzi();
                if (true != zEquals) {
                    str = "";
                }
                ((ib2) za2VarZzi).a(str);
            }
            return zEquals;
        } catch (JSONException unused) {
            k92.j(5);
            return false;
        }
    }

    public boolean j() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    public boolean k() {
        boolean z;
        synchronized (this.a) {
            z = this.b;
        }
        return z;
    }

    public boolean l(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !k()) {
            return false;
        }
        k92.d("Sending troubleshooting signals to the server.");
        e(context, str, str2, str3);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a A[Catch: all -> 0x0034, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0015, B:7:0x001b, B:12:0x003d, B:14:0x0045, B:16:0x0056, B:18:0x0067, B:11:0x0036, B:19:0x006a, B:20:0x006e), top: B:25:0x000b, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.net.Uri n(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r5 = this;
            android.net.Uri r7 = android.net.Uri.parse(r7)
            android.net.Uri$Builder r7 = r7.buildUpon()
            java.lang.Object r0 = r5.a
            monitor-enter(r0)
            java.lang.Object r1 = r5.d     // Catch: java.lang.Throwable -> L34
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L34
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L6a
            hd2 r1 = defpackage.hd2.B     // Catch: java.lang.Throwable -> L34
            cd2 r1 = r1.c     // Catch: java.lang.Throwable -> L34
            java.lang.String r1 = "debug_signals_id.txt"
            java.io.FileInputStream r1 = r6.openFileInput(r1)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            r3.<init>()     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            r4 = 1
            defpackage.hs0.j(r1, r3, r4)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            byte[] r1 = r3.toByteArray()     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            goto L3d
        L34:
            r6 = move-exception
            goto L83
        L36:
            java.lang.String r1 = "Error reading from internal storage."
            defpackage.k92.d(r1)     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = ""
        L3d:
            r5.d = r2     // Catch: java.lang.Throwable -> L34
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L6a
            hd2 r1 = defpackage.hd2.B     // Catch: java.lang.Throwable -> L34
            cd2 r1 = r1.c     // Catch: java.lang.Throwable -> L34
            java.util.UUID r1 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L34
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L34
            r5.d = r1     // Catch: java.lang.Throwable -> L34
            java.lang.String r2 = "debug_signals_id.txt"
            r3 = 0
            java.io.FileOutputStream r6 = r6.openFileOutput(r2, r3)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L67
            java.lang.String r2 = "UTF-8"
            byte[] r1 = r1.getBytes(r2)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L67
            r6.write(r1)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L67
            r6.close()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L67
            goto L6a
        L67:
            defpackage.k92.f()     // Catch: java.lang.Throwable -> L34
        L6a:
            java.lang.Object r6 = r5.d     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L34
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            java.lang.String r0 = "linkedDeviceId"
            r7.appendQueryParameter(r0, r6)
            java.lang.String r6 = "adSlotPath"
            r7.appendQueryParameter(r6, r8)
            java.lang.String r6 = "afmaVersion"
            r7.appendQueryParameter(r6, r9)
            android.net.Uri r6 = r7.build()
            return r6
        L83:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t92.n(android.content.Context, java.lang.String, java.lang.String, java.lang.String):android.net.Uri");
    }

    public void p(Context context) {
        try {
            zzboe.zza().zzb(context, null);
            ((l72) this.f).zzk();
            ((l72) this.f).zzl(null, new gy0(null));
        } catch (RemoteException unused) {
            k92.j(5);
        }
    }
}
