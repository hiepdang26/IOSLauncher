package defpackage;

import android.os.Process;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class hf extends Thread {
    public static final boolean m = gv1.a;
    public final PriorityBlockingQueue g;
    public final PriorityBlockingQueue h;
    public final ov i;
    public final mc1 j;
    public volatile boolean k = false;
    public final hz1 l;

    public hf(PriorityBlockingQueue priorityBlockingQueue, PriorityBlockingQueue priorityBlockingQueue2, ov ovVar, mc1 mc1Var) {
        this.g = priorityBlockingQueue;
        this.h = priorityBlockingQueue2;
        this.i = ovVar;
        this.j = mc1Var;
        this.l = new hz1(this, priorityBlockingQueue2, mc1Var);
    }

    private void a() {
        yi0 yi0Var = (yi0) this.g.take();
        yi0Var.a("cache-queue-take");
        yi0Var.i();
        try {
            yi0Var.e();
            ef efVarA = this.i.a(yi0Var.h);
            if (efVarA == null) {
                yi0Var.a("cache-miss");
                if (!this.l.c(yi0Var)) {
                    this.h.put(yi0Var);
                }
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (efVarA.e < jCurrentTimeMillis) {
                yi0Var.a("cache-hit-expired");
                yi0Var.q = efVarA;
                if (!this.l.c(yi0Var)) {
                    this.h.put(yi0Var);
                }
                return;
            }
            yi0Var.a("cache-hit");
            uv uvVarH = yi0Var.h(new uv(efVarA.a, efVarA.g));
            yi0Var.a("cache-hit-parsed");
            if (((dv1) uvVarH.j) == null) {
                if (efVarA.f < jCurrentTimeMillis) {
                    yi0Var.a("cache-hit-refresh-needed");
                    yi0Var.q = efVarA;
                    uvVarH.h = true;
                    if (this.l.c(yi0Var)) {
                        this.j.z(yi0Var, uvVarH, null);
                    } else {
                        this.j.z(yi0Var, uvVarH, new w1(this, yi0Var, 6, false));
                    }
                } else {
                    this.j.z(yi0Var, uvVarH, null);
                }
                return;
            }
            yi0Var.a("cache-parsing-failed");
            ov ovVar = this.i;
            String str = yi0Var.h;
            synchronized (ovVar) {
                ef efVarA2 = ovVar.a(str);
                if (efVarA2 != null) {
                    efVarA2.f = 0L;
                    efVarA2.e = 0L;
                    ovVar.f(str, efVarA2);
                }
            }
            yi0Var.q = null;
            if (!this.l.c(yi0Var)) {
                this.h.put(yi0Var);
            }
        } finally {
            yi0Var.i();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (m) {
            gv1.b("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.i.d();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.k) {
                    Thread.currentThread().interrupt();
                    return;
                }
                gv1.a("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
