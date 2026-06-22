package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class gg extends zv implements fg, ip, hv1 {
    public static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(gg.class, "_decisionAndIndex");
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(gg.class, Object.class, "_state");
    public static final AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(gg.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;
    public final eo j;
    public final yo k;

    public gg(int i, eo eoVar) {
        super(i);
        this.j = eoVar;
        this.k = eoVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = n1.g;
    }

    public static void t(sx0 sx0Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + sx0Var + ", already has " + obj).toString());
    }

    public static Object w(sx0 sx0Var, Object obj, int i, jz0 jz0Var) {
        if (obj instanceof uk) {
            return obj;
        }
        if ((i == 1 || i == 2) && (sx0Var instanceof zg0)) {
            return new sk(obj, sx0Var instanceof zg0 ? (zg0) sx0Var : null, jz0Var, (CancellationException) null, 16);
        }
        return obj;
    }

    @Override // defpackage.hv1
    public final void a(vh vhVar, int i) throws IllegalAccessException, InvocationTargetException {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = l;
            i2 = atomicIntegerFieldUpdater.get(this);
            if ((i2 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, ((i2 >> 29) << 29) + i));
        r(vhVar);
    }

    @Override // defpackage.zv
    public final void b(Object obj, CancellationException cancellationException) throws IllegalAccessException, InvocationTargetException {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof sx0) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof uk) {
                return;
            }
            if (!(obj2 instanceof sk)) {
                cancellationException2 = cancellationException;
                sk skVar = new sk(obj2, (zg0) null, (jz0) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, skVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            sk skVar2 = (sk) obj2;
            if (skVar2.e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            sk skVarA = sk.a(skVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, skVarA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    cancellationException2 = cancellationException;
                }
            }
            zg0 zg0Var = skVar2.b;
            if (zg0Var != null) {
                h(zg0Var, cancellationException);
            }
            o70 o70Var = skVar2.c;
            if (o70Var != null) {
                i(o70Var, cancellationException);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // defpackage.zv
    public final eo c() {
        return this.j;
    }

    @Override // defpackage.zv
    public final Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // defpackage.zv
    public final Object e(Object obj) {
        return obj instanceof sk ? ((sk) obj).a : obj;
    }

    @Override // defpackage.zv
    public final Object g() {
        return m.get(this);
    }

    @Override // defpackage.ip
    public final ip getCallerFrame() {
        eo eoVar = this.j;
        if (eoVar instanceof ip) {
            return (ip) eoVar;
        }
        return null;
    }

    @Override // defpackage.eo
    public final yo getContext() {
        return this.k;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [jj0, o70] */
    public final void h(zg0 zg0Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        try {
            zg0Var.g.invoke(th);
        } catch (Throwable th2) {
            os.h(this.k, new wk("Exception in invokeOnCancellation handler for " + this, th2, 0));
        }
    }

    public final void i(o70 o70Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        try {
            o70Var.invoke(th);
        } catch (Throwable th2) {
            os.h(this.k, new wk("Exception in resume onCancellation handler for " + this, th2, 0));
        }
    }

    public final void j(af1 af1Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        yo yoVar = this.k;
        int i = l.get(this) & 536870911;
        if (i == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            af1Var.g(i, yoVar);
        } catch (Throwable th2) {
            os.h(yoVar, new wk("Exception in invokeOnCancellation handler for " + this, th2, 0));
        }
    }

    public final void k(Throwable th) throws IllegalAccessException, InvocationTargetException {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof sx0) {
                kg kgVar = new kg(this, th, (obj instanceof zg0) || (obj instanceof af1));
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, kgVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                sx0 sx0Var = (sx0) obj;
                if (sx0Var instanceof zg0) {
                    h((zg0) obj, th);
                } else if (sx0Var instanceof af1) {
                    j((af1) obj, th);
                }
                if (!s()) {
                    l();
                }
                m(this.i);
                return;
            }
            return;
        }
    }

    public final void l() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n;
        dw dwVar = (dw) atomicReferenceFieldUpdater.get(this);
        if (dwVar == null) {
            return;
        }
        dwVar.b();
        atomicReferenceFieldUpdater.set(this, qx0.g);
    }

    public final void m(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = l;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z = i == 4;
                eo eoVar = this.j;
                if (!z && (eoVar instanceof yv)) {
                    boolean z2 = i == 1 || i == 2;
                    int i4 = this.i;
                    if (z2 == (i4 == 1 || i4 == 2)) {
                        cp cpVar = ((yv) eoVar).j;
                        yo context = ((yv) eoVar).k.getContext();
                        if (cpVar.B()) {
                            cpVar.z(context, this);
                            return;
                        }
                        v00 v00VarA = on1.a();
                        if (v00VarA.i >= 4294967296L) {
                            v00VarA.D(this);
                            return;
                        }
                        v00VarA.F(true);
                        try {
                            np1.F(this, eoVar, true);
                            do {
                            } while (v00VarA.G());
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        return;
                    }
                }
                np1.F(this, eoVar, z);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 1073741824 + (536870911 & i2)));
    }

    public final Object n() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        boolean zS = s();
        do {
            atomicIntegerFieldUpdater = l;
            i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zS) {
                    u();
                }
                Object obj = m.get(this);
                if (obj instanceof uk) {
                    throw ((uk) obj).a;
                }
                int i3 = this.i;
                if (i3 == 1 || i3 == 2) {
                    fi0 fi0Var = (fi0) this.k.n(iy.i);
                    if (fi0Var != null && !fi0Var.a()) {
                        CancellationException cancellationExceptionW = ((xi0) fi0Var).w();
                        b(obj, cancellationExceptionW);
                        throw cancellationExceptionW;
                    }
                }
                return e(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((dw) n.get(this)) == null) {
            p();
        }
        if (zS) {
            u();
        }
        return hp.g;
    }

    public final void o() {
        dw dwVarP = p();
        if (dwVarP == null || (m.get(this) instanceof sx0)) {
            return;
        }
        dwVarP.b();
        n.set(this, qx0.g);
    }

    public final dw p() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        fi0 fi0Var = (fi0) this.k.n(iy.i);
        if (fi0Var == null) {
            return null;
        }
        dw dwVarE = ((xi0) fi0Var).E((2 & 1) == 0, (2 & 2) != 0, new ai(this));
        do {
            atomicReferenceFieldUpdater = n;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, dwVarE)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return dwVarE;
    }

    public final void q(o70 o70Var) throws IllegalAccessException, InvocationTargetException {
        r(o70Var instanceof zg0 ? (zg0) o70Var : new zg0(o70Var));
    }

    public final void r(sx0 sx0Var) throws IllegalAccessException, InvocationTargetException {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof n1) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, sx0Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            if (obj instanceof zg0 ? true : obj instanceof af1) {
                t(sx0Var, obj);
                throw null;
            }
            if (obj instanceof uk) {
                uk ukVar = (uk) obj;
                ukVar.getClass();
                if (!uk.b.compareAndSet(ukVar, 0, 1)) {
                    t(sx0Var, obj);
                    throw null;
                }
                if (obj instanceof kg) {
                    if (((uk) obj) == null) {
                        ukVar = null;
                    }
                    Throwable th = ukVar != null ? ukVar.a : null;
                    if (sx0Var instanceof zg0) {
                        h((zg0) sx0Var, th);
                        return;
                    } else {
                        qg0.i(sx0Var, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        j((af1) sx0Var, th);
                        return;
                    }
                }
                return;
            }
            if (!(obj instanceof sk)) {
                if (sx0Var instanceof af1) {
                    return;
                }
                qg0.i(sx0Var, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                sk skVar = new sk(obj, (zg0) sx0Var, (jz0) null, (CancellationException) null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, skVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            sk skVar2 = (sk) obj;
            if (skVar2.b != null) {
                t(sx0Var, obj);
                throw null;
            }
            if (sx0Var instanceof af1) {
                return;
            }
            qg0.i(sx0Var, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
            zg0 zg0Var = (zg0) sx0Var;
            Throwable th2 = skVar2.e;
            if (th2 != null) {
                h(zg0Var, th2);
                return;
            }
            sk skVarA = sk.a(skVar2, zg0Var, null, 29);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, skVarA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            return;
        }
    }

    @Override // defpackage.eo
    public final void resumeWith(Object obj) {
        Throwable thA = yb1.a(obj);
        if (thA != null) {
            obj = new uk(false, thA);
        }
        v(obj, this.i, null);
    }

    public final boolean s() {
        if (this.i != 2) {
            return false;
        }
        eo eoVar = this.j;
        qg0.i(eoVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return yv.n.get((yv) eoVar) != null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CancellableContinuation(");
        sb.append(os.u(this.j));
        sb.append("){");
        Object obj = m.get(this);
        sb.append(obj instanceof sx0 ? "Active" : obj instanceof kg ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(os.e(this));
        return sb.toString();
    }

    public final void u() {
        eo eoVar = this.j;
        Throwable th = null;
        yv yvVar = eoVar instanceof yv ? (yv) eoVar : null;
        if (yvVar != null) {
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = yv.n;
                Object obj = atomicReferenceFieldUpdater.get(yvVar);
                wg1 wg1Var = np1.b;
                if (obj == wg1Var) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(yvVar, wg1Var, this)) {
                        if (atomicReferenceFieldUpdater.get(yvVar) != wg1Var) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(yvVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(yvVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            l();
            k(th);
        }
    }

    public final void v(Object obj, int i, jz0 jz0Var) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof sx0) {
                Object objW = w((sx0) obj2, obj, i, jz0Var);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objW)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!s()) {
                    l();
                }
                m(i);
                return;
            }
            if (obj2 instanceof kg) {
                kg kgVar = (kg) obj2;
                kgVar.getClass();
                if (kg.c.compareAndSet(kgVar, 0, 1)) {
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }
}
