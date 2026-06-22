package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ui0 extends ti0 {
    public final xi0 k;
    public final vi0 l;
    public final ci m;
    public final Object n;

    public ui0(xi0 xi0Var, vi0 vi0Var, ci ciVar, Object obj) {
        this.k = xi0Var;
        this.l = vi0Var;
        this.m = ciVar;
        this.n = obj;
    }

    @Override // defpackage.o70
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m((Throwable) obj);
        return zp1.a;
    }

    @Override // defpackage.ti0
    public final void m(Throwable th) {
        ci ciVar = this.m;
        xi0 xi0Var = this.k;
        xi0Var.getClass();
        ci ciVarH = xi0.H(ciVar);
        vi0 vi0Var = this.l;
        Object obj = this.n;
        if (ciVarH != null) {
            while (ciVarH.k.E((2 & 1) == 0, (2 & 2) != 0, new ui0(xi0Var, vi0Var, ciVarH, obj)) == qx0.g) {
                ciVarH = xi0.H(ciVarH);
                if (ciVarH == null) {
                }
            }
            return;
        }
        xi0Var.j(xi0Var.v(vi0Var, obj));
    }
}
