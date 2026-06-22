package defpackage;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class g01 implements bj0 {
    public final jf b = new jf(0);

    @Override // defpackage.bj0
    public final void b(MessageDigest messageDigest) {
        int i = 0;
        while (true) {
            jf jfVar = this.b;
            if (i >= jfVar.i) {
                return;
            }
            e01 e01Var = (e01) jfVar.f(i);
            Object objJ = this.b.j(i);
            d01 d01Var = e01Var.b;
            if (e01Var.d == null) {
                e01Var.d = e01Var.c.getBytes(bj0.a);
            }
            d01Var.g(e01Var.d, objJ, messageDigest);
            i++;
        }
    }

    public final Object c(e01 e01Var) {
        jf jfVar = this.b;
        return jfVar.containsKey(e01Var) ? jfVar.get(e01Var) : e01Var.a;
    }

    @Override // defpackage.bj0
    public final boolean equals(Object obj) {
        if (obj instanceof g01) {
            return this.b.equals(((g01) obj).b);
        }
        return false;
    }

    @Override // defpackage.bj0
    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.b + '}';
    }
}
