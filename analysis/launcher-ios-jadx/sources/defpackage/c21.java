package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c21 extends vu1 {
    @Override // defpackage.jn
    public final void c(qn0 qn0Var, boolean z) {
        super.c(qn0Var, z);
        if (this.u0 > 0) {
            jn jnVar = this.t0[0];
            jn jnVar2 = jnVar.U;
            if (jnVar2 != null && (jnVar2 instanceof kn)) {
            }
            ArrayList arrayList = jnVar.R;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((gm) arrayList.get(i)).j();
            }
            jnVar.f0 = 0.5f;
            jnVar.e0 = 0.5f;
            jnVar.f(2, this, 2);
            jnVar.f(4, this, 4);
            jnVar.f(3, this, 3);
            jnVar.f(5, this, 5);
        }
    }
}
