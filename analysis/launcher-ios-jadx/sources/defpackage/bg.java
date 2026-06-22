package defpackage;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class bg extends cg {
    public final /* synthetic */ int i;
    public final /* synthetic */ cz1 j;

    public /* synthetic */ bg(cz1 cz1Var, int i) {
        this.i = i;
        this.j = cz1Var;
    }

    /* JADX WARN: Finally extract failed */
    @Override // defpackage.cg
    public final void c() {
        switch (this.i) {
            case 0:
                cz1 cz1Var = this.j;
                WorkDatabase workDatabase = cz1Var.j;
                workDatabase.c();
                try {
                    ArrayList arrayListH = workDatabase.u().h();
                    int size = arrayListH.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayListH.get(i);
                        i++;
                        cg.a(cz1Var, (String) obj);
                    }
                    workDatabase.n();
                    workDatabase.j();
                    fe1.b(cz1Var.i, cz1Var.j, cz1Var.l);
                    return;
                } catch (Throwable th) {
                    workDatabase.j();
                    throw th;
                }
            default:
                cz1 cz1Var2 = this.j;
                WorkDatabase workDatabase2 = cz1Var2.j;
                workDatabase2.c();
                try {
                    ArrayList arrayListG = workDatabase2.u().g();
                    int size2 = arrayListG.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayListG.get(i2);
                        i2++;
                        cg.a(cz1Var2, (String) obj2);
                    }
                    workDatabase2.n();
                    workDatabase2.j();
                    return;
                } catch (Throwable th2) {
                    workDatabase2.j();
                    throw th2;
                }
        }
    }
}
