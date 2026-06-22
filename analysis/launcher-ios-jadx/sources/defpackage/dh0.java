package defpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class dh0 extends sd1 implements Runnable {
    public final ch0 h;
    public final eh0 i;
    public final AtomicBoolean j = new AtomicBoolean();
    public final el g = new el(0);

    public dh0(ch0 ch0Var) {
        eh0 eh0Var;
        eh0 eh0Var2;
        this.h = ch0Var;
        if (ch0Var.i.h) {
            eh0Var2 = fh0.f;
        } else {
            while (true) {
                if (ch0Var.h.isEmpty()) {
                    eh0Var = new eh0(ch0Var.l);
                    ch0Var.i.a(eh0Var);
                    break;
                } else {
                    eh0Var = (eh0) ch0Var.h.poll();
                    if (eh0Var != null) {
                        break;
                    }
                }
            }
            eh0Var2 = eh0Var;
        }
        this.i = eh0Var2;
    }

    @Override // defpackage.sd1
    public final cw a(rd1 rd1Var) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return this.g.h ? tz.g : this.i.c(rd1Var, this.g);
    }

    @Override // defpackage.cw
    public final void b() {
        if (this.j.compareAndSet(false, true)) {
            this.g.b();
            boolean z = fh0.g;
            eh0 eh0Var = this.i;
            if (z) {
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                eh0Var.c(this, null);
            } else {
                ch0 ch0Var = this.h;
                ch0Var.getClass();
                eh0Var.i = System.nanoTime() + ch0Var.g;
                ch0Var.h.offer(eh0Var);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ch0 ch0Var = this.h;
        ch0Var.getClass();
        long jNanoTime = System.nanoTime() + ch0Var.g;
        eh0 eh0Var = this.i;
        eh0Var.i = jNanoTime;
        ch0Var.h.offer(eh0Var);
    }
}
