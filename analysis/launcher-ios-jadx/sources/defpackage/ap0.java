package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class ap0 extends at1 {
    public final ji1 c = new ji1();

    @Override // defpackage.at1
    public final void a() {
        ji1 ji1Var = this.c;
        int i = ji1Var.i;
        if (i > 0) {
            ji1Var.h[0].getClass();
            throw new ClassCastException();
        }
        Object[] objArr = ji1Var.h;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        ji1Var.i = 0;
    }
}
