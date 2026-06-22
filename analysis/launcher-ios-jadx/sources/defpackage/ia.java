package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ia extends au0 {
    public long b = 0;
    public int c = 0;
    public String d = "";
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public String m = "";
    public String n = "";
    public String o = "";
    public int p = 0;
    public String q = "";
    public String r = "";
    public byte[] s = az1.c;
    public int t = 0;
    public int u = 0;

    public ia() {
        this.a = -1;
    }

    @Override // defpackage.au0
    public final int a() {
        int iA = tj.a(2, this.c) + tj.c(1, this.b);
        if (!this.d.equals("")) {
            iA += tj.f(3, this.d);
        }
        int i = this.e;
        if (i != 0) {
            iA += tj.a(4, i);
        }
        int i2 = this.f;
        if (i2 != 0) {
            iA += tj.a(5, i2);
        }
        int i3 = this.g;
        if (i3 != 0) {
            iA += tj.a(6, i3);
        }
        int i4 = this.h;
        if (i4 != 0) {
            iA += tj.a(7, i4);
        }
        int i5 = this.i;
        if (i5 != 0) {
            iA += tj.a(8, i5);
        }
        int i6 = this.j;
        if (i6 != 0) {
            iA += tj.a(9, i6);
        }
        int i7 = this.k;
        if (i7 != 0) {
            iA += tj.a(10, i7);
        }
        int i8 = this.l;
        if (i8 != 0) {
            iA += tj.a(11, i8);
        }
        if (!this.m.equals("")) {
            iA += tj.f(12, this.m);
        }
        if (!this.n.equals("")) {
            iA += tj.f(13, this.n);
        }
        if (!this.o.equals("")) {
            iA += tj.f(14, this.o);
        }
        int i9 = this.p;
        if (i9 != 0) {
            iA += tj.a(15, i9);
        }
        if (!this.q.equals("")) {
            iA += tj.f(16, this.q);
        }
        if (!this.r.equals("")) {
            iA += tj.f(17, this.r);
        }
        if (!Arrays.equals(this.s, az1.c)) {
            byte[] bArr = this.s;
            iA += tj.e(bArr.length) + bArr.length + tj.g(18);
        }
        int i10 = this.t;
        if (i10 != 0) {
            iA += tj.a(19, i10);
        }
        int i11 = this.u;
        return i11 != 0 ? tj.a(20, i11) + iA : iA;
    }

    @Override // defpackage.au0
    public final au0 b(rj rjVar) throws tg0 {
        while (true) {
            int i = rjVar.i();
            switch (i) {
                case 0:
                    break;
                case 8:
                    this.b = rjVar.b();
                    break;
                case 16:
                    this.c = rjVar.g();
                    break;
                case 26:
                    this.d = rjVar.h();
                    break;
                case 32:
                    this.e = rjVar.g();
                    break;
                case 40:
                    this.f = rjVar.g();
                    break;
                case 48:
                    this.g = rjVar.g();
                    break;
                case 56:
                    this.h = rjVar.g();
                    break;
                case 64:
                    this.i = rjVar.g();
                    break;
                case 72:
                    this.j = rjVar.g();
                    break;
                case 80:
                    this.k = rjVar.g();
                    break;
                case 88:
                    this.l = rjVar.g();
                    break;
                case 98:
                    this.m = rjVar.h();
                    break;
                case 106:
                    this.n = rjVar.h();
                    break;
                case 114:
                    this.o = rjVar.h();
                    break;
                case 120:
                    this.p = rjVar.g();
                    break;
                case 130:
                    this.q = rjVar.h();
                    break;
                case 138:
                    this.r = rjVar.h();
                    break;
                case 146:
                    this.s = rjVar.a();
                    break;
                case 152:
                    int iG = rjVar.g();
                    switch (iG) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.t = iG;
                            break;
                    }
                    break;
                case 160:
                    this.u = rjVar.g();
                    break;
                default:
                    if (!rjVar.j(i)) {
                    }
                    break;
            }
        }
        return this;
    }

    @Override // defpackage.au0
    public final void e(tj tjVar) throws sj {
        tjVar.q(1, this.b);
        tjVar.p(2, this.c);
        if (!this.d.equals("")) {
            tjVar.v(3, this.d);
        }
        int i = this.e;
        if (i != 0) {
            tjVar.p(4, i);
        }
        int i2 = this.f;
        if (i2 != 0) {
            tjVar.p(5, i2);
        }
        int i3 = this.g;
        if (i3 != 0) {
            tjVar.p(6, i3);
        }
        int i4 = this.h;
        if (i4 != 0) {
            tjVar.p(7, i4);
        }
        int i5 = this.i;
        if (i5 != 0) {
            tjVar.p(8, i5);
        }
        int i6 = this.j;
        if (i6 != 0) {
            tjVar.p(9, i6);
        }
        int i7 = this.k;
        if (i7 != 0) {
            tjVar.p(10, i7);
        }
        int i8 = this.l;
        if (i8 != 0) {
            tjVar.p(11, i8);
        }
        if (!this.m.equals("")) {
            tjVar.v(12, this.m);
        }
        if (!this.n.equals("")) {
            tjVar.v(13, this.n);
        }
        if (!this.o.equals("")) {
            tjVar.v(14, this.o);
        }
        int i9 = this.p;
        if (i9 != 0) {
            tjVar.p(15, i9);
        }
        if (!this.q.equals("")) {
            tjVar.v(16, this.q);
        }
        if (!this.r.equals("")) {
            tjVar.v(17, this.r);
        }
        if (!Arrays.equals(this.s, az1.c)) {
            tjVar.m(18, this.s);
        }
        int i10 = this.t;
        if (i10 != 0) {
            tjVar.p(19, i10);
        }
        int i11 = this.u;
        if (i11 != 0) {
            tjVar.p(20, i11);
        }
    }
}
