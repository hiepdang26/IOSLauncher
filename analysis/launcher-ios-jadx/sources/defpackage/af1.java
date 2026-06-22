package defpackage;

import androidx.profileinstaller.ProfileVerifier;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class af1 extends ol implements sx0 {
    public static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(af1.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;
    public final long i;

    public af1(long j2, vh vhVar, int i) {
        super(vhVar);
        this.i = j2;
        this.cleanedAndPointers = i << 16;
    }

    @Override // defpackage.ol
    public final boolean c() {
        return j.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return j.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i, yo yoVar);

    public final void h() {
        if (j.incrementAndGet(this) == le.b) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = j;
            i = atomicIntegerFieldUpdater.get(this);
            if (i == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST + i));
        return true;
    }
}
