package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class ah0 extends hi0 {
    public static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(ah0.class, "_invoked");
    private volatile int _invoked;
    public final o70 k;

    public ah0(o70 o70Var) {
        this.k = o70Var;
    }

    @Override // defpackage.o70
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m((Throwable) obj);
        return zp1.a;
    }

    @Override // defpackage.ti0
    public final void m(Throwable th) {
        if (l.compareAndSet(this, 0, 1)) {
            this.k.invoke(th);
        }
    }
}
