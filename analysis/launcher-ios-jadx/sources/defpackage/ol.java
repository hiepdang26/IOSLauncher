package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class ol {
    public static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(ol.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(ol.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public ol(af1 af1Var) {
        this._prev = af1Var;
    }

    public final void a() {
        h.lazySet(this, null);
    }

    public final ol b() {
        Object obj = g.get(this);
        if (obj == hs0.a) {
            return null;
        }
        return (ol) obj;
    }

    public abstract boolean c();

    public final void d() {
        ol olVarB;
        if (b() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
            ol olVar = (ol) atomicReferenceFieldUpdater.get(this);
            while (olVar != null && olVar.c()) {
                olVar = (ol) atomicReferenceFieldUpdater.get(olVar);
            }
            ol olVarB2 = b();
            qg0.h(olVarB2);
            while (olVarB2.c() && (olVarB = olVarB2.b()) != null) {
                olVarB2 = olVarB;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(olVarB2);
                ol olVar2 = ((ol) obj) == null ? null : olVar;
                while (!atomicReferenceFieldUpdater.compareAndSet(olVarB2, obj, olVar2)) {
                    if (atomicReferenceFieldUpdater.get(olVarB2) != obj) {
                        break;
                    }
                }
            }
            if (olVar != null) {
                g.set(olVar, olVarB2);
            }
            if (!olVarB2.c() || olVarB2.b() == null) {
                if (olVar == null || !olVar.c()) {
                    return;
                }
            }
        }
    }
}
