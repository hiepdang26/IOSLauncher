package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class kk extends zk1 implements s70 {
    public int h;
    public final /* synthetic */ a40[] i;
    public final /* synthetic */ int j;
    public final /* synthetic */ AtomicInteger k;
    public final /* synthetic */ je l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kk(a40[] a40VarArr, int i, AtomicInteger atomicInteger, je jeVar, eo eoVar) {
        super(2, eoVar);
        this.i = a40VarArr;
        this.j = i;
        this.k = atomicInteger;
        this.l = jeVar;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        return new kk(this.i, this.j, this.k, this.l, eoVar);
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((kk) create((gp) obj, (eo) obj2)).invokeSuspend(zp1.a);
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        hp hpVar = hp.g;
        int i = this.h;
        AtomicInteger atomicInteger = this.k;
        je jeVar = this.l;
        try {
            if (i == 0) {
                np1.I(obj);
                a40[] a40VarArr = this.i;
                int i2 = this.j;
                a40 a40Var = a40VarArr[i2];
                t3 t3Var = new t3(jeVar, i2);
                this.h = 1;
                if (a40Var.a(t3Var, this) == hpVar) {
                    return hpVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                np1.I(obj);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                hg0.k(jeVar);
            }
            return zp1.a;
        } finally {
            if (atomicInteger.decrementAndGet() == 0) {
                hg0.k(jeVar);
            }
        }
    }
}
