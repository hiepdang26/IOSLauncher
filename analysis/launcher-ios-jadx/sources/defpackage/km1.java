package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzauo;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdx;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzffk;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzgcu;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class km1 {
    public final Context a;
    public final WebView b;
    public final zzauo c;
    public final zzffk d;
    public final int e;
    public final zzdsp f;
    public final boolean g;
    public final zzgcu h = zzbzo.zze;
    public final zzfll i;
    public final m92 j;

    public km1(WebView webView, zzauo zzauoVar, zzdsp zzdspVar, zzfll zzfllVar, zzffk zzffkVar, m92 m92Var) {
        this.b = webView;
        Context context = webView.getContext();
        this.a = context;
        this.c = zzauoVar;
        this.f = zzdspVar;
        zzbbw.zza(context);
        zzbbn zzbbnVar = zzbbw.zziI;
        n42 n42Var = n42.d;
        this.e = ((Integer) n42Var.c.zza(zzbbnVar)).intValue();
        this.g = ((Boolean) n42Var.c.zza(zzbbw.zziJ)).booleanValue();
        this.i = zzfllVar;
        this.d = zzffkVar;
        this.j = m92Var;
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        try {
            hd2 hd2Var = hd2.B;
            hd2Var.j.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strZze = this.c.zzc().zze(this.a, str, this.b);
            if (!this.g) {
                return strZze;
            }
            hd2Var.j.getClass();
            wd.P(this.f, "csg", new Pair("clat", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
            return strZze;
        } catch (RuntimeException e) {
            k92.f();
            hd2.B.g.zzw(e, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    public String getClickSignalsWithTimeout(String str, int i) {
        if (i <= 0) {
            k92.e("Invalid timeout for getting click signals. Timeout=" + i);
            return "";
        }
        try {
            return (String) zzbzo.zza.zzb(new p42(this, str, 0)).get(Math.min(i, this.e), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            k92.f();
            hd2.B.g.zzw(e, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            return e instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    public String getQueryInfo() {
        cd2 cd2Var = hd2.B.c;
        String string = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        w42 w42Var = new w42(this, string);
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            this.j.b(this.b, w42Var);
            return string;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zziL)).booleanValue()) {
            this.h.execute(new xm(this, bundle, w42Var, 15));
            return string;
        }
        nx0 nx0Var = new nx0(2);
        nx0Var.q(bundle);
        e41.a(this.a, new s2(nx0Var), w42Var);
        return string;
    }

    @JavascriptInterface
    public String getViewSignals() {
        try {
            hd2 hd2Var = hd2.B;
            hd2Var.j.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strZzh = this.c.zzc().zzh(this.a, this.b, null);
            if (!this.g) {
                return strZzh;
            }
            hd2Var.j.getClass();
            wd.P(this.f, "vsg", new Pair("vlat", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
            return strZzh;
        } catch (RuntimeException e) {
            k92.f();
            hd2.B.g.zzw(e, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    @JavascriptInterface
    public String getViewSignalsWithTimeout(int i) {
        if (i <= 0) {
            k92.e("Invalid timeout for getting view signals. Timeout=" + i);
            return "";
        }
        try {
            return (String) zzbzo.zza.zzb(new sv(this, 3)).get(Math.min(i, this.e), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            k92.f();
            hd2.B.g.zzw(e, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            return e instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    public void recordClick(String str) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zziN)).booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        zzbzo.zza.execute(new el0(this, str, 24));
    }

    @JavascriptInterface
    public void reportTouchEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("x");
            int i2 = jSONObject.getInt("y");
            int i3 = jSONObject.getInt("duration_ms");
            float f = (float) jSONObject.getDouble("force");
            int i4 = jSONObject.getInt("type");
            try {
                this.c.zzd(MotionEvent.obtain(0L, i3, i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 3 ? -1 : 3 : 2 : 1 : 0, i, i2, f, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            } catch (RuntimeException e) {
                e = e;
                k92.f();
                hd2.B.g.zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
            } catch (JSONException e2) {
                e = e2;
                k92.f();
                hd2.B.g.zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
            }
        } catch (RuntimeException | JSONException e3) {
            e = e3;
        }
    }
}
