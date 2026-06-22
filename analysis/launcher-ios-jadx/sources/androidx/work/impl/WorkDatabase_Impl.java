package androidx.work.impl;

import android.content.Context;
import defpackage.ei;
import defpackage.fz1;
import defpackage.hu0;
import defpackage.hz1;
import defpackage.ks;
import defpackage.mz1;
import defpackage.nm0;
import defpackage.ol1;
import defpackage.oz1;
import defpackage.qg0;
import defpackage.tu;
import defpackage.v21;
import defpackage.vg0;
import defpackage.wk1;
import defpackage.xh;
import defpackage.z71;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    public volatile mz1 l;
    public volatile tu m;
    public volatile oz1 n;
    public volatile ol1 o;
    public volatile fz1 p;
    public volatile hz1 q;
    public volatile v21 r;

    @Override // defpackage.kc1
    public final vg0 d() {
        return new vg0(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // defpackage.kc1
    public final wk1 e(ks ksVar) {
        ei eiVar = new ei(ksVar, new nm0(this), "7d73d21f1bd82c9e5268b6dcf9fde2cb", "3071c8717539de5d5353f4c8cd59a032");
        Context context = ksVar.a;
        qg0.l(context, "context");
        return ksVar.c.d(new xh(context, ksVar.b, eiVar, false, false));
    }

    @Override // defpackage.kc1
    public final List f(LinkedHashMap linkedHashMap) {
        int i = 14;
        int i2 = 13;
        int i3 = 17;
        int i4 = 18;
        return Arrays.asList(new hu0(i2, i, 10), new hu0(11), new hu0(16, i3, 12), new hu0(i3, i4, i2), new hu0(i4, 19, i), new hu0(15));
    }

    @Override // defpackage.kc1
    public final Set h() {
        return new HashSet();
    }

    @Override // defpackage.kc1
    public final Map i() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(mz1.class, list);
        map.put(tu.class, list);
        map.put(oz1.class, list);
        map.put(ol1.class, list);
        map.put(fz1.class, list);
        map.put(hz1.class, list);
        map.put(v21.class, list);
        map.put(z71.class, list);
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final tu p() {
        tu tuVar;
        if (this.m != null) {
            return this.m;
        }
        synchronized (this) {
            try {
                if (this.m == null) {
                    this.m = new tu(this);
                }
                tuVar = this.m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tuVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final v21 q() {
        v21 v21Var;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new v21(this);
                }
                v21Var = this.r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return v21Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final ol1 r() {
        ol1 ol1Var;
        if (this.o != null) {
            return this.o;
        }
        synchronized (this) {
            try {
                if (this.o == null) {
                    this.o = new ol1(this);
                }
                ol1Var = this.o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ol1Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final fz1 s() {
        fz1 fz1Var;
        if (this.p != null) {
            return this.p;
        }
        synchronized (this) {
            try {
                if (this.p == null) {
                    this.p = new fz1(this);
                }
                fz1Var = this.p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fz1Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final hz1 t() {
        hz1 hz1Var;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            try {
                if (this.q == null) {
                    this.q = new hz1(this);
                }
                hz1Var = this.q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hz1Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final mz1 u() {
        mz1 mz1Var;
        if (this.l != null) {
            return this.l;
        }
        synchronized (this) {
            try {
                if (this.l == null) {
                    this.l = new mz1(this);
                }
                mz1Var = this.l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mz1Var;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final oz1 v() {
        oz1 oz1Var;
        if (this.n != null) {
            return this.n;
        }
        synchronized (this) {
            try {
                if (this.n == null) {
                    this.n = new oz1(this);
                }
                oz1Var = this.n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oz1Var;
    }
}
