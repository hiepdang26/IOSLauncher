package defpackage;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.ads.zzazx;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdq;
import com.google.android.gms.internal.ads.zzbtq;

/* JADX INFO: loaded from: classes.dex */
public abstract class c7 {
    public static final int APP_OPEN_AD_ORIENTATION_LANDSCAPE = 2;
    public static final int APP_OPEN_AD_ORIENTATION_PORTRAIT = 1;

    @Deprecated
    public static void load(final Context context, final String str, final s2 s2Var, final int i, final b7 b7Var) {
        hg0.j(context, "Context cannot be null.");
        hg0.j(str, "adUnitId cannot be null.");
        hg0.j(s2Var, "AdRequest cannot be null.");
        hg0.g("#008 Must be called on the main UI thread.");
        zzbbw.zza(context);
        if (((Boolean) zzbdq.zzd.zze()).booleanValue()) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkl)).booleanValue()) {
                k42.b.execute(new Runnable() { // from class: f42
                    @Override // java.lang.Runnable
                    public final void run() {
                        Context context2 = context;
                        int i2 = i;
                        String str2 = str;
                        s2 s2Var2 = s2Var;
                        try {
                            new zzazx(context2, str2, s2Var2.a, i2, b7Var).zza();
                        } catch (IllegalStateException e) {
                            zzbtq.zza(context2).zzh(e, "AppOpenAd.load");
                        }
                    }
                });
                return;
            }
        }
        new zzazx(context, str, s2Var.a, i, b7Var).zza();
    }

    public abstract wb1 getResponseInfo();

    public abstract void show(Activity activity);

    public static void load(Context context, String str, s2 s2Var, b7 b7Var) {
        hg0.j(context, "Context cannot be null.");
        hg0.j(str, "adUnitId cannot be null.");
        hg0.j(s2Var, "AdRequest cannot be null.");
        hg0.g("#008 Must be called on the main UI thread.");
        zzbbw.zza(context);
        if (((Boolean) zzbdq.zzd.zze()).booleanValue()) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkl)).booleanValue()) {
                k42.b.execute(new ng(context, str, s2Var, b7Var, 14, false));
                return;
            }
        }
        new zzazx(context, str, s2Var.a, 3, b7Var).zza();
    }

    @Deprecated
    public static void load(Context context, String str, n2 n2Var, int i, b7 b7Var) {
        hg0.j(context, "Context cannot be null.");
        hg0.j(str, "adUnitId cannot be null.");
        hg0.j(n2Var, "AdManagerAdRequest cannot be null.");
        throw null;
    }
}
