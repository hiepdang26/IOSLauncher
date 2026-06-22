package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class dc0 extends hx1 {
    public static final int[] k = new int[2];

    public static void m(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    @Override // defpackage.ru
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.ru r24) {
        /*
            Method dump skipped, instruction units count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dc0.a(ru):void");
    }

    @Override // defpackage.hx1
    public final void d() {
        jn jnVar;
        jn jnVar2;
        in inVar;
        jn jnVar3;
        jn jnVar4;
        in inVar2;
        jn jnVar5 = this.b;
        boolean z = jnVar5.a;
        gv gvVar = this.e;
        if (z) {
            gvVar.d(jnVar5.r());
        }
        boolean z2 = gvVar.j;
        in inVar3 = in.j;
        in inVar4 = in.i;
        in inVar5 = in.g;
        vu vuVar = this.i;
        vu vuVar2 = this.h;
        if (!z2) {
            jn jnVar6 = this.b;
            in inVar6 = jnVar6.T[0];
            this.d = inVar6;
            if (inVar6 != inVar4) {
                if (inVar6 == inVar3 && (jnVar4 = jnVar6.U) != null && ((inVar2 = jnVar4.T[0]) == inVar5 || inVar2 == inVar3)) {
                    int iR = (jnVar4.r() - this.b.I.e()) - this.b.K.e();
                    hx1.b(vuVar2, jnVar4.d.h, this.b.I.e());
                    hx1.b(vuVar, jnVar4.d.i, -this.b.K.e());
                    gvVar.d(iR);
                    return;
                }
                if (inVar6 == inVar5) {
                    gvVar.d(jnVar6.r());
                }
            }
        } else if (this.d == inVar3 && (jnVar2 = (jnVar = this.b).U) != null && ((inVar = jnVar2.T[0]) == inVar5 || inVar == inVar3)) {
            hx1.b(vuVar2, jnVar2.d.h, jnVar.I.e());
            hx1.b(vuVar, jnVar2.d.i, -this.b.K.e());
            return;
        }
        if (gvVar.j) {
            jn jnVar7 = this.b;
            if (jnVar7.a) {
                gm[] gmVarArr = jnVar7.Q;
                gm gmVar = gmVarArr[0];
                gm gmVar2 = gmVar.f;
                if (gmVar2 != null && gmVarArr[1].f != null) {
                    if (jnVar7.y()) {
                        vuVar2.f = this.b.Q[0].e();
                        vuVar.f = -this.b.Q[1].e();
                        return;
                    }
                    vu vuVarH = hx1.h(this.b.Q[0]);
                    if (vuVarH != null) {
                        hx1.b(vuVar2, vuVarH, this.b.Q[0].e());
                    }
                    vu vuVarH2 = hx1.h(this.b.Q[1]);
                    if (vuVarH2 != null) {
                        hx1.b(vuVar, vuVarH2, -this.b.Q[1].e());
                    }
                    vuVar2.b = true;
                    vuVar.b = true;
                    return;
                }
                if (gmVar2 != null) {
                    vu vuVarH3 = hx1.h(gmVar);
                    if (vuVarH3 != null) {
                        hx1.b(vuVar2, vuVarH3, this.b.Q[0].e());
                        hx1.b(vuVar, vuVar2, gvVar.g);
                        return;
                    }
                    return;
                }
                gm gmVar3 = gmVarArr[1];
                if (gmVar3.f != null) {
                    vu vuVarH4 = hx1.h(gmVar3);
                    if (vuVarH4 != null) {
                        hx1.b(vuVar, vuVarH4, -this.b.Q[1].e());
                        hx1.b(vuVar2, vuVar, -gvVar.g);
                        return;
                    }
                    return;
                }
                if ((jnVar7 instanceof xb0) || jnVar7.U == null || jnVar7.j(7).f != null) {
                    return;
                }
                jn jnVar8 = this.b;
                hx1.b(vuVar2, jnVar8.U.d.h, jnVar8.s());
                hx1.b(vuVar, vuVar2, gvVar.g);
                return;
            }
        }
        if (this.d == inVar4) {
            jn jnVar9 = this.b;
            int i = jnVar9.r;
            if (i == 2) {
                jn jnVar10 = jnVar9.U;
                if (jnVar10 != null) {
                    gv gvVar2 = jnVar10.e.e;
                    gvVar.l.add(gvVar2);
                    gvVar2.k.add(gvVar);
                    gvVar.b = true;
                    gvVar.k.add(vuVar2);
                    gvVar.k.add(vuVar);
                }
            } else if (i == 3) {
                if (jnVar9.s == 3) {
                    vuVar2.a = this;
                    vuVar.a = this;
                    sr1 sr1Var = jnVar9.e;
                    sr1Var.h.a = this;
                    sr1Var.i.a = this;
                    gvVar.a = this;
                    if (jnVar9.z()) {
                        gvVar.l.add(this.b.e.e);
                        this.b.e.e.k.add(gvVar);
                        sr1 sr1Var2 = this.b.e;
                        sr1Var2.e.a = this;
                        gvVar.l.add(sr1Var2.h);
                        gvVar.l.add(this.b.e.i);
                        this.b.e.h.k.add(gvVar);
                        this.b.e.i.k.add(gvVar);
                    } else if (this.b.y()) {
                        this.b.e.e.l.add(gvVar);
                        gvVar.k.add(this.b.e.e);
                    } else {
                        this.b.e.e.l.add(gvVar);
                    }
                } else {
                    gv gvVar3 = jnVar9.e.e;
                    gvVar.l.add(gvVar3);
                    gvVar3.k.add(gvVar);
                    this.b.e.h.k.add(gvVar);
                    this.b.e.i.k.add(gvVar);
                    gvVar.b = true;
                    gvVar.k.add(vuVar2);
                    gvVar.k.add(vuVar);
                    vuVar2.l.add(gvVar);
                    vuVar.l.add(gvVar);
                }
            }
        }
        jn jnVar11 = this.b;
        gm[] gmVarArr2 = jnVar11.Q;
        gm gmVar4 = gmVarArr2[0];
        gm gmVar5 = gmVar4.f;
        if (gmVar5 != null && gmVarArr2[1].f != null) {
            if (jnVar11.y()) {
                vuVar2.f = this.b.Q[0].e();
                vuVar.f = -this.b.Q[1].e();
                return;
            }
            vu vuVarH5 = hx1.h(this.b.Q[0]);
            vu vuVarH6 = hx1.h(this.b.Q[1]);
            if (vuVarH5 != null) {
                vuVarH5.b(this);
            }
            if (vuVarH6 != null) {
                vuVarH6.b(this);
            }
            this.j = 4;
            return;
        }
        if (gmVar5 != null) {
            vu vuVarH7 = hx1.h(gmVar4);
            if (vuVarH7 != null) {
                hx1.b(vuVar2, vuVarH7, this.b.Q[0].e());
                c(vuVar, vuVar2, 1, gvVar);
                return;
            }
            return;
        }
        gm gmVar6 = gmVarArr2[1];
        if (gmVar6.f != null) {
            vu vuVarH8 = hx1.h(gmVar6);
            if (vuVarH8 != null) {
                hx1.b(vuVar, vuVarH8, -this.b.Q[1].e());
                c(vuVar2, vuVar, -1, gvVar);
                return;
            }
            return;
        }
        if ((jnVar11 instanceof xb0) || (jnVar3 = jnVar11.U) == null) {
            return;
        }
        hx1.b(vuVar2, jnVar3.d.h, jnVar11.s());
        c(vuVar, vuVar2, 1, gvVar);
    }

    @Override // defpackage.hx1
    public final void e() {
        vu vuVar = this.h;
        if (vuVar.j) {
            this.b.Z = vuVar.g;
        }
    }

    @Override // defpackage.hx1
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override // defpackage.hx1
    public final boolean k() {
        return this.d != in.i || this.b.r == 0;
    }

    public final void n() {
        this.g = false;
        vu vuVar = this.h;
        vuVar.c();
        vuVar.j = false;
        vu vuVar2 = this.i;
        vuVar2.c();
        vuVar2.j = false;
        this.e.j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.b.j0;
    }
}
