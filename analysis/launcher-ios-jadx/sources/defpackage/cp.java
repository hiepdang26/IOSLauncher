package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class cp extends g implements ho {
    public static final bp h = new bp(iy.g, ap.h);

    public cp() {
        super(iy.g);
    }

    public void A(yo yoVar, Runnable runnable) {
        z(yoVar, runnable);
    }

    public boolean B() {
        return !(this instanceof vp1);
    }

    @Override // defpackage.g, defpackage.yo
    public final wo n(xo xoVar) {
        wo woVarA;
        qg0.l(xoVar, "key");
        if (!(xoVar instanceof bp)) {
            if (iy.g == xoVar) {
                return this;
            }
            return null;
        }
        bp bpVar = (bp) xoVar;
        xo xoVar2 = this.g;
        if ((xoVar2 == bpVar || bpVar.h == xoVar2) && (woVarA = bpVar.a(this)) != null) {
            return woVarA;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0022 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0023 A[RETURN] */
    @Override // defpackage.g, defpackage.yo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.yo r(defpackage.xo r4) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            defpackage.qg0.l(r4, r0)
            boolean r0 = r4 instanceof defpackage.bp
            sz r1 = defpackage.sz.g
            if (r0 == 0) goto L1e
            bp r4 = (defpackage.bp) r4
            xo r0 = r3.g
            if (r0 == r4) goto L17
            xo r2 = r4.h
            if (r2 != r0) goto L16
            goto L17
        L16:
            return r3
        L17:
            wo r4 = r4.a(r3)
            if (r4 == 0) goto L23
            goto L22
        L1e:
            iy r0 = defpackage.iy.g
            if (r0 != r4) goto L23
        L22:
            return r1
        L23:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cp.r(xo):yo");
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + os.e(this);
    }

    public abstract void z(yo yoVar, Runnable runnable);
}
