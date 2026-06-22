package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class u {
    public static final u b;
    public static final u c;
    public final CancellationException a;

    static {
        if (a0.j) {
            c = null;
            b = null;
        } else {
            c = new u(false, null);
            b = new u(true, null);
        }
    }

    public u(boolean z, CancellationException cancellationException) {
        this.a = cancellationException;
    }
}
