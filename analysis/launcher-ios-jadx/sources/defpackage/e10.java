package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class e10 {
    public final hp1 a;
    public final iy b;
    public final g10 c;
    public final f10 d;
    public boolean e;

    public e10(hp1 hp1Var, d81 d81Var, iy iyVar, g10 g10Var, f10 f10Var) {
        this.a = hp1Var;
        this.b = iyVar;
        this.c = g10Var;
        this.d = f10Var;
    }

    public final IOException a(boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            c(iOException);
        }
        iy iyVar = this.b;
        if (z2) {
            if (iOException != null) {
                iyVar.getClass();
            } else {
                iyVar.getClass();
            }
        }
        if (z) {
            if (iOException != null) {
                iyVar.getClass();
            } else {
                iyVar.getClass();
            }
        }
        return this.a.c(this, z2, z, iOException);
    }

    public final sb1 b(boolean z) throws IOException {
        try {
            sb1 sb1VarE = this.d.e(z);
            if (sb1VarE == null) {
                return sb1VarE;
            }
            ka0.q.getClass();
            sb1VarE.m = this;
            return sb1VarE;
        } catch (IOException e) {
            this.b.getClass();
            c(e);
            throw e;
        }
    }

    public final void c(IOException iOException) {
        this.c.e();
        e81 e81VarH = this.d.h();
        synchronized (e81VarH.b) {
            try {
                if (iOException instanceof vj1) {
                    int i = ((vj1) iOException).g;
                    if (i == 5) {
                        int i2 = e81VarH.n + 1;
                        e81VarH.n = i2;
                        if (i2 > 1) {
                            e81VarH.k = true;
                            e81VarH.l++;
                        }
                    } else if (i != 6) {
                        e81VarH.k = true;
                        e81VarH.l++;
                    }
                } else {
                    if (!(e81VarH.h != null) || (iOException instanceof wl)) {
                        e81VarH.k = true;
                        if (e81VarH.m == 0) {
                            if (iOException != null) {
                                e81VarH.b.b(e81VarH.c, iOException);
                            }
                            e81VarH.l++;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
