package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class na extends au0 {
    public String b = "";
    public String c = "";
    public boolean d = false;
    public la e = null;
    public la f = null;
    public int g = 2;
    public int h = 2;

    public na() {
        this.a = -1;
    }

    @Override // defpackage.au0
    public final int a() {
        int iF = tj.f(1, this.b);
        if (!this.c.equals("")) {
            iF += tj.f(2, this.c);
        }
        if (this.d) {
            iF += tj.g(3) + 1;
        }
        la laVar = this.e;
        if (laVar != null) {
            iF += tj.d(4, laVar);
        }
        la laVar2 = this.f;
        if (laVar2 != null) {
            iF += tj.d(5, laVar2);
        }
        int i = this.g;
        if (i != 2) {
            iF += tj.a(6, i);
        }
        int i2 = this.h;
        return i2 != 2 ? tj.a(7, i2) + iF : iF;
    }

    @Override // defpackage.au0
    public final au0 b(rj rjVar) throws tg0 {
        while (true) {
            int i = rjVar.i();
            if (i == 0) {
                break;
            }
            if (i == 10) {
                this.b = rjVar.h();
            } else if (i == 18) {
                this.c = rjVar.h();
            } else if (i == 24) {
                this.d = rjVar.g() != 0;
            } else if (i == 34) {
                if (this.e == null) {
                    this.e = new la();
                }
                rjVar.c(this.e);
            } else if (i == 42) {
                if (this.f == null) {
                    this.f = new la();
                }
                rjVar.c(this.f);
            } else if (i == 48) {
                this.g = rjVar.g();
            } else if (i == 56) {
                this.h = rjVar.g();
            } else if (!rjVar.j(i)) {
                break;
            }
        }
        return this;
    }

    @Override // defpackage.au0
    public final void e(tj tjVar) throws sj {
        tjVar.v(1, this.b);
        if (!this.c.equals("")) {
            tjVar.v(2, this.c);
        }
        boolean z = this.d;
        if (z) {
            tjVar.w(3, 0);
            tjVar.s(z ? 1 : 0);
        }
        la laVar = this.e;
        if (laVar != null) {
            tjVar.r(4, laVar);
        }
        la laVar2 = this.f;
        if (laVar2 != null) {
            tjVar.r(5, laVar2);
        }
        int i = this.g;
        if (i != 2) {
            tjVar.p(6, i);
        }
        int i2 = this.h;
        if (i2 != 2) {
            tjVar.p(7, i2);
        }
    }
}
