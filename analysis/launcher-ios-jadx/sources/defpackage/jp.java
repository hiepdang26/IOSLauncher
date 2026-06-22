package defpackage;

import androidx.work.CoroutineWorker;

/* JADX INFO: loaded from: classes.dex */
public final class jp extends zk1 implements s70 {
    public si0 h;
    public int i;
    public final /* synthetic */ si0 j;
    public final /* synthetic */ CoroutineWorker k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jp(si0 si0Var, CoroutineWorker coroutineWorker, eo eoVar) {
        super(2, eoVar);
        this.j = si0Var;
        this.k = coroutineWorker;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        return new jp(this.j, this.k, eoVar);
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        jp jpVar = (jp) create((gp) obj, (eo) obj2);
        zp1 zp1Var = zp1.a;
        jpVar.invokeSuspend(zp1Var);
        return zp1Var;
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        int i = this.i;
        if (i == 0) {
            np1.I(obj);
            this.h = this.j;
            this.i = 1;
            this.k.getClass();
            throw new IllegalStateException("Not implemented");
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        si0 si0Var = this.h;
        np1.I(obj);
        si0Var.g.i(obj);
        return zp1.a;
    }
}
