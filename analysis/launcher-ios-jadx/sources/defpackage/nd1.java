package defpackage;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class nd1 {
    public boolean b;
    public Bundle c;
    public boolean d;
    public c6 e;
    public final gd1 a = new gd1();
    public boolean f = true;

    public final Bundle a(String str) {
        if (!this.d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.c;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.c = null;
        return bundle2;
    }

    public final void b(String str, md1 md1Var) {
        Object obj;
        gd1 gd1Var = this.a;
        dd1 dd1VarA = gd1Var.a(str);
        if (dd1VarA != null) {
            obj = dd1VarA.h;
        } else {
            dd1 dd1Var = new dd1(str, md1Var);
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
        if (((md1) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }
}
