package defpackage;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class cx0 extends Thread {
    public final PriorityBlockingQueue g;
    public final q11 h;
    public final ov i;
    public final mc1 j;
    public volatile boolean k = false;

    public cx0(PriorityBlockingQueue priorityBlockingQueue, q11 q11Var, ov ovVar, mc1 mc1Var) {
        this.g = priorityBlockingQueue;
        this.h = q11Var;
        this.i = ovVar;
        this.j = mc1Var;
    }

    private void a() {
        ef efVar;
        yi0 yi0Var = (yi0) this.g.take();
        mc1 mc1Var = this.j;
        SystemClock.elapsedRealtime();
        yi0Var.i();
        try {
            try {
                try {
                    yi0Var.a("network-queue-take");
                    yi0Var.e();
                    TrafficStats.setThreadStatsTag(yi0Var.i);
                    uv uvVarJ = this.h.J(yi0Var);
                    yi0Var.a("network-http-complete");
                    if (uvVarJ.h && yi0Var.d()) {
                        yi0Var.c("not-modified");
                        yi0Var.f();
                        return;
                    }
                    uv uvVarH = yi0Var.h(uvVarJ);
                    yi0Var.a("network-parse-complete");
                    if (yi0Var.n && (efVar = (ef) uvVarH.g) != null) {
                        this.i.f(yi0Var.h, efVar);
                        yi0Var.a("network-cache-written");
                    }
                    synchronized (yi0Var.j) {
                        yi0Var.o = true;
                    }
                    mc1Var.z(yi0Var, uvVarH, null);
                    yi0Var.g(uvVarH);
                } catch (dv1 e) {
                    SystemClock.elapsedRealtime();
                    mc1Var.getClass();
                    yi0Var.a("post-error");
                    ((k10) mc1Var.h).execute(new xm(yi0Var, new uv(e), null, 2));
                    yi0Var.f();
                }
            } catch (Exception e2) {
                gv1.a("Unhandled exception %s", e2.toString());
                dv1 dv1Var = new dv1(e2);
                SystemClock.elapsedRealtime();
                mc1Var.getClass();
                yi0Var.a("post-error");
                ((k10) mc1Var.h).execute(new xm(yi0Var, new uv(dv1Var), null, 2));
                yi0Var.f();
            }
        } finally {
            yi0Var.i();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.k) {
                    Thread.currentThread().interrupt();
                    return;
                }
                gv1.a("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
