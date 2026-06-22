package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ga extends au0 {
    public byte[] b = az1.c;
    public long c = 0;

    public ga() {
        this.a = -1;
    }

    @Override // defpackage.au0
    public final int a() {
        byte[] bArr = this.b;
        return tj.c(2, this.c) + tj.e(bArr.length) + bArr.length + tj.g(1);
    }

    @Override // defpackage.au0
    public final au0 b(rj rjVar) throws tg0 {
        while (true) {
            int i = rjVar.i();
            if (i == 0) {
                break;
            }
            if (i == 10) {
                this.b = rjVar.a();
            } else if (i == 16) {
                this.c = rjVar.b();
            } else if (!rjVar.j(i)) {
                break;
            }
        }
        return this;
    }

    @Override // defpackage.au0
    public final void e(tj tjVar) throws sj {
        tjVar.m(1, this.b);
        tjVar.q(2, this.c);
    }
}
