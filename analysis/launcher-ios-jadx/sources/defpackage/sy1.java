package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class sy1 extends zk1 implements s70 {
    public int h;
    public final /* synthetic */ pw1 i;
    public final /* synthetic */ lz1 j;
    public final /* synthetic */ qy0 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sy1(pw1 pw1Var, lz1 lz1Var, qy0 qy0Var, eo eoVar) {
        super(2, eoVar);
        this.i = pw1Var;
        this.j = lz1Var;
        this.k = qy0Var;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        return new sy1(this.i, this.j, this.k, eoVar);
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((sy1) create((gp) obj, (eo) obj2)).invokeSuspend(zp1.a);
    }

    /* JADX WARN: Type inference failed for: r11v10, types: [a40[], java.io.Serializable] */
    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        hp hpVar = hp.g;
        int i = this.h;
        if (i == 0) {
            np1.I(obj);
            pw1 pw1Var = this.i;
            pw1Var.getClass();
            lz1 lz1Var = this.j;
            List list = (List) pw1Var.g;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (((lm) obj2).b(lz1Var)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList(yj.w(arrayList));
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj3 = arrayList.get(i2);
                i2++;
                lm lmVar = (lm) obj3;
                lmVar.getClass();
                arrayList2.add(new uf(new km(lmVar, null), 0));
            }
            gw gwVar = new gw(new uf((a40[]) wj.A(arrayList2).toArray(new a40[0]), 1));
            tu tuVar = new tu(this.k, lz1Var, 9, false);
            this.h = 1;
            if (gwVar.a(tuVar, this) == hpVar) {
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
