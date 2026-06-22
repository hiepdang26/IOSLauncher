package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.view.MenuItem;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class n6 implements mu0 {
    public Object g;
    public Object h;

    public /* synthetic */ n6(Object obj, Object obj2) {
        this.g = obj;
        this.h = obj2;
    }

    public void c() {
        m6 m6Var = (m6) this.g;
        if (m6Var != null) {
            try {
                ((q6) this.h).j.unregisterReceiver(m6Var);
            } catch (IllegalArgumentException unused) {
            }
            this.g = null;
        }
    }

    public void d() {
        li1 li1Var = (li1) this.g;
        HashSet hashSet = li1Var.e;
        if (hashSet.remove((ig) this.h) && hashSet.isEmpty()) {
            li1Var.b();
        }
    }

    public abstract IntentFilter e();

    public abstract int f();

    public MenuItem g(MenuItem menuItem) {
        if (!(menuItem instanceof uk1)) {
            return menuItem;
        }
        uk1 uk1Var = (uk1) menuItem;
        if (((ug1) this.h) == null) {
            this.h = new ug1(0);
        }
        MenuItem menuItem2 = (MenuItem) ((ug1) this.h).get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        qt0 qt0Var = new qt0((Context) this.g, uk1Var);
        ((ug1) this.h).put(uk1Var, qt0Var);
        return qt0Var;
    }

    public abstract void h();

    public void i() {
        c();
        IntentFilter intentFilterE = e();
        if (intentFilterE.countActions() == 0) {
            return;
        }
        if (((m6) this.g) == null) {
            this.g = new m6(this, 0);
        }
        ((q6) this.h).j.registerReceiver((m6) this.g, intentFilterE);
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        Class cls = (Class) this.h;
        return new d41((Context) this.g, qm0Var.b(File.class, cls), qm0Var.b(Uri.class, cls), cls);
    }

    public n6(Context context) {
        this.g = context;
    }

    public n6(q6 q6Var) {
        this.h = q6Var;
    }
}
