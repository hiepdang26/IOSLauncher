package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ka extends au0 {
    public static volatile ka[] f;
    public int b = 1;
    public String c = "";
    public long d = 0;
    public long e = 0;

    public ka() {
        this.a = -1;
    }

    @Override // defpackage.au0
    public final int a() {
        int iA = tj.a(1, this.b);
        if (!this.c.equals("")) {
            iA += tj.f(2, this.c);
        }
        long j = this.d;
        if (j != 0) {
            iA += tj.c(3, j);
        }
        long j2 = this.e;
        return j2 != 0 ? tj.c(4, j2) + iA : iA;
    }

    @Override // defpackage.au0
    public final au0 b(rj rjVar) throws tg0 {
        while (true) {
            int i = rjVar.i();
            if (i == 0) {
                break;
            }
            if (i == 8) {
                int iG = rjVar.g();
                if (iG == 1 || iG == 2 || iG == 3 || iG == 4) {
                    this.b = iG;
                }
            } else if (i == 18) {
                this.c = rjVar.h();
            } else if (i == 24) {
                this.d = rjVar.b();
            } else if (i == 32) {
                this.e = rjVar.b();
            } else if (!rjVar.j(i)) {
                break;
            }
        }
        return this;
    }

    @Override // defpackage.au0
    public final void e(tj tjVar) throws sj {
        tjVar.p(1, this.b);
        if (!this.c.equals("")) {
            tjVar.v(2, this.c);
        }
        long j = this.d;
        if (j != 0) {
            tjVar.q(3, j);
        }
        long j2 = this.e;
        if (j2 != 0) {
            tjVar.q(4, j2);
        }
    }
}
