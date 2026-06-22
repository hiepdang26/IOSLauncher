package defpackage;

import android.os.Build;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class fe1 {
    public static final /* synthetic */ int a = 0;

    static {
        ka0.r("Schedulers");
    }

    public static void a(mz1 mz1Var, jl1 jl1Var, ArrayList arrayList) {
        if (arrayList.size() > 0) {
            jl1Var.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                mz1Var.j(((lz1) obj).a, jCurrentTimeMillis);
            }
        }
    }

    public static void b(rl rlVar, WorkDatabase workDatabase, List list) {
        ArrayList arrayListC;
        if (list == null || list.size() == 0) {
            return;
        }
        mz1 mz1VarU = workDatabase.u();
        workDatabase.c();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                arrayListC = mz1VarU.c();
                a(mz1VarU, rlVar.c, arrayListC);
            } else {
                arrayListC = null;
            }
            ArrayList arrayListB = mz1VarU.b(rlVar.i);
            a(mz1VarU, rlVar.c, arrayListB);
            if (arrayListC != null) {
                arrayListB.addAll(arrayListC);
            }
            ArrayList arrayListA = mz1VarU.a();
            workDatabase.n();
            workDatabase.j();
            if (arrayListB.size() > 0) {
                lz1[] lz1VarArr = (lz1[]) arrayListB.toArray(new lz1[arrayListB.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ud1 ud1Var = (ud1) it.next();
                    if (ud1Var.e()) {
                        ud1Var.c(lz1VarArr);
                    }
                }
            }
            if (arrayListA.size() > 0) {
                lz1[] lz1VarArr2 = (lz1[]) arrayListA.toArray(new lz1[arrayListA.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ud1 ud1Var2 = (ud1) it2.next();
                    if (!ud1Var2.e()) {
                        ud1Var2.c(lz1VarArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.j();
            throw th;
        }
    }
}
