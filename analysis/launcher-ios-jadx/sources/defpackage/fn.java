package defpackage;

import android.content.Context;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class fn {
    public final qm0 a;
    public final Context b;
    public final Object c;
    public final LinkedHashSet d;
    public Object e;

    public fn(Context context, qm0 qm0Var) {
        this.a = qm0Var;
        Context applicationContext = context.getApplicationContext();
        qg0.k(applicationContext, "context.applicationContext");
        this.b = applicationContext;
        this.c = new Object();
        this.d = new LinkedHashSet();
    }

    public abstract Object a();

    public final void b(Object obj) {
        synchronized (this.c) {
            Object obj2 = this.e;
            if (obj2 == null || !obj2.equals(obj)) {
                this.e = obj;
                ((dz1) this.a.d).execute(new wc(wj.A(this.d), this, 3));
            }
        }
    }

    public abstract void c();

    public abstract void d();
}
