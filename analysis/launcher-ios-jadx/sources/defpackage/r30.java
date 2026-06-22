package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class r30 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ z30 h;

    public /* synthetic */ r30(z30 z30Var, int i) {
        this.g = i;
        this.h = z30Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.d();
                break;
            case 1:
                this.h.d();
                break;
            default:
                this.h.setLayerType(0, null);
                break;
        }
    }
}
