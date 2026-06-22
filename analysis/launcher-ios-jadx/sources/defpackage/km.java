package defpackage;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class km extends zk1 implements s70 {
    public int h;
    public /* synthetic */ Object i;
    public final /* synthetic */ lm j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public km(lm lmVar, eo eoVar) {
        super(2, eoVar);
        this.j = lmVar;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        km kmVar = new km(this.j, eoVar);
        kmVar.i = obj;
        return kmVar;
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((km) create((v31) obj, (eo) obj2)).invokeSuspend(zp1.a);
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        hp hpVar = hp.g;
        int i = this.h;
        if (i == 0) {
            np1.I(obj);
            v31 v31Var = (v31) this.i;
            lm lmVar = this.j;
            jm jmVar = new jm(lmVar, v31Var);
            fn fnVar = lmVar.a;
            fnVar.getClass();
            synchronized (fnVar.c) {
                try {
                    if (fnVar.d.add(jmVar)) {
                        if (fnVar.d.size() == 1) {
                            fnVar.e = fnVar.a();
                            ka0 ka0VarJ = ka0.j();
                            int i2 = gn.a;
                            Objects.toString(fnVar.e);
                            ka0VarJ.getClass();
                            fnVar.c();
                        }
                        jmVar.a(fnVar.e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            im imVar = new im(this.j, jmVar);
            this.h = 1;
            if (hs0.b(v31Var, imVar, this) == hpVar) {
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
