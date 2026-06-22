package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class io1 extends zk1 implements s70 {
    public int h;
    public final /* synthetic */ jo1 i;
    public final /* synthetic */ j80 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public io1(jo1 jo1Var, j80 j80Var, eo eoVar) {
        super(2, eoVar);
        this.i = jo1Var;
        this.j = j80Var;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        return new io1(this.i, this.j, eoVar);
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((io1) create((gp) obj, (eo) obj2)).invokeSuspend(zp1.a);
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        hp hpVar = hp.g;
        int i = this.h;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            np1.I(obj);
            return obj;
        }
        np1.I(obj);
        lo1 lo1Var = this.i.a;
        this.h = 1;
        Object objB = lo1Var.b(this.j, this);
        return objB == hpVar ? hpVar : objB;
    }
}
