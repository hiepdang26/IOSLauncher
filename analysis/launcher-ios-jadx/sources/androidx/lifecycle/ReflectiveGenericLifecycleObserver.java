package androidx.lifecycle;

import defpackage.aj;
import defpackage.an0;
import defpackage.cj;
import defpackage.dn0;
import defpackage.en0;
import defpackage.um0;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements an0 {
    public final dn0 g;
    public final aj h;

    public ReflectiveGenericLifecycleObserver(dn0 dn0Var) {
        this.g = dn0Var;
        cj cjVar = cj.c;
        Class<?> cls = dn0Var.getClass();
        aj ajVar = (aj) cjVar.a.get(cls);
        this.h = ajVar == null ? cjVar.a(cls, null) : ajVar;
    }

    @Override // defpackage.an0
    public final void a(en0 en0Var, um0 um0Var) {
        HashMap map = this.h.a;
        List list = (List) map.get(um0Var);
        dn0 dn0Var = this.g;
        aj.a(list, en0Var, um0Var, dn0Var);
        aj.a((List) map.get(um0.ON_ANY), en0Var, um0Var, dn0Var);
    }
}
