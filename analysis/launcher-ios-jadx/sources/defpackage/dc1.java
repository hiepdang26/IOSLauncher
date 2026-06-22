package defpackage;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdq;
import com.google.android.gms.internal.ads.zzbwp;

/* JADX INFO: loaded from: classes.dex */
public abstract class dc1 {
    public static void load(Context context, String str, s2 s2Var, ec1 ec1Var) {
        hg0.j(context, "Context cannot be null.");
        hg0.j(str, "AdUnitId cannot be null.");
        hg0.j(s2Var, "AdRequest cannot be null.");
        hg0.j(ec1Var, "LoadCallback cannot be null.");
        hg0.g("#008 Must be called on the main UI thread.");
        zzbbw.zza(context);
        if (((Boolean) zzbdq.zzk.zze()).booleanValue()) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkl)).booleanValue()) {
                k42.b.execute(new ng(context, str, s2Var, ec1Var, 16, false));
                return;
            }
        }
        k92.d("Loading on UI thread");
        new zzbwp(context, str).zza(s2Var.a, ec1Var);
    }

    public abstract wb1 getResponseInfo();

    public abstract void show(Activity activity, kz0 kz0Var);

    public static void load(Context context, String str, n2 n2Var, ec1 ec1Var) {
        hg0.j(context, "Context cannot be null.");
        hg0.j(str, "AdUnitId cannot be null.");
        hg0.j(n2Var, "AdManagerAdRequest cannot be null.");
        throw null;
    }
}
