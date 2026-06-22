package defpackage;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class j10 extends i10 implements ju {
    public final jf1 i;

    public j10(jf1 jf1Var) {
        this.i = jf1Var;
        Method method = nl.a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.i;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof j10) && ((j10) obj).i == this.i;
    }

    public final int hashCode() {
        return System.identityHashCode(this.i);
    }

    @Override // defpackage.cp
    public final String toString() {
        return this.i.toString();
    }

    @Override // defpackage.cp
    public final void z(yo yoVar, Runnable runnable) {
        try {
            this.i.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            fi0 fi0Var = (fi0) yoVar.n(iy.i);
            if (fi0Var != null) {
                fi0Var.b(cancellationException);
            }
            aw.b.z(yoVar, runnable);
        }
    }
}
