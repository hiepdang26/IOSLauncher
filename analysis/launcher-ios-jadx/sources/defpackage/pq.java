package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class pq {
    public static pq a(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        if (i == 0) {
            return new ou0(dArr, dArr2);
        }
        if (i == 2) {
            double d = dArr[0];
            double[] dArr3 = dArr2[0];
            oq oqVar = new oq();
            oqVar.a = d;
            oqVar.b = dArr3;
            return oqVar;
        }
        kn0 kn0Var = new kn0();
        int length = dArr2[0].length;
        kn0Var.c = new double[length];
        kn0Var.a = dArr;
        kn0Var.b = dArr2;
        if (length > 2) {
            double d2 = 0.0d;
            int i2 = 0;
            while (true) {
                double d3 = d2;
                if (i2 >= dArr.length) {
                    break;
                }
                double d4 = dArr2[i2][0];
                if (i2 > 0) {
                    Math.hypot(d4 - d2, d4 - d3);
                }
                i2++;
                d2 = d4;
            }
        }
        return kn0Var;
    }

    public abstract double b(double d);

    public abstract void c(double d, double[] dArr);

    public abstract void d(double d, float[] fArr);

    public abstract double e(double d);

    public abstract void f(double d, double[] dArr);

    public abstract double[] g();
}
