package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class he1 extends f implements ip {
    public final zk1 j;

    public he1(yo yoVar, zk1 zk1Var) {
        super(yoVar, true);
        this.j = zk1Var;
    }

    @Override // defpackage.xi0
    public final boolean F() {
        return true;
    }

    @Override // defpackage.ip
    public final ip getCallerFrame() {
        zk1 zk1Var = this.j;
        if (uo.r(zk1Var)) {
            return zk1Var;
        }
        return null;
    }

    @Override // defpackage.xi0
    public final void j(Object obj) {
        eo eoVarD = e42.d(this.j);
        if (obj instanceof uk) {
            obj = np1.e(((uk) obj).a);
        }
        np1.G(obj, eoVarD);
    }

    @Override // defpackage.xi0
    public final void l(Object obj) {
        zk1 zk1Var = this.j;
        if (obj instanceof uk) {
            obj = np1.e(((uk) obj).a);
        }
        zk1Var.resumeWith(obj);
    }
}
