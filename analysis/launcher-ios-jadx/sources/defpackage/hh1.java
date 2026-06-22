package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.a;
import androidx.savedstate.Recreator;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class hh1 {
    public static volatile hh1 e;
    public final /* synthetic */ int a;
    public Object b;
    public boolean c;
    public final Object d;

    public hh1(int i) {
        this.a = i;
        switch (i) {
            case 3:
                this.d = new Object();
                break;
            default:
                this.d = Collections.newSetFromMap(new WeakHashMap());
                this.b = new HashSet();
                break;
        }
    }

    public static hh1 b(Context context) {
        if (e == null) {
            synchronized (hh1.class) {
                try {
                    if (e == null) {
                        e = new hh1(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public boolean a(ha1 ha1Var) {
        boolean z = true;
        if (ha1Var == null) {
            return true;
        }
        boolean zRemove = ((Set) this.d).remove(ha1Var);
        if (!((HashSet) this.b).remove(ha1Var) && !zRemove) {
            z = false;
        }
        if (z) {
            ha1Var.clear();
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [en0, java.lang.Object, od1] */
    public void c() {
        ?? r0 = this.d;
        a aVarL = r0.l();
        if (aVarL.c != vm0.h) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        aVarL.a(new Recreator(r0));
        nd1 nd1Var = (nd1) this.b;
        nd1Var.getClass();
        if (nd1Var.b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        aVarL.a(new jt0(nd1Var, 1));
        nd1Var.b = true;
        this.c = true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [en0, java.lang.Object] */
    public void d(Bundle bundle) {
        if (!this.c) {
            c();
        }
        a aVarL = this.d.l();
        if (aVarL.c.compareTo(vm0.j) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + aVarL.c).toString());
        }
        nd1 nd1Var = (nd1) this.b;
        if (!nd1Var.b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (nd1Var.d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        nd1Var.c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        nd1Var.d = true;
    }

    public void e(Bundle bundle) {
        nd1 nd1Var = (nd1) this.b;
        nd1Var.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = nd1Var.c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        gd1 gd1Var = nd1Var.a;
        gd1Var.getClass();
        ed1 ed1Var = new ed1(gd1Var);
        gd1Var.i.put(ed1Var, Boolean.FALSE);
        while (ed1Var.hasNext()) {
            Map.Entry entry = (Map.Entry) ed1Var.next();
            bundle2.putBundle((String) entry.getKey(), ((md1) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void f(b82 b82Var) {
        synchronized (this.d) {
            try {
                if (((ArrayDeque) this.b) == null) {
                    this.b = new ArrayDeque();
                }
                ((ArrayDeque) this.b).add(b82Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g(pm1 pm1Var) {
        b82 b82Var;
        synchronized (this.d) {
            if (((ArrayDeque) this.b) != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.d) {
                        try {
                            b82Var = (b82) ((ArrayDeque) this.b).poll();
                            if (b82Var == null) {
                                this.c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    b82Var.f(pm1Var);
                }
            }
        }
    }

    public String toString() {
        switch (this.a) {
            case 1:
                return super.toString() + "{numRequests=" + ((Set) this.d).size() + ", isPaused=" + this.c + "}";
            default:
                return super.toString();
        }
    }

    public hh1(od1 od1Var) {
        this.a = 2;
        this.d = od1Var;
        this.b = new nd1();
    }

    public hh1(Context context) {
        Object gh1Var;
        this.a = 0;
        this.b = new HashSet();
        zn znVar = new zn(new iv(context, 3));
        ch1 ch1Var = new ch1(this);
        if (Build.VERSION.SDK_INT >= 24) {
            gh1Var = new uv(znVar, ch1Var);
        } else {
            gh1Var = new gh1(context, znVar, ch1Var);
        }
        this.d = gh1Var;
    }
}
