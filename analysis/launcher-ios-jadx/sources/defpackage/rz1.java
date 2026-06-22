package defpackage;

import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class rz1 {
    public final ow1 a;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final Object d = new Object();

    static {
        ka0.r("WorkTimer");
    }

    public rz1(ow1 ow1Var) {
        this.a = ow1Var;
    }

    public final void a(zy1 zy1Var) {
        synchronized (this.d) {
            try {
                if (((qz1) this.b.remove(zy1Var)) != null) {
                    ka0 ka0VarJ = ka0.j();
                    Objects.toString(zy1Var);
                    ka0VarJ.getClass();
                    this.c.remove(zy1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
