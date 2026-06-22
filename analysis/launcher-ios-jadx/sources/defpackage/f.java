package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends xi0 implements eo, gp {
    public final yo i;

    public f(yo yoVar, boolean z) {
        super(z);
        C((fi0) yoVar.n(iy.i));
        this.i = yoVar.k(this);
    }

    @Override // defpackage.xi0
    public final void B(wk wkVar) throws IllegalAccessException, InvocationTargetException {
        os.h(this.i, wkVar);
    }

    @Override // defpackage.xi0
    public final void J(Object obj) {
        if (!(obj instanceof uk)) {
            P(obj);
            return;
        }
        uk ukVar = (uk) obj;
        O(uk.b.get(ukVar) != 0, ukVar.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q(int i, f fVar, s70 s70Var) {
        int iV = uo.v(i);
        zp1 zp1Var = zp1.a;
        if (iV == 0) {
            try {
                np1.G(zp1Var, e42.d(((za) s70Var).create(fVar, this)));
                return;
            } finally {
                resumeWith(np1.e(th));
            }
        }
        if (iV != 1) {
            if (iV == 2) {
                e42.d(((za) s70Var).create(fVar, this)).resumeWith(zp1Var);
                return;
            }
            if (iV != 3) {
                throw new wk(4);
            }
            try {
                yo yoVar = this.i;
                Object objA = bf1.A(yoVar, null);
                try {
                    np1.c(2, s70Var);
                    Object objD = s70Var.d(fVar, this);
                    if (objD != hp.g) {
                        resumeWith(objD);
                    }
                } finally {
                    bf1.t(yoVar, objA);
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // defpackage.gp
    public final yo c() {
        return this.i;
    }

    @Override // defpackage.eo
    public final yo getContext() {
        return this.i;
    }

    @Override // defpackage.xi0
    public final String q() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // defpackage.eo
    public final void resumeWith(Object obj) throws IllegalAccessException, InvocationTargetException {
        Throwable thA = yb1.a(obj);
        if (thA != null) {
            obj = new uk(false, thA);
        }
        Object objG = G(obj);
        if (objG == hg0.e) {
            return;
        }
        l(objG);
    }

    public void P(Object obj) {
    }

    public void O(boolean z, Throwable th) {
    }
}
