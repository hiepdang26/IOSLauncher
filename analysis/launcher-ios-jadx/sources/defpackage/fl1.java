package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class fl1 implements Serializable {
    public jj0 g;
    public volatile Object h = iy.k;
    public final Object i = this;

    /* JADX WARN: Multi-variable type inference failed */
    public fl1(d70 d70Var) {
        this.g = (jj0) d70Var;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [d70, java.lang.Object, jj0] */
    public final Object a() {
        Object objC;
        Object obj = this.h;
        iy iyVar = iy.k;
        if (obj != iyVar) {
            return obj;
        }
        synchronized (this.i) {
            objC = this.h;
            if (objC == iyVar) {
                ?? r1 = this.g;
                qg0.h(r1);
                objC = r1.c();
                this.h = objC;
                this.g = null;
            }
        }
        return objC;
    }

    public final String toString() {
        return this.h != iy.k ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
