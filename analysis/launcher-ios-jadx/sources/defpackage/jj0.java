package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class jj0 implements z70, Serializable {
    private final int arity;

    public jj0(int i) {
        this.arity = i;
    }

    @Override // defpackage.z70
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        u91.a.getClass();
        String strA = v91.a(this);
        qg0.k(strA, "renderLambdaToString(...)");
        return strA;
    }
}
