package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class il {
    public final int a;
    public final jl[] b;
    public long c;

    public il(int i, ad1 ad1Var) {
        this.a = i;
        this.b = new jl[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.b[i2] = new jl(ad1Var);
        }
    }
}
