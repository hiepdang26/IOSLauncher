package androidx.lifecycle;

import android.os.Looper;
import android.view.View;
import defpackage.dd1;
import defpackage.ed1;
import defpackage.en0;
import defpackage.ev;
import defpackage.fl0;
import defpackage.gd1;
import defpackage.h60;
import defpackage.ko0;
import defpackage.lo0;
import defpackage.mc1;
import defpackage.u8;
import defpackage.uo;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final Object k = new Object();
    public final Object a = new Object();
    public final gd1 b = new gd1();
    public int c = 0;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;
    public final fl0 j;

    public b() {
        Object obj = k;
        this.f = obj;
        this.j = new fl0(this, 3);
        this.e = obj;
        this.g = -1;
    }

    public static void a(String str) {
        u8.u().l.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(uo.t("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(lo0 lo0Var) {
        if (lo0Var.h) {
            if (!lo0Var.d()) {
                lo0Var.b(false);
                return;
            }
            int i = lo0Var.i;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            lo0Var.i = i2;
            mc1 mc1Var = lo0Var.g;
            Object obj = this.e;
            mc1Var.getClass();
            if (((en0) obj) != null) {
                ev evVar = (ev) mc1Var.h;
                if (evVar.e0) {
                    View viewO = evVar.O();
                    if (viewO.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    if (evVar.i0 != null) {
                        if (h60.E(3)) {
                            Objects.toString(evVar.i0);
                        }
                        evVar.i0.setContentView(viewO);
                    }
                }
            }
        }
    }

    public final void c(lo0 lo0Var) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (lo0Var != null) {
                b(lo0Var);
                lo0Var = null;
            } else {
                gd1 gd1Var = this.b;
                gd1Var.getClass();
                ed1 ed1Var = new ed1(gd1Var);
                gd1Var.i.put(ed1Var, Boolean.FALSE);
                while (ed1Var.hasNext()) {
                    b((lo0) ((Map.Entry) ed1Var.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public final void d(mc1 mc1Var) {
        Object obj;
        a("observeForever");
        ko0 ko0Var = new ko0(this, mc1Var);
        gd1 gd1Var = this.b;
        dd1 dd1VarA = gd1Var.a(mc1Var);
        if (dd1VarA != null) {
            obj = dd1VarA.h;
        } else {
            dd1 dd1Var = new dd1(mc1Var, ko0Var);
            gd1Var.j++;
            dd1 dd1Var2 = gd1Var.h;
            if (dd1Var2 == null) {
                gd1Var.g = dd1Var;
                gd1Var.h = dd1Var;
            } else {
                dd1Var2.i = dd1Var;
                dd1Var.j = dd1Var2;
                gd1Var.h = dd1Var;
            }
            obj = null;
        }
        lo0 lo0Var = (lo0) obj;
        if (lo0Var instanceof LiveData$LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (lo0Var != null) {
            return;
        }
        ko0Var.b(true);
    }

    public final void e(Object obj) {
        a("setValue");
        this.g++;
        this.e = obj;
        c(null);
    }
}
