package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class rc0 extends cg {
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;
    public final /* synthetic */ bd0 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rc0(bd0 bd0Var, Object[] objArr, int i, int i2) {
        super("OkHttp %s stream %d", objArr);
        this.k = bd0Var;
        this.i = i;
        this.j = i2;
    }

    @Override // defpackage.cg
    public final void b() {
        bd0 bd0Var = this.k;
        try {
            bd0Var.z.z(this.i, this.j);
        } catch (IOException e) {
            bd0Var.a(2, 2, e);
        }
    }
}
