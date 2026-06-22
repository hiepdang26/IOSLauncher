package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ze1 {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public ze1 f;
    public ze1 g;

    public ze1() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final ze1 a() {
        ze1 ze1Var = this.f;
        ze1 ze1Var2 = ze1Var != this ? ze1Var : null;
        ze1 ze1Var3 = this.g;
        ze1Var3.f = ze1Var;
        this.f.g = ze1Var3;
        this.f = null;
        this.g = null;
        return ze1Var2;
    }

    public final void b(ze1 ze1Var) {
        ze1Var.g = this;
        ze1Var.f = this.f;
        this.f.g = ze1Var;
        this.f = ze1Var;
    }

    public final ze1 c() {
        this.d = true;
        return new ze1(this.a, this.b, this.c);
    }

    public final void d(ze1 ze1Var, int i) {
        if (!ze1Var.e) {
            throw new IllegalArgumentException();
        }
        int i2 = ze1Var.c;
        int i3 = i2 + i;
        byte[] bArr = ze1Var.a;
        if (i3 > 8192) {
            if (ze1Var.d) {
                throw new IllegalArgumentException();
            }
            int i4 = ze1Var.b;
            if (i3 - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
            ze1Var.c -= ze1Var.b;
            ze1Var.b = 0;
        }
        System.arraycopy(this.a, this.b, bArr, ze1Var.c, i);
        ze1Var.c += i;
        this.b += i;
    }

    public ze1(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = true;
        this.e = false;
    }
}
