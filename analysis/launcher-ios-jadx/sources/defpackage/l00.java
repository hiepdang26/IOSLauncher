package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class l00 extends ig1 {
    public abstract void e(z60 z60Var, Object obj);

    public void f(Object obj) {
        z60 z60VarA = a();
        try {
            e(z60VarA, obj);
            z60VarA.h.executeInsert();
        } finally {
            d(z60VarA);
        }
    }
}
