package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class zk0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ bl0 h;

    public /* synthetic */ zk0(bl0 bl0Var, int i) {
        this.g = i;
        this.h = bl0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                o1 o1Var = new o1(this, 29);
                bl0 bl0Var = this.h;
                bl0Var.a(bl0Var.g.findViewById(v51.migration_cling), o1Var, "cling_gel.migration.dismissed");
                break;
            default:
                bl0 bl0Var2 = this.h;
                bl0Var2.a(bl0Var2.g.findViewById(v51.longpress_cling), null, "cling_gel.workspace.dismissed");
                break;
        }
    }
}
