package defpackage;

import androidx.work.CoroutineWorker;

/* JADX INFO: loaded from: classes.dex */
public final class kp extends zk1 implements s70 {
    public int h;
    public final /* synthetic */ CoroutineWorker i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kp(CoroutineWorker coroutineWorker, eo eoVar) {
        super(2, eoVar);
        this.i = coroutineWorker;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        return new kp(this.i, eoVar);
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((kp) create((gp) obj, (eo) obj2)).invokeSuspend(zp1.a);
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        hp hpVar = hp.g;
        int i = this.h;
        CoroutineWorker coroutineWorker = this.i;
        try {
            if (i == 0) {
                np1.I(obj);
                this.h = 1;
                obj = coroutineWorker.a();
                if (obj == hpVar) {
                    return hpVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                np1.I(obj);
            }
            coroutineWorker.l.i((ho0) obj);
        } catch (Throwable th) {
            coroutineWorker.l.j(th);
        }
        return zp1.a;
    }
}
