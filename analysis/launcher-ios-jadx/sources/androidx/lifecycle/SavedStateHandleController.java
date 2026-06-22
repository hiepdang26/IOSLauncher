package androidx.lifecycle;

import defpackage.an0;
import defpackage.en0;
import defpackage.um0;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleController implements an0 {
    public boolean g;

    @Override // defpackage.an0
    public final void a(en0 en0Var, um0 um0Var) {
        if (um0Var == um0.ON_DESTROY) {
            this.g = false;
            en0Var.l().f(this);
        }
    }
}
