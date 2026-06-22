package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class vc0 extends cg {
    public final /* synthetic */ int i;
    public final /* synthetic */ fe j;
    public final /* synthetic */ int k;
    public final /* synthetic */ bd0 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vc0(bd0 bd0Var, Object[] objArr, int i, fe feVar, int i2, boolean z) {
        super("OkHttp %s Push Data[%s]", objArr);
        this.l = bd0Var;
        this.i = i;
        this.j = feVar;
        this.k = i2;
    }

    @Override // defpackage.cg
    public final void b() {
        try {
            ka0 ka0Var = this.l.p;
            fe feVar = this.j;
            int i = this.k;
            ka0Var.getClass();
            feVar.H(i);
            this.l.z.z(this.i, 6);
            synchronized (this.l) {
                this.l.B.remove(Integer.valueOf(this.i));
            }
        } catch (IOException unused) {
        }
    }
}
