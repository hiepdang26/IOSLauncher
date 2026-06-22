package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class m30 extends n30 {
    public final /* synthetic */ int k;
    public final /* synthetic */ q30 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m30(q30 q30Var, int i) {
        super(q30Var);
        this.k = i;
        this.l = q30Var;
    }

    @Override // defpackage.n30
    public final float a() {
        switch (this.k) {
            case 0:
                q30 q30Var = this.l;
                return q30Var.h + q30Var.i;
            case 1:
                q30 q30Var2 = this.l;
                return q30Var2.h + q30Var2.j;
            default:
                return this.l.h;
        }
    }
}
