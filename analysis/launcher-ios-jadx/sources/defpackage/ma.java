package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ma extends au0 {
    public long b = 0;
    public int c = 0;

    public ma() {
        this.a = -1;
    }

    @Override // defpackage.au0
    public final int a() {
        int iC = tj.c(1, this.b);
        int i = this.c;
        return i != 0 ? tj.a(2, i) + iC : iC;
    }

    @Override // defpackage.au0
    public final au0 b(rj rjVar) throws tg0 {
        while (true) {
            int i = rjVar.i();
            if (i == 0) {
                break;
            }
            if (i == 8) {
                this.b = rjVar.b();
            } else if (i == 16) {
                this.c = rjVar.g();
            } else if (!rjVar.j(i)) {
                break;
            }
        }
        return this;
    }

    @Override // defpackage.au0
    public final void e(tj tjVar) throws sj {
        tjVar.q(1, this.b);
        int i = this.c;
        if (i != 0) {
            tjVar.p(2, i);
        }
    }
}
