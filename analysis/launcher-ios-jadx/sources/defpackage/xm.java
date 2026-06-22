package defpackage;

import android.content.BroadcastReceiver;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryChargingProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$NetworkStateProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$StorageNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.internal.ads.zzbte;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzdsp;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.u;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class xm implements Runnable {
    public final /* synthetic */ int g;
    public Object h;
    public Object i;
    public Object j;

    public /* synthetic */ xm() {
        this.g = 9;
    }

    private final void a() {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(ContentProviderOperation.newDelete((Uri) this.h).build());
        int size = ((ArrayList) this.i).size();
        for (int i = 0; i < size; i++) {
            ContentValues contentValues = new ContentValues();
            Long l = (Long) ((ArrayList) this.i).get(i);
            l.longValue();
            contentValues.put("_id", l);
            contentValues.put("screenRank", Integer.valueOf(i));
            arrayList.add(ContentProviderOperation.newInsert((Uri) this.h).withValues(contentValues).build());
        }
        try {
            ((ContentResolver) this.j).applyBatch("com.luutinhit.launcherios.settings", arrayList);
            synchronized (rl0.A) {
                ArrayList arrayList2 = rl0.F;
                arrayList2.clear();
                arrayList2.addAll((ArrayList) this.i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r5v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // java.lang.Runnable
    public final void run() {
        nv1 nv1Var;
        CookieManager cookieManagerI;
        Object objCall = null;
        ?? r5 = 0;
        int i = 0;
        zAcceptThirdPartyCookies = false;
        boolean zAcceptThirdPartyCookies = false;
        switch (this.g) {
            case 0:
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.j;
                Context context = (Context) this.i;
                Intent intent = (Intent) this.h;
                try {
                    boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    ka0 ka0VarJ = ka0.j();
                    int i2 = ConstraintProxyUpdateReceiver.a;
                    ka0VarJ.getClass();
                    t01.a(context, ConstraintProxy$BatteryNotLowProxy.class, booleanExtra);
                    t01.a(context, ConstraintProxy$BatteryChargingProxy.class, booleanExtra2);
                    t01.a(context, ConstraintProxy$StorageNotLowProxy.class, booleanExtra3);
                    t01.a(context, ConstraintProxy$NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    pendingResult.finish();
                }
            case 1:
                ArrayList arrayList = (ArrayList) this.h;
                li1 li1Var = (li1) this.i;
                if (arrayList.contains(li1Var)) {
                    arrayList.remove(li1Var);
                    ((cu) this.j).getClass();
                    k31.a(li1Var.a, li1Var.c.L);
                    return;
                }
                return;
            case 2:
                ((yi0) this.h).e();
                uv uvVar = (uv) this.i;
                dv1 dv1Var = (dv1) uvVar.j;
                if (dv1Var == null) {
                    yi0 yi0Var = (yi0) this.h;
                    JSONObject jSONObject = (JSONObject) uvVar.i;
                    synchronized (yi0Var.s) {
                        nv1Var = yi0Var.t;
                        break;
                    }
                    if (nv1Var != null) {
                        int i3 = WallpaperActivity.W;
                        WallpaperActivity wallpaperActivity = nv1Var.g;
                        try {
                            jSONObject.toString();
                            ArrayList arrayList2 = wallpaperActivity.P;
                            arrayList2.clear();
                            ?? jSONArray = jSONObject.getJSONArray("list_wallpaper");
                            while (r5 < jSONArray.length()) {
                                try {
                                    JSONObject jSONObject2 = jSONArray.getJSONObject(r5);
                                    arrayList2.add(new qv1(jSONObject2.getString("url"), jSONObject2.getString("thumb")));
                                } catch (JSONException e) {
                                    e.getMessage();
                                }
                                r5++;
                            }
                            b8 b8Var = wallpaperActivity.L;
                            b8Var.k = arrayList2;
                            b8Var.f();
                            wallpaperActivity.K.g();
                        } catch (Throwable th) {
                            th.toString();
                        }
                    }
                    break;
                } else {
                    ((yi0) this.h).b(dv1Var);
                }
                if (((uv) this.i).h) {
                    ((yi0) this.h).a("intermediate-response");
                } else {
                    ((yi0) this.h).c("done");
                }
                w1 w1Var = (w1) this.j;
                if (w1Var != null) {
                    w1Var.run();
                    return;
                }
                return;
            case 3:
                qh0 qh0Var = (qh0) this.h;
                boolean z = qh0Var instanceof v6;
                oe0 oe0Var = (oe0) this.j;
                if (z) {
                    oe0Var.t((v6) qh0Var, null);
                } else if (qh0Var instanceof og1) {
                    og1 og1Var = (og1) qh0Var;
                    Intent intent2 = og1Var.H;
                    if (intent2 == null) {
                        intent2 = og1Var.x;
                    }
                    oe0Var.v(og1Var, intent2, og1Var.w, false);
                } else if (qh0Var instanceof s01) {
                    s01 s01Var = (s01) qh0Var;
                    oe0Var.w(s01Var.z, s01Var.w, false, s01Var);
                }
                oe0Var.a.execute(new o1(this, 26));
                return;
            case 4:
                a();
                return;
            case 5:
                hl0 hl0VarL = ((rl0) this.j).l();
                t tVar = (t) this.h;
                if (tVar != hl0VarL || hl0VarL == null) {
                    return;
                }
                tVar.bindWidgetsModel((qx1) this.i);
                return;
            case 6:
                hl0 hl0VarL2 = ((rl0) ((el0) this.j).i).l();
                if (hl0VarL2 != null) {
                    hl0VarL2.bindShortcutsChanged((ArrayList) this.h, new ArrayList(), (jq1) this.i);
                    return;
                }
                return;
            case 7:
                hl0 hl0VarL3 = ((u) this.j).l((hl0) this.h);
                if (hl0VarL3 != null) {
                    hl0VarL3.bindFolders((wp0) this.i);
                    return;
                }
                return;
            case 8:
                hl0 hl0VarL4 = ((u) this.j).l((hl0) this.h);
                if (hl0VarL4 != null) {
                    hl0VarL4.bindAppWidget((qk0) this.i);
                    return;
                }
                return;
            case 9:
                try {
                    objCall = ((e50) this.h).call();
                    break;
                } catch (Exception unused) {
                }
                ((Handler) this.j).post(new el0((f50) this.i, objCall, 8, r5));
                return;
            case 10:
                ((s31) this.h).k((bj1) this.i, (wb2) this.j);
                return;
            case 11:
                bx1 bx1Var = (bx1) this.j;
                try {
                    bx1Var.m = bx1Var.i.getAppWidgetHost().allocateAppWidgetId();
                    if (m7.f(bx1Var.i).a(bx1Var.m, (rk0) this.h, (Bundle) this.i)) {
                        bx1Var.j.post(bx1Var.g);
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
            case 12:
                m92 m92Var = (m92) this.h;
                m92Var.getClass();
                Object obj = this.i;
                if ((obj instanceof WebView) && (cookieManagerI = hd2.B.e.i()) != null) {
                    zAcceptThirdPartyCookies = cookieManagerI.acceptThirdPartyCookies((WebView) obj);
                }
                HashMap map = m92Var.a;
                Boolean boolValueOf = Boolean.valueOf(zAcceptThirdPartyCookies);
                ab2 ab2Var = (ab2) map.get(boolValueOf);
                Pair pair = (Pair) this.j;
                if (ab2Var != null) {
                    hd2.B.j.getClass();
                    if (ab2Var.c > System.currentTimeMillis()) {
                        m92Var.d(ab2Var, pair, true);
                        return;
                    }
                }
                HashMap map2 = m92Var.b;
                List arrayList3 = (List) map2.get(boolValueOf);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                    map2.put(boolValueOf, arrayList3);
                }
                arrayList3.add(pair);
                return;
            case 13:
                new zzbte((Context) this.i, i2.g, ((s2) this.h).a, null).zzb((f41) this.j);
                return;
            case 14:
                b42 b42Var = (b42) this.j;
                int i4 = b42Var.h;
                LifecycleCallback lifecycleCallback = (LifecycleCallback) this.h;
                if (i4 > 0) {
                    Bundle bundle = b42Var.i;
                    lifecycleCallback.d(bundle != null ? bundle.getBundle((String) this.i) : null);
                }
                if (b42Var.h >= 2) {
                    lifecycleCallback.g();
                }
                if (b42Var.h >= 3) {
                    lifecycleCallback.e();
                }
                if (b42Var.h >= 4) {
                    lifecycleCallback.h();
                    return;
                }
                return;
            case 15:
                km1 km1Var = (km1) this.h;
                CookieManager cookieManagerI2 = hd2.B.e.i();
                boolean zAcceptThirdPartyCookies2 = cookieManagerI2 != null ? cookieManagerI2.acceptThirdPartyCookies(km1Var.b) : false;
                Bundle bundle2 = (Bundle) this.i;
                bundle2.putBoolean("accept_3p_cookie", zAcceptThirdPartyCookies2);
                nx0 nx0Var = new nx0(2);
                nx0Var.q(bundle2);
                e41.a(km1Var.a, new s2(nx0Var), (w42) this.j);
                return;
            case 16:
                e82 e82Var = (e82) this.j;
                int i5 = e82Var.a0;
                LifecycleCallback lifecycleCallback2 = (LifecycleCallback) this.h;
                if (i5 > 0) {
                    Bundle bundle3 = e82Var.b0;
                    lifecycleCallback2.d(bundle3 != null ? bundle3.getBundle((String) this.i) : null);
                }
                if (e82Var.a0 >= 2) {
                    lifecycleCallback2.g();
                }
                if (e82Var.a0 >= 3) {
                    lifecycleCallback2.e();
                }
                if (e82Var.a0 >= 4) {
                    lifecycleCallback2.h();
                    return;
                }
                return;
            case 17:
                zzdsp zzdspVar = (zzdsp) this.h;
                ConcurrentHashMap concurrentHashMapZzc = zzdspVar.zzc();
                String str = (String) this.i;
                if (!TextUtils.isEmpty("action") && !TextUtils.isEmpty(str)) {
                    concurrentHashMapZzc.put("action", str);
                }
                while (true) {
                    Pair[] pairArr = (Pair[]) this.j;
                    if (i >= pairArr.length) {
                        zzdspVar.zzf(concurrentHashMapZzc);
                        return;
                    }
                    Pair pair2 = pairArr[i];
                    String str2 = (String) pair2.first;
                    String str3 = (String) pair2.second;
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        concurrentHashMapZzc.put(str2, str3);
                    }
                    i++;
                }
                break;
            default:
                zzcej zzcejVar = (zzcej) ((wc0) this.h).j;
                if (zzcejVar != null) {
                    zzcejVar.zzd((String) this.i, (HashMap) this.j);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ xm(Context context, s2 s2Var, f41 f41Var) {
        this.g = 13;
        this.i = context;
        this.h = s2Var;
        this.j = f41Var;
    }

    public /* synthetic */ xm(Object obj, Object obj2, Object obj3, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
        this.j = obj3;
    }

    public /* synthetic */ xm(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.g = i;
        this.j = obj;
        this.h = obj2;
        this.i = obj3;
    }

    public xm(s31 s31Var, bj1 bj1Var, wb2 wb2Var) {
        this.g = 10;
        qg0.l(s31Var, "processor");
        this.h = s31Var;
        this.i = bj1Var;
        this.j = wb2Var;
    }
}
