package defpackage;

import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbdx;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class w42 extends f41 {
    public final /* synthetic */ String a;
    public final /* synthetic */ km1 b;

    public w42(km1 km1Var, String str) {
        this.a = str;
        this.b = km1Var;
    }

    @Override // defpackage.f41
    public final void onFailure(String str) {
        int i = 0;
        k92.h("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        Locale locale = Locale.getDefault();
        zzbdc zzbdcVar = zzbdx.zza;
        String str2 = String.format(locale, "window.postMessage({'paw_id': '%1$s', 'error': '%2$s', 'sdk_ttl_ms': %3$d}, '*');", this.a, str, Long.valueOf(((Boolean) zzbdcVar.zze()).booleanValue() ? ((Long) n42.d.c.zza(zzbbw.zziX)).longValue() : 0L));
        boolean zBooleanValue = ((Boolean) zzbdcVar.zze()).booleanValue();
        km1 km1Var = this.b;
        if (!zBooleanValue) {
            km1Var.b.evaluateJavascript(str2, null);
            return;
        }
        try {
            km1Var.h.execute(new s42(this, str2, i));
        } catch (RuntimeException e) {
            hd2.B.g.zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onFailure");
        }
    }

    @Override // defpackage.f41
    public final void onSuccess(e41 e41Var) {
        String str;
        int i = 1;
        String str2 = this.a;
        String str3 = (String) e41Var.a.g;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", str2);
            jSONObject.put("signal", str3);
            jSONObject.put("sdk_ttl_ms", ((Boolean) zzbdx.zza.zze()).booleanValue() ? ((Long) n42.d.c.zza(zzbbw.zziX)).longValue() : 0L);
            str = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", jSONObject);
        } catch (JSONException unused) {
            str = String.format(Locale.getDefault(), "window.postMessage({'paw_id': '%1$s', 'signal': '%2$s', 'sdk_ttl_ms': %3$d}, '*');", str2, (String) e41Var.a.g, Long.valueOf(((Boolean) zzbdx.zza.zze()).booleanValue() ? ((Long) n42.d.c.zza(zzbbw.zziX)).longValue() : 0L));
        }
        boolean zBooleanValue = ((Boolean) zzbdx.zza.zze()).booleanValue();
        km1 km1Var = this.b;
        if (!zBooleanValue) {
            km1Var.b.evaluateJavascript(str, null);
            return;
        }
        try {
            km1Var.h.execute(new s42(this, str, i));
        } catch (RuntimeException e) {
            hd2.B.g.zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onSuccess");
        }
    }
}
