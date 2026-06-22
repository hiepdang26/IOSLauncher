package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class nk implements yo, Serializable {
    public final yo g;
    public final wo h;

    public nk(wo woVar, yo yoVar) {
        qg0.l(yoVar, "left");
        qg0.l(woVar, "element");
        this.g = yoVar;
        this.h = woVar;
    }

    public final boolean equals(Object obj) {
        boolean zD;
        if (this == obj) {
            return true;
        }
        if (obj instanceof nk) {
            nk nkVar = (nk) obj;
            nkVar.getClass();
            int i = 2;
            nk nkVar2 = nkVar;
            int i2 = 2;
            while (true) {
                yo yoVar = nkVar2.g;
                nkVar2 = yoVar instanceof nk ? (nk) yoVar : null;
                if (nkVar2 == null) {
                    break;
                }
                i2++;
            }
            nk nkVar3 = this;
            while (true) {
                yo yoVar2 = nkVar3.g;
                nkVar3 = yoVar2 instanceof nk ? (nk) yoVar2 : null;
                if (nkVar3 == null) {
                    break;
                }
                i++;
            }
            if (i2 == i) {
                nk nkVar4 = this;
                while (true) {
                    wo woVar = nkVar4.h;
                    if (!qg0.d(nkVar.n(woVar.getKey()), woVar)) {
                        zD = false;
                        break;
                    }
                    yo yoVar3 = nkVar4.g;
                    if (!(yoVar3 instanceof nk)) {
                        qg0.i(yoVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        wo woVar2 = (wo) yoVar3;
                        zD = qg0.d(nkVar.n(woVar2.getKey()), woVar2);
                        break;
                    }
                    nkVar4 = (nk) yoVar3;
                }
                if (zD) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.yo
    public final Object h(Object obj, s70 s70Var) {
        return s70Var.d(this.g.h(obj, s70Var), this.h);
    }

    public final int hashCode() {
        return this.h.hashCode() + this.g.hashCode();
    }

    @Override // defpackage.yo
    public final yo k(yo yoVar) {
        return az1.E(this, yoVar);
    }

    @Override // defpackage.yo
    public final wo n(xo xoVar) {
        qg0.l(xoVar, "key");
        nk nkVar = this;
        while (true) {
            wo woVarN = nkVar.h.n(xoVar);
            if (woVarN != null) {
                return woVarN;
            }
            yo yoVar = nkVar.g;
            if (!(yoVar instanceof nk)) {
                return yoVar.n(xoVar);
            }
            nkVar = (nk) yoVar;
        }
    }

    @Override // defpackage.yo
    public final yo r(xo xoVar) {
        qg0.l(xoVar, "key");
        wo woVar = this.h;
        wo woVarN = woVar.n(xoVar);
        yo yoVar = this.g;
        if (woVarN != null) {
            return yoVar;
        }
        yo yoVarR = yoVar.r(xoVar);
        return yoVarR == yoVar ? this : yoVarR == sz.g ? woVar : new nk(woVar, yoVarR);
    }

    public final String toString() {
        return "[" + ((String) h("", new mk(0))) + ']';
    }
}
