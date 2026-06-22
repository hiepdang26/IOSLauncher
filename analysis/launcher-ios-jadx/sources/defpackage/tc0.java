package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class tc0 extends cg {
    public final /* synthetic */ int i = 1;
    public final /* synthetic */ Object j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tc0(bd0 bd0Var, Object[] objArr) {
        super("OkHttp %s ping", objArr);
        this.j = bd0Var;
    }

    @Override // defpackage.cg
    public final void b() {
        switch (this.i) {
            case 0:
                bd0 bd0Var = (bd0) this.j;
                bd0Var.getClass();
                try {
                    bd0Var.z.r(2, 0, false);
                } catch (IOException e) {
                    bd0Var.a(2, 2, e);
                    return;
                }
                break;
            default:
                bd0 bd0Var2 = (bd0) ((ad0) this.j).j;
                bd0Var2.h.a(bd0Var2);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tc0(ad0 ad0Var, Object[] objArr) {
        super("OkHttp %s settings", objArr);
        this.j = ad0Var;
    }
}
