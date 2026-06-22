package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class tm1 extends om1 {
    public final Runnable i;

    public tm1(Runnable runnable, long j, cx cxVar) {
        super(j, cxVar);
        this.i = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.i.run();
        } finally {
            this.h.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.i;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(os.e(runnable));
        sb.append(", ");
        sb.append(this.g);
        sb.append(", ");
        sb.append(this.h);
        sb.append(']');
        return sb.toString();
    }
}
