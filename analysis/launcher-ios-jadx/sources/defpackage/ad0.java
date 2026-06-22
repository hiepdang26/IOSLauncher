package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class ad0 extends cg {
    public final /* synthetic */ int i = 0;
    public final /* synthetic */ Object j;
    public final Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad0(bd0 bd0Var, ed0 ed0Var) {
        super("OkHttp %s", new Object[]{bd0Var.j});
        this.j = bd0Var;
        this.k = ed0Var;
    }

    @Override // defpackage.cg
    public final void b() {
        long j;
        id0[] id0VarArr = null;
        switch (this.i) {
            case 0:
                id0 id0Var = (id0) this.k;
                ad0 ad0Var = (ad0) this.j;
                try {
                    ((bd0) ad0Var.j).h.b(id0Var);
                    return;
                } catch (IOException e) {
                    d21.a.m(4, "Http2Connection.Listener failure for " + ((bd0) ad0Var.j).j, e);
                    try {
                        id0Var.c(e, 2);
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            case 1:
                ad0 ad0Var2 = (ad0) this.j;
                t3 t3Var = (t3) this.k;
                synchronized (((bd0) ad0Var2.j).z) {
                    synchronized (((bd0) ad0Var2.j)) {
                        try {
                            int iE = ((bd0) ad0Var2.j).x.e();
                            t3 t3Var2 = ((bd0) ad0Var2.j).x;
                            t3Var2.getClass();
                            for (int i = 0; i < 10; i++) {
                                if (((1 << i) & t3Var.g) != 0) {
                                    t3Var2.h(i, ((int[]) t3Var.h)[i]);
                                }
                            }
                            int iE2 = ((bd0) ad0Var2.j).x.e();
                            if (iE2 == -1 || iE2 == iE) {
                                j = 0;
                            } else {
                                j = iE2 - iE;
                                if (!((bd0) ad0Var2.j).i.isEmpty()) {
                                    id0VarArr = (id0[]) ((bd0) ad0Var2.j).i.values().toArray(new id0[((bd0) ad0Var2.j).i.size()]);
                                }
                            }
                        } finally {
                        }
                        break;
                    }
                    try {
                        bd0 bd0Var = (bd0) ad0Var2.j;
                        bd0Var.z.a(bd0Var.x);
                    } catch (IOException e2) {
                        ((bd0) ad0Var2.j).a(2, 2, e2);
                    }
                    break;
                }
                if (id0VarArr != null) {
                    for (id0 id0Var2 : id0VarArr) {
                        synchronized (id0Var2) {
                            id0Var2.b += j;
                            if (j > 0) {
                                id0Var2.notifyAll();
                            }
                        }
                    }
                }
                bd0.C.execute(new tc0(ad0Var2, new Object[]{((bd0) ad0Var2.j).j}));
                return;
            default:
                bd0 bd0Var2 = (bd0) this.j;
                ed0 ed0Var = (ed0) this.k;
                try {
                    ed0Var.h(this);
                    do {
                        break;
                    } while (ed0Var.b(false, this));
                    bd0Var2.a(1, 6, null);
                } catch (IOException e3) {
                    bd0Var2.a(2, 2, e3);
                } catch (Throwable th) {
                    bd0Var2.a(3, 3, null);
                    wq1.c(ed0Var);
                    throw th;
                }
                wq1.c(ed0Var);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad0(ad0 ad0Var, Object[] objArr, id0 id0Var) {
        super("OkHttp %s stream %d", objArr);
        this.j = ad0Var;
        this.k = id0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad0(ad0 ad0Var, Object[] objArr, t3 t3Var) {
        super("OkHttp %s ACK Settings", objArr);
        this.j = ad0Var;
        this.k = t3Var;
    }
}
