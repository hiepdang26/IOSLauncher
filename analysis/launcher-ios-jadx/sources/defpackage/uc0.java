package defpackage;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class uc0 extends cg {
    public final /* synthetic */ int i = 2;
    public final /* synthetic */ int j;
    public final /* synthetic */ bd0 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uc0(bd0 bd0Var, Object[] objArr, int i, ArrayList arrayList) {
        super("OkHttp %s Push Request[%s]", objArr);
        this.k = bd0Var;
        this.j = i;
    }

    private final void d() {
        this.k.p.getClass();
        try {
            this.k.z.z(this.j, 6);
            synchronized (this.k) {
                this.k.B.remove(Integer.valueOf(this.j));
            }
        } catch (IOException unused) {
        }
    }

    private final void e() {
        this.k.p.getClass();
        try {
            this.k.z.z(this.j, 6);
            synchronized (this.k) {
                this.k.B.remove(Integer.valueOf(this.j));
            }
        } catch (IOException unused) {
        }
    }

    @Override // defpackage.cg
    public final void b() {
        switch (this.i) {
            case 0:
                d();
                return;
            case 1:
                e();
                return;
            default:
                this.k.p.getClass();
                synchronized (this.k) {
                    this.k.B.remove(Integer.valueOf(this.j));
                    break;
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uc0(bd0 bd0Var, Object[] objArr, int i, ArrayList arrayList, boolean z) {
        super("OkHttp %s Push Headers[%s]", objArr);
        this.k = bd0Var;
        this.j = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uc0(bd0 bd0Var, Object[] objArr, int i, int i2) {
        super("OkHttp %s Push Reset[%s]", objArr);
        this.k = bd0Var;
        this.j = i;
    }
}
