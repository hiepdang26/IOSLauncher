package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class sc0 extends cg {
    public final /* synthetic */ int i;
    public final /* synthetic */ long j;
    public final /* synthetic */ bd0 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sc0(bd0 bd0Var, Object[] objArr, int i, long j) {
        super("OkHttp Window Update %s stream %d", objArr);
        this.k = bd0Var;
        this.i = i;
        this.j = j;
    }

    @Override // defpackage.cg
    public final void b() {
        bd0 bd0Var = this.k;
        try {
            bd0Var.z.B(this.i, this.j);
        } catch (IOException e) {
            bd0Var.a(2, 2, e);
        }
    }
}
