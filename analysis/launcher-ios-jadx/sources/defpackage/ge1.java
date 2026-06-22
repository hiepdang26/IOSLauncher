package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ge1 extends fy {
    public double d;
    public double e;

    @Override // defpackage.fy
    public final double a(double d) {
        double d2 = this.d;
        double d3 = this.e;
        if (d < d3) {
            return (d3 * d) / (((d3 - d) * d2) + d);
        }
        return ((d - 1.0d) * (1.0d - d3)) / ((1.0d - d) - ((d3 - d) * d2));
    }

    @Override // defpackage.fy
    public final double b(double d) {
        double d2 = this.d;
        double d3 = this.e;
        if (d < d3) {
            double d4 = d2 * d3 * d3;
            double d5 = ((d3 - d) * d2) + d;
            return d4 / (d5 * d5);
        }
        double d6 = d3 - 1.0d;
        double d7 = (((d3 - d) * (-d2)) - d) + 1.0d;
        return ((d6 * d2) * d6) / (d7 * d7);
    }
}
