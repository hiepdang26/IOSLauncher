package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zc0 extends cg {
    public final boolean i;
    public final int j;
    public final int k;
    public final /* synthetic */ bd0 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc0(bd0 bd0Var, int i, int i2) {
        super("OkHttp %s ping %08x%08x", new Object[]{bd0Var.j, Integer.valueOf(i), Integer.valueOf(i2)});
        this.l = bd0Var;
        this.i = true;
        this.j = i;
        this.k = i2;
    }

    @Override // defpackage.cg
    public final void b() {
        int i = this.j;
        int i2 = this.k;
        boolean z = this.i;
        bd0 bd0Var = this.l;
        bd0Var.getClass();
        try {
            bd0Var.z.r(i, i2, z);
        } catch (IOException e) {
            bd0Var.a(2, 2, e);
        }
    }
}
