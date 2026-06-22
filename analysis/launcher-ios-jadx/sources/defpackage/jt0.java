package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jt0 implements an0 {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ jt0(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // defpackage.an0
    public final void a(en0 en0Var, um0 um0Var) {
        switch (this.g) {
            case 0:
                um0 um0Var2 = um0.ON_DESTROY;
                lt0 lt0Var = (lt0) this.h;
                if (um0Var != um0Var2) {
                    lt0Var.getClass();
                } else {
                    lt0Var.a();
                }
                break;
            default:
                nd1 nd1Var = (nd1) this.h;
                qg0.l(nd1Var, "this$0");
                if (um0Var == um0.ON_START) {
                    nd1Var.f = true;
                } else if (um0Var == um0.ON_STOP) {
                    nd1Var.f = false;
                }
                break;
        }
    }
}
