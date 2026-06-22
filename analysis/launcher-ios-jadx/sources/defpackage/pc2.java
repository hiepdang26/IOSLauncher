package defpackage;

import android.content.Context;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class pc2 extends ca0 implements e7 {
    public static final q11 q = new q11("AppSet.API", new q02(4), new jl1(7));
    public final Context o;
    public final ea0 p;

    public pc2(Context context, ea0 ea0Var) {
        super(context, null, q, r5.a, ba0.b);
        this.o = context;
        this.p = ea0Var;
    }

    @Override // defpackage.e7
    public final od2 a() {
        if (this.p.c(this.o, 212800000) != 0) {
            v5 v5Var = new v5(new Status(17, null, null, null));
            od2 od2Var = new od2();
            od2Var.g(v5Var);
            return od2Var;
        }
        ld ldVar = new ld();
        ldVar.d = new v20[]{os.d};
        ldVar.c = new b21(this);
        ldVar.a = false;
        ldVar.b = 27601;
        return c(0, ldVar.a());
    }
}
