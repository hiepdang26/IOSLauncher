package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class jz1 {
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(jz1.class, Object.class, "lastScheduledTask");
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(jz1.class, "producerIndex");
    public static final AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(jz1.class, "consumerIndex");
    public static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(jz1.class, "blockingTasksInBuffer");
    public final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final om1 a(om1 om1Var) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = c;
        if (atomicIntegerFieldUpdater.get(this) - d.get(this) == 127) {
            return om1Var;
        }
        if (om1Var.h.g == 1) {
            e.incrementAndGet(this);
        }
        int i = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.a;
            if (atomicReferenceArray.get(i) == null) {
                atomicReferenceArray.lazySet(i, om1Var);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final om1 b() {
        om1 om1Var;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (om1Var = (om1) this.a.getAndSet(i2, null)) != null) {
                if (om1Var.h.g == 1) {
                    e.decrementAndGet(this);
                }
                return om1Var;
            }
        }
    }

    public final om1 c(int i, boolean z) {
        int i2 = i & 127;
        AtomicReferenceArray atomicReferenceArray = this.a;
        om1 om1Var = (om1) atomicReferenceArray.get(i2);
        if (om1Var != null) {
            if ((om1Var.h.g == 1) == z) {
                while (!atomicReferenceArray.compareAndSet(i2, om1Var, null)) {
                    if (atomicReferenceArray.get(i2) != om1Var) {
                    }
                }
                if (z) {
                    e.decrementAndGet(this);
                }
                return om1Var;
            }
        }
        return null;
    }
}
