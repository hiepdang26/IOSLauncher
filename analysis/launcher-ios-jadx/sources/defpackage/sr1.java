package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class sr1 extends hx1 {
    public vu k;
    public sb l;

    @Override // defpackage.ru
    public final void a(ru ruVar) {
        float f;
        float f2;
        float f3;
        int i;
        if (uo.v(this.j) == 3) {
            jn jnVar = this.b;
            l(jnVar.J, jnVar.L, 1);
            return;
        }
        gv gvVar = this.e;
        boolean z = gvVar.c;
        in inVar = in.i;
        if (z && !gvVar.j && this.d == inVar) {
            jn jnVar2 = this.b;
            int i2 = jnVar2.s;
            if (i2 == 2) {
                jn jnVar3 = jnVar2.U;
                if (jnVar3 != null) {
                    if (jnVar3.e.e.j) {
                        gvVar.d((int) ((r1.g * jnVar2.z) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                gv gvVar2 = jnVar2.d.e;
                if (gvVar2.j) {
                    int i3 = jnVar2.Y;
                    if (i3 == -1) {
                        f = gvVar2.g;
                        f2 = jnVar2.X;
                    } else if (i3 == 0) {
                        f3 = gvVar2.g * jnVar2.X;
                        i = (int) (f3 + 0.5f);
                        gvVar.d(i);
                    } else if (i3 != 1) {
                        i = 0;
                        gvVar.d(i);
                    } else {
                        f = gvVar2.g;
                        f2 = jnVar2.X;
                    }
                    f3 = f / f2;
                    i = (int) (f3 + 0.5f);
                    gvVar.d(i);
                }
            }
        }
        vu vuVar = this.h;
        if (vuVar.c) {
            vu vuVar2 = this.i;
            if (vuVar2.c) {
                if (vuVar.j && vuVar2.j && gvVar.j) {
                    return;
                }
                if (!gvVar.j && this.d == inVar) {
                    jn jnVar4 = this.b;
                    if (jnVar4.r == 0 && !jnVar4.z()) {
                        vu vuVar3 = (vu) vuVar.l.get(0);
                        vu vuVar4 = (vu) vuVar2.l.get(0);
                        int i4 = vuVar3.g + vuVar.f;
                        int i5 = vuVar4.g + vuVar2.f;
                        vuVar.d(i4);
                        vuVar2.d(i5);
                        gvVar.d(i5 - i4);
                        return;
                    }
                }
                if (!gvVar.j && this.d == inVar && this.a == 1 && vuVar.l.size() > 0 && vuVar2.l.size() > 0) {
                    vu vuVar5 = (vu) vuVar.l.get(0);
                    int i6 = (((vu) vuVar2.l.get(0)).g + vuVar2.f) - (vuVar5.g + vuVar.f);
                    int i7 = gvVar.m;
                    if (i6 < i7) {
                        gvVar.d(i6);
                    } else {
                        gvVar.d(i7);
                    }
                }
                if (gvVar.j && vuVar.l.size() > 0 && vuVar2.l.size() > 0) {
                    vu vuVar6 = (vu) vuVar.l.get(0);
                    vu vuVar7 = (vu) vuVar2.l.get(0);
                    int i8 = vuVar6.g;
                    int i9 = vuVar.f + i8;
                    int i10 = vuVar7.g;
                    int i11 = vuVar2.f + i10;
                    float f4 = this.b.f0;
                    if (vuVar6 == vuVar7) {
                        f4 = 0.5f;
                    } else {
                        i8 = i9;
                        i10 = i11;
                    }
                    vuVar.d((int) ((((i10 - i8) - gvVar.g) * f4) + i8 + 0.5f));
                    vuVar2.d(vuVar.g + gvVar.g);
                }
            }
        }
    }

    @Override // defpackage.hx1
    public final void d() {
        jn jnVar;
        jn jnVar2;
        jn jnVar3;
        jn jnVar4;
        jn jnVar5 = this.b;
        boolean z = jnVar5.a;
        gv gvVar = this.e;
        if (z) {
            gvVar.d(jnVar5.l());
        }
        boolean z2 = gvVar.j;
        in inVar = in.j;
        in inVar2 = in.g;
        in inVar3 = in.i;
        vu vuVar = this.i;
        vu vuVar2 = this.h;
        if (!z2) {
            jn jnVar6 = this.b;
            this.d = jnVar6.T[1];
            if (jnVar6.E) {
                this.l = new sb(this);
            }
            in inVar4 = this.d;
            if (inVar4 != inVar3) {
                if (inVar4 == inVar && (jnVar4 = this.b.U) != null && jnVar4.T[1] == inVar2) {
                    int iL = (jnVar4.l() - this.b.J.e()) - this.b.L.e();
                    hx1.b(vuVar2, jnVar4.e.h, this.b.J.e());
                    hx1.b(vuVar, jnVar4.e.i, -this.b.L.e());
                    gvVar.d(iL);
                    return;
                }
                if (inVar4 == inVar2) {
                    gvVar.d(this.b.l());
                }
            }
        } else if (this.d == inVar && (jnVar2 = (jnVar = this.b).U) != null && jnVar2.T[1] == inVar2) {
            hx1.b(vuVar2, jnVar2.e.h, jnVar.J.e());
            hx1.b(vuVar, jnVar2.e.i, -this.b.L.e());
            return;
        }
        boolean z3 = gvVar.j;
        vu vuVar3 = this.k;
        if (z3) {
            jn jnVar7 = this.b;
            if (jnVar7.a) {
                gm[] gmVarArr = jnVar7.Q;
                gm gmVar = gmVarArr[2];
                gm gmVar2 = gmVar.f;
                if (gmVar2 != null && gmVarArr[3].f != null) {
                    if (jnVar7.z()) {
                        vuVar2.f = this.b.Q[2].e();
                        vuVar.f = -this.b.Q[3].e();
                    } else {
                        vu vuVarH = hx1.h(this.b.Q[2]);
                        if (vuVarH != null) {
                            hx1.b(vuVar2, vuVarH, this.b.Q[2].e());
                        }
                        vu vuVarH2 = hx1.h(this.b.Q[3]);
                        if (vuVarH2 != null) {
                            hx1.b(vuVar, vuVarH2, -this.b.Q[3].e());
                        }
                        vuVar2.b = true;
                        vuVar.b = true;
                    }
                    jn jnVar8 = this.b;
                    if (jnVar8.E) {
                        hx1.b(vuVar3, vuVar2, jnVar8.b0);
                        return;
                    }
                    return;
                }
                if (gmVar2 != null) {
                    vu vuVarH3 = hx1.h(gmVar);
                    if (vuVarH3 != null) {
                        hx1.b(vuVar2, vuVarH3, this.b.Q[2].e());
                        hx1.b(vuVar, vuVar2, gvVar.g);
                        jn jnVar9 = this.b;
                        if (jnVar9.E) {
                            hx1.b(vuVar3, vuVar2, jnVar9.b0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                gm gmVar3 = gmVarArr[3];
                if (gmVar3.f != null) {
                    vu vuVarH4 = hx1.h(gmVar3);
                    if (vuVarH4 != null) {
                        hx1.b(vuVar, vuVarH4, -this.b.Q[3].e());
                        hx1.b(vuVar2, vuVar, -gvVar.g);
                    }
                    jn jnVar10 = this.b;
                    if (jnVar10.E) {
                        hx1.b(vuVar3, vuVar2, jnVar10.b0);
                        return;
                    }
                    return;
                }
                gm gmVar4 = gmVarArr[4];
                if (gmVar4.f != null) {
                    vu vuVarH5 = hx1.h(gmVar4);
                    if (vuVarH5 != null) {
                        hx1.b(vuVar3, vuVarH5, 0);
                        hx1.b(vuVar2, vuVar3, -this.b.b0);
                        hx1.b(vuVar, vuVar2, gvVar.g);
                        return;
                    }
                    return;
                }
                if ((jnVar7 instanceof xb0) || jnVar7.U == null || jnVar7.j(7).f != null) {
                    return;
                }
                jn jnVar11 = this.b;
                hx1.b(vuVar2, jnVar11.U.e.h, jnVar11.t());
                hx1.b(vuVar, vuVar2, gvVar.g);
                jn jnVar12 = this.b;
                if (jnVar12.E) {
                    hx1.b(vuVar3, vuVar2, jnVar12.b0);
                    return;
                }
                return;
            }
        }
        if (z3 || this.d != inVar3) {
            gvVar.b(this);
        } else {
            jn jnVar13 = this.b;
            int i = jnVar13.s;
            if (i == 2) {
                jn jnVar14 = jnVar13.U;
                if (jnVar14 != null) {
                    gv gvVar2 = jnVar14.e.e;
                    gvVar.l.add(gvVar2);
                    gvVar2.k.add(gvVar);
                    gvVar.b = true;
                    gvVar.k.add(vuVar2);
                    gvVar.k.add(vuVar);
                }
            } else if (i == 3 && !jnVar13.z()) {
                jn jnVar15 = this.b;
                if (jnVar15.r != 3) {
                    gv gvVar3 = jnVar15.d.e;
                    gvVar.l.add(gvVar3);
                    gvVar3.k.add(gvVar);
                    gvVar.b = true;
                    gvVar.k.add(vuVar2);
                    gvVar.k.add(vuVar);
                }
            }
        }
        jn jnVar16 = this.b;
        gm[] gmVarArr2 = jnVar16.Q;
        gm gmVar5 = gmVarArr2[2];
        gm gmVar6 = gmVar5.f;
        if (gmVar6 != null && gmVarArr2[3].f != null) {
            if (jnVar16.z()) {
                vuVar2.f = this.b.Q[2].e();
                vuVar.f = -this.b.Q[3].e();
            } else {
                vu vuVarH6 = hx1.h(this.b.Q[2]);
                vu vuVarH7 = hx1.h(this.b.Q[3]);
                if (vuVarH6 != null) {
                    vuVarH6.b(this);
                }
                if (vuVarH7 != null) {
                    vuVarH7.b(this);
                }
                this.j = 4;
            }
            if (this.b.E) {
                c(vuVar3, vuVar2, 1, this.l);
            }
        } else if (gmVar6 != null) {
            vu vuVarH8 = hx1.h(gmVar5);
            if (vuVarH8 != null) {
                hx1.b(vuVar2, vuVarH8, this.b.Q[2].e());
                c(vuVar, vuVar2, 1, gvVar);
                if (this.b.E) {
                    c(vuVar3, vuVar2, 1, this.l);
                }
                if (this.d == inVar3) {
                    jn jnVar17 = this.b;
                    if (jnVar17.X > 0.0f) {
                        dc0 dc0Var = jnVar17.d;
                        if (dc0Var.d == inVar3) {
                            dc0Var.e.k.add(gvVar);
                            gvVar.l.add(this.b.d.e);
                            gvVar.a = this;
                        }
                    }
                }
            }
        } else {
            gm gmVar7 = gmVarArr2[3];
            if (gmVar7.f != null) {
                vu vuVarH9 = hx1.h(gmVar7);
                if (vuVarH9 != null) {
                    hx1.b(vuVar, vuVarH9, -this.b.Q[3].e());
                    c(vuVar2, vuVar, -1, gvVar);
                    if (this.b.E) {
                        c(vuVar3, vuVar2, 1, this.l);
                    }
                }
            } else {
                gm gmVar8 = gmVarArr2[4];
                if (gmVar8.f != null) {
                    vu vuVarH10 = hx1.h(gmVar8);
                    if (vuVarH10 != null) {
                        hx1.b(vuVar3, vuVarH10, 0);
                        c(vuVar2, vuVar3, -1, this.l);
                        c(vuVar, vuVar2, 1, gvVar);
                    }
                } else if (!(jnVar16 instanceof xb0) && (jnVar3 = jnVar16.U) != null) {
                    hx1.b(vuVar2, jnVar3.e.h, jnVar16.t());
                    c(vuVar, vuVar2, 1, gvVar);
                    if (this.b.E) {
                        c(vuVar3, vuVar2, 1, this.l);
                    }
                    if (this.d == inVar3) {
                        jn jnVar18 = this.b;
                        if (jnVar18.X > 0.0f) {
                            dc0 dc0Var2 = jnVar18.d;
                            if (dc0Var2.d == inVar3) {
                                dc0Var2.e.k.add(gvVar);
                                gvVar.l.add(this.b.d.e);
                                gvVar.a = this;
                            }
                        }
                    }
                }
            }
        }
        if (gvVar.l.size() == 0) {
            gvVar.c = true;
        }
    }

    @Override // defpackage.hx1
    public final void e() {
        vu vuVar = this.h;
        if (vuVar.j) {
            this.b.a0 = vuVar.g;
        }
    }

    @Override // defpackage.hx1
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override // defpackage.hx1
    public final boolean k() {
        return this.d != in.i || this.b.s == 0;
    }

    public final void m() {
        this.g = false;
        vu vuVar = this.h;
        vuVar.c();
        vuVar.j = false;
        vu vuVar2 = this.i;
        vuVar2.c();
        vuVar2.j = false;
        vu vuVar3 = this.k;
        vuVar3.c();
        vuVar3.j = false;
        this.e.j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.b.j0;
    }
}
