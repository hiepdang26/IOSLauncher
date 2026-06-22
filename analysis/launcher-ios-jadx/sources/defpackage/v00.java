package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class v00 extends cp {
    public long i;
    public boolean j;
    public x8 k;

    public final void C() {
        long j = this.i - 4294967296L;
        this.i = j;
        if (j <= 0 && this.j) {
            shutdown();
        }
    }

    public final void D(zv zvVar) {
        x8 x8Var = this.k;
        if (x8Var == null) {
            x8Var = new x8();
            this.k = x8Var;
        }
        x8Var.addLast(zvVar);
    }

    public abstract Thread E();

    public final void F(boolean z) {
        this.i = (z ? 4294967296L : 1L) + this.i;
        if (z) {
            return;
        }
        this.j = true;
    }

    public final boolean G() throws IllegalAccessException, InvocationTargetException {
        x8 x8Var = this.k;
        if (x8Var == null) {
            return false;
        }
        zv zvVar = (zv) (x8Var.isEmpty() ? null : x8Var.removeFirst());
        if (zvVar == null) {
            return false;
        }
        zvVar.run();
        return true;
    }

    public abstract void shutdown();
}
