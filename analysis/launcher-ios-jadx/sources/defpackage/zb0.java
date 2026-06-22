package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class zb0 extends jn implements xb0 {
    public jn[] t0 = new jn[4];
    public int u0 = 0;

    public final void Q(jn jnVar) {
        if (jnVar == this || jnVar == null) {
            return;
        }
        int i = this.u0 + 1;
        jn[] jnVarArr = this.t0;
        if (i > jnVarArr.length) {
            this.t0 = (jn[]) Arrays.copyOf(jnVarArr, jnVarArr.length * 2);
        }
        jn[] jnVarArr2 = this.t0;
        int i2 = this.u0;
        jnVarArr2[i2] = jnVar;
        this.u0 = i2 + 1;
    }

    public final void R(int i, ax1 ax1Var, ArrayList arrayList) {
        for (int i2 = 0; i2 < this.u0; i2++) {
            jn jnVar = this.t0[i2];
            ArrayList arrayList2 = ax1Var.a;
            if (!arrayList2.contains(jnVar)) {
                arrayList2.add(jnVar);
            }
        }
        for (int i3 = 0; i3 < this.u0; i3++) {
            n90.k(this.t0[i3], i, arrayList, ax1Var);
        }
    }

    @Override // defpackage.jn
    public void g(jn jnVar, HashMap map) {
        super.g(jnVar, map);
        zb0 zb0Var = (zb0) jnVar;
        this.u0 = 0;
        int i = zb0Var.u0;
        for (int i2 = 0; i2 < i; i2++) {
            Q((jn) map.get(zb0Var.t0[i2]));
        }
    }

    public void a() {
    }
}
