package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class nx {
    public boolean i;
    public ax m;
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public boolean e = false;
    public zw f = null;
    public Object g = null;
    public xw h = null;
    public vz1 j = null;
    public boolean k = false;
    public boolean l = true;

    public final float[] a(float[] fArr) {
        if (fArr == null) {
            fArr = new float[2];
        }
        int i = this.a - this.c;
        int i2 = this.b - this.d;
        fArr[0] = (this.f.getDragRegion().width() / 2) + i;
        fArr[1] = (this.f.getDragRegion().height() / 2) + i2;
        return fArr;
    }
}
