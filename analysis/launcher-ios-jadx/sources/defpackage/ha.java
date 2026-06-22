package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ha extends au0 {
    public float b = 0.0f;
    public float c = 0.0f;
    public float d = 0.0f;
    public int e = 0;

    public ha() {
        this.a = -1;
    }

    @Override // defpackage.au0
    public final int a() {
        return tj.a(4, this.e) + tj.g(3) + 4 + tj.g(2) + 4 + tj.g(1) + 4;
    }

    @Override // defpackage.au0
    public final au0 b(rj rjVar) throws tg0 {
        while (true) {
            int i = rjVar.i();
            if (i == 0) {
                break;
            }
            if (i == 13) {
                this.b = Float.intBitsToFloat(rjVar.f());
            } else if (i == 21) {
                this.c = Float.intBitsToFloat(rjVar.f());
            } else if (i == 29) {
                this.d = Float.intBitsToFloat(rjVar.f());
            } else if (i == 32) {
                this.e = rjVar.g();
            } else if (!rjVar.j(i)) {
                break;
            }
        }
        return this;
    }

    @Override // defpackage.au0
    public final void e(tj tjVar) throws sj {
        tjVar.n(this.b, 1);
        tjVar.n(this.c, 2);
        tjVar.n(this.d, 3);
        tjVar.p(4, this.e);
    }
}
