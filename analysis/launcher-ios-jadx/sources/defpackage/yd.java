package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public abstract class yd extends fn {
    public final m6 f;

    public yd(Context context, qm0 qm0Var) {
        super(context, qm0Var);
        this.f = new m6(this, 1);
    }

    @Override // defpackage.fn
    public final void c() {
        ka0 ka0VarJ = ka0.j();
        int i = zd.a;
        ka0VarJ.getClass();
        this.b.registerReceiver(this.f, e());
    }

    @Override // defpackage.fn
    public final void d() {
        ka0 ka0VarJ = ka0.j();
        int i = zd.a;
        ka0VarJ.getClass();
        this.b.unregisterReceiver(this.f);
    }

    public abstract IntentFilter e();

    public abstract void f(Intent intent);
}
