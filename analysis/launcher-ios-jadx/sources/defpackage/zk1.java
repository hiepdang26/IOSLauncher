package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class zk1 extends go implements z70 {
    public final int g;

    public zk1(int i, eo eoVar) {
        super(eoVar);
        this.g = i;
    }

    @Override // defpackage.z70
    public final int getArity() {
        return this.g;
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
