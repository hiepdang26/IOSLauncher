package defpackage;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class cd1 extends fd1 implements Iterator {
    public dd1 g;
    public dd1 h;
    public final /* synthetic */ int i;

    public cd1(dd1 dd1Var, dd1 dd1Var2, int i) {
        this.i = i;
        this.g = dd1Var2;
        this.h = dd1Var;
    }

    @Override // defpackage.fd1
    public final void a(dd1 dd1Var) {
        dd1 dd1Var2;
        dd1 dd1VarB = null;
        if (this.g == dd1Var && dd1Var == this.h) {
            this.h = null;
            this.g = null;
        }
        dd1 dd1Var3 = this.g;
        if (dd1Var3 == dd1Var) {
            switch (this.i) {
                case 0:
                    dd1Var2 = dd1Var3.j;
                    break;
                default:
                    dd1Var2 = dd1Var3.i;
                    break;
            }
            this.g = dd1Var2;
        }
        dd1 dd1Var4 = this.h;
        if (dd1Var4 == dd1Var) {
            dd1 dd1Var5 = this.g;
            if (dd1Var4 != dd1Var5 && dd1Var5 != null) {
                dd1VarB = b(dd1Var4);
            }
            this.h = dd1VarB;
        }
    }

    public final dd1 b(dd1 dd1Var) {
        switch (this.i) {
            case 0:
                return dd1Var.i;
            default:
                return dd1Var.j;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.h != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        dd1 dd1Var = this.h;
        dd1 dd1Var2 = this.g;
        this.h = (dd1Var == dd1Var2 || dd1Var2 == null) ? null : b(dd1Var);
        return dd1Var;
    }
}
