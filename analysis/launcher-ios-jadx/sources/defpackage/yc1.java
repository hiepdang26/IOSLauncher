package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class yc1 extends AtomicReference implements cw {
    public final /* synthetic */ int g = 1;

    public /* synthetic */ yc1() {
    }

    public boolean a() {
        return get() == null;
    }

    @Override // defpackage.cw
    public final void b() {
        Object andSet;
        switch (this.g) {
            case 0:
                if (get() != null && (andSet = getAndSet(null)) != null) {
                    ((Runnable) andSet).run();
                    break;
                }
                break;
            default:
                ew.a(this);
                break;
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        switch (this.g) {
            case 0:
                return "RunnableDisposable(disposed=" + a() + ", " + get() + ")";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ yc1(Object obj) {
        super(obj);
    }
}
