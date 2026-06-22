package defpackage;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class g42 extends Thread {
    public final WeakReference g;
    public final long h;
    public final CountDownLatch i = new CountDownLatch(1);
    public boolean j = false;

    public g42(f3 f3Var, long j) {
        this.g = new WeakReference(f3Var);
        this.h = j;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        f3 f3Var;
        WeakReference weakReference = this.g;
        try {
            if (this.i.await(this.h, TimeUnit.MILLISECONDS) || (f3Var = (f3) weakReference.get()) == null) {
                return;
            }
            f3Var.c();
            this.j = true;
        } catch (InterruptedException unused) {
            f3 f3Var2 = (f3) weakReference.get();
            if (f3Var2 != null) {
                f3Var2.c();
                this.j = true;
            }
        }
    }
}
