package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class ew implements cw {
    public static final ew g;
    public static final /* synthetic */ ew[] h;

    static {
        ew ewVar = new ew("DISPOSED", 0);
        g = ewVar;
        h = new ew[]{ewVar};
    }

    public static void a(AtomicReference atomicReference) {
        cw cwVar;
        cw cwVar2 = (cw) atomicReference.get();
        ew ewVar = g;
        if (cwVar2 == ewVar || (cwVar = (cw) atomicReference.getAndSet(ewVar)) == ewVar || cwVar == null) {
            return;
        }
        cwVar.b();
    }

    public static boolean c(AtomicReference atomicReference, cw cwVar) {
        while (true) {
            cw cwVar2 = (cw) atomicReference.get();
            if (cwVar2 == g) {
                if (cwVar == null) {
                    return false;
                }
                cwVar.b();
                return false;
            }
            while (!atomicReference.compareAndSet(cwVar2, cwVar)) {
                if (atomicReference.get() != cwVar2) {
                    break;
                }
            }
            return true;
        }
    }

    public static boolean d(AtomicReference atomicReference, cw cwVar) {
        while (!atomicReference.compareAndSet(null, cwVar)) {
            if (atomicReference.get() != null) {
                cwVar.b();
                if (atomicReference.get() == g) {
                    return false;
                }
                e42.m(new qj("Disposable already set!"));
                return false;
            }
        }
        return true;
    }

    public static ew valueOf(String str) {
        return (ew) Enum.valueOf(ew.class, str);
    }

    public static ew[] values() {
        return (ew[]) h.clone();
    }

    @Override // defpackage.cw
    public final void b() {
    }
}
