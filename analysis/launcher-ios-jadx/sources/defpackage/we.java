package defpackage;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class we {
    public final ArrayDeque a;

    public we(int i) {
        switch (i) {
            case 1:
                this.a = new ArrayDeque();
                break;
            default:
                char[] cArr = vq1.a;
                this.a = new ArrayDeque(0);
                break;
        }
    }

    public rv a() {
        rv rvVar;
        synchronized (this.a) {
            rvVar = (rv) this.a.poll();
        }
        return rvVar == null ? new rv() : rvVar;
    }

    public void b(rv rvVar) {
        synchronized (this.a) {
            try {
                if (this.a.size() < 10) {
                    this.a.offer(rvVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void c(t80 t80Var) {
        t80Var.b = null;
        t80Var.c = null;
        this.a.offer(t80Var);
    }
}
