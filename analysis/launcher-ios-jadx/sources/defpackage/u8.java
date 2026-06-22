package defpackage;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class u8 extends m90 {
    public static volatile u8 m;
    public static final t8 n = new t8(0);
    public final fu l = new fu();

    public static u8 u() {
        if (m != null) {
            return m;
        }
        synchronized (u8.class) {
            try {
                if (m == null) {
                    m = new u8();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return m;
    }

    public final void v(Runnable runnable) {
        fu fuVar = this.l;
        if (fuVar.n == null) {
            synchronized (fuVar.l) {
                try {
                    if (fuVar.n == null) {
                        fuVar.n = fu.u(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        fuVar.n.post(runnable);
    }
}
