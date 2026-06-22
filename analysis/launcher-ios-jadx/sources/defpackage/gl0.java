package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class gl0 implements Runnable {
    public final /* synthetic */ int g = 0;
    public final /* synthetic */ long h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;

    public gl0(yi0 yi0Var, String str, long j) {
        this.j = yi0Var;
        this.i = str;
        this.h = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                synchronized (rl0.A) {
                    rl0.d(this.h, (qh0) this.i, (StackTraceElement[]) this.j);
                    break;
                }
                return;
            default:
                yi0 yi0Var = (yi0) this.j;
                yi0Var.g.a((String) this.i, this.h);
                yi0Var.g.b(yi0Var.toString());
                return;
        }
    }

    public gl0(long j, qh0 qh0Var, StackTraceElement[] stackTraceElementArr) {
        this.h = j;
        this.i = qh0Var;
        this.j = stackTraceElementArr;
    }
}
