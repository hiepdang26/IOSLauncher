package defpackage;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k00 implements Runnable {
    public final uy1 g;
    public final c01 h;

    static {
        ka0.r("EnqueueRunnable");
    }

    public k00(uy1 uy1Var) {
        c01 c01Var = new c01();
        this.g = uy1Var;
        this.h = c01Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(defpackage.uy1 r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k00.a(uy1):boolean");
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        c01 c01Var = this.h;
        uy1 uy1Var = this.g;
        try {
            uy1Var.getClass();
            HashSet hashSet = new HashSet();
            hashSet.addAll(uy1Var.j);
            HashSet hashSetY = uy1.y(uy1Var);
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hashSet.removeAll(uy1Var.j);
                    z = false;
                    break;
                } else if (hashSetY.contains((String) it.next())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                throw new IllegalStateException("WorkContinuation has cycles (" + uy1Var + ")");
            }
            cz1 cz1Var = uy1Var.h;
            WorkDatabase workDatabase = cz1Var.j;
            workDatabase.c();
            try {
                n90.f(workDatabase, cz1Var.i, uy1Var);
                boolean zA = a(uy1Var);
                workDatabase.n();
                if (zA) {
                    t01.a(cz1Var.h, RescheduleReceiver.class, true);
                    fe1.b(cz1Var.i, cz1Var.j, cz1Var.l);
                }
                c01Var.a(c01.c);
            } finally {
                workDatabase.j();
            }
        } catch (Throwable th) {
            c01Var.a(new zz0(th));
        }
    }
}
