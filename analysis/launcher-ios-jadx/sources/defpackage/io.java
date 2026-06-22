package defpackage;

import android.os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class io extends AtomicBoolean implements OutcomeReceiver {
    public final gg g;

    public io(gg ggVar) {
        super(false);
        this.g = ggVar;
    }

    @Override // android.os.OutcomeReceiver
    public final void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            this.g.resumeWith(np1.e(th));
        }
    }

    @Override // android.os.OutcomeReceiver
    public final void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.g.resumeWith(obj);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
