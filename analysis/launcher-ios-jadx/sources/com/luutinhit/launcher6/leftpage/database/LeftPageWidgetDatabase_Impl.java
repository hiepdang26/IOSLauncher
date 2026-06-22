package com.luutinhit.launcher6.leftpage.database;

import android.content.Context;
import defpackage.ei;
import defpackage.ks;
import defpackage.nm0;
import defpackage.qg0;
import defpackage.qm0;
import defpackage.vg0;
import defpackage.wk1;
import defpackage.xh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LeftPageWidgetDatabase_Impl extends LeftPageWidgetDatabase {
    public volatile qm0 m;

    @Override // defpackage.kc1
    public final vg0 d() {
        return new vg0(this, new HashMap(0), new HashMap(0), "LeftPageWidget");
    }

    @Override // defpackage.kc1
    public final wk1 e(ks ksVar) {
        ei eiVar = new ei(ksVar, new nm0(this), "fc241614abab42898ea133b50fc265df", "cb688170a96a1e58a794aa9c0a7d4fac");
        Context context = ksVar.a;
        qg0.l(context, "context");
        return ksVar.c.d(new xh(context, ksVar.b, eiVar, false, false));
    }

    @Override // defpackage.kc1
    public final List f(LinkedHashMap linkedHashMap) {
        return new ArrayList();
    }

    @Override // defpackage.kc1
    public final Set h() {
        return new HashSet();
    }

    @Override // defpackage.kc1
    public final Map i() {
        HashMap map = new HashMap();
        map.put(qm0.class, Collections.EMPTY_LIST);
        return map;
    }

    @Override // com.luutinhit.launcher6.leftpage.database.LeftPageWidgetDatabase
    public final qm0 p() {
        qm0 qm0Var;
        if (this.m != null) {
            return this.m;
        }
        synchronized (this) {
            try {
                if (this.m == null) {
                    this.m = new qm0(this);
                }
                qm0Var = this.m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qm0Var;
    }
}
