package defpackage;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class e80 implements Runnable {
    public static final ThreadLocal k = new ThreadLocal();
    public static final y4 l = new y4(5);
    public ArrayList g;
    public long h;
    public long i;
    public ArrayList j;

    public static m91 c(RecyclerView recyclerView, int i, long j) {
        int iK = recyclerView.l.k();
        for (int i2 = 0; i2 < iK; i2++) {
            m91 m91VarQ = RecyclerView.Q(recyclerView.l.j(i2));
            if (m91VarQ.i == i && !m91VarQ.k()) {
                return null;
            }
        }
        c91 c91Var = recyclerView.i;
        try {
            recyclerView.X();
            m91 m91VarK = c91Var.k(i, j);
            if (m91VarK != null) {
                if (!m91VarK.j() || m91VarK.k()) {
                    c91Var.a(m91VarK, false);
                } else {
                    c91Var.h(m91VarK.g);
                }
            }
            recyclerView.Y(false);
            return m91VarK;
        } catch (Throwable th) {
            recyclerView.Y(false);
            throw th;
        }
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.y) {
            if (RecyclerView.G0 && !this.g.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.h == 0) {
                this.h = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        c80 c80Var = recyclerView.m0;
        c80Var.a = i;
        c80Var.b = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r17) {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e80.b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i = no1.a;
            Trace.beginSection("RV Prefetch");
            ArrayList arrayList = this.g;
            if (arrayList.isEmpty()) {
                this.h = 0L;
                Trace.endSection();
                return;
            }
            int size = arrayList.size();
            long jMax = 0;
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i2);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                this.h = 0L;
                Trace.endSection();
            } else {
                b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.i);
                this.h = 0L;
                Trace.endSection();
            }
        } catch (Throwable th) {
            this.h = 0L;
            int i3 = no1.a;
            Trace.endSection();
            throw th;
        }
    }
}
