package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class la extends au0 {
    public int b = 0;
    public byte[] c = az1.c;

    public la() {
        this.a = -1;
    }

    @Override // defpackage.au0
    public final int a() {
        int iA = tj.a(1, this.b);
        byte[] bArr = this.c;
        return tj.e(bArr.length) + bArr.length + tj.g(2) + iA;
    }

    @Override // defpackage.au0
    public final au0 b(rj rjVar) throws tg0 {
        while (true) {
            int i = rjVar.i();
            if (i == 0) {
                break;
            }
            if (i == 8) {
                this.b = rjVar.g();
            } else if (i == 18) {
                this.c = rjVar.a();
            } else if (!rjVar.j(i)) {
                break;
            }
        }
        return this;
    }

    @Override // defpackage.au0
    public final void e(tj tjVar) throws sj {
        tjVar.p(1, this.b);
        tjVar.m(2, this.c);
    }
}
