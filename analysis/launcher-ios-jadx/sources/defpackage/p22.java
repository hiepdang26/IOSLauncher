package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p22 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ o32 h;

    public /* synthetic */ p22(o32 o32Var, int i) {
        this.g = i;
        this.h = o32Var;
    }

    private final void a() {
        o32 o32Var = this.h;
        o32Var.getClass();
        hd2 hd2Var = hd2.B;
        t92 t92Var = hd2Var.m;
        Context context = o32Var.a;
        String str = o32Var.d;
        String str2 = o32Var.e;
        t92Var.getClass();
        zzbbn zzbbnVar = zzbbw.zzei;
        n42 n42Var = n42.d;
        String strM = t92.m(context, t92Var.n(context, (String) n42Var.c.zza(zzbbnVar), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strM)) {
            k92.d("Not linked for in app preview.");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(strM.trim());
                String strOptString = jSONObject.optString("gct");
                t92Var.f = jSONObject.optString("status");
                if (((Boolean) n42Var.c.zza(zzbbw.zzip)).booleanValue()) {
                    boolean z = "0".equals((String) t92Var.f) || "2".equals((String) t92Var.f);
                    t92Var.g(z);
                    ((ib2) hd2Var.g.zzi()).a(!z ? "" : str);
                }
                synchronized (t92Var.a) {
                    t92Var.e = strOptString;
                }
                if ("2".equals((String) t92Var.f)) {
                    k92.d("Creative is not pushed for this device.");
                    t92.h("There was no creative pushed from DFP to the device.", context, false, false);
                    return;
                } else if ("1".equals((String) t92Var.f)) {
                    k92.d("The app is not linked for creative preview.");
                    t92Var.c(context, str, str2);
                    return;
                } else {
                    if ("0".equals((String) t92Var.f)) {
                        k92.d("Device is linked for in app preview.");
                        t92.h("The device is successfully linked for creative preview.", context, false, true);
                        return;
                    }
                    return;
                }
            } catch (JSONException unused) {
                k92.j(5);
            }
        }
        t92.h("In-app preview failed to load because of a system error. Please try again later.", context, true, true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                o32 o32Var = this.h;
                o32Var.c(o32Var.a);
                return;
            case 1:
                o32 o32Var2 = this.h;
                o32Var2.getClass();
                t92 t92Var = hd2.B.m;
                String str = o32Var2.d;
                String str2 = o32Var2.e;
                String str3 = o32Var2.f;
                boolean zK = t92Var.k();
                Context context = o32Var2.a;
                boolean zI = t92Var.i(context, str, str2);
                synchronized (t92Var.a) {
                    t92Var.b = zI;
                    break;
                }
                if (!t92Var.k()) {
                    t92Var.c(context, str, str2);
                    return;
                }
                if (!zK && !TextUtils.isEmpty(str3)) {
                    t92Var.e(context, str2, str3, str);
                }
                k92.d("Device is linked for debug signals.");
                t92.h("The device is successfully linked for troubleshooting.", context, false, true);
                return;
            case 2:
                o32 o32Var3 = this.h;
                o32Var3.g = 4;
                o32Var3.b();
                return;
            case 3:
                a();
                return;
            case 4:
                o32 o32Var4 = this.h;
                o32Var4.getClass();
                hd2.B.m.b(o32Var4.a);
                return;
            case 5:
                o32 o32Var5 = this.h;
                o32Var5.c(o32Var5.a);
                return;
            default:
                o32 o32Var6 = this.h;
                o32Var6.getClass();
                hd2.B.m.b(o32Var6.a);
                return;
        }
    }
}
