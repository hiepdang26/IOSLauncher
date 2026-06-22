package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdq;
import com.google.android.gms.internal.ads.zzbte;

/* JADX INFO: loaded from: classes.dex */
public final class e41 {
    public final pw1 a;

    public e41(pw1 pw1Var) {
        this.a = pw1Var;
    }

    public static void a(Context context, s2 s2Var, f41 f41Var) {
        i2 i2Var = i2.g;
        zzbbw.zza(context);
        if (((Boolean) zzbdq.zzj.zze()).booleanValue()) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkl)).booleanValue()) {
                k42.b.execute(new xm(context, s2Var, f41Var));
                return;
            }
        }
        new zzbte(context, i2Var, s2Var.a, null).zzb(f41Var);
    }
}
