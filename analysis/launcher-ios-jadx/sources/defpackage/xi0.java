package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class xi0 implements fi0, p11 {
    public static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(xi0.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(xi0.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    public xi0(boolean z) {
        this._state = z ? hg0.j : hg0.i;
    }

    public static ci H(np0 np0Var) {
        while (np0Var.k()) {
            np0 np0VarG = np0Var.g();
            if (np0VarG == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = np0.h;
                Object obj = atomicReferenceFieldUpdater.get(np0Var);
                while (true) {
                    np0Var = (np0) obj;
                    if (!np0Var.k()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(np0Var);
                }
            } else {
                np0Var = np0VarG;
            }
        }
        while (true) {
            np0Var = np0Var.j();
            if (!np0Var.k()) {
                if (np0Var instanceof ci) {
                    return (ci) np0Var;
                }
                if (np0Var instanceof px0) {
                    return null;
                }
            }
        }
    }

    public static String M(Object obj) {
        if (!(obj instanceof vi0)) {
            return obj instanceof cf0 ? ((cf0) obj).a() ? "Active" : "New" : obj instanceof uk ? "Cancelled" : "Completed";
        }
        vi0 vi0Var = (vi0) obj;
        return vi0Var.d() ? "Cancelling" : vi0Var.e() ? "Completing" : "Active";
    }

    public boolean A(Throwable th) {
        return false;
    }

    public final void C(fi0 fi0Var) {
        byte b;
        qx0 qx0Var = qx0.g;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        if (fi0Var == null) {
            atomicReferenceFieldUpdater.set(this, qx0Var);
            return;
        }
        xi0 xi0Var = (xi0) fi0Var;
        do {
            Object objZ = xi0Var.z();
            boolean z = objZ instanceof qz;
            b = 0;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = g;
            if (z) {
                if (!((qz) objZ).g) {
                    qz qzVar = hg0.j;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(xi0Var, objZ, qzVar)) {
                        if (atomicReferenceFieldUpdater2.get(xi0Var) != objZ) {
                            b = -1;
                            break;
                        }
                    }
                    xi0Var.getClass();
                    b = 1;
                }
            } else if (objZ instanceof bf0) {
                px0 px0Var = ((bf0) objZ).g;
                while (!atomicReferenceFieldUpdater2.compareAndSet(xi0Var, objZ, px0Var)) {
                    if (atomicReferenceFieldUpdater2.get(xi0Var) != objZ) {
                        b = -1;
                        break;
                    }
                }
                xi0Var.getClass();
                b = 1;
            }
            if (b == 0) {
                break;
            }
        } while (b != 1);
        bi biVar = (bi) xi0Var.E((2 & 1) == 0, (2 & 2) != 0, new ci(this));
        atomicReferenceFieldUpdater.set(this, biVar);
        if (z() instanceof cf0) {
            return;
        }
        biVar.b();
        atomicReferenceFieldUpdater.set(this, qx0Var);
    }

    public final dw D(o70 o70Var) {
        return E(false, true, o70Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00b9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.dw E(boolean r8, boolean r9, defpackage.o70 r10) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xi0.E(boolean, boolean, o70):dw");
    }

    public boolean F() {
        return false;
    }

    public final Object G(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objN;
        do {
            objN = N(z(), obj);
            if (objN == hg0.d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                uk ukVar = obj instanceof uk ? (uk) obj : null;
                throw new IllegalStateException(str, ukVar != null ? ukVar.a : null);
            }
        } while (objN == hg0.f);
        return objN;
    }

    public final void I(px0 px0Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        Object objI = px0Var.i();
        qg0.i(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        wk wkVar = null;
        for (np0 np0VarJ = (np0) objI; !np0VarJ.equals(px0Var); np0VarJ = np0VarJ.j()) {
            if (np0VarJ instanceof hi0) {
                ti0 ti0Var = (ti0) np0VarJ;
                try {
                    ti0Var.m(th);
                } catch (Throwable th2) {
                    if (wkVar != null) {
                        qg0.b(wkVar, th2);
                    } else {
                        wkVar = new wk("Exception in completion handler " + ti0Var + " for " + this, th2, 0);
                    }
                }
            }
        }
        if (wkVar != null) {
            B(wkVar);
        }
        p(th);
    }

    public final void L(ti0 ti0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        px0 px0Var = new px0();
        ti0Var.getClass();
        np0.h.lazySet(px0Var, ti0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = np0.g;
        atomicReferenceFieldUpdater2.lazySet(px0Var, ti0Var);
        loop0: while (true) {
            if (ti0Var.i() == ti0Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(ti0Var, ti0Var, px0Var)) {
                    if (atomicReferenceFieldUpdater2.get(ti0Var) != ti0Var) {
                        break;
                    }
                }
                px0Var.h(ti0Var);
                break loop0;
            }
            break;
        }
        np0 np0VarJ = ti0Var.j();
        do {
            atomicReferenceFieldUpdater = g;
            if (atomicReferenceFieldUpdater.compareAndSet(this, ti0Var, np0VarJ)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == ti0Var);
    }

    public final Object N(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (!(obj instanceof cf0)) {
            return hg0.d;
        }
        if (((obj instanceof qz) || (obj instanceof ti0)) && !(obj instanceof ci) && !(obj2 instanceof uk)) {
            cf0 cf0Var = (cf0) obj;
            Object df0Var = obj2 instanceof cf0 ? new df0((cf0) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = g;
                if (atomicReferenceFieldUpdater.compareAndSet(this, cf0Var, df0Var)) {
                    J(obj2);
                    t(cf0Var, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == cf0Var);
            return hg0.f;
        }
        cf0 cf0Var2 = (cf0) obj;
        px0 px0VarY = y(cf0Var2);
        if (px0VarY == null) {
            return hg0.f;
        }
        ci ciVarH = null;
        vi0 vi0Var = cf0Var2 instanceof vi0 ? (vi0) cf0Var2 : null;
        if (vi0Var == null) {
            vi0Var = new vi0(px0VarY, null);
        }
        synchronized (vi0Var) {
            if (vi0Var.e()) {
                return hg0.d;
            }
            vi0.h.set(vi0Var, 1);
            if (vi0Var != cf0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = g;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, cf0Var2, vi0Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != cf0Var2) {
                        return hg0.f;
                    }
                }
            }
            boolean zD = vi0Var.d();
            uk ukVar = obj2 instanceof uk ? (uk) obj2 : null;
            if (ukVar != null) {
                vi0Var.b(ukVar.a);
            }
            Throwable thC = vi0Var.c();
            if (zD) {
                thC = null;
            }
            if (thC != null) {
                I(px0VarY, thC);
            }
            ci ciVar = cf0Var2 instanceof ci ? (ci) cf0Var2 : null;
            if (ciVar == null) {
                px0 px0VarF = cf0Var2.f();
                if (px0VarF != null) {
                    ciVarH = H(px0VarF);
                }
            } else {
                ciVarH = ciVar;
            }
            if (ciVarH != null) {
                while (ciVarH.k.E((2 & 1) == 0, (2 & 2) != 0, new ui0(this, vi0Var, ciVarH, obj2)) == qx0.g) {
                    ciVarH = H(ciVarH);
                    if (ciVarH == null) {
                    }
                }
                return hg0.e;
            }
            return v(vi0Var, obj2);
        }
    }

    @Override // defpackage.fi0
    public boolean a() {
        Object objZ = z();
        return (objZ instanceof cf0) && ((cf0) objZ).a();
    }

    @Override // defpackage.fi0, defpackage.j81
    public void b(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        if (cancellationException == null) {
            cancellationException = new gi0(q(), null, this);
        }
        o(cancellationException);
    }

    @Override // defpackage.wo
    public final xo getKey() {
        return iy.i;
    }

    @Override // defpackage.yo
    public final Object h(Object obj, s70 s70Var) {
        return s70Var.d(obj, this);
    }

    public final boolean i(cf0 cf0Var, px0 px0Var, ti0 ti0Var) {
        char c;
        wi0 wi0Var = new wi0(ti0Var, this, cf0Var);
        do {
            np0 np0VarG = px0Var.g();
            if (np0VarG == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = np0.h;
                Object obj = atomicReferenceFieldUpdater.get(px0Var);
                while (true) {
                    np0VarG = (np0) obj;
                    if (!np0VarG.k()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(np0VarG);
                }
            }
            np0.h.lazySet(ti0Var, np0VarG);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = np0.g;
            atomicReferenceFieldUpdater2.lazySet(ti0Var, px0Var);
            wi0Var.c = px0Var;
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(np0VarG, px0Var, wi0Var)) {
                    c = wi0Var.a(np0VarG) == null ? (char) 1 : (char) 2;
                } else if (atomicReferenceFieldUpdater2.get(np0VarG) != px0Var) {
                    c = 0;
                    break;
                }
            }
            if (c == 1) {
                return true;
            }
        } while (c != 2);
        return false;
    }

    @Override // defpackage.yo
    public final yo k(yo yoVar) {
        return p02.s(this, yoVar);
    }

    public void l(Object obj) {
        j(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038 A[PHI: r0
  0x0038: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v12 java.lang.Object) binds: [B:3:0x0006, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(java.lang.Object r10) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xi0.m(java.lang.Object):boolean");
    }

    @Override // defpackage.yo
    public final wo n(xo xoVar) {
        qg0.l(xoVar, "key");
        if (qg0.d(iy.i, xoVar)) {
            return this;
        }
        return null;
    }

    public void o(CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        m(cancellationException);
    }

    public final boolean p(Throwable th) {
        if (F()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        bi biVar = (bi) h.get(this);
        return (biVar == null || biVar == qx0.g) ? z : biVar.e(th) || z;
    }

    public String q() {
        return "Job was cancelled";
    }

    @Override // defpackage.yo
    public final yo r(xo xoVar) {
        return p02.o(this, xoVar);
    }

    public boolean s(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return m(th) && x();
    }

    public final void t(cf0 cf0Var, Object obj) throws IllegalAccessException, InvocationTargetException {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        bi biVar = (bi) atomicReferenceFieldUpdater.get(this);
        if (biVar != null) {
            biVar.b();
            atomicReferenceFieldUpdater.set(this, qx0.g);
        }
        wk wkVar = null;
        uk ukVar = obj instanceof uk ? (uk) obj : null;
        Throwable th = ukVar != null ? ukVar.a : null;
        if (cf0Var instanceof ti0) {
            try {
                ((ti0) cf0Var).m(th);
                return;
            } catch (Throwable th2) {
                B(new wk("Exception in completion handler " + cf0Var + " for " + this, th2, 0));
                return;
            }
        }
        px0 px0VarF = cf0Var.f();
        if (px0VarF != null) {
            Object objI = px0VarF.i();
            qg0.i(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (np0 np0VarJ = (np0) objI; !np0VarJ.equals(px0VarF); np0VarJ = np0VarJ.j()) {
                if (np0VarJ instanceof ti0) {
                    ti0 ti0Var = (ti0) np0VarJ;
                    try {
                        ti0Var.m(th);
                    } catch (Throwable th3) {
                        if (wkVar != null) {
                            qg0.b(wkVar, th3);
                        } else {
                            wkVar = new wk("Exception in completion handler " + ti0Var + " for " + this, th3, 0);
                        }
                    }
                }
            }
            if (wkVar != null) {
                B(wkVar);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + M(z()) + '}');
        sb.append('@');
        sb.append(os.e(this));
        return sb.toString();
    }

    public final Throwable u(Object obj) {
        Throwable thC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        xi0 xi0Var = (xi0) ((p11) obj);
        Object objZ = xi0Var.z();
        if (objZ instanceof vi0) {
            thC = ((vi0) objZ).c();
        } else if (objZ instanceof uk) {
            thC = ((uk) objZ).a;
        } else {
            if (objZ instanceof cf0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objZ).toString());
            }
            thC = null;
        }
        CancellationException cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        return cancellationException == null ? new gi0("Parent job is ".concat(M(objZ)), thC, xi0Var) : cancellationException;
    }

    public final Object v(vi0 vi0Var, Object obj) throws IllegalAccessException, InvocationTargetException {
        Object obj2 = null;
        Throwable gi0Var = null;
        uk ukVar = obj instanceof uk ? (uk) obj : null;
        Throwable th = ukVar != null ? ukVar.a : null;
        synchronized (vi0Var) {
            vi0Var.d();
            ArrayList arrayListG = vi0Var.g(th);
            if (!arrayListG.isEmpty()) {
                int size = arrayListG.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    Object obj3 = arrayListG.get(i);
                    i++;
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        obj2 = obj3;
                        break;
                    }
                }
                gi0Var = (Throwable) obj2;
                if (gi0Var == null) {
                    gi0Var = (Throwable) arrayListG.get(0);
                }
            } else if (vi0Var.d()) {
                gi0Var = new gi0(q(), null, this);
            }
            if (gi0Var != null && arrayListG.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListG.size()));
                int size2 = arrayListG.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj4 = arrayListG.get(i2);
                    i2++;
                    Throwable th2 = (Throwable) obj4;
                    if (th2 != gi0Var && th2 != gi0Var && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        qg0.b(gi0Var, th2);
                    }
                }
            }
        }
        if (gi0Var != null && gi0Var != th) {
            obj = new uk(false, gi0Var);
        }
        if (gi0Var != null && (p(gi0Var) || A(gi0Var))) {
            qg0.i(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            uk.b.compareAndSet((uk) obj, 0, 1);
        }
        J(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        Object df0Var = obj instanceof cf0 ? new df0((cf0) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, vi0Var, df0Var) && atomicReferenceFieldUpdater.get(this) == vi0Var) {
        }
        t(vi0Var, obj);
        return obj;
    }

    public final CancellationException w() {
        CancellationException gi0Var;
        Object objZ = z();
        if (!(objZ instanceof vi0)) {
            if (objZ instanceof cf0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(objZ instanceof uk)) {
                return new gi0(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((uk) objZ).a;
            gi0Var = th instanceof CancellationException ? (CancellationException) th : null;
            return gi0Var == null ? new gi0(q(), th, this) : gi0Var;
        }
        Throwable thC = ((vi0) objZ).c();
        if (thC == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        gi0Var = thC instanceof CancellationException ? (CancellationException) thC : null;
        if (gi0Var == null) {
            if (strConcat == null) {
                strConcat = q();
            }
            gi0Var = new gi0(strConcat, thC, this);
        }
        return gi0Var;
    }

    public boolean x() {
        return true;
    }

    public final px0 y(cf0 cf0Var) {
        px0 px0VarF = cf0Var.f();
        if (px0VarF != null) {
            return px0VarF;
        }
        if (cf0Var instanceof qz) {
            return new px0();
        }
        if (cf0Var instanceof ti0) {
            L((ti0) cf0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + cf0Var).toString());
    }

    public final Object z() {
        while (true) {
            Object obj = g.get(this);
            if (!(obj instanceof nz0)) {
                return obj;
            }
            ((nz0) obj).a(this);
        }
    }

    public void K() {
    }

    public void B(wk wkVar) {
        throw wkVar;
    }

    public void J(Object obj) {
    }

    public void j(Object obj) {
    }
}
