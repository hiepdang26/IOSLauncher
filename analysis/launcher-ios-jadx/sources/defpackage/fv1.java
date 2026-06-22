package defpackage;

import android.os.SystemClock;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class fv1 {
    public static final boolean c = gv1.a;
    public final ArrayList a = new ArrayList();
    public boolean b = false;

    public final synchronized void a(String str, long j) {
        if (this.b) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.a.add(new ev1(str, j, SystemClock.elapsedRealtime()));
    }

    public final synchronized void b(String str) {
        this.b = true;
        ArrayList arrayList = this.a;
        long j = arrayList.size() == 0 ? 0L : ((ev1) arrayList.get(arrayList.size() - 1)).c - ((ev1) arrayList.get(0)).c;
        if (j <= 0) {
            return;
        }
        long j2 = ((ev1) this.a.get(0)).c;
        gv1.a("(%-4d ms) %s", Long.valueOf(j), str);
        ArrayList arrayList2 = this.a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ev1 ev1Var = (ev1) obj;
            long j3 = ev1Var.c;
            gv1.a("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(ev1Var.b), ev1Var.a);
            j2 = j3;
        }
    }

    public final void finalize() {
        if (this.b) {
            return;
        }
        b("Request on the loose");
        gv1.a("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
}
