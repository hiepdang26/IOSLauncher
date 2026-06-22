package defpackage;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdq;
import com.google.android.gms.internal.ads.zzblr;

/* JADX INFO: loaded from: classes.dex */
public abstract class og0 {
    public static void load(Context context, String str, s2 s2Var, pg0 pg0Var) {
        hg0.j(context, "Context cannot be null.");
        hg0.j(str, "AdUnitId cannot be null.");
        hg0.j(s2Var, "AdRequest cannot be null.");
        hg0.j(pg0Var, "LoadCallback cannot be null.");
        hg0.g("#008 Must be called on the main UI thread.");
        zzbbw.zza(context);
        if (((Boolean) zzbdq.zzi.zze()).booleanValue()) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkl)).booleanValue()) {
                k42.b.execute(new ng(context, str, s2Var, pg0Var, 13, false));
                return;
            }
        }
        new zzblr(context, str).zza(s2Var.a, pg0Var);
    }

    public abstract wb1 getResponseInfo();

    public abstract void setFullScreenContentCallback(a70 a70Var);

    public abstract void setImmersiveMode(boolean z);

    public abstract void show(Activity activity);
}
