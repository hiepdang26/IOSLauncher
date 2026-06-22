package defpackage;

import com.luutinhit.launcher6.leftpage.database.LeftPageWidgetDatabase_Impl;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sq implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ wq h;
    public final /* synthetic */ hm0 i;

    public /* synthetic */ sq(wq wqVar, hm0 hm0Var, int i) {
        this.g = i;
        this.h = wqVar;
        this.i = hm0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LeftPageWidgetDatabase_Impl leftPageWidgetDatabase_Impl;
        switch (this.g) {
            case 0:
                wq wqVar = this.h;
                wqVar.s.remove(this.i);
                qm0 qm0Var = wqVar.t;
                leftPageWidgetDatabase_Impl = (LeftPageWidgetDatabase_Impl) qm0Var.a;
                leftPageWidgetDatabase_Impl.b();
                leftPageWidgetDatabase_Impl.c();
                try {
                    om0 om0Var = (om0) qm0Var.c;
                    z60 z60VarA = om0Var.a();
                    try {
                        z60VarA.q(1, r2.a);
                        z60VarA.a();
                        om0Var.d(z60VarA);
                        leftPageWidgetDatabase_Impl.n();
                        leftPageWidgetDatabase_Impl.j();
                        new Thread(new rq(wqVar, 3)).start();
                        return;
                    } catch (Throwable th) {
                        om0Var.d(z60VarA);
                        throw th;
                    }
                } finally {
                }
            case 1:
                this.h.u.g.e(this.i.c, 1);
                return;
            default:
                hm0 hm0Var = this.i;
                wq wqVar2 = this.h;
                qm0 qm0Var2 = wqVar2.t;
                leftPageWidgetDatabase_Impl = (LeftPageWidgetDatabase_Impl) qm0Var2.a;
                leftPageWidgetDatabase_Impl.b();
                leftPageWidgetDatabase_Impl.c();
                try {
                    ((su) qm0Var2.b).f(hm0Var);
                    leftPageWidgetDatabase_Impl.n();
                    leftPageWidgetDatabase_Impl.j();
                    wqVar2.post(new sq(wqVar2, hm0Var, 1));
                    return;
                } finally {
                }
        }
    }
}
