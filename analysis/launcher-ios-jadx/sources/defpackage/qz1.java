package defpackage;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class qz1 implements Runnable {
    public final rz1 g;
    public final zy1 h;

    public qz1(rz1 rz1Var, zy1 zy1Var) {
        this.g = rz1Var;
        this.h = zy1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.g.d) {
            try {
                if (((qz1) this.g.b.remove(this.h)) != null) {
                    pz1 pz1Var = (pz1) this.g.c.remove(this.h);
                    if (pz1Var != null) {
                        zy1 zy1Var = this.h;
                        lu luVar = (lu) pz1Var;
                        ka0 ka0VarJ = ka0.j();
                        Objects.toString(zy1Var);
                        ka0VarJ.getClass();
                        luVar.n.execute(new ku(luVar, 0));
                    }
                } else {
                    ka0 ka0VarJ2 = ka0.j();
                    this.h.toString();
                    ka0VarJ2.getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
