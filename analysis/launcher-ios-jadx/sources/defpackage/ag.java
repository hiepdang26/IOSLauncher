package defpackage;

import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class ag extends cg {
    public final /* synthetic */ cz1 i;
    public final /* synthetic */ UUID j;

    public ag(cz1 cz1Var, UUID uuid) {
        this.i = cz1Var;
        this.j = uuid;
    }

    @Override // defpackage.cg
    public final void c() {
        cz1 cz1Var = this.i;
        WorkDatabase workDatabase = cz1Var.j;
        workDatabase.c();
        try {
            cg.a(cz1Var, this.j.toString());
            workDatabase.n();
            workDatabase.j();
            fe1.b(cz1Var.i, cz1Var.j, cz1Var.l);
        } catch (Throwable th) {
            workDatabase.j();
            throw th;
        }
    }
}
