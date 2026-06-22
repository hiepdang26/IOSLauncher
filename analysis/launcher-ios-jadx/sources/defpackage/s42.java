package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s42 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ w42 h;
    public final /* synthetic */ String i;

    public /* synthetic */ s42(w42 w42Var, String str, int i) {
        this.g = i;
        this.h = w42Var;
        this.i = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.b.b.evaluateJavascript(this.i, null);
                break;
            default:
                this.h.b.b.evaluateJavascript(this.i, null);
                break;
        }
    }
}
