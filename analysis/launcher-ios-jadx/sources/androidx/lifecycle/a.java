package androidx.lifecycle;

import android.os.Looper;
import defpackage.an0;
import defpackage.dd1;
import defpackage.dn0;
import defpackage.en0;
import defpackage.f80;
import defpackage.fn0;
import defpackage.in0;
import defpackage.q20;
import defpackage.qg0;
import defpackage.rt;
import defpackage.sm0;
import defpackage.u8;
import defpackage.um0;
import defpackage.uo;
import defpackage.vm0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final boolean a;
    public q20 b;
    public vm0 c;
    public final WeakReference d;
    public int e;
    public boolean f;
    public boolean g;
    public final ArrayList h;

    public a(en0 en0Var) {
        new AtomicReference();
        this.a = true;
        this.b = new q20();
        this.c = vm0.h;
        this.h = new ArrayList();
        this.d = new WeakReference(en0Var);
    }

    public final void a(dn0 dn0Var) {
        an0 reflectiveGenericLifecycleObserver;
        Object obj;
        en0 en0Var;
        ArrayList arrayList = this.h;
        c("addObserver");
        vm0 vm0Var = this.c;
        vm0 vm0Var2 = vm0.g;
        if (vm0Var != vm0Var2) {
            vm0Var2 = vm0.h;
        }
        fn0 fn0Var = new fn0();
        HashMap map = in0.a;
        boolean z = dn0Var instanceof an0;
        boolean z2 = dn0Var instanceof rt;
        if (z && z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((rt) dn0Var, (an0) dn0Var);
        } else if (z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((rt) dn0Var, null);
        } else if (z) {
            reflectiveGenericLifecycleObserver = (an0) dn0Var;
        } else {
            Class<?> cls = dn0Var.getClass();
            if (in0.c(cls) == 2) {
                Object obj2 = in0.b.get(cls);
                qg0.h(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    in0.a((Constructor) list.get(0), dn0Var);
                    throw null;
                }
                int size = list.size();
                f80[] f80VarArr = new f80[size];
                if (size > 0) {
                    in0.a((Constructor) list.get(0), dn0Var);
                    throw null;
                }
                reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(f80VarArr);
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(dn0Var);
            }
        }
        fn0Var.b = reflectiveGenericLifecycleObserver;
        fn0Var.a = vm0Var2;
        q20 q20Var = this.b;
        dd1 dd1VarA = q20Var.a(dn0Var);
        if (dd1VarA != null) {
            obj = dd1VarA.h;
        } else {
            HashMap map2 = q20Var.k;
            dd1 dd1Var = new dd1(dn0Var, fn0Var);
            q20Var.j++;
            dd1 dd1Var2 = q20Var.h;
            if (dd1Var2 == null) {
                q20Var.g = dd1Var;
                q20Var.h = dd1Var;
            } else {
                dd1Var2.i = dd1Var;
                dd1Var.j = dd1Var2;
                q20Var.h = dd1Var;
            }
            map2.put(dn0Var, dd1Var);
            obj = null;
        }
        if (((fn0) obj) == null && (en0Var = (en0) this.d.get()) != null) {
            boolean z3 = this.e != 0 || this.f;
            vm0 vm0VarB = b(dn0Var);
            this.e++;
            while (fn0Var.a.compareTo(vm0VarB) < 0 && this.b.k.containsKey(dn0Var)) {
                arrayList.add(fn0Var.a);
                sm0 sm0Var = um0.Companion;
                vm0 vm0Var3 = fn0Var.a;
                sm0Var.getClass();
                qg0.l(vm0Var3, "state");
                int iOrdinal = vm0Var3.ordinal();
                um0 um0Var = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : um0.ON_RESUME : um0.ON_START : um0.ON_CREATE;
                if (um0Var == null) {
                    throw new IllegalStateException("no event up from " + fn0Var.a);
                }
                fn0Var.a(en0Var, um0Var);
                arrayList.remove(arrayList.size() - 1);
                vm0VarB = b(dn0Var);
            }
            if (!z3) {
                h();
            }
            this.e--;
        }
    }

    public final vm0 b(dn0 dn0Var) {
        HashMap map = this.b.k;
        dd1 dd1Var = map.containsKey(dn0Var) ? ((dd1) map.get(dn0Var)).j : null;
        vm0 vm0Var = dd1Var != null ? ((fn0) dd1Var.h).a : null;
        ArrayList arrayList = this.h;
        vm0 vm0Var2 = arrayList.isEmpty() ? null : (vm0) arrayList.get(arrayList.size() - 1);
        vm0 vm0Var3 = this.c;
        qg0.l(vm0Var3, "state1");
        if (vm0Var == null || vm0Var.compareTo(vm0Var3) >= 0) {
            vm0Var = vm0Var3;
        }
        return (vm0Var2 == null || vm0Var2.compareTo(vm0Var) >= 0) ? vm0Var : vm0Var2;
    }

    public final void c(String str) {
        if (this.a) {
            u8.u().l.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(uo.t("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void d(um0 um0Var) {
        qg0.l(um0Var, "event");
        c("handleLifecycleEvent");
        e(um0Var.a());
    }

    public final void e(vm0 vm0Var) {
        vm0 vm0Var2 = this.c;
        if (vm0Var2 == vm0Var) {
            return;
        }
        vm0 vm0Var3 = vm0.h;
        vm0 vm0Var4 = vm0.g;
        if (vm0Var2 == vm0Var3 && vm0Var == vm0Var4) {
            throw new IllegalStateException(("no event down from " + this.c + " in component " + this.d.get()).toString());
        }
        this.c = vm0Var;
        if (this.f || this.e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        h();
        this.f = false;
        if (this.c == vm0Var4) {
            this.b = new q20();
        }
    }

    public final void f(dn0 dn0Var) {
        qg0.l(dn0Var, "observer");
        c("removeObserver");
        this.b.b(dn0Var);
    }

    public final void g() {
        vm0 vm0Var = vm0.i;
        c("setCurrentState");
        e(vm0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r12.g = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.a.h():void");
    }
}
