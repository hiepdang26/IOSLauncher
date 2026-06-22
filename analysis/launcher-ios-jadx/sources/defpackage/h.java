package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final h c;
    public static final h d;
    public final boolean a;
    public final CancellationException b;

    static {
        if (p.j) {
            d = null;
            c = null;
        } else {
            d = new h(false, null);
            c = new h(true, null);
        }
    }

    public h(boolean z, CancellationException cancellationException) {
        this.a = z;
        this.b = cancellationException;
    }
}
