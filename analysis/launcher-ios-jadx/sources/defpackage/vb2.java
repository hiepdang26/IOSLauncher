package defpackage;

import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbu;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdsf;
import com.google.android.gms.internal.ads.zzdsp;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class vb2 {
    public final int a;
    public final long b;
    public final boolean c;
    public final boolean d;
    public final Map e;
    public final ArrayDeque f = new ArrayDeque();
    public final ArrayDeque g = new ArrayDeque();
    public final zzdsp h;
    public ConcurrentHashMap i;

    public vb2(zzdsp zzdspVar) {
        this.h = zzdspVar;
        zzbbn zzbbnVar = zzbbw.zzgm;
        n42 n42Var = n42.d;
        this.a = ((Integer) n42Var.c.zza(zzbbnVar)).intValue();
        zzbbn zzbbnVar2 = zzbbw.zzgn;
        zzbbu zzbbuVar = n42Var.c;
        this.b = ((Long) zzbbuVar.zza(zzbbnVar2)).longValue();
        this.c = ((Boolean) zzbbuVar.zza(zzbbw.zzgr)).booleanValue();
        this.d = ((Boolean) zzbbuVar.zza(zzbbw.zzgq)).booleanValue();
        this.e = Collections.synchronizedMap(new jb2(this));
    }

    public final synchronized String a(String str, zzdsf zzdsfVar) {
        try {
            ob2 ob2Var = (ob2) this.e.get(str);
            zzdsfVar.zzb().put("request_id", str);
            if (ob2Var == null) {
                zzdsfVar.zzb().put("mhit", "false");
                return null;
            }
            if (!((Boolean) n42.d.c.zza(zzbbw.zzgL)).booleanValue()) {
                this.e.remove(str);
            }
            String str2 = ob2Var.b;
            zzdsfVar.zzb().put("mhit", "true");
            return str2;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(String str) {
        this.e.remove(str);
    }

    public final synchronized boolean c(int i, String str, String str2) {
        ob2 ob2Var = (ob2) this.e.get(str);
        if (ob2Var == null) {
            return false;
        }
        ob2Var.c.add(str2);
        return ob2Var.c.size() < i;
    }

    public final synchronized boolean d(String str, String str2) {
        ob2 ob2Var = (ob2) this.e.get(str);
        if (ob2Var != null) {
            if (ob2Var.c.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void e(zzdsf zzdsfVar) throws Throwable {
        try {
            try {
                if (this.c) {
                    ArrayDeque arrayDeque = this.g;
                    ArrayDeque arrayDequeClone = arrayDeque.clone();
                    arrayDeque.clear();
                    ArrayDeque arrayDeque2 = this.f;
                    ArrayDeque arrayDequeClone2 = arrayDeque2.clone();
                    arrayDeque2.clear();
                    zzbzo.zza.execute(new ng(this, zzdsfVar, arrayDequeClone, arrayDequeClone2, 17, false));
                    return;
                }
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public final void f(zzdsf zzdsfVar, ArrayDeque arrayDeque, String str) {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzdsfVar.zzb());
            this.i = concurrentHashMap;
            concurrentHashMap.put("action", "ev");
            this.i.put("e_r", str);
            this.i.put("e_id", (String) pair2.first);
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(wd.M(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException unused) {
                    pair = new Pair("", "");
                }
                ConcurrentHashMap concurrentHashMap2 = this.i;
                String str2 = (String) pair.first;
                if (!TextUtils.isEmpty(str2)) {
                    concurrentHashMap2.put("e_type", str2);
                }
                ConcurrentHashMap concurrentHashMap3 = this.i;
                String str3 = (String) pair.second;
                if (!TextUtils.isEmpty(str3)) {
                    concurrentHashMap3.put("e_agent", str3);
                }
            }
            this.h.zzf(this.i);
        }
    }

    public final synchronized void g() {
        hd2.B.j.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            Iterator it = this.e.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (jCurrentTimeMillis - ((ob2) entry.getValue()).a.longValue() <= this.b) {
                    break;
                }
                this.g.add(new Pair((String) entry.getKey(), ((ob2) entry.getValue()).b));
                it.remove();
            }
        } catch (ConcurrentModificationException e) {
            hd2.B.g.zzw(e, "QueryJsonMap.removeExpiredEntries");
        }
    }
}
