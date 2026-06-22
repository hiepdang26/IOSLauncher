package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class w3 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ x3 h;

    public /* synthetic */ w3(x3 x3Var, int i) {
        this.g = i;
        this.h = x3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                x3 x3Var = this.h;
                int i = x3Var.i;
                int[] iArr = x3Var.j;
                if (i < iArr.length) {
                    x3Var.a.scrollBy(0, iArr[i]);
                    x3Var.i++;
                    x3Var.a.postOnAnimation(x3Var.k);
                }
                break;
            default:
                x3 x3Var2 = this.h;
                x3Var2.d = x3Var2.e;
                x3Var2.f = true;
                x3Var2.g = true;
                x3Var2.a();
                break;
        }
    }
}
