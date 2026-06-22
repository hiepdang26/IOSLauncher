package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class go extends za {
    private final yo _context;
    private transient eo intercepted;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public go(eo eoVar) {
        super(eoVar);
        yo context = eoVar != null ? eoVar.getContext() : null;
        this._context = context;
    }

    @Override // defpackage.eo
    public yo getContext() {
        yo yoVar = this._context;
        qg0.h(yoVar);
        return yoVar;
    }

    public final eo intercepted() {
        eo eoVar = this.intercepted;
        if (eoVar != null) {
            return eoVar;
        }
        ho hoVar = (ho) getContext().n(iy.g);
        eo yvVar = hoVar != null ? new yv((cp) hoVar, this) : this;
        this.intercepted = yvVar;
        return yvVar;
    }

    @Override // defpackage.za
    public void releaseIntercepted() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        eo eoVar = this.intercepted;
        if (eoVar != null && eoVar != this) {
            wo woVarN = getContext().n(iy.g);
            qg0.h(woVarN);
            yv yvVar = (yv) eoVar;
            do {
                atomicReferenceFieldUpdater = yv.n;
            } while (atomicReferenceFieldUpdater.get(yvVar) == np1.b);
            Object obj = atomicReferenceFieldUpdater.get(yvVar);
            gg ggVar = obj instanceof gg ? (gg) obj : null;
            if (ggVar != null) {
                ggVar.l();
            }
        }
        this.intercepted = tk.g;
    }
}
