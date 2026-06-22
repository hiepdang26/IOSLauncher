package defpackage;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class jo1 {
    public final lo1 a;

    public jo1(lo1 lo1Var) {
        this.a = lo1Var;
    }

    public static final jo1 a(Context context) {
        ho1 ho1Var;
        qg0.l(context, "context");
        int i = Build.VERSION.SDK_INT;
        t2 t2Var = t2.a;
        if ((i >= 30 ? t2Var.a() : 0) >= 5) {
            Object systemService = context.getSystemService((Class<Object>) o7.u());
            qg0.k(systemService, "context.getSystemService…opicsManager::class.java)");
            ho1Var = new ho1(o7.k(systemService), 1);
        } else {
            if ((i >= 30 ? t2Var.a() : 0) == 4) {
                Object systemService2 = context.getSystemService((Class<Object>) o7.u());
                qg0.k(systemService2, "context.getSystemService…opicsManager::class.java)");
                ho1Var = new ho1(o7.k(systemService2), 0);
            } else {
                ho1Var = null;
            }
        }
        if (ho1Var != null) {
            return new jo1(ho1Var);
        }
        return null;
    }

    public do0 b(j80 j80Var) {
        qg0.l(j80Var, "request");
        xt xtVar = aw.a;
        return np1.a(np1.b(m90.a(kq0.a), new io1(this, j80Var, null)));
    }
}
