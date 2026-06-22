package com.bumptech.glide.manager;

import android.content.Context;
import defpackage.gn0;
import defpackage.h60;
import defpackage.ka0;
import defpackage.sa1;
import defpackage.ua1;
import defpackage.vq1;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final HashMap a = new HashMap();
    public final ua1 b;

    public a(ua1 ua1Var) {
        this.b = ua1Var;
    }

    public final sa1 a(Context context, com.bumptech.glide.a aVar, androidx.lifecycle.a aVar2, h60 h60Var, boolean z) {
        vq1.a();
        vq1.a();
        HashMap map = this.a;
        sa1 sa1Var = (sa1) map.get(aVar2);
        if (sa1Var != null) {
            return sa1Var;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(aVar2);
        sa1 sa1VarE = this.b.e(aVar, lifecycleLifecycle, new ka0(this, h60Var), context);
        map.put(aVar2, sa1VarE);
        lifecycleLifecycle.h(new gn0(this, aVar2));
        if (z) {
            sa1VarE.j();
        }
        return sa1VarE;
    }
}
