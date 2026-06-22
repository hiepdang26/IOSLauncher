package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class hm1 implements Comparable {
    public final int g;
    public final int h;
    public final String i;
    public final String j;

    public hm1(int i, int i2, String str, String str2) {
        this.g = i;
        this.h = i2;
        this.i = str;
        this.j = str2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        hm1 hm1Var = (hm1) obj;
        qg0.l(hm1Var, "other");
        int i = this.g - hm1Var.g;
        return i == 0 ? this.h - hm1Var.h : i;
    }
}
