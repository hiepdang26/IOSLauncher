package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class qa0 extends qh0 implements Comparable {
    public float x;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        qa0 qa0Var = (qa0) obj;
        if (this.h == 4) {
            if (qa0Var.h == 4) {
                return (qa0Var.n * qa0Var.m) - (this.m * this.n);
            }
            return -1;
        }
        if (qa0Var.h == 4) {
            return 1;
        }
        return Float.compare(qa0Var.x, this.x);
    }
}
