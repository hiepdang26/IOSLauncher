package defpackage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class vi0 implements cf0 {
    public static final AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(vi0.class, "_isCompleting");
    public static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(vi0.class, Object.class, "_rootCause");
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(vi0.class, Object.class, "_exceptionsHolder");
    private volatile Object _exceptionsHolder;
    private volatile int _isCompleting = 0;
    private volatile Object _rootCause;
    public final px0 g;

    public vi0(px0 px0Var, Throwable th) {
        this.g = px0Var;
        this._rootCause = th;
    }

    @Override // defpackage.cf0
    public final boolean a() {
        return c() == null;
    }

    public final void b(Throwable th) {
        Throwable thC = c();
        if (thC == null) {
            i.set(this, th);
            return;
        }
        if (th == thC) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        atomicReferenceFieldUpdater.set(this, arrayList);
    }

    public final Throwable c() {
        return (Throwable) i.get(this);
    }

    public final boolean d() {
        return c() != null;
    }

    public final boolean e() {
        return h.get(this) != 0;
    }

    @Override // defpackage.cf0
    public final px0 f() {
        return this.g;
    }

    public final ArrayList g(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            arrayList = (ArrayList) obj;
        }
        Throwable thC = c();
        if (thC != null) {
            arrayList.add(0, thC);
        }
        if (th != null && !th.equals(thC)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, hg0.h);
        return arrayList;
    }

    public final String toString() {
        return "Finishing[cancelling=" + d() + ", completing=" + e() + ", rootCause=" + c() + ", exceptions=" + j.get(this) + ", list=" + this.g + ']';
    }
}
