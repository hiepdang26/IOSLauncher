package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbu;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbcx;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdx;
import com.google.android.gms.internal.ads.zzbtc;
import com.google.android.gms.internal.ads.zzbtl;
import com.google.android.gms.internal.ads.zzbyl;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcgj;
import com.google.android.gms.internal.ads.zzdoa;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.gms.internal.ads.zzfgf;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzfki;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzful;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.android.gms.internal.ads.zzgca;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.android.gms.internal.ads.zzgcu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class y22 extends zzbyl {
    public static final ArrayList L = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    public static final ArrayList M = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    public static final ArrayList N = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
    public static final ArrayList O = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    public String A;
    public final String B;
    public final ArrayList C;
    public final ArrayList D;
    public final ArrayList E;
    public final ArrayList F;
    public final zzbcx J;
    public final m92 K;
    public final zzcgj g;
    public Context h;
    public final zzauo i;
    public final zzffk j;
    public final zzfgf k;
    public final zzgcu l;
    public final ScheduledExecutorService m;
    public zzbtl n;
    public final zzdsp q;
    public final zzfll r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public final String w;
    public final String x;
    public final or1 z;
    public Point o = new Point();
    public Point p = new Point();
    public final AtomicInteger y = new AtomicInteger(0);
    public final AtomicBoolean G = new AtomicBoolean(false);
    public final AtomicBoolean H = new AtomicBoolean(false);
    public final AtomicInteger I = new AtomicInteger(0);

    public y22(zzcgj zzcgjVar, Context context, zzauo zzauoVar, zzfgf zzfgfVar, zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, zzdsp zzdspVar, zzfll zzfllVar, or1 or1Var, zzbcx zzbcxVar, zzffk zzffkVar, m92 m92Var) {
        ArrayList arrayListW;
        this.g = zzcgjVar;
        this.h = context;
        this.i = zzauoVar;
        this.j = zzffkVar;
        this.k = zzfgfVar;
        this.l = zzgcuVar;
        this.m = scheduledExecutorService;
        this.q = zzdspVar;
        this.r = zzfllVar;
        this.z = or1Var;
        this.J = zzbcxVar;
        zzbbn zzbbnVar = zzbbw.zzgx;
        n42 n42Var = n42.d;
        this.s = ((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue();
        zzbbn zzbbnVar2 = zzbbw.zzgw;
        zzbbu zzbbuVar = n42Var.c;
        this.t = ((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue();
        this.u = ((Boolean) zzbbuVar.zza(zzbbw.zzgz)).booleanValue();
        this.v = ((Boolean) zzbbuVar.zza(zzbbw.zzgB)).booleanValue();
        this.w = (String) zzbbuVar.zza(zzbbw.zzgA);
        this.x = (String) zzbbuVar.zza(zzbbw.zzgC);
        this.B = (String) zzbbuVar.zza(zzbbw.zzgD);
        this.K = m92Var;
        if (((Boolean) zzbbuVar.zza(zzbbw.zzgE)).booleanValue()) {
            this.C = w((String) zzbbuVar.zza(zzbbw.zzgF));
            this.D = w((String) zzbbuVar.zza(zzbbw.zzgG));
            this.E = w((String) zzbbuVar.zza(zzbbw.zzgH));
            arrayListW = w((String) zzbbuVar.zza(zzbbw.zzgI));
        } else {
            this.C = L;
            this.D = M;
            this.E = N;
            arrayListW = O;
        }
        this.F = arrayListW;
    }

    public static boolean u(Uri uri, ArrayList arrayList, ArrayList arrayList2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (path.contains((String) obj)) {
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        if (host.endsWith((String) obj2)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final Uri v(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl=");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl=");
        }
        if (iIndexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = iIndexOf + 1;
        return Uri.parse(string.substring(0, i) + str + "=" + str2 + "&" + string.substring(i));
    }

    public static final ArrayList w(String str) {
        String[] strArrSplit = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            if (!zzfvj.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static zzfkf x(do0 do0Var, zzbyq zzbyqVar) {
        if (!zzfki.zza() || !((Boolean) zzbdl.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfkf zzfkfVarZza = ((zc2) zzgcj.zzp(do0Var)).zza();
            zzfkfVarZza.zzd(new ArrayList(Collections.singletonList(zzbyqVar.zzb)));
            tb2 tb2Var = zzbyqVar.zzd;
            zzfkfVarZza.zzb(tb2Var == null ? "" : tb2Var.v);
            zzfkfVarZza.zzf(zzbyqVar.zzd.s);
            return zzfkfVarZza;
        } catch (ExecutionException e) {
            hd2.B.g.zzw(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.zc2 f(android.content.Context r41, java.lang.String r42, java.lang.String r43, defpackage.rc2 r44, defpackage.tb2 r45, android.os.Bundle r46) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y22.f(android.content.Context, java.lang.String, java.lang.String, rc2, tb2, android.os.Bundle):zc2");
    }

    public final do0 p(final String str) {
        final zzdoa[] zzdoaVarArr = new zzdoa[1];
        do0 do0VarZza = this.k.zza();
        zzgbq zzgbqVar = new zzgbq() { // from class: jd2
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) throws JSONException {
                zzdoa zzdoaVar = (zzdoa) obj;
                y22 y22Var = this.a;
                y22Var.getClass();
                zzdoaVarArr[0] = zzdoaVar;
                Context context = y22Var.h;
                zzbtl zzbtlVar = y22Var.n;
                Map map = zzbtlVar.zzb;
                JSONObject jSONObjectS = z71.s(context, map, map, zzbtlVar.zza, null);
                JSONObject jSONObjectV = z71.v(y22Var.h, y22Var.n.zza);
                JSONObject jSONObjectU = z71.u(y22Var.n.zza);
                JSONObject jSONObjectT = z71.t(y22Var.h, y22Var.n.zza);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("asset_view_signal", jSONObjectS);
                jSONObject.put("ad_view_signal", jSONObjectV);
                jSONObject.put("scroll_view_signal", jSONObjectU);
                jSONObject.put("lock_screen_signal", jSONObjectT);
                String str2 = str;
                if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str2)) {
                    jSONObject.put("click_signal", z71.r(null, y22Var.h, y22Var.p, y22Var.o));
                }
                return zzdoaVar.zzg(str2, jSONObject);
            }
        };
        zzgcu zzgcuVar = this.l;
        do0 do0VarZzn = zzgcj.zzn(do0VarZza, zzgbqVar, zzgcuVar);
        do0VarZzn.addListener(new gb2(this, zzdoaVarArr, 6), zzgcuVar);
        final int i = 0;
        do0 do0VarZzm = zzgcj.zzm((zzgca) zzgcj.zzo(zzgca.zzu(do0VarZzn), ((Integer) n42.d.c.zza(zzbbw.zzgP)).intValue(), TimeUnit.MILLISECONDS, this.m), new zzful() { // from class: l22
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                switch (i) {
                    case 0:
                        ArrayList arrayList = y22.L;
                        return ((JSONObject) obj).optString("nas");
                    default:
                        ArrayList arrayList2 = y22.L;
                        k92.f();
                        return null;
                }
            }
        }, zzgcuVar);
        final int i2 = 1;
        return zzgcj.zze(do0VarZzm, Exception.class, new zzful() { // from class: l22
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                switch (i2) {
                    case 0:
                        ArrayList arrayList = y22.L;
                        return ((JSONObject) obj).optString("nas");
                    default:
                        ArrayList arrayList2 = y22.L;
                        k92.f();
                        return null;
                }
            }
        }, zzgcuVar);
    }

    public final void q() {
        y22 y22Var;
        do0 do0VarZzb;
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            m92 m92Var = this.K;
            synchronized (m92Var) {
                m92Var.c(true);
                m92Var.c(false);
            }
            return;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzkg)).booleanValue()) {
            do0VarZzb = zzgcj.zzk(new w22(this), zzbzo.zza);
            y22Var = this;
        } else {
            y22Var = this;
            do0VarZzb = y22Var.f(this.h, null, "BANNER", null, null, new Bundle()).zzb();
        }
        zzgcj.zzr(do0VarZzb, new w22(this), y22Var.g.zzB());
    }

    public final void r() {
        zzbbn zzbbnVar = zzbbw.zziH;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            if (((Boolean) n42Var.c.zza(zzbbw.zziK)).booleanValue()) {
                return;
            }
            if (((Boolean) n42Var.c.zza(zzbbw.zziO)).booleanValue() && this.G.getAndSet(true)) {
                return;
            }
            q();
        }
    }

    public final void s(List list, he0 he0Var, zzbtc zzbtcVar, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        do0 do0VarZzn;
        Map map;
        if (!((Boolean) n42.d.c.zza(zzbbw.zzgO)).booleanValue()) {
            k92.h("The updating URL feature is not enabled.");
            try {
                zzbtcVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException unused) {
                k92.f();
                return;
            }
        }
        Iterator it = list.iterator();
        int i = 0;
        while (true) {
            boolean zHasNext = it.hasNext();
            arrayList = this.D;
            arrayList2 = this.C;
            if (!zHasNext) {
                break;
            } else if (u((Uri) it.next(), arrayList2, arrayList)) {
                i++;
            }
        }
        if (i > 1) {
            k92.h("Multiple google urls found: ".concat(String.valueOf(list)));
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Uri uri = (Uri) it2.next();
            if (u(uri, arrayList2, arrayList)) {
                f22 f22Var = new f22(this, uri, he0Var, 3);
                zzgcu zzgcuVar = this.l;
                do0 do0VarZzb = zzgcuVar.zzb(f22Var);
                zzbtl zzbtlVar = this.n;
                if (zzbtlVar == null || (map = zzbtlVar.zzb) == null || map.isEmpty()) {
                    k92.g("Asset view map is empty.");
                    do0VarZzn = do0VarZzb;
                } else {
                    do0VarZzn = zzgcj.zzn(do0VarZzb, new s22(this, 1), zzgcuVar);
                }
            } else {
                k92.h("Not a Google URL: ".concat(String.valueOf(uri)));
                do0VarZzn = zzgcj.zzh(uri);
            }
            arrayList3.add(do0VarZzn);
        }
        zzgcj.zzr(zzgcj.zzd(arrayList3), new u22(this, zzbtcVar, z, 1), this.g.zzB());
    }

    public final void t(List list, he0 he0Var, zzbtc zzbtcVar, boolean z) {
        Map map;
        if (!((Boolean) n42.d.c.zza(zzbbw.zzgO)).booleanValue()) {
            try {
                zzbtcVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException unused) {
                k92.f();
                return;
            }
        }
        f22 f22Var = new f22(this, list, he0Var, 1);
        zzgcu zzgcuVar = this.l;
        do0 do0VarZzb = zzgcuVar.zzb(f22Var);
        zzbtl zzbtlVar = this.n;
        if (zzbtlVar == null || (map = zzbtlVar.zzb) == null || map.isEmpty()) {
            k92.g("Asset view map is empty.");
        } else {
            do0VarZzb = zzgcj.zzn(do0VarZzb, new s22(this, 0), zzgcuVar);
        }
        zzgcj.zzr(do0VarZzb, new u22(this, zzbtcVar, z, 0), this.g.zzB());
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final he0 zze(he0 he0Var, he0 he0Var2, String str, he0 he0Var3) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zziR)).booleanValue()) {
            return new gy0(null);
        }
        Context context = (Context) gy0.r(he0Var);
        lr lrVar = (lr) gy0.r(he0Var2);
        hr hrVar = (hr) gy0.r(he0Var3);
        zzbcx zzbcxVar = this.J;
        zzbcxVar.zzg(context, lrVar, str, hrVar);
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            m92 m92Var = this.K;
            synchronized (m92Var) {
                m92Var.c(true);
                m92Var.c(false);
            }
        }
        return new gy0(zzbcxVar.zzb());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009c  */
    @Override // com.google.android.gms.internal.ads.zzbym
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf(defpackage.he0 r9, com.google.android.gms.internal.ads.zzbyq r10, com.google.android.gms.internal.ads.zzbyj r11) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y22.zzf(he0, com.google.android.gms.internal.ads.zzbyq, com.google.android.gms.internal.ads.zzbyj):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzg(zzbtl zzbtlVar) {
        this.n = zzbtlVar;
        this.k.zzc(1);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzh(List list, he0 he0Var, zzbtc zzbtcVar) {
        s(list, he0Var, zzbtcVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzi(List list, he0 he0Var, zzbtc zzbtcVar) {
        t(list, he0Var, zzbtcVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzj(he0 he0Var) {
        zzbbn zzbbnVar = zzbbw.zziG;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            zzbbn zzbbnVar2 = zzbbw.zzgM;
            zzbbu zzbbuVar = n42Var.c;
            if (!((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue()) {
                r();
            }
            WebView webView = (WebView) gy0.r(he0Var);
            if (webView == null) {
                k92.e("The webView cannot be null.");
                return;
            }
            webView.addJavascriptInterface(new km1(webView, this.i, this.q, this.r, this.j, this.K), "gmaSdk");
            if (((Boolean) zzbbuVar.zza(zzbbw.zziQ)).booleanValue()) {
                hd2.B.g.zzs();
            }
            if (((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue()) {
                r();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzk(he0 he0Var) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzgO)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) gy0.r(he0Var);
            zzbtl zzbtlVar = this.n;
            View view = zzbtlVar == null ? null : zzbtlVar.zza;
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationOnScreen(iArr);
            }
            this.o = new Point(((int) motionEvent.getRawX()) - iArr[0], ((int) motionEvent.getRawY()) - iArr[1]);
            if (motionEvent.getAction() == 0) {
                this.p = this.o;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            Point point = this.o;
            motionEventObtain.setLocation(point.x, point.y);
            this.i.zzd(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzl(List list, he0 he0Var, zzbtc zzbtcVar) {
        s(list, he0Var, zzbtcVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzm(List list, he0 he0Var, zzbtc zzbtcVar) {
        t(list, he0Var, zzbtcVar, false);
    }
}
