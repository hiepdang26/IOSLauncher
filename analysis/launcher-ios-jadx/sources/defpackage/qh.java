package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class qh extends zk1 implements s70 {
    public int h;
    public /* synthetic */ Object i;
    public final /* synthetic */ c40 j;
    public final /* synthetic */ uf k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qh(c40 c40Var, uf ufVar, eo eoVar) {
        super(2, eoVar);
        this.j = c40Var;
        this.k = ufVar;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        qh qhVar = new qh(this.j, this.k, eoVar);
        qhVar.i = obj;
        return qhVar;
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((qh) create((gp) obj, (eo) obj2)).invokeSuspend(zp1.a);
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        hp hpVar = hp.g;
        int i = this.h;
        zp1 zp1Var = zp1.a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            np1.I(obj);
            return zp1Var;
        }
        np1.I(obj);
        gp gpVar = (gp) this.i;
        uf ufVar = this.k;
        ufVar.getClass();
        s70 rhVar = new rh(ufVar, null);
        u31 u31Var = new u31(e42.l(gpVar, sz.g), wd.c(-2, 1, 4));
        u31Var.Q(3, u31Var, rhVar);
        this.h = 1;
        Object objH = z71.h(this.j, u31Var, true, this);
        if (objH != hpVar) {
            objH = zp1Var;
        }
        return objH == hpVar ? hpVar : zp1Var;
    }
}
