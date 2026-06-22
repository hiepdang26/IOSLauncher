package defpackage;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class l60 extends d11 {
    public final h60 c;
    public boolean g;
    public ca e = null;
    public w50 f = null;
    public final int d = 1;

    public l60(h60 h60Var) {
        this.c = h60Var;
    }

    @Override // defpackage.d11
    public final void a(ViewPager viewPager, Object obj) {
        w50 w50Var = (w50) obj;
        if (this.e == null) {
            h60 h60Var = this.c;
            h60Var.getClass();
            this.e = new ca(h60Var);
        }
        ca caVar = this.e;
        caVar.getClass();
        h60 h60Var2 = w50Var.y;
        if (h60Var2 != null && h60Var2 != caVar.q) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + w50Var.toString() + " is already attached to a FragmentManager.");
        }
        caVar.b(new n60(6, w50Var));
        if (w50Var.equals(this.f)) {
            this.f = null;
        }
    }

    @Override // defpackage.d11
    public final void b() {
        ca caVar = this.e;
        if (caVar != null) {
            if (!this.g) {
                try {
                    this.g = true;
                    if (caVar.g) {
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    }
                    caVar.h = false;
                    h60 h60Var = caVar.q;
                    if (h60Var.p != null && !h60Var.C) {
                        h60Var.w(true);
                        caVar.a(h60Var.E, h60Var.F);
                        h60Var.b = true;
                        try {
                            h60Var.N(h60Var.E, h60Var.F);
                            h60Var.d();
                            h60Var.W();
                            h60Var.t();
                            ((HashMap) h60Var.c.i).values().removeAll(Collections.singleton(null));
                        } catch (Throwable th) {
                            h60Var.d();
                            throw th;
                        }
                    }
                } finally {
                    this.g = false;
                }
            }
            this.e = null;
        }
    }

    @Override // defpackage.d11
    public final Object e(ViewPager viewPager, int i) {
        ca caVar = this.e;
        h60 h60Var = this.c;
        if (caVar == null) {
            h60Var.getClass();
            this.e = new ca(h60Var);
        }
        long jL = l(i);
        w50 w50VarA = h60Var.A("android:switcher:" + viewPager.getId() + ":" + jL);
        if (w50VarA != null) {
            ca caVar2 = this.e;
            caVar2.getClass();
            caVar2.b(new n60(7, w50VarA));
        } else {
            w50VarA = k(i);
            this.e.e(viewPager.getId(), w50VarA, "android:switcher:" + viewPager.getId() + ":" + jL, 1);
        }
        if (w50VarA != this.f) {
            if (w50VarA.I) {
                w50VarA.I = false;
            }
            if (this.d == 1) {
                this.e.h(w50VarA, vm0.j);
                return w50VarA;
            }
            w50VarA.S(false);
        }
        return w50VarA;
    }

    @Override // defpackage.d11
    public final boolean f(View view, Object obj) {
        return ((w50) obj).L == view;
    }

    @Override // defpackage.d11
    public final void h(Object obj) {
        w50 w50Var = (w50) obj;
        w50 w50Var2 = this.f;
        if (w50Var != w50Var2) {
            h60 h60Var = this.c;
            int i = this.d;
            if (w50Var2 != null) {
                if (w50Var2.I) {
                    w50Var2.I = false;
                }
                if (i == 1) {
                    if (this.e == null) {
                        h60Var.getClass();
                        this.e = new ca(h60Var);
                    }
                    this.e.h(this.f, vm0.j);
                } else {
                    w50Var2.S(false);
                }
            }
            if (!w50Var.I) {
                w50Var.I = true;
            }
            if (i == 1) {
                if (this.e == null) {
                    h60Var.getClass();
                    this.e = new ca(h60Var);
                }
                this.e.h(w50Var, vm0.k);
            } else {
                w50Var.S(true);
            }
            this.f = w50Var;
        }
    }

    @Override // defpackage.d11
    public final void j(ViewPager viewPager) {
        if (viewPager.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract w50 k(int i);

    public long l(int i) {
        return i;
    }
}
