package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ig {
    public boolean a;
    public hg b;
    public boolean c;

    public final void a(hg hgVar) {
        synchronized (this) {
            while (this.c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (this.b == hgVar) {
                return;
            }
            this.b = hgVar;
            if (this.a) {
                hgVar.n();
            }
        }
    }
}
