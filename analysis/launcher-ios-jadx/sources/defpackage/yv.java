package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class yv extends zv implements ip, eo {
    public static final AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(yv.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    public final cp j;
    public final go k;
    public Object l;
    public final Object m;

    public yv(cp cpVar, go goVar) {
        super(-1);
        this.j = cpVar;
        this.k = goVar;
        this.l = np1.a;
        Object objH = goVar.getContext().h(0, zo.j);
        qg0.h(objH);
        this.m = objH;
    }

    @Override // defpackage.zv
    public final void b(Object obj, CancellationException cancellationException) {
        if (obj instanceof vk) {
            ((vk) obj).getClass();
            throw null;
        }
    }

    @Override // defpackage.zv
    public final Object g() {
        Object obj = this.l;
        this.l = np1.a;
        return obj;
    }

    @Override // defpackage.ip
    public final ip getCallerFrame() {
        go goVar = this.k;
        if (uo.r(goVar)) {
            return goVar;
        }
        return null;
    }

    @Override // defpackage.eo
    public final yo getContext() {
        return this.k.getContext();
    }

    @Override // defpackage.eo
    public final void resumeWith(Object obj) {
        go goVar = this.k;
        yo context = goVar.getContext();
        Throwable thA = yb1.a(obj);
        Object ukVar = thA == null ? obj : new uk(false, thA);
        cp cpVar = this.j;
        if (cpVar.B()) {
            this.l = ukVar;
            this.i = 0;
            cpVar.z(context, this);
            return;
        }
        v00 v00VarA = on1.a();
        if (v00VarA.i >= 4294967296L) {
            this.l = ukVar;
            this.i = 0;
            v00VarA.D(this);
            return;
        }
        v00VarA.F(true);
        try {
            yo context2 = goVar.getContext();
            Object objA = bf1.A(context2, this.m);
            try {
                goVar.resumeWith(obj);
                while (v00VarA.G()) {
                }
            } finally {
                bf1.t(context2, objA);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.j + ", " + os.u(this.k) + ']';
    }

    @Override // defpackage.zv
    public final eo c() {
        return this;
    }
}
