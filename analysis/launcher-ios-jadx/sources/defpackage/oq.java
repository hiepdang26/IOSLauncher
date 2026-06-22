package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class oq extends pq {
    public double a;
    public double[] b;

    @Override // defpackage.pq
    public final double b(double d) {
        return this.b[0];
    }

    @Override // defpackage.pq
    public final void c(double d, double[] dArr) {
        double[] dArr2 = this.b;
        System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
    }

    @Override // defpackage.pq
    public final void d(double d, float[] fArr) {
        int i = 0;
        while (true) {
            double[] dArr = this.b;
            if (i >= dArr.length) {
                return;
            }
            fArr[i] = (float) dArr[i];
            i++;
        }
    }

    @Override // defpackage.pq
    public final double e(double d) {
        return 0.0d;
    }

    @Override // defpackage.pq
    public final void f(double d, double[] dArr) {
        for (int i = 0; i < this.b.length; i++) {
            dArr[i] = 0.0d;
        }
    }

    @Override // defpackage.pq
    public final double[] g() {
        return new double[]{this.a};
    }
}
