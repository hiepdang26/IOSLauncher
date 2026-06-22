package defpackage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes.dex */
public final class f21 extends s {
    @Override // defpackage.s
    public final Random a() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        qg0.k(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
