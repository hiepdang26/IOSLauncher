package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class rh extends zk1 implements s70 {
    public int h;
    public /* synthetic */ Object i;
    public final /* synthetic */ uf j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rh(uf ufVar, eo eoVar) {
        super(2, eoVar);
        this.j = ufVar;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        rh rhVar = new rh(this.j, eoVar);
        rhVar.i = obj;
        return rhVar;
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((rh) create((v31) obj, (eo) obj2)).invokeSuspend(zp1.a);
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        hp hpVar = hp.g;
        int i = this.h;
        if (i == 0) {
            np1.I(obj);
            v31 v31Var = (v31) this.i;
            this.h = 1;
            if (this.j.b(v31Var, this) == hpVar) {
                return hpVar;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            np1.I(obj);
        }
        return zp1.a;
    }
}
