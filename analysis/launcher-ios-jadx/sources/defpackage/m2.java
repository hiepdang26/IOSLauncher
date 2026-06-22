package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdq;

/* JADX INFO: loaded from: classes.dex */
public final class m2 {
    public final Context a;
    public final k52 b;

    public m2(Context context, k52 k52Var) {
        this.a = context;
        this.b = k52Var;
    }

    public final void a(s2 s2Var) {
        e92 e92Var = s2Var.a;
        Context context = this.a;
        zzbbw.zza(context);
        if (((Boolean) zzbdq.zzc.zze()).booleanValue()) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkl)).booleanValue()) {
                k42.b.execute(new el0(this, e92Var, 23, false));
                return;
            }
        }
        try {
            this.b.zzg(lc2.a(context, e92Var));
        } catch (RemoteException unused) {
            k92.f();
        }
    }
}
