package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class ge implements hv1 {
    public Object g = le.p;
    public gg h;
    public final /* synthetic */ je i;

    public ge(je jeVar) {
        this.i = jeVar;
    }

    @Override // defpackage.hv1
    public final void a(vh vhVar, int i) throws IllegalAccessException, InvocationTargetException {
        gg ggVar = this.h;
        if (ggVar != null) {
            ggVar.a(vhVar, i);
        }
    }

    public final Object b(e40 e40Var) throws Throwable {
        vh vhVarN;
        Boolean bool;
        int i;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = je.m;
        je jeVar = this.i;
        vh vhVar = (vh) atomicReferenceFieldUpdater.get(jeVar);
        while (true) {
            jeVar.getClass();
            if (jeVar.s(je.h.get(jeVar), true)) {
                this.g = le.l;
                Throwable thO = jeVar.o();
                if (thO == null) {
                    return Boolean.FALSE;
                }
                int i2 = pi1.a;
                throw thO;
            }
            long andIncrement = je.i.getAndIncrement(jeVar);
            long j = le.b;
            long j2 = andIncrement / j;
            int i3 = (int) (andIncrement % j);
            if (vhVar.i != j2) {
                vhVarN = jeVar.n(j2, vhVar);
                if (vhVarN == null) {
                    continue;
                }
            } else {
                vhVarN = vhVar;
            }
            Object objD = jeVar.D(vhVarN, i3, andIncrement, null);
            wg1 wg1Var = le.m;
            if (objD == wg1Var) {
                throw new IllegalStateException("unreachable");
            }
            wg1 wg1Var2 = le.o;
            if (objD != wg1Var2) {
                if (objD != le.n) {
                    vhVarN.a();
                    this.g = objD;
                    return Boolean.TRUE;
                }
                je jeVar2 = this.i;
                gg ggVarS = az1.s(e42.d(e40Var));
                try {
                    this.h = ggVarS;
                    Object objD2 = jeVar2.D(vhVarN, i3, andIncrement, this);
                    if (objD2 == wg1Var) {
                        a(vhVarN, i3);
                    } else {
                        if (objD2 == wg1Var2) {
                            if (andIncrement < jeVar2.q()) {
                                vhVarN.a();
                            }
                            vh vhVar2 = (vh) je.m.get(jeVar2);
                            while (true) {
                                if (jeVar2.s(je.h.get(jeVar2), true)) {
                                    gg ggVar = this.h;
                                    qg0.h(ggVar);
                                    this.h = null;
                                    this.g = le.l;
                                    Throwable thO2 = jeVar.o();
                                    if (thO2 == null) {
                                        ggVar.resumeWith(Boolean.FALSE);
                                    } else {
                                        ggVar.resumeWith(np1.e(thO2));
                                    }
                                } else {
                                    long andIncrement2 = je.i.getAndIncrement(jeVar2);
                                    long j3 = le.b;
                                    long j4 = andIncrement2 / j3;
                                    int i4 = (int) (andIncrement2 % j3);
                                    if (vhVar2.i != j4) {
                                        vh vhVarN2 = jeVar2.n(j4, vhVar2);
                                        if (vhVarN2 != null) {
                                            vhVar2 = vhVarN2;
                                        }
                                    }
                                    Object objD3 = jeVar2.D(vhVar2, i4, andIncrement2, this);
                                    if (objD3 == le.m) {
                                        a(vhVar2, i4);
                                        break;
                                    }
                                    if (objD3 == le.o) {
                                        if (andIncrement2 < jeVar2.q()) {
                                            vhVar2.a();
                                        }
                                    } else {
                                        if (objD3 == le.n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        vhVar2.a();
                                        this.g = objD3;
                                        this.h = null;
                                        bool = Boolean.TRUE;
                                        i = ggVarS.i;
                                    }
                                }
                            }
                        } else {
                            vhVarN.a();
                            this.g = objD2;
                            this.h = null;
                            bool = Boolean.TRUE;
                            i = ggVarS.i;
                        }
                        ggVarS.v(bool, i, null);
                    }
                    return ggVarS.n();
                } catch (Throwable th) {
                    ggVarS.u();
                    throw th;
                }
            }
            if (andIncrement < jeVar.q()) {
                vhVarN.a();
            }
            vhVar = vhVarN;
        }
    }
}
