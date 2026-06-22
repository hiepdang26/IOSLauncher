package defpackage;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdq;
import com.google.android.gms.internal.ads.zzbxa;

/* JADX INFO: loaded from: classes.dex */
public abstract class fc1 {
    public static void load(Context context, String str, s2 s2Var, gc1 gc1Var) {
        hg0.j(context, "Context cannot be null.");
        hg0.j(str, "AdUnitId cannot be null.");
        hg0.j(s2Var, "AdRequest cannot be null.");
        hg0.j(gc1Var, "LoadCallback cannot be null.");
        hg0.g("#008 Must be called on the main UI thread.");
        zzbbw.zza(context);
        if (((Boolean) zzbdq.zzk.zze()).booleanValue()) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkl)).booleanValue()) {
                k42.b.execute(new ng(context, str, s2Var, gc1Var, 15, false));
                return;
            }
        }
        new zzbxa(context, str).zza(s2Var.a, gc1Var);
    }

    public abstract wb1 getResponseInfo();

    public abstract void show(Activity activity, kz0 kz0Var);

    public static void load(Context context, String str, n2 n2Var, gc1 gc1Var) {
        hg0.j(context, "Context cannot be null.");
        hg0.j(str, "AdUnitId cannot be null.");
        hg0.j(n2Var, "AdManagerAdRequest cannot be null.");
        throw null;
    }
}
