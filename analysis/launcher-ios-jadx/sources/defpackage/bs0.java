package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class bs0 extends zk1 implements s70 {
    public int h;
    public final /* synthetic */ es0 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs0(es0 es0Var, eo eoVar) {
        super(2, eoVar);
        this.i = es0Var;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        return new bs0(this.i, eoVar);
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((bs0) create((gp) obj, (eo) obj2)).invokeSuspend(zp1.a);
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
        as0 as0Var = this.i.a;
        this.h = 1;
        Object objB = as0Var.b(this);
        return objB == hpVar ? hpVar : objB;
    }
}
