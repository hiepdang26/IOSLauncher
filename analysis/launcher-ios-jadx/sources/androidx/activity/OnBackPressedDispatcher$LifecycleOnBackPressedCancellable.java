package androidx.activity;

import defpackage.an0;
import defpackage.b60;
import defpackage.eg;
import defpackage.en0;
import defpackage.oy0;
import defpackage.um0;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements an0, eg {
    public final androidx.lifecycle.a g;
    public final b60 h;
    public oy0 i;
    public final /* synthetic */ b j;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(b bVar, androidx.lifecycle.a aVar, b60 b60Var) {
        this.j = bVar;
        this.g = aVar;
        this.h = b60Var;
        aVar.a(this);
    }

    @Override // defpackage.an0
    public final void a(en0 en0Var, um0 um0Var) {
        if (um0Var == um0.ON_START) {
            b bVar = this.j;
            ArrayDeque arrayDeque = bVar.b;
            b60 b60Var = this.h;
            arrayDeque.add(b60Var);
            oy0 oy0Var = new oy0(bVar, b60Var);
            b60Var.b.add(oy0Var);
            this.i = oy0Var;
            return;
        }
        if (um0Var != um0.ON_STOP) {
            if (um0Var == um0.ON_DESTROY) {
                cancel();
            }
        } else {
            oy0 oy0Var2 = this.i;
            if (oy0Var2 != null) {
                oy0Var2.cancel();
            }
        }
    }

    @Override // defpackage.eg
    public final void cancel() {
        this.g.f(this);
        this.h.b.remove(this);
        oy0 oy0Var = this.i;
        if (oy0Var != null) {
            oy0Var.cancel();
            this.i = null;
        }
    }
}
