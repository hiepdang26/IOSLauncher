package defpackage;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class ed1 extends fd1 implements Iterator {
    public dd1 g;
    public boolean h = true;
    public final /* synthetic */ gd1 i;

    public ed1(gd1 gd1Var) {
        this.i = gd1Var;
    }

    @Override // defpackage.fd1
    public final void a(dd1 dd1Var) {
        dd1 dd1Var2 = this.g;
        if (dd1Var == dd1Var2) {
            dd1 dd1Var3 = dd1Var2.j;
            this.g = dd1Var3;
            this.h = dd1Var3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.h) {
            return this.i.g != null;
        }
        dd1 dd1Var = this.g;
        return (dd1Var == null || dd1Var.i == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.h) {
            this.h = false;
            this.g = this.i.g;
        } else {
            dd1 dd1Var = this.g;
            this.g = dd1Var != null ? dd1Var.i : null;
        }
        return this.g;
    }
}
