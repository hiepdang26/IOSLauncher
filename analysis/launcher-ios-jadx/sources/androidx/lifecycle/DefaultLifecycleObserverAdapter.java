package androidx.lifecycle;

import defpackage.an0;
import defpackage.en0;
import defpackage.rt;
import defpackage.st;
import defpackage.um0;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements an0 {
    public final rt g;
    public final an0 h;

    public DefaultLifecycleObserverAdapter(rt rtVar, an0 an0Var) {
        this.g = rtVar;
        this.h = an0Var;
    }

    @Override // defpackage.an0
    public final void a(en0 en0Var, um0 um0Var) {
        int i = st.a[um0Var.ordinal()];
        rt rtVar = this.g;
        if (i == 3) {
            rtVar.onResume();
        } else if (i == 7) {
            throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        an0 an0Var = this.h;
        if (an0Var != null) {
            an0Var.a(en0Var, um0Var);
        }
    }
}
