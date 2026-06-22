package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class zs1 extends za implements s70, z70 {
    public final int g;
    public int h;
    public /* synthetic */ Object i;
    public final /* synthetic */ View j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zs1(View view, eo eoVar) {
        super(eoVar);
        this.j = view;
        if (eoVar != null && eoVar.getContext() != sz.g) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
        this.g = 2;
    }

    @Override // defpackage.za
    public final eo create(Object obj, eo eoVar) {
        zs1 zs1Var = new zs1(this.j, eoVar);
        zs1Var.i = obj;
        return zs1Var;
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        return ((zs1) create((ff1) obj, (eo) obj2)).invokeSuspend(zp1.a);
    }

    @Override // defpackage.z70
    public final int getArity() {
        return this.g;
    }

    @Override // defpackage.eo
    public final yo getContext() {
        return sz.g;
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        hp hpVar = hp.g;
        int i = this.h;
        View view = this.j;
        if (i == 0) {
            np1.I(obj);
            ff1 ff1Var = (ff1) this.i;
            this.i = ff1Var;
            this.h = 1;
            ff1Var.h = view;
            ff1Var.g = 3;
            ff1Var.j = this;
            return hpVar;
        }
        zp1 zp1Var = zp1.a;
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            np1.I(obj);
            return zp1Var;
        }
        ff1 ff1Var2 = (ff1) this.i;
        np1.I(obj);
        if (view instanceof ViewGroup) {
            this.i = null;
            this.h = 2;
            ff1Var2.getClass();
            ip1 ip1Var = new ip1(new y8((ViewGroup) view, 2));
            if (ip1Var.h.hasNext()) {
                ff1Var2.i = ip1Var;
                ff1Var2.g = 2;
                ff1Var2.j = this;
                obj2 = hpVar;
            } else {
                obj2 = zp1Var;
            }
            if (obj2 != hpVar) {
                obj2 = zp1Var;
            }
            if (obj2 == hpVar) {
                return hpVar;
            }
        }
        return zp1Var;
    }

    @Override // defpackage.za
    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        u91.a.getClass();
        String strA = v91.a(this);
        qg0.k(strA, "renderLambdaToString(...)");
        return strA;
    }
}
