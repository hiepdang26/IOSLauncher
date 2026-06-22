package defpackage;

import android.content.Context;
import com.luutinhit.launcher6.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class sj0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Serializable i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Object l;

    public /* synthetic */ sj0(Object obj, Object obj2, Serializable serializable, Object obj3, Object obj4, int i) {
        this.g = i;
        this.l = obj;
        this.h = obj2;
        this.i = serializable;
        this.j = obj3;
        this.k = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                ((t) this.l).bindAppsAdded((ArrayList) this.h, (ArrayList) this.i, (ArrayList) this.j, (ArrayList) this.k);
                return;
            case 1:
                hl0 hl0VarL = ((rl0) this.l).l();
                if (hl0VarL == null || ((hl0) this.j) != hl0VarL) {
                    return;
                }
                hl0VarL.bindShortcutsHidden((ArrayList) this.h, (ArrayList) this.i, (jq1) this.k);
                return;
            default:
                try {
                    if (!(((nf1) this.h).g instanceof h)) {
                        String string = ((UUID) this.i).toString();
                        lz1 lz1VarI = ((yy1) this.l).c.i(string);
                        if (lz1VarI == null || k31.d(lz1VarI.b)) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        ((yy1) this.l).b.j(string, (o50) this.j);
                        ((Context) this.k).startService(kl1.a((Context) this.k, m90.i(lz1VarI), (o50) this.j));
                    }
                    ((nf1) this.h).i(null);
                    return;
                } catch (Throwable th) {
                    ((nf1) this.h).j(th);
                    return;
                }
        }
    }

    public sj0(rl0 rl0Var, hl0 hl0Var, ArrayList arrayList, ArrayList arrayList2, jq1 jq1Var) {
        this.g = 1;
        this.l = rl0Var;
        this.j = hl0Var;
        this.h = arrayList;
        this.i = arrayList2;
        this.k = jq1Var;
    }
}
