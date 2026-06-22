package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbsk;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class s32 {
    public final Object a;
    public final Object b;
    public final Object c;
    public Object d;
    public Object e;
    public Object f;

    public s32(mb2 mb2Var, y92 y92Var, y92 y92Var2, zzbhc zzbhcVar, zzbsk zzbskVar) {
        this.a = mb2Var;
        this.b = y92Var;
        this.c = y92Var2;
        this.d = zzbhcVar;
        this.e = zzbskVar;
    }

    public static void a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        x32 x32Var = x32.f;
        ka2 ka2Var = x32Var.a;
        String str2 = x32Var.d.g;
        ka2Var.getClass();
        ka2.m(context, str2, bundle, new ta1(ka2Var));
    }

    public s32(Context context, String str) {
        String strConcat;
        this.a = context.getApplicationContext();
        this.b = str;
        this.c = new TreeMap();
        String packageName = context.getPackageName();
        try {
            strConcat = packageName + "-" + j02.a(context).g(0, context.getPackageName()).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            k92.f();
            strConcat = String.valueOf(packageName).concat("-missing");
        }
        this.f = strConcat;
    }
}
