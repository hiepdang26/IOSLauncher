package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class ja extends au0 {
    public int b;
    public long c;
    public long d;
    public int e;
    public ka[] f;
    public int g;
    public ha h;

    public ja() {
        f();
    }

    @Override // defpackage.au0
    public final int a() {
        int iC = tj.c(2, this.c) + tj.a(1, this.b);
        long j = this.d;
        if (j != 0) {
            iC += tj.c(3, j);
        }
        int i = this.e;
        if (i != 0) {
            iC += tj.a(4, i);
        }
        ka[] kaVarArr = this.f;
        if (kaVarArr != null && kaVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                ka[] kaVarArr2 = this.f;
                if (i2 >= kaVarArr2.length) {
                    break;
                }
                ka kaVar = kaVarArr2[i2];
                if (kaVar != null) {
                    iC = tj.d(5, kaVar) + iC;
                }
                i2++;
            }
        }
        int i3 = this.g;
        if (i3 != 1) {
            iC += tj.a(6, i3);
        }
        ha haVar = this.h;
        return haVar != null ? tj.d(7, haVar) + iC : iC;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d1, code lost:
    
        return r5;
     */
    @Override // defpackage.au0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.au0 b(defpackage.rj r6) throws defpackage.tg0 {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ja.b(rj):au0");
    }

    @Override // defpackage.au0
    public final void e(tj tjVar) throws sj {
        tjVar.p(1, this.b);
        tjVar.q(2, this.c);
        long j = this.d;
        if (j != 0) {
            tjVar.q(3, j);
        }
        int i = this.e;
        if (i != 0) {
            tjVar.p(4, i);
        }
        ka[] kaVarArr = this.f;
        if (kaVarArr != null && kaVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                ka[] kaVarArr2 = this.f;
                if (i2 >= kaVarArr2.length) {
                    break;
                }
                ka kaVar = kaVarArr2[i2];
                if (kaVar != null) {
                    tjVar.r(5, kaVar);
                }
                i2++;
            }
        }
        int i3 = this.g;
        if (i3 != 1) {
            tjVar.p(6, i3);
        }
        ha haVar = this.h;
        if (haVar != null) {
            tjVar.r(7, haVar);
        }
    }

    public final void f() {
        this.b = 0;
        this.c = 0L;
        this.d = 0L;
        this.e = 0;
        if (ka.f == null) {
            synchronized (ng0.b) {
                try {
                    if (ka.f == null) {
                        ka.f = new ka[0];
                    }
                } finally {
                }
            }
        }
        this.f = ka.f;
        this.g = 1;
        this.h = null;
        this.a = -1;
    }
}
