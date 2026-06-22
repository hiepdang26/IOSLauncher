package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzaop;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzaqo;
import com.google.android.gms.internal.ads.zzbbw;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l52 {
    public static zzapk a;
    public static final Object b = new Object();

    public l52(Context context) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (b) {
            try {
                if (a == null) {
                    zzbbw.zza(context);
                    a = ((Boolean) n42.d.c.zza(zzbbw.zzdW)).booleanValue() ? z32.a(context) : zzaqo.zza(context, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static g52 a(int i, String str, HashMap map, byte[] bArr) {
        g52 g52Var = new g52();
        b52 b52Var = new b52(str, g52Var);
        ub2 ub2Var = new ub2();
        e52 e52Var = new e52(i, str, g52Var, b52Var, bArr, map, ub2Var);
        if (ub2.c()) {
            try {
                Map mapZzl = e52Var.zzl();
                byte[] bArr2 = bArr == null ? null : bArr;
                if (ub2.c()) {
                    ub2Var.d("onNetworkRequest", new ol1(str, "GET", mapZzl, bArr2));
                }
            } catch (zzaop e) {
                k92.h(e.getMessage());
            }
        }
        a.zza(e52Var);
        return g52Var;
    }
}
