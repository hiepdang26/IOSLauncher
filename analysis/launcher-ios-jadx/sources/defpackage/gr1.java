package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class gr1 extends fr1 {
    public t11[] a;
    public String b;
    public int c;

    public gr1() {
        this.a = null;
        this.c = 0;
    }

    public t11[] getPathData() {
        return this.a;
    }

    public String getPathName() {
        return this.b;
    }

    public void setPathData(t11[] t11VarArr) {
        if (!p02.b(this.a, t11VarArr)) {
            this.a = p02.j(t11VarArr);
            return;
        }
        t11[] t11VarArr2 = this.a;
        for (int i = 0; i < t11VarArr.length; i++) {
            t11VarArr2[i].a = t11VarArr[i].a;
            int i2 = 0;
            while (true) {
                float[] fArr = t11VarArr[i].b;
                if (i2 < fArr.length) {
                    t11VarArr2[i].b[i2] = fArr[i2];
                    i2++;
                }
            }
        }
    }

    public gr1(gr1 gr1Var) {
        this.a = null;
        this.c = 0;
        this.b = gr1Var.b;
        this.a = p02.j(gr1Var.a);
    }
}
