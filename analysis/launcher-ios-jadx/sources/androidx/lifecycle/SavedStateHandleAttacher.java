package androidx.lifecycle;

import android.os.Bundle;
import defpackage.an0;
import defpackage.en0;
import defpackage.jd1;
import defpackage.um0;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements an0 {
    public final jd1 g;

    public SavedStateHandleAttacher(jd1 jd1Var) {
        this.g = jd1Var;
    }

    @Override // defpackage.an0
    public final void a(en0 en0Var, um0 um0Var) {
        if (um0Var != um0.ON_CREATE) {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + um0Var).toString());
        }
        en0Var.l().f(this);
        jd1 jd1Var = this.g;
        if (jd1Var.b) {
            return;
        }
        Bundle bundleA = jd1Var.a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = jd1Var.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleA != null) {
            bundle.putAll(bundleA);
        }
        jd1Var.c = bundle;
        jd1Var.b = true;
    }
}
