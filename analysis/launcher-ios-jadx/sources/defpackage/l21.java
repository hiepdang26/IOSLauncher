package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class l21 extends k21 {
    public final Object c;

    public l21(int i) {
        super(i);
        this.c = new Object();
    }

    @Override // defpackage.k21
    public final Object a() {
        Object objA;
        synchronized (this.c) {
            objA = super.a();
        }
        return objA;
    }

    @Override // defpackage.k21
    public final boolean c(Object obj) {
        boolean zC;
        qg0.l(obj, "instance");
        synchronized (this.c) {
            zC = super.c(obj);
        }
        return zC;
    }
}
