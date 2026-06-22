package defpackage;

import android.content.Context;
import com.google.android.gms.internal.ads.zzauh;

/* JADX INFO: loaded from: classes.dex */
public final class eh1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ Object i;

    public /* synthetic */ eh1(Object obj, boolean z, int i) {
        this.g = i;
        this.i = obj;
        this.h = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                gx0 gx0Var = (gx0) this.i;
                gx0Var.getClass();
                vq1.a();
                uv uvVar = (uv) gx0Var.b;
                boolean z = uvVar.h;
                boolean z2 = this.h;
                uvVar.h = z2;
                if (z != z2) {
                    ((ch1) uvVar.i).a(z2);
                }
                break;
            case 1:
                ((gh1) this.i).h.a(this.h);
                break;
            case 2:
                ((m92) this.i).e(this.h, false);
                break;
            default:
                boolean z3 = this.h;
                lb2 lb2Var = (lb2) this.i;
                lb2Var.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    String str = lb2Var.r.g;
                    Context context = lb2Var.p;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    zzauh.zza(str, context, z3, lb2Var.s).zzp();
                } catch (NullPointerException e) {
                    lb2Var.n.zzc(2027, System.currentTimeMillis() - jCurrentTimeMillis, e);
                }
                break;
        }
    }
}
