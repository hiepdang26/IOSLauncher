package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ry1 extends zk1 implements y70 {
    public int h;
    public /* synthetic */ c40 i;
    public /* synthetic */ Object[] j;

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        sn snVar;
        sn snVar2;
        hp hpVar = hp.g;
        int i = this.h;
        if (i == 0) {
            np1.I(obj);
            c40 c40Var = this.i;
            sn[] snVarArr = (sn[]) this.j;
            int length = snVarArr.length;
            int i2 = 0;
            while (true) {
                snVar = qn.a;
                if (i2 >= length) {
                    snVar2 = null;
                    break;
                }
                snVar2 = snVarArr[i2];
                if (!qg0.d(snVar2, snVar)) {
                    break;
                }
                i2++;
            }
            if (snVar2 != null) {
                snVar = snVar2;
            }
            this.h = 1;
            if (c40Var.b(snVar, this) == hpVar) {
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
