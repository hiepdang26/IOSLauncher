package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class yr0 extends p02 {
    public final p02 m;
    public final /* synthetic */ int n;
    public final Object o;

    public yr0(p02 p02Var, Object obj, int i) {
        this.n = i;
        this.m = p02Var;
        this.o = obj;
    }

    @Override // defpackage.p02
    public final void A(wr0 wr0Var) {
        switch (this.n) {
            case 0:
                this.m.z(new xr0(wr0Var, this));
                break;
            default:
                zr0 zr0Var = new zr0(wr0Var);
                wr0Var.c(zr0Var);
                cw cwVarB = ((td1) this.o).b(new el0(zr0Var, this.m, 5, false));
                yc1 yc1Var = zr0Var.g;
                yc1Var.getClass();
                ew.c(yc1Var, cwVarB);
                break;
        }
    }
}
