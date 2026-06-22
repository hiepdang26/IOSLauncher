package defpackage;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class x12 {
    public Boolean a;
    public boolean b;
    public final /* synthetic */ eb c;
    public final int d;
    public final Bundle e;
    public final /* synthetic */ eb f;

    public x12(eb ebVar, int i, Bundle bundle) {
        this.f = ebVar;
        Boolean bool = Boolean.TRUE;
        this.c = ebVar;
        this.a = bool;
        this.b = false;
        this.d = i;
        this.e = bundle;
    }

    public abstract void a(vl vlVar);

    public abstract boolean b();

    public final void c() {
        synchronized (this) {
            this.a = null;
        }
    }

    public final void d() {
        c();
        synchronized (this.c.zzt) {
            this.c.zzt.remove(this);
        }
    }
}
