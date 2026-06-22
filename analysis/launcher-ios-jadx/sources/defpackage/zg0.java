package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class zg0 implements sx0, o70 {
    public final jj0 g;

    /* JADX WARN: Multi-variable type inference failed */
    public zg0(o70 o70Var) {
        this.g = (jj0) o70Var;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [jj0, o70] */
    @Override // defpackage.o70
    public final Object invoke(Object obj) {
        this.g.invoke((Throwable) obj);
        return zp1.a;
    }

    public final String toString() {
        return "InvokeOnCancel[" + this.g.getClass().getSimpleName() + '@' + os.e(this) + ']';
    }
}
